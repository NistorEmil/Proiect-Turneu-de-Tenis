package app.ViewModel.Commands;

import app.ViewModel.TennisPlayerCRUDViewModel;
import app.model.Referee;
import app.model.TennisPlayer;
import app.ViewModel.service.TennisMatchServiceInterface;
import app.ViewModel.service.TennisPlayerServiceInterface;
import app.ViewModel.single_point_access.GUIFrameSinglePointAccess;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class CommandFilterTennisPlayersByAge implements ICommand{
    private TennisPlayerCRUDViewModel tennisPlayerCRUDViewModel;
    private TennisPlayerServiceInterface tennisPlayerService = ServiceSinglePointAccess.getTennisPlayerService();
    private TennisMatchServiceInterface tennisMatchService = ServiceSinglePointAccess.getTennisMatchService();

    public CommandFilterTennisPlayersByAge() {
    }

    public CommandFilterTennisPlayersByAge(TennisPlayerCRUDViewModel tennisPlayerCRUDViewModel) {
        this.tennisPlayerCRUDViewModel = tennisPlayerCRUDViewModel;
    }


    @Override
    public void execute(Referee referee) {
        List<TennisPlayer> tennisPlayers = tennisPlayerService.findAll();
        List<TennisPlayer> filteredTennisPlayers = new ArrayList<>();
        if(tennisPlayerCRUDViewModel.getAgeTextField().isEmpty())
        {
            GUIFrameSinglePointAccess.showDialogMessage("Enter the age");
            return;
        }
        Integer age = Integer.parseInt(tennisPlayerCRUDViewModel.getAgeTextField());
        for(TennisPlayer tennisPlayer: tennisPlayers)
        {
            if(tennisPlayer.getAge() <= age)
            {
                filteredTennisPlayers.add(tennisPlayer);
            }
        }
        Object[][] tennisPlayersTable1 = new Object[200][5];
        if (filteredTennisPlayers != null) {
            for (int i = 0; i < filteredTennisPlayers.size(); i++) {
                tennisPlayersTable1[i][0] = filteredTennisPlayers.get(i).getId();
                tennisPlayersTable1[i][1] = filteredTennisPlayers.get(i).getFirstName();
                tennisPlayersTable1[i][2] = filteredTennisPlayers.get(i).getLastName();
                tennisPlayersTable1[i][3] = filteredTennisPlayers.get(i).getAge();
                tennisPlayersTable1[i][4] = filteredTennisPlayers.get(i).getCategory();
            }
        }
        String[] cols = {"Id", "First Name", "Last Name", "Age", "Category"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(tennisPlayersTable1, cols);
        tennisPlayerCRUDViewModel.setModel(defaultTableModel);
    }
}
