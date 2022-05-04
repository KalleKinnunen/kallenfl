package com.example.kallenfl.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Pelaaja {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String etunimi;
    private String sukunimi;
    private long jaardit;
    
    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    public Pelaaja() {}

    public Pelaaja(String etunimi, String sukunimi, long jaardit, Category category) {
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.jaardit = jaardit;
        this.category = category;
    }

    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEtunimi() {
		return etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public String getSukunimi() {
		return sukunimi;
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}

	public Long getJaardit() {
		return jaardit;
	}

	public void setJaardit(long jaardit) {
		this.jaardit = jaardit;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		if (this.category != null)
			return "Pelaaja [id=" + id + ", etunimi=" + etunimi + ", sukunimi=" + sukunimi + ", jaardit=" + jaardit +  " category =" + this.getCategory() + "]";		
		else
			return "Pelaaja [id=" + id + ", etunimi=" + etunimi + ", sukunimi=" + sukunimi + ", jaardit=" + jaardit +  "]";
	}
}