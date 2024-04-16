package app.ViewModel.Commands;

import app.ViewModel.TournamentOrganizerViewModel;
import app.view.TournamentOrganizerView.TennisPlayerCRUDView;
import app.model.*;
public class CommandOpenTennisPlayerCRUD implements ICommand {
    private TournamentOrganizerViewModel tournamentOrganizerViewModel;

    public CommandOpenTennisPlayerCRUD() {
    }

    public CommandOpenTennisPlayerCRUD(TournamentOrganizerViewModel tournamentOrganizerViewModel) {
        this.tournamentOrganizerViewModel = tournamentOrganizerViewModel;
    }

    @Override
    public void execute(Referee referee) {
        new TennisPlayerCRUDView();
    }
}
