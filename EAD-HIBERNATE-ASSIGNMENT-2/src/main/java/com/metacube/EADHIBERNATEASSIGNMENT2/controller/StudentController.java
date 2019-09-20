package com.metacube.EADHIBERNATEASSIGNMENT2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metacube.EADHIBERNATEASSIGNMENT2.dto.Name;
import com.metacube.EADHIBERNATEASSIGNMENT2.dto.Standard;
import com.metacube.EADHIBERNATEASSIGNMENT2.dto.StudentForm;
import com.metacube.EADHIBERNATEASSIGNMENT2.model.Student;
import com.metacube.EADHIBERNATEASSIGNMENT2.repository.StudentRepository;
import com.metacube.EADHIBERNATEASSIGNMENT2.util.DTOUtil;

@Controller
public class StudentController {

	StudentRepository repository;
	List<Student> listOfStudents = new ArrayList<>();

	@Autowired
	public StudentController(StudentRepository repository) {
		this.repository = repository;
	}

	@Value("${welcome.message}")
	private String welcomeMessage;

	/**Get mapping for home page
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

	/**Post mapping for adding student
	 * @param student
	 * @param result
	 * @param model
	 * @param attribute
	 * @return view
	 */
	@PostMapping("/addStudent")
	public String studentAdded(@Validated StudentForm student,
			BindingResult result, Model model, RedirectAttributes attribute) {

		if (result.hasErrors()) {
			return "addStudent";
		} else {

			if (repository.findByEmailContainingIgnoreCase(student.getEmail())
					.size() != 0) {
				attribute.addFlashAttribute("msg", "Student already exist");
			} else {
				repository.save(DTOUtil.map(student, Student.class));
				attribute.addFlashAttribute("msg", "Student added");
			}
			return "redirect:/home";
		}
	}

	/**Get mapping for showing all students
	 * @param model
	 * @return view
	 */
	@GetMapping("/showStudent")
	public String showStudent(Model model) {
		List<Student> studentList = new ArrayList<Student>();
		studentList = repository.findAll();
		model.addAttribute("studentList", studentList);
		return "showStudent";
	}

	/**Get Mapping for searchStudent page
	 * @param model
	 * @return view
	 */
	@GetMapping("/searchStudent")
	public String searchStudent(Model model) {
		model.addAttribute("std", new Standard());
		model.addAttribute("name", new Name());
		return "searchStudent";
	}

	/**Post mapping for searching student by class
	 * @param std
	 * @param result
	 * @param model
	 * @param attribute
	 * @return view
	 */
	@PostMapping("/studentByClass")
	public String showStudentByClass(@Validated Standard std, BindingResult result,
			Model model, RedirectAttributes attribute) {
		if (result.hasErrors()) {
			return "searchStudent";
		} else {
			List<Student> studentList = new ArrayList<Student>();
			studentList = repository.findByStdContaining(std.getStd());
			if (studentList.size() != 0) {
				model.addAttribute("studentList", studentList);
				return "searchResult";
			} else {
				attribute.addFlashAttribute("msg", "Student added");
				result.addError(new ObjectError("msg", "No student Found"));
				return "searchStudent";
			}
		}
	}

	/**Post Mapping for searching student by name
	 * @param name
	 * @param result
	 * @param model
	 * @param attribute
	 * @return view
	 */
	@PostMapping("/studentByName")
	public String showStudentByName(@Validated Name name, BindingResult result,
			Model model, RedirectAttributes attribute) {
		if (result.hasErrors()) {
			return "searchStudent";
		} else {
			List<Student> studentList = new ArrayList<Student>();
			studentList = repository.findByFirstNameContainingIgnoreCase(name
					.getFirstName());
			if (studentList.size() != 0) {
				model.addAttribute("studentList", studentList);
				return "searchResult";
			} else {
				attribute.addFlashAttribute("msg", "Student added");
				result.addError(new ObjectError("msg", "No student Found"));
				return "searchStudent";
			}
		}
	}

}
