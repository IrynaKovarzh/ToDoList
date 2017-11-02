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
            	findByTitle(sc); 
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
	            	System.out.println(".........");	
	                     break;       
	            default: 
	            	//read again	            	
	                     break;
			  }        
			
	           if (newAction) {
	        	   menuButton = takeMenuButton(sc);	   		    	
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
			eventList.toPrint();
		}
		
private void deleteEvent(Scanner sc) {
						
			 System.out.println();
			 System.out.println("DELETING");
		     System.out.println("Input the number:");
      	     
      	   int id = getNumber(sc);       
      	   
		  eventList.deleteEvent(id);
		}

private void editEvent(Scanner sc) {			
			// To try and catch ...
			
			 System.out.println();
			 System.out.println("EDITING");
			 System.out.println("Input the id-number:");
       	   
      	     int id = 0;
      	   if (sc.hasNextInt()) {
      		 id = sc.nextInt();
      	   }
			
      	   //to find the event
      	  Event event = eventList.getEventById(id);
      	   if (event == null) {
      		 System.out.println("There is no event with this id.");
      		   return;
      	   }
      	   
      	   //to ask what to change
      	 String title = event.getTitle();
  	     System.out.println(title);
  	     System.out.println("Input/Edit the title of the plan:");  	    
  	     
  	     title = sc.next();	 
  	     
       	    String dateStr = event.getDeadLineDate().toString();
       	    System.out.println(dateStr);    
       	    LocalDate date = getDate(sc);
       	 
		eventList.editEvent(id, new Event(title, date));
		}

private void sortEventList(Scanner sc) {
	System.out.println("SORTING");
	
	 System.out.println ("Ways to sort:");
	 System.out.println ("<D> - by date");
	 System.out.println ("<T> - to title");
	 System.out.println();
	 System.out.println("Input the way to sort:");
	 
	  Character menuButton = takeMenuButton(sc);
	   
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
	   	
	  EventList.toPrintList(sortedList);
	}

private void findById(Scanner sc) {
	System.out.println();
	System.out.println("SEARCHING");
	System.out.println("Input the id-number:");
	   
	   int id = 0;	   
	   if (sc.hasNextInt()) {
		 id = sc.nextInt();
	   }
	
		System.out.println();
	   //to find the event
	  Event event = eventList.getEventById(id);
	   if (event == null) {
		 System.out.println("There is no event with this id.");
		   return;
	   } 
	   
	   System.out.println(event);
	}

private void findByTitle(Scanner sc) {
	System.out.println("SEARCHING");
	System.out.println("Input text");

	String searchText = getText(sc);

	System.out.println();
eventList.findItemByTitle(searchText);
}

private Character takeMenuButton(Scanner sc){
	Character menuButton = 'L'; //
	 
	String inpStr = ""; 
	   System.out.println();
	   System.out.println("MenuButton:");
	   if(sc.hasNext()) {
		   //inpStr = sc.next();	
		   inpStr = sc.nextLine(); //for whole line reading including space
	   } 
	   /*else {
		   
	   }*/
	    	   		    
	    	if (inpStr!= null && inpStr.length() != 0) {
	    	menuButton = inpStr.toUpperCase().charAt(0);
	    	}
	    	
	    	return	menuButton; 	
}

private String getText(Scanner sc){     	   
String text = "";  
  // To try and catch ...
    if(sc.hasNext()) {
    	//text = sc.next();	
    	text = sc.nextLine();
    }
    
return text;
}

private LocalDate getDate(Scanner sc) {
 
  String dateFormat = "dd-MM-yyyy";
  System.out.println("Input the date to perform to ( "+ dateFormat + " ):");
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat); 
  String dateStr = "";  
  if(sc.hasNext()) {
      dateStr = sc.next();
  }
  
LocalDate date = LocalDate.parse(dateStr, formatter);

return date;
}

public int getNumber(Scanner sc) {       	
	   // To try and catch ...
	   int id = 0;
	   if (sc.hasNextLine()) {
		 Character ch = sc.next().toCharArray()[0];
		 id = Character.getNumericValue(ch);
	   }	   
	return id;
}
}

