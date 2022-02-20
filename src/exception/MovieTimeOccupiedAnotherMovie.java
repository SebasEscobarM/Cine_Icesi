package exception;

public class MovieTimeOccupiedAnotherMovie extends Exception{
	public MovieTimeOccupiedAnotherMovie() { //Movie movie
		super("The time chosen for the film is already reserved for another function. The fuction is " );
	}
}
