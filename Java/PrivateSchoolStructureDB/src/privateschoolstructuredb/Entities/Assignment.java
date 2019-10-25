package privateschoolstructuredb.Entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Assignment {

    private Integer assignment_id;
    private String title;
    private String description;
    private Date subDateTime;
    private String oralMark;
    private String totalMark;
    private Integer course_id;
    private String course_title;

    public Assignment(Integer assignment_id, String title, String description, Date subDateTime, String oralMark, String totalMark, Integer course_id) {
        this.assignment_id = assignment_id;
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.oralMark = oralMark;
        this.totalMark = totalMark;
        this.course_id = course_id;
    }

    public Assignment(Integer assignment_id, String title, String description, Date subDateTime, String oralMark, String totalMark) {
        this.assignment_id = assignment_id;
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.oralMark = oralMark;
        this.totalMark = totalMark;
    }

    public Assignment(Integer assignment_id, String title, String description, Date subDateTime, String oralMark, String totalMark, String course_title) {
        this.assignment_id = assignment_id;
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.oralMark = oralMark;
        this.totalMark = totalMark;
        this.course_title = course_title;
    }

    public Assignment(AssignmentsModels a) {

        this.title = a.getTitle();
        this.description = a.getDescription();
        this.subDateTime = a.getSubDateTime();
        this.oralMark = null;
        this.totalMark = null;
        this.course_id = a.getCourse_id();

    }

    public Assignment() {
    }

    public String getCourse_title() {
        return course_title;
    }

    public void setCourse_title(String course_title) {
        this.course_title = course_title;
    }

    
    public Integer getAssignment_id() {
        return assignment_id;
    }

    public void setAssignment_id(Integer assignment_id) {
        this.assignment_id = assignment_id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getSubDateTime() {
        return subDateTime;
    }

    public String getOralMark() {
        return oralMark;
    }

    public void setOralMark(String oralMark) {
        this.oralMark = oralMark;
    }

    public String getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(String totalMark) {
        this.totalMark = totalMark;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public void setSubDateTime(Date subDateTime) {
        this.subDateTime = subDateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

    @Override
    public String toString() {
        return "Assignment{" + "assignment_id=" + assignment_id + ", title=" + title + ", description=" + description + ", subDateTime=" + subDateTime + ", oralMark=" + oralMark + ", totalMark=" + totalMark + '}';
    }

}
