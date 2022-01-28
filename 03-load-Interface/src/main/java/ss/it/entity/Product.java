package ss.it.entity;

import lombok.Data;

@Data
public  class Product implements IProduct{
	private Integer pid;
	private String pname;
	private Integer price;
	private Float qty;

}
