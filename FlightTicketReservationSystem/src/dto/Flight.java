package dto;

public class Flight {
	private String airline;
	private int flightId;
	private String origin;
	private String destination;
	private String arrivalTime;
	private String depatureTime;
	private String duration;
	private int fair;
	private int seatCapacity;
	public Flight(String airline, int flightId, String origin, String destination, String arrivalTime,
			String depatureTime, String duration,int seatCapacity,int fair) {
		super();
		this.airline = airline;
		this.flightId = flightId;
		this.origin = origin;
		this.destination = destination;
		this.arrivalTime = arrivalTime;
		this.depatureTime = depatureTime;
		this.duration = duration;
		this.seatCapacity = seatCapacity;
		this.fair=fair;
		
	}
	
	

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepatureTime() {
		return depatureTime;
	}

	public void setDepatureTime(String depatureTime) {
		this.depatureTime = depatureTime;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getFairDetatils() {
		return fair;
	}

	public void setFair(int fair) {
		this.fair= fair;
	}



	@Override
	public String toString() {
		return "Flight [airline=" + airline + ", flightId=" + flightId + ", origin=" + origin + ", destination="
				+ destination + ", arrivalTime=" + arrivalTime + ", depatureTime=" + depatureTime + ", duration="
				+ duration +", seatCapacity=" + seatCapacity+ ", fair=" + fair  + "]";
	}
//	public class FairDetails{
//		private float basePrice;
//		private float taxes;
//		
//		public FairDetails(float basePrice, float taxes) {
//			super();
//			this.basePrice = basePrice;
//			this.taxes = taxes;
//		}
//
//		public float getBasePrice() {
//			return basePrice;
//		}
//
//		public void setBasePrice(float basePrice) {
//			this.basePrice = basePrice;
//		}
//
//		public float getTaxes() {
//			return taxes;
//		}
//
//		public void setTaxes(float taxes) {
//			this.taxes = taxes;
//		}
//
//		@Override
//		public String toString() {
//			return "FairDetails [basePrice=" + basePrice + ", taxes=" + taxes + "]";
//		}
		
		
	}
	

