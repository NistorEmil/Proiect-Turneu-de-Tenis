package app.ViewModel.Commands;

import app.ViewModel.RefereeCRUDViewModel;
import app.ViewModel.service.RefereeServiceInterface;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;
import app.model.*;
public class CommandRefereeTableSelected implements ICommand{
    private RefereeCRUDViewModel refereeCRUDViewModel;
    private RefereeServiceInterface refereeService = ServiceSinglePointAccess.getRefereeService();

    public CommandRefereeTableSelected() {
    }

    public CommandRefereeTableSelected(RefereeCRUDViewModel refereeCRUDViewModel) {
        this.refereeCRUDViewModel = refereeCRUDViewModel;
    }

    @Override
    public void execute(Referee referee) {
        int selectedRow = refereeCRUDViewModel.getRow();
        //int selectedColumn = refereeCRUDViewModel.getColumn();
        //if (selectedRow >= 0 && refereeCRUDViewModel.getRefereesTable().getValueAt(selectedRow, selectedColumn) != null) {
            if (selectedRow >= 0) { // Check if a row is selected;
                Integer id = (Integer) refereeCRUDViewModel.getRefereesTable().getValueAt(selectedRow, 0);
                String firstName = (String) refereeCRUDViewModel.getRefereesTable().getValueAt(selectedRow, 1);
                String lastName = (String) refereeCRUDViewModel.getRefereesTable().getValueAt(selectedRow, 2);
                refereeCRUDViewModel.setIdTextField(id.toString());
                refereeCRUDViewModel.setFirstNameTextField(firstName);
                refereeCRUDViewModel.setLastNameTextField(lastName);
                //refereeCRUDViewModel.setIdTextField(refereeCRUDViewModel.getRefereesTable().getValueAt(selectedRow, 0).toString());
                //refereeCRUDViewModel.setFirstNameTextField(refereeCRUDViewModel.getRefereesTable().getValueAt(selectedRow, 1).toString());
                //refereeCRUDViewModel.setLastNameTextField(refereeCRUDViewModel.getRefereesTable().getValueAt(selectedRow, 2).toString())
        }
    }
}
