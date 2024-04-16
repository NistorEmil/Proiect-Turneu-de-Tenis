package app.ViewModel.Commands;

import app.ViewModel.GenerateProgramViewModel;
import app.model.CategoryType;
import app.model.Referee;
import app.model.TennisMatch;
import app.model.TennisPlayer;
import app.ViewModel.service.RefereeServiceInterface;
import app.ViewModel.service.TennisPlayerServiceInterface;
import app.ViewModel.single_point_access.GUIFrameSinglePointAccess;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;

import javax.swing.table.DefaultTableModel;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommandCreateLast4Table implements ICommand{
    private GenerateProgramViewModel generateProgramViewModel;
    private TennisPlayerServiceInterface tennisPlayerService = ServiceSinglePointAccess.getTennisPlayerService();
    private RefereeServiceInterface refereeService = ServiceSinglePointAccess.getRefereeService();

    public CommandCreateLast4Table() {
    }

    public CommandCreateLast4Table(GenerateProgramViewModel generateProgramViewModel) {
        this.generateProgramViewModel = generateProgramViewModel;
    }

    @Override
    public void execute(Referee referee) {
        List<TennisPlayer> selectedPlayers = new ArrayList<>();
        Integer id1 = Integer.parseInt(generateProgramViewModel.getLast4TextField1());
        Integer id2 = Integer.parseInt(generateProgramViewModel.getLast4TextField2());
        Integer id3 = Integer.parseInt(generateProgramViewModel.getLast4TextField3());
        Integer id4 = Integer.parseInt(generateProgramViewModel.getLast4TextField4());
        selectedPlayers.add(tennisPlayerService.findById(id1));
        selectedPlayers.add(tennisPlayerService.findById(id2));
        selectedPlayers.add(tennisPlayerService.findById(id3));
        selectedPlayers.add(tennisPlayerService.findById(id4));
        List<TennisMatch> tennisMatches = generateLast2(selectedPlayers);

        Object[][] matchesData = new Object[tennisMatches.size()][5];

        for (int i = 0; i < tennisMatches.size(); i++) {
            matchesData[i][0] = tennisMatches.get(i).getTime();
            matchesData[i][1] = tennisMatches.get(i).getTennisPlayer1().getId();
            matchesData[i][2] = tennisMatches.get(i).getTennisPlayer2().getId();
            matchesData[i][3] = tennisMatches.get(i).getReferee().getId();
            matchesData[i][4] = tennisMatches.get(i).getId();
        }

        String[] cols = {"Time", "First Player", "Second Player", "Referee", "Id"};
        generateProgramViewModel.setLast4Table(new DefaultTableModel(matchesData, cols));
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
}
