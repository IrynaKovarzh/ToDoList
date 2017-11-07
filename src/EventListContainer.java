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
		
	public static void saveObjsToXml(EventList eventList) {
		// Using XmlIO to save an object to file, errors are unexpected (write protected
		// files)
		try {
			XmlIO.saveObject("todolist.xml", eventList);
			System.out.println("Save events successfully!");			
		} catch (IOException ex) {
			Logger.getLogger(EventList.class.getName()).log(Level.SEVERE, null, ex);
		}		
	}
	
	public static EventList loadObjsFromXml() {
		// Using XmlIO to save an object to file, errors are unexpected (write protected files)		
		EventList newEventList = new EventList();

		try {
			newEventList = XmlIO.loadObject("todolist.xml", EventList.class);
			setNextIdNum(newEventList.getEventList());
			
			System.out.println("Load events successfully!");
		} catch (IOException ex) {
			Logger.getLogger(EventList.class.getName()).log(Level.SEVERE, null, ex);
		}		
		return newEventList;
	}	
	
	private static void setNextIdNum(List<Event> eventList) {
		Event.initNextIdNum(getMaxIndex(eventList) + 1);
	}
	
	private static int getMaxIndex(List<Event> eventList) {
		int index = 0;
		Iterator<Event> it = eventList.iterator();
		while (it.hasNext()) {
			Event event = it.next();
			if (event.getId() > index)
				index = event.getId();
		}
		return index;
	}
}
