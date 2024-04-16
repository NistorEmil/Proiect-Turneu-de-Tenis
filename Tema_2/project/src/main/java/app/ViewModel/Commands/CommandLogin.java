package app.ViewModel.Commands;

import app.model.Referee;
import app.model.User;
import app.model.UserType;
import app.ViewModel.service.RefereeServiceInterface;
import app.ViewModel.service.UserServiceInterface;
import app.ViewModel.single_point_access.GUIFrameSinglePointAccess;
import app.ViewModel.LoginViewModel;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;
import app.view.AdministratorView;
import app.view.RefereeView;
import app.view.TournamentOrganizerView.TournamentOrganizerView;

public class CommandLogin implements ICommand {
    UserServiceInterface userService = ServiceSinglePointAccess.getUserService();
    RefereeServiceInterface refereeService = ServiceSinglePointAccess.getRefereeService();
    private LoginViewModel loginViewModel;

    public CommandLogin() {
    }

    public CommandLogin(LoginViewModel loginViewModel) {
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void execute(Referee referee){
        String userName = loginViewModel.getUserField();
        String password = loginViewModel.getPassField();
        User user = userService.findByUsername(userName);
        if(userName.isEmpty()){
            GUIFrameSinglePointAccess.showDialogMessage("UserName required");
        }
        else if(password.isEmpty()){
            GUIFrameSinglePointAccess.showDialogMessage("Password required");
        }
        else{
            User user1 = userService.login(userName, password);
            if (user1 != null) {
                GUIFrameSinglePointAccess.showDialogMessage("Succesfully login");
                UserType role = user1.getRole();
                if(role.equals(UserType.REFEREE))
                {
                    Integer id = user1.getId();
                    Referee referee2 = refereeService.findById(id);
                    new RefereeView(referee2);
                }
                else if(role.equals(UserType.ADMINISTRATOR))
                {
                    new AdministratorView();
                }
                else if(role.equals(UserType.TOURNAMENT_ORGANIZER))
                {
                    new TournamentOrganizerView();
                }
            }
            else {
                GUIFrameSinglePointAccess.showDialogMessage("Invalid username or password");
            }
        }
    }
}
