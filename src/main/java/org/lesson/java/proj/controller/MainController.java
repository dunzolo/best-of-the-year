package org.lesson.java.proj.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.lesson.java.obj.Movie;
import org.lesson.java.obj.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String printFirstString(Model model,
			@RequestParam(name = "name") String name) {
		model.addAttribute("name", name);
		
		return "index";
	}
	
	@GetMapping("/movies")
	public String getMoviesList(Model model) {
		String movie_list = "";
		
		//for(Movie movie : getBestMovies()) {
		//	movie_list += movie.getTitolo() + ", ";
		//}
		//movie_list = movie_list.substring(0, movie_list.length() - 1);
		
		Iterator<Movie> it = getBestMovies().iterator();
		while(it.hasNext()) {
			movie_list += it.next().getTitolo();
			if(it.hasNext()) movie_list += ", ";
		}
		
		model.addAttribute("name", movie_list);
		
		return "index";
	}
	
	@GetMapping("/movies/{id}")
	public String getMovieId(Model model,
			@PathVariable("id") int id) {
		
		String movie_id = null;
		for( Movie movie : getBestMovies()) {
			if(movie.getId() == id) {				
				movie_id = movie.getTitolo(); 
			}
		}
		
		if(movie_id != null) model.addAttribute("name", movie_id);
		else model.addAttribute("name", "movie not found");
		
		return "index";
	}
	
	@GetMapping("/songs")
	public String getSongsList(Model model) {
		String song_list = "";
		
		Iterator<Song> it = getBestSong().iterator();
		while(it.hasNext()) {
			song_list += it.next().getTitolo();
			if(it.hasNext()) song_list += ", ";
		}
		
		model.addAttribute("name", song_list);
		
		return "index";
	}
	
	@GetMapping("/songs/{id}")
	public String getSongId(Model model,
			@PathVariable("id") int id) {
		
		String song_id = null;
		for( Song song : getBestSong()) {
			if(song.getId() == id) {				
				song_id = song.getTitolo(); 
			}
		}
		
		if(song_id != null) model.addAttribute("name", song_id);
		else model.addAttribute("name", "song not found");
		
		
		return "index";
	}
	
	//methods
	private List<Movie> getBestMovies(){
		List<Movie> movies = new ArrayList<>();
		
		for(int i = 0; i < 3; i++) {
			Movie movie = new Movie(i, "Movie: Titolo " + i);
			movies.add(movie);
		}
		
		return movies;
	}
	
	private List<Song> getBestSong(){
		List<Song> songs = new ArrayList<>();
		
		for(int i = 0; i < 3; i++) {
			Song song = new Song(i, "Song: Titolo " + i);
			songs.add(song);
		}
		
		return songs;
	}
}
