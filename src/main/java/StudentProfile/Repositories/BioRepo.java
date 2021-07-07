package StudentProfile.Repositories;


import StudentProfile.Result;
import StudentProfile.Subjects.Biology;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BioRepo extends JpaRepository<Biology,Integer> {
    Boolean existsByBiologyResult(Result result);
}
