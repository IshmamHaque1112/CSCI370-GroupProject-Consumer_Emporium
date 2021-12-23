//Joshua Ng 
import java.util.*;
public class Customer implements PersonType {
  private String name = "";
  private double wage; //how much they get per day
  private double balance; //
  private int ordersmade=0;
  private double discount=0;
  private int custid;
  private ArrayList<Product> wishList = new ArrayList<Product>();
  private ArrayList<Customer> friends = new ArrayList<Customer>();
  private ArrayList<Integer> friendRequest = new ArrayList<Integer>();
  private String title;
  private int ismember=0;
   Customer(String name, double wage, double balance, int id){
    
    this.name = name;
    this.wage = wage;
    this.balance = balance;
    this.custid=id;
  }
  public int returnmembership(){
    return this.ismember;
  }
  public void changetomember(){
    this.ismember=1;
  }
  public void changeMember(int a){
    this.ismember=a;
  }
  public void changeID(int a){
   this.custid=a;
  }
  public int getID(){
    return this.custid;
  }
  public ArrayList<Product> returnwishlist(){
    return this.wishList;
  }
  public void addToWishList(Product item){
    this.wishList.add(item);
  }

  public void removeFromWishList(Product item){
    for(int i = 0; i < this.wishList.size(); i++){
      if(item.getproductid() == this.wishList.get(i).getproductid()){
        this.wishList.remove(i);
      }
    }
  }
  public int numoforders(){
    return this.ordersmade;
  }
  public void increaseorders(int neworders){
    this.ordersmade=this.ordersmade+neworders;
  }
  public double getDiscount(){
    return this.discount;
  }
  public void editDiscount(double a){
    this.discount=a;
  }
  public void changeDiscount(){
    if(this.ordersmade>3) this.discount=0.33;
    else if(this.ordersmade>6) this.discount=0.5;
  }
  public String getName(){
    return this.name;
  }

  public void setName(String name){
    this.name = name;
  }

  public double getWage(){
    return this.wage;
  }

  public void setWage(double wage){
    this.wage = wage;
  }

  public double getBalance(){
    return this.balance;
  }

  public void setBalance(double balance){
    this.balance = balance;
  }
  public void changeBalance(double money){
    this.balance=this.balance+money;
  }
  public void balanceIncrease(){
    this.balance=this.balance + this.wage;
  }

  public String jobTitle(){
    return "Customer";
  }
  //Notify the discount
  public void update()
  {
    System.out.println("dear" + name + ", there are items on discount");
  }
  public void alterfriendrequest(Customer friender){
    this.friendRequest.add(friender.getID());
  }
  public void alterfriend(Customer friender){
    this.friends.add(friender);
  }
  public void acceptfriendrequest(Customer befriended){
   System.out.println(befriended.getName()+" is now a friend.");
   this.alterfriend(befriended);
   befriended.alterfriend(this);
   for(int i=0;i<this.friendRequest.size();i++){
      if(this.friendRequest.get(i)==befriended.getID()) this.friendRequest.remove(i);
    }
  }
  
  public void returnfriendrequest(ArrayList<Customer> custarray){
    for(int i=0;i<this.friendRequest.size();i++){
    int currid=this.friendRequest.get(i);
    System.out.println(i+" ID:"+this.friendRequest.get(i)+" Name: "+custarray.get(currid-1).getName());
   };
  }
 public void PrintFriends(){
   for(int i=0;i<this.friends.size();i++){
    Customer currentcust=this.friends.get(i);
    System.out.println("Index: "+i+" ID: "+currentcust.getID()+" Name:"+ currentcust.getName());
   }
 }
 public boolean isFriendinList(int a){
   for(int i=0;i<this.friends.size();i++){
    if(this.friends.get(i).getID()==a) return true;
   }
   return false;
 }
 public ArrayList<Customer> friendList(){
   return this.friends;
 }
 public ArrayList<Integer> friendRequestList(){
   return this.friendRequest;
 }
 public boolean isCustomerinFriendRequest(int b){
   for(int i=0;i<this.friendRequest.size();i++){
    if(this.friendRequest.get(i)==b) return true;
   }
   return false;
 }
}