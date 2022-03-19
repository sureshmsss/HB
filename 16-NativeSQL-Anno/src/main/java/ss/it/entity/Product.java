package ss.it.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedNativeQuery;

import lombok.Data;

@Data
@Entity
@Table(name = "Product")
@NamedNativeQuery(name = "GET_PROD_BY_PRICE", query = " select * from Product where price<=? and price>=?", resultClass = Product.class)
@NamedNativeQuery(name = "GET_PROD_BY_QTY", query = " select * from Product where qty<=? and qty>=?", resultClass = Product.class)
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid;
	@Column(length = 20)
	private String pname;
	private Float price;
	private Float qty;

	public Product() {
		System.out.println("product()=>" + this.hashCode());
	}

}
