import java.util.*;

public class Inventory {
	//public array list of Tools 
	static HashMap<String, Tool> toolList = new HashMap<String,Tool>();
		
	/*
	 * Adds new tool to Inventory list.
	 */
	public static void addTool(String toolCode, Tool toolToAdd) {
		if(!toolList.containsKey(toolCode)) {
			toolList.put(toolCode, toolToAdd);
		}
	}
}
