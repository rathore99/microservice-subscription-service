package com.rahul.rathore.subscription.service.request;

import java.sql.Date;

public class SubscriptionReq {

	private String subscriberName;
	private Long bookId;
	private Date dateSubscribed;
	private String notify;
	public String getSubscriberName() {
		return subscriberName;
	}
	public void setSubscriberName(String subscriberName) {
		this.subscriberName = subscriberName;
	}
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public Date getDateSubscribed() {
		return dateSubscribed;
	}
	public void setDateSubscribed(Date dateSubscribed) {
		this.dateSubscribed = dateSubscribed;
	}
	public String getNotify() {
		return notify;
	}
	public void setNotify(String notify) {
		this.notify = notify;
	}
	public SubscriptionReq(String subscriberName, Long bookId, Date dateSubscribed, String notify) {
		super();
		this.subscriberName = subscriberName;
		this.bookId = bookId;
		this.dateSubscribed = dateSubscribed;
		this.notify = notify;
	}
	public SubscriptionReq() {
		super();
	}
	
	
}
