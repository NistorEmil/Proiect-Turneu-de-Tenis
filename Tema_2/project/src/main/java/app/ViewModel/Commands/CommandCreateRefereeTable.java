package app.ViewModel.Commands;

import app.ViewModel.RefereeCRUDViewModel;
import app.model.Referee;
import app.ViewModel.service.RefereeServiceInterface;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class CommandCreateRefereeTable implements ICommand{
    private RefereeCRUDViewModel refereeCRUDViewModel;
    private RefereeServiceInterface refereeService = ServiceSinglePointAccess.getRefereeService();

    public CommandCreateRefereeTable() {
    }

    public CommandCreateRefereeTable(RefereeCRUDViewModel refereeCRUDViewModel) {
        this.refereeCRUDViewModel = refereeCRUDViewModel;
    }

    @Override
    public void execute(Referee referee) {
        List<Referee> referees = refereeService.findAll();
        Object[][] refereesTable1 = new Object[200][3];
        if(referees!= null){
            for(int i = 0; i < referees.size(); i++){
                refereesTable1[i][0] = referees.get(i).getId();
                refereesTable1[i][1] = referees.get(i).getFirstName();
                refereesTable1[i][2] = referees.get(i).getLastName();
            }
        }
        String[] colsRefs = {"Id", "First Name", "Last Name"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(refereesTable1, colsRefs);
        refereeCRUDViewModel.setModel(defaultTableModel);

        /*
        int selectedRow = refereeCRUDViewModel.getRow();
        int selectedColumn = refereeCRUDViewModel.getColumn();
        if (selectedRow >= 0 && refereeCRUDViewModel.getRefereesTable().getValueAt(selectedRow, selectedColumn) != null) { // Check if a row is selected;
            refereeCRUDViewModel.setIdTextField(refereeCRUDViewModel.getRefereesTable().getValueAt(selectedRow, 0).toString());
            refereeCRUDViewModel.setFirstNameTextField(refereeCRUDViewModel.getRefereesTable().getValueAt(selectedRow, 1).toString());
            refereeCRUDViewModel.setLastNameTextField(refereeCRUDViewModel.getRefereesTable().getValueAt(selectedRow, 2).toString());

        }

         */
    }
}
