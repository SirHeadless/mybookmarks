package com.sirheadless.mybookmarks.url.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "urls")
public class Url implements Serializable {
    public static enum UrlType {
        Tutorial, Description, Information;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "url_id")
    private int urlId;
    @Column(name = "url")
    private String url;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "url_type")
    @Enumerated(EnumType.STRING)
    private UrlType urlType;
    @Column(name = "rating")
    private int rating;
    @Column(name = "page_created_at")
    private Date pageCreatedAt;
    @Column(name = "entry_updated_at")
    private Date entryUpdatedAt;
    @Column(name = "entry_created_at")
    private Date entryCreatedAt;
    @Column(name = "user_id")
    private int userId;


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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Url [urlId=" + urlId + ", url=" + url + ", name=" + name + ", description=" + description + ", urlType="
                + urlType + ", rating=" + rating + ", pageCreatedAt=" + pageCreatedAt + ", entryUpdatedAt="
                + entryUpdatedAt + ", entryCreatedAt=" + entryCreatedAt + ", userId=" + userId + "]";
    }


}
