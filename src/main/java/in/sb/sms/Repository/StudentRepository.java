package in.sb.sms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.sb.sms.Entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}
