import database.HandleDatabase;


public class dbTest {
	
    public static void main (String argv[]){
    	HandleDatabase handler = new HandleDatabase();
    	
    	System.out.println(handler.databaseHasEntry("test"));


}
}