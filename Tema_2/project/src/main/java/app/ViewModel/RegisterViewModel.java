package app.ViewModel;

import app.ViewModel.Commands.CommandTournamentRegistration;
import app.ViewModel.Commands.ICommand;
import app.model.TennisMatch;
import app.model.User;
import app.model.UserType;
import app.ViewModel.single_point_access.GUIFrameSinglePointAccess;
import app.view.LoginView;
import app.view.RefereeInterface;
import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RegisterViewModel {
    private Property<String> firstName;
    private Property<String> age;
    private Property<String> lastName;
    private Property<Boolean> maleRadioButton;
    private Property<Boolean> femaleRadioButton;
    private Property<Boolean> under18RadioButton;
    public ICommand registerButton;
    private ICommand backButton;
    public RegisterViewModel()
    {
        firstName= PropertyFactory.createProperty("firstName", this, String.class);
        age = PropertyFactory.createProperty("age", this, String.class);
        firstName = PropertyFactory.createProperty("firstName", this, String.class);
        lastName = PropertyFactory.createProperty("lastName", this, String.class);
        maleRadioButton = PropertyFactory.createProperty("maleRadioButton", this, Boolean.class);
        femaleRadioButton = PropertyFactory.createProperty("femaleRadioButton", this, Boolean.class);
        under18RadioButton = PropertyFactory.createProperty("under18RadioButton", this, Boolean.class);
        registerButton = new CommandTournamentRegistration(this);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public String getAge() {
        return age.get();
    }

    public String getLastName() {
        return lastName.get();
    }

    public Boolean getMaleRadioButton() {
        return maleRadioButton.get();
    }

    public Boolean getFemaleRadioButton() {
        return femaleRadioButton.get();
    }

}