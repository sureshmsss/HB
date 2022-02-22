package ss.it.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "person_jpa")
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	/*	// Identity generator of JPA works with mysql db only
		@Id // singular id field
		@GeneratedValue(strategy = GenerationType.IDENTITY)*/

	/*	// Sequence type-1 generator of JPA works with both mysql db and oracle db 
		@Id // singular id field
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
	*/
	// Sequence type-2 creating our sequence dynamically with given values
	/*		@Id // singular id field
			@SequenceGenerator(name = "gen1", sequenceName = "my_jpa_id", initialValue = 100, allocationSize = 2)
			@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
		 // Sequence type-3 creating our sequence dynamically with default values
		@Id // singular id field//here default initial value=1 and allocation=52 =>1,52,102,152,202
		@SequenceGenerator(name = "gen1", sequenceName = "my_jpa_id")
		@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
		
	// Table type-1 creating our sequence dynamically with default values
	@Id // singular id field//here default initial value=1 and allocation=52
		// =>1,52,102,152,202
	@TableGenerator(name = "gen1", pkColumnName = "id_col", table = "my_jpa_tab", pkColumnValue = "pid", valueColumnName = "val_col", initialValue = 100, allocationSize = 2)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.TABLE)
	*/
	@Id // singular id field//here default sequence is HIBERNATE_SEQUENCES(YES S) WITH
		// initial value=1 and allocation=1
	@GeneratedValue(strategy = GenerationType.TABLE)

	private Integer id;
	@Column(name = "name", length = 20)
	private String name;
	@Column(name = "address", length = 20)
	private String address;
	@Column(name = "gender", length = 20)
	private String gender;

}
