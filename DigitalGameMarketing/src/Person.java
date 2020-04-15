
public class Person {
	private String name;
	private String lastname;
	private String email;
	private Address address;
	private Phone phone;
	private Date birthdate;

	public Person(String name, String lastname, String email, Address address, Phone phone, Date birthdate) {// For user
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.birthdate = birthdate;
	}

	public Person(String email, Phone phone, Date birthdate) {// For Admin
		this.email = email;
		this.phone = phone;
		this.birthdate = birthdate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
}
