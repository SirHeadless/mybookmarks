package com.sirheadless.mybookmarks.category.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "categories")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "parent_id")
    private int parentId;
    @Column(name = "entry_updated_at")
    private Date entryUpdatedAt;
    @Column(name = "entry_created_at")
    private Date entryCreatedAt;
    @Column(name = "user_id")
    private int userId;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Category [categoryId=" + categoryId + ", name=" + name + ", description=" + description + ", parentId="
                + parentId + ", entryUpdatedAt=" + entryUpdatedAt + ", entryCreatedAt=" + entryCreatedAt + ", userId="
                + userId + "]";
    }


}
