package test1_practical;

public class Course {


    //Attributes for the CourseApp.Course Class

    public String name;
    public String code;
    public String startDate;
    public int numberOfStudents;
    public int count;


    //CourseApp.Course Code and The Name of the CourseApp.Course (Constructor)
    public Course(String code, String name){
        this.code = code;
        this.name = name;
    }



    //All the Information about the CourseApp.Course such as StartDate, NumberOfStudents and the count (Constructor)
    public Course(String startDate, int numberOfStudents, int count){
        this.startDate = startDate;
        this.numberOfStudents = numberOfStudents;
        this.count = count;
    }


    //Getters and Setter of the CourseApp.Course Class

    public String getCode() {
        return code;
    }
    public String getName(){
        return name;
    }

    public String getStartDate(){
        return startDate;
    }

    public int getCount(){
        return count;
    }

    public int getNumberOfStudents(){
        return numberOfStudents;
    }
}
