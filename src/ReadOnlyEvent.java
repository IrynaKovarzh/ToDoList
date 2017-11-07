import java.time.LocalDate;

public interface ReadOnlyEvent {

	Status getStatus();

	int getId();

	String toString();

	String getTitle();

	LocalDate getDeadLineDate();

}