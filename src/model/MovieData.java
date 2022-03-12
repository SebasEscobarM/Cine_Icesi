package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class MovieData {
		
	public ArrayList<Movie> movies=new ArrayList<>();;
	
	public ArrayList<Movie> getArrL() {
		return movies;
	}
	public void save() {
		try {
			Gson gson=new Gson();
			String json=gson.toJson(this);
			File file=new File("SaveFiles/data.json");
			FileOutputStream fos=new FileOutputStream(file);
			fos.write(json.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void load() {
		try {
			FileInputStream fis=new FileInputStream(new File("SaveFiles/data.json"));			
			BufferedReader br=new BufferedReader(new InputStreamReader(fis));
			String json="";
			String line;
			while((line=br.readLine())!=null) {
				json+=line;
			}
			Gson gson=new Gson();
			MovieData moviesD=gson.fromJson(json,MovieData.class);
			movies=moviesD.movies;
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Movie getMovie(String name, String duration, String room, String hour, String date) {
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
	
	public boolean sameHourDate(Movie nwMv) {
		boolean answer=false;
		for(int i=0;i<movies.size();i++) {
			if(nwMv.getDayMovie().equalsIgnoreCase(movies.get(i).getDayMovie()) && nwMv.getHourMovie().equalsIgnoreCase(movies.get(i).getHourMovie())) {
				answer=true;
				break;
			}
		}
		return answer;
	}
	
	public void deleteMovie(Movie mvToDelete) {
		movies.remove(mvToDelete);
		save();
	}
	public void addMovie(Movie nwMovie) {
		movies.add(nwMovie);
		save();
	}
}
