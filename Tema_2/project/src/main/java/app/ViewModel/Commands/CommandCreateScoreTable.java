package app.ViewModel.Commands;

import app.ViewModel.TennisMatchesScoreViewModel;
import app.model.Referee;
import app.model.TennisMatch;
import app.ViewModel.service.TennisMatchServiceInterface;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class CommandCreateScoreTable implements ICommand {
    private TennisMatchesScoreViewModel tennisMatchesScoreViewModel;
    private TennisMatchServiceInterface tennisMatchService = ServiceSinglePointAccess.getTennisMatchService();

    public CommandCreateScoreTable() {
    }

    public CommandCreateScoreTable(TennisMatchesScoreViewModel tennisMatchesScoreViewModel) {
        this.tennisMatchesScoreViewModel = tennisMatchesScoreViewModel;
    }

    @Override
    public void execute(Referee referee) {
        List<TennisMatch> tennisMatches = tennisMatchService.findAll();
        List<TennisMatch> newTennisMatches = new ArrayList<>();
        for(TennisMatch tennisMatch: tennisMatches)
        {
            if(tennisMatch.getPlayed() != null && tennisMatch.getPlayed())
            {
                newTennisMatches.add(tennisMatch);
            }
        }
        Object[][] tennisMatchesTable1 = new Object[200][4];
        if (newTennisMatches != null) {
            for (int i = 0; i < newTennisMatches.size(); i++) {
                tennisMatchesTable1[i][0] = newTennisMatches.get(i).getTennisPlayer1().getId();
                tennisMatchesTable1[i][1] = newTennisMatches.get(i).getTennisPlayer1Score();
                tennisMatchesTable1[i][2] = newTennisMatches.get(i).getTennisPlayer2().getId();
                tennisMatchesTable1[i][3] = newTennisMatches.get(i).getTennisPlayer2Score();
            }
        }
        String[] cols = {"Tennis Player1", "Score1", "Tennis Player2", "Score2"};
        tennisMatchesScoreViewModel.setModel(new DefaultTableModel(tennisMatchesTable1, cols));
    }
}
