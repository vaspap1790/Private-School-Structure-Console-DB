
package privateschoolstructuredb.Entities;

public class TrainersInCourses {
    
    private Integer trainer_id;
    private Integer course_id;

    public TrainersInCourses(Integer trainer_id, Integer course_id) {
        this.trainer_id = trainer_id;
        this.course_id = course_id;
    }

    public boolean equals(Object other){
        if (other == this) return true;
        if (other == null) return false;
        if (getClass()!=other.getClass())return false;
        TrainersInCourses tic = (TrainersInCourses) other;
        return((this.trainer_id==tic.trainer_id)&&(this.course_id==tic.course_id));
    }

    public Integer getTrainer_id() {
        return trainer_id;
    }

    public void setTrainer_id(Integer trainer_id) {
        this.trainer_id = trainer_id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    @Override
    public String toString() {
        return "TrainersInCourses{" + "trainer_id=" + trainer_id + ", course_id=" + course_id + '}';
    }
    
    
}
