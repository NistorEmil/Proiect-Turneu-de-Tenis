package app.ViewModel.Commands;

import app.ViewModel.TournamentOrganizerViewModel;
import app.model.Referee;
import app.ViewModel.service.TennisMatchServiceInterface;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;
import app.model.TennisMatch;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class CommandSaveAsJson implements ICommand {
    private TournamentOrganizerViewModel tournamentOrganizerViewModel;
    private TennisMatchServiceInterface tennisMatchService = ServiceSinglePointAccess.getTennisMatchService();

    public CommandSaveAsJson() {
    }

    public CommandSaveAsJson(TournamentOrganizerViewModel tournamentOrganizerViewModel) {
        this.tournamentOrganizerViewModel = tournamentOrganizerViewModel;
    }

    @Override
    public void execute(Referee referee) {
        /*
        List<TennisMatch> objects = tennisMatchService.findAll();
        Collections.sort(objects);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("output.json")) {
            gson.toJson(objects, writer);
            System.out.println("JSON file saved successfully!");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Error saving JSON file: " + ex.getMessage());
        }














         */
    }
}
