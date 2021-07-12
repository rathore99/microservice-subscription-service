package com.rahul.rathore.subscription.service.data.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rahul.rathore.subscription.service.data.entity.Subscription;

@Repository
public interface SubscriptionRepository  extends JpaRepository<Subscription, Long>{

	List<Subscription> findBySubscriberName(String subscriberName);
	Subscription findBySubscriberNameAndBookIdAndDateSubscribed(String subscriberName,Long bookId, Date subscribedDate) ;
	
}
