package app.ViewModel.Commands;

import app.ViewModel.LoginViewModel;
import app.ViewModel.TennisMatchesScoreViewModel;
import app.model.Referee;
import app.view.RegisterView;
import app.view.TennisMatchesScoreView;

public class CommandOpenScoreTable implements ICommand {
    private LoginViewModel loginViewModel;

    public CommandOpenScoreTable() {
    }

    public CommandOpenScoreTable(LoginViewModel loginViewModel) {
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void execute(Referee referee) {
        new TennisMatchesScoreView();
    }
}
