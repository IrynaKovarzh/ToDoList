import java.time.LocalDate;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class Event implements ReadOnlyEvent {

	private static int nextIdNum = 1;
	
	private int id;
	private String title;
	
	
	private LocalDate deadLineDate;
	private Status status;
	
	//private String description;
	
	/* (non-Javadoc)
	 * @see ReadOnlyEvent#getStatus()
	 */
	@Override
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
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
	
	public Event() {
		this("", LocalDate.now().plusDays(1)); 
	}

	/* (non-Javadoc)
	 * @see ReadOnlyEvent#getId()
	 */
	@Override
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void CopyIdFrom(ReadOnlyEvent onotherEvent) {
	this.setId(onotherEvent.getId());
	}
	
	/* (non-Javadoc)
	 * @see ReadOnlyEvent#toString()
	 */
	@Override
	public String toString() {
		return "*" + id + " " + title + " [DL : " + deadLineDate + "  Status: " + status + "]"; //
	}

	/* (non-Javadoc)
	 * @see ReadOnlyEvent#getTitle()
	 */
	@Override
	public String getTitle() {
		return title;
	}


	/* (non-Javadoc)
	 * @see ReadOnlyEvent#getDeadLineDate()
	 */
	@Override
	public LocalDate getDeadLineDate() {
		return deadLineDate;
	}
	
	public static void initNextIdNum(int newNextIdNum ) {
		nextIdNum = newNextIdNum;
	}
	
}




