package in.sb.sms.Service;

import java.util.List;

import in.sb.sms.Entity.Student;

public interface StudentService {
      List<Student> getAllStudents();
      Student getStudentById(Long id);
      Student saveStudent(Student student);
      void deleteStudent(Long id);
      
}
