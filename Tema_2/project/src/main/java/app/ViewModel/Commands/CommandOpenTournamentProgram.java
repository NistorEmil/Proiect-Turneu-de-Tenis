package app.ViewModel.Commands;

import app.ViewModel.LoginViewModel;
import app.view.TournamentProgramView;
import app.model.*;
public class CommandOpenTournamentProgram implements ICommand {
    private LoginViewModel loginViewModel;

    public CommandOpenTournamentProgram() {
    }

    public CommandOpenTournamentProgram(LoginViewModel loginViewModel) {
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void execute(Referee referee) {
        new TournamentProgramView();
    }
}
