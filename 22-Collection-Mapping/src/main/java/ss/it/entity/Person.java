package ss.it.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	@Id
	@GeneratedValue
	private Integer pid;
	private String pname;
	private String address;

	private List<String> nickNames;
	private List<String> friends;
	private Set<Long> phones;
	private Map<String, Long> idCards;

}
