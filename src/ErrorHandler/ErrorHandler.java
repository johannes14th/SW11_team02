package ErrorHandler;

import java.util.ArrayList;
import java.util.List;

public class ErrorHandler {
	
	private static List<String> errors_ = new ArrayList<String> ();
	
	public ErrorHandler() {
		
	}
	
	public static void addErrorMessage(String msg) {
		errors_.add(msg);
	}

	public static String getErrorMessage(int index) {
		if(errors_.size() > index)
		{
			return (String)errors_.get(index);
		}
		else
		{
			return null;
		}
	}
}
