package app.ViewModel.Commands;

import app.ViewModel.TennisPlayerCRUDViewModel;
import app.model.TennisMatch;
import app.model.TennisPlayer;
import app.ViewModel.service.TennisMatchServiceInterface;
import app.ViewModel.service.TennisPlayerServiceInterface;
import app.ViewModel.single_point_access.GUIFrameSinglePointAccess;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;

import java.util.List;
import app.model.*;
public class CommandDeleteTennisPlayer implements ICommand{
    private TennisPlayerCRUDViewModel tennisPlayerCRUDViewModel;
    private TennisPlayerServiceInterface tennisPlayerService = ServiceSinglePointAccess.getTennisPlayerService();
    private TennisMatchServiceInterface tennisMatchService = ServiceSinglePointAccess.getTennisMatchService();

    public CommandDeleteTennisPlayer() {
    }

    public CommandDeleteTennisPlayer (TennisPlayerCRUDViewModel tennisPlayerCRUDViewModel) {
        this.tennisPlayerCRUDViewModel = tennisPlayerCRUDViewModel;
    }


    @Override
    public void execute(Referee referee) {
        String firstName = tennisPlayerCRUDViewModel.getFirstNameTextField();
        String lastName = tennisPlayerCRUDViewModel.getLastNameTextField();
        String age = tennisPlayerCRUDViewModel.getAgeTextField();
        String category = tennisPlayerCRUDViewModel.getCategory();

        if(firstName.isEmpty()){
            GUIFrameSinglePointAccess.showDialogMessage("Complete first name field");
            return;
        }
        else if(lastName.isEmpty()){
            GUIFrameSinglePointAccess.showDialogMessage("Complete last name field");
            return;
        }
        else if(age == null) {
            GUIFrameSinglePointAccess.showDialogMessage("Complete age field");
            return;
        }
        else if(category == null) {
            GUIFrameSinglePointAccess.showDialogMessage("Choose category");
            return;
        }
        else{
            String id = tennisPlayerCRUDViewModel.getIdTextField();
            if(id == null){
                GUIFrameSinglePointAccess.showDialogMessage("Error deleting user");
                return;
            }
            else {
                TennisPlayer tennisPlayer = tennisPlayerService.findById(Integer.parseInt(id));
                List<TennisMatch> tennisMatches =  tennisMatchService.findAllByTennisPlayerId(tennisPlayer.getId());
                if(tennisMatches.size() > 0)
                {
                    for(TennisMatch tennisMatch: tennisMatches)
                    {
                        tennisMatchService.delete(tennisMatch);
                    }
                }
                tennisPlayerService.delete(tennisPlayer);
                GUIFrameSinglePointAccess.showDialogMessage("Succesfully deleted");
                return;
            }
        }
    }
}
