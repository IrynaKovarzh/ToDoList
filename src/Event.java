import java.time.LocalDate;

public class Event {

	private static int nextIdNum = 1;
	
	private int id;
	private String title;
	private LocalDate deadLineDate;
	private Status status;
	//private String description;
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDeadLineDate(LocalDate deadLineDate) {
		this.deadLineDate = deadLineDate;
	}

	public Event(String title, LocalDate deadLineDate) {
	    this.id = nextIdNum;
		this.title = title;
		this.deadLineDate = deadLineDate;
		status = Status.TODO;
		
		++nextIdNum;
	}

	public Event(String title) {
		this(title, LocalDate.now().plusDays(1)); 
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}
	
	public void CopyIdFrom(Event onotherEvent) {
	this.setId(onotherEvent.getId());
	}
	
	@Override
	public String toString() {
		return "*" + id + " " + title + " [DL : " + deadLineDate + "  Status: " + status + "]"; //
	}

	public String getTitle() {
		return title;
	}

	/*
	private void setTitle(String title) {
		this.title = title;
	}
	*/

	public LocalDate getDeadLineDate() {
		return deadLineDate;
	}

	/*
	private void setDeadLineDate(LocalDate deadline) {
		this.deadLineDate = deadline;
	}
	*/
	
}
