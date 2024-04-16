package app.ViewModel.Commands;

import app.ViewModel.RefereeViewModel;
import app.model.Referee;
import app.model.TennisMatch;
import app.ViewModel.service.RefereeServiceInterface;
import app.ViewModel.service.TennisMatchServiceInterface;
import app.ViewModel.service.TennisPlayerServiceInterface;
import app.ViewModel.single_point_access.GUIFrameSinglePointAccess;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;

public class CommandChangeScore implements ICommand{
    private RefereeViewModel refereeViewModel;
    private RefereeServiceInterface refereeService = ServiceSinglePointAccess.getRefereeService();
    private TennisPlayerServiceInterface tennisPlayerService = ServiceSinglePointAccess.getTennisPlayerService();
    private TennisMatchServiceInterface tennisMatchService = ServiceSinglePointAccess.getTennisMatchService();

    public CommandChangeScore() {
    }

    public CommandChangeScore (RefereeViewModel refereeViewModel) {
        this.refereeViewModel = refereeViewModel;
    }

    @Override
    public void execute(Referee referee) {
        String id1 = refereeViewModel.getIdTextField();
        if (id1.isEmpty()) {
            GUIFrameSinglePointAccess.showDialogMessage("Enter Match Id");
            return;
        } else {
            TennisMatch foundTennisMatch = tennisMatchService.findById(Integer.parseInt(id1));
            if (foundTennisMatch == null) {
                GUIFrameSinglePointAccess.showDialogMessage("Not such Tennis Match");
                return;
            }
            if (refereeViewModel.getScoreTextField1().isEmpty()) {
                GUIFrameSinglePointAccess.showDialogMessage("Complete score1 field");
                return;
            }
            if (refereeViewModel.getScoreTextField2().isEmpty()) {
                GUIFrameSinglePointAccess.showDialogMessage("Complete score2 field");
                return;
            }
            Integer score1 = Integer.parseInt(refereeViewModel.getScoreTextField1());
            Integer score2 = Integer.parseInt(refereeViewModel.getScoreTextField2());

            if (score1 == null) {
                GUIFrameSinglePointAccess.showDialogMessage("Complete score1 field");
                return;
            }
            if (score2 == null) {
                GUIFrameSinglePointAccess.showDialogMessage("Complete score2 field");
                return;
            }
            foundTennisMatch.setTennisPlayer1Score(score1);
            foundTennisMatch.setTennisPlayer2Score(score2);
            foundTennisMatch.setPlayed(true);
            tennisMatchService.update(foundTennisMatch);
            GUIFrameSinglePointAccess.showDialogMessage("Succesfully updated");
        }
    }
}
