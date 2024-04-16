package app.ViewModel.Commands;

import app.ViewModel.TournamentProgramViewModel;
import app.model.CategoryType;
import app.model.Referee;
import app.model.TennisMatch;
import app.model.TennisPlayer;
import app.ViewModel.service.RefereeServiceInterface;
import app.ViewModel.service.TennisPlayerServiceInterface;
import app.ViewModel.single_point_access.GUIFrameSinglePointAccess;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class CommandCreateTournamentProgram implements ICommand{
    private TournamentProgramViewModel tournamentProgramViewModel;
    private TennisPlayerServiceInterface tennisPlayerService = ServiceSinglePointAccess.getTennisPlayerService();
    private RefereeServiceInterface refereeService = ServiceSinglePointAccess.getRefereeService();

    public CommandCreateTournamentProgram() {
    }

    public CommandCreateTournamentProgram(TournamentProgramViewModel tournamentProgramViewModel) {
        this.tournamentProgramViewModel = tournamentProgramViewModel;
    }


    @Override
    public void execute(Referee referee) {
        List<TennisMatch> tennisMatches = generateLast8();
        if(tennisMatches != null)
        {
            int matchNumber = 1;
            Object[][] tennisMachesTablee = new Object[200][5];
            tennisMachesTablee[0][0] = "Last 16";
            if (tennisMatches != null) {
                for (int i = 0; i < tennisMatches.size(); i++) {
                    tennisMachesTablee[i+1][0] = matchNumber;
                    tennisMachesTablee[i+1][1] = tennisMatches.get(i).getTime();
                    tennisMachesTablee[i+1][2] = tennisMatches.get(i).getTennisPlayer1().getId();
                    tennisMachesTablee[i+1][3] = tennisMatches.get(i).getTennisPlayer2().getId();
                    tennisMachesTablee[i+1][4] = tennisMatches.get(i).getReferee().getId();
                    matchNumber++;
                }
            }
            tennisMachesTablee[9][0] = "Last 8";
            int hour = 16;
            int row = 10;
            int j = 1;
            for(int i = 0; i < 4; i++)
            {
                tennisMachesTablee[row][0] = matchNumber;
                tennisMachesTablee[row][1] = LocalTime.of(hour, 0);
                tennisMachesTablee[row][2] = "Match Winner " + j;
                j++;
                tennisMachesTablee[row][3] = "Match Winner "+ j;
                j++;
                hour++;
                row++;
                matchNumber++;
            }
            tennisMachesTablee[14][0] = "Semi Final";
            hour = 20;
            row = 15;
            j = 9;
            for(int i = 0; i < 2; i++)
            {
                tennisMachesTablee[row][0] = matchNumber;
                tennisMachesTablee[row][1] = LocalTime.of(hour, 0);
                tennisMachesTablee[row][2] = "Match Winner " + j;
                j++;
                tennisMachesTablee[row][3] = "Match Winner "+ j;
                j++;
                hour++;
                row++;
                matchNumber++;
            }
            tennisMachesTablee[row][0] = "Final";
            tennisMachesTablee[++row][0] = matchNumber;
            tennisMachesTablee[row][1] = LocalTime.of(22, 0);
            tennisMachesTablee[row][2] = "Match Winner " + j;
            j++;
            tennisMachesTablee[row][3] = "Match Winner "+ j;

            String[] cols = {"Match", "Time", "First Player", "Second Player", "Referee"};
            tournamentProgramViewModel.setModel(new DefaultTableModel(tennisMachesTablee, cols));
        }
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
}
