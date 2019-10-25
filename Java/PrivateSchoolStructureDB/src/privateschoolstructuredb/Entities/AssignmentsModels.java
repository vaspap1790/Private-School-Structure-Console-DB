
package privateschoolstructuredb.Entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AssignmentsModels {
    
    private Integer assignment_id;
    private String title;
    private String description;
    private Date subDateTime;
    private Integer course_id;
    private String course_title;

    public AssignmentsModels(Integer assignment_id, String title, String description, Date subDateTime, Integer course_id, String course_title) {
       
        this.assignment_id = assignment_id;
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.course_id = course_id;
        this.course_title = course_title;
    }

    public AssignmentsModels(Integer assignment_id, String title, String description, Date subDateTime) {
        
        this.assignment_id = assignment_id;
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        
    }

    public AssignmentsModels( String title, String description, Integer course_id) {
       
        this.title = title;
        this.description = description;
        this.course_id = course_id;
    }
    
    

    public AssignmentsModels() {
    }

    public String getCourse_title() {
        return course_title;
    }

    public void setCourse_title(String course_title) {
        this.course_title = course_title;
    }
    
    public Date getSubDateTime() {
        return subDateTime;
    }

    public void setSubDateTime(Date subDateTime) {
        this.subDateTime = subDateTime;
    }
    
    public Integer getAssignment_id() {
        return assignment_id;
    }

    public void setAssignment_id(Integer assignment_id) {
        this.assignment_id = assignment_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

     public DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

    @Override
    public String toString() {
        return "AssignmentsModels{" + "assignment_id=" + assignment_id + ", title=" + title + ", description=" + description + ", subDateTime=" + subDateTime + ", course_id=" + course_id + ", course_title=" + course_title + '}';
    }
    
}
