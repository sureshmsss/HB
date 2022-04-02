package ss.it.entity;

import lombok.Data;

@Data
public class Employee extends Person {
	private String desg;
	private Float salary;
	private String company;

	@Override
	public String toString() {
		return "Employee=>" + desg + "-" + salary + "-" + company+"-"+super.toString();
	}

}
