package app.ViewModel.Commands;

import app.ViewModel.TennisMatchCRUDViewModel;
import app.ViewModel.service.RefereeServiceInterface;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;
import app.model.*;
public class CommandRefereeTableSelected1 implements ICommand{
    private TennisMatchCRUDViewModel tennisMatchCRUDViewModel;
    private RefereeServiceInterface refereeService = ServiceSinglePointAccess.getRefereeService();

    public CommandRefereeTableSelected1() {
    }

    public CommandRefereeTableSelected1(TennisMatchCRUDViewModel tennisMatchCRUDViewModel) {
        this.tennisMatchCRUDViewModel = tennisMatchCRUDViewModel;
    }

    @Override
    public void execute(Referee referee) {
        int selectedRow = tennisMatchCRUDViewModel.getRefereesRow();
        if (selectedRow >= 0){
            tennisMatchCRUDViewModel.setRefereeId(tennisMatchCRUDViewModel.getRefereesTable().getValueAt(selectedRow, 0).toString());
        }
    }
}
