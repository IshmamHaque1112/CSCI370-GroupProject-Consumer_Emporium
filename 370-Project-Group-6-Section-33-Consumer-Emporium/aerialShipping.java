//Joshua Wang - Part of Factory Pattern. Class implements the interface shipping. Each shipping has an order attached to it.

public class aerialShipping implements Shipping{

Order shipment;
@Override
public void shipOrder(){
System.out.println("Shipment no." + this.shipment.orderid + " sent by air.");
}
@Override
public void calculateCosts(){ 
  System.out.println("Order no." + this.shipment.orderid + " will cost " + (this.shipment.totalcost*1.30) + " if shipped by air.");
}

public aerialShipping(Order oshipment){
this.shipment = oshipment;
}

}