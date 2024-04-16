package app.view;

import app.ViewModel.AdministratorViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.Binder;
import net.sds.mvvm.bindings.BindingType;

public class AdministratorView {
    @Bind(value = "model", target = "model.value", type = BindingType.TARGET_TO_SOURCE)
    @Bind(value = "selectedRow", target = "row.value", type = BindingType.BI_DIRECTIONAL)
    private JTable usersTable;
    @Bind(value = "text", target = "userNameTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField userNameTextField;
    private JButton addUserButton;
    private JButton updateUserButton;
    private JButton deleteUserButton;
    private JButton backButton;
    private JPanel panel;
    @Bind(value = "text", target = "passwordTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JPasswordField passwordTextField;
    @Bind(value = "text", target = "firstNameTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField firstNameTextField;
    @Bind(value = "text", target = "lastNameTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField lastNameTextField;
    @Bind(value = "selected", target = "administratorRadioButton.value", type = BindingType.BI_DIRECTIONAL)
    private JRadioButton administratorRadioButton;
    @Bind(value = "selected", target = "refereeRadioButton.value", type = BindingType.BI_DIRECTIONAL)
    private JRadioButton refereeRadioButton;
    @Bind(value = "selected", target = "tournament_OrganizerRadioButton.value", type = BindingType.BI_DIRECTIONAL)
    private JRadioButton tournament_OrganizerRadioButton;
    AdministratorViewModel administratorViewModel;

    public AdministratorView() {
        app.ViewModel.single_point_access.GUIFrameSinglePointAccess.changePanel(panel, "Administrator Panel");
        administratorViewModel = new AdministratorViewModel();
        administratorViewModel.commandCreateUserTable.execute(null);
        ButtonGroup group = new ButtonGroup();
        group.add(refereeRadioButton);
        group.add(tournament_OrganizerRadioButton);
        group.add(administratorRadioButton);
        try {
            Binder.bind(this, administratorViewModel);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administratorViewModel.addUserButton.execute(null);
            }
        });
        updateUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administratorViewModel.updateUserButton.execute(null);
            }
        });
        deleteUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administratorViewModel.deleteUserButton.execute(null);
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginView();
            }
        });
        usersTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                administratorViewModel.fillFields.execute(null);
            }
        });
    }
}
