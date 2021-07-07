package StudentProfile;

import StudentProfile.Subjects.Biology;
import StudentProfile.Subjects.Physics;

import javax.persistence.*;

@Entity
public class Result {
    @Id
    @GeneratedValue
    private int RID;
    @OneToOne(mappedBy = "biologyResult")
    private Biology biology;
    @OneToOne(mappedBy = "physicsResult")
    private Physics physics;
    private String TeachersComment;
    private Boolean Approved=false;
    @OneToOne
    private Student student;

    public Result() {
    }

    public Result(Biology biology, Physics physics, String teachersComment, Boolean approved, Student student) {
        this.biology = biology;
        this.physics = physics;
        TeachersComment = teachersComment;
        Approved = approved;
        this.student = student;
    }
    public Result(int RID) {
        this.RID=RID;
    }

    public int getRID() {
        return RID;
    }

    public void setRID(int RID) {
        this.RID = RID;
    }

    public Biology getBiology() {
        return biology;
    }

    public void setBiology(Biology biology) {
        this.biology = biology;
    }

    public Physics getPhysics() {
        return physics;
    }

    public void setPhysics(Physics physics) {
        this.physics = physics;
    }

    public String getTeachersComment() {
        return TeachersComment;
    }

    public void setTeachersComment(String teachersComment) {
        TeachersComment = teachersComment;
    }

    public Boolean getApproved() {
        return Approved;
    }

    public void setApproved(Boolean approved) {
        Approved = approved;
    }


    public void setStudent(Student student) {
        this.student = student;
    }


}
