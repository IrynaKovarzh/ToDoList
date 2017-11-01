import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
	
public class ToDoListApp {

	private EventList eventList = new EventList();  
			
		public void run() {		
			
     	   Scanner sc = new Scanner(System.in);
			
			boolean newAction = true;
								
			Character menuButton = 'H';		
			while (newAction) {
		    	switch (menuButton) {
	            case 'R':  
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
	                     break;
	            case 'S' : 
	          	  // to sort
	                   break;
	            case 'Q' : 
	            	newAction = false;
	            	System.out.println(".........");	
	                     break;       
	            default: 
	            	//read again
	            	// newAction = false;
	                     break;
			  }        
			
	           if (newAction) {
	        	   String inpStr = ""; 
	        	   System.out.println();
	        	   System.out.println("MenuButton:");
	        	   if(sc.hasNext()) {
	        		   inpStr = sc.nextLine();	        		   
	        	   } 
	        	   /*else {
	        		   
	        	   }*/
	   		    	   		    
	   		    	if (inpStr!= null && inpStr.length() != 0) {
	   		    		menuButton = inpStr.toUpperCase().charAt(0);
	   		    	}
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
	        // ...
		}
		
		private void addEvent(Scanner sc) {
			
			// To try and catch ...
			
			 System.out.println();
			 System.out.println("Adding an event");
      	     System.out.println("Input the title of the plan:");
      	     String title = "";
      	     if(sc.hasNext()) {
      	     title = sc.nextLine();			
			//String title = "PNummer1";
      	     }
      	     
 		  //  String dateFormat = "d/MM/yyyy";
 		    String dateFormat = "dd-MM-yyyy";
 		    System.out.println("Input the date to perform to ( "+ dateFormat + " ):");
 		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat); 
 		    String dateStr = "";
 		    if(sc.hasNext()) {
 		       dateStr = sc.nextLine();
 		   }
 		   //convert String to LocalDate     
 		  LocalDate date = LocalDate.parse(dateStr, formatter);
 		  
 		// String date = "16/08/2016";
 		  
 		 //   LocalDate date = LocalDate.now();
			
			//Event event = new Event("PNummer1", LocalDate.now());  //
			
			eventList.addEvent(new Event(title, date));
		}
		
		private void printList() {			
			eventList.toPrint();
		}
		
private void deleteEvent(Scanner sc) {
	//private void deleteEvent() {
			
			// To try and catch ...
			
			 System.out.println();
			 System.out.println("Deletng an event");
      	     System.out.println("Input the number:");
      	  //  int id = sc.nextInt();
      	   int id = 0;
      	   // String title = sc.nextLine();			
			//String title = "PNummer1";
      	   if (sc.hasNextInt()) {
      		 id = sc.nextInt();
      	   }
			
 		 // id = 1;
		  eventList.deleteEvent(id);
		}

private void editEvent(Scanner sc) {
	//private void deleteEvent() {
			
			// To try and catch ...
			
			 System.out.println();
			 System.out.println("Editing an event");
      	     System.out.println("Input the number:");
      	  //  int id = sc.nextInt();
      	   int id = 0;
      	   // String title = sc.nextLine();			
			//String title = "PNummer1";
      	   if (sc.hasNextInt()) {
      		 id = sc.nextInt();
      	   }
			
 		 // id = 1;
		//  eventList.editEvent(id);
		}

	}

