/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeveloper.beta.nosqlexperiment.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author serge
 */
@Document
public class Comment {

    @Id
    private String id;
    private String text = "";
    private String publishedBy = ""; //Ideally this should be an embedded User object
    @Indexed
    private int rating = 0;

    public Comment() {
    }

    public Comment(String text, int rating, String publishedBy) {
        this.text = text;
        this.rating = rating;
        this.publishedBy = publishedBy;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublishedBy() {
        return publishedBy;
    }

    public void setPublishedBy(String publishedBy) {
        this.publishedBy = publishedBy;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
