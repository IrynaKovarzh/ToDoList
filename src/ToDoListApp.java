import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
	
public class ToDoListApp {

	private EventList eventList = new EventList();  
			
		public void run() {		
			
     	   Scanner sc = new Scanner(System.in);
			
			boolean newAction = true;
								
			Character menuButton = 'H';		
			while (newAction) {
		    	switch (menuButton) {
	            case 'P':  
	            	// to read the list
	            	printList();
	                     break;
	            case 'A':
	            	// add
	            	addEvent(sc);
	                     break;
	            case 'D': 
	            	  // delete by id
	            	deleteEvent(sc);
	                     break;
	            case 'E': 
	            	  // edit
	            	editEvent(sc);
	                     break;
	            case 'H':
	        		toPrintMenu();
	                     break;
	            case 'C' : 
	            	  // check deadline
	            	eventList.getAllIsExpired();
	                     break;
	            case 'R' : 
	            	  // remove all that are expired
	            	eventList.removeAllDoneExpired();
	                     break;     
	            case 'F' :
	            	// find all by title, contains 
            	findAllByTitle(sc); 
            		break;

	            case 'I' : 
	            	  // find an item, by id 
	            	findById(sc);
	                     break;         
	            case 'S' : 
	          	  // to sort
	            	sortEventList(sc);
	                   break;
	            case 'Q' : 
	            	newAction = false;
	            	System.out.println();
	            	System.out.println(".........");	
	                     break;       
	            default: 
	            	//read again	            	
	                     break;
			  }        
			
	           if (newAction) {
	        	   menuButton = getMenuButton(sc);	   		    	
	           }	   	     					
			}
			sc.close();
		}
		
		private void toPrintMenu() {
			System.out.println ("MENU:");
			System.out.println ("<H> - to print menu");
			System.out.println ("<Q> - to quit");
			System.out.println ("<R> - to read the list");
			System.out.println ("<A> - to add an item");
			System.out.println ("<D> - to deleate an item");			
			System.out.println ("<E> - to edit menu");
			System.out.println ("<C> - to check expired date");
			System.out.println ("<F> - to find an event");
			System.out.println ("<I> - to find an event, by ID number");
			System.out.println ("<S> - to sort");
	        // ...
		}
		
		private void addEvent(Scanner sc) {
												
			 System.out.println();
			 System.out.println("ADDING");
			 
		     System.out.println("Input the title of the plan:");     	            	   
      	     String title = getText(sc);      	    
      	     
            LocalDate date = getDate(sc);
       	   
		  eventList.addEvent(new Event(title, date));
		}
		
