package app.ViewModel.Commands;

import app.ViewModel.TennisMatchCRUDViewModel;
import app.model.CategoryType;
import app.model.Referee;
import app.model.TennisMatch;
import app.model.TennisPlayer;
import app.ViewModel.service.RefereeServiceInterface;
import app.ViewModel.service.TennisMatchServiceInterface;
import app.ViewModel.service.TennisPlayerServiceInterface;
import app.ViewModel.single_point_access.GUIFrameSinglePointAccess;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;

public class CommandUpdateTennisMatch implements ICommand {
    private TennisMatchCRUDViewModel tennisMatchCRUDViewModel;
    private RefereeServiceInterface refereeService = ServiceSinglePointAccess.getRefereeService();
    private TennisPlayerServiceInterface tennisPlayerService = ServiceSinglePointAccess.getTennisPlayerService();
    private TennisMatchServiceInterface tennisMatchService = ServiceSinglePointAccess.getTennisMatchService();

    public CommandUpdateTennisMatch() {
    }

    public CommandUpdateTennisMatch (TennisMatchCRUDViewModel tennisMatchCRUDViewModel) {
        this.tennisMatchCRUDViewModel = tennisMatchCRUDViewModel;
    }

    @Override
    public void execute(Referee referee) {
        String id1 = tennisMatchCRUDViewModel.getMatchIdTextField();
        if(id1 == null){
            GUIFrameSinglePointAccess.showDialogMessage("Select a tennisMatch");
        }
        else{
            TennisMatch foundTennisMatch = tennisMatchService.findById(Integer.parseInt(id1));
            if(foundTennisMatch == null)
            {
                GUIFrameSinglePointAccess.showDialogMessage("Not such Tennis Match");
                return;
            }

            Integer id = Integer.parseInt(tennisMatchCRUDViewModel.getMatchIdTextField());
            Integer player1Id = Integer.parseInt(tennisMatchCRUDViewModel.getTennisPlayer1Id());
            Integer player2Id = Integer.parseInt(tennisMatchCRUDViewModel.getTennisPlayer2Id());
            Integer refereeId = Integer.parseInt(tennisMatchCRUDViewModel.getRefereeId());
            CategoryType categoryType = tennisMatchCRUDViewModel.getCategory();

            if(id == null){
                GUIFrameSinglePointAccess.showDialogMessage("Complete id field");
            }
            if(player1Id  == null){
                GUIFrameSinglePointAccess.showDialogMessage("Complete player1 id field");
            }
            if(player2Id == null){
                GUIFrameSinglePointAccess.showDialogMessage("Complete player2 id field");
            }
            if(refereeId == null){
                GUIFrameSinglePointAccess.showDialogMessage("Complete referee id field");
            }
            if(categoryType == null){
                GUIFrameSinglePointAccess.showDialogMessage("Choose category");
            }
            TennisMatch tennisMatch = tennisMatchService.findById(id);

            if(tennisMatch == null || tennisMatch.getId() == foundTennisMatch.getId()) {
                TennisPlayer tennisPlayer1 = tennisPlayerService.findById(player1Id);
                TennisPlayer tennisPlayer2 = tennisPlayerService.findById(player2Id);
                if(tennisPlayer1 != null) {
                    foundTennisMatch.setTennisPlayer1(tennisPlayerService.findById(player1Id));
                }
                else {
                    GUIFrameSinglePointAccess.showDialogMessage("Not such tennis player with this id");
                }
                if(tennisPlayer2 != null)
                    foundTennisMatch.setTennisPlayer2(tennisPlayerService.findById(player2Id));
                else{
                    GUIFrameSinglePointAccess.showDialogMessage("Not such tennis player with this id");
                }
                if(refereeService.findById(refereeId) != null) {
                    Referee referee2 = refereeService.findById(refereeId);
                    referee2.getTennisMatches().add(foundTennisMatch);
                    foundTennisMatch.setReferee(referee2);
                }
                else{
                    GUIFrameSinglePointAccess.showDialogMessage("Not such referee with this id");
                }
                foundTennisMatch.setCategory(categoryType);
                tennisMatchService.update(foundTennisMatch);
                GUIFrameSinglePointAccess.showDialogMessage("Succesfully updated");
            }
            else {
                GUIFrameSinglePointAccess.showDialogMessage("Already existing Tennis Match");
            }
        }
    }
}
