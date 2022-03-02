package ss.it.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public  class Product {
	@Id
	@GeneratedValue
	private Integer pid;
	private String pname;
	private Integer price;
	private Float qty;

}
