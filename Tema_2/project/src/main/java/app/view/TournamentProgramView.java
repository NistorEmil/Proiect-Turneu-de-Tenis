package app.view;

import app.ViewModel.TournamentProgramViewModel;
import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.Binder;
import net.sds.mvvm.bindings.BindingType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TournamentProgramView implements TournamentProgramInterface {
    private JPanel panel;
    @Bind(value = "model", target = "model.value", type = BindingType.TARGET_TO_SOURCE)
    private JTable model;
    private JButton backButton;
    TournamentProgramViewModel tournamentProgramViewModel;

    public TournamentProgramView() {
        app.ViewModel.single_point_access.GUIFrameSinglePointAccess.changePanel(panel, "Tennis Tournament Panel");
        tournamentProgramViewModel = new TournamentProgramViewModel();
        tournamentProgramViewModel.createTableCommand.execute(null);
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
