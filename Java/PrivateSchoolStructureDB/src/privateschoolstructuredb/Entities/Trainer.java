
package privateschoolstructuredb.Entities;

import java.util.ArrayList;

public class Trainer{
    
    private Integer trainer_id;
    private String firstName;
    private String lastName;
    private String subject;
    private ArrayList <Course> courses;

    public Trainer(Integer trainer_id, String firstName, String lastName, String subject) {
        this.trainer_id = trainer_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    public Trainer(Integer trainer_id, String firstName, String lastName) {
        this.trainer_id = trainer_id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    
    public Trainer() {
    }

    public Integer getTrainer_id() {
        return trainer_id;
    }

    public void setTrainer_id(Integer trainer_id) {
        this.trainer_id = trainer_id;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Trainer{" + "trainer_id=" + this.trainer_id + ", firstName=" + firstName + ", lastName=" + lastName + ", subject=" + subject + '}';
    }


}
