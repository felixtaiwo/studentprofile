package StudentProfile.Repositories;

import StudentProfile.Result;
import StudentProfile.Subjects.Physics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhysicsRepo extends JpaRepository<Physics,Integer> {
    Boolean existsByPhysicsResult(Result result);
}
