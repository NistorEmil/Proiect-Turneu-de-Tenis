package app.ViewModel.Commands;

import app.ViewModel.TennisPlayerCRUDViewModel;
import app.model.TennisPlayer;
import app.ViewModel.service.TennisPlayerServiceInterface;
import app.ViewModel.single_point_access.GUIFrameSinglePointAccess;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;
import app.model.*;
public class CommandUpdateTennisPlayer implements ICommand{
    private TennisPlayerCRUDViewModel tennisPlayerCRUDViewModel;
    private TennisPlayerServiceInterface tennisPlayerService = ServiceSinglePointAccess.getTennisPlayerService();

    public CommandUpdateTennisPlayer() {
    }

    public CommandUpdateTennisPlayer(TennisPlayerCRUDViewModel tennisPlayerCRUDViewModel) {
        this.tennisPlayerCRUDViewModel = tennisPlayerCRUDViewModel;
    }


    @Override
    public void execute(Referee referee) {
        String id = tennisPlayerCRUDViewModel.getIdTextField();
        if(id.isEmpty()){
            GUIFrameSinglePointAccess.showDialogMessage("Select a Tennis Player");
            return;
        }
        else{
            TennisPlayer foundtennisPlayer = tennisPlayerService.findById(Integer.parseInt(id));
            if(foundtennisPlayer == null)
            {
                GUIFrameSinglePointAccess.showDialogMessage("Not such Tennis Player");
                return;
            }

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

            TennisPlayer tennisPlayer = tennisPlayerService.findById(Integer.parseInt(id));

            if(tennisPlayer == null || tennisPlayer.getId() == foundtennisPlayer.getId()) {
                foundtennisPlayer.setFirstName(firstName);
                foundtennisPlayer.setLastName(lastName);
                foundtennisPlayer.setAge(Integer.valueOf(age));
                foundtennisPlayer.setCategory(category.toString());
                tennisPlayerService.update(foundtennisPlayer);
                GUIFrameSinglePointAccess.showDialogMessage("Succesfully updated");
                return;
            }
            else {
                GUIFrameSinglePointAccess.showDialogMessage("Already existing id");
                return;
            }
        }
    }
}
