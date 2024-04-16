package app.ViewModel.Commands;

import app.ViewModel.AdministratorViewModel;
import app.model.Referee;
import app.model.User;
import app.model.UserType;
import app.ViewModel.service.RefereeServiceInterface;
import app.ViewModel.service.UserServiceInterface;
import app.ViewModel.single_point_access.GUIFrameSinglePointAccess;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;

public class CommandDeleteUser implements ICommand {
    private AdministratorViewModel administratorViewModel;
    private UserServiceInterface userService = ServiceSinglePointAccess.getUserService();
    private RefereeServiceInterface refereeService = ServiceSinglePointAccess.getRefereeService();
    public CommandDeleteUser() {
    }

    public CommandDeleteUser (AdministratorViewModel administratorViewModel) {
        this.administratorViewModel = administratorViewModel;
    }

    @Override
    public void execute(Referee referee) {
        String username = administratorViewModel.getUsername();
        String password = administratorViewModel.getPassword();
        UserType role = administratorViewModel.getRole();

        if(username == null){
            GUIFrameSinglePointAccess.showDialogMessage("Complete username field");
            return;
        }
        else if(password == null){
            GUIFrameSinglePointAccess.showDialogMessage("Complete password field");
            return;
        }
        else if(role == null) {
            GUIFrameSinglePointAccess.showDialogMessage("Complete role field");
            return;
        }
        else{
            String username1 = administratorViewModel.getUsername();
            if(username1 == null){
                GUIFrameSinglePointAccess.showDialogMessage("Error deleting user");
                return;
            }
            else {
                User user = userService.findByUsername(username);
                if(user == null)
                {
                    GUIFrameSinglePointAccess.showDialogMessage("No such user");
                    return;
                }
                if(user.getAssociatedPerson() != null)
                {
                    Integer id = user.getAssociatedPerson().getId();
                    Referee referee2 = refereeService.findById(id);;
                    refereeService.delete(referee2);
                    userService.delete(user);
                }
                else
                {
                    userService.delete(user);
                }
                GUIFrameSinglePointAccess.showDialogMessage("Succesfully deleted");
            }
        }
    }
}
