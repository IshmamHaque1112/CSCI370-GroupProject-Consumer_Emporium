//Joshua Ng
public class Employee implements PersonType {
  private String name = "";
  private double wage; //how much they get per day
  private double balance; //pool of money they can use
  //private String jobTitle = "";
  private int empid;
  public Employee(String name, double wage, double balance, int id){
    
    this.name = name;
    this.wage = wage;
    this.balance = balance;
    this.empid=id;
  }
  public void changeID(int a){
   this.empid=a;
  }
  public int getID(){
    return this.empid;
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
    return "Employee";
  }
  
}