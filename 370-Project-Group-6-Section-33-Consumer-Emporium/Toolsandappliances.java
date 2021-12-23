//Ishmam Haque. Implemented template pattern by allowing method for getting summary to be redefined in each class. I also wrote up the entirety of the product classes.
public class Toolsandappliances extends Product{
  private String productname="";
  private int productid;
  private String description="";
  private String expirationdate;
  private double priceofproduct;
  private double originalprice;
  private String producercompany="";
  Toolsandappliances(String productname, int productid,String producercompany, String description, String expirationdate, double priceofproduct){
    super(productname,productid,producercompany,description,expirationdate,priceofproduct);
    this.productname=productname;
    this.productid=productid;
    this.description=description;
    this.expirationdate=expirationdate;
    this.priceofproduct=priceofproduct;
    this.producercompany=producercompany;
    this.originalprice=priceofproduct;  
  }

  Toolsandappliances(){}

  public void setToolsandappliances(String productname, int productid,String producercompany, String description, String expirationdate, double priceofproduct){
      this.productname=productname;
    this.productid=productid;
    this.description=description;
    this.expirationdate=expirationdate;
    this.priceofproduct=priceofproduct;
    this.producercompany=producercompany;  
  }
  public void changepricetodiscount(double newdiscount){
    this.originalprice=this.priceofproduct;
    this.priceofproduct=this.originalprice*(1-newdiscount);
  }
  public void restoreprice(){
    this.priceofproduct=this.originalprice;
  }
  public String getproductName(){
	return this.productname;  
  }
  public int getproductid() {
	return this.productid; 
  }
  public String getdescription(){
	  return this.description;
  }
  public String getexpirationdate(){
    return this.expirationdate;
  }
  public double getPrice(){
    return this.priceofproduct;
  }
  public String getProducer(){
    return this.producercompany;
  }
  public void changeproductname(String f) {
	  this.productname=f;  
  }
  public void changeproductid(int e) {
	this.productid=e; 
  }
  public void changedescription(String d){
	  this.description=d;
  }
  public void changeexpirationdate(String b){
    this.expirationdate=b;
  }
  public void changePrice(float c){
    this.priceofproduct=c;
  }
  public void changeProducer(String a){
  this.producercompany=a;
  }
  public String getSummary(){
    String summary= " ID:"+this.productid+" Name: "+this.productname+" by "+this.producercompany+" Description: "+this.description+" Price: "+this.priceofproduct;
    return summary;
  }

public void setFoodorDrink(String productname, int productid,String producercompany, String description, String expirationdate, double priceofproduct, String typefoodordrink, String nutritionvalue){}

}