package app.ViewModel.Commands;

import app.ViewModel.RefereeCRUDViewModel;
import app.model.Referee;
import app.ViewModel.service.RefereeServiceInterface;
import app.ViewModel.single_point_access.GUIFrameSinglePointAccess;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;

public class CommandAddReferee implements ICommand {
    private RefereeCRUDViewModel refereeCRUDViewModel;
    private RefereeServiceInterface refereeService = ServiceSinglePointAccess.getRefereeService();

    public CommandAddReferee() {
    }

    public CommandAddReferee (RefereeCRUDViewModel refereeCRUDViewModel) {
        this.refereeCRUDViewModel = refereeCRUDViewModel;
    }

    @Override
    public void execute(Referee referee) {
        String firstName = refereeCRUDViewModel.getFirstNameTextField();
        String lastName = refereeCRUDViewModel.getLastNameTextField();
        if(firstName.isEmpty()){
            GUIFrameSinglePointAccess.showDialogMessage("First Name required");
        }
        else if(lastName.isEmpty()){
            GUIFrameSinglePointAccess.showDialogMessage("Last Name required");
        }
        else
        {
            Referee referee2 = new Referee(firstName, lastName);
            Referee referee1 = refereeService.save(referee2);
            if (referee1 != null) {
                GUIFrameSinglePointAccess.showDialogMessage("Succesfully registered");
            }
            else {
                GUIFrameSinglePointAccess.showDialogMessage("Invalid registration");
            }
        }
    }
}
