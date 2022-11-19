package ams4.Package.model;

public class Administrator {
	private String email;
	private String password;
	private Integer roll;
	private String userName;
	private String userAddress;
	private String userPhone;
	
	public Administrator(String email, String password, Integer roll, String userName, String userAddress,
			String userPhone) {
		super();
		this.email = email;
		this.password = password;
		this.roll = roll;
		this.userName = userName;
		this.userAddress = userAddress;
		this.userPhone = userPhone;
	}
	

	public Administrator(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}


	public Administrator() {
		super();
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRoll() {
		return roll;
	}

	public void setRoll(Integer roll) {
		this.roll = roll;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	@Override
	public String toString() {
		return "Administrator [email=" + email + ", password=" + password + ", roll=" + roll + ", userName=" + userName
				+ ", userAddress=" + userAddress + ", userPhone=" + userPhone + "]";
	}
	
	
}
