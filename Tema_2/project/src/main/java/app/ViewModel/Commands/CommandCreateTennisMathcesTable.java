package app.ViewModel.Commands;

import app.ViewModel.RefereeViewModel;
import app.model.Referee;
import app.model.TennisMatch;
import app.ViewModel.service.RefereeServiceInterface;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class CommandCreateTennisMathcesTable implements ICommand{
    private RefereeViewModel refereeViewModel;
    private RefereeServiceInterface refereeService = ServiceSinglePointAccess.getRefereeService();

    public CommandCreateTennisMathcesTable() {
    }

    public CommandCreateTennisMathcesTable(RefereeViewModel refereeViewModel) {
        this.refereeViewModel = refereeViewModel;
    }


    @Override
    public void execute(Referee referee) {

        List<TennisMatch> tennisMatches = refereeService.getAllTennisMatchesOfReferee(referee);
        Object[][] tennisMatchesTable1 = new Object[200][6];
        if (tennisMatches != null) {
            for (int i = 0; i < tennisMatches.size(); i++) {
                tennisMatchesTable1[i][0] = tennisMatches.get(i).getId();
                tennisMatchesTable1[i][1] = tennisMatches.get(i).getCategory();
                tennisMatchesTable1[i][2] = tennisMatches.get(i).getTennisPlayer1().getId();
                tennisMatchesTable1[i][3] = tennisMatches.get(i).getTennisPlayer1Score();
                tennisMatchesTable1[i][4] = tennisMatches.get(i).getTennisPlayer2().getId();
                tennisMatchesTable1[i][5] = tennisMatches.get(i).getTennisPlayer2Score();
            }
        }
        String[] cols = {"Tennis Match Id", "Category", "TennisPlayer1", "Score1", "TennisPlayer2", "Score2"};
        refereeViewModel.setModel(new DefaultTableModel(tennisMatchesTable1, cols));
    }
}
