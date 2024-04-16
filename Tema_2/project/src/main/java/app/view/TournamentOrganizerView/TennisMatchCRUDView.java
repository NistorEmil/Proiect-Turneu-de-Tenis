package app.view.TournamentOrganizerView;

import app.ViewModel.TennisMatchCRUDViewModel;
import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.Binder;
import net.sds.mvvm.bindings.BindingType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TennisMatchCRUDView {
    @Bind(value = "text", target = "refereeId.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField refereeId;
    @Bind(value = "model", target = "modelTennisPlayer1.value", type = BindingType.TARGET_TO_SOURCE)
    @Bind(value = "selectedRow", target = "rowTennisPlayer1.value", type = BindingType.BI_DIRECTIONAL)
    private JTable tennisPlayersTable1;
    @Bind(value = "model", target = "modelReferee.value", type = BindingType.TARGET_TO_SOURCE)
    @Bind(value = "selectedRow", target = "rowReferee.value", type = BindingType.BI_DIRECTIONAL)
    private JTable refereesTable;
    @Bind(value = "model", target = "modelTennisPlayer2.value", type = BindingType.TARGET_TO_SOURCE)
    @Bind(value = "selectedRow", target = "rowTennisPlayer2.value", type = BindingType.BI_DIRECTIONAL)
    private JTable tennisPlayersTable2;
    @Bind(value = "text", target = "tennisPlayer1Id.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField tennisPlayer1Id;
    @Bind(value = "text", target = "tennisPlayer2Id.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField tennisPlayer2Id;
    private JButton addTennisMatchButton;
    private JButton updateTennisMatchButton;
    private JButton deleteTennisMatchButton;
    private JButton backButton;
    private JPanel panel;
    @Bind(value = "selected", target = "maleRadioButton.value", type = BindingType.BI_DIRECTIONAL)
    private JRadioButton maleRadioButton;
    @Bind(value = "selected", target = "femaleRadioButton.value", type = BindingType.BI_DIRECTIONAL)
    private JRadioButton femaleRadioButton;
    @Bind(value = "selected", target = "under18RadioButton.value", type = BindingType.BI_DIRECTIONAL)
    private JRadioButton under18RadioButton;
    @Bind(value = "model", target = "tennisMatchesTable.value", type = BindingType.TARGET_TO_SOURCE)
    @Bind(value = "selectedRow", target = "rowTennisMatch.value", type = BindingType.BI_DIRECTIONAL)
    private JTable tennisMatchesTable;
    @Bind(value = "text", target = "matchIdTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField matchIdTextField;
    @Bind(value = "text", target = "scoreTextField1.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField scoreTextField1;
    @Bind(value = "text", target = "scoreTextField2.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField scoreTextField2;
    @Bind(value = "selected", target = "matchPlayed.value", type = BindingType.BI_DIRECTIONAL)
    private JRadioButton matchPlayed;
    TennisMatchCRUDViewModel tennisMatchCRUDViewModel;

    public TennisMatchCRUDView() {
        app.ViewModel.single_point_access.GUIFrameSinglePointAccess.changePanel(panel, "Tennis Match Panel");
        tennisMatchCRUDViewModel = new TennisMatchCRUDViewModel();
        tennisMatchCRUDViewModel.createTennisPlayerTable1Command.execute(null);
        tennisMatchCRUDViewModel.createTennisPlayerTable2Command.execute(null);
        tennisMatchCRUDViewModel.createRefereeTableCommand.execute(null);
        tennisMatchCRUDViewModel.createTennisMatchTableCommand.execute(null);
        ButtonGroup group = new ButtonGroup();
        group.add(maleRadioButton);
        group.add(femaleRadioButton);
        group.add(under18RadioButton);
        try {
            Binder.bind(this, tennisMatchCRUDViewModel);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        addTennisMatchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tennisMatchCRUDViewModel.addTennisMatchButton.execute(null);
            }
        });
        updateTennisMatchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tennisMatchCRUDViewModel.updateTennisMatchButton.execute(null);
            }
        });
        deleteTennisMatchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tennisMatchCRUDViewModel.deleteTennisMatchButton.execute(null);
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TournamentOrganizerView();
            }
        });
        tennisPlayersTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tennisMatchCRUDViewModel.fillFieldsTennisPlayer1.execute(null);
            }
        });
        tennisPlayersTable2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tennisMatchCRUDViewModel.fillFieldsTennisPlayer2.execute(null);
            }
        });
        refereesTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tennisMatchCRUDViewModel.fillFieldsReferee.execute(null);
            }
        });
        tennisMatchesTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tennisMatchCRUDViewModel.fillFieldsTennisMatch.execute(null);
            }
        });
    }

}
