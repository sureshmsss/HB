package ss.it.entity;

public interface IProduct {
	public Integer getPid();

	public String getPname();

	public Integer getPrice();

	public Float getQty();

	public void setPid(Integer pid);

	public void setPname(String pname);

	public void setPrice(Integer price);

	public void setQty(Float qty);

}
