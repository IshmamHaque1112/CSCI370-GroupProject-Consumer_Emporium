//Joshua Ng
public class PersonTest{
 
  private String name = "";
  private double wage; //how much they get per day
  private double balance; //pool of money they can use
  public PersonType t;
  private int type, id;
  public Boss bosst;
  public Customer customert;
  public Employee employeet;
  PersonTest(String name, double wage, double balance, int id, int type){
    this.name = name;
    this.wage = wage;
    this.balance = balance;
    this.type = type;
    this.id = id;
    if(type == 1){
      t = new Boss(name, wage, balance, id);
      bosst = new Boss(name, wage, balance, id);
    }
    if(type == 2){
      t = new Employee(name, wage, balance, id);
      employeet = new Employee(name, wage, balance, id);
    }
    if(type == 3){
      t = new Customer(name, wage, balance, id);
      customert = new Customer(name, wage, balance, id);
    }
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

  public void balanceIncrease(){
    this.balance=this.balance + this.wage;
  }
};