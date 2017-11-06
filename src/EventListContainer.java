import java.io.IOException;
import java.util.*;
import java.util.logging.*;

public class EventListContainer {

	public static void toPrintList(List<Event> eventList) {
		System.out.println();
		System.out.println("ToDoList");
		System.out.println("========");
		Iterator<Event> it = eventList.iterator();
		while(it.hasNext()) {
			Event event = it.next();
			System.out.println(event);		
		}
	}
	
	public static void toSaveXML(EventCollection eventList) {	
	                    try {
	                    	XmlIO.saveObject("todolist.xml", eventList);	                    
	                    } catch (IOException ex) {
	                        Logger.getLogger(EventList.class.getName()).log(Level.SEVERE, null, ex);
	                    }
		}
	
	public static EventCollection toLoadFromXML() {	
	       // Loading with XmlIO, in this case the file might be missing.
		EventCollection todolist = new EventCollection();
        try {
        	todolist = XmlIO.loadObject("todolist.xml", EventCollection.class);
        } catch (IOException ex) {
            System.out.println("Could not load todolist.xml");
        }
        return todolist;
}
	
}
