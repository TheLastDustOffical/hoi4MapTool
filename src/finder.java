import java.io.IOException;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class finder {
    public static void find() {
        // Pfade anpassen
        String eingabeOrdnerPfad = "C:\\Program Files (x86)\\Steam\\steamapps\\common\\Hearts of Iron IV\\history\\states";
        String ausgabeOrdnerPfad = "C:\\Users\\TheLastDust\\Desktop\\TEST";

        // Suchwort

        String ausTag = ui.getTag();
        String suchwort = "owner = " + ausTag;

        try {
            Files.walk(Paths.get(eingabeOrdnerPfad))
                    .filter(Files::isRegularFile)
                    .filter(file -> file.toString().endsWith(".txt"))
                    .filter(file -> enthältSuchwort(file, suchwort))
                    .forEach(file -> kopiereDatei(file, ausgabeOrdnerPfad));

            System.out.println("Suche abgeschlossen und Dateien kopiert.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean enthältSuchwort(Path dateiPfad, String suchwort) {
        try {
            return Files.lines(dateiPfad, StandardCharsets.UTF_8)
                    .anyMatch(line -> line.contains(suchwort));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void kopiereDatei(Path quelle, String zielOrdner) {
        try {
            Path ziel = Paths.get(zielOrdner, quelle.getFileName().toString());
            Files.copy(quelle, ziel, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Datei " + quelle.getFileName() + " erfolgreich kopiert.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

