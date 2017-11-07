import java.io.IOException;
import java.util.*;
import java.util.logging.*;

public class EventListContainer {

	public static void toPrintList(List<ReadOnlyEvent> eventList) {
		System.out.println();
		System.out.println("Event List");
		System.out.println("==========");
		Iterator<ReadOnlyEvent> it = eventList.iterator();
		while(it.hasNext()) {
			ReadOnlyEvent event = it.next();
			System.out.println(event);		
		}
	}

	public static void toSaveXML(EventList eventList) {	
	                    try {
	                    	XmlIO.saveObject("todolist.xml", eventList);	                    
	                    } catch (IOException ex) {
	                        Logger.getLogger(EventList.class.getName()).log(Level.SEVERE, null, ex);
	                    }
		}
	
	public static EventList toLoadFromXML() {	
	       // Loading with XmlIO, in this case the file might be missing.
		EventList todolist = new EventList();
        try {
        	todolist = XmlIO.loadObject("todolist.xml", EventList.class);
        } catch (IOException ex) {
            System.out.println("Could not load todolist.xml");
        }
        return todolist;
}
	
}
