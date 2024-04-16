package app.ViewModel.Commands;

import app.ViewModel.TournamentOrganizerViewModel;
import app.model.CategoryType;
import app.model.Referee;
import app.model.TennisMatch;
import app.model.TennisPlayer;
import app.ViewModel.service.RefereeServiceInterface;
import app.ViewModel.service.TennisPlayerServiceInterface;
import app.ViewModel.single_point_access.GUIFrameSinglePointAccess;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;
import app.view.TournamentOrganizerView.GenerateProgramView;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class CommandCreateProgramView implements ICommand {
    private TournamentOrganizerViewModel tournamentOrganizerViewModel;
    private RefereeServiceInterface refereeService = ServiceSinglePointAccess.getRefereeService();
    private TennisPlayerServiceInterface tennisPlayerService = ServiceSinglePointAccess.getTennisPlayerService();

    public CommandCreateProgramView() {
    }

    public CommandCreateProgramView(TournamentOrganizerViewModel tournamentOrganizerViewModel) {
        this.tournamentOrganizerViewModel = tournamentOrganizerViewModel;
    }


    @Override
    public void execute(Referee referee) {
        new GenerateProgramView();
            /*
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

             */
    }
    public List<TennisMatch> generateLast8() {
        List<TennisMatch> tennisMatches = new ArrayList<>();
        List<TennisPlayer> tennisPlayers = tennisPlayerService.findAll();
        if (tennisPlayers.size() != 16) {
            GUIFrameSinglePointAccess.showDialogMessage("Not enough players registered");
            return null;
        }
        List<Referee> referees = refereeService.findAll();
        Random random = new Random();

        // Verificăm dacă avem cel puțin 8 jucători și cel puțin 3 arbitri
        if (tennisPlayers.size() < 8 || referees.size() < 3) {

        }

        // Definim ora de start a primului meci la 10:00
        LocalTime startTime = LocalTime.of(10, 0);

        // Generăm 8 meciuri
        for (int i = 0; i < 8; i++) {
            int indexPlayer1 = random.nextInt(tennisPlayers.size());
            int indexPlayer2;
            do {
                indexPlayer2 = random.nextInt(tennisPlayers.size());
            } while (indexPlayer2 == indexPlayer1); // Asigurăm că cei doi jucători sunt diferiți

            int indexReferee = i % referees.size(); // Impartim indecsii arbitrilor pentru a ne asigura ca fiecare meci are un arbitru diferit

            // Obținem jucătorii și arbitrul corespunzători indexurilor generate
            TennisPlayer player1 = tennisPlayers.get(indexPlayer1);
            TennisPlayer player2 = tennisPlayers.get(indexPlayer2);
            Referee referee = referees.get(indexReferee);

            // Adăugăm meciul în lista de meciuri, cu timpul de start adecvat
            tennisMatches.add(new TennisMatch(player1, player2, referee, CategoryType.MALE, startTime));

            startTime = startTime.plusMinutes(50);

            // Eliminăm jucătorii din listele disponibile pentru a evita repetarea lor în alte meciuri
            tennisPlayers.remove(indexPlayer1);
            if (indexPlayer1 < indexPlayer2) {
                indexPlayer2--; // Trebuie să ajustăm indexul pentru a ține cont de faptul că eliminăm un element anterior
            }
            tennisPlayers.remove(indexPlayer2);
        }
        return tennisMatches;
    }

    public TennisPlayer findTennisPlayerById(Integer id)
    {
        return tennisPlayerService.findById(id);
    }

    public List<TennisMatch> generateLast4(List<TennisPlayer> tennisPlayers1) {
        List<TennisMatch> tennisMatches = new ArrayList<>();
        List<TennisPlayer> tennisPlayers = tennisPlayers1;
        if(tennisPlayers.size() >= 8) {
            List<Referee> referees = refereeService.findAll();
            Random random = new Random();

            // Verificăm dacă avem cel puțin 8 jucători și cel puțin 3 arbitri
            if (tennisPlayers.size() < 4 || referees.size() < 3) {

            }

            // Definim ora de start a primului meci la 10:00
            LocalTime startTime = LocalTime.of(16, 0);

            for (int i = 0; i < 4; i++) {
                int indexPlayer1 = random.nextInt(tennisPlayers.size());
                int indexPlayer2;
                do {
                    indexPlayer2 = random.nextInt(tennisPlayers.size());
                } while (indexPlayer2 == indexPlayer1); // Asigurăm că cei doi jucători sunt diferiți

                int indexReferee = i % referees.size(); // Impartim indecsii arbitrilor pentru a ne asigura ca fiecare meci are un arbitru diferit

                // Obținem jucătorii și arbitrul corespunzători indexurilor generate
                TennisPlayer player1 = tennisPlayers.get(indexPlayer1);
                TennisPlayer player2 = tennisPlayers.get(indexPlayer2);
                Referee referee = referees.get(indexReferee);

                // Adăugăm meciul în lista de meciuri, cu timpul de start adecvat
                tennisMatches.add(new TennisMatch(player1, player2, referee, CategoryType.MALE, startTime));

                startTime = startTime.plusMinutes(60);

                // Eliminăm jucătorii din listele disponibile pentru a evita repetarea lor în alte meciuri
                tennisPlayers.remove(indexPlayer1);
                if (indexPlayer1 < indexPlayer2) {
                    indexPlayer2--; // Trebuie să ajustăm indexul pentru a ține cont de faptul că eliminăm un element anterior
                }
                tennisPlayers.remove(indexPlayer2);
            }
        }
        else {
            GUIFrameSinglePointAccess.showDialogMessage("Select the winners");
        }
        return tennisMatches;

    }

    public List<TennisMatch> generateLast2(List<TennisPlayer> tennisPlayers1) {
        List<TennisMatch> tennisMatches = new ArrayList<>();
        List<TennisPlayer> tennisPlayers = tennisPlayers1;
        List<Referee> referees = refereeService.findAll();
        Random random = new Random();
        if(tennisPlayers.size() >= 4) {
            // Verificăm dacă avem cel puțin 8 jucători și cel puțin 3 arbitri
            if (tennisPlayers.size() < 2 || referees.size() < 3) {

            }

            // Definim ora de start a primului meci la 10:00
            LocalTime startTime = LocalTime.of(20, 0);

            for (int i = 0; i < 2; i++) {
                int indexPlayer1 = random.nextInt(tennisPlayers.size());
                int indexPlayer2;
                do {
                    indexPlayer2 = random.nextInt(tennisPlayers.size());
                } while (indexPlayer2 == indexPlayer1); // Asigurăm că cei doi jucători sunt diferiți

                int indexReferee = i % referees.size(); // Impartim indecsii arbitrilor pentru a ne asigura ca fiecare meci are un arbitru diferit

                // Obținem jucătorii și arbitrul corespunzători indexurilor generate
                TennisPlayer player1 = tennisPlayers.get(indexPlayer1);
                TennisPlayer player2 = tennisPlayers.get(indexPlayer2);
                Referee referee = referees.get(indexReferee);

                // Adăugăm meciul în lista de meciuri, cu timpul de start adecvat
                tennisMatches.add(new TennisMatch(player1, player2, referee, CategoryType.MALE, startTime));

                startTime = startTime.plusMinutes(60);

                // Eliminăm jucătorii din listele disponibile pentru a evita repetarea lor în alte meciuri
                tennisPlayers.remove(indexPlayer1);
                if (indexPlayer1 < indexPlayer2) {
                    indexPlayer2--; // Trebuie să ajustăm indexul pentru a ține cont de faptul că eliminăm un element anterior
                }
                tennisPlayers.remove(indexPlayer2);
            }
        }
        else
        {
            GUIFrameSinglePointAccess.showDialogMessage("Select the winners");
        }
        return tennisMatches;
    }

    public List<TennisMatch> generateLast1(List<TennisPlayer> tennisPlayers1) {
        List<TennisMatch> tennisMatches = new ArrayList<>();
        List<TennisPlayer> tennisPlayers = tennisPlayers1;
        List<Referee> referees = refereeService.findAll();
        Random random = new Random();
        if (tennisPlayers.size() >= 2) {
            // Verificăm dacă avem cel puțin 8 jucători și cel puțin 3 arbitri
            if (tennisPlayers.size() < 1 || referees.size() < 3) {

            }

            // Definim ora de start a primului meci la 10:00
            LocalTime startTime = LocalTime.of(22, 0);

            for (int i = 0; i < 1; i++) {
                int indexPlayer1 = random.nextInt(tennisPlayers.size());
                int indexPlayer2;
                do {
                    indexPlayer2 = random.nextInt(tennisPlayers.size());
                } while (indexPlayer2 == indexPlayer1); // Asigurăm că cei doi jucători sunt diferiți

                int indexReferee = i % referees.size(); // Impartim indecsii arbitrilor pentru a ne asigura ca fiecare meci are un arbitru diferit

                // Obținem jucătorii și arbitrul corespunzători indexurilor generate
                TennisPlayer player1 = tennisPlayers.get(indexPlayer1);
                TennisPlayer player2 = tennisPlayers.get(indexPlayer2);
                Referee referee = referees.get(indexReferee);

                // Adăugăm meciul în lista de meciuri, cu timpul de start adecvat
                tennisMatches.add(new TennisMatch(player1, player2, referee, CategoryType.MALE, startTime));

                startTime = startTime.plusMinutes(60);

                // Eliminăm jucătorii din listele disponibile pentru a evita repetarea lor în alte meciuri
                tennisPlayers.remove(indexPlayer1);
                if (indexPlayer1 < indexPlayer2) {
                    indexPlayer2--; // Trebuie să ajustăm indexul pentru a ține cont de faptul că eliminăm un element anterior
                }
                tennisPlayers.remove(indexPlayer2);
            }
        }
        else
        {
            GUIFrameSinglePointAccess.showDialogMessage("Select the winners");
        }
        return tennisMatches;
    }
}
