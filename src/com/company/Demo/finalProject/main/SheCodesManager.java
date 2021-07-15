package com.company.Demo.finalProject.main;




import javax.xml.bind.annotation.*;
import java.util.*;

@XmlRootElement(name="usersAndPermissions") // without name - we will get xml with class name as the root element
@XmlAccessorType(XmlAccessType.FIELD)
public class SheCodesManager  implements java.io.Serializable {

    @XmlElements({
            @XmlElement(type=Student.class),
            @XmlElement(type=Mentor.class),
            @XmlElement(type=Admin.class),
            @XmlElement(type=Allies.class)
    })
    HashMap<String, User> users;

    static User user;

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
                case 2: // login for existing user and update profile
                    sheCodesUpdateProfile ();
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
        System.out.println("    2. For Login and Update your own profile ");
        System.out.println();
    }


    private boolean registerNewGrad() {
        User user;
        String alumniId;
        String password;



        Scanner console = new Scanner(System.in);
        System.out.println("In order to register please login as Admin ");
        System.out.println("Alumni Id:");
        if (console.hasNext())
            alumniId = console.next();
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
        if(!validatePermission(alumniId,password,true)) {
            return false;
        }

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
        if (!user.setAdditionalData())
        {
            System.out.println("One of the values were not set as expected ");
            return false;
        }
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
//update to public because of Unit Test
    private boolean validatePermission(String alumniId ,  String password , boolean adminFlag ) {

        for (User AdminUser : users.values()) {
            if (adminFlag){
                if (AdminUser.getAlumniId().equals(alumniId) && AdminUser.getPassword().equals(password) && AdminUser.getType().equals("Admin")) {
                    System.out.println("user and password are correct and type is Admin ");
                    return true;
                }
            }
            else {
                if (AdminUser.getAlumniId().equals(alumniId) && AdminUser.getPassword().equals(password)) {
                    System.out.println("user and password are correct ");
                    return true;
                }
            }
        }
        System.out.println("user or password wrong ");
        return false;
    }



    private User getUserByAlumniId(String alumniId) {
            if (users.containsKey(alumniId)) {
                return users.get(alumniId);
            } else {
                System.out.println("Invalid alumniId. Aborting...");
                return null;
            }

    }



    private boolean sheCodesUpdateProfile()
    {
        String alumniId = login();
        if (alumniId.isEmpty()) { return false; }

        //Update Profile
        updateProfile(alumniId);
        return true;


    }

    private String login()
    {
        String alumniId;
        String password;
        Scanner console = new Scanner(System.in);
        System.out.println();
        System.out.println("alumni Id:");
        if (console.hasNext())
            alumniId = console.next();
        else {
            System.out.println("Invalid alumni Id. Aborting...");
            return "";
        }

        System.out.println("Password:");
        if (console.hasNext())
            password = console.next();
        else {
            System.out.println("Invalid password. Aborting...");
            return "";
        }

        if(!validatePermission(alumniId ,password,false)) {
            return "";
        }
        return alumniId;


    }
    private void updateProfile( String alumniId)
    {
        User user = getUserByAlumniId(alumniId);

        Scanner console = new Scanner(System.in);
        Integer selectedOption;
        boolean updateFlag = true;

        while (updateFlag) {
            System.out.println("Which category you want to update");
            System.out.println("    1. Update Password ");
            System.out.println("    2. LinkedIn Page ");
            System.out.println("    3ר. EXIT  ");
            System.out.println();

            selectedOption = console.nextInt();
            //TODO for next week
            switch (selectedOption) {
                case 1:
                    updatePassword (user);
                    break;
                case 2:
                    updateLinedIn (user);
                    break;
                default:
                    updateFlag = false ;
                    break;

            }
        }



        SerializationService.getInstance().serializeUser( this);
    }

    private void updatePassword( User user)
    {
        Scanner console = new Scanner(System.in);
        System.out.println("Please enter new password");
        String newPassword = console.next();
        user.setPassword(newPassword);
    }

    private void updateLinedIn( User user)
    {
        Scanner console = new Scanner(System.in);
        System.out.println("Please enter new LinkedIn");
        String newLink = console.next();
        user.setLinkedInPage(newLink);
    }



}
