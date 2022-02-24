package model;

import java.util.ArrayList;
import java.util.Date;

public class Movie {
	//attributes
	private String nameFilm;
	private String durationFilm;
	private String filmRoom;
	private String dayMovie;
	private String hourMovie;
	
	//relations
	
	//methods
	public Movie(String nameFilm, String durationFilm, String filmRoom, String dayMovie, String hourMovie) {
		this.nameFilm = nameFilm;
		this.durationFilm = durationFilm;
		this.filmRoom = filmRoom;
		this.dayMovie = dayMovie;
		this.hourMovie = hourMovie;
	}
	
	public boolean searchChair(String nameFilm,String filmRoom,Date dateMovie,Date hourMovie) {
		boolean freeChair = false;
		
		return freeChair;
	}
	
	
	public String getNameFilm() {
		return nameFilm;
	}

	public void setNameFilm(String nameFilm) {
		this.nameFilm = nameFilm;
	}

	public String getDurationFilm() {
		return durationFilm;
	}

	public void setDurationFilm(String durationFilm) {
		this.durationFilm = durationFilm;
	}

	public String getFilmRoom() {
		return filmRoom;
	}

	public void setFilmRoom(String filmRoom) {
		this.filmRoom = filmRoom;
	}

	public String getDayMovie() {
		return dayMovie;
	}

	public void setDayMovie(String dayMovie) {
		this.dayMovie = dayMovie;
	}

	public String getHourMovie() {
		return hourMovie;
	}

	public void setHourMovie(String hourMovie) {
		this.hourMovie = hourMovie;
	}

	
}
