package com.company.Demo.finalProject;



import javax.xml.bind.*;
import java.io.File;


public class SerializationService {
    private static SerializationService ourInstance = new SerializationService();

    public static final String FILE_NAME = "usersAndPermissions.xml";

    public static SerializationService getInstance() {
        return ourInstance;
    }

    private SerializationService() {
    }


    public static SheCodesManager unserializeUser() {
        File f = new File(FILE_NAME);
        if(f.exists()) {
            SheCodesManager e = null;
            JAXBContext jaxbContext = null;
            try {
                jaxbContext = JAXBContext.newInstance(SheCodesManager.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                e = (SheCodesManager) jaxbUnmarshaller.unmarshal( new File(FILE_NAME) );
            } catch (JAXBException e1) {
                e1.printStackTrace();
            }
            return e;
        }
        else
        {
            return new SheCodesManager();
        }

    }


    public static void serializeUser( SheCodesManager usersAndPermissions) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance( SheCodesManager.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(usersAndPermissions, new File(FILE_NAME)); //format the resulting XML data with line breaks and indentation
            //jaxbMarshaller.marshal( usersAndPermissions, System.out ); //Marshal and print to console
        } catch (PropertyException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
