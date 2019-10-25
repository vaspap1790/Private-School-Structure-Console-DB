
package privateschoolstructuredb.Entities;


public class AssignmentsInStudents {
    
    private Integer student_id;
    private Integer assignment_id;

    public AssignmentsInStudents(Integer student_id, Integer assignment_id) {
        this.student_id = student_id;
        this.assignment_id = assignment_id;
    }

    public boolean equals(Object other){
        if (other == this) return true;
        if (other == null) return false;
        if (getClass()!=other.getClass())return false;
        AssignmentsInStudents ais = (AssignmentsInStudents) other;
        return((this.student_id==ais.student_id)&&(this.assignment_id==ais.assignment_id));
    }
    
    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public Integer getAssignment_id() {
        return assignment_id;
    }

    public void setAssignment_id(Integer assignment_id) {
        this.assignment_id = assignment_id;
    }

    @Override
    public String toString() {
        return "AssignmentsInStudents{" + "student_id=" + student_id + ", assignment_id=" + assignment_id + '}';
    }
    
    
}
