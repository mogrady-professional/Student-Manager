package ie.gmit.dip;

import java.io.Serializable;

public class Course implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

	public Course(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
}