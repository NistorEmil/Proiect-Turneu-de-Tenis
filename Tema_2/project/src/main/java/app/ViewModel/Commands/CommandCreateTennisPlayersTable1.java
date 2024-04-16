package app.ViewModel.Commands;

import app.ViewModel.TennisMatchCRUDViewModel;
import app.model.TennisPlayer;
import app.ViewModel.service.TennisPlayerServiceInterface;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import app.model.*;
public class CommandCreateTennisPlayersTable1 implements ICommand {
    private TennisMatchCRUDViewModel tennisMatchCRUDViewModel;
    private TennisPlayerServiceInterface tennisPlayerService = ServiceSinglePointAccess.getTennisPlayerService();

    public CommandCreateTennisPlayersTable1() {
    }

    public CommandCreateTennisPlayersTable1(TennisMatchCRUDViewModel tennisMatchCRUDViewModel) {
        this.tennisMatchCRUDViewModel =  tennisMatchCRUDViewModel;
    }

    @Override
    public void execute(Referee referee) {
        List<TennisPlayer> tennisPlayers = tennisPlayerService.findAll();
        Object[][] tennisPlayersTable1 = new Object[200][5];
        if (tennisPlayers != null) {
            for (int i = 0; i < tennisPlayers.size(); i++) {
                tennisPlayersTable1[i][0] = tennisPlayers.get(i).getId();
                tennisPlayersTable1[i][1] = tennisPlayers.get(i).getFirstName();
                tennisPlayersTable1[i][2] = tennisPlayers.get(i).getLastName();
                tennisPlayersTable1[i][3] = tennisPlayers.get(i).getAge();
                tennisPlayersTable1[i][4] = tennisPlayers.get(i).getCategory();
            }
        }
        String[] cols = {"Id", "First Name", "Last Name", "Age", "Category"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(tennisPlayersTable1, cols);
        tennisMatchCRUDViewModel.setModelTennisPlayer1(defaultTableModel);
    }

}
