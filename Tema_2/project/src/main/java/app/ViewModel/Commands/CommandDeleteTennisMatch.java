package app.ViewModel.Commands;

import app.ViewModel.TennisMatchCRUDViewModel;
import app.model.CategoryType;
import app.model.Referee;
import app.model.TennisMatch;
import app.ViewModel.service.RefereeServiceInterface;
import app.ViewModel.service.TennisMatchServiceInterface;
import app.ViewModel.service.TennisPlayerServiceInterface;
import app.ViewModel.single_point_access.GUIFrameSinglePointAccess;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;

import java.util.List;

public class CommandDeleteTennisMatch implements ICommand {
    private TennisMatchCRUDViewModel tennisMatchCRUDViewModel;
    private RefereeServiceInterface refereeService = ServiceSinglePointAccess.getRefereeService();
    private TennisPlayerServiceInterface tennisPlayerService = ServiceSinglePointAccess.getTennisPlayerService();
    private TennisMatchServiceInterface tennisMatchService = ServiceSinglePointAccess.getTennisMatchService();

    public CommandDeleteTennisMatch() {
    }

    public CommandDeleteTennisMatch (TennisMatchCRUDViewModel tennisMatchCRUDViewModel) {
        this.tennisMatchCRUDViewModel = tennisMatchCRUDViewModel;
    }

    @Override
    public void execute(Referee referee) {
        Integer id = Integer.parseInt(tennisMatchCRUDViewModel.getMatchIdTextField());
        Integer player1Id = Integer.parseInt(tennisMatchCRUDViewModel.getTennisPlayer1Id());
        Integer player2Id = Integer.parseInt(tennisMatchCRUDViewModel.getTennisPlayer2Id());
        Integer refereeId = Integer.parseInt(tennisMatchCRUDViewModel.getRefereeId());
        CategoryType categoryType = tennisMatchCRUDViewModel.getCategory();

        if(id == null){
            GUIFrameSinglePointAccess.showDialogMessage("Complete id field");
        }
        else if(player1Id == null){
            GUIFrameSinglePointAccess.showDialogMessage("Complete player1 id field");
        }
        else if(player2Id == null) {
            GUIFrameSinglePointAccess.showDialogMessage("Complete player2 id field");
        }
        else if(refereeId == null) {
            GUIFrameSinglePointAccess.showDialogMessage("Complete referee id field");
        }
        else if(categoryType == null) {
            GUIFrameSinglePointAccess.showDialogMessage("Choose category");
        }
        else{
            String id1 = tennisMatchCRUDViewModel.getMatchIdTextField();
            if(id1 == null){
                GUIFrameSinglePointAccess.showDialogMessage("Error deleting referee");
            }
            else {
                TennisMatch tennisMatch= tennisMatchService.findById(id);
                Referee referee2 = tennisMatch.getReferee();
                List<TennisMatch> tennisMatches = referee2.getTennisMatches();
                tennisMatches.remove(tennisMatch);
                referee2.setTennisMatches(tennisMatches);
                refereeService.update(referee2);
                tennisMatchService.delete(tennisMatch);
                GUIFrameSinglePointAccess.showDialogMessage("Succesfully deleted");
            }
        }
    }
}
