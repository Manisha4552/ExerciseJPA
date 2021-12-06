package jpamavenproject.ExerciseJPA;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import jpamavenproject.ExerciseJPA.entities.Author;
import jpamavenproject.ExerciseJPA.entities.Book;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPADemo");
    	EntityManager em=emf.createEntityManager();
    	
    	em.getTransaction().begin();
    	
    	Author a1 = new Author();
    	a1.setName("Manisha");
    	
    	Author a2 = new Author();
    	a2.setName("Monika");
    	
    	Book b1 = new Book();
    	b1.setTitle("JAVA");
    	b1.setPrice(1000);
    	List<Author> la1 = new ArrayList<>();
    	la1.add(a1);
    	la1.add(a2);
    	b1.setAuthor(la1);
    	
    	Book b2 = new Book();
    	b2.setTitle("SQL");
    	b2.setPrice(2000);
    	List<Author> la2 = new ArrayList<>();
    	la2.add(a2);
    	b2.setAuthor(la2);
    	
    	List<Book> lb1 = new ArrayList<>();
    	lb1.add(b1);
    	lb1.add(b2);
    	
    	List<Book> lb2 = new ArrayList<>();
    	lb2.add(b2);
    	
    	a1.setBook(lb1);
    	a2.setBook(lb2);
    	
//    	em.persist(b1);
//    	em.persist(b2);
    	
    	TypedQuery<Book> tq = em.createNamedQuery("Book.getAll",Book.class);
    	List<Book> list = tq.getResultList();
    	for(Book b:list){
    			System.out.println(b.getISBN()+"\t"+b.getTitle()+"\t"+b.getPrice());	
    	}
    	
    	TypedQuery<Book> tq1 = em.createQuery("select book from Book book JOIN book.author auth where auth.name='Monika'",Book.class);
    	List<Book> list1 = tq1.getResultList();
    	for(Book tb1: list1) {
    		System.out.println(tb1.getTitle());
    	}
    	
    	TypedQuery<Book> tq2 = em.createNamedQuery("Book1.getAll",Book.class);
    	List<Book> list2 = tq2.getResultList();
    	for(Book tb2:list2){
    			System.out.println(tb2.getTitle());	
    	}
    	
    	TypedQuery<Author> tq3 = em.createQuery("select auth from Author auth JOIN auth.book books where books.id=21",Author.class);
    	List<Author> list3 = tq3.getResultList();
    	for(Author tb3: list3) {
    		System.out.println(tb3.getName()+"\t"+tb3.getId());
    	}

    	
    	System.out.println("Added successfully");
    	
    	em.getTransaction().commit();
    	
    }
}
