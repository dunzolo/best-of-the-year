package org.lesson.java.obj;

public class Song {
	private int id;
	private String titolo;
	
	public Song(int id, String titolo) {
		setId(id);
		setTitolo(titolo);
	}

	//get e set
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	
}
