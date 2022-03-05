package ie.gmit.dip;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	private String sid;
	private String firstName;
	private String surname;
	private Date dob; 
	private Course course;
	private Address address;
	
	public Student(String id) {
		super();
		this.sid = id;
	}
	
	public Student(String id, String firstName, String surname, Date dob) {
		this(id);
		this.firstName = firstName;
		this.surname = surname;
		this.dob = dob;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", firstName=" + firstName + ", surname=" + surname + ", dob=" + dob + "]";
	}
}