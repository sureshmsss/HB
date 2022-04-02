package ss.it.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "INH_ANNO_TPCC_Payment")//remain empty table
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // TPSC
public class Payment {

	@Id
	@GeneratedValue
	private Integer txId;
	private Double amount;
	private LocalDateTime txDate;

	@Override
	public String toString() {
		return "Payment [txId=" + txId + ", amount=" + amount + ", txDate=" + txDate + "]" + super.toString();
	}

}
