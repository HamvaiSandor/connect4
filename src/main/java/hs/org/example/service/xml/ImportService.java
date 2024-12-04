package hs.org.example.service.xml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import hs.org.example.model.Player;

import java.io.File;

/**
 * Import szolgáltatás a Player objektumok XML fájlból történő
 * beolvasásához.
 */
public class ImportService {

/**
 * Importálja a megadott fájlban található játékos adatokat.
 */
    public Player importData(final String fileName) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Player.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Player) unmarshaller.unmarshal(new File(fileName));



    }
}
