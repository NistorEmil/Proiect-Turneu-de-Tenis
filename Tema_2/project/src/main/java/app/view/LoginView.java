package app.view;

import app.ViewModel.LoginViewModel;
import app.ViewModel.single_point_access.GUIFrameSinglePointAccess;
import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.Binder;
import net.sds.mvvm.bindings.BindingType;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView {
    @Bind(value = "text", target = "textField1.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField textField1;
    private JButton loginButton;
    @Bind(value = "text", target = "passwordField1.value", type = BindingType.BI_DIRECTIONAL)
    private JPasswordField passwordField1;
    private JPanel panel;
    private JButton inscriereTurneuButton;
    private JButton vizualizareProgramButton;
    private JButton scoreButton;
    private LoginViewModel loginViewModel;

    public LoginView() {
        GUIFrameSinglePointAccess.changePanel(panel, "Login Panel");
        loginViewModel = new LoginViewModel();
        try {
            Binder.bind(this, loginViewModel);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        inscriereTurneuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TennisPlayer tennisPlayer = registerPresenter.tournamentRegistration();
                loginViewModel.registerCommand.execute(null);
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginViewModel.loginCommand.execute(null);
            }
        });

        vizualizareProgramButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginViewModel.tournamentProgramCommand.execute(null);
            }
        });

        scoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginViewModel.scoreCommand.execute(null);
            }
        });

    }
}