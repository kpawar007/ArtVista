package com.artapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Art")
public class Art {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int artId;

    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title must be less than 100 characters")
    @Column
    private String title;

    @Column(length = 1000)
    private String description;

    @NotBlank(message = "Artist name is required")
    @Column
    private String artistName;

    @NotNull(message = "Price is required")
    @Column
    private double price;

    @Column
    private String category;

    @Column
    private String imageUrl;

    @Column
    private boolean isAvailable;

	public int getArtId() {
		return artId;
	}

	public void setArtId(int artId) {
		this.artId = artId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Art() {
		
	}

	@Override
	public String toString() {
		return "Art [artId=" + artId + ", title=" + title + ", description=" + description + ", artistName="
				+ artistName + ", price=" + price + ", category=" + category + ", imageUrl=" + imageUrl
				+ ", isAvailable=" + isAvailable + "]";
	}
    
    
	
}
