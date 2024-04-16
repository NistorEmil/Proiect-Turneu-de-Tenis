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

public class CommandAddTennisMatch  implements ICommand {
    private TennisMatchCRUDViewModel tennisMatchCRUDViewModel;
    private RefereeServiceInterface refereeService = ServiceSinglePointAccess.getRefereeService();
    private TennisPlayerServiceInterface tennisPlayerService = ServiceSinglePointAccess.getTennisPlayerService();
    private TennisMatchServiceInterface tennisMatchService = ServiceSinglePointAccess.getTennisMatchService();

    public CommandAddTennisMatch() {
    }

    public CommandAddTennisMatch (TennisMatchCRUDViewModel tennisMatchCRUDViewModel) {
        this.tennisMatchCRUDViewModel = tennisMatchCRUDViewModel;
    }

    @Override
    public void execute(Referee referee) {
        Integer playerId1 = Integer.parseInt(tennisMatchCRUDViewModel.getTennisPlayer1Id());
        Integer playerId2 = Integer.parseInt(tennisMatchCRUDViewModel.getTennisPlayer2Id());
        Integer refereeId = Integer.parseInt(tennisMatchCRUDViewModel.getRefereeId());
        CategoryType category = tennisMatchCRUDViewModel.getCategory();
        Boolean matchPlayed = tennisMatchCRUDViewModel.getMatchPlayed();
        if(playerId1 == null){
            GUIFrameSinglePointAccess.showDialogMessage("Player 1 required");
        }
        else if(playerId2 == null){
            GUIFrameSinglePointAccess.showDialogMessage("Player 2 required");
        }
        else if(refereeId == null){
            GUIFrameSinglePointAccess.showDialogMessage("Referee required");
        }
        else if(category == null){
            GUIFrameSinglePointAccess.showDialogMessage("Category required");
        }
        else
        {
            TennisPlayer tennisPlayer1 = tennisPlayerService.findById(playerId1);
            TennisPlayer tennisPlayer2 = tennisPlayerService.findById(playerId2);
            Referee referee2 = refereeService.findById(refereeId);
            TennisMatch tennisMatch;
            TennisMatch tennisMatch1;
            if(matchPlayed)
            {
                Integer score1 = Integer.parseInt(tennisMatchCRUDViewModel.getScoreTextField1());
                Integer score2 = Integer.parseInt(tennisMatchCRUDViewModel.getScoreTextField2());
                tennisMatch = new TennisMatch(tennisPlayer1, tennisPlayer2, referee2, category, score1, score2, matchPlayed);
                tennisMatch1 = tennisMatchService.save(tennisMatch);
            }
            else
            {
                tennisMatch = new TennisMatch(tennisPlayer1, tennisPlayer2, referee2, category, matchPlayed);
                tennisMatch1 = tennisMatchService.save(tennisMatch);
            }
            if (tennisMatch1 != null) {
                GUIFrameSinglePointAccess.showDialogMessage("Succesfully registered");
            }
            else {
                GUIFrameSinglePointAccess.showDialogMessage("Invalid registration");
            }
        }
    }
}
