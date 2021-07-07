package StudentProfile;

import StudentProfile.Subjects.Biology;
import StudentProfile.Subjects.Physics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private Service service;
    @RequestMapping(value = "/addS",method = RequestMethod.POST)
    public  Student addStudent(@RequestBody Student student){
        service.addStudent(student);
        Result result = new Result(
                null,
                null,
                null,
                false,
                student);
        service.addResult(result);
        student.setResults(result);
        service.addStudent(student);
        return service.findStudentById(student.getStudentId());
    }
    @RequestMapping(value ="/addR/bio/{studentId}",method = RequestMethod.POST)
    public Biology Student (@RequestBody Biology result, @PathVariable int studentId ) throws IOException {
        Student student = service.findStudentById(studentId);
        Result result1 = student.getResults();
        int RID= result1.getRID();
        result.setBiologyResult(new Result(RID));
        if (service.existsB(new Result(RID))) {throw new IOException("Student has a Result already");} else {
            student.setTcp(student.getTcp()+result.getGp());
            student.setTnu(student.getTnu()+1);
            float cgpa= (float)(student.getTcp())/(student.getTnu());
            student.setCgpa(BigDecimal.valueOf(cgpa));
            service.addStudent(student);
           return service.addResult(result);

        }
    }
    @RequestMapping(value ="/addR/phy/{studentId}",method = RequestMethod.POST)
    public Physics Student (@RequestBody Physics result,@PathVariable int studentId ) throws IOException {
        Student student = service.findStudentById(studentId);
        Result result1 = student.getResults();
        int RID= result1.getRID();
        result.setPhysicsResult(new Result(RID));
        if (service.existsP(new Result(RID))) {throw new IOException("Student has a Result already");} else {
            student.setTcp(student.getTcp()+result.getGp());
            student.setTnu(student.getTnu()+1);
            float cgpa= (float)(student.getTcp())/(student.getTnu());
            student.setCgpa(BigDecimal.valueOf(cgpa));
            service.addStudent(student);
            return service.addResult(result);

        }
    }
    @RequestMapping(value = "/getS/{studentId}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable int studentId){
        return service.getStudent(studentId);
    }
    @RequestMapping(value = "/getR", method = RequestMethod.GET)
    public List<Result> getAllResult(){
        return service.getAllResults();
    }
    @RequestMapping(value = "/getR/bio", method = RequestMethod.GET)
    public List<Biology> getAllBioResult(){
        return service.getAllBioResults();}

}
