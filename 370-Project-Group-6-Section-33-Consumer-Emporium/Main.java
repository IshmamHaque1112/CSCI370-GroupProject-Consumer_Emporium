import java.util.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
class Main {
  public static int currentday=1;
  public static int maxdays=7;
  public static int baselinecustid=1;
  public static int baselineempid=1;
  public static int baselineproductid=1;
  public static int baselineorderid=1;
  public static double storewealth=100000000;
  public static Boss boss1;
  public static int bossid=1;
  public static ArrayList<Order> orderList = new  ArrayList<Order>();
  public static ArrayList<Customer> customerList = new  ArrayList<Customer>();
  public static ArrayList<Employee> employeeList = new ArrayList<Employee>();
  public static ArrayList<Productandquantity> stockedproducts = new ArrayList<Productandquantity>();
  public static List<Customer> OBS = new ArrayList<>();
  public static double OBSdiscount=0;
  public static ArrayList<Product> proposedList = new ArrayList<Product>();
  public static int searchEmployeebyid(ArrayList<Employee> emplist, int id){
    for(int i=0;i<emplist.size();i++){
         if(id==emplist.get(i).getID()) return i;
    }
    return id-1;
  }
  public static int searchCustomerbyid(ArrayList<Customer> custlist, int id){
    for(int i=0;i<custlist.size();i++){
         if(id==custlist.get(i).getID()) return i;
    }
    return id-1;
  }
  public static void PrintAllProducts(ArrayList<Productandquantity> mittens){
    for(int i=0;i<mittens.size();i++){
      System.out.println("\n");
      System.out.println("product: " +mittens.get(i).getid()+" Quantity: "+mittens.get(i).currentquantity);
      if(mittens.get(i).p1 instanceof Clothing){
        Clothing a=(Clothing)mittens.get(i).p1;
        System.out.println(a.getSummary()+"\n");
        if(mittens.get(i).currentdiscount!=0) System.out.println("Discount: "+mittens.get(i).currentdiscount);
      }
      if(mittens.get(i).p1 instanceof Electronic){
        Electronic a=(Electronic)mittens.get(i).p1;
        System.out.println(a.getSummary()+"\n");
        if(mittens.get(i).currentdiscount!=0) System.out.println("Discount: "+mittens.get(i).currentdiscount);
      }
      if(mittens.get(i).p1 instanceof EntertainmentMedia){
        EntertainmentMedia a=(EntertainmentMedia)mittens.get(i).p1;
        System.out.println(a.getSummary()+"\n");
        if(mittens.get(i).currentdiscount!=0) System.out.println("Discount: "+mittens.get(i).currentdiscount);
      }
      if(mittens.get(i).p1 instanceof FoodorDrink){
        FoodorDrink a=(FoodorDrink)mittens.get(i).p1;
        System.out.println(a.getSummary()+"\n");
        if(mittens.get(i).currentdiscount!=0) System.out.println("Discount: "+mittens.get(i).currentdiscount);
      }
      if(mittens.get(i).p1 instanceof Medicinesandsupplements){
        Medicinesandsupplements a=(Medicinesandsupplements)mittens.get(i).p1;
        System.out.println(a.getSummary()+"\n");
        if(mittens.get(i).currentdiscount!=0) System.out.println("Discount: "+mittens.get(i).currentdiscount);
      }
      if(mittens.get(i).p1 instanceof Toolsandappliances){
        Toolsandappliances a=(Toolsandappliances)mittens.get(i).p1;
        System.out.println(a.getSummary()+"\n");
        if(mittens.get(i).currentdiscount!=0) System.out.println("Discount: "+mittens.get(i).currentdiscount);
      }
      if(mittens.get(i).p1 instanceof Toys){
        Toys a=(Toys)mittens.get(i).p1;
        System.out.println(a.getSummary()+"\n");
        if(mittens.get(i).currentdiscount!=0) System.out.println("Discount: "+mittens.get(i).currentdiscount);
      }
      if(mittens.get(i).p1 instanceof Weapons){
        Weapons a=(Weapons)mittens.get(i).p1;
        System.out.println(a.getSummary()+"\n");
        if(mittens.get(i).currentdiscount!=0) System.out.println("Discount: "+mittens.get(i).currentdiscount);
      }
    }
  }
  public static Product searchProduct(ArrayList<Productandquantity> mittens,int prid){
    for(int i=0;i<mittens.size();i++){
    if(mittens.get(i).getid()==prid){
      return mittens.get(i).p1;
    }
    }
    return null;
  }
  public static int searchProductIndex(ArrayList<Productandquantity> mittens,int prid){
    for(int i=0;i<mittens.size();i++){
    if(mittens.get(i).getid()==prid){
      return i;
    }
    }
    return -1;
  }
  public static void changeQuantity(ArrayList<Productandquantity> mittens,Product p,int q){
     for(int i=0;i<mittens.size();i++){
      if(mittens.get(i).getid()==p.getproductid()){
      mittens.get(i).currentquantity=mittens.get(i).currentquantity+q;
      }
     }
  }
  //line 103-121,545-558, and 980-1002
  //Observer Pattern
  //Bhokai Larbpaiboonpong
  //The mall(subject) will notify the customers who purchased a membership(observers) the list of discounted items
   public static void addCustomertoOBSArray(Customer name)
  {
    OBS.add(name);
  }
  public static void removeCustomertoOBSArray(Customer name)
  {
    OBS.remove(name);
  }
  public static void update(Customer name)
  {
    System.out.println("dear," + name.getName() + ", there are items on discount");
  }
  public static void discountTitle()
  {
    for(Customer name:OBS)
    {
      System.out.println("Announcement about the discount "+name.getName()+". You all have been given a discount of "+OBSdiscount);
    }
  }
  public static void main(String[] args) {
    System.out.println("Good day. Today we begin running the Consumer Emporium, a superstore founded 20 years ago by Miner Krafter. However, it fell into bankruptcy and we here at Group 6 have revived it and are putting it to work. We will run it for 7 days and see if we can avoid bankruptcy. First we must create a boss and some basic stockings of products.");
    String bossname;
    double bosswage; 
    double bossbalance; 
    Scanner scan=new Scanner(System.in);
    //String bossjobTitle;
    System.out.println("name");	
		bossname=scan.nextLine();
    while(bossname==null) bossname=scan.nextLine();
		System.out.println("wage");
		bosswage=scan.nextDouble();
		System.out.println("balance");
		bossbalance=scan.nextDouble();
		//System.out.println("Job title");
		//bossjobTitle=scan.next();
    int bossid = 1;
    //Joshua Ng State Pattern
    PersonTest boss0=new PersonTest(bossname,bosswage,bossbalance, bossid, 1);
    boss1=boss0.bosst;
    //the 1 after bossid goes to persontest constructor that creates boss
    System.out.println("Meet CEO "+boss1.getName());
    String empname;
    double empwage; 
    double empbalance;
    int employeeid;
    scan.nextLine(); 
    System.out.println("First employee name");	
		empname=scan.nextLine();
    while(empname==null) empname=scan.nextLine();
		System.out.println("First employee wage");
		empwage=scan.nextDouble();
		System.out.println("First employee balance");
		empbalance=scan.nextDouble();
    employeeid = baselineempid;
    baselineempid=baselineempid+1;
    PersonTest emp0=new PersonTest(empname,empwage,empbalance, employeeid, 2);
    Employee emp1=emp0.employeet;
    System.out.println("Meet First Employee "+emp1.getName());
    employeeList.add(emp1);
    String custname;
    double custwage; 
    double custbalance;
    int customerid;
    scan.nextLine(); 
    System.out.println("First customer name");	
		custname=scan.nextLine();
    while(custname==null) custname=scan.nextLine();
		System.out.println("First customer wage");
		custwage=scan.nextDouble();
		System.out.println("First customer balance");
		custbalance=scan.nextDouble();
    customerid = baselinecustid;
    baselinecustid=baselinecustid+1;
    PersonTest cust0=new PersonTest(custname,custwage,custbalance, customerid, 3);
    Customer cust1=cust0.customert;
    System.out.println("Meet First customer "+cust1.getName());
    customerList.add(cust1);
    FoodorDrink firstproduct= new FoodorDrink("Jerry's apples",baselineproductid,"Mr.Schmitt","Delicious and tasty","september 2022",12.2,"Food","Vitamins A and C");
    baselineproductid=baselineproductid+1;
    storewealth=storewealth-(firstproduct.getPrice()*25);
    Productandquantity a = new Productandquantity(firstproduct,25);
    stockedproducts.add(a);
  //Joshua Wang
  shippingFactory shipfactory = new shippingFactory();
  Order firstorder = new Order(baselineorderid,currentday, customerList.get(1-1),employeeList.get(1-1));
  firstorder.addProduct(searchProduct(stockedproducts,1),10);
  baselineorderid=baselineorderid+1;
  customerList.get(1-1).increaseorders(1);
  customerList.get(1-1).changeBalance(-1*firstorder.getTotalCost());
 Product zeta=searchProduct(stockedproducts,1);
 changeQuantity(stockedproducts,zeta,-10);
 storewealth=storewealth+firstorder.getTotalCost();
 orderList.add(firstorder);
Shipping groundship1 = shipfactory.createShipment(firstorder, "USA");
groundship1.shipOrder();
    int timetomove=0;
    while((currentday<=maxdays) && (storewealth>0)){
     int role;
      System.out.println("DAY:  "+currentday);
      System.out.println("Current wealth: "+storewealth);
      System.out.println("What role do you want to be? 1 for Boss, 2 for Employee, 3 for Customer,4 to see list of all persons. If you pick 5, if boss approves, then we move to the next day. \n");
      role=scan.nextInt();
      if(role==1){
       System.out.println("What is the id for Boss? (Your account's ID is 1)"); 
       int keeprunning1=1;
       int bossrole;
       bossrole=scan.nextInt();
       if(bossrole==bossid){
        int bosschoose;
        while(keeprunning1==1){
        System.out.println("What do you want to do "+boss1.getName()+"? 1 to add a new Product, 2 for creating discounts for a product, 3 to restock, 4 to add New Customer, 5 to add New Employee, 6 to make a new discount for membership, 7 to add your own money to store money,8 to get product from proposedlist, 9 to permit time change, 10 to get out.");
        bosschoose=scan.nextInt();
        if(bosschoose==1){
          int producttype;
          System.out.println("What type do you want to add? 1 for Clothing, 2 for Electronic, 3 to EntertainmentMedia, 4 for FoodorDrink, 5 for Medicinesandsupplements, 6 for Toolsandappliances, 7 for Toys, 8 for Weapons.");
          producttype=scan.nextInt();
          if(producttype==1){
           scan.nextLine();
           System.out.println("Name");
           String t1productname;
           t1productname=scan.nextLine();
           System.out.println("Description");
           String t1description;
           t1description=scan.nextLine();
           String t1expirationdate="None";
           System.out.println("Price");
           double t1priceofproduct;
           t1priceofproduct=scan.nextDouble();
           scan.nextLine();
           System.out.println("Producing Company");      
           String t1producercompany;
           t1producercompany=scan.nextLine();
           System.out.println("Clothing type");      
           String t1typeofclothing;
           t1typeofclothing=scan.nextLine();
           System.out.println("Made of");      
           String t1madeof;
           t1madeof=scan.nextLine();
           Clothing newp1=new Clothing(t1productname,baselineproductid,t1producercompany, t1description, t1expirationdate, t1priceofproduct,t1typeofclothing, t1madeof);
           baselineproductid=baselineproductid+1;
           System.out.println("How many quantity you want?");
           int newquant1;
           newquant1=scan.nextInt();
           storewealth=storewealth-(newp1.getPrice()*newquant1);
           Productandquantity newpq1= new Productandquantity(newp1,newquant1);
           stockedproducts.add(newpq1);
          }
          if(producttype==2){
           scan.nextLine();
           System.out.println("Name");
           String t1productname;
           t1productname=scan.nextLine();
           System.out.println("Description");
           String t1description;
           t1description=scan.nextLine();
           String t1expirationdate="None";
           System.out.println("Price");
           double t1priceofproduct;
           t1priceofproduct=scan.nextDouble();
           scan.nextLine();
           System.out.println("Producing Company");      
           String t1producercompany;
           t1producercompany=scan.nextLine();
           System.out.println("Type of Electronic");    
           String t1typeofelectronic;
           t1typeofelectronic=scan.nextLine();
           Electronic newp1=new Electronic(t1productname,baselineproductid,t1producercompany, t1description, t1expirationdate, t1priceofproduct,t1typeofelectronic);
           baselineproductid=baselineproductid+1;
           System.out.println("How many quantity you want?");
           int newquant1;
           newquant1=scan.nextInt();
           storewealth=storewealth-(newp1.getPrice()*newquant1);
           Productandquantity newpq1= new Productandquantity(newp1,newquant1);
           stockedproducts.add(newpq1);
          }
          if(producttype==3){
           scan.nextLine();
           System.out.println("Name");
           String t1productname;
           t1productname=scan.nextLine();
           System.out.println("Description");
           String t1description;
           t1description=scan.nextLine();
           String t1expirationdate="None";
           System.out.println("Price");
           double t1priceofproduct;
           t1priceofproduct=scan.nextDouble();
           scan.nextLine();
           System.out.println("Producing Company");      
           String t1producercompany;
           t1producercompany=scan.nextLine();
           System.out.println("Rating");    
           int t1rating;
           t1rating=scan.nextInt();  
           System.out.println("Type of Media");
           scan.nextLine();    
           String t1typeofmedia;
           t1typeofmedia=scan.nextLine();
           EntertainmentMedia newp1=new EntertainmentMedia(t1productname,baselineproductid,t1producercompany, t1description, t1expirationdate, t1priceofproduct,t1typeofmedia,t1rating);
           baselineproductid=baselineproductid+1;
           System.out.println("How many quantity you want?");
           int newquant1;
           newquant1=scan.nextInt();
           storewealth=storewealth-(newp1.getPrice()*newquant1);
           Productandquantity newpq1= new Productandquantity(newp1,newquant1);
           stockedproducts.add(newpq1);
          }
          if(producttype==4){
           scan.nextLine();
           System.out.println("Name");
           String t1productname;
           t1productname=scan.nextLine();
           System.out.println("Description");
           String t1description;
           t1description=scan.nextLine();
           System.out.println("Expiration date");
           String t1expirationdate;
           t1expirationdate=scan.nextLine();
           System.out.println("Price");
           double t1priceofproduct;
           t1priceofproduct=scan.nextDouble();
           scan.nextLine();
           System.out.println("Producing Company");      
           String t1producercompany;
           t1producercompany=scan.nextLine();
           System.out.println("Nutrition value");    
           String t1nutrition;
           t1nutrition=scan.nextLine();  
           System.out.println("Type Food or drink");
           String t1typefooddrink;
           t1typefooddrink=scan.nextLine();
           FoodorDrink newp1=new FoodorDrink(t1productname,baselineproductid,t1producercompany, t1description, t1expirationdate, t1priceofproduct,t1typefooddrink,t1nutrition);
           baselineproductid=baselineproductid+1;
           System.out.println("How many quantity you want?");
           int newquant1;
           newquant1=scan.nextInt();
           storewealth=storewealth-(newp1.getPrice()*newquant1);
           Productandquantity newpq1= new Productandquantity(newp1,newquant1);
           stockedproducts.add(newpq1);
          }
          if(producttype==5){
           scan.nextLine();
           System.out.println("Name");
           String t1productname;
           t1productname=scan.nextLine();
           System.out.println("Description");
           String t1description;
           t1description=scan.nextLine();
           System.out.println("Expiration date");
           String t1expirationdate;
           t1expirationdate=scan.nextLine();
           System.out.println("Price");
           double t1priceofproduct;
           t1priceofproduct=scan.nextDouble();
           scan.nextLine();
           System.out.println("Producing Company");      
           String t1producercompany;
           t1producercompany=scan.nextLine();
           System.out.println("Nutrition value");    
           String t1nutrition;
           t1nutrition=scan.nextLine();  
           System.out.println("Type Medicine or Supplement");   
           String t1typefooddrink;
           t1typefooddrink=scan.nextLine();
           Medicinesandsupplements newp1=new Medicinesandsupplements(t1productname,baselineproductid,t1producercompany, t1description, t1expirationdate, t1priceofproduct,t1typefooddrink,t1nutrition);
           baselineproductid=baselineproductid+1;
           System.out.println("How many quantity you want?");
           int newquant1;
           newquant1=scan.nextInt();
           storewealth=storewealth-(newp1.getPrice()*newquant1);
           Productandquantity newpq1= new Productandquantity(newp1,newquant1);
           stockedproducts.add(newpq1);
          }
          if(producttype==6){
           scan.nextLine();
           System.out.println("Name");
           String t1productname;
           t1productname=scan.nextLine();
           System.out.println("Description");
           String t1description;
           t1description=scan.nextLine();
           String t1expirationdate="None";
           System.out.println("Price");
           double t1priceofproduct;
           t1priceofproduct=scan.nextDouble();
           scan.nextLine();
           System.out.println("Producing Company");      
           String t1producercompany;
           t1producercompany=scan.nextLine();
           Toolsandappliances newp1=new Toolsandappliances(t1productname,baselineproductid,t1producercompany, t1description, t1expirationdate, t1priceofproduct);
           baselineproductid=baselineproductid+1;
           System.out.println("How many quantity you want?");
           int newquant1;
           newquant1=scan.nextInt();
           storewealth=storewealth-(newp1.getPrice()*newquant1);
           Productandquantity newpq1= new Productandquantity(newp1,newquant1);
           stockedproducts.add(newpq1);
          }
          if(producttype==7){
             scan.nextLine();
           System.out.println("Name");
           String t1productname;
           t1productname=scan.nextLine();
           System.out.println("Description");
           String t1description;
           t1description=scan.nextLine();
           String t1expirationdate="None";
           System.out.println("Price");
           double t1priceofproduct;
           t1priceofproduct=scan.nextDouble();
           scan.nextLine();
           System.out.println("Producing Company");      
           String t1producercompany;
           t1producercompany=scan.nextLine();
           Toys newp1=new Toys(t1productname,baselineproductid,t1producercompany, t1description, t1expirationdate, t1priceofproduct);
           baselineproductid=baselineproductid+1;
           System.out.println("How many quantity you want?");
           int newquant1;
           newquant1=scan.nextInt();
           storewealth=storewealth-(newp1.getPrice()*newquant1);
           Productandquantity newpq1= new Productandquantity(newp1,newquant1);
           stockedproducts.add(newpq1);
          }
          if(producttype==8){
             scan.nextLine();
           System.out.println("Name");
           String t1productname;
           t1productname=scan.nextLine();
           System.out.println("Description");
           String t1description;
           t1description=scan.nextLine();
           String t1expirationdate="None";
           System.out.println("Price");
           double t1priceofproduct;
           t1priceofproduct=scan.nextDouble();
           scan.nextLine();
           System.out.println("Producing Company");      
           String t1producercompany;
           t1producercompany=scan.nextLine();
           System.out.println("Type of Weapon");
           String t1typeweapon;
           t1typeweapon=scan.nextLine();
           Weapons newp1=new Weapons(t1productname,baselineproductid,t1producercompany, t1description, t1expirationdate, t1priceofproduct,t1typeweapon);
           baselineproductid=baselineproductid+1;
           System.out.println("How many quantity you want?");
           int newquant1;
           newquant1=scan.nextInt();
           storewealth=storewealth-(newp1.getPrice()*newquant1);
           Productandquantity newpq1= new Productandquantity(newp1,newquant1);
           stockedproducts.add(newpq1);
          }
        }
        if(bosschoose==2){
          PrintAllProducts(stockedproducts);
          System.out.println("Do you want to add (1) or remove (2) a discount?");
          int addoremove;
          addoremove=scan.nextInt();
          if(addoremove==1){
           System.out.println("What discount you adding?");
           double newdis;
           newdis=scan.nextDouble();
           System.out.println("What product are you using?");
           int idtouse;
           idtouse=scan.nextInt();
           for(int i=0;i<stockedproducts.size();i++){
             if(stockedproducts.get(i).pid==idtouse){
               stockedproducts.get(i).currentdiscount=newdis;
               stockedproducts.get(i).p1.changepricetodiscount(newdis);
             }
           }
          }
          if(addoremove==2){
           System.out.println("What product are you removing discount from?");
           int idtouse;
           idtouse=scan.nextInt();
           for(int i=0;i<stockedproducts.size();i++){
             if(stockedproducts.get(i).pid==idtouse){
               stockedproducts.get(i).currentdiscount=0;
               stockedproducts.get(i).p1.restoreprice();
             }
           }
          }
        }
        if(bosschoose==3){
          PrintAllProducts(stockedproducts);
           System.out.println("What product are you wanting to buy more of?");
           int pidord;
           pidord=scan.nextInt();
           System.out.println("How much you buying?");
           int addquant;
           addquant=scan.nextInt();
           for(int i=0;i<stockedproducts.size();i++){
             if(stockedproducts.get(i).pid==pidord){
               stockedproducts.get(i).currentquantity=stockedproducts.get(i).currentquantity+addquant;
               storewealth=storewealth-(addquant*stockedproducts.get(i).p1.getPrice());
             }
           }
        }
        if(bosschoose==4){
           String newcustname;
           double newcustwage; 
           double newcustbalance;
           int newcustomerid;
           scan.nextLine(); 
           System.out.println("Customer name");	
		       newcustname=scan.nextLine();
           while(newcustname==null) newcustname=scan.nextLine();
		       System.out.println("Customer wage");
		       newcustwage=scan.nextDouble();
		       System.out.println("Customer balance");
		       newcustbalance=scan.nextDouble();
           newcustomerid = baselinecustid;
           baselinecustid=baselinecustid+1;
           PersonTest newcust0=new PersonTest(newcustname,newcustwage,newcustbalance, newcustomerid, 3);
           Customer newcust1=newcust0.customert;
           System.out.println("Meet New customer "+newcust1.getName());
           customerList.add(newcust1);
        }
       if(bosschoose==5){
        String newempname;
        double newempwage; 
        double newempbalance;
        int newemployeeid;
        scan.nextLine(); 
        System.out.println("Employee name");	
		    newempname=scan.nextLine();
        while(newempname==null) newempname=scan.nextLine();
		    System.out.println("Employee wage");
		    newempwage=scan.nextDouble();
		    System.out.println("Employee balance");
		    newempbalance=scan.nextDouble();
        newemployeeid = baselineempid;
       baselineempid=baselineempid+1;
       PersonTest newemp0=new PersonTest(newempname,newempwage,newempbalance, newemployeeid, 2);
       Employee newemp1=newemp0.employeet;
       System.out.println("Meet New Employee "+newemp1.getName());
       employeeList.add(newemp1);
       }
       //Bhokai Larbpaiboonpong
       //Boss has the ability to decide of which items and how much will it discount
       if(bosschoose==6){
        System.out.println("Change membership discount:");
        double newdis2;
        newdis2=scan.nextDouble();
        OBSdiscount=newdis2;
        for(int i=0;i<customerList.size();i++){
         if(customerList.get(i).returnmembership()==1){
           customerList.get(i).editDiscount(OBSdiscount);
           System.out.println(customerList.get(i).getName()+" you have a new discount: "+OBSdiscount);
         }
        }
        discountTitle();
       }
       if(bosschoose==7){
         System.out.println("Donate your money");
         double donation1;
         donation1=scan.nextDouble();
         while(donation1>boss1.getBalance())donation1=scan.nextDouble();
         storewealth=storewealth+donation1;
         double bossval=boss1.getBalance();
         boss1.setBalance(bossval-donation1);
       }
       if(bosschoose==8){
        int productpicked;
        for(int i=0;i<proposedList.size();i++){
         if(proposedList.get(i) instanceof Clothing){
          Clothing z=(Clothing)proposedList.get(i);
          System.out.println(i+" "+z.getSummary()+"\n");
         }
        else if(proposedList.get(i) instanceof Electronic){
         Electronic b=(Electronic)proposedList.get(i);
         System.out.println(i+" "+b.getSummary()+"\n");
        }
        else if(proposedList.get(i) instanceof  EntertainmentMedia){
         EntertainmentMedia c=(EntertainmentMedia)proposedList.get(i);
         System.out.println(i+" "+c.getSummary()+"\n");
       }
       else if(proposedList.get(i) instanceof FoodorDrink){
        FoodorDrink d=(FoodorDrink)proposedList.get(i);
        System.out.println(i+" "+d.getSummary()+"\n");
       }
       else if(proposedList.get(i) instanceof Medicinesandsupplements){
        Medicinesandsupplements e=(Medicinesandsupplements)proposedList.get(i);
        System.out.println(i+" "+e.getSummary()+"\n");
       }
       else if(proposedList.get(i) instanceof Toolsandappliances){
        Toolsandappliances f=(Toolsandappliances)proposedList.get(i);
        System.out.println(i+" "+f.getSummary()+"\n");
       }
      else if(proposedList.get(i) instanceof Toys){
        Toys g=(Toys)proposedList.get(i);
        System.out.println(i+" "+g.getSummary()+"\n");
       }
       else if(proposedList.get(i) instanceof Weapons){
        Weapons h=(Weapons)proposedList.get(i);
        System.out.println(i+" "+h.getSummary()+"\n");
       }
       }
        System.out.println("Which product are you picking from proposedlist by position number?");
        productpicked=scan.nextInt();
        if(productpicked>=proposedList.size()){
          productpicked=scan.nextInt();
        }
        Product b=proposedList.get(productpicked);
        System.out.println("How much do you want?");
        int newquant3;
         newquant3=scan.nextInt();
         storewealth=storewealth-(b.getPrice()*newquant3);
          b.changeproductid(baselineproductid);
          baselineproductid=baselineproductid+1;
          Productandquantity newpqb= new Productandquantity(b,newquant3);
          stockedproducts.add(newpqb);
       }
       if(bosschoose==9){
         timetomove=1;
       }
       if(bosschoose==10){
         keeprunning1=0;
       }
       }
       }
      }
      else if(role==2){
       int keeprunning2=1;
       System.out.println("What is the id of the employee you are? (if you're the first account, your ID is 1.The second account is 2 and so on)");
       int logempid;
       logempid=scan.nextInt();
       int indexofemp;
       indexofemp=searchEmployeebyid(employeeList,logempid);
       System.out.println("Name: "+ employeeList.get(indexofemp).getName()+" Id: "+logempid+" Index: "+indexofemp);
       while(keeprunning2==1){
       int empchoose;
       System.out.println("What do you want to do today. Add product to proposedlist for 1, add or remove discount is 2, 3 to add a new Customer, 4 to get out.");
       empchoose=scan.nextInt();
        if(empchoose==1){
          int producttype;
          System.out.println("What type do you want to add? 1 for Clothing, 2 for Electronic, 3 to EntertainmentMedia, 4 for FoodorDrink, 5 for Medicinesandsupplements, 6 for Toolsandappliances, 7 for Toys, 8 for Weapons.");
          producttype=scan.nextInt();
          if(producttype==1){
           scan.nextLine();
           System.out.println("Name");
           String t1productname;
           t1productname=scan.nextLine();
           System.out.println("Description");
           String t1description;
           t1description=scan.nextLine();
           String t1expirationdate="None";
           System.out.println("Price");
           double t1priceofproduct;
           t1priceofproduct=scan.nextDouble();
           scan.nextLine();
           System.out.println("Producing Company");      
           String t1producercompany;
           t1producercompany=scan.nextLine();
           System.out.println("Clothing type");      
           String t1typeofclothing;
           t1typeofclothing=scan.nextLine();
           System.out.println("Made of");      
           String t1madeof;
           t1madeof=scan.nextLine();
           Clothing newp1=new Clothing(t1productname,-1,t1producercompany, t1description, t1expirationdate, t1priceofproduct,t1typeofclothing, t1madeof);
           proposedList.add(newp1);
          }
          if(producttype==2){
           scan.nextLine();
           System.out.println("Name");
           String t1productname;
           t1productname=scan.nextLine();
           System.out.println("Description");
           String t1description;
           t1description=scan.nextLine();
           String t1expirationdate="None";
           System.out.println("Price");
           double t1priceofproduct;
           t1priceofproduct=scan.nextDouble();
           scan.nextLine();
           System.out.println("Producing Company");      
           String t1producercompany;
           t1producercompany=scan.nextLine();
           System.out.println("Type of Electronic");    
           String t1typeofelectronic;
           t1typeofelectronic=scan.nextLine();
           Electronic newp1=new Electronic(t1productname,-1,t1producercompany, t1description, t1expirationdate, t1priceofproduct,t1typeofelectronic);
           proposedList.add(newp1);
          }
          if(producttype==3){
           scan.nextLine();
           System.out.println("Name");
           String t1productname;
           t1productname=scan.nextLine();
           System.out.println("Description");
           String t1description;
           t1description=scan.nextLine();
           String t1expirationdate="None";
           System.out.println("Price");
           double t1priceofproduct;
           t1priceofproduct=scan.nextDouble();
           scan.nextLine();
           System.out.println("Producing Company");      
           String t1producercompany;
           t1producercompany=scan.nextLine();
           System.out.println("Rating");    
           int t1rating;
           t1rating=scan.nextInt();  
           System.out.println("Type of Media");
           scan.nextLine();    
           String t1typeofmedia;
           t1typeofmedia=scan.nextLine();
           EntertainmentMedia newp1=new EntertainmentMedia(t1productname,-1,t1producercompany, t1description, t1expirationdate, t1priceofproduct,t1typeofmedia,t1rating);
           proposedList.add(newp1);
          }
          if(producttype==4){
           scan.nextLine();
           System.out.println("Name");
           String t1productname;
           t1productname=scan.nextLine();
           System.out.println("Description");
           String t1description;
           t1description=scan.nextLine();
           System.out.println("Expiration date");
           String t1expirationdate;
           t1expirationdate=scan.nextLine();
           System.out.println("Price");
           double t1priceofproduct;
           t1priceofproduct=scan.nextDouble();
           scan.nextLine();
           System.out.println("Producing Company");      
           String t1producercompany;
           t1producercompany=scan.nextLine();
           System.out.println("Nutrition value");    
           String t1nutrition;
           t1nutrition=scan.nextLine();  
           System.out.println("Type Food or drink");
           String t1typefooddrink;
           t1typefooddrink=scan.nextLine();
           FoodorDrink newp1=new FoodorDrink(t1productname,-1,t1producercompany, t1description, t1expirationdate, t1priceofproduct,t1typefooddrink,t1nutrition);
           proposedList.add(newp1);
          }
          if(producttype==5){
           scan.nextLine();
           System.out.println("Name");
           String t1productname;
           t1productname=scan.nextLine();
           System.out.println("Description");
           String t1description;
           t1description=scan.nextLine();
           System.out.println("Expiration date");
           String t1expirationdate;
           t1expirationdate=scan.nextLine();
           System.out.println("Price");
           double t1priceofproduct;
           t1priceofproduct=scan.nextDouble();
           scan.nextLine();
           System.out.println("Producing Company");      
           String t1producercompany;
           t1producercompany=scan.nextLine();
           System.out.println("Nutrition value");    
           String t1nutrition;
           t1nutrition=scan.nextLine();  
           System.out.println("Type Medicine or Supplement");  
           String t1typefooddrink;
           t1typefooddrink=scan.nextLine();
           Medicinesandsupplements newp1=new Medicinesandsupplements(t1productname,-1,t1producercompany, t1description, t1expirationdate, t1priceofproduct,t1typefooddrink,t1nutrition);
           proposedList.add(newp1);
          }
          if(producttype==6){
           scan.nextLine();
           System.out.println("Name");
           String t1productname;
           t1productname=scan.nextLine();
           System.out.println("Description");
           String t1description;
           t1description=scan.nextLine();
           String t1expirationdate="None";
           System.out.println("Price");
           double t1priceofproduct;
           t1priceofproduct=scan.nextDouble();
           scan.nextLine();
           System.out.println("Producing Company");      
           String t1producercompany;
           t1producercompany=scan.nextLine();
           Toolsandappliances newp1=new Toolsandappliances(t1productname,-1,t1producercompany, t1description, t1expirationdate, t1priceofproduct);
           proposedList.add(newp1);
          }
          if(producttype==7){
             scan.nextLine();
           System.out.println("Name");
           String t1productname;
           t1productname=scan.nextLine();
           System.out.println("Description");
           String t1description;
           t1description=scan.nextLine();
           String t1expirationdate="None";
           System.out.println("Price");
           double t1priceofproduct;
           t1priceofproduct=scan.nextDouble();
           scan.nextLine();
           System.out.println("Producing Company");      
           String t1producercompany;
           t1producercompany=scan.nextLine();
           Toys newp1=new Toys(t1productname,-1,t1producercompany, t1description, t1expirationdate, t1priceofproduct);
           proposedList.add(newp1);
          }
          if(producttype==8){
             scan.nextLine();
           System.out.println("Name");
           String t1productname;
           t1productname=scan.nextLine();
           System.out.println("Description");
           String t1description;
           t1description=scan.nextLine();
           String t1expirationdate="None";
           System.out.println("Price");
           double t1priceofproduct;
           t1priceofproduct=scan.nextDouble();
           scan.nextLine();
           System.out.println("Producing Company");      
           String t1producercompany;
           t1producercompany=scan.nextLine();
           System.out.println("Type of Weapon");
           String t1typeweapon;
           t1typeweapon=scan.nextLine();
           Weapons newp1=new Weapons(t1productname,-1,t1producercompany, t1description, t1expirationdate, t1priceofproduct,t1typeweapon);
           proposedList.add(newp1);
          }
        }
        if(empchoose==2){
         PrintAllProducts(stockedproducts);
          System.out.println("Do you want to add (1) or remove (2) a discount?");
          int addoremove;
          addoremove=scan.nextInt();
          if(addoremove==1){
           System.out.println("What discount you adding?");
           double newdis;
           newdis=scan.nextDouble();
           System.out.println("What product are you using by id?");
           int idtouse;
           idtouse=scan.nextInt();
           for(int i=0;i<stockedproducts.size();i++){
             if(stockedproducts.get(i).pid==idtouse){
               stockedproducts.get(i).currentdiscount=newdis;
               stockedproducts.get(i).p1.changepricetodiscount(newdis);
             }
           }
          }
          if(addoremove==2){
           System.out.println("What product are you removing discount from by id?");
           int idtouse;
           idtouse=scan.nextInt();
           for(int i=0;i<stockedproducts.size();i++){
             if(stockedproducts.get(i).pid==idtouse){
               stockedproducts.get(i).currentdiscount=0;
               stockedproducts.get(i).p1.restoreprice();
             }
            }
          }
        }
        if(empchoose==3){
          String newcustname;
           double newcustwage; 
           double newcustbalance;
           int newcustomerid;
           scan.nextLine(); 
           System.out.println("Customer name");	
		       newcustname=scan.nextLine();
           while(newcustname==null) newcustname=scan.nextLine();
		       System.out.println("Customer wage");
		       newcustwage=scan.nextDouble();
		       System.out.println("Customer balance");
		       newcustbalance=scan.nextDouble();
           newcustomerid = baselinecustid;
           baselinecustid=baselinecustid+1;
           PersonTest newcust0=new PersonTest(newcustname,newcustwage,newcustbalance, newcustomerid, 3);
           Customer newcust1=newcust0.customert;
           System.out.println("Meet New customer "+newcust1.getName());
           customerList.add(newcust1);
        }
        if(empchoose==4){
          keeprunning2=0;
        }
       }
      }
      else if(role==3){
       int keeprunning3=1;
       System.out.println("What is the id of the customer you are? (if you're the first account, your ID is 1.The second account is 2 and so on)");
       int logcustid;
       logcustid=scan.nextInt();
       int indexofcust;
       indexofcust=searchCustomerbyid(customerList,logcustid);
       System.out.println("Name: "+ customerList.get(indexofcust).getName()+" Wealth: "+customerList.get(indexofcust).getBalance()+" Id: "+logcustid+" Index: "+indexofcust+" Membership yes (1) or no (0) "+customerList.get(indexofcust).returnmembership());
       while(keeprunning3==1){
        int custchoose;
        System.out.println("What do you want to do today? Add product to wishlist for 1, make an order for 2, 3 to purchase membership, 4 to make a friend request,5 to accept friend request,6 to use customer support,7 to see all orders you have made, or 8 to get out.");
        custchoose=scan.nextInt();
        if(custchoose==1){
         PrintAllProducts(stockedproducts);
         System.out.println("What product do you want in the wishlist by id number?");
         int productchosen;
         productchosen=scan.nextInt();
          customerList.get(indexofcust).addToWishList(searchProduct(stockedproducts,productchosen));
        }
        if(custchoose==2){
          System.out.println("Time to make an order! What employee do you want to carry out your order?");
          for(int i=0;i<employeeList.size();i++){
            System.out.println(employeeList.get(i).getID()+" : "+employeeList.get(i).getName());
          }
          int emporder;
          int emporderindex;
          emporder=scan.nextInt();
          if(searchEmployeebyid(employeeList,emporder)==-1){emporder=scan.nextInt();}
           emporderindex=searchEmployeebyid(employeeList,emporder);
           Order neworder = new Order(baselineorderid,currentday, customerList.get(indexofcust),employeeList.get(emporderindex));
           int orderinprocess=1;
           int validorder=1;
           while(true){
            PrintAllProducts(stockedproducts);
            System.out.println("What product do you want to add by id number? Type -1 if you are finished. Type 0 if you want to cancel this order");
            int opid;
            int opq;
            opid=scan.nextInt();
            if(opid==0){
             validorder=0;
             break;
            }
            else if(opid==-1) break;
            else if(searchProductIndex(stockedproducts,opid)==-1) opid=scan.nextInt();
            int opindex=searchProductIndex(stockedproducts,opid);
            System.out.println("How much quantity do you want of product "+opid+"? Won't accept more than current quantity.");
             opq=scan.nextInt();
             if(opq>(stockedproducts.get(opindex).currentquantity+neworder.productquantity(searchProduct(stockedproducts,opid)))) opq=scan.nextInt();
             neworder.addProduct(stockedproducts.get(opindex).p1,opq);
             Product z1=searchProduct(stockedproducts,opid);
             changeQuantity(stockedproducts,z1,(opq*-1));
             customerList.get(indexofcust).removeFromWishList(z1);
             if(neworder.getTotalCost()>customerList.get(indexofcust).getBalance()){
               System.out.println("Order is too much money");
               validorder=0;
               break;
             }       
           }
           if(validorder==0){
            for(int i=0;i<stockedproducts.size();i++) stockedproducts.get(i).restoreoriginalquantity();
            System.out.println("Order cancelled");
           }
           else{
           for(int i=0;i<stockedproducts.size();i++) stockedproducts.get(i).changeProductQuantityPermanent();
           baselineorderid=baselineorderid+1;
           customerList.get(indexofcust).increaseorders(1);
           customerList.get(indexofcust).changeBalance(-1*neworder.getTotalCost());
           storewealth=storewealth+neworder.getTotalCost();
           orderList.add(neworder);
           scan.nextLine();
           System.out.println("Which country do you want to ship to?");
           String location;
           location=scan.nextLine();
           if(location=="USA"){
             Shipping newgroundship1 = shipfactory.createShipment(firstorder, location);
             newgroundship1.shipOrder();
           }
           else if(location!="USA"){
             Shipping newairship1 = shipfactory.createShipment(firstorder, location);
             newairship1.shipOrder();
           }
          ArrayList <Customer> custflist=customerList.get(indexofcust).friendList();
          if(custflist.size()!=0){
             System.out.println("Which friend to you want to gift this to by index number? Type -1 if you don't want to gift it");
             customerList.get(indexofcust).PrintFriends();
             int friendtogift;
             friendtogift=scan.nextInt();
             if(friendtogift==-1) System.out.println("You are not gifting this order");
             else if(friendtogift<-1) System.out.println("You chose not a friend. Can't gift it.");
             else if(friendtogift>=custflist.size()) System.out.println("You chose not a friend. Can't gift it.");
             else{ System.out.println(" This friend is being gifted Friend: "+custflist.get(friendtogift).getName());}
           }
           if(customerList.get(indexofcust).returnmembership()==0)  customerList.get(indexofcust).changeDiscount();        
           }
        }
        //Bhokai Larbpaiboonpong
        //Being the membership will be notified about the discount
        if(custchoose==3){
          if(customerList.get(indexofcust).returnmembership()==1) System.out.println("Already a member. Current discount is "+OBSdiscount);
          else if (customerList.get(indexofcust).returnmembership()==0){
          System.out.println("Want to join? Cost is 400.  1 for Yes or 2 for No");
           if(customerList.get(indexofcust).getBalance()<400){System.out.println("Can't pay.");
           }
           else{
             int yorn;
             yorn=scan.nextInt();
             if(yorn==1){
              customerList.get(indexofcust).changeBalance(-400);
              customerList.get(indexofcust).changeMember(1);
              System.out.println("Congratulations. Current Membership discount is "+ OBSdiscount);
              customerList.get(indexofcust).editDiscount(OBSdiscount);
               addCustomertoOBSArray(customerList.get(indexofcust));
             }
             else if(yorn==2){
               System.out.println("Hopefully you will join someday.");
             }
             else{ System.out.println("Did not register");}
           }
          }
        }
        if(custchoose==4){
        for(int i=0;i<customerList.size();i++){
          if((customerList.get(indexofcust).isFriendinList(indexofcust+1)==false) && (i!=indexofcust)){
          System.out.println("Index: "+i+" ID: "+customerList.get(i).getID()+" Name: "+customerList.get(i).getName());
          }
        }
        System.out.println("Which one you want to make a friend by id number?");
         int friendtoadd;
         friendtoadd=scan.nextInt();
         if((customerList.get(indexofcust).isFriendinList(friendtoadd)==true) || (customerList.get(indexofcust).isCustomerinFriendRequest(friendtoadd)==true)){
           friendtoadd=scan.nextInt();
         }
         customerList.get(friendtoadd-1).alterfriendrequest(customerList.get(indexofcust));
        }
        if(custchoose==5){
          System.out.println("Which customers by id you want to accept friend request from?");
          customerList.get(indexofcust).returnfriendrequest(customerList);
          int friendtoadd2;
          friendtoadd2=scan.nextInt();
          if(customerList.get(indexofcust).isCustomerinFriendRequest(friendtoadd2)==false){
           System.out.println("Not in request list.");
           friendtoadd2=scan.nextInt();
          }
           customerList.get(indexofcust).acceptfriendrequest(customerList.get(friendtoadd2-1));
           System.out.println("Friend has been added.");
         
        }
        if(custchoose==6){
          System.out.println("Customer Support, select from the following: 1 for Refund, 2 for Concerns");
          PrototypePatternTicket cusTicket = new PrototypePatternTicket();
          int choice;
          char choicechar;
          int orderunsatid;
          int orderunsatindex;
          choice=scan.nextInt();
          if(choice==1){
            System.out.println("What order are you unsatified with? Go by id");
            choicechar='r';
            orderunsatid=scan.nextInt();
            orderunsatindex=orderunsatid-1;
            if(orderList.get(orderunsatindex).getCustomer().getID()!=indexofcust+1){
              System.out.println("This is not your order.");
            }
            else{
            cusTicket.createTicket(customerList.get(indexofcust),choicechar,orderunsatindex,orderList);
            storewealth=storewealth-orderList.get(orderunsatindex).getTotalCost();
            HashMap<Product, Integer> refundedorder= orderList.get(orderunsatindex).orderedproducts;
             for (Map.Entry<Product, Integer> set : refundedorder.entrySet()) {
		          stockedproducts.get(set.getKey().getproductid()-1).currentquantity= stockedproducts.get(set.getKey().getproductid()-1).currentquantity+set.getValue();
              stockedproducts.get(set.getKey().getproductid()-1).changeProductQuantityPermanent();  
		         }    
           }

          }
          else if(choice==2){
            System.out.println("Please enter your concerns about your experience");
            choicechar='c';
            scan.nextLine();
            String feedback;
            feedback=scan.nextLine();
            System.out.println(feedback);
          }    
        }
        if(custchoose==7){
         for(int i=0;i<orderList.size();i++){
           if(orderList.get(i).getCustomer().getID()==indexofcust+1){
             System.out.println("Order: "+orderList.get(i).getId()+" Price: "+orderList.get(i).getTotalCost());
             orderList.get(i).allProductsOrdered();
           }
         }

        }
        if(custchoose==8){
          keeprunning3=0;
        }
       }
      }
      if(role==4){
        System.out.println("Boss: "+ boss1.getName()+" ID: "+"1");
        for(int i=0;i<employeeList.size();i++){
          System.out.println("Employee: "+ employeeList.get(i).getName()+" ID: "+employeeList.get(i).getID());
        }
        for(int i=0;i<customerList.size();i++){
          System.out.println("Customer: "+ customerList.get(i).getName()+" ID: "+customerList.get(i).getID());
        }
      }
      else if(role==5){
        if(timetomove==0){
          System.out.println("Can't shut down now");
        }
        else{
        System.out.println("store wealth: "+storewealth);
        for(int i=0;i<customerList.size();i++){
          customerList.get(i).balanceIncrease();
        }
        for(int i=0;i<employeeList.size();i++){
          employeeList.get(i).balanceIncrease();
          storewealth=storewealth-employeeList.get(i).getWage();
        }
        boss1.balanceIncrease();
        storewealth=storewealth-boss1.getWage();
        timetomove=0;
        currentday=currentday+1;
        }
      }
    }
    if(storewealth<=0) System.out.println("Bankrupt!");
    else{
      System.out.println("Congratulations you made it. Store wealth is"+storewealth);
    }
    scan.close();
    System.exit(0);
  }
}