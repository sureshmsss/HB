package ss.it.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "INH_ANNO_TPSC_ChequePayment")
@PrimaryKeyJoinColumn(name = "pay_Id", referencedColumnName = "txId")
public class ChequePayment extends Payment {
	private Long chequeNo;
	private String chequeType;

	@Override
	public String toString() {
		return "ChequePayment [chequeNo=" + chequeNo + ", chequeType=" + chequeType + "]" + super.toString();
	}

}
