package co.unicauca.sena.views;

import java.util.List;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.unicauca.sena.controllers.ClassroomController;
import co.unicauca.sena.model.Classroom;
import co.unicauca.sena.model.Schedule;

@RestController
@RequestMapping("/classroom")
@CrossOrigin("*")
public class ClassroomView {

	/**
	 * Attributes
	 */
	@Autowired
	public ClassroomController controller;
	
	/**
	 * Construct
	 */
	
	/*public ClassroomView() {
		
	}
	
	/**
	 * Methods
	 */
	
	@GetMapping("/test")
	public ResponseEntity<String> testGetEndpoint() {
		return ResponseEntity.ok("Test Get Endpoint is Working");
	}
	
	@GetMapping("/getClassrooms")
	public List<Classroom> getClassrooms() throws Exception{
		return controller.getClassrooms();
	}
	
	@GetMapping("/getActiveClassrooms")
	public List<Classroom> getActiveClassrooms() throws Exception{
		return controller.getActiveClassrooms();
	}
	
	@PutMapping("/updateClassroomsState")
	public boolean updateClassroomsState(@RequestParam String id) throws InterruptedException, ExecutionException {
		return controller.setClassroomState(id);
	}
	
	@PostMapping("/createClassroom")
	public boolean createClassroom(@RequestBody Classroom classroom) throws InterruptedException, ExecutionException {
		return controller.create(classroom);	
	}
	
	@PutMapping("/updateClassrooms")
	public boolean updateClassrooms(@RequestBody Classroom classroom) throws InterruptedException, ExecutionException {
		return controller.update(classroom);
	}
	
	@PutMapping("/deleteClassroom")
	public boolean deleteClassroom(@RequestParam String id) throws InterruptedException, ExecutionException {
		return controller.delete(id);
	}
	
	@GetMapping("/getSchedulesClassrooms")
	public List<Schedule> getSchedulesClassrooms(@RequestParam String cod) throws Exception{
		return controller.getSchedulesClassrooms(cod);
	}

}

