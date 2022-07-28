package co.unicauca.sena.views;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.unicauca.sena.controllers.CompetencyController;
import co.unicauca.sena.model.Competency;

@RestController
@RequestMapping("/competency")
@CrossOrigin("*")
public class CompetencyView {

	/**
	 * Attributes
	 */
	@Autowired
	public CompetencyController controller;
	
	/**
	 * Construct
	 */
	
	/*public CompetencyView(CompetencyController controller) {
		this.controller = controller;
	}
	
	/**
	 * Methods
	 */
	
	@GetMapping("/getCompetences")
	public List<Competency> getCompetency() throws Exception{
		return controller.getCompetencies();
	}
}
