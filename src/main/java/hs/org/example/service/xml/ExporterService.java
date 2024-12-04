package hs.org.example.service.xml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import hs.org.example.model.Player;

import java.io.File;

/**
 * Exportálási szolgáltatás a Player objektumok XML formátumba
 * történő exportálásához.
 */

public class ExporterService {

/**
 * Exportálja a megadott játékos adatokat egy XML fájlba.
 */

    public void exportData(final Player player) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Player.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        marshaller.marshal(player, new File("player.xml"));
    }
}
