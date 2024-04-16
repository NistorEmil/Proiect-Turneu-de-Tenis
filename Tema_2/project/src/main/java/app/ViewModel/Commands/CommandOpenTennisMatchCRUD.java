package app.ViewModel.Commands;

import app.ViewModel.TournamentOrganizerViewModel;
import app.view.TournamentOrganizerView.TennisMatchCRUDView;
import app.model.*;
public class CommandOpenTennisMatchCRUD implements ICommand {
    private TournamentOrganizerViewModel tournamentOrganizerViewModel;

    public CommandOpenTennisMatchCRUD() {
    }

    public CommandOpenTennisMatchCRUD(TournamentOrganizerViewModel tournamentOrganizerViewModel) {
        this.tournamentOrganizerViewModel = tournamentOrganizerViewModel;
    }

    @Override
    public void execute(Referee referee) {
        new TennisMatchCRUDView();
    }
}
