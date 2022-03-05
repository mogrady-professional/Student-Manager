package ie.gmit.dip;

import java.io.Serializable;

public class Address implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String address;

	public Address(String address) {
		super();
		this.address = address;
	}

	public String getAddress() {
		return address;
	}
}