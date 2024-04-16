package app.ViewModel.Commands;

import app.ViewModel.TennisMatchCRUDViewModel;
import app.model.TennisMatch;
import app.ViewModel.service.TennisMatchServiceInterface;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;

import javax.swing.table.DefaultTableModel;
import java.util.List;
import app.model.*;
public class CommandCreateTennisMatchesTable implements ICommand {
        private TennisMatchCRUDViewModel tennisMatchCRUDViewModel;
    private TennisMatchServiceInterface tennisMatchService = ServiceSinglePointAccess.getTennisMatchService();

    public CommandCreateTennisMatchesTable() {
    }

    public CommandCreateTennisMatchesTable(TennisMatchCRUDViewModel tennisMatchCRUDViewModel) {
        this.tennisMatchCRUDViewModel =  tennisMatchCRUDViewModel;
    }

    @Override
    public void execute(Referee referee) {
        List<TennisMatch> tennisMatches = tennisMatchService.findAll();
        Object[][] tennisMatchesTable1 = new Object[200][5];
        if(tennisMatches!= null){
            for(int i = 0; i < tennisMatches.size(); i++){
                tennisMatchesTable1[i][0] = tennisMatches.get(i).getId();
                tennisMatchesTable1[i][1] = tennisMatches.get(i).getTennisPlayer1().getId();
                tennisMatchesTable1[i][2] = tennisMatches.get(i).getTennisPlayer2().getId();
                tennisMatchesTable1[i][3] = tennisMatches.get(i).getReferee().getId();
                tennisMatchesTable1[i][4] = tennisMatches.get(i).getCategory().toString();
            }
        }
        String[] colsMatches = {"Id", "Player 1 id", "Player 2 id", "Referee id", "Category"};
        tennisMatchCRUDViewModel.setModelTennisMatch(new DefaultTableModel(tennisMatchesTable1, colsMatches));
    }
}
