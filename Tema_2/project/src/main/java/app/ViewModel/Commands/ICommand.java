package app.ViewModel.Commands;

import app.model.Referee;

public interface ICommand {
    public void execute(Referee referee);
}
