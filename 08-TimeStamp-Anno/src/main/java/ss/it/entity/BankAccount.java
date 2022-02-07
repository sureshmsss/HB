package ss.it.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
	@Id
	@GeneratedValue
	private Integer acno;
	private String pwd;
	private Long mobNo;
	private LocalDateTime time;
	@Version
	private Integer count;
	@CreationTimestamp
	private Timestamp creationTime;
	@UpdateTimestamp
	private Timestamp lastUpdated;

}
