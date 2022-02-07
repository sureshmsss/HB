package ss.it.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="adaar_pan_link")
@NoArgsConstructor
@AllArgsConstructor
public class Adaar_Pan_Link {
	// has - a property
	@EmbeddedId
	private AadarWithPAN_ID apid;

	private String name;
	private String desg;
	private Float salary;

}