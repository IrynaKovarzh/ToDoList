import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class EventList {	
	private List<Event> eventList = new ArrayList<Event>();
		
	public List<ReadOnlyEvent> getEventList() {					
		return Collections.unmodifiableList(eventList);
		}
	
	public void setEventList(List<Event> eventList) {	
	 this.eventList = eventList;
	}
		
	public void addEvent(Event event) {
		eventList.add(event);
	}

	public void deleteEvent(int id) {
		boolean hasRemoved = false;
		Iterator<Event> it = eventList.iterator();
		while (it.hasNext() && !hasRemoved) {
			ReadOnlyEvent event = it.next();
			if (event.getId() == id) {
				it.remove();
				hasRemoved = true;
			}
		}
	}
		
	private int getIndexEventById(int id) {
		int index = -1;
		Iterator<Event> it = eventList.iterator();
		while (it.hasNext()) {
			ReadOnlyEvent event = it.next();
			if (event.getId() == id)
				return eventList.indexOf(event);
		}
		return index;
	}	

	public ReadOnlyEvent getReadOnlyEventById(int id) {
		int index = getIndexEventById(id);
		if (index < 0)
			return null;
		return eventList.get(index);
	}

	
	public Event getEventById(int id) {
		int index = getIndexEventById(id);
		if (index < 0)
			return null;
		return eventList.get(index);
	}

	public void removeAllDoneExpired() { // for today
		LocalDate today = LocalDate.now();

		Iterator<Event> it = eventList.iterator();
		
		int inumber = 0;
		while (it.hasNext()) {
			ReadOnlyEvent event = it.next();
			if (event.getDeadLineDate().isBefore(today) || event.getStatus() == Status.DONE ) {
				it.remove();			
				inumber ++;
			}
		}
		System.out.println(inumber + " event(s) have been deleted.");
	}
	
	public List<ReadOnlyEvent> getAllEventByTitle(String title) {
		List<ReadOnlyEvent> resList = new ArrayList<ReadOnlyEvent>();

		String t = title.toLowerCase();
		Iterator<Event> it = eventList.iterator();
		while (it.hasNext()) {
			ReadOnlyEvent item = it.next();
			if (item.getTitle().toLowerCase().contains(t)) {
				resList.add(item);
			}
		}

		return resList;
	}
		
	public List<ReadOnlyEvent> getAllBeforeDate(LocalDate Date) {
		System.out.println("Not implemented yet");
		return null;
	}

	public List<ReadOnlyEvent> getAllIsExpired() { // for today
		LocalDate today = LocalDate.now();

		//System.out.println("Expired");
		
		List<ReadOnlyEvent> resList = new ArrayList<ReadOnlyEvent>();
		Iterator<Event> it = eventList.iterator();
		while (it.hasNext()) {
			ReadOnlyEvent event = it.next();
			if (event.getDeadLineDate().isBefore(today)  && event.getStatus() != Status.DONE ) {
				resList.add(event);
		//		System.out.println(event);
			}
		}
		return resList;
	}

	public void findItemByTitle(String title) {

		title.trim();
		String t = title.toLowerCase();
		boolean hasFound = false;
		Iterator<Event> it = eventList.iterator();
		while (it.hasNext()) {
			ReadOnlyEvent item = it.next();
			if (item.getTitle().toLowerCase().contains(t)) {
				System.out.println(item);
				hasFound = true;
			}
		}
		if (!hasFound) {
			System.out.println("None of such plans");
		}

	}
	
	public int getMaxIndex() {
		int index = 0;
		Iterator<Event> it = eventList.iterator();
		while (it.hasNext()) {
			ReadOnlyEvent event = it.next();
			if (event.getId() > index)
				index = event.getId();
			// System.out.println(event);
		}
		return index;
	}
	
}
