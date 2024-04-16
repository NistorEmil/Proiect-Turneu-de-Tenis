package app.ViewModel.Commands;

import app.ViewModel.AdministratorViewModel;
import app.model.Referee;
import app.model.User;
import app.model.*;
import app.ViewModel.service.UserRefereeServiceInterface;
import app.ViewModel.service.UserServiceInterface;
import app.ViewModel.single_point_access.GUIFrameSinglePointAccess;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;

public class CommandAddUser implements ICommand {
    private AdministratorViewModel administratorViewModel;
    private UserServiceInterface userService = ServiceSinglePointAccess.getUserService();
    private UserRefereeServiceInterface userRefereeService = ServiceSinglePointAccess.getUserRefereeService();
    public CommandAddUser() {
    }

    public CommandAddUser (AdministratorViewModel administratorViewModel) {
        this.administratorViewModel = administratorViewModel;
    }

    @Override
    public void execute(Referee referee) {
        String username = administratorViewModel.getUsername();
        String password = administratorViewModel.getPassword();
        UserType role = administratorViewModel.getRole();
        String firstName = administratorViewModel.getFirstName();
        String lastName = administratorViewModel.getLastName();

        if(username.isEmpty()){
            GUIFrameSinglePointAccess.showDialogMessage("Complete username field");
            return;
        }
        if(password.isEmpty()){
            GUIFrameSinglePointAccess.showDialogMessage("Complete password field");
            return;
        }
        else if(role == null){
            GUIFrameSinglePointAccess.showDialogMessage("Complete role field");
            return;
        }
        else if(firstName.isEmpty()){
            GUIFrameSinglePointAccess.showDialogMessage("Complete first name field");
            return;
        }
        else if(lastName.isEmpty()){
            GUIFrameSinglePointAccess.showDialogMessage("Complete last name field");
            return;
        }
        else{
            User user = userService.findByUsername(username);

            if(user == null) {
                User user1 = new User(username, password, role);
                User user2 = userService.save(user1);
                if (user2 != null) {
                    if(role == UserType.REFEREE) {
                        Referee referee1 = new Referee(firstName, lastName);
                        userRefereeService.associateUserWithReferee(user1, referee1);
                    }
                    GUIFrameSinglePointAccess.showDialogMessage("Succesfully added");
                }
            }
            else {
                GUIFrameSinglePointAccess.showDialogMessage("Already existing username");
            }
        }
    }
}
