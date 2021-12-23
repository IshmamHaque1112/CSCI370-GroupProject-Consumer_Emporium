//Joshua Ng
public class Boss implements PersonType {
  private String name = "";
  private double wage; //how much they get per day
  private double balance; //pool of money they can use
  //private String jobTitle = "";
  private int id;
  public Boss(String name, double wage,double balance, int id){

    this.name = name;
    this.wage = wage;
    this.balance = balance;
    this.id = id;

    //this.jobTitle = jobTitle;
  }
   /*public String getJobTitle(){
    return jobTitle;
  }
  public void setJobTitle(String jobTitle){
    this.jobTitle = jobTitle;
  }*/
  public String getName(){
    return this.name;
  }

  public void setName(String name){
    this.name = name;
  }

  public double getWage(){
    return this.wage;
  }
  public int getID(){
    return this.id;
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
    return "CEO";
  }


}