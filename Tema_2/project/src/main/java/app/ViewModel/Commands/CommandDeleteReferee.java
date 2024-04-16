package app.ViewModel.Commands;

import app.ViewModel.RefereeCRUDViewModel;
import app.model.Referee;
import app.model.TennisMatch;
import app.model.User;
import app.ViewModel.service.RefereeServiceInterface;
import app.ViewModel.service.TennisMatchServiceInterface;
import app.ViewModel.service.UserRefereeServiceInterface;
import app.ViewModel.service.UserServiceInterface;
import app.ViewModel.single_point_access.GUIFrameSinglePointAccess;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;

import java.util.List;

public class CommandDeleteReferee implements ICommand {
    private RefereeCRUDViewModel refereeCRUDViewModel;
    private RefereeServiceInterface refereeService = ServiceSinglePointAccess.getRefereeService();
    private UserRefereeServiceInterface userRefereeService = ServiceSinglePointAccess.getUserRefereeService();
    private TennisMatchServiceInterface tennisMatchService = ServiceSinglePointAccess.getTennisMatchService();
    private UserServiceInterface userService = ServiceSinglePointAccess.getUserService();

    public CommandDeleteReferee() {
    }

    public CommandDeleteReferee (RefereeCRUDViewModel refereeCRUDViewModel) {
        this.refereeCRUDViewModel = refereeCRUDViewModel;
    }

    @Override
    public void execute(Referee referee) {
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
        else{
            String id1 = refereeCRUDViewModel.getIdTextField();
            if(id1 == null){
                GUIFrameSinglePointAccess.showDialogMessage("Error deleting referee");
            }
            else {
                Referee referee2 = refereeService.findById(id);
                User user = userRefereeService.getUserByPerson(referee2);
                List<TennisMatch> tennisMatches =  tennisMatchService.findAllByRefereeId(referee2.getId());
                tennisMatchService.changeReferees(tennisMatches);
                refereeService.delete(referee2);
                if(user != null) {
                    user.setAssociatedPerson(null);
                    userService.update(user);
                }
                GUIFrameSinglePointAccess.showDialogMessage("Succesfully deleted");
            }
        }
    }
}
