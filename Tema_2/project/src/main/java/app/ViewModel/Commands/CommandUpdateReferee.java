package app.ViewModel.Commands;

import app.ViewModel.RefereeCRUDViewModel;
import app.model.Referee;
import app.ViewModel.service.RefereeServiceInterface;
import app.ViewModel.single_point_access.GUIFrameSinglePointAccess;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;

public class CommandUpdateReferee implements ICommand {
    private RefereeCRUDViewModel refereeCRUDViewModel;
    private RefereeServiceInterface refereeService = ServiceSinglePointAccess.getRefereeService();

    public CommandUpdateReferee() {
    }

    public CommandUpdateReferee (RefereeCRUDViewModel refereeCRUDViewModel) {
        this.refereeCRUDViewModel = refereeCRUDViewModel;
    }

    @Override
    public void execute(Referee referee) {
        String id1 = refereeCRUDViewModel.getIdTextField();
        if(id1 == null){
            GUIFrameSinglePointAccess.showDialogMessage("Select a referee");
        }
        else{
            Referee foundReferee = refereeService.findById(Integer.parseInt(id1));
            if(foundReferee == null)
            {
                GUIFrameSinglePointAccess.showDialogMessage("Not such referee");
                return;
            }

            String firstName = refereeCRUDViewModel.getFirstNameTextField();
            String plastName = refereeCRUDViewModel.getLastNameTextField();
            Integer id = Integer.parseInt(refereeCRUDViewModel.getIdTextField());

            if(firstName == null){
                GUIFrameSinglePointAccess.showDialogMessage("Complete first name field");
            }
            else if(plastName == null){
                GUIFrameSinglePointAccess.showDialogMessage("Complete last name field");
            }
            else if(id == null) {
                GUIFrameSinglePointAccess.showDialogMessage("Complete id field");
            }
            Referee referee2 = refereeService.findById(id);

            if(referee2 == null || referee2.getId() == foundReferee.getId()) {
                foundReferee.setFirstName(firstName);
                foundReferee.setLastName(plastName);
                foundReferee.setId(id);
                refereeService.update(foundReferee);
                GUIFrameSinglePointAccess.showDialogMessage("Succesfully updated");
            }
            else {
                GUIFrameSinglePointAccess.showDialogMessage("Already existing referee");
            }
        }
    }
}
