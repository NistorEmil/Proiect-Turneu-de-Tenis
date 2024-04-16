package app.ViewModel;

import app.ViewModel.Commands.*;
import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RefereeCRUDViewModel {
    private Property<String> firstName;
    private Property<String>  lastName;
    private Property<String>  id;
    public ICommand addButton;
    public ICommand updateButton;
    public ICommand deleteButton;
    public ICommand backButton;
    private Property<Integer> row;
    private Property<Integer> column;
    private Property<DefaultTableModel> model;
    public ICommand commandCreateRefereeTable;
    public ICommand fillFields;

    public RefereeCRUDViewModel() {
        addButton = new CommandAddReferee();
        updateButton = new CommandUpdateReferee();
        deleteButton = new CommandDeleteReferee();
        firstName = PropertyFactory.createProperty("firstName", this, String.class);
        lastName = PropertyFactory.createProperty("lastName", this, String.class);
        id = PropertyFactory.createProperty("id", this, String.class);
        model = PropertyFactory.createProperty("model", this, new DefaultTableModel());
        row = PropertyFactory.createProperty("row", this, Integer.class);
        column = PropertyFactory.createProperty("column", this, Integer.class);
        commandCreateRefereeTable = new CommandCreateRefereeTable(this);
        fillFields = new CommandRefereeTableSelected(this);
        deleteButton = new CommandDeleteReferee(this);
        updateButton = new CommandUpdateReferee(this);
        addButton = new CommandAddReferee(this);
    }

    public String getFirstNameTextField() {
        return firstName.get();
    }

    public String getLastNameTextField() {
        return lastName.get();
    }

    public String getIdTextField() {
        return id.get();
    }

    public DefaultTableModel getRefereesTable() {
        return model.get();
    }

    public void setModel(DefaultTableModel defaultTableModel){
        model.set(defaultTableModel);
    }

    public Integer getRow() {
        return row.get();
    }

    public Integer getColumn() {
        return column.get();
    }

    public void setFirstNameTextField(String firstNameTextField) {
        this.firstName.set(firstNameTextField);
    }

    public void setLastNameTextField(String lastNameTextField) {
        this.lastName.set(lastNameTextField);
    }

    public void setIdTextField(String idTextField) {
        this.id.set(idTextField);
    }
}
