import java.util.*;
public class PrototypePatternTicket {
	
	//public static ArrayList<Customer> customerList = new  ArrayList<Customer>();
	
	public void createTicket(Customer cust0,char n,int orderNum, ArrayList<Order> orderList) {
		if (n == 'e')
		 TicketCache.addExchange(cust0,orderNum,orderList);
		else if (n =='r')
		TicketCache.addRefund(cust0,orderNum,orderList);
		else
		TicketCache.addConcern(cust0);
	   }
}
