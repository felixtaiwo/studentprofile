package StudentProfile;


import StudentProfile.Repositories.*;
import StudentProfile.Subjects.Biology;
import StudentProfile.Subjects.Physics;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ResultRepo resultRepo;
    @Autowired
    private BioRepo bioRepo;
    @Autowired
    private PhysicsRepo physicsRepo;



    public Student addStudent(Student student){
        return studentRepo.save(student);
    }
    public Result addResult(Result result){
        return resultRepo.save(result);
    }
    public Student getStudent(int studentId) { return studentRepo.findByStudentId(studentId);
    }
    public List<Biology> getAllBioResults (){
        return bioRepo.findAll();
    }
    public Biology addResult(Biology result) {
        return bioRepo.save(result);
    }
    public Student findStudentById(int id){
        return studentRepo.findByStudentId(id);
   }
    public List<Result> getAllResults() {
        return resultRepo.findAll();
    }
    public Boolean existsB(Result result){
        return bioRepo.existsByBiologyResult(result);
    }
    public Boolean existsP(Result result){
        return physicsRepo.existsByPhysicsResult(result);
    }
    public Result getResult (int id){
        return resultRepo.findByRID(id);
    }
    public Physics addResult(Physics result) {
        return physicsRepo.save(result);
    }
}
