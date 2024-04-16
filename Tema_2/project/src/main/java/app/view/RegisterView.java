package app.view;

import app.ViewModel.RegisterViewModel;
import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.Binder;
import net.sds.mvvm.bindings.BindingType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterView {
    private JPanel panel;
    @Bind(value = "text", target = "firstName.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField firstName;
    @Bind(value = "text", target = "age.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField age;
    @Bind(value = "text", target = "lastName.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField lastName;
    @Bind(value = "selected", target = "maleRadioButton.value", type = BindingType.BI_DIRECTIONAL)
    private JRadioButton maleRadioButton;
    @Bind(value = "selected", target = "femaleRadioButton.value", type = BindingType.BI_DIRECTIONAL)
    private JRadioButton femaleRadioButton;
    @Bind(value = "selected", target = "under18RadioButton.value", type = BindingType.BI_DIRECTIONAL)
    private JRadioButton under18RadioButton;
    private JButton backButton;
    private JButton registerButton;
    RegisterViewModel registerViewModel;

    public RegisterView() {

        app.ViewModel.single_point_access.GUIFrameSinglePointAccess.changePanel(panel, "Register Panel");
        registerViewModel = new RegisterViewModel();

        ButtonGroup group = new ButtonGroup();
        group.add(maleRadioButton);
        group.add(femaleRadioButton);
        group.add(under18RadioButton);
        try {
            Binder.bind(this, registerViewModel);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerViewModel.registerButton.execute(null);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginView();
            }
        });
    }
}
