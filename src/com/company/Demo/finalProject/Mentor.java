package com.company.Demo.finalProject;




import com.sun.deploy.util.StringUtils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Mentor  extends User implements java.io.Serializable {

    private String courses ;
    private boolean canMentor;


    public Mentor(){}

    //no need for constructor - will be initiated by getter and setter
//    public Mentor(List courses, boolean canMentor) {
//        this.courses = courses;
//        this.canMentor = canMentor;
//    }


    public String getCourses() {
        return courses;
    }


    private boolean isCanMentor() {
        return canMentor;
    }

    private void setCourses(String courses) {
        this.courses = courses;
    }

    private void setCanMentor(boolean canMentor) {
        this.canMentor = canMentor;
    }

    @Override
    public  boolean setAdditionalData() {
        Scanner console = new Scanner(System.in);
        System.out.println("Did you mentor before(Y/N):");
        String canMentor = console.next();
        switch (canMentor.toUpperCase()) {
            case "Y":
                this.setCanMentor(true);
                break;
            case "N":
                this.setCanMentor(false);
                return false;
            default:
                System.out.println("Invalid option. Aborting...");
                return false;
        }

        //Set better than list - automatic validation that unique courses will be set
        //Set<CourseName> courseNameSet = new HashSet<>();
        List<String> courseNameSet = new ArrayList<>();
        boolean courseFlag = false;


        while (!courseFlag) {
            System.out.println("Which course you graduated : ");
            System.out.println("1. Java");
            System.out.println("2. Python");
            System.out.println("3. Web");
            System.out.println("4. DBA");
            System.out.println("5. Selection Completed - EXIT");
            Integer courseNumber = console.nextInt();
            switch (courseNumber) {
                case 1:
                    //TODO translate to string from Set
                    courseNameSet.add(CourseName.JAVA.toString());
                    break;
                case 2:
                    courseNameSet.add(CourseName.PYTHON.toString());
                    break;
                case 3:
                    courseNameSet.add(CourseName.WEB.toString());
                    break;
                case 4:
                    courseNameSet.add(CourseName.DBA.toString());
                    break;
                case 5:
                    //String listOfCourses = String.join(",", courseNameSet);
                    //
                    String courseNameString = StringUtils.join(courseNameSet, ",");
                    this.setCourses(courseNameString);
                    courseFlag= true;
                    //because graduate as least one course , can mentor although was not mentor before
                    if ( !courseNameSet.isEmpty()) {
                        System.out.println("CAN BE MENTOR");
                        this.setCanMentor(true);
                    }
                    System.out.println("Exit Course Selection...");
                    break;
                default:
                    System.out.println("Invalid Course. Aborting...");
                    return false;
            }

        }
        return true;
    }

    @Override
    public void printUserDetails()
    {
        super.printUserDetails();
        System.out.println("Can Mentor : " + this.isCanMentor());
    }
}
