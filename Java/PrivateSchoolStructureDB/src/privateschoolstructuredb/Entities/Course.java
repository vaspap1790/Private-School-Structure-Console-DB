
package privateschoolstructuredb.Entities;

import java.util.ArrayList;
import java.util.Date;

public class Course {
    
    private Integer course_id;
    private String title;
    private String stream;
    private String type;
    private Date start_date;
    private Date end_date;
    private ArrayList <Student> students;
    private ArrayList <Integer> student_ids;
    private ArrayList <Trainer> trainers;
    private ArrayList <Integer> trainer_ids;
    private ArrayList <AssignmentsModels> assignments;
    private ArrayList <Integer> assignment_ids;
    

    public Course(Integer course_id, String title, String stream, String type, Date start_date, Date end_date) {
        this.course_id = course_id;
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public Course() {
    }

    public ArrayList<Integer> getStudent_ids() {
        return student_ids;
    }

    public void setStudent_ids(ArrayList<Integer> student_ids) {
        this.student_ids = student_ids;
    }

    public ArrayList<Integer> getTrainer_ids() {
        return trainer_ids;
    }

    public void setTrainer_ids(ArrayList<Integer> trainer_ids) {
        this.trainer_ids = trainer_ids;
    }

    public ArrayList<Integer> getAssignment_ids() {
        return assignment_ids;
    }

    public void setAssignment_ids(ArrayList<Integer> assignment_ids) {
        this.assignment_ids = assignment_ids;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<AssignmentsModels> getAssignments() {
        return assignments;
    }

    public void setAssignments(ArrayList<AssignmentsModels> assignments) {
        this.assignments = assignments;
    }

    
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(ArrayList<Trainer> trainers) {
        this.trainers = trainers;
    }

    
    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Course{" + "course_id=" + course_id + ", title=" + title + ", stream=" + stream + ", type=" + type + ", start_date=" + start_date + ", end_date=" + end_date + '}';
    }



}
