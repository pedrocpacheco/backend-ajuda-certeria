package com.ajudacerteira.backendjava.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "evento")
public class Evento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String imageUrl;
    private String day; 


    @Column(columnDefinition = "TEXT")
    private String description;

    private String creatorName;
    private String creatorImageUrl;

    public Evento() {
    }

    public Evento(Long id, String name, String address, String eventImageUrl, String eventDay, String description,
            String creatorName, String creatorImageUrl) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.imageUrl = eventImageUrl;
        this.day = eventDay;
        this.description = description;
        this.creatorName = creatorName;
        this.creatorImageUrl = creatorImageUrl;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String eventImageUrl) {
        this.imageUrl = eventImageUrl;
    }
    public String getDay() {
        return day;
    }
    public void setDay(String eventDay) {
        this.day = eventDay;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCreatorName() {
        return creatorName;
    }
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }
    public String getCreatorImageUrl() {
        return creatorImageUrl;
    }
    public void setCreatorImageUrl(String creatorImageUrl) {
        this.creatorImageUrl = creatorImageUrl;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Evento other = (Evento) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Evento [id=" + id + ", name=" + name + ", address=" + address + ", eventImageUrl=" + imageUrl
                + ", eventDay=" + day + ", description=" + description + ", creatorName=" + creatorName
                + ", creatorImageUrl=" + creatorImageUrl + "]";
    }
}

