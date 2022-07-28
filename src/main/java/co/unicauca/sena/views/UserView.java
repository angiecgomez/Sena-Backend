package co.unicauca.sena.views;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.unicauca.sena.controllers.UserController;
import co.unicauca.sena.model.Schedule;
import co.unicauca.sena.model.User;

@RestController
@RequestMapping("/schedule")
@CrossOrigin("*")
public class UserView {

	/**
	 * Attributes
	 */
	@Autowired
	public UserController controller;
	
	/**
	 * Construct
	 */
	
	/*public UserView(UserController controller) {
		this.controller = controller;
	}
	
	/**
	 * Methods
	 */
	
	@GetMapping("/getUsers")
	public List<User> getUsers() throws Exception{
		return controller.getUsers();
	}
	
	
	@GetMapping("/getUser")
	public User getUser(@RequestParam String email, @RequestParam String password) throws InterruptedException, ExecutionException {
		return controller.getUser(email, password);
	}
	
	@GetMapping("/getActiveUsers")
	public List<User> getActiveUsers() throws Exception{
		return controller.getActiveUsers();
	}
	
	@GetMapping("/getSchedulesUsers")
	public List<Schedule> getSchedulesUsers(@RequestParam String id) throws InterruptedException, ExecutionException {
		return controller.getSchedulesUsers(id);
	}
	
	
	
}
