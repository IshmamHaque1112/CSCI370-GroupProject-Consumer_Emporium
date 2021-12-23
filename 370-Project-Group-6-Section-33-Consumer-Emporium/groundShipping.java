//Joshua Wang - Part of Factory Pattern. Class implements the interface shipping. Each shipping has an order attached to it.

public class groundShipping implements Shipping{

Order shipment;
@Override
public void shipOrder(){
System.out.println("Shipment no." + this.shipment.orderid + " sent by ground.");
}
@Override
public void calculateCosts(){ 
  System.out.println("Order no." + this.shipment.orderid + " will cost " + (this.shipment.totalcost*1.15) + " if shipped by ground.");
}

public groundShipping(Order oshipment){
this.shipment = oshipment;
}

}
