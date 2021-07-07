package StudentProfile.Repositories;

import StudentProfile.Result;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ResultRepo extends JpaRepository<Result, Integer> {
     int countByRID(int id);
     Result findByRID(int id);

}
