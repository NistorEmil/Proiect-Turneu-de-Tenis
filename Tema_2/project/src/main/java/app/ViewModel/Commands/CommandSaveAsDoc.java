package app.ViewModel.Commands;

import app.ViewModel.TournamentOrganizerViewModel;
import app.model.*;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import app.ViewModel.service.TennisMatchServiceInterface;
import app.ViewModel.single_point_access.ServiceSinglePointAccess;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class CommandSaveAsDoc implements ICommand {
    private TournamentOrganizerViewModel tournamentOrganizerViewModel;
    private TennisMatchServiceInterface tennisMatchService = ServiceSinglePointAccess.getTennisMatchService();

    public CommandSaveAsDoc() {
    }

    public  CommandSaveAsDoc(TournamentOrganizerViewModel tournamentOrganizerViewModel) {
        this.tournamentOrganizerViewModel = tournamentOrganizerViewModel;
    }

    @Override
    public void execute(Referee referee) {
    /*
        List<TennisMatch> objects = tennisMatchService.findAll();
        Collections.sort(objects);

        try (XWPFDocument document = new XWPFDocument()) {
            XWPFTable table = document.createTable(objects.size() + 1, 4);

            // Set column names
            XWPFTableRow headerRow = table.getRow(0);
            headerRow.getCell(0).setText("ID");
            headerRow.getCell(1).setText("Tennis Player1");
            headerRow.getCell(2).setText("Tennis Player1");
            headerRow.getCell(3).setText("Referee");

            // Populate data
            for (int i = 0; i < objects.size(); i++) {
                TennisMatch obj = objects.get(i);
                XWPFTableRow row = table.getRow(i + 1);
                row.getCell(0).setText(String.valueOf(obj.getId()));
                row.getCell(1).setText(obj.getTennisPlayer1().toString());
                row.getCell(2).setText(obj.getTennisPlayer2().toString());
                row.getCell(3).setText(obj.getReferee().toString());
            }

            // Write to file
            try (FileOutputStream out = new FileOutputStream("output.docx")) {
                document.write(out);
            }
            System.out.println("DOC file saved successfully!");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Error saving DOC file: " + ex.getMessage());
        }


     */
    }
}
