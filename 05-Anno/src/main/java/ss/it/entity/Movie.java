package ss.it.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ss.it.proxy.IMovie;

@Entity
@Table(name="Movie_info")
@Data//lombok api
@AllArgsConstructor
@NoArgsConstructor
//@DynamicInsert(value = true)
//@DynamicUpdate(value = true)
//@Proxy(lazy=false)
@Proxy(lazy=true,proxyClass = ss.it.proxy.IMovie.class)
public  class Movie implements IMovie{
	
	@Id//sigular id filed
	@GeneratedValue(generator = "increment")
	@Column(name="mid")//mapping with column name
	private Integer mid;
	@Column(name="mname",length=20)//mapping with column name
	private String mname;
	@Column(name="hero",length = 20)//mapping with column name
	private String hero;
	@Column(name="budget")//mapping with column name
	@Transient
	private Float budget;

}
