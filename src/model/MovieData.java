package model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MovieData {
		
	public static ObservableList<Movie> movie = FXCollections.observableArrayList();
	public static ArrayList<Movie> movies=new ArrayList<>();
	
	public static Movie getMovie(String name, String duration, String room, String hour, String date) {
		int pos=-1;
		for(int i=0;i<movies.size();i++) {
			Movie m=movies.get(i);
			if(m.getNameFilm().equalsIgnoreCase(name) && m.getDurationFilm().equalsIgnoreCase(duration) && m.getFilmRoom().equalsIgnoreCase(room) && m.getHourMovie().equalsIgnoreCase(hour) && m.getDayMovie().equalsIgnoreCase(date)){
				pos=i;
				break;
			}
		}
		if(pos!=-1) {
			return movies.get(pos);
		}else {
			return null;
		}
	}
	
	public static void deleteMovie(Movie mvToDelete) {
		movie.remove(mvToDelete);
		movies.remove(mvToDelete);
	}
	public static void addMovie(Movie nwMovie) {
		movies.add(nwMovie);
		movie.add(nwMovie);
	}
}
