package model;

import java.util.ArrayList;
import java.util.Date;

public class BienestarCinema {
	//attributes
	
	//relations
	private ArrayList<Employee> employees;
	private ArrayList<Movie> movies;
	private ArrayList<User> users;
	
	//methods
	public BienestarCinema() {
		employees = new ArrayList<>();
		movies = new ArrayList<>();
		users = new ArrayList<>();
	}
	
	public String addEmployees(String idEmployee) {
		String message = "";
		
		return message;
	}
	
	public String deleteEmployees(String idEmployee) {
		String message = "";
		
		return message;
	}
	
	public Employee searchEmployee(String idEmployee) {
		Employee employee = null;
		
		return employee;
	}
	
	public String addMovies(String nameFilm,String durationFilm,String filmRoom,Date dateMovie,Date hourMovie,boolean chair) {
		String message = "";
		
		return message;
	}
	
	public String deleteMovies(String nameFilm,String filmRoom,Date dateMovie,Date hourMovie) {
		String message = "";
		
		return message;
	}
	
	
	//Una interfaz parecida a la de registrar películas y se pide todo otra vez, se hace un getText para guardarlo otra vez completo
	public String editMovies(String nameFilm,String durationFilm,String filmRoom,Date dateMovie,Date hourMovie,boolean chair) {
		String message = "";
		
		return message;
	}
	
	public Movie searchMovies(String nameFilm,String filmRoom,Date dateMovie,Date hourMovie) {
		Movie movie = null;
		
		return movie;
	}
	
	public String addUser(String nameUser,String idUser) {
		String message = "";
		
		return message;
	}
	
	public String deleteUser(String idUser) {
		String message = "";
		
		return message;
	}
	
	public User searchUser(String idUser) {
		User user = null;
		
		return user;
	}
	
}
