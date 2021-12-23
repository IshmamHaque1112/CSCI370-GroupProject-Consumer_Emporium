
public class Feedback extends Ticket {
	public Feedback(){
	     type = "Feedback";
	   }

	   @Override
	   public void type() {
	      System.out.println("Describe your recent experience, include anything that delighted you and/or frustrated you.");
	   }
}
