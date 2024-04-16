package app.ViewModel.Commands;

import app.ViewModel.TennisMatchCRUDViewModel;
import app.model.Referee;
import app.ViewModel.service.RefereeServiceInterface;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class CommandCreateRefereeTable1 implements ICommand{
    private TennisMatchCRUDViewModel tennisMatchCRUDViewModel;
    private RefereeServiceInterface refereeService = ServiceSinglePointAccess.getRefereeService();

    public CommandCreateRefereeTable1() {
    }

    public CommandCreateRefereeTable1(TennisMatchCRUDViewModel tennisMatchCRUDViewModel) {
        this.tennisMatchCRUDViewModel = tennisMatchCRUDViewModel;
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
        tennisMatchCRUDViewModel.setModelReferee(defaultTableModel);
    }
}
