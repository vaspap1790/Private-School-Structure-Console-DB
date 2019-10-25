
package privateschoolstructuredb.Entities;

public class StudentsInCourses {
    
    private Integer student_id;
    private Integer course_id;

    public StudentsInCourses(Integer student_id, Integer course_id) {
        this.student_id = student_id;
        this.course_id = course_id;
    }

    public boolean equals(Object other){
        if (other == this) return true;
        if (other == null) return false;
        if (getClass()!=other.getClass())return false;
        StudentsInCourses sic = (StudentsInCourses) other;
        return((this.student_id==sic.student_id)&&(this.course_id==sic.course_id));
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    @Override
    public String toString() {
        return "StudentsInCourses{" + "student_id=" + student_id + ", course_id=" + course_id + '}';
    }
    
}
