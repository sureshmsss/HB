package ss.it.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Movie_info")
@Data//lombok api
@AllArgsConstructor
@NoArgsConstructor
public  class Movie {
	
	@Id//sigular id filed
	@Column(name="mid")//mapping with column name
	private Integer mid;
	@Column(name="mname",length=20)//mapping with column name
	private String mname;
	@Column(name="hero",length = 20)//mapping with column name
	private String hero;
	@Column(name="budget")//mapping with column name
	private Float budget;

}
