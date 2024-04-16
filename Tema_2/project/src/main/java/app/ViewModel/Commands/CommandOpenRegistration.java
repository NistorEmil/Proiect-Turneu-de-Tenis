package app.ViewModel.Commands;

import app.ViewModel.LoginViewModel;
import app.view.RegisterView;
import app.model.*;
public class CommandOpenRegistration implements ICommand {
    private LoginViewModel loginViewModel;

    public CommandOpenRegistration() {
    }

    public CommandOpenRegistration(LoginViewModel loginViewModel) {
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void execute(Referee referee) {
        new RegisterView();
    }
}
