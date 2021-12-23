public abstract class Ticket implements Cloneable{
	private String customerName; 
	private int id,customerId,order;
	   protected String type;
	   
	   abstract void type();
	   
	   //the type of ticket
	   public String getType(){
	      return type;
	   }
	   
	   //ticketing cache order
	   public int getId() {
	      return id;
	   }
	   
	   public void setId(int id) {
	      this.id = id;
	   }
	   
	   //filling customer id related to membership
	   public int getCustomerId() {
	      return customerId;
	   }
	   
	   public void setCustomerId(int customerId) {
	      this.customerId = customerId;
	   }
	   
	   //filling the customer name
	   public String getName() {
		   return customerName;
		   }
		   
	   public void setName(String name) {
		      this.customerName = name;
		      }
	   
	   //filling for product
	   public int getOrder() {
		   return order;
		   }
		   
	   public void setOrder(int orderNum) {
		      this.order = orderNum;
		      }
	   
	   public Object clone() {
	      Object clone = null;
	      
	      try {
	         clone = super.clone();
	         
	      } catch (CloneNotSupportedException e) {
	         e.printStackTrace();
	      }
	      
	      return clone;
	   }
	   public String toString() {
		      return " Name:"+customerName + " " + type+" order#:"+order+" ID:"+customerId;
		   }
}
