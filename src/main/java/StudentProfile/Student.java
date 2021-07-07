package StudentProfile;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Entity
public class Student {
    @Id
    @GeneratedValue
    public int studentId;
    @NotNull
    private String fullname;
    @OneToOne
    private Result results;
    private int tcp;
    private int tnu;
    @Column(scale = 2)
    private BigDecimal cgpa;


    public Student() {
    }

    public Student(int studentId,  String fullname, Result results) {
        this.studentId = studentId;
        this.results=results;
        this.fullname = fullname;
    }


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Result getResults() {
        return results;
    }

    public void setResults(Result results) {
        this.results = results;
    }

    public int getTcp() {
        return tcp;
    }

    public void setTcp(int tcp) {
        this.tcp = tcp;
    }

    public int getTnu() {
        return tnu;
    }

    public void setTnu(int tnu) {
        this.tnu = tnu;
    }

    public BigDecimal getCgpa() {
        return cgpa;
    }

    public void setCgpa(BigDecimal cgpa) {
        this.cgpa = cgpa;
    }

}

