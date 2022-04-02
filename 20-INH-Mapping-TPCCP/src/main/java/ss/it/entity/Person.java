package ss.it.entity;

import javax.persistence.Table;

import lombok.Data;

@Data
//@Table(name = "INH_Person")
public class Person {
	private Integer id;
	private String name;
	private String address;

	@Override
	public String toString() {
		return "Person=>" + id + "-" + name + "-" + address;
	}

}
