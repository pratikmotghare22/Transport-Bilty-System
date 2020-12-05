package bean;

public class CityBean {
	private String city, city_code, state;
	private int id;

	public CityBean() {
		super();
	}

	public CityBean(String city, String city_code, String state) {
		super();
		this.city = city;
		this.city_code = city_code;
		this.state = state;
	}
	
	public CityBean(int id,String city, String city_code, String state) {
		super();
		this.id=id;
		this.city = city;
		this.city_code = city_code;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity_Code() {
		return city_code;
	}

	public void setCity_Code(String city_code) {
		this.city_code = city_code;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
