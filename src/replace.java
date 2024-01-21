import java.io.IOException;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Scanner;

public class replace {
    public static void replacer() {
        String ordnerPfad = "C:\\Users\\TheLastDust\\Documents\\Paradox Interactive\\Hearts of Iron IV\\mod\\SpeedMap\\history\\states";
        String ausTag = ui.getTag();

        Scanner scan = new Scanner (System.in);

        System.out.println("Please enter the replacement tag: ");
        String ausRepTag = scan.next();


        String suchtext = ausTag;
        String ersetzung = ausRepTag;

        ersetzeAlleTexteImOrdner(ordnerPfad, suchtext, ersetzung);
    }

    public static void ersetzeAlleTexteImOrdner(String ordnerPfad, String suchtext, String ersetzung) {
        try (Stream<Path> dateien = Files.walk(Paths.get(ordnerPfad))) {
            dateien.filter(Files::isRegularFile)
                    .filter(file -> file.toString().endsWith(".txt"))
                    .forEach(file -> ersetzeText(file, suchtext, ersetzung));

            System.out.println("Suchtext in allen Textdateien im Ordner erfolgreich ersetzt.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ersetzeText(Path dateiPfad, String suchtext, String ersetzung) {
        try {
            List<String> zeilen = Files.lines(dateiPfad, StandardCharsets.UTF_8)
                    .map(line -> line.replace(suchtext, ersetzung))
                    .collect(Collectors.toList());

            Files.write(dateiPfad, zeilen, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
