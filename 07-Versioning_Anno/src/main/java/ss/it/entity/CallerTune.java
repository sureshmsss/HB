package ss.it.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Data;
@Entity
@Data
@Table(name="Callertune")
public  class CallerTune {
	@Id
	@GeneratedValue
	private Integer tuneId;
	@Column
	private String tuneName;
	@Column
	private String movieName;
	@Version
	private Integer updationCount;

}
