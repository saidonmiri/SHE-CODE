package com.company.Demo.FinalProject;




import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Mentor  extends User implements  Volunteers ,java.io.Serializable {

    private Set courses ;
    private boolean canMentor;


    public Mentor(){}

    //no need for constructor - will be initiated by getter and setter
//    public Mentor(List courses, boolean canMentor) {
//        this.courses = courses;
//        this.canMentor = canMentor;
//    }


    public Set getCourses() {
        return courses;
    }


    public boolean isCanMentor() {
        return canMentor;
    }

    public void setCourses(Set courses) {
        this.courses = courses;
    }

    public void setCanMentor(boolean canMentor) {
        this.canMentor = canMentor;
    }

    @Override
    public  void setAdditionalData() {
        Scanner console = new Scanner(System.in);
        System.out.println("Did you mentor before(Y/N):");
        String canMentor = console.next();
        switch (canMentor.toUpperCase()) {
            case "Y":
                this.setCanMentor(true);
                break;
            case "N":
                this.setCanMentor(false);
                break;
            default:
                System.out.println("Invalid option. Aborting...");
                break;
        }

        //Set better than list - automatic validation that unique courses will be set
        Set<CourseName> courseNameSet = new HashSet<>();
        boolean courseFlag = false;

        while (!courseFlag) {
            System.out.println("");
            System.out.println("Which course you graduated : ");
            System.out.println("1. Java");
            System.out.println("2. Python");
            System.out.println("3. Web");
            System.out.println("4. DBA");
            System.out.println("5. Selection Completed - EXIT");
            Integer courseNumber = console.nextInt();
            switch (courseNumber) {
                case 1:
                    courseNameSet.add(CourseName.JAVA);
                    break;
                case 2:
                    courseNameSet.add(CourseName.PYTHON);
                    break;
                case 3:
                    courseNameSet.add(CourseName.WEB);
                    break;
                case 4:
                    courseNameSet.add(CourseName.DBA);
                    break;
                case 5:
                    this.setCourses(courseNameSet);
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
                    break;
            }

        }
    }

    @Override
    public void printUserDetails()
    {
        super.printUserDetails();
        System.out.println("Can Mentor : " + this.isCanMentor());
    }
}
