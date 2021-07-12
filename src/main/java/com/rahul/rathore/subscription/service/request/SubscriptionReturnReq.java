package com.rahul.rathore.subscription.service.request;

import java.sql.Date;


public class SubscriptionReturnReq {
	

	private String subscriberName;
	private Date dateSubscribed;
	private Date dateReturned;
	private Long bookId;



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


	public SubscriptionReturnReq( String subscriberName, Date dateSubscribed, Date dateReturned,
			Long bookId) {
		super();
		this.subscriberName = subscriberName;
		this.dateSubscribed = dateSubscribed;
		this.dateReturned = dateReturned;
		this.bookId = bookId;
	}


	public SubscriptionReturnReq() {
		super();
	}


	@Override
	public String toString() {
		return "Subscription [subscriberName=" + subscriberName
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
		SubscriptionReturnReq other = (SubscriptionReturnReq) obj;
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
		return true;
	}
	

}
