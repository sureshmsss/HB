package ss.it.entity;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public  class Person {
	private Integer id;
	private String name;
	private String address;
	private String gender;

}
