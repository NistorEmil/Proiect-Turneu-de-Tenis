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

public class CommandSaveAsXml implements ICommand {
    private TournamentOrganizerViewModel tournamentOrganizerViewModel;
    private TennisMatchServiceInterface tennisMatchService = ServiceSinglePointAccess.getTennisMatchService();

    public CommandSaveAsXml() {
    }

    public CommandSaveAsXml(TournamentOrganizerViewModel tournamentOrganizerViewModel) {
        this.tournamentOrganizerViewModel = tournamentOrganizerViewModel;
    }

    @Override
    public void execute(Referee referee) {
        List<TennisMatch> objects = tennisMatchService.findAll();
        Collections.sort(objects);
        try (FileWriter writer = new FileWriter("output.xml")) {
            writer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.append("<tennisMatchList>\n");
            for (TennisMatch obj : objects) {
                writer.append("  <tennisMatch>\n");
                writer.append("    <id>").append(String.valueOf(obj.getId())).append("</id>\n");
                writer.append("    <firstPlayer>").append(String.valueOf(obj.getTennisPlayer1().getId())).append("</firstPlayer>\n");
                writer.append("    <secondPlayer>").append(String.valueOf(obj.getTennisPlayer2().getId())).append("</secondPlayer>\n");
                writer.append("    <referee>").append(String.valueOf(obj.getReferee().getId())).append("</referee>\n");
                writer.append("  </tennisMatch>\n");
            }
            writer.append("</tennisMatchList>\n");
            System.out.println("XML file saved successfully!");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Error saving XML file: " + ex.getMessage());
        }
    }
}
