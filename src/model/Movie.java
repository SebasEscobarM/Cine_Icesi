package model;

import java.util.ArrayList;

public class Movie {
	//Constants
	public static final int MINI_ROOM_CHAIRS=28;
	public static final int MID_ROOM_CHAIRS=42;
	//attributes
	private String nameFilm;
	private String durationFilm;
	private String filmRoom;
	private String dayMovie;
	private String hourMovie;
	
	//relations
	private ArrayList<User> chairsRoomData; 
	
	//methods
	public Movie(String nameFilm, String durationFilm, String filmRoom, String dayMovie, String hourMovie) {
		this.nameFilm = nameFilm;
		this.durationFilm = durationFilm;
		this.filmRoom = filmRoom;
		this.dayMovie = dayMovie;
		this.hourMovie = hourMovie;
		chairsRoomData=new ArrayList<>();
		if(filmRoom.equalsIgnoreCase("Sala Media")) {		
			setArrSize(MID_ROOM_CHAIRS);
			System.out.println(chairsRoomData.size());
		} else if (filmRoom.equalsIgnoreCase("MiniSala")) {
			setArrSize(MINI_ROOM_CHAIRS);
			System.out.println(chairsRoomData.size());
		}
	}
	
	public boolean isFull() {
		boolean full=true;
		for(int i=0;i<chairsRoomData.size();i++) {
			if(chairsRoomData.get(i)==null) {
				full=false;
				break;
			}
		}
		return full;
	}
	
	public boolean sameId(User us) {
		boolean ans=false;
		for(int i=0;i<chairsRoomData.size();i++) {
			if(chairsRoomData.get(i)!=null && us.getIdUsers().equalsIgnoreCase(chairsRoomData.get(i).getIdUsers())) {
				ans=true;
				break;
			}
		}
		return ans;
	}
	public void setArrSize(int n) {
		for(int i=0;i<n;i++) {
			chairsRoomData.add(null);
		}
	}
	public ArrayList<User> getChairs(){
		return chairsRoomData;
	}
	public void addUserToAChair(User user, int pos) {
		chairsRoomData.set(pos,user);
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
