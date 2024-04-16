package app.ViewModel;

import app.ViewModel.Commands.*;
import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.BindingType;
import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GenerateProgramViewModel {
    private Property<DefaultTableModel> last16Table;
    private Property<DefaultTableModel> last8Table;
    private Property<DefaultTableModel> last4Table;
    public ICommand generateLast16Button;
    public ICommand generateLast8Button;
    public ICommand generateLast4Button;
    private Property<String> player4TextField;
    private Property<String> player3TextField;
    private Property<String> player2TextField;
    private Property<String> player1TextField;
    private Property<String> player5TextField;
    private Property<String> player6TextField;
    private Property<String> player7TextField;
    private Property<String> player8TextField;
    private Property<String> last4TextField1;
    private Property<String> last4TextField2;
    private Property<String> last4TextField3;
    private Property<String> last4TextField4;
    private Property<DefaultTableModel> finalTable;
    private Property<String> last2TextField1;
    private Property<String> last2TextField2;
    public ICommand generateLast2Button;
    private Property<String> winnerTextField;
    public ICommand backButton;
    private Property<Integer> rowLast16Table;
    private Property<Integer> rowLast8Table;
    private Property<Integer> rowLast4Table;
    private Property<Integer> rowLast2Table;
    public ICommand fillFields16;
    public ICommand fillFields8;
    public ICommand fillFields4;
    public ICommand fillFields2;

    public GenerateProgramViewModel() {
        last16Table = PropertyFactory.createProperty("last16Table", this, new DefaultTableModel());
        last8Table = PropertyFactory.createProperty("last8Table", this, new DefaultTableModel());
        last4Table = PropertyFactory.createProperty("last4Table", this, new DefaultTableModel());
        finalTable = PropertyFactory.createProperty("finalTable", this, new DefaultTableModel());
        player1TextField = PropertyFactory.createProperty("player1TextField", this, String.class);
        player2TextField = PropertyFactory.createProperty("player2TextField", this, String.class);
        player3TextField = PropertyFactory.createProperty("player3TextField", this, String.class);
        player4TextField = PropertyFactory.createProperty("player4TextField", this, String.class);
        player5TextField = PropertyFactory.createProperty("player5TextField", this, String.class);
        player6TextField = PropertyFactory.createProperty("player6TextField", this, String.class);
        player7TextField = PropertyFactory.createProperty("player7TextField", this, String.class);
        player8TextField = PropertyFactory.createProperty("player8TextField", this, String.class);
        last4TextField1 = PropertyFactory.createProperty("last4TextField1", this, String.class);
        last4TextField2 = PropertyFactory.createProperty("last4TextField2", this, String.class);
        last4TextField3 = PropertyFactory.createProperty("last4TextField3", this, String.class);
        last4TextField4 = PropertyFactory.createProperty("last4TextField4", this, String.class);
        last2TextField1 = PropertyFactory.createProperty("last2TextField1", this, String.class);
        last2TextField2 = PropertyFactory.createProperty("last2TextField2", this, String.class);
        winnerTextField = PropertyFactory.createProperty("winnerTextField", this, String.class);
        rowLast16Table = PropertyFactory.createProperty("rowLast16Table", this, Integer.class);
        rowLast8Table = PropertyFactory.createProperty("rowLast8Table", this, Integer.class);
        rowLast4Table = PropertyFactory.createProperty("rowLast4Table", this, Integer.class);
        rowLast2Table = PropertyFactory.createProperty("rowLast2Table", this, Integer.class);
        winnerTextField = PropertyFactory.createProperty("winnerTextField", this, String.class);
        generateLast16Button = new CommandCreateLast16Table(this);
        generateLast8Button = new CommandCreateLast8Table(this);
        generateLast4Button = new CommandCreateLast4Table(this);
        generateLast2Button = new CommandCreateLast2Table(this);
        fillFields16 = new CommandLast16TableSelected(this);
        fillFields8 = new CommandLast8TableSelected(this);
        fillFields4 = new CommandLast4TableSelected(this);
        fillFields2 = new CommandLast2TableSelected(this);
    }

    public DefaultTableModel getLast16Table() {
        return last16Table.get();
    }

    public DefaultTableModel getLast8Table() {
        return last8Table.get();
    }

    public DefaultTableModel getLast4Table() {
        return last4Table.get();
    }

    public String getPlayer4TextField() {
        return player4TextField.get();
    }

    public String getPlayer3TextField() {
        return player3TextField.get();
    }

    public String getPlayer2TextField() {
        return player2TextField.get();
    }

    public String getPlayer1TextField() {
        return player1TextField.get();
    }

    public String getPlayer5TextField() {
        return player5TextField.get();
    }

    public String getPlayer6TextField() {
        return player6TextField.get();
    }

    public String getPlayer7TextField() {
        return player7TextField.get();
    }

    public String getPlayer8TextField() {
        return player8TextField.get();
    }

    public String getLast4TextField1() {
        return last4TextField1.get();
    }

    public String getLast4TextField2() {
        return last4TextField2.get();
    }

    public String getLast4TextField3() {
        return last4TextField3.get();
    }

    public String getLast4TextField4() {
        return last4TextField4.get();
    }

    public DefaultTableModel getFinalTable() {
        return finalTable.get();
    }

    public String getLast2TextField1() {
        return last2TextField1.get();
    }

    public String getLast2TextField2() {
        return last2TextField2.get();
    }

    public Integer getRowLast16Table() {
        return rowLast16Table.get();
    }

    public Integer getRowLast8Table() {
        return rowLast8Table.get();
    }

    public Integer getRowLast4Table() {
        return rowLast4Table.get();
    }

    public Integer getRowLast2Table() {
        return rowLast2Table.get();
    }

    public void setLast16Table(DefaultTableModel last16Table) {
        this.last16Table.set(last16Table);
    }

    public void setLast8Table(DefaultTableModel last8Table) {
        this.last8Table.set(last8Table);
    }

    public void setLast4Table(DefaultTableModel last4Table) {
        this.last4Table.set(last4Table);
    }

    public void setPlayer4TextField(String player4TextField) {
        this.player4TextField.set(player4TextField);
    }

    public void setPlayer3TextField(String player3TextField) {
        this.player3TextField.set(player3TextField);
    }

    public void setPlayer2TextField(String player2TextField) {
        this.player2TextField.set(player2TextField);
    }

    public void setPlayer1TextField(String player1TextField) {
        this.player1TextField.set(player1TextField);
    }

    public void setPlayer5TextField(String player5TextField) {
        this.player5TextField.set(player5TextField);
    }

    public void setPlayer6TextField(String player6TextField) {
        this.player6TextField.set(player6TextField);
    }

    public void setPlayer7TextField(String player7TextField) {
        this.player7TextField.set(player7TextField);
    }

    public void setPlayer8TextField(String player8TextField) {
        this.player8TextField.set(player8TextField);
    }

    public void setLast4TextField1(String last4TextField1) {
        this.last4TextField1.set(last4TextField1);
    }

    public void setLast4TextField2(String last4TextField2) {
        this.last4TextField2.set(last4TextField2);
    }

    public void setLast4TextField3(String last4TextField3) {
        this.last4TextField3.set(last4TextField3);
    }

    public void setLast4TextField4(String last4TextField4) {
        this.last4TextField4.set(last4TextField4);
    }

    public void setFinalTable(DefaultTableModel finalTable) {
        this.finalTable.set(finalTable);
    }

    public void setLast2TextField1(String last2TextField1) {
        this.last2TextField1.set(last2TextField1);
    }

    public void setLast2TextField2(String last2TextField2) {
        this.last2TextField2.set(last2TextField2);
    }

    public void setWinnerTextField(String winnerTextField) {
        this.winnerTextField.set(winnerTextField);
    }

}
