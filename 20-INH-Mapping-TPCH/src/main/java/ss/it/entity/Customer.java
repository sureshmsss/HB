package ss.it.entity;

import lombok.Data;

@Data
public class Customer extends Person {
	private Integer billNo;
	private Float billAmt;

	@Override
	public String toString() {
		return "Customer=>" + billNo + "-" + billAmt+"-"+super.toString();
	}

}
