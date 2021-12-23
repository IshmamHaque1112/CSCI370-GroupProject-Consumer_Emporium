//Joshua Wang - Part of Factory Pattern. Class implements the interface shipping. We use this to return a type of shipping given a location.

public class shippingFactory{
public Shipping createShipment(Order shippedorder, String Location){

if (Location == null) return null;

else if (Location.equals("USA")){
return new groundShipping(shippedorder);
}

else {
return new aerialShipping(shippedorder);
}
}
}