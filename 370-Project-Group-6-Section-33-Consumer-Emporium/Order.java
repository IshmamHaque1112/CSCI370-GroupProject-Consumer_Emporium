import java.util.*;
public class Order{
int orderid;
int totalquantity=0;
double totalcost=0;
int DateOfPurchase;
HashMap<Product, Integer> orderedproducts = new HashMap<>();
Customer Customer1;
Employee Employee1;
  
  Order(int orid,int orDateOfPurchase, Customer orCustomer,Employee Employee1){
    this.orderid = orid;
    this.DateOfPurchase = orDateOfPurchase;
    this.Customer1 = orCustomer;
    this.Employee1=Employee1;
  }

  public int getId(){
    return this.orderid;
  }
  public HashMap<Product,Integer> getmap(){
    return this.orderedproducts;
  }
  public void setid(int orid){
    this.orderid = orid;
  }
  public void addProduct(Product newproduct,int quantity){
   if(this.orderedproducts.containsKey(newproduct)){
     int newq1=this.orderedproducts.get(newproduct)+quantity;
     this.orderedproducts.replace(newproduct, newq1);
     //this.orderedproducts.put(newproduct,this.orderedproducts.get(newproduct)+quantity);
   }
   else{
     this.orderedproducts.put(newproduct,quantity);
   }
   this.totalquantity=this.totalquantity+quantity;
   this.totalcost=this.totalcost+(newproduct.getPrice()*quantity)*(1-this.Customer1.getDiscount());
  }
  public int getDateOfPurchase(){
    return this.DateOfPurchase;
  }
  public void setDateOfPurchase(int orDateOfPurchase){
    this.DateOfPurchase = orDateOfPurchase;
  }
  public int getQuantity(){
    return this.totalquantity;
  }
  public int productquantity(Product a){
    if(this.orderedproducts.containsKey(a)==true){
    return this.orderedproducts.get(a);}
    else return 0;
  }
  public double getTotalCost(){
    return this.totalcost;
  }
  public void removeProduct(Product p){
    this.orderedproducts.remove(p);
  }
  public Customer getCustomer(){
    return this.Customer1;
  }
  public void setCustomer(Customer orCustomer){
    this.Customer1 = orCustomer;
  }
  public Employee getEmployee(){
    return this.Employee1;
  }
  public void setEmployee(Employee orEmployee){
    this.Employee1 = orEmployee;
  }
  public void allProductsOrdered(){
    this.orderedproducts.forEach((k, v) -> System.out.println(k.getproductName() + " : " + v));
  }
}
//we can use order ids as the key
//we do set and get too right?
//adding it wouldn't hurt
//i guess no harm in it
//one second I forgot the set and get looool
//apparently dictionaries in java are hashmap or hashtable