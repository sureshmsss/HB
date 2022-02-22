package ss.it.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "person1")
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	/*//increment generator
	 * 	@Id // singular id field
		@Column(name = "id") // if table & class props are same then col is optional
		@GenericGenerator(name = "gen1", strategy = "increment")
		@GeneratedValue(generator = "gen1")
	*/
	// identity generator
	/*@Id // singular id field
	@Column(name = "id") // if table & class props are same then col is optional
	@GenericGenerator(name = "gen1", strategy = "identity")
	@GeneratedValue(generator = "gen1")*/
	// sequence generator type-1 normal
	/*@Id // singular id field
	@Column(name = "id") // if table & class props are same then col is optional
	@GenericGenerator(name = "gen1", strategy = "sequence")
	@GeneratedValue(generator = "gen1")
	*/
	// sequence generator type-2 using availed sequence
	/*	@Id // singular id field
		@Column(name = "id") // if table & class props are same then col is optional
		@GenericGenerator(name = "gen1", strategy = "sequence",
		parameters = {@Parameter(name="sequence_name",value="hibernate_sequence")})
		@GeneratedValue(generator = "gen1")
	*/
	// sequence generator type-2 using availed sequence
	@Id // singular id field
	@Column(name = "id") // if table & class props are same then col is optional
	@GenericGenerator(name = "gen1", strategy = "sequence", parameters = {
			@Parameter(name = "sequence_name", value = "my_seq_anno_id"),
			@Parameter(name = "initial_value", value = "10000"),
			@Parameter(name = "increment_size", value = "1") })
	@GeneratedValue(generator = "gen1")
	private Integer id;
	@Column(name = "name", length = 20)
	private String name;
	@Column(name = "address", length = 20)
	private String address;
	@Column(name = "gender", length = 20)
	private String gender;

}
