package app.ViewModel.Commands;

import app.ViewModel.GenerateProgramViewModel;
import app.ViewModel.service.RefereeServiceInterface;
import app.ViewModel.service.TennisPlayerServiceInterface;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;

import javax.swing.table.DefaultTableModel;
import java.util.Random;
import app.model.*;
public class CommandLast8TableSelected implements ICommand {
    private GenerateProgramViewModel generateProgramViewModel;
    private TennisPlayerServiceInterface tennisPlayerService = ServiceSinglePointAccess.getTennisPlayerService();
    private RefereeServiceInterface refereeService = ServiceSinglePointAccess.getRefereeService();

    public CommandLast8TableSelected() {
    }

    public CommandLast8TableSelected(GenerateProgramViewModel generateProgramViewModel) {
        this.generateProgramViewModel = generateProgramViewModel;
    }

    @Override
    public void execute(Referee referee) {
        int selectedRow = generateProgramViewModel.getRowLast8Table();

        // Verificăm dacă un rând este selectat
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) generateProgramViewModel.getLast8Table();

            int playerId;
            // Obținem coloana selectata
            Random random = new Random();

            // Generăm un număr aleatoriu între 1 și 2 inclusiv
            int randomNumber = random.nextInt(2) + 1;
            int selectedColumn = randomNumber;

            playerId = (int) model.getValueAt(selectedRow, selectedColumn);
            switch (selectedRow) {
                case 0:
                    generateProgramViewModel.setLast4TextField1(String.valueOf(playerId));
                    break;
                case 1:
                    generateProgramViewModel.setLast4TextField2(String.valueOf(playerId));
                    break;
                case 2:
                    generateProgramViewModel.setLast4TextField3(String.valueOf(playerId));
                    break;
                case 3:
                    generateProgramViewModel.setLast4TextField4(String.valueOf(playerId));
                    break;
            }
        }
    }
}
