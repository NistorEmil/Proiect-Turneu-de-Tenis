package app.ViewModel;

import app.ViewModel.Commands.*;
import app.view.TournamentOrganizerView.GenerateProgramView;

import javax.swing.*;

public class TournamentOrganizerViewModel {
    public ICommand refereeCRUDButton;
    public ICommand tennisMatchCRUDButton;
    public ICommand tennisPlayerCRUDButton;
    public ICommand backButton;
    public ICommand generateProgramButton;
    public ICommand saveAsCsv;
    public ICommand saveAsXml;
    public ICommand saveAsJson;
    public TournamentOrganizerViewModel() {
       refereeCRUDButton = new CommandOpenRefereeCRUD(this);
       tennisMatchCRUDButton = new CommandOpenTennisMatchCRUD(this);
       tennisPlayerCRUDButton = new CommandOpenTennisPlayerCRUD(this);
       generateProgramButton = new CommandCreateProgramView(this);
       saveAsCsv = new CommandSaveAsCsv(this);
       saveAsXml = new CommandSaveAsXml(this);
       saveAsJson = new CommandSaveAsJson(this);
    }

}
