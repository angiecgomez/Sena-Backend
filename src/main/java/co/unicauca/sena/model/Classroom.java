package co.unicauca.sena.model;

/**
 * @author jesruiz
 * @author angiecgomez
 * @author mafemartinez
 *
 *	This class represents the ambiente entity
 */
public class Classroom {

	/**
	 * Attributes
	 */
	
	private String cod;
	private String name;
	private String type;
	private String location;
	private int capacity;
	private boolean state;
	
	
	/**
	 * Constructor
	 */

	public Classroom() {
	}
	
	

	public Classroom(String cod, String name, String type, String location, int capacity, boolean state) {
		super();
		this.cod = cod;
		this.name = name;
		this.type = type;
		this.location = location;
		this.capacity = capacity;
		this.state = state;
	}



	/**
	 * Getters and setters
	 */

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean getState() {
		return state;
	}
	
	public void setState(boolean state) {
		this.state = state;
	}
}
