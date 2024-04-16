package app.ViewModel.Commands;

import app.ViewModel.AdministratorViewModel;
import app.model.User;
import app.model.UserType;
import app.ViewModel.service.UserRefereeServiceInterface;
import app.ViewModel.service.UserServiceInterface;
import app.ViewModel.single_point_access.GUIFrameSinglePointAccess;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;
import app.model.*;
public class CommandUpdateUser implements ICommand {
    private AdministratorViewModel administratorViewModel;
    private UserServiceInterface userService = ServiceSinglePointAccess.getUserService();
    private UserRefereeServiceInterface userRefereeService = ServiceSinglePointAccess.getUserRefereeService();
    public CommandUpdateUser() {
    }

    public CommandUpdateUser (AdministratorViewModel administratorViewModel) {
        this.administratorViewModel = administratorViewModel;
    }

    @Override
    public void execute(Referee referee) {
        String username1 = administratorViewModel.getUsername();
        if(username1 == null){
            GUIFrameSinglePointAccess.showDialogMessage("Select an user");
        }
        else{
            User foundUser = userService.findByUsername(username1);

            String username = administratorViewModel.getUsername();
            String password = administratorViewModel.getPassword();
            UserType role = administratorViewModel.getRole();
            System.out.println("Daaaaaa");
            System.out.println(role.toString());

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
            User user = userService.findByUsername(username);
            if(user == null)
            {
                GUIFrameSinglePointAccess.showDialogMessage("No such user");
                return;
            }
            if(user == null || user.getId() == foundUser.getId()) {
                foundUser.setUserName(username);
                foundUser.setPassword(password);
                foundUser.setRole(role);
                userService.update(foundUser);
                GUIFrameSinglePointAccess.showDialogMessage("Succesfully updated");
            }
            else {
                GUIFrameSinglePointAccess.showDialogMessage("Already existing username");
            }
        }
    }
}
