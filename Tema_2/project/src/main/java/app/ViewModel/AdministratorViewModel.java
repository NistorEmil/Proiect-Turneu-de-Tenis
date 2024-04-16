package app.ViewModel;

import app.ViewModel.Commands.*;
import app.model.User;
import app.model.UserType;
import app.view.AdministratorView;
import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AdministratorViewModel {
    private Property<DefaultTableModel> model;
    private Property<String> userNameTextField;
    private Property<String> passwordTextField;
    private Property<String> firstNameTextField;
    private Property<String> lastNameTextField;
    private Property<Integer> row;
    private Property<Boolean> administratorRadioButton;
    private Property<Boolean> refereeRadioButton;
    private Property<Boolean> tournament_OrganizerRadioButton;
    public ICommand addUserButton;
    public ICommand updateUserButton;
    public ICommand deleteUserButton;
    public ICommand backButton;
    public ICommand commandCreateUserTable;
    public ICommand fillFields;
    public AdministratorViewModel()
    {
        userNameTextField = PropertyFactory.createProperty("userNameTextField", this, String.class);
        passwordTextField = PropertyFactory.createProperty("passwordTextField", this, String.class);
        firstNameTextField = PropertyFactory.createProperty("firstNameTextField", this, String.class);
        lastNameTextField = PropertyFactory.createProperty("lastNameTextField", this, String.class);
        model = PropertyFactory.createProperty("model", this, new DefaultTableModel());
        row = PropertyFactory.createProperty("row", this, Integer.class);
        administratorRadioButton = PropertyFactory.createProperty("administratorRadioButton", this, Boolean.class);
        refereeRadioButton = PropertyFactory.createProperty("refereeRadioButton", this, Boolean.class);
        tournament_OrganizerRadioButton = PropertyFactory.createProperty("tournament_OrganizerRadioButton", this, Boolean.class);
        commandCreateUserTable = new CommandCreateUserTable(this);
        addUserButton = new CommandAddUser(this);
        updateUserButton = new CommandUpdateUser(this);
        deleteUserButton = new CommandDeleteUser(this);
        fillFields = new CommandUserTableSelected(this);
    }

    public String getUsername() {
        return userNameTextField.get();
    }

    public void setUserName(String userName) {
        this.userNameTextField.set(userName);
    }

    public void setPassword(String password) {
        this.passwordTextField.set(password);
    }

    public String getPassword() {
        return passwordTextField.get();
    }

    public String getFirstName() {
        return firstNameTextField.get();
    }

    public String getLastName() {
        return lastNameTextField.get();
    }
    public DefaultTableModel getTable(){
        return model.get();
    }
    public Integer getRow(){
        return row.get();
    }

    public UserType getRole()
    {
        if(getAdministratorRadioButton())
            return UserType.ADMINISTRATOR;
        else if(getRefereeRadioButton())
            return UserType.REFEREE;
        else
            return UserType.TOURNAMENT_ORGANIZER;
    }
    public Boolean getAdministratorRadioButton() {
        return administratorRadioButton.get();
    }

    public Boolean getRefereeRadioButton() {
        return refereeRadioButton.get();
    }


    public void setAdministratorRadioButton(Boolean administratorRadioButton) {
        this.administratorRadioButton.set(administratorRadioButton);
    }

    public void setTournament_OrganizerRadioButton(Boolean tournament_OrganizerRadioButton) {
        this.tournament_OrganizerRadioButton.set(tournament_OrganizerRadioButton);
    }

    public void setModel(DefaultTableModel defaultTableModel){
        model.set(defaultTableModel);
    }

}
