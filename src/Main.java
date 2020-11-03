import java.util.*;

public class Main {

	public static void main(String[] args) {
		Tool ladder = new Tool("Ladder", "Werner", "LADW", 1.99, true, true, false);
		ladder.printAttributes();
		
		Tool chainsaw = new Tool("Chainsaw", "Stihl", "CHNS", 1.49, true, false, true);
		chainsaw.printAttributes();
		
		Tool jackhammer1 = new Tool("Jackhammer", "Ridgid", "JAKR", 2.99, true, false, false);
		jackhammer1.printAttributes();
		
		Tool jackhammer2 = new Tool("Jackhammer", "Ridgid", "JAKR", 2.99, true, false, false);
		jackhammer2.printAttributes();
	}
}
