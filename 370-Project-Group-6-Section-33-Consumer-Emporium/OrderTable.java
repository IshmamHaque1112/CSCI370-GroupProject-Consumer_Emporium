import java.util.ArrayList;
import java.util.List;
public class OrderTable {

	   private String name = "";
	   private int customerid;
	   private int orderid;
	   private int totalquantity=0;
	   private double totalcost=0;
	   private int DateOfPurchase;
	   public static ArrayList<OrderTable> orderList = new  ArrayList<OrderTable>();

	   public OrderTable(String name,int customerid, int orderid, 
			  int totalquantity, double totalcost,int DateOfPurchase ) {
	      this.name = name;
	      this.customerid = customerid;
	      this.orderid = orderid;
	      this.totalquantity = totalquantity;
	      this.totalcost = totalcost;
	      this.DateOfPurchase = DateOfPurchase;
	   orderList = new ArrayList<OrderTable>();
	   }
	 
	   public void add(OrderTable e) {
		   orderList.add(e);
	   }
	 
	   public void remove(OrderTable e) {
		   orderList.remove(e);
	   }
	 
	   public List<OrderTable> getOrders(){
	     return orderList;
	   }
	 
	   public String toString(){
	      return ("Order :[ Name : "+ name 
	      + ", Custoer ID : " + customerid + ", Order ID:" + orderid + ", Quantity" + totalquantity
	      + ". Total balance" + totalcost + ", Purchase Date" + DateOfPurchase+ "]");
	   }   
	}

