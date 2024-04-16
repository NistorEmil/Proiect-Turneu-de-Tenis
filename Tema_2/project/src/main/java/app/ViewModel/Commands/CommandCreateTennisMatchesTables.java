package app.ViewModel.Commands;

import app.ViewModel.TennisMatchCRUDViewModel;
import app.model.Referee;
import app.model.TennisMatch;
import app.model.TennisPlayer;
import app.ViewModel.service.implementation.RefereeService;
import app.ViewModel.service.implementation.TennisMatchService;
import app.ViewModel.service.implementation.TennisPlayerService;

import java.util.List;
import javax.swing.table.DefaultTableModel;

public class CommandCreateTennisMatchesTables implements ICommand{
    private TennisMatchCRUDViewModel tennisMatchCRUDViewModel;
    private TennisMatchService tennisMatchService;
    private RefereeService refereeService;
    private TennisPlayerService tennisPlayerService;

    public CommandCreateTennisMatchesTables() {
    }

    public CommandCreateTennisMatchesTables(TennisMatchCRUDViewModel tennisMatchCRUDViewModel) {
        this.tennisMatchCRUDViewModel = tennisMatchCRUDViewModel;
    }


    @Override
    public void execute(Referee referee) {
        List<TennisPlayer> tennisPlayers = tennisPlayerService.findAll();
        Object[][] tennisPlayersTablee1 = new Object[200][5];
        if(tennisPlayers!= null){
            for(int i = 0; i < tennisPlayers.size(); i++){
                tennisPlayersTablee1[i][0] = tennisPlayers.get(i).getId();
                tennisPlayersTablee1[i][1] = tennisPlayers.get(i).getFirstName();
                tennisPlayersTablee1[i][2] = tennisPlayers.get(i).getLastName();
                tennisPlayersTablee1[i][3] = tennisPlayers.get(i).getAge();
                tennisPlayersTablee1[i][4] = tennisPlayers.get(i).getCategory();
            }
        }
        String[] cols = {"Id", "First Name", "Last Name", "Age", "Category"};
        tennisMatchCRUDViewModel.setModelTennisPlayer1(new DefaultTableModel(tennisPlayersTablee1, cols));

        int selectedRow = tennisMatchCRUDViewModel.getTennisPlayer1Row();
        if (selectedRow >= 0) {
            tennisMatchCRUDViewModel.setTennisPlayer1Id(tennisMatchCRUDViewModel.getTennisPlayer1Table().getValueAt(selectedRow, 0).toString());
        }

        tennisMatchCRUDViewModel.setModelTennisPlayer2(new DefaultTableModel(tennisPlayersTablee1, cols));

        selectedRow = tennisMatchCRUDViewModel.getTennisPlayer2Row();
        if (selectedRow >= 0) {
            tennisMatchCRUDViewModel.setTennisPlayer2Id(tennisMatchCRUDViewModel.getTennisPlayer2Table().getValueAt(selectedRow, 0).toString());
        }


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

        tennisMatchCRUDViewModel.setModelReferee(new DefaultTableModel(refereesTable1, colsRefs));

        selectedRow = tennisMatchCRUDViewModel.getRefereesRow();
        if (selectedRow >= 0){
            tennisMatchCRUDViewModel.setRefereeId(tennisMatchCRUDViewModel.getRefereesTable().getValueAt(selectedRow, 0).toString());
        }

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

        selectedRow = tennisMatchCRUDViewModel.getTennisMatchRow();

        if (selectedRow >= 0){
            tennisMatchCRUDViewModel.setMatchIdTextField(tennisMatchCRUDViewModel.getTennisMatchesTable().getValueAt(selectedRow, 0).toString());
            tennisMatchCRUDViewModel.setTennisPlayer1Id(tennisMatchCRUDViewModel.getTennisMatchesTable().getValueAt(selectedRow, 1).toString());
            tennisMatchCRUDViewModel.setTennisPlayer2Id(tennisMatchCRUDViewModel.getTennisMatchesTable().getValueAt(selectedRow, 2).toString());
            tennisMatchCRUDViewModel.setRefereeId(tennisMatchCRUDViewModel.getTennisMatchesTable().getValueAt(selectedRow, 3).toString());
            String categoryType = tennisMatchCRUDViewModel.getTennisMatchesTable().getValueAt(selectedRow, 4).toString();
            if(categoryType.equals("MALE"))
            {
                tennisMatchCRUDViewModel.setMaleRadioButton(true);
            }
            else if(categoryType.equals("FEMALE"))
            {
                tennisMatchCRUDViewModel.setFemaleRadioButton(true);
            }
            else if(categoryType.equals("UNDER18"))
            {
                tennisMatchCRUDViewModel.setUnder18RadioButton(true);
            }
        }
    }
}
