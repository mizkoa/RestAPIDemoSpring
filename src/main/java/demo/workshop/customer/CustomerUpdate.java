package demo.workshop.customer;

import javax.validation.constraints.NotNull;

public class CustomerUpdate {
	@NotNull
	private String name ; 
	@NotNull
	private String lastName ;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String phone) {
		this.lastName = phone;
	} 

}
