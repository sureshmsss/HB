package ss.it.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="aadarwithPan_id")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AadarWithPAN_ID implements Serializable {

	private Long auid;
	private Long panNo;

}