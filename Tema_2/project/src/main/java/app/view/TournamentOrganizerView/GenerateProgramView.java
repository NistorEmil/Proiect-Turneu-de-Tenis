package app.view.TournamentOrganizerView;

import app.ViewModel.GenerateProgramViewModel;
import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.Binder;
import net.sds.mvvm.bindings.BindingType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GenerateProgramView {

    private JButton backButton;
    private JPanel panel;
    @Bind(value = "model", target = "last16Table.value", type = BindingType.TARGET_TO_SOURCE)
    @Bind(value = "selectedRow", target = "rowLast16Table.value", type = BindingType.BI_DIRECTIONAL)
    private JTable last16Table;
    @Bind(value = "model", target = "last8Table.value", type = BindingType.TARGET_TO_SOURCE)
    @Bind(value = "selectedRow", target = "rowLast8Table.value", type = BindingType.BI_DIRECTIONAL)
    private JTable last8Table;
    @Bind(value = "model", target = "last4Table.value", type = BindingType.TARGET_TO_SOURCE)
    @Bind(value = "selectedRow", target = "rowLast4Table.value", type = BindingType.BI_DIRECTIONAL)
    private JTable last4Table;
    private JButton generateLast8Button;
    private JButton generateLast4Button;
    @Bind(value = "text", target = "player4TextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField player4TextField;
    @Bind(value = "text", target = "player3TextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField player3TextField;
    @Bind(value = "text", target = "player2TextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField player2TextField;
    @Bind(value = "text", target = "player1TextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField player1TextField;
    @Bind(value = "text", target = "player5TextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField player5TextField;
    @Bind(value = "text", target = "player6TextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField player6TextField;
    @Bind(value = "text", target = "player7TextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField player7TextField;
    @Bind(value = "text", target = "player8TextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField player8TextField;
    @Bind(value = "text", target = "last4TextField1.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField last4TextField1;
    @Bind(value = "text", target = "last4TextField2.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField last4TextField2;
    @Bind(value = "text", target = "last4TextField3.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField last4TextField3;
    @Bind(value = "text", target = "last4TextField4.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField last4TextField4;
    @Bind(value = "model", target = "finalTable.value", type = BindingType.TARGET_TO_SOURCE)
    @Bind(value = "selectedRow", target = "rowLast2Table.value", type = BindingType.BI_DIRECTIONAL)
    private JTable finalTable;
    @Bind(value = "text", target = "last2TextField1.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField last2TextField1;
    @Bind(value = "text", target = "last2TextField2.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField last2TextField2;
    private JButton generateLast2Button;
    @Bind(value = "text", target = "winnerTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField winnerTextField;
    private GenerateProgramViewModel generateProgramViewModel;

    public GenerateProgramView() {
        app.ViewModel.single_point_access.GUIFrameSinglePointAccess.changePanel(panel, "Tennis Tournament Panel");
        generateProgramViewModel = new GenerateProgramViewModel();
        generateProgramViewModel.generateLast16Button.execute(null);
        try {
            Binder.bind(this, generateProgramViewModel);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        generateLast8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateProgramViewModel.generateLast8Button.execute(null);
            }
        });
        generateLast4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateProgramViewModel.generateLast4Button.execute(null);
            }
        });
        generateLast2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateProgramViewModel.generateLast2Button.execute(null);
            }
        });
        last16Table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                generateProgramViewModel.fillFields16.execute(null);
            }
        });
        last8Table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                generateProgramViewModel.fillFields8.execute(null);
            }
        });
        last4Table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                generateProgramViewModel.fillFields4.execute(null);
            }
        });
        finalTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                generateProgramViewModel.fillFields2.execute(null);
            }
        });
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new TournamentOrganizerView();
            }
        });
    }
}
        /*
        List<TennisMatch> tennisMatches = generateProgramPresenter.generateLast8();
        if(tennisMatches != null) {
            Object[][] tennisMachesTablee = new Object[200][5];
            if (tennisMatches != null) {
                for (int i = 0; i < tennisMatches.size(); i++) {
                    tennisMachesTablee[i][0] = tennisMatches.get(i).getTime();
                    tennisMachesTablee[i][1] = tennisMatches.get(i).getTennisPlayer1().getId();
                    tennisMachesTablee[i][2] = tennisMatches.get(i).getTennisPlayer2().getId();
                    tennisMachesTablee[i][3] = tennisMatches.get(i).getReferee().getId();
                }
            }
            String[] cols = {"Time", "First Player", "Second Player", "Referee"};
            this.last16Table.setModel(new DefaultTableModel(tennisMachesTablee, cols));
            List<TennisPlayer> selectedPlayers = new ArrayList<>();
            this.last16Table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        // Obținem rândul selectat
                        int selectedRow = last16Table.getSelectedRow();

                        // Verificăm dacă un rând este selectat
                        if (selectedRow != -1) {
                            DefaultTableModel model = (DefaultTableModel) last16Table.getModel();

                            int playerId;
                            // Obținem coloana selectata
                            int selectedColumn = last16Table.getSelectedColumn();

                            playerId = (int) model.getValueAt(selectedRow, selectedColumn);
                            selectedPlayers.add(generateProgramPresenter.findTennisPlayerById(playerId));
                            switch (selectedRow) {
                                case 0:
                                    player1TextField.setText(String.valueOf(playerId));
                                    break;
                                case 1:
                                    player2TextField.setText(String.valueOf(playerId));
                                    break;
                                case 2:
                                    player3TextField.setText(String.valueOf(playerId));
                                    break;
                                case 3:
                                    player4TextField.setText(String.valueOf(playerId));
                                    break;
                                case 4:
                                    player5TextField.setText(String.valueOf(playerId));
                                    break;
                                case 5:
                                    player6TextField.setText(String.valueOf(playerId));
                                    break;
                                case 6:
                                    player7TextField.setText(String.valueOf(playerId));
                                    break;
                                case 7:
                                    player8TextField.setText(String.valueOf(playerId));
                                    break;
                            }
                        }
                    }
                }
            });
            generateLast8Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        List<TennisMatch> tennisMatches = generateProgramPresenter.generateLast4(selectedPlayers);
                        // Crează o nouă matrice de obiecte pentru a stoca datele pentru tabel
                        Object[][] matchesData = new Object[tennisMatches.size()][4];

                        // Populează matricea cu datele din lista de meciuri
                        for (int i = 0; i < tennisMatches.size(); i++) {
                            matchesData[i][0] = tennisMatches.get(i).getTime();
                            matchesData[i][1] = tennisMatches.get(i).getTennisPlayer1().getId();
                            matchesData[i][2] = tennisMatches.get(i).getTennisPlayer2().getId();
                            matchesData[i][3] = tennisMatches.get(i).getReferee().getId();
                        }

                        // Definirea numelor de coloane pentru tabel
                        String[] cols = {"Time", "First Player", "Second Player", "Referee"};

                        // Crearea unui nou model de tabel cu datele actualizate
                        DefaultTableModel model = new DefaultTableModel(matchesData, cols);

                        // Setarea noului model pentru tabelul last8Table
                        last8Table.setModel(model);
                    last8Table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                        @Override
                        public void valueChanged(ListSelectionEvent e) {
                            if (!e.getValueIsAdjusting()) {
                                // Obținem rândul selectat
                                int selectedRow = last8Table.getSelectedRow();

                                // Verificăm dacă un rând este selectat
                                if (selectedRow != -1) {
                                    DefaultTableModel model = (DefaultTableModel) last8Table.getModel();

                                    int playerId;
                                    // Obținem coloana selectata
                                    int selectedColumn = last8Table.getSelectedColumn();

                                    playerId = (int) model.getValueAt(selectedRow, selectedColumn);
                                    selectedPlayers.add(generateProgramPresenter.findTennisPlayerById(playerId));
                                    switch (selectedRow) {
                                        case 0:
                                            last4TextField1.setText(String.valueOf(playerId));
                                            break;
                                        case 1:
                                            last4TextField2.setText(String.valueOf(playerId));
                                            break;
                                        case 2:
                                            last4TextField3.setText(String.valueOf(playerId));
                                            break;
                                        case 3:
                                            last4TextField4.setText(String.valueOf(playerId));
                                            break;
                                    }
                                }
                            }
                        }
                    });
                }
            });
            generateLast4Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    List<TennisMatch> tennisMatches = generateProgramPresenter.generateLast2(selectedPlayers);

                    // Crează o nouă matrice de obiecte pentru a stoca datele pentru tabel
                    Object[][] matchesData = new Object[tennisMatches.size()][4];

                    // Populează matricea cu datele din lista de meciuri
                    for (int i = 0; i < tennisMatches.size(); i++) {
                        matchesData[i][0] = tennisMatches.get(i).getTime();
                        matchesData[i][1] = tennisMatches.get(i).getTennisPlayer1().getId();
                        matchesData[i][2] = tennisMatches.get(i).getTennisPlayer2().getId();
                        matchesData[i][3] = tennisMatches.get(i).getReferee().getId();
                    }

                    // Definirea numelor de coloane pentru tabel
                    String[] cols = {"Time", "First Player", "Second Player", "Referee"};

                    // Crearea unui nou model de tabel cu datele actualizate
                    DefaultTableModel model = new DefaultTableModel(matchesData, cols);

                    // Setarea noului model pentru tabelul last8Table
                    last4Table.setModel(model);

                    last4Table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                        @Override
                        public void valueChanged(ListSelectionEvent e) {
                            if (!e.getValueIsAdjusting()) {
                                // Obținem rândul selectat
                                int selectedRow = last4Table.getSelectedRow();

                                // Verificăm dacă un rând este selectat
                                if (selectedRow != -1) {
                                    DefaultTableModel model = (DefaultTableModel) last4Table.getModel();

                                    int playerId;
                                    // Obținem coloana selectata
                                    int selectedColumn = last4Table.getSelectedColumn();

                                    playerId = (int) model.getValueAt(selectedRow, selectedColumn);
                                    selectedPlayers.add(generateProgramPresenter.findTennisPlayerById(playerId));
                                    switch (selectedRow) {
                                        case 0:
                                            last2TextField1.setText(String.valueOf(playerId));
                                            break;
                                        case 1:
                                            last2TextField2.setText(String.valueOf(playerId));
                                            break;
                                    }
                                }
                            }
                        }
                    });
                }
            });
            generateLast2Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    List<TennisMatch> tennisMatches = generateProgramPresenter.generateLast1(selectedPlayers);

                    // Crează o nouă matrice de obiecte pentru a stoca datele pentru tabel
                    Object[][] matchesData = new Object[tennisMatches.size()][4];

                    // Populează matricea cu datele din lista de meciuri
                    for (int i = 0; i < tennisMatches.size(); i++) {
                        matchesData[i][0] = tennisMatches.get(i).getTime();
                        matchesData[i][1] = tennisMatches.get(i).getTennisPlayer1().getId();
                        matchesData[i][2] = tennisMatches.get(i).getTennisPlayer2().getId();
                        matchesData[i][3] = tennisMatches.get(i).getReferee().getId();
                    }

                    // Definirea numelor de coloane pentru tabel
                    String[] cols = {"Time", "First Player", "Second Player", "Referee"};

                    // Crearea unui nou model de tabel cu datele actualizate
                    DefaultTableModel model = new DefaultTableModel(matchesData, cols);

                    // Setarea noului model pentru tabelul last8Table
                    finalTable.setModel(model);

                    finalTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                        @Override
                        public void valueChanged(ListSelectionEvent e) {
                            if (!e.getValueIsAdjusting()) {
                                // Obținem rândul selectat
                                int selectedRow = finalTable.getSelectedRow();

                                // Verificăm dacă un rând este selectat
                                if (selectedRow != -1) {
                                    DefaultTableModel model = (DefaultTableModel) finalTable.getModel();

                                    int playerId;
                                    // Obținem coloana selectata
                                    int selectedColumn = finalTable.getSelectedColumn();

                                    playerId = (int) model.getValueAt(selectedRow, selectedColumn);
                                    selectedPlayers.add(generateProgramPresenter.findTennisPlayerById(playerId));
                                    switch (selectedRow) {
                                        case 0:
                                            winnerTextField.setText(String.valueOf(playerId));
                                            break;
                                    }
                                }
                            }
                        }
                    });
                }
            });
        }
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TournamentOrganizerView();
            }
        });



         */
