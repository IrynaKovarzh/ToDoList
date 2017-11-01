import java.time.LocalDate;
import java.util.*;

public class EventList {

	private List<Event> eventList = new ArrayList<Event>();
	
	public void toPrint() {
		System.out.println();
		System.out.println("ToDoList");
		System.out.println("========");
		Iterator<Event> it = eventList.iterator();
		while(it.hasNext()) {
			Event event = it.next();
			System.out.println(event);		
		}
	}
	
	public void addEvent(Event event) {
		eventList.add(event);
	}
	
	public void deleteEvent(int id) {
		boolean hasRemoved = false;
		Iterator<Event> it = eventList.iterator();		
		while(it.hasNext() && !hasRemoved) {
			Event event = it.next();
		//	System.out.println(tmpDate);
			if (event.getId() == id) {
			it.remove();
			hasRemoved = true;
			}
		}				
	}
	
	/*
	public void deleteEvent(Event event) {
		eventList.remove(event);
	}
	*/
	
	public void editEvent(Event elementOrig, Event elementNew)  {
		int index = eventList.indexOf(elementOrig); 
		eventList.set(index, elementNew);		
	}
	
	public List<Event> getAllBeforeDate(LocalDate Date){
	return null;	
	}

	public void removeAllDoneExpired(){ //for today
		//LocalDate today = LocalDate.now(); 
		
				
		System.out.println("Done");
	}
	
}
