package ss.it.entity;

import javax.persistence.Table;

import lombok.Data;

@Data
//@Table(name="SP_Product")
public  class Product {
	private Integer pid;
	private String pname;
	private Integer price;
	private Float qty;

}
