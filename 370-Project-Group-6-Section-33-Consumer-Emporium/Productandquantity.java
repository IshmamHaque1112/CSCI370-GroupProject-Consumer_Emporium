public class Productandquantity{
public Product p1;
public int pid;
public int currentquantity=0;
public int originalquantity=0;
public double currentdiscount=0;
public Productandquantity(Product p2,int q1){
  this.p1=p2;
  this.currentquantity=q1;
  this.pid=p2.getproductid();
  this.originalquantity=q1;
}
public void getProductSummary(){
      if(this.p1 instanceof Clothing){
        Clothing a=(Clothing)this.p1;
        System.out.println(a.getSummary()+"\n");
      }
      if(this.p1 instanceof Electronic){
        Electronic a=(Electronic)this.p1;
        System.out.println(a.getSummary()+"\n");
      }
      if(this.p1 instanceof EntertainmentMedia){
        EntertainmentMedia a=(EntertainmentMedia)this.p1;
        System.out.println(a.getSummary()+"\n");
      }
      if(this.p1 instanceof FoodorDrink){
        FoodorDrink a=(FoodorDrink)this.p1;
        System.out.println(a.getSummary()+"\n");
      }
      if(this.p1 instanceof Medicinesandsupplements){
        Medicinesandsupplements a=(Medicinesandsupplements)this.p1;
        System.out.println(a.getSummary()+"\n");
      }
      if(this.p1 instanceof Toolsandappliances){
        Toolsandappliances a=(Toolsandappliances)this.p1;
        System.out.println(a.getSummary()+"\n");
      }
      if(this.p1 instanceof Toys){
        Toys a=(Toys)this.p1;
        System.out.println(a.getSummary()+"\n");
      }
      if(this.p1 instanceof Weapons){
        Weapons a=(Weapons)this.p1;
        System.out.println(a.getSummary()+"\n");
      }
 }
 public void changeProductQuantity(int q3){
   this.currentquantity=this.currentquantity+q3;
 }
 public void changeProductQuantityPermanent(){
   this.originalquantity=this.currentquantity;
 }
 public void restoreoriginalquantity(){
   this.currentquantity=this.originalquantity;
 }
 public void newdiscount(Double newdisc){
   this.currentdiscount=newdisc;
   this.p1.changepricetodiscount(newdisc);
 }
 public void restoreoriginal(){
   this.currentdiscount=0;
   this.p1.restoreprice();
 }
 public int getid(){
   return this.p1.getproductid();
 }
}
