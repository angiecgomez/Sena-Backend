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

import co.unicauca.sena.controllers.AcademicPeriodController;
import co.unicauca.sena.model.AcademicPeriod;

@RestController
@RequestMapping("period")
@CrossOrigin("*")
public class AcademicPeriodView {

	/**
	 * Attributes
	 */
	
	@Autowired
	public AcademicPeriodController controller;

	/**
	 * Construct
	 */
	
	/*public AcademicPeriodView(AcademicPeriodController controller) {
		this.controller = controller;
	}

	/**
	 * Methods
	 */
	
	@GetMapping("/getAcademicPeriods")
	public List<AcademicPeriod> getAcademicPeriods() throws Exception{
		return controller.getAcademicPeriods();
	}
	
	@PostMapping("/createPeriod")
	public boolean createPeriod(@RequestBody AcademicPeriod period) throws InterruptedException, ExecutionException {
		return controller.create(period);	
	}
	
	
}
