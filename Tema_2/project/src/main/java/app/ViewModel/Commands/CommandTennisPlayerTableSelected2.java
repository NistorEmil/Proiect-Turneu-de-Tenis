package app.ViewModel.Commands;

import app.ViewModel.TennisMatchCRUDViewModel;
import app.ViewModel.service.TennisPlayerServiceInterface;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;
import app.model.*;
public class CommandTennisPlayerTableSelected2 implements ICommand{
    private TennisMatchCRUDViewModel tennisMatchCRUDViewModel;
    private TennisPlayerServiceInterface tennisPlayerService = ServiceSinglePointAccess.getTennisPlayerService();

    public CommandTennisPlayerTableSelected2() {
    }

    public CommandTennisPlayerTableSelected2(TennisMatchCRUDViewModel tennisMatchCRUDViewModel) {
        this.tennisMatchCRUDViewModel = tennisMatchCRUDViewModel;
    }


    @Override
    public void execute(Referee referee) {
        int selectedRow1 = tennisMatchCRUDViewModel.getTennisPlayer2Row();
        if (selectedRow1 >= 0) {
            tennisMatchCRUDViewModel.setTennisPlayer2Id(tennisMatchCRUDViewModel.getTennisPlayer2Table().getValueAt(selectedRow1, 0).toString());
        }
    }
}
