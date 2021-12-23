
public class Refund extends Ticket {
	public Refund(){
	     type = "Refund";
	   }

	   @Override
	   public void type() {
	      System.out.println("Issuing refund");
	   }
}
