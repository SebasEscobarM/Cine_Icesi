package model;

import java.util.ArrayList;
import java.util.Date;

public class Peliculas {
	//attributes
	private String nameFilm;
	private String durationFilm;
	private String filmRoom;
	private Date dayMovie;
	private Date hourMovie;
	
	private ArrayList<Peliculas> peliculas;
	
	//relations
	
	//methods
	public Peliculas(String nameFilm, String durationFilm, String filmRoom, Date dayMovie, Date hourMovie) {
		peliculas = new ArrayList<>();
		this.nameFilm = nameFilm;
		this.durationFilm = durationFilm;
		this.filmRoom = filmRoom;
		this.dayMovie = dayMovie;
		this.hourMovie = hourMovie;
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

	public Date getDayMovie() {
		return dayMovie;
	}

	public void setDayMovie(Date dayMovie) {
		this.dayMovie = dayMovie;
	}

	public Date getHourMovie() {
		return hourMovie;
	}

	public void setHourMovie(Date hourMovie) {
		this.hourMovie = hourMovie;
	}
	
}
