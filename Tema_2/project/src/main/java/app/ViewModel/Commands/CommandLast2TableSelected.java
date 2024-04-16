package app.ViewModel.Commands;

import app.ViewModel.GenerateProgramViewModel;
import app.ViewModel.service.RefereeServiceInterface;
import app.ViewModel.service.TennisPlayerServiceInterface;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;
import app.model.*;
import javax.swing.table.DefaultTableModel;
import java.util.Random;

public class CommandLast2TableSelected  implements ICommand {
    private GenerateProgramViewModel generateProgramViewModel;
    private TennisPlayerServiceInterface tennisPlayerService = ServiceSinglePointAccess.getTennisPlayerService();
    private RefereeServiceInterface refereeService = ServiceSinglePointAccess.getRefereeService();

    public CommandLast2TableSelected() {
    }

    public CommandLast2TableSelected(GenerateProgramViewModel generateProgramViewModel) {
        this.generateProgramViewModel = generateProgramViewModel;
    }

    @Override
    public void execute(Referee referee) {
        int selectedRow = generateProgramViewModel.getRowLast2Table();

        // Verificăm dacă un rând este selectat
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) generateProgramViewModel.getFinalTable();

            int playerId;
            Random random = new Random();

            // Generăm un număr aleatoriu între 1 și 2 inclusiv
            int randomNumber = random.nextInt(2) + 1;
            int selectedColumn = randomNumber;

            playerId = (int) model.getValueAt(selectedRow, selectedColumn);
            switch (selectedRow) {
                case 0:
                    generateProgramViewModel.setWinnerTextField(String.valueOf(playerId));
                    break;
            }
        }
    }
}
