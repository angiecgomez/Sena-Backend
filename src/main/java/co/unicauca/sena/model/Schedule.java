package co.unicauca.sena.model;

public class Schedule {

	/**
	 * Attributes
	 */
	
	private String id;
	private String idPeriod;
	private String idUser;
	private String day;
	private String hour;
	private String idCompetency;
	private String idClassroom;
	
	/**
	 * Construct
	 */
	
	public Schedule(String id, String idPeriod, String idUser, String day, String hour, String idCompetency,
			String idClassroom) {
		this.id = id;
		this.idPeriod = idPeriod;
		this.idUser = idUser;
		this.day = day;
		this.hour = hour;
		this.idCompetency = idCompetency;
		this.idClassroom = idClassroom;
	}

	public Schedule() {
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

	public String getIdPeriod() {
		return idPeriod;
	}

	public void setIdPeriod(String idPeriod) {
		this.idPeriod = idPeriod;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getIdCompetency() {
		return idCompetency;
	}

	public void setIdCompetency(String idCompetency) {
		this.idCompetency = idCompetency;
	}

	public String getIdClassroom() {
		return idClassroom;
	}

	public void setIdClassroom(String idClassroom) {
		this.idClassroom = idClassroom;
	}
	
	
	
	
	
}
