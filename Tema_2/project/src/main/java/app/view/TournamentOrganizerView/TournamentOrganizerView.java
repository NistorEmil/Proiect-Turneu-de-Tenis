package app.view.TournamentOrganizerView;

import app.ViewModel.TournamentOrganizerViewModel;
import app.view.LoginView;
import app.view.TournamentOrganizerInterface;
import net.sds.mvvm.bindings.Binder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TournamentOrganizerView implements TournamentOrganizerInterface {
    private JPanel panel;
    private JButton refereeCRUDButton;
    private JButton tennisMatchCRUDButton;
    private JButton tennisPlayerCRUDButton;
    private JButton backButton;
    private JButton generateProgramButton;
    private TournamentOrganizerViewModel tournamentOrganizerViewModel;

    public TournamentOrganizerView() {
        app.ViewModel.single_point_access.GUIFrameSinglePointAccess.changePanel(panel, "TournamentOrganizer Panel");
        tournamentOrganizerViewModel = new TournamentOrganizerViewModel();
        tournamentOrganizerViewModel.saveAsCsv.execute(null);
        tournamentOrganizerViewModel.saveAsXml.execute(null);
        tournamentOrganizerViewModel.saveAsJson.execute(null);
        try {
            Binder.bind(this, tournamentOrganizerViewModel);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        refereeCRUDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tournamentOrganizerViewModel.refereeCRUDButton.execute(null);
            }
        });
        tennisPlayerCRUDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tournamentOrganizerViewModel.tennisPlayerCRUDButton.execute(null);
            }
        });
        tennisMatchCRUDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tournamentOrganizerViewModel.tennisMatchCRUDButton.execute(null);
            }
        });
        generateProgramButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tournamentOrganizerViewModel.generateProgramButton.execute(null);
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
