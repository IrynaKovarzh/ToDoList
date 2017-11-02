import java.util.*;

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

	
}
