package com.rahul.rathore.subscription.service.data.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="SUBSCRIPTION")
public class Subscription {
	

	@Id
	@Column(name="SUBSCRIPTION_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long subscriptionId;

	@Column(name="SUBSCRIBER_NAME")
	private String subscriberName;
	
	@Column(name="DATE_SUBSCRIBED")
	private Date dateSubscribed;

	@Column(name="DATE_RETURNED")
	private Date dateReturned;

	@Column(name="BOOK_ID")
	private Long bookId;

	public Long getSubscriptionId() {
		return subscriptionId;
	}


	public String getSubscriberName() {
		return subscriberName;
	}

	public void setSubscriberName(String subscriberName) {
		this.subscriberName = subscriberName;
	}

	public Date getDateSubscribed() {
		return dateSubscribed;
	}

	public void setDateSubscribed(Date dateSubscribed) {
		this.dateSubscribed = dateSubscribed;
	}

	public Date getDateReturned() {
		return dateReturned;
	}

	public void setDateReturned(Date dateReturned) {
		this.dateReturned = dateReturned;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}


	public Subscription( String subscriberName, Date dateSubscribed, Date dateReturned,
			Long bookId) {
		super();
		this.subscriberName = subscriberName;
		this.dateSubscribed = dateSubscribed;
		this.dateReturned = dateReturned;
		this.bookId = bookId;
	}


	public Subscription() {
		super();
	}


	@Override
	public String toString() {
		return "Subscription [subscriptionId=" + subscriptionId + ", subscriberName=" + subscriberName
				+ ", dateSubscribed=" + dateSubscribed + ", dateReturned=" + dateReturned + ", bookId=" + bookId + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((dateReturned == null) ? 0 : dateReturned.hashCode());
		result = prime * result + ((dateSubscribed == null) ? 0 : dateSubscribed.hashCode());
		result = prime * result + ((subscriberName == null) ? 0 : subscriberName.hashCode());
		result = prime * result + (int) (subscriptionId ^ (subscriptionId >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subscription other = (Subscription) obj;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (dateReturned == null) {
			if (other.dateReturned != null)
				return false;
		} else if (!dateReturned.equals(other.dateReturned))
			return false;
		if (dateSubscribed == null) {
			if (other.dateSubscribed != null)
				return false;
		} else if (!dateSubscribed.equals(other.dateSubscribed))
			return false;
		if (subscriberName == null) {
			if (other.subscriberName != null)
				return false;
		} else if (!subscriberName.equals(other.subscriberName))
			return false;
		if (subscriptionId != other.subscriptionId)
			return false;
		return true;
	}
	

}
