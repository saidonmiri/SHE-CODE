package com.company.Demo.FinalProject;




import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.*;

@XmlRootElement(name="usersAndPermissions") // without name - we will get xml with class name as the root element
@XmlAccessorType(XmlAccessType.FIELD)
public class SheCodesManager  implements Serializable {

    @XmlElements({
            @XmlElement(name = "Student", type=Student.class),
            @XmlElement(name = "Mentor", type=Mentor.class)
    })
    private HashMap<String, User> users;

    private User user;

    public SheCodesManager() {
        users = new HashMap<String, User>();
    }


    public void startSheCodesManagement() {
        Scanner console = new Scanner(System.in);

        while (true) {

            printLoginMenu();
            Integer selectedOption = console.nextInt();

            switch (selectedOption) {
                case 1: //register new graduate , can be created only by Admin
                    registerNewGrad ();
                    break;
                case 2: // login for existing user
                    sheCodesLogin ();
                    break;
                case 3: // register with different user
                    //switchUser ();
                    break;
                default:
                    System.exit(0);
            }
        }

    }


    private void printLoginMenu()
    {
        System.out.println();
        System.out.println();
        System.out.println("Do you want to registers or login?");
        System.out.println("    1. For Registration(Only for Admin) ");
        System.out.println("    2. For Login ");
        System.out.println();
    }


    private boolean registerNewGrad() {
        User user;
        String username;
        String password;
        boolean allSet;


        Scanner console = new Scanner(System.in);
        System.out.println("In order to register please login as Admin ");
        System.out.println("User Name:");
        if (console.hasNext())
            username = console.next();
        else {
            System.out.println("Invalid user name. Aborting...");
            return false;
        }

        System.out.println("Password:");
        if (console.hasNext())
            password = console.next();
        else {
            System.out.println("Invalid password. Aborting...");
            return false;
        }

        //Validate if user is admin
//        if(!validateAdminPermission(username)) {
//            return false;
//        }

        System.out.println("User type you want to add?");
        System.out.println("( 1. Student  2. Mentor   3. Allies )");
        int newTypeNumber = -1;
        if (console.hasNextInt())
            newTypeNumber = console.nextInt();
        else {
            System.out.println("Invalid user type. Aborting...");
            return false;
        }
        user = UserFactory.createUser(newTypeNumber);

        if (user == null) {
            System.out.println("Invalid user type. Aborting...");
            return false;
        }
        user.setUserDetails();
        user.setAdditionalData();
        if (users.containsKey(user.getAlumniId())) {
            System.out.println("User "+ user.getAlumniId() +" already exist. Aborting...");
            return false;
        }

        user.setType(user.getClass().getSimpleName());
        users.put(user.getAlumniId(), user);



        SerializationService.getInstance().serializeUser( this);


        user.printUserDetails();

        return true;
    }

    private boolean validateAdminPermission(String user )
    {


            if (users.containsKey(user)  ) {
                return true;
            } else {
                System.out.println("user is not Admin");
                return false;
            }

    }

    private boolean sheCodesLogin() {

        String username;
        String password;
        Scanner console = new Scanner(System.in);
        System.out.println();
        System.out.println("User Name:");
        if (console.hasNext())
            username = console.next();
        else {
            System.out.println("Invalid user name. Aborting...");
            return false;
        }

        System.out.println("Password:");
        if (console.hasNext())
            password = console.next();
        else {
            System.out.println("Invalid password. Aborting...");
            return false;
        }

        //TODO Validate if user and password is correct
//        if(!validateAuthorization(username)) {
//            return false;
//        }

        return true;
    }





}
