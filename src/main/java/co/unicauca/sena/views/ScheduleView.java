package co.unicauca.sena.views;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.unicauca.sena.controllers.ScheduleController;
import co.unicauca.sena.model.Schedule;

@RestController
@RequestMapping("/schedule")
@CrossOrigin("*")
public class ScheduleView {
	
	/**
	 * Attributes
	 */
	@Autowired
	public ScheduleController controller;

	
	/**
	 * Construct
	 */
	
	/*public ScheduleView(ScheduleController controller) {
		this.controller = controller;
	}
	
	
	/**
	 * Methods
	 */
	
	@GetMapping("/getSchedules")
	public List<Schedule> getSchedules() throws Exception {
		return controller.getSchedules();
	}
	
	@PostMapping("/createSchedule")
	public boolean createSchedule(@RequestBody Schedule schedule) throws InterruptedException, ExecutionException {
		return controller.create(schedule);	
	}
}
