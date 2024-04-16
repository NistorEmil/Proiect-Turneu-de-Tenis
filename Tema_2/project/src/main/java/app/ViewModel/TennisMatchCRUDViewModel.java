package app.ViewModel;

import app.ViewModel.Commands.*;
import app.model.CategoryType;
import app.model.UserType;
import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.BindingType;
import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TennisMatchCRUDViewModel {
    private Property<String> refereeId;
    private Property<DefaultTableModel> modelTennisPlayer1;
    private Property<DefaultTableModel> modelReferee;
    private Property<DefaultTableModel> modelTennisPlayer2;
    private Property<String> tennisPlayer1Id;
    private Property<String> tennisPlayer2Id;
    public ICommand addTennisMatchButton;
    public ICommand updateTennisMatchButton;
    public ICommand deleteTennisMatchButton;
    public ICommand backButton;
    public ICommand createTennisPlayerTable1Command;
    public ICommand createTennisPlayerTable2Command;
    public ICommand createRefereeTableCommand;
    public ICommand createTennisMatchTableCommand;
    public ICommand fillFieldsTennisPlayer1;
    public ICommand fillFieldsTennisPlayer2;
    public ICommand fillFieldsReferee;
    public ICommand fillFieldsTennisMatch;
    private Property<Boolean> maleRadioButton;
    private Property<Boolean> femaleRadioButton;
    private Property<Boolean> under18RadioButton;
    private Property<DefaultTableModel> tennisMatchesTable;
    private Property<String> matchIdTextField;
    private Property<Integer> rowReferee;
    private Property<Integer> rowTennisPlayer1;
    private Property<Integer> rowTennisPlayer2;
    private Property<Integer> rowTennisMatch;
    private Property<String> scoreTextField1;
    private Property<String> scoreTextField2;
    private Property<Boolean> matchPlayed;

    public TennisMatchCRUDViewModel()
    {
        refereeId = PropertyFactory.createProperty("refereeId", this, String.class);
        tennisPlayer1Id = PropertyFactory.createProperty("tennisPlayer1Id", this, String.class);
        tennisPlayer2Id = PropertyFactory.createProperty("tennisPlayer2Id", this, String.class);
        matchIdTextField = PropertyFactory.createProperty("matchIdTextField", this, String.class);
        modelTennisPlayer1 = PropertyFactory.createProperty("modelTennisPlayer1", this, new DefaultTableModel());
        rowTennisPlayer1 = PropertyFactory.createProperty("rowTennisPlayer1", this, Integer.class);
        modelTennisPlayer2 = PropertyFactory.createProperty("modelTennisPlayer2", this, new DefaultTableModel());
        rowTennisPlayer2 = PropertyFactory.createProperty("rowTennisPlayer2", this, Integer.class);
        modelReferee = PropertyFactory.createProperty("modelReferee", this, new DefaultTableModel());
        rowReferee = PropertyFactory.createProperty("rowReferee", this, Integer.class);
        tennisMatchesTable = PropertyFactory.createProperty("tennisMatchesTable", this, new DefaultTableModel());
        rowTennisMatch = PropertyFactory.createProperty("rowTennisMatch", this, Integer.class);
        maleRadioButton = PropertyFactory.createProperty("maleRadioButton", this, Boolean.class);
        femaleRadioButton = PropertyFactory.createProperty("femaleRadioButton", this, Boolean.class);
        under18RadioButton = PropertyFactory.createProperty("under18RadioButton", this, Boolean.class);
        matchPlayed = PropertyFactory.createProperty("matchPlayed", this, Boolean.class);
        scoreTextField1 = PropertyFactory.createProperty("scoreTextField1", this, String.class);
        scoreTextField2 = PropertyFactory.createProperty("scoreTextField2", this, String.class);
        addTennisMatchButton = new CommandAddTennisMatch(this);
        updateTennisMatchButton = new CommandUpdateTennisMatch(this);
        deleteTennisMatchButton = new CommandDeleteTennisMatch(this);
        createTennisPlayerTable1Command = new CommandCreateTennisPlayersTable1(this);
        createTennisPlayerTable2Command = new CommandCreateTennisPlayersTable2(this);
        createRefereeTableCommand = new CommandCreateRefereeTable1(this);
        createTennisMatchTableCommand = new CommandCreateTennisMatchesTable(this);
        fillFieldsTennisPlayer1 = new CommandTennisPlayerTableSelected1(this);
        fillFieldsReferee = new CommandRefereeTableSelected1(this);
        fillFieldsTennisPlayer2 = new CommandTennisPlayerTableSelected2(this);
        fillFieldsTennisMatch = new CommandTennisMatchesTableSelected(this);
    }

    public CategoryType getCategory() {
        if(maleRadioButton.get())
            return CategoryType.MALE;
        else if(femaleRadioButton.get())
            return CategoryType.FEMALE;
        else if(under18RadioButton.get())
            return CategoryType.UNDER18;
        return null;
    }

    public String getScoreTextField1() {
        return scoreTextField1.get();
    }

    public String getScoreTextField2() {
        return scoreTextField2.get();
    }

    public Boolean getMatchPlayed() {
        return matchPlayed.get();
    }

    public String getRefereeId() {
        return refereeId.get();
    }

    public String getTennisPlayer1Id() {
        return tennisPlayer1Id.get();
    }

    public String getTennisPlayer2Id() {
        return tennisPlayer2Id.get();
    }

    public String getMatchIdTextField() {
        return matchIdTextField.get();
    }

    public void setRefereeId(String refereeId) {
        this.refereeId.set(refereeId);
    }

    public void setTennisPlayer1Id(String tennisPlayer1Id) {
        this.tennisPlayer1Id.set(tennisPlayer1Id);
    }

    public void setTennisPlayer2Id(String tennisPlayer2Id) {
        this.tennisPlayer2Id.set(tennisPlayer2Id);
    }

    public void setMatchIdTextField(String matchIdTextField) {
        this.matchIdTextField.set(matchIdTextField);
    }

    public DefaultTableModel getRefereesTable(){
        return modelReferee.get();
    }
    public DefaultTableModel getTennisPlayer1Table(){
        return modelTennisPlayer1.get();
    }
    public DefaultTableModel getTennisPlayer2Table(){
        return modelTennisPlayer2.get();
    }

    public DefaultTableModel getTennisMatchesTable(){
        return tennisMatchesTable.get();
    }
    public Integer getRefereesRow(){
        return rowReferee.get();
    }

    public Integer getTennisPlayer1Row(){
        return rowTennisPlayer1.get();
    }

    public Integer getTennisPlayer2Row(){
        return rowTennisPlayer2.get();
    }
    public Integer getTennisMatchRow(){
        return rowTennisMatch.get();
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

    public void setModelReferee(DefaultTableModel defaultTableModel){
        modelReferee.set(defaultTableModel);
    }
    public void setModelTennisPlayer1(DefaultTableModel defaultTableModel){
        modelTennisPlayer1.set(defaultTableModel);
    }
    public void setModelTennisPlayer2(DefaultTableModel defaultTableModel){
        modelTennisPlayer2.set(defaultTableModel);
    }

    public void setModelTennisMatch(DefaultTableModel defaultTableModel){
        tennisMatchesTable.set(defaultTableModel);
    }
}
