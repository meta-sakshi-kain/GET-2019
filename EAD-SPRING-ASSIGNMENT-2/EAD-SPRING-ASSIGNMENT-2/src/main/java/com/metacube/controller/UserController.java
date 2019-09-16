package com.metacube.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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

import com.metacube.dto.EmployeeDetails;
import com.metacube.dto.Friend;
import com.metacube.dto.FriendForEmp;
import com.metacube.dto.FriendProfile;
import com.metacube.model.pojo.Login;
import com.metacube.model.pojo.Pass;
import com.metacube.model.pojo.User;
import com.metacube.model.pojo.Vehicle;
import com.metacube.service.PassService;
import com.metacube.service.UserService;
import com.metacube.service.VehicleService;
import com.metacube.util.DTOUtil;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private PassService passService;

	@Value("${welcome.message}")
	private String welcomeMessage;

	@GetMapping("/registration")
	public String registerUser(Model model) {
		model.addAttribute("welcomeMessage", welcomeMessage);
		model.addAttribute(new User());
		return "user";
	}
	@PostMapping("/registration")
	public String registerUser1(Model model) {
		model.addAttribute("welcomeMessage", welcomeMessage);
		model.addAttribute("user", new User());
		return "user";
	}

	
	@GetMapping("/getPass")
	public String getPass(){
		return "getPass";
	}
	
	@GetMapping("/login")
	public String loginUser(Model model,HttpSession session,Login login) {
		model.addAttribute("welcomeMessage", welcomeMessage);
		model.addAttribute("login", new Login());
		session.setAttribute("email", "email");
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

	@PostMapping("/addVehicle")
	public String userAdded(@Validated User user, BindingResult result,
			final RedirectAttributes redirectAttributes, Model model) {
		if (result.hasErrors()) {
			return "user";
		} else {
			if (user.getConfirmPassword().equals(user.getPassword())) {
				User dbUser = DTOUtil.map(user, User.class);
				if (!userService.userExists(user.getEmail())) {
					redirectAttributes.addFlashAttribute("msg","User added successfully");
					userService.addUser(dbUser);
					model.addAttribute("regId",userService.getUserRegId(user.getEmail()));
					model.addAttribute("vehicle", new Vehicle());
					return "addVehicle";
				} else {
					redirectAttributes.addFlashAttribute("msg","User already exist");
					return "user";
				}

			} 
			else {
				ObjectError objectError = new ObjectError("pass","Passwords do not match");
				result.addError(objectError);
				return "user";
			}
		}
	}

	@GetMapping("/addVehicle")
	public String vehicleAdded1() {
		return "addVehicle";
	}

	@PostMapping("/getPass")
	public String vehicleAdded(@Validated Vehicle vehicle,BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "addVehicle";
		} else {
			Vehicle dbVehicle = DTOUtil.map(vehicle, Vehicle.class);
			vehicleService.addVehicle(dbVehicle);
			model.addAttribute("vehicleType", vehicle.getVehicleType());
			model.addAttribute("regId", vehicle.getRegId());
			return "getPass";
		}
}

	@GetMapping("/home")
	public String passSelected(Pass pass, Model model) {
		Pass dbPass = DTOUtil.map(pass, Pass.class);
		passService.addPass(dbPass);
		model.addAttribute("regId", pass.getRegId());
		EmployeeDetails emp = userService.getEmpDetails(pass.getRegId());
		model.addAttribute("emp", emp);
		return "home";
	}

	@PostMapping("/home")
	public String userLoggedIn(@Validated Login login, BindingResult result,final RedirectAttributes redirectAttributes, Model model) {
		if (result.hasErrors()) {
			System.out.println("not logged in");
			return "login";
		} else {
			if (!userService.userExists(login.getEmail())) {
				redirectAttributes.addFlashAttribute("msg","User does not exist");
				return "redirect:/login";
			}
			String pass = userService.getPassword(login.getEmail());
			if (!pass.equals(login.getPassword())) {
				redirectAttributes.addFlashAttribute("msg","Password Incorrect");
				return "redirect:/login";
			}
			if(!userService.userAddedVehicle(userService.getUserRegId(login.getEmail()))){
				model.addAttribute("regId",userService.getUserRegId(login.getEmail()));
				model.addAttribute("vehicle", new Vehicle());
				return "addVehicle";
			}	
			EmployeeDetails emp = userService.getEmpDetails(userService.getUserRegId(login.getEmail()));
			model.addAttribute("emp", emp);
			return "home";
		}
	}

	@GetMapping("/friend")
	public String showFriends(FriendForEmp friendForEmp, Model model) {
		List<Friend> listFriend = userService.getFriendList(friendForEmp.getEmpRegId(), friendForEmp.getEmpOrganization());
		model.addAttribute("list", listFriend);
		return "friend";
	}
	
	@GetMapping("/friendProfile")
	public String showFriendProfile(Friend friend, Model model) {
		FriendProfile friendProfile = userService.getFriendProfile(friend.getRegId());
		model.addAttribute("profile", friendProfile);
		return "friendProfile";
	}
	
	@GetMapping("/update")
	public String getUpdatePage(){
		return "home";
	} 

	@PostMapping("/update")
	public String updateDetail(EmployeeDetails emp, BindingResult result,Model model) {
		if (userService.updateDetail(emp)) {
			EmployeeDetails employee = userService.getEmpDetails(emp.getRegId());
			model.addAttribute("emp", employee);
			return "home";
		} 
		else{
			return "home";
		}
	}
}
