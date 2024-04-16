package app.view;

import app.ViewModel.TennisMatchesScoreViewModel;
import app.ViewModel.TournamentProgramViewModel;
import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.Binder;
import net.sds.mvvm.bindings.BindingType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TennisMatchesScoreView {
    private JPanel panel1;
    @Bind(value = "model", target = "model.value", type = BindingType.TARGET_TO_SOURCE)
    private JTable model;
    private JButton backButton;
    TennisMatchesScoreViewModel tournamentProgramViewModel;
    public TennisMatchesScoreView() {
        app.ViewModel.single_point_access.GUIFrameSinglePointAccess.changePanel(panel1, "Tennis Tournament Score Panel");
        tournamentProgramViewModel = new TennisMatchesScoreViewModel();
        tournamentProgramViewModel.createTableCommand1.execute(null);
        try {
            Binder.bind(this, tournamentProgramViewModel);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginView();
            }
        });
    }
}
