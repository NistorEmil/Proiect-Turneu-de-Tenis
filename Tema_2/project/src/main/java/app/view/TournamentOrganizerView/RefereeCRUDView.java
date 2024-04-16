package app.view.TournamentOrganizerView;

import app.ViewModel.RefereeCRUDViewModel;
import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.Binder;
import net.sds.mvvm.bindings.BindingType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RefereeCRUDView{
    @Bind(value = "text", target = "firstName.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField firstName;
    @Bind(value = "text", target = "lastName.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField lastName;
    @Bind(value = "text", target = "id.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField id;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JPanel panel;
    private JButton backButton;
    @Bind(value = "model", target = "model.value", type = BindingType.TARGET_TO_SOURCE)
    @Bind(value = "selectedRow", target = "row.value", type = BindingType.BI_DIRECTIONAL)
    //@Bind(value = "selectedColumn", target = "column.value", type = BindingType.BI_DIRECTIONAL)
    private JTable model;
    private RefereeCRUDViewModel refereeCRUDViewModel;

    public RefereeCRUDView() {
        app.ViewModel.single_point_access.GUIFrameSinglePointAccess.changePanel(panel, "Referee CRUD Panel");
        refereeCRUDViewModel = new RefereeCRUDViewModel();
        refereeCRUDViewModel.commandCreateRefereeTable.execute(null);
        try {
            Binder.bind(this, refereeCRUDViewModel);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refereeCRUDViewModel.addButton.execute(null);
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refereeCRUDViewModel.updateButton.execute(null);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refereeCRUDViewModel.deleteButton.execute(null);
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
                refereeCRUDViewModel.fillFields.execute(null);
            }
        });
    }

}
