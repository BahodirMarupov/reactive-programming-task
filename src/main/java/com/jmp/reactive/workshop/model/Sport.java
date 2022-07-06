package com.jmp.reactive.workshop.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

/**
 * Author: Bakhodirjon_Marupov
 * Date: 04/07/2022
 */

@Document(value = "sports")
public class Sport {
    private String id;
    private String type;
    private Map<String, Object> attributes;

    public Sport(String type, Map<String, Object> attributes) {
        this.type = type;
        this.attributes = attributes;
    }

    public Sport() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return id;
    }
}
