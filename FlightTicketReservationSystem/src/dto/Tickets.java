package dto;

public class Tickets {
	private String Passengername;
	private String emailId;
	private int flightId;
	private String airlineName;
	private String ticketId;
	public Tickets(String passengername, String emailId, int flightId,String airlineName) {
		super();
		Passengername = passengername;
		this.emailId = emailId;
		this.flightId = flightId;
		this.airlineName=airlineName;
		this.ticketId = emailId+flightId;
	}
	public String getPassengername() {
		return Passengername;
	}
	public void setPassengername(String passengername) {
		Passengername = passengername;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public String getTicketId() {
		return ticketId;
	}
	@Override
	public String toString() {
		return "Tickets [Passengername=" + Passengername + ", emailId=" + emailId + ", flightId=" + flightId
				+ ", airlineName=" + airlineName + ", ticketId=" + ticketId + "]";
	}
	
}
