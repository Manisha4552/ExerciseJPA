package jpamavenproject.ExerciseJPA.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(value={
		@NamedQuery(name="Book.getAll" , query="select books from Book books"),
		@NamedQuery(name="Book1.getAll" , query="select obj from Book obj where obj.price BETWEEN 500 AND 1000")
		})

public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ISBN;
	private String title;
	private int price;
	@ManyToMany(cascade=CascadeType.ALL)
	List<Author> author;
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public List<Author> getAuthor() {
		return author;
	}
	public void setAuthor(List<Author> author) {
		this.author = author;
	}
	

}