		private void printList() {			
			EventListContainer.toPrintList(eventList.getList());
		}
		
private void deleteEvent(Scanner sc) {
						
			 System.out.println();
			 System.out.println("DELETING");
			 
		     System.out.println("Input the number:");      	     
      	   int id = getNumber(sc);       
      	   
		  eventList.deleteEvent(id);
		}

private void editEvent(Scanner sc) {			
						
			 System.out.println();
			 System.out.println("EDITING");
			 
			 System.out.println("Input the id-number:");       	   
			 int id = getNumber(sc);
			
      	   //to find the event
      	  Event event = eventList.getEventById(id);
      	   if (event == null) {
      		 System.out.println();
      		 System.out.println("There is no event with this id.");
      		   return;
      	   }
      	   
      	   //to ask what to change
      	 String title = event.getTitle();
  	     System.out.println(title);
  	     
  	     System.out.println("Input/Edit the title of the plan:");  	      	     
  	     title = getText(sc);	 
  	     
       	    String dateStr = event.getDeadLineDate().toString();
       	    System.out.println(dateStr);    
       	    LocalDate date = getDate(sc);
       	 
		eventList.editEvent(id, new Event(title, date));
		}

private void toPrintSubMenuSort() {
	 System.out.println ("Ways to sort:");
	 System.out.println ("<D> - by date");
	 System.out.println ("<T> - to title");	 
    // ...
}

private Character getSubMenuSortButton(Scanner sc){
	Character ch = 'L';
	 System.out.println();
	 System.out.println("Input the way to sort:");
	while (ch != 'D' && ch != 'T') {
		ch = getMenuButton(sc);
	}
	
	return ch;
}

private void sortEventList(Scanner sc) {
	
	System.out.println();
	System.out.println("SORTING");
	
	  toPrintSubMenuSort();		 
	  Character menuButton = getSubMenuSortButton(sc);
	   
	   List<Event> sortedList = eventList.getList();
	   switch (menuButton) {
       case 'T':  
       	// by title
   		Collections.sort(sortedList,
   				         new Comparator<Event>(){
                            public int compare(Event ev1, Event ev2){
                            return ev1.getTitle().compareToIgnoreCase(ev2.getTitle());	                   
                            }}
   				);   		
                break;
       case 'D':
       	// by date
    	   Collections.sort(sortedList,
				      new Comparator<Event>(){
                      public int compare(Event ev1, Event ev2){
                      return ev1.getDeadLineDate().compareTo(ev2.getDeadLineDate());	                     
                      }}
    			   );
                break;
	   }
	   	
	  EventListContainer.toPrintList(sortedList);
	}

private void findById(Scanner sc) {
	
	System.out.println();
	System.out.println("SEARCHING");
	
	System.out.println("Input the id-number:");
	   int id = getNumber(sc);	   
	   	
		System.out.println();
	   //to find the event
	  Event event = eventList.getEventById(id);
	   if (event == null) {
		 System.out.println();
		 System.out.println("There is no event with this id.");
		   return;
	   } 
	   
	   System.out.println(event);
	}

private void findAllByTitle(Scanner sc) {
	System.out.println();
	System.out.println("SEARCHING");
	
	System.out.println("Input text");
	String searchText = getText(sc);
	
	List<Event> resList = eventList.getAllEventByTitle(searchText);
	
	if (!resList.isEmpty()) {
    EventListContainer.toPrintList(resList);
	} else {
		System.out.println();
		System.out.println("None of such plans");
	}
}

private Character getMenuButton(Scanner sc){
	Character menuButton = 'L'; //
	 
	String inpStr = ""; 
	   System.out.println();
	   System.out.println("MenuButton:");
	  
	   try {
	   if(sc.hasNext()) {
		   inpStr = sc.next();	        		   
	   } 
	   } catch (Exception e) { } // any exception
	    	   		    
	    	if (inpStr!= null && inpStr.length() != 0) {
	    	menuButton = inpStr.toUpperCase().charAt(0);
	    	}
	    	
	    	return	menuButton; 	
}

private String getText(Scanner sc){     	   

	String text = "";  
while(text.length() == 0) {
	try {
    if(sc.hasNext()) {
    	text = sc.nextLine();						
    } 
    } catch (Exception e) { } // any exception  
}

return text;
}

private LocalDate getDate(Scanner sc) { 
 
LocalDate date = null;
 while(date == null) {	
 
	 String dateFormat = "yyyy-MM-dd";
  System.out.println("Input the date to perform to ( "+ dateFormat + " ):");
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat); 
  String dateStr = "";  
 
  try {
  if(sc.hasNext()) {
      dateStr = sc.next();
      date = LocalDate.parse(dateStr, formatter);
  }
 } catch (Exception e) { } // any exception  
 }
 
return date;
}

public int getNumber(Scanner sc) {       	
	 
	   int id = 0;
	   while (id == 0) {
	   
		   try {
	   if (sc.hasNextLine()) {
		 Character ch = sc.next().toCharArray()[0];
		 id = Character.getNumericValue(ch);
	   }
	   } catch (Exception e) { } // any exception
			  	   
	   }
	return id;
}
}

