package co.unicauca.sena.model;

/**
 * @author jesruiz
 * @author angiecgomez
 * @author mafemartinez
 *
 * This class represents the Coordinador o docente entity
 */
public class User {
	
	/**
	 * Attributes
	 */
	
	private String id;
	private String idType;
	private String name;
	private String lastName;
	private String email;
	private String type; // Técnico o profesional
	private String contract; // Constratista CNT - Planta PT
	private String area; // Álgebra Lineal
	private boolean teacher; // Docente true o false; false si es coordinador
	private boolean state; //Activo o inactivo
	private int hoursWeek;
	private int hoursDay;
	
	
	/**
	 * Construct
	 */
	
	public User() {
	}

	
	public User(String id, String idType, String name, String lastName, String email, String type, String contract,
			String area, boolean teacher, boolean state, int hoursWeek, int hoursDay) {
		super();
		this.id = id;
		this.idType = idType;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.type = type;
		this.contract = contract;
		this.area = area;
		this.teacher = teacher;
		this.state = state;
		this.hoursWeek = hoursWeek;
		this.hoursDay = hoursDay;
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


	public String getIdType() {
		return idType;
	}


	public void setIdType(String idType) {
		this.idType = idType;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getContract() {
		return contract;
	}


	public void setContract(String contract) {
		this.contract = contract;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public boolean isTeacher() {
		return teacher;
	}


	public void setTeacher(boolean teacher) {
		this.teacher = teacher;
	}


	public boolean isState() {
		return state;
	}


	public void setState(boolean state) {
		this.state = state;
	}


	public int getHoursWeek() {
		return hoursWeek;
	}


	public void setHoursWeek(int hoursWeek) {
		this.hoursWeek = hoursWeek;
	}


	public int getHoursDay() {
		return hoursDay;
	}


	public void setHoursDay(int hoursDay) {
		this.hoursDay = hoursDay;
	}
	
}
