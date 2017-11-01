import java.time.LocalDate;

public class Event {

	private static int nextIdNum = 1;
	
	private int id;
	private String title;
	private LocalDate deadLineDate;
	
	public Event(String title, LocalDate deadLineDate) {
	    this.id = nextIdNum;
		this.title = title;
		this.deadLineDate = deadLineDate;
		
		++nextIdNum;
	}

	public Event(String title) {
		this(title, LocalDate.now().plusDays(1)); //plans for tomorrow		
	}


	public int getId() {
		return id;
	}

	/*
	private void setId(int id) {
		Id = id;
	}
	*/

	@Override
	public String toString() {
		return "*" + id + " " + title + " [DL : " + deadLineDate + "]"; //
	}

	public String getTitle() {
		return title;
	}

	/*
	private void setTitle(String title) {
		this.title = title;
	}
	*/

	public LocalDate getdeadLineDate() {
		return deadLineDate;
	}

	/*
	private void setdeadLineDate(LocalDate deadline) {
		this.deadLineDate = deadline;
	}
	*/
	
}
