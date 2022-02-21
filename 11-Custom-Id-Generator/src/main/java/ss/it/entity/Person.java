package ss.it.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="person1")//for guid generator we used new tab name and id val as string type
public class Person  {
	private Integer id;
	private String name;
	private String address;
	private String gender;

}
