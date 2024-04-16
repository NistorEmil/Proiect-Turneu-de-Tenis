package app.ViewModel;

import app.ViewModel.Commands.CommandChangeScore;
import app.ViewModel.Commands.CommandCreateTennisMathcesTable;
import app.ViewModel.Commands.ICommand;
import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.BindingType;
import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RefereeViewModel {
    private Property<DefaultTableModel> model;
    private Property<String> scoreTextField1;
    private Property<String> scoreTextField2;
    public ICommand backButton;
    public ICommand commandCreateRefereeTable;
    public ICommand changeScore;
    private Property<String> idTextField;

    public RefereeViewModel()
    {
        model = PropertyFactory.createProperty("model", this, new DefaultTableModel());
        scoreTextField1 = PropertyFactory.createProperty("scoreTextField1", this, String.class);
        scoreTextField2 = PropertyFactory.createProperty("scoreTextField2", this, String.class);
        idTextField = PropertyFactory.createProperty("idTextField", this, String.class);
        commandCreateRefereeTable = new CommandCreateTennisMathcesTable(this);
        changeScore = new CommandChangeScore(this);
    }

    public void setModel(DefaultTableModel defaultTableModel){
        model.set(defaultTableModel);
    }
    public DefaultTableModel getTable(){
        return model.get();
    }

    public String getIdTextField() {
        return idTextField.get();
    }

    public String getScoreTextField1() {
        return scoreTextField1.get();
    }

    public String getScoreTextField2() {
        return scoreTextField2.get();
    }

}