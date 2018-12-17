package be.vdab.fietsacademy.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="verantwoordelijkheden")

public class Verantwoordelijkheid implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String naam;
	@ManyToMany
	@JoinTable(
			name = "docentenverantwoordelijkheden",
			joinColumns = @JoinColumn (name = "verantwoordelijkheidid"),
			inverseJoinColumns = @JoinColumn(name = "docentid")
			)
	private Set<Docent> docenten = new LinkedHashSet<>();
	
	public Verantwoordelijkheid(String naam) {
		super();
		this.naam = naam;
	}

	protected Verantwoordelijkheid() {
		super();
	}

	public long getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}
	
	public boolean add(Docent docent) {
		boolean toegevoegd = docenten.add(docent);
		if (! docent.getVerantwoordelijkheden().contains(this)) {
			docent.add(this);
		}
		return toegevoegd;
	}
	public boolean remove(Docent docent) {
		boolean verwijderd = docenten.remove(docent);
		if (docent.getVerantwoordelijkheden().contains(this)) {
			docent.remove(this);
		}
		return verwijderd;
	}
	public Set<Docent> getDocenten() {
		return Collections.unmodifiableSet(docenten);
	}

	@Override
	public int hashCode() {
		return naam == null ? 0 : naam.toLowerCase().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Verantwoordelijkheid))
			return false;
		
		if (naam == null) {
			return false;
		} 
		return naam.equalsIgnoreCase(((Verantwoordelijkheid) obj ).naam);
			
	}

	
	
	

}
