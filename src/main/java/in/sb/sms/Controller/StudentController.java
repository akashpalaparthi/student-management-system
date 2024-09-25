package in.sb.sms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.sb.sms.Entity.Student;
import in.sb.sms.Service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
      @Autowired
	  private StudentService studentService;
      
      @GetMapping
      public String listStudents(Model model) {
          List<Student> students = studentService.getAllStudents();
          model.addAttribute("students", students);
          return "students"; 
      }
      @GetMapping("/new")
      public String createStudentForm(Model model) {
          Student student = new Student();
          model.addAttribute("student", student);
          return "create_student";
      }

      @PostMapping
      public String saveStudent(@ModelAttribute("student") Student student) {
          studentService.saveStudent(student);
          return "redirect:/students";
      }

      @GetMapping("/edit/{id}")
      public String editStudentForm(@PathVariable Long id, Model model) {
          Student student = studentService.getStudentById(id);
          model.addAttribute("student", student);
          return "edit_student";
      }

      @PostMapping("/{id}")
      public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student) {
          studentService.saveStudent(student);
          return "redirect:/students";
      }

      @GetMapping("/delete/{id}")
      public String deleteStudent(@PathVariable Long id) {
          studentService.deleteStudent(id);
          return "redirect:/students";
      }
	
}
