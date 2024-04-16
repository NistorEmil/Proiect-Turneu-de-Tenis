package app.ViewModel.Commands;

import app.ViewModel.RegisterViewModel;
import app.model.TennisMatch;
import app.model.TennisPlayer;
import app.ViewModel.service.TennisPlayerServiceInterface;
import app.ViewModel.single_point_access.GUIFrameSinglePointAccess;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;
import app.model.*;
import java.util.List;
import java.util.ArrayList;

public class CommandTournamentRegistration implements ICommand{
    private RegisterViewModel registerViewModel;
    private TennisPlayerServiceInterface tennisPlayerService = ServiceSinglePointAccess.getTennisPlayerService();

    public CommandTournamentRegistration() {
    }

    public CommandTournamentRegistration(RegisterViewModel registerViewModel) {
        this.registerViewModel = registerViewModel;
    }


    @Override
    public void execute(Referee referee) {
        String firstName = registerViewModel.getFirstName();
        String lastName = registerViewModel.getLastName();
        String age = registerViewModel.getAge();
        String categoryType;
        if(registerViewModel.getFemaleRadioButton())
        {
            categoryType = "FEMALE";
        }
        else if(registerViewModel.getMaleRadioButton())
        {
            categoryType = "MALE";
        }
        else
        {
            categoryType = "UNDER18";
        }
        List<TennisMatch> tennisMatchList = new ArrayList<>();
        if(firstName.isEmpty()){
            GUIFrameSinglePointAccess.showDialogMessage("First Name required");
        }
        else if(lastName.isEmpty()){
            GUIFrameSinglePointAccess.showDialogMessage("Last Name required");
        }
        else if(age == null){
            GUIFrameSinglePointAccess.showDialogMessage("Age required");
        }
        else if(categoryType == null){
            GUIFrameSinglePointAccess.showDialogMessage("Category required");
        }
        else
        {
            TennisPlayer tennisPlayer = new TennisPlayer(firstName, lastName, Integer.parseInt(age), categoryType, tennisMatchList);
            TennisPlayer tennisPlayer1 = tennisPlayerService.save(tennisPlayer);
            if (tennisPlayer1 != null) {
                GUIFrameSinglePointAccess.showDialogMessage("Succesfully registered");
            }
            else {
                GUIFrameSinglePointAccess.showDialogMessage("Invalid registration");
            }
        }
    }
}
