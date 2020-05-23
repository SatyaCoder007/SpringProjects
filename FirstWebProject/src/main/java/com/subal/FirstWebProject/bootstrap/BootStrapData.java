package com.subal.FirstWebProject.bootstrap;

import com.subal.FirstWebProject.model.Author;
import com.subal.FirstWebProject.model.Book;
import com.subal.FirstWebProject.model.Publisher;
import com.subal.FirstWebProject.repositories.AuthorRepository;
import com.subal.FirstWebProject.repositories.BookRepository;
import com.subal.FirstWebProject.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;



    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {



        Publisher publisher = new Publisher();
        publisher.setPublisherName("Tata");
        publisher.setCity("Delhi");
        publisher.setState("Delhi");

        Author satya = new Author("Satya","Noida","UP");
        Book learningSpring = new Book("Learning Spring","123456");


        satya.getBooks().add(learningSpring);
        learningSpring.getAuthors().add(satya);


       // learningSpring.setPublishers(publisher);
        // publisher.getBooks().add(learningSpring);

        authorRepository.save(satya);
        bookRepository.save(learningSpring);
        publisherRepository.save(publisher);

        Author keshav = new Author("keshav","Delhi","Delhi");
        Book learningSql = new Book("Learning Sql","123467");

        keshav.getBooks().add(learningSql);
        learningSql.getAuthors().add(keshav);


      //  learningSql.setPublishers(publisher);
      //  publisher.getBooks().add(learningSql);

        authorRepository.save(keshav);
        bookRepository.save(learningSql);
        publisherRepository.save(publisher);

        System.out.println("BootStrap Started ");
        System.out.println("Number of Books Added : " + bookRepository.count());
        System.out.println("Number of Authors Added : " + authorRepository.count());
      //  System.out.println("Number of Publisher's book count : " +  publisher.getBooks().size());

    }
}
