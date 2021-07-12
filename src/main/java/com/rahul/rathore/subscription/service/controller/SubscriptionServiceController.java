package com.rahul.rathore.subscription.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.rathore.subscription.service.data.entity.Subscription;
import com.rahul.rathore.subscription.service.request.SubscriptionReq;
import com.rahul.rathore.subscription.service.request.SubscriptionReturnReq;
import com.rahul.rathore.subscription.service.services.SubscriptionService;

@RestController
@RequestMapping("/subscriber")
public class SubscriptionServiceController {
	@Autowired
	private SubscriptionService subscriptionService;
	
	@GetMapping("/subscriptions")
	public Iterable<Subscription> getSubscriptions(){
		
		return subscriptionService.getSubscriptions();
		
	}
	
	@GetMapping("/subscriptions/{subscriberName}")
	public Iterable<Subscription> getSubscriptionsOfSubscriber(@PathVariable String subscriberName){
		
		return subscriptionService.getSubscriptionByName(subscriberName);
		
	}
	
	@PostMapping("/subscriptions")
	public ResponseEntity<?> createSubscription(@RequestBody SubscriptionReq subscriptionReq) {
		 
		 return new ResponseEntity<>(
				 subscriptionService.saveSubscription(subscriptionReq));
	}
	
	@PostMapping("/returns")
	public ResponseEntity<?> updateSubscriptionDetailsForReturns(@RequestBody SubscriptionReturnReq subscriptionReq) {
		 
		 return new ResponseEntity<>(
				 subscriptionService.saveSubscriptionOnReturn(subscriptionReq));
	}

}
