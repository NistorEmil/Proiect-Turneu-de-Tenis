package app.ViewModel;

import app.ViewModel.Commands.CommandCreateScoreTable;
import app.ViewModel.Commands.CommandCreateTournamentProgram;
import app.ViewModel.Commands.ICommand;
import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;

import javax.swing.table.DefaultTableModel;

public class TennisMatchesScoreViewModel {
    private Property<DefaultTableModel> model;
    public ICommand createTableCommand1;

    public TennisMatchesScoreViewModel() {
        model = PropertyFactory.createProperty("model", this, new DefaultTableModel());
        createTableCommand1 = new CommandCreateScoreTable(this);
    }

    public DefaultTableModel getModel() {
        return model.get();
    }

    public void setModel(DefaultTableModel model) {
        this.model.set(model);
    }
}
