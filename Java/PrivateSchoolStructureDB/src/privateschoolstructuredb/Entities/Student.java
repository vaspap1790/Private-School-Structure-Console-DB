package privateschoolstructuredb.Entities;

import java.util.ArrayList;
import java.util.Date;

public class Student{

    private Integer student_id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String stream;
    private double tuitionFees;
    private ArrayList <Course> courses;
    private ArrayList <Assignment> assignments;

    public Student(Integer student_id, String firstName, String lastName, Date dateOfBirth, String stream, double tuitionFees) {
        this.student_id = student_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.stream = stream;
        this.tuitionFees = tuitionFees;
    }

    public Student(Integer student_id, String firstName, String lastName) {
        this.student_id= student_id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    

    public Student() {
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    
    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(ArrayList<Assignment> assignments) {
        this.assignments = assignments;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public double getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(double tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    @Override
    public String toString() {
        return "Student{" + "student_id=" + this.student_id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", stream=" + stream + ", tuitionFees=" + tuitionFees + '}';
    }

}
