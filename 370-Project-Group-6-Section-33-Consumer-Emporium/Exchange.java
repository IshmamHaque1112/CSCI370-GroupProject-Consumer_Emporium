public class Exchange extends Ticket {
	public Exchange(){
	     type = "Exchange";
	   }

	   @Override
	   public void type() {
	      System.out.println("Exchanging item");
	   }
}
