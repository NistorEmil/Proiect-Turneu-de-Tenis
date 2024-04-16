package app.ViewModel.Commands;

import app.ViewModel.TennisPlayerCRUDViewModel;
import app.ViewModel.service.TennisPlayerServiceInterface;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;
import app.model.*;
public class CommandTennisPlayerTableSelected implements ICommand{
    private TennisPlayerCRUDViewModel tennisPlayerCRUDViewModel;
    private TennisPlayerServiceInterface tennisPlayerService = ServiceSinglePointAccess.getTennisPlayerService();

    public CommandTennisPlayerTableSelected() {
    }

    public CommandTennisPlayerTableSelected(TennisPlayerCRUDViewModel tennisPlayerCRUDViewModel) {
        this.tennisPlayerCRUDViewModel = tennisPlayerCRUDViewModel;
    }


    @Override
    public void execute(Referee referee) {
        int selectedRow = tennisPlayerCRUDViewModel.getSelectedRow();
        if (selectedRow >= 0){
            Integer id = (Integer) tennisPlayerCRUDViewModel.getModel().getValueAt(selectedRow, 0);
            String firstName = (String) tennisPlayerCRUDViewModel.getModel().getValueAt(selectedRow, 1);
            String lastName = (String) tennisPlayerCRUDViewModel.getModel().getValueAt(selectedRow, 2);
            Integer age = (Integer) tennisPlayerCRUDViewModel.getModel().getValueAt(selectedRow, 3);
            String categoryType = (String) tennisPlayerCRUDViewModel.getModel().getValueAt(selectedRow, 4);
            tennisPlayerCRUDViewModel.setIdTextField(id.toString());
            tennisPlayerCRUDViewModel.setFirstNameTextField(firstName);
            tennisPlayerCRUDViewModel.setLastNameTextField(lastName);
            tennisPlayerCRUDViewModel.setAgeTextField(age.toString());

            if(categoryType.equals("MALE"))
            {
                tennisPlayerCRUDViewModel.setMaleRadioButton(true);
            }
            else if(categoryType.equals("FEMALE"))
            {
                tennisPlayerCRUDViewModel.setFemaleRadioButton(true);
            }
            else if(categoryType.equals("UNDER18"))
            {
                tennisPlayerCRUDViewModel.setUnder18RadioButton(true);
            }
        }
    }
}
