package ss.it.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "ORM_Product")
public class Product {
	@Id
	@GeneratedValue
	private Integer pid;
	private String pname;
	private Float price;
	private Float qty;
	private Shop details;

}
