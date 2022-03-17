package ss.it.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Product")
@NamedQuery(name = "GET_PRODUCTS_BY_PRICE", query = " from Product where price<=:max and price>=:min")
public class Product {
	@Id
	@GeneratedValue
	private Integer pid;
	@Column(length = 20)
	private String pname;
	private Float price;
	private Float qty;

}
