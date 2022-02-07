package ss.it.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
//	@Id
//	@GeneratedValue
	private Integer acno;
	private String pwd;
	private Long mobNo;
	private LocalDateTime time;
	private Timestamp lastUpdated;

}
