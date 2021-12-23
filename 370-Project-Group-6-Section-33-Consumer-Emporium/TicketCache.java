import java.util.Hashtable;
import java.util.*;
public class TicketCache {
	
   private static final Hashtable<Integer, Ticket> exchangeMap  = new Hashtable<Integer, Ticket>();
   private static final Hashtable<Integer, Ticket> refundMap  = new Hashtable<Integer, Ticket>();
   private static final Hashtable<Integer, Ticket> concernsMap  = new Hashtable<Integer, Ticket>();

   private static int indexE=0,indexR=0,indexC=0;

   public static Ticket getTicket(Integer shapeId) {
      Ticket cachedTicket = exchangeMap.get(shapeId);
      return (Ticket) cachedTicket.clone();
   }

public static void addExchange(Customer cust0,int orderNum, ArrayList<Order> orderList) {
	Exchange exchange = new Exchange();
    exchange.setId(++indexE);
    exchange.setCustomerId(cust0.getID());
    exchange.setName(cust0.getName());

    exchangeMap.put(indexE,exchange);  
}

public static void addRefund(Customer cust0, int orderNum, ArrayList<Order> orderList) {
	Refund refund = new Refund();
	refund.setId(++indexR);
	refund.setCustomerId(cust0.getID());
	refund.setName(cust0.getName());
	refund.setOrder(orderNum);

    refundMap.put(indexR,refund);
    
    //current order cost
    double refundTotal = orderList.get(orderNum).getTotalCost();
    cust0.changeBalance(refundTotal);
}

public static void addConcern(Customer cust0) {
	Feedback concern = new Feedback();
	concern.setId(++indexC);
	concern.setCustomerId(cust0.getID());
	concern.setName(cust0.getName());

    concernsMap.put(indexR,concern);  
}

public void print() {
	
	System.out.println("Exchange tickets: "+exchangeMap);
	System.out.println("Refund tickets: "+refundMap);
	System.out.println("Concern tickets: "+concernsMap);
}



}
