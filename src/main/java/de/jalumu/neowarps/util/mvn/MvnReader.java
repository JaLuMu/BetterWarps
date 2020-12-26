package de.jalumu.neowarps.util.mvn;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;

public class MvnReader {

    public static String getLatestMvnVersion(URL url) {
        BufferedReader reader = null;

        try {
            XMLStreamReader reader1 = XMLInputFactory.newInstance().createXMLStreamReader(url.openStream());
            String latest = null;
            while (reader1.hasNext()) {
                if (reader1.next() == XMLStreamConstants.START_ELEMENT) {
                    if (reader1.getLocalName().equals("latest")) {
                        latest = reader1.getElementText();
                        break;
                    }
                }
            }
            return latest;
        } catch (IOException ex) {
        } catch (XMLStreamException ex) {
        } finally {
            return null;
        }
    }

}
