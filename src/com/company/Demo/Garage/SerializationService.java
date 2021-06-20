package com.company.Demo.Garage;

import javax.xml.bind.*;
import java.io.*;


public class SerializationService {
    private static SerializationService ourInstance = new SerializationService();

    public static SerializationService getInstance() {
        return ourInstance;
    }

    private SerializationService() {
    }


    public static GarageManager unserializeGarage() {
        File f = new File("garage.xml");
        if(f.exists()) {
            GarageManager e = null;
            JAXBContext jaxbContext = null;
            try {
                jaxbContext = JAXBContext.newInstance(GarageManager.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                e = (GarageManager) jaxbUnmarshaller.unmarshal( new File("garage.xml") );
            } catch (JAXBException e1) {
                e1.printStackTrace();
            }
            return e;
        }
        else
        {
            return new GarageManager();
        }

    }


    public static void serializeGarage(GarageManager garage) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(GarageManager.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(garage, new File("garage.xml"));
           // jaxbMarshaller.marshal( garage, System.out );
        } catch (PropertyException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
