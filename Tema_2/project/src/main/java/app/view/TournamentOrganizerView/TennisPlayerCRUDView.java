package app.view.TournamentOrganizerView;

import app.ViewModel.TennisPlayerCRUDViewModel;
import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.Binder;
import net.sds.mvvm.bindings.BindingType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TennisPlayerCRUDView {
    @Bind(value = "text", target = "firstNameTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField firstNameTextField;
    @Bind(value = "text", target = "lastNameTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField lastNameTextField;
    @Bind(value = "text", target = "ageTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField ageTextField;
    @Bind(value = "text", target = "idTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField idTextField;
    private JPanel panel;
    @Bind(value = "model", target = "model.value", type = BindingType.TARGET_TO_SOURCE)
    @Bind(value = "selectedRow", target = "row.value", type = BindingType.BI_DIRECTIONAL)
    private JTable model;
    private JButton addTennisPlayerButton;
    private JButton updateTennisPlayerButton;
    private JButton deleteTennisPlayerButton;
    private JButton backButton;
    @Bind(value = "selected", target = "maleRadioButton.value", type = BindingType.BI_DIRECTIONAL)
    private JRadioButton maleRadioButton;
    @Bind(value = "selected", target = "femaleRadioButton.value", type = BindingType.BI_DIRECTIONAL)
    private JRadioButton femaleRadioButton;
    @Bind(value = "selected", target = "under18RadioButton.value", type = BindingType.BI_DIRECTIONAL)
    private JRadioButton under18RadioButton;
    private JButton filterAfterAgeButton;
    private JButton filterAfterCategoryButton;
    TennisPlayerCRUDViewModel tennisPlayerCRUDViewModel;
    public TennisPlayerCRUDView() {
        app.ViewModel.single_point_access.GUIFrameSinglePointAccess.changePanel(panel, "Tennis Player Panel");
        tennisPlayerCRUDViewModel = new TennisPlayerCRUDViewModel();
        tennisPlayerCRUDViewModel.commandCreateTennisPlayerTable.execute(null);
        ButtonGroup group = new ButtonGroup();
        group.add(maleRadioButton);
        group.add(femaleRadioButton);
        group.add(under18RadioButton);
        try {
            Binder.bind(this, tennisPlayerCRUDViewModel);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        addTennisPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tennisPlayerCRUDViewModel.addTennisPlayerButton.execute(null);
            }
        });
        updateTennisPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tennisPlayerCRUDViewModel.updateTennisPlayerButton.execute(null);
            }
        });
        deleteTennisPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tennisPlayerCRUDViewModel.deleteTennisPlayerButton.execute(null);
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TournamentOrganizerView();
            }
        });
        model.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tennisPlayerCRUDViewModel.fillFields.execute(null);
            }
        });
        filterAfterAgeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tennisPlayerCRUDViewModel.commandFilterAfterAge.execute(null);
            }
        });
        filterAfterCategoryButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tennisPlayerCRUDViewModel.commandFilterAfterCategory.execute(null);
            }
        });
    }

}
