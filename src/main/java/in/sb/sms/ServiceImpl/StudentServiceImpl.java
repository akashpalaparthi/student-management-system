package in.sb.sms.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sb.sms.Entity.Student;
import in.sb.sms.Repository.StudentRepository;
import in.sb.sms.Service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		 Optional<Student> optional = studentRepository.findById(id);
	        Student student = null;
	        if (optional.isPresent()) {
	            student = optional.get();
	        } else {
	            throw new RuntimeException("Student not found for id :: " + id);
	        }
	        return student;
	}

	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
	      studentRepository.deleteById(id);
		
	}

}
