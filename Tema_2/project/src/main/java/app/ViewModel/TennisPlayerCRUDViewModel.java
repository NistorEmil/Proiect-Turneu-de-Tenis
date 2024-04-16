package app.ViewModel;

import app.ViewModel.Commands.*;
import app.model.CategoryType;
import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TennisPlayerCRUDViewModel {
    private Property<String> firstNameTextField;
    private Property<String> lastNameTextField;
    private Property<String> ageTextField;
    private Property<String> idTextField;
    private Property<Integer> row;
    private Property<DefaultTableModel> model;
    public ICommand addTennisPlayerButton;
    public ICommand updateTennisPlayerButton;
    public ICommand deleteTennisPlayerButton;
    public ICommand backButton;
    public ICommand commandCreateTennisPlayerTable;
    public ICommand fillFields;
    public ICommand commandFilterAfterAge;
    public ICommand commandFilterAfterCategory;
    private Property<Boolean> maleRadioButton;
    private Property<Boolean> femaleRadioButton;
    private Property<Boolean> under18RadioButton;
    public TennisPlayerCRUDViewModel()
    {
        firstNameTextField = PropertyFactory.createProperty("firstNameTextField", this, String.class);
        lastNameTextField = PropertyFactory.createProperty("lastNameTextField", this, String.class);
        ageTextField = PropertyFactory.createProperty("ageTextField", this, String.class);
        idTextField = PropertyFactory.createProperty("idTextField", this, String.class);
        model = PropertyFactory.createProperty("model", this, new DefaultTableModel());
        maleRadioButton = PropertyFactory.createProperty("maleRadioButton", this, Boolean.class);
        femaleRadioButton = PropertyFactory.createProperty("femaleRadioButton", this, Boolean.class);
        under18RadioButton = PropertyFactory.createProperty("under18RadioButton", this, Boolean.class);
        row = PropertyFactory.createProperty("row", this, Integer.class);
        addTennisPlayerButton = new CommandAddTennisPlayer(this);
        updateTennisPlayerButton = new CommandUpdateTennisPlayer(this);
        deleteTennisPlayerButton = new CommandDeleteTennisPlayer(this);
        commandCreateTennisPlayerTable = new CommandCreateTennisPlayersTable(this);
        fillFields = new CommandTennisPlayerTableSelected(this);
        commandFilterAfterAge = new CommandFilterTennisPlayersByAge(this);
        commandFilterAfterCategory = new CommandFilterTennisPlayerByCategory(this);
    }

    public String getFirstNameTextField() {
        return firstNameTextField.get();
    }

    public String getLastNameTextField() {
        return lastNameTextField.get();
    }

    public String getAgeTextField() {
        return ageTextField.get();
    }

    public String getIdTextField() {
        return idTextField.get();
    }

    public DefaultTableModel getModel() {
        return model.get();
    }

    public Boolean getMaleRadioButton() {
        return maleRadioButton.get();
    }

    public Boolean getFemaleRadioButton() {
        return femaleRadioButton.get();
    }

    public Boolean getUnder18RadioButton() {
        return under18RadioButton.get();
    }

    public void setFirstNameTextField(String firstNameTextField) {
        this.firstNameTextField.set(firstNameTextField);
    }

    public void setLastNameTextField(String lastNameTextField) {
        this.lastNameTextField.set(lastNameTextField);
    }

    public void setAgeTextField(String ageTextField) {
        this.ageTextField.set(ageTextField);
    }

    public void setIdTextField(String idTextField) {
        this.idTextField.set(idTextField);
    }

    public void setModel(DefaultTableModel model) {
        this.model.set(model);
    }

    public void setMaleRadioButton(Boolean maleRadioButton) {
        this.maleRadioButton.set(maleRadioButton);
    }

    public void setFemaleRadioButton(Boolean femaleRadioButton) {
        this.femaleRadioButton.set(femaleRadioButton);
    }

    public void setUnder18RadioButton(Boolean under18RadioButton) {
        this.under18RadioButton.set(under18RadioButton);
    }

    public Integer getSelectedRow() {
        return row.get();
    }

    public String getCategory()
    {
        if(getMaleRadioButton())
            return "MALE";
        else if(getFemaleRadioButton())
            return "MALE";
        else
            return "UNDER18";
    }

}
