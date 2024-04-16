package app.ViewModel.Commands;

import app.ViewModel.AdministratorViewModel;
import app.ViewModel.service.implementation.UserService;
import app.model.*;

public class CommandUserTableSelected implements ICommand {
    private AdministratorViewModel administratorViewModel;
    private UserService userService;

    public CommandUserTableSelected() {
    }

    public CommandUserTableSelected(AdministratorViewModel administratorViewModel) {
        this.administratorViewModel = administratorViewModel;
    }

    @Override
    public void execute(Referee referee) {
        int selectedRow = administratorViewModel.getRow();
        if (selectedRow >= 0) {
            String username = (String) administratorViewModel.getTable().getValueAt(selectedRow, 0);
            String password = (String) administratorViewModel.getTable().getValueAt(selectedRow, 1);
            String role = (String) administratorViewModel.getTable().getValueAt(selectedRow, 2);
            administratorViewModel.setUserName(username);
            administratorViewModel.setPassword(password);

            // Set the appropriate radio button based on role
            switch (role) {
                case "REFEREE":
                    administratorViewModel.setAdministratorRadioButton(true);
                    break;
                case "TOURNAMENT_ORGANIZER":
                    administratorViewModel.setTournament_OrganizerRadioButton(true);
                    break;
                case "ADMINISTRATOR":
                    administratorViewModel.setAdministratorRadioButton(true);
                    break;
            }
        }
    }
}


