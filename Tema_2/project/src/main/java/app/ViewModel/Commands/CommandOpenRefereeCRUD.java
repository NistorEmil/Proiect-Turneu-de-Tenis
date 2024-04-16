package app.ViewModel.Commands;

import app.ViewModel.TournamentOrganizerViewModel;
import app.view.TournamentOrganizerView.RefereeCRUDView;
import app.model.*;
public class CommandOpenRefereeCRUD implements ICommand {
    private TournamentOrganizerViewModel tournamentOrganizerViewModel;

    public CommandOpenRefereeCRUD() {
    }

    public CommandOpenRefereeCRUD(TournamentOrganizerViewModel tournamentOrganizerViewModel) {
        this.tournamentOrganizerViewModel = tournamentOrganizerViewModel;
    }

    @Override
    public void execute(Referee referee) {
        new RefereeCRUDView();
    }
}
