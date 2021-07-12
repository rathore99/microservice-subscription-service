package com.rahul.rathore.subscription.service.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rahul.rathore.subscription.service.data.entity.Subscription;
import com.rahul.rathore.subscription.service.data.repository.SubscriptionRepository;
import com.rahul.rathore.subscription.service.request.SubscriptionReq;
import com.rahul.rathore.subscription.service.request.SubscriptionReturnReq;
import com.rahul.rathore.subscription.service.response.Book;
@Service
public class SubscriptionService {

	@Autowired
	private SubscriptionRepository subscriptionRepository;
	@Autowired
	private RestTemplate restTemplate; 

	private static final long BOOK_RETURNED = 1;
	private static final long BOOK_ISSUED = -1;
	@Value("${microservice.book.service.getBook.endpoint}")
	private  String GET_BOOK_URL ;
	
	@Value("${microservice.book.service.updateAvailability.endpoint}")
	private  String UPDATE_BOOK_AVAILABILITY_URL ;
	
	public List<Subscription> getSubscriptionByName(String subscriberName) {
		return subscriptionRepository.findBySubscriberName(subscriberName);
	}
	
	public Iterable<Subscription> getSubscriptions() {
		return subscriptionRepository.findAll();
	}



	@Transactional
	public HttpStatus saveSubscription (SubscriptionReq subscriptionReq) {
		
		Long bookId =subscriptionReq.getBookId();
		//check availability of book fro Book-Service
		Book book = getBook(bookId);
		
		if(book!=null)
		{
			if(book.getAvailableCopies()>0 ) {
				createSubscriptionEntryAndUpdateUvailability(subscriptionReq,book);
				 return HttpStatus.CREATED;
			}
			else
				return HttpStatus.UNPROCESSABLE_ENTITY;
		}
      return HttpStatus.UNPROCESSABLE_ENTITY;
	}
	
	private void createSubscriptionEntryAndUpdateUvailability(SubscriptionReq subscriptionReq, Book book) {

		Subscription subscription = new Subscription(subscriptionReq.getSubscriberName(),
				subscriptionReq.getDateSubscribed(), null, subscriptionReq.getBookId());
		subscriptionRepository.saveAndFlush(subscription);
		updateBookAvailability(book,BOOK_ISSUED);
	}
	
	private Book updateBookAvailability(Book book,Long counter) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		String bookServiceURI = "http://localhost:9090/booklibrary/books/UpdateAvailability/" 
		+book.getBookId()+"/"+counter;
		
		return restTemplate.exchange(bookServiceURI, HttpMethod.POST, entity, Book.class).getBody();
	}
	
	private Book getBook(Long bookId) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Book> entity = new HttpEntity<Book>(headers);
		String bookServiceURI = "http://localhost:9090/booklibrary/books/" + bookId;
		
		return restTemplate.exchange(bookServiceURI, HttpMethod.GET, entity, Book.class).getBody();
		
	}
	
	public HttpStatus saveSubscriptionOnReturn(SubscriptionReturnReq subscriptionReq) {

		Book book = getBook(subscriptionReq.getBookId());
		if(book!=null && book.getAvailableCopies()+ BOOK_RETURNED <= book.getTotalCopies()) {
			
		Subscription subscription = subscriptionRepository.findBySubscriberNameAndBookIdAndDateSubscribed(subscriptionReq.getSubscriberName(),
				subscriptionReq.getBookId(), subscriptionReq.getDateSubscribed());
		subscription.setDateReturned(subscriptionReq.getDateReturned());
		subscriptionRepository.saveAndFlush(subscription);
		updateBookAvailability(book,BOOK_RETURNED);
		return HttpStatus.CREATED;
		}
		return HttpStatus.UNPROCESSABLE_ENTITY;
	}
	
}
