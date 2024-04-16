package app.ViewModel.Commands;

import app.ViewModel.TennisMatchCRUDViewModel;
import app.ViewModel.service.TennisMatchServiceInterface;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;
import app.model.*;
public class CommandTennisMatchesTableSelected implements ICommand {
    private TennisMatchCRUDViewModel tennisMatchCRUDViewModel;
    private TennisMatchServiceInterface tennisMatchService = ServiceSinglePointAccess.getTennisMatchService();

    public CommandTennisMatchesTableSelected() {
    }

    public CommandTennisMatchesTableSelected(TennisMatchCRUDViewModel tennisMatchCRUDViewModel) {
        this.tennisMatchCRUDViewModel =  tennisMatchCRUDViewModel;
    }

    @Override
    public void execute(Referee referee) {
        int selectedRow = tennisMatchCRUDViewModel.getTennisMatchRow();
        if (selectedRow >= 0){
            tennisMatchCRUDViewModel.setMatchIdTextField(tennisMatchCRUDViewModel.getTennisMatchesTable().getValueAt(selectedRow, 0).toString());
            tennisMatchCRUDViewModel.setTennisPlayer1Id(tennisMatchCRUDViewModel.getTennisMatchesTable().getValueAt(selectedRow, 1).toString());
            tennisMatchCRUDViewModel.setTennisPlayer2Id(tennisMatchCRUDViewModel.getTennisMatchesTable().getValueAt(selectedRow, 2).toString());
            tennisMatchCRUDViewModel.setRefereeId(tennisMatchCRUDViewModel.getTennisMatchesTable().getValueAt(selectedRow, 3).toString());
            String userType = tennisMatchCRUDViewModel.getTennisMatchesTable().getValueAt(selectedRow, 4).toString();
            System.out.println(userType);
            if(userType.equals("MALE"))
            {
                tennisMatchCRUDViewModel.setMaleRadioButton(true);
            }
            else if(userType.equals("FEMALE"))
            {
                tennisMatchCRUDViewModel.setFemaleRadioButton(true);
            }
            else if(userType.equals("UNDER18"))
            {
                tennisMatchCRUDViewModel.setUnder18RadioButton(true);
            }
        }
    }
}
