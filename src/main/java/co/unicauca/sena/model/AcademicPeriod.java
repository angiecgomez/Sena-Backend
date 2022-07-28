package co.unicauca.sena.model;

/**
 * @author jesruiz
 * @author angiecgomez
 * @author mafemartinez
 *
 * This class represents the período académico entity
 */

public class AcademicPeriod {
	
	/**
	 * Attributes
	 */
	
	private String id;
	private String name;
	private String startDate;
	private String endDate;
	
	/**
	 * Construct
	 */
	
	public AcademicPeriod(String id, String name, String startDate, String endDate) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public AcademicPeriod() {
	}
	
	/**
	 * Getters and setters
	 */

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
