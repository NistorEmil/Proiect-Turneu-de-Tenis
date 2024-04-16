package app.ViewModel.Commands;

import app.ViewModel.TournamentOrganizerViewModel;
import app.model.Referee;
import app.model.TennisMatch;
import app.ViewModel.service.TennisMatchServiceInterface;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class CommandSaveAsCsv implements ICommand {
    private TournamentOrganizerViewModel tournamentOrganizerViewModel;
    private TennisMatchServiceInterface tennisMatchService = ServiceSinglePointAccess.getTennisMatchService();

    public CommandSaveAsCsv() {
    }

    public  CommandSaveAsCsv(TournamentOrganizerViewModel tournamentOrganizerViewModel) {
        this.tournamentOrganizerViewModel = tournamentOrganizerViewModel;
    }

    @Override
    public void execute(Referee referee) {
        List<TennisMatch> tennisMatches = tennisMatchService.findAll();
        Collections.sort(tennisMatches);
        try (FileWriter writer = new FileWriter("output.csv")) {
            for (TennisMatch tennisMatch : tennisMatches) {
                writer.append(tennisMatch.toString());
                writer.append("\n");
            }
            System.out.println("CSV file saved successfully!");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Error saving CSV file: " + ex.getMessage());
        }
    }
}
