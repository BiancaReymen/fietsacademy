package be.vdab.fietsacademy.entities;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import be.vdab.fietsacademy.valueobjects.Adres;

@Entity
@Table(name = "campussen")
public class Campus implements Serializable {

	private final static long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String naam;
	@Embedded
	private Adres adres;
	
	public Campus(String naam, Adres adres) {
		super();
		this.naam = naam;
		this.adres = adres;
	}

	protected Campus() {
		super();
	}

	public long getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

	public Adres getAdres() {
		return adres;
	}
	
	
	
	
}
