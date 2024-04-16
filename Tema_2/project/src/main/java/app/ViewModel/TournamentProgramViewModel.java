package app.ViewModel;

import app.ViewModel.Commands.CommandCreateTournamentProgram;
import app.ViewModel.Commands.CommandLogin;
import app.ViewModel.Commands.CommandOpenTournamentProgram;
import app.ViewModel.Commands.ICommand;
import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.BindingType;
import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TournamentProgramViewModel {
    private Property<DefaultTableModel> model;
    public ICommand createTableCommand;

    public TournamentProgramViewModel() {
        model = PropertyFactory.createProperty("model", this, new DefaultTableModel());
        createTableCommand = new CommandCreateTournamentProgram(this);
    }

    public DefaultTableModel getModel() {
        return model.get();
    }

    public void setModel(DefaultTableModel model) {
        this.model.set(model);
    }
}
