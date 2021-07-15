package com.company.Demo.finalProject.main;



import javax.xml.bind.annotation.*;
import java.util.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Student extends  User implements java.io.Serializable {

    private Set courses ;
    private JobStatus jobStatus;

    public Student(){
    }

    //no need for constructor - will be initiated by getter and setter
//    public Student(String firstName, String lastName, String type, String alumniId, String password, String linkedInPage, JobStatus jobStatus, Set courses) {
//        super(firstName, lastName, type, alumniId, password, linkedInPage);
//        this.jobStatus = jobStatus;
//        this.courses = courses;
//    }


    public JobStatus getJobStatus() {
        return jobStatus;
    }


    public Set getCourses() {
        return courses;
    }

    public void setJobStatus(JobStatus jobStatus) {
        this.jobStatus = jobStatus;
    }

    public void setCourses(Set courses) {
        this.courses = courses;
    }

    @Override
    public void printUserDetails()
    {
        super.printUserDetails();
        System.out.println("Job Status : " + this.getJobStatus());
        System.out.println("List of courses were Completed  : " + this.getCourses());
    }

    @Override
    public  boolean setAdditionalData(){

        Scanner console = new Scanner(System.in);
        System.out.println("Select the job status:");
        System.out.println("1. Not Looking For Job");
        System.out.println("2. Looking For Job");
        System.out.println("3. Not looking But Open For Suggestion");
        Integer jobStatusNumber = console.nextInt();

        switch (jobStatusNumber) {
            case 1:
                this.setJobStatus(JobStatus.NOT_LOOKING);
                break;
            case 2:
                this.setJobStatus(JobStatus.LOOKING);
                break;
            case 3:
                this.setJobStatus(JobStatus.OPEN_FOR_SUGGESTION);
                break;
            default:
                System.out.println("Invalid Job Status. Aborting...");
                break;
        }

        //Set better than list - automatic validation that unique courses will be set
        Set<CourseName> courseNameSet = new HashSet<>();
        boolean courseFlag = false;

    while (!courseFlag) {
            System.out.println("");
            System.out.println("Which Graduated You Completed");
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
                    //this.setCourses(courseNameSet);
                    courseFlag= true;
                    System.out.println("Exit Course Selection...");
                    break;
                default:
                    System.out.println("Invalid Course. Aborting...");
                    return false;
            }

        }

    return true;
    }

}
