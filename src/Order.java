import java.sql.Date;

public class Order {
	private int shopper_id, order_id;
	private Date order_date;
	private double amount;

	public Order(int shopper_id, int order_id, Date order_date, double amount) {
		this.shopper_id = shopper_id;
		this.order_id = order_id;
		this.order_date = order_date;
		this.amount = amount;
	}

	public int getShopper_id() {
		return shopper_id;
	}

	public void setShopper_id(int shopper_id) {
		this.shopper_id = shopper_id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
