package ss.it.entity;

import lombok.Data;

@Data
//@Table(name="SP_Product")
public  class Product {
	private Integer pid;
	private String pname;
	private Float price;
	private Float qty;

}
