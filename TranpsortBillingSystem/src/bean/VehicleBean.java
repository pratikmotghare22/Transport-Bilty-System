package bean;

public class VehicleBean {

	private String vehiclename, vehiclenumber, vehicletype, ownername, insurance;
	private int vehicleid;

	public VehicleBean() {
		super();
	}
	
	public VehicleBean(int vehicleid,String vehicletype,String vehiclename, String vehiclenumber,String ownername,
			String insurance) {
		super();
		this.vehicleid=vehicleid;
		this.vehicletype = vehicletype;
		this.vehiclename = vehiclename;
		this.vehiclenumber = vehiclenumber;
		this.ownername = ownername;
		this.insurance = insurance;

	}
	
	public VehicleBean(String vehicletype, String vehiclename, String vehiclenumber, String ownername,
			String insurance) {
		super();
		this.vehicletype = vehicletype;
		this.vehiclename = vehiclename;
		this.vehiclenumber = vehiclenumber;
		this.ownername = ownername;
		this.insurance = insurance;

	}

	
	
	public int getVehicleId() {
		return vehicleid;
	}

	public void setVehicleId(int vehicleid) {
		this.vehicleid = vehicleid;
	}
	public String getVehicleType() {
		return vehicletype;
	}

	public void setVehicleType(String vehicletype) {
		this.vehicletype = vehicletype;
	}

	public String getVehicleName() {
		return vehiclename;
	}

	public void setVehicleName(String vehiclename) {
		this.vehiclename = vehiclename;
	}

	public String getVehicleNumber() {
		return vehiclenumber;
	}

	public void setVehicleNumber(String vehiclenumber) {
		this.vehiclenumber = vehiclenumber;
	}

	public String getOwnerName() {
		return ownername;
	}

	public void setOwnerName(String ownername) {
		this.ownername = ownername;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	

}
