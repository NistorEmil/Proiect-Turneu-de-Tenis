package app.ViewModel.Commands;

import app.ViewModel.TennisMatchCRUDViewModel;
import app.ViewModel.service.TennisPlayerServiceInterface;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;
import app.model.*;
public class CommandTennisPlayerTableSelected1 implements ICommand{
    private TennisMatchCRUDViewModel tennisMatchCRUDViewModel;
    private TennisPlayerServiceInterface tennisPlayerService = ServiceSinglePointAccess.getTennisPlayerService();

    public CommandTennisPlayerTableSelected1() {
    }

    public CommandTennisPlayerTableSelected1(TennisMatchCRUDViewModel tennisMatchCRUDViewModel) {
        this.tennisMatchCRUDViewModel = tennisMatchCRUDViewModel;
    }


    @Override
    public void execute(Referee referee) {
        int selectedRow1 = tennisMatchCRUDViewModel.getTennisPlayer1Row();
        if (selectedRow1 >= 0) {
            tennisMatchCRUDViewModel.setTennisPlayer1Id(tennisMatchCRUDViewModel.getTennisPlayer1Table().getValueAt(selectedRow1, 0).toString());
        }
    }
}
