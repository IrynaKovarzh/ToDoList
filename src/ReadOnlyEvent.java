import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public interface ReadOnlyEvent {
	
	Status getStatus();

	int getId();

	String toString();

	String getTitle();

	LocalDate getDeadLineDate();

}