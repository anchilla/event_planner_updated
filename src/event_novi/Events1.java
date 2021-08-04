package event_novi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="events_new1")
public class Events1 {

	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="id")
	int id;
	@Column(name="type")
	String typeOfEvent;
	@Column(name="day")
	String day;
	@Column(name="month")
	String month;
	@Column(name="year")
	String year;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTypeOfEvent() {
		return typeOfEvent;
	}


	public void setTypeOfEvent(String typeOfEvent) {
		this.typeOfEvent = typeOfEvent;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}



	public void setMonth(String month) {
		this.month = month;
	}



	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}

	public Events1() {
		
	}

	public Events1(String day, String month, String year, String typeOfEvent) {
		this.day = day;
		this.month = month;
		this.year = year;
		this.typeOfEvent = typeOfEvent;
	}
	
	public String toString() {
		return  typeOfEvent+": "+year+"-"+month+"-"+day;
		}
}
