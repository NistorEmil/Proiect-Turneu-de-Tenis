package app.ViewModel;

import app.ViewModel.Commands.*;
import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;

public class LoginViewModel {

    private Property<String> textField1;
    private Property<String> passwordField1;
    private Property<String> idField;
    public ICommand loginCommand;
    public ICommand registerCommand;
    public ICommand tournamentProgramCommand;
    public ICommand scoreCommand;
    public LoginViewModel() {
        textField1 = PropertyFactory.createProperty("textField1", this, String.class);
        passwordField1 = PropertyFactory.createProperty("passwordField1", this, String.class);
        idField = PropertyFactory.createProperty("idField", this, String.class);
        scoreCommand = new CommandOpenScoreTable(this);
        loginCommand = new CommandLogin(this);
        registerCommand = new CommandOpenRegistration(this);
        tournamentProgramCommand = new CommandOpenTournamentProgram(this);
    }

    public String getUserField() {
        return textField1.get();
    }
    public String getPassField() {
        return passwordField1.get();
    }

}