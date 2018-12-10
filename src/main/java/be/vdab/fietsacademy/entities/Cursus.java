package be.vdab.fietsacademy.entities;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@Inheritance(strategy = InheritanceType.JOINED)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Table(name = "cursussen")
//@DiscriminatorColumn(name="soort")
public abstract class Cursus implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String naam;
	
	public Cursus(String naam) {
		super();
		this.naam = naam;
		id = UUID.randomUUID().toString();
	}
	protected Cursus() {
		super();
	}
	public String getId() {
		return id;
	}
	public String getNaam() {
		return naam;
	}

	
}
