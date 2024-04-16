package app.ViewModel.Commands;

import app.ViewModel.AdministratorViewModel;
import app.model.User;
import app.ViewModel.service.UserServiceInterface;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import app.model.*;
public class CommandCreateUserTable implements ICommand{
    private AdministratorViewModel administratorViewModel;
    private UserServiceInterface userService = ServiceSinglePointAccess.getUserService();

    public CommandCreateUserTable() {
    }

    public CommandCreateUserTable(AdministratorViewModel administratorViewModel) {
        this.administratorViewModel = administratorViewModel;
    }

    @Override
    public void execute(Referee referee) {
        Object[][] usersTable1 = new Object[200][5];
        String[] cols = {"Username", "Password", "Role"};
        List<User> users = userService.findAll();
        if(users!= null){
            for(int i = 0; i < users.size(); i++){
                usersTable1[i][0] = users.get(i).getUserName();
                usersTable1[i][1] = users.get(i).getPassword();
                usersTable1[i][2] = users.get(i).getRole().toString();
            }
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(usersTable1, cols);
        administratorViewModel.setModel(defaultTableModel);
        administratorViewModel.getTable();
        /*
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
                case "ADMINISTRATOR": administratorViewModel.setAdministratorRadioButton(true);
                    break;
            }
        }

         */
    }

}
