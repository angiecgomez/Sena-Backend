package co.unicauca.sena.model;

public class Competency {

	/**
	 * Attributes
	 */
	
	private String id;
	private String name;
	
	/**
	 * Constructor
	 */
	
	public Competency(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public Competency() {
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
}
