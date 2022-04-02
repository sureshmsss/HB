package ss.it.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="INH_ANNO_TPCC_CardPayment")
public class CardPayment extends Payment {

	private Long cardNo;
	private String cardType;
	private String gateWay;

	@Override
	public String toString() {
		return "CardPayment [cardNo=" + cardNo + ", cardType=" + cardType + ", gateWay=" + gateWay + "]"
				+ super.toString();
	}

}
