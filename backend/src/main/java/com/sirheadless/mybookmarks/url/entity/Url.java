package com.sirheadless.mybookmarks.url.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="urls")
public class Url implements Serializable{
	public static enum UrlType {
		Tutorial,Description,Information;
	}
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="url_id")
	private int urlId;
	@Column(name="url")
	private String url;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description; 
	@Column(name="url_type")
	@Enumerated(EnumType.STRING)
	private UrlType urlType;
	@Column(name="rating")
	private int rating;
	@Column(name="page_created_at")
	private Date pageCreatedAt;
	@Column(name="entry_updated_at")
	private Date entryUpdatedAt;
	@Column(name="entry_created_at")
	private Date entryCreatedAt;

	public int getUrlId() {
		return urlId;
	}

	public void setUrlId(int urlId) {
		this.urlId = urlId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UrlType getUrlType() {
		return urlType;
	}

	public void setUrlType(UrlType urlType) {
		this.urlType = urlType;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Date getPageCreatedAt() {
		return pageCreatedAt;
	}

	public void setPageCreatedAt(Date pageCreatedAt) {
		this.pageCreatedAt = pageCreatedAt;
	}

	public Date getEntryUpdatedAt() {
		return entryUpdatedAt;
	}

	public void setEntryUpdatedAt(Date entryUpdatedAt) {
		this.entryUpdatedAt = entryUpdatedAt;
	}

	public Date getEntryCreatedAt() {
		return entryCreatedAt;
	}

	public void setEntryCreatedAt(Date entryCreatedAt) {
		this.entryCreatedAt = entryCreatedAt;
	}
	
	  @PrePersist
	  protected void onCreate() {
		 this.entryCreatedAt = new Date();
	  }

	  @PreUpdate
	  protected void onUpdate() {
		 this.entryUpdatedAt = new Date();
	  }

	@Override
	public String toString() {
		return "Url [urlId=" + urlId + ", url=" + url + ", name=" + name + ", description=" + description
				+ ", urlType=" + urlType + ", rating=" + rating + "]";
	}
	

}
