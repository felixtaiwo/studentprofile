package StudentProfile.Subjects;

import StudentProfile.Result;

import javax.persistence.*;
import java.io.IOException;


@Entity
public class Biology {
    public enum grades{
        A,B,C,D,E,F
    }
    @Id
    @GeneratedValue
    private int BID;
    @OneToOne
    private Result biologyResult;
    private int ca;
    private int exam;
    private int total;
    @Enumerated(EnumType.STRING)
    private Biology.grades grade;
    private int gp;




    public Biology() {
    }

    public Biology(Result biologyResult) {
        this.biologyResult=biologyResult;
    }

    public int getBID() {
        return BID;
    }

    public void setBID(int BID) {
        this.BID = BID;
    }




    public void setBiologyResult(Result biologyResult) {
        this.biologyResult = biologyResult;
    }

    public int getCa() {
        return ca;
    }

    public void setCa(int ca) throws IOException {
        if (ca>30 || ca<0){
            throw new IOException("invalid CA score");
        } else
        this.ca = ca;
    }

    public int getExam() {
        return exam;
    }

    public void setExam(int exam) throws IOException {
        if (exam>70 || exam<0){
            throw new IOException("invalid Exam score");
        } else
            this.exam = exam;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total =
                ca+exam;
    }

    public grades getGrade() {
        return grade;
    }

    public void setGrade(grades grade)  {
        grades Bon = grades.A;
        if ((ca+exam)<30){
            this.grade=grades.F;
        } else if ((ca+exam)<40){
            this.grade=grades.E;
        } else if ((ca+exam)<50){
            this.grade=grades.D;
        } else if ((ca+exam)<60){
            this.grade=grades.C;
        } else if ((ca+exam)<70){
            this.grade=grades.B;
        } else this.grade=Bon;
    }

    public int getGp() {
        return gp;
    }

    public void setGp(int gp) {
        int Bon =5;
        if ((ca+exam)<30){
            this.gp=0;
        } else  if ((ca+exam)<40){
            this.gp=1;
        } else  if ((ca+exam)<50){
            this.gp=2;
        } else  if ((ca+exam)<60){
            this.gp=3;
        } else  if ((ca+exam)<70){
            this.gp=4;
        } else this.gp=Bon;
    }


}

