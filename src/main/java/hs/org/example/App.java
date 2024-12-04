package hs.org.example;
import hs.org.example.model.Player;
import hs.org.example.service.xml.ExporterService;
import hs.org.example.service.xml.ImportService;
import jakarta.xml.bind.JAXBException;

/**
 * A fő alkalmazás osztály, amely kezeli az adat exportálását és importálását.
 */
final class App {
    private App() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static void main(final String[] args) throws JAXBException {
        ExporterService exporterService = new ExporterService();
        exporterService.exportData(getplayer());
        ImportService importService = new ImportService();
        String fileName = "Plaxer.xml";
        Player player = importService.importData(fileName);
        System.out.println(player);
    }

/**
 * Létrehoz és visszaad egy Player objektumot.
 */
    private static Player getplayer() {

        return new Player("Player", "");
    }
}
