public abstract class Person {
 
  private String name = "";
  private double wage; //how much they get per day
  private double balance; //pool of money they can use

  Person(String name, double wage, double balance){
    this.name = name;
    this.wage = wage;
    this.balance = balance;
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
}