package com.metacube.EADHIBERNATEASSIGNMENT1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metacube.EADHIBERNATEASSIGNMENT1.dao.StudentDao;
import com.metacube.EADHIBERNATEASSIGNMENT1.dto.StudentForm;
import com.metacube.EADHIBERNATEASSIGNMENT1.model.Student;
import com.metacube.EADHIBERNATEASSIGNMENT1.util.DTOUtil;

@Controller
public class StudentController {

	StudentDao studentDao;

	@Autowired
	public StudentController(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Value("${welcome.message}")
	private String welcomeMessage;

	/** Get mapping for home page
	 * @param model
	 * @return view
	 */
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("welcomeMessage", welcomeMessage);
		return "home";
	}

	/**Get mapping for addStudent page
	 * @param model
	 * @return view
	 */
	@GetMapping("/addStudent")
	public String addStudent(Model model) {
		model.addAttribute("studentForm", new StudentForm());
	
		return "addStudent";
	}

	/**Post mapping for addding a student
	 * @param student object to be added
	 * @param result
	 * @param model
	 * @param attribute
	 * @return view
	 */
	@PostMapping("/addStudent")
	public String studentAdded(@Validated StudentForm student,BindingResult result,Model model,RedirectAttributes attribute) {
		
		if (result.hasErrors()) {
			return "addStudent";
		} else {
			if (studentDao.studentExist(student.getEmail())) {
				attribute.addFlashAttribute("msg", "Student already exist");
				return "addStudent";
			}
			else{
				
				studentDao.add(DTOUtil.map(student, Student.class));
				attribute.addFlashAttribute("msg", "Student Added");
				return "redirect:/home";
			}
		}
	}
	/**Get Mapping for getting all students 
	 * @param model
	 * @return view
	 */
	@GetMapping("/showStudent")
	public String showStudent(Model model) {
		List<Student> studentList = new ArrayList<Student>();
		studentList = studentDao.showAll();
		model.addAttribute("studentList", studentList);
		return "showStudent";
	}
}
