package app.ViewModel.Commands;

import app.ViewModel.GenerateProgramViewModel;
import app.model.TennisPlayer;
import app.model.*;
import app.ViewModel.service.RefereeServiceInterface;
import app.ViewModel.service.TennisPlayerServiceInterface;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommandLast16TableSelected implements ICommand {
    private GenerateProgramViewModel generateProgramViewModel;
    private TennisPlayerServiceInterface tennisPlayerService = ServiceSinglePointAccess.getTennisPlayerService();
    private RefereeServiceInterface refereeService = ServiceSinglePointAccess.getRefereeService();

    public CommandLast16TableSelected() {
    }

    public CommandLast16TableSelected(GenerateProgramViewModel generateProgramViewModel) {
        this.generateProgramViewModel = generateProgramViewModel;
    }

    @Override
    public void execute(Referee referee) {

        List<TennisPlayer> selectedPlayers = new ArrayList<>();
        int selectedRow = generateProgramViewModel.getRowLast16Table();

        // Verificăm dacă un rând este selectat
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) generateProgramViewModel.getLast16Table();

            int playerId;
            // Obținem coloana selectata
            Random random = new Random();

            // Generăm un număr aleatoriu între 1 și 2 inclusiv
            int randomNumber = random.nextInt(2) + 1;
            int selectedColumn = randomNumber;

            playerId = (int) model.getValueAt(selectedRow, selectedColumn);
            selectedPlayers.add(tennisPlayerService.findById(playerId));
            switch (selectedRow) {
                case 0:
                    generateProgramViewModel.setPlayer1TextField(String.valueOf(playerId));
                    break;
                case 1:
                    generateProgramViewModel.setPlayer2TextField(String.valueOf(playerId));
                    break;
                case 2:
                    generateProgramViewModel.setPlayer3TextField(String.valueOf(playerId));
                    break;
                case 3:
                    generateProgramViewModel.setPlayer4TextField(String.valueOf(playerId));
                    break;
                case 4:
                    generateProgramViewModel.setPlayer5TextField(String.valueOf(playerId));
                    break;
                case 5:
                    generateProgramViewModel.setPlayer6TextField(String.valueOf(playerId));
                    break;
                case 6:
                    generateProgramViewModel.setPlayer7TextField(String.valueOf(playerId));
                    break;
                case 7:
                    generateProgramViewModel.setPlayer8TextField(String.valueOf(playerId));
                    break;
            }
        }
    }
}
