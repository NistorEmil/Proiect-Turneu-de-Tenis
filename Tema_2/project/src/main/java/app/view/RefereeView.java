package app.view;

import app.ViewModel.RefereeViewModel;
import app.model.Referee;
import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.Binder;
import net.sds.mvvm.bindings.BindingType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RefereeView implements RefereeInterface {

    private JPanel panel;
    @Bind(value = "model", target = "model.value", type = BindingType.TARGET_TO_SOURCE)
    private JTable model;
    private JButton backButton;
    @Bind(value = "text", target = "scoreTextField1.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField scoreTextField1;
    @Bind(value = "text", target = "scoreTextField2.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField scoreTextField2;
    private JButton changeScoreButton;
    @Bind(value = "text", target = "idTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField idTextField;
    RefereeViewModel refereeViewModel;
    public RefereeView(Referee referee) {
        app.ViewModel.single_point_access.GUIFrameSinglePointAccess.changePanel(panel, "Referee Panel");
        refereeViewModel = new RefereeViewModel();
        refereeViewModel.commandCreateRefereeTable.execute(referee);
        try {
            Binder.bind(this, refereeViewModel);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        changeScoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refereeViewModel.changeScore.execute(null);
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
