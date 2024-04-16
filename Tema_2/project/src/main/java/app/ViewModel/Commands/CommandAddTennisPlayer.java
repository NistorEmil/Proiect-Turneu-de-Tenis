package app.ViewModel.Commands;

import app.ViewModel.TennisPlayerCRUDViewModel;
import app.model.TennisMatch;
import app.model.TennisPlayer;
import app.ViewModel.service.TennisPlayerServiceInterface;
import app.ViewModel.single_point_access.GUIFrameSinglePointAccess;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;

import java.util.ArrayList;
import java.util.List;
import app.model.*;
public class CommandAddTennisPlayer implements ICommand{
    private TennisPlayerCRUDViewModel tennisPlayerCRUDViewModel;
    private TennisPlayerServiceInterface tennisPlayerService = ServiceSinglePointAccess.getTennisPlayerService();

    public CommandAddTennisPlayer() {
    }

    public CommandAddTennisPlayer(TennisPlayerCRUDViewModel tennisPlayerCRUDViewModel) {
        this.tennisPlayerCRUDViewModel = tennisPlayerCRUDViewModel;
    }


    @Override
    public void execute(Referee referee) {
        String firstName = tennisPlayerCRUDViewModel.getFirstNameTextField();
        String lastName = tennisPlayerCRUDViewModel.getLastNameTextField();
        String age = tennisPlayerCRUDViewModel.getAgeTextField();
        String categoryType = tennisPlayerCRUDViewModel.getCategory();
        List<TennisMatch> tennisMatchList = new ArrayList<>();
        if(firstName.isEmpty()){
            GUIFrameSinglePointAccess.showDialogMessage("First Name required");
            return;
        }
        else if(lastName.isEmpty()){
            GUIFrameSinglePointAccess.showDialogMessage("Last Name required");
            return;
        }
        else if(age == null){
            GUIFrameSinglePointAccess.showDialogMessage("Age required");
            return;
        }
        else if(categoryType == null){
            GUIFrameSinglePointAccess.showDialogMessage("Category required");
            return;
        }
        else
        {
            TennisPlayer tennisPlayer = new TennisPlayer(firstName, lastName, Integer.parseInt(age), categoryType, tennisMatchList);
            TennisPlayer tennisPlayer1 = tennisPlayerService.save(tennisPlayer);
            if (tennisPlayer1 != null) {
                GUIFrameSinglePointAccess.showDialogMessage("Succesfully registered");
                return;
            }
            else {
                GUIFrameSinglePointAccess.showDialogMessage("Invalid registration");
                return;
            }
        }
    }
}
