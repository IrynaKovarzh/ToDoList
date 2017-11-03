import java.time.LocalDate;
import java.util.*;

public class EventList {

	private static List<Event> eventList = new ArrayList<Event>();

	/*
	 * public void toPrint() { toPrintList(eventList); }
	 */

	public void printFromIryna() {
		System.out.println("Hello");
	}

	/*
	 * public static void toPrintList(List<Event> eventList) { System.out.println();
	 * System.out.println("ToDoList"); System.out.println("========");
	 * Iterator<Event> it = eventList.iterator(); while(it.hasNext()) { Event event
	 * = it.next(); System.out.println(event); } }
	 */

	public List<Event> getList() {
		return eventList;
	}

	public void addEvent(Event event) {
		eventList.add(event);
	}

	public void deleteEvent(int id) {
		boolean hasRemoved = false;
		Iterator<Event> it = eventList.iterator();
		while (it.hasNext() && !hasRemoved) {
			Event event = it.next();
			// System.out.println(tmpDate);
			if (event.getId() == id) {
				it.remove();
				hasRemoved = true;
			}
		}
	}

	/*
	 * public void deleteEvent(Event event) { eventList.remove(event); }
	 */

	private int getIndexEventById(int id) {
		int index = -1;
		Iterator<Event> it = eventList.iterator();
		while (it.hasNext()) {
			Event event = it.next();
			if (event.getId() == id)
				return eventList.indexOf(event);
			// System.out.println(event);
		}
		return index;
	}

	public Event getEventById(int id) {
		int index = getIndexEventById(id);
		if (index < 0)
			return null;
		return eventList.get(index);
	}

	public List<Event> getAllEventByTitle(String title) {
		List<Event> resList = new ArrayList<Event>();

		String t = title.toLowerCase();
		Iterator<Event> it = eventList.iterator();
		while (it.hasNext()) {
			Event item = it.next();
			if (item.getTitle().toLowerCase().contains(t)) {
				resList.add(item);
			}
		}

		return resList;
	}

	public void editEvent(int id, Event event) {
		int index = getIndexEventById(id);
		event.CopyIdFrom(eventList.get(index));
		if (index >= 0)
			eventList.set(index, event);
	}

	/*
	 * public void editEvent(Event elementOrig, Event elementNew) { int index =
	 * eventList.indexOf(elementOrig); eventList.set(index, elementNew); }
	 */

	public List<Event> getAllBeforeDate(LocalDate Date) {
		System.out.println("Not implemented yet");
		return null;
	}

	public void removeAllDoneExpired() { // for today
		LocalDate today = LocalDate.now();

		Iterator<Event> it = eventList.iterator();
		
		int inumber = 0;
		while (it.hasNext()) {
			Event event = it.next();
			if (event.getDeadLineDate().isBefore(today) || event.getStatus() == Status.DONE ) {
				it.remove();
				System.out.println(event + " is deleted succesfully!");
				inumber ++;
			}
		}
		System.out.println("Remove " + inumber + " event(s) of expired date or done succesfully!");
	}

	public void getAllIsExpired() { // for today
		LocalDate today = LocalDate.now();

		System.out.println("Expired");
		Iterator<Event> it = eventList.iterator();
		while (it.hasNext()) {
			Event event = it.next();
			if (event.getDeadLineDate().isBefore(today)  || event.getStatus() == Status.DONE ) {
				System.out.println(event);
			}
		}
	}

	public void findItemByTitle(String title) {

		title.trim();
		String t = title.toLowerCase();
		boolean hasFound = false;
		Iterator<Event> it = eventList.iterator();
		while (it.hasNext()) {
			Event item = it.next();
			if (item.getTitle().toLowerCase().contains(t)) {
				System.out.println(item);
				hasFound = true;
			}
		}
		if (!hasFound) {
			System.out.println("None of such plans");
		}

	}
}
