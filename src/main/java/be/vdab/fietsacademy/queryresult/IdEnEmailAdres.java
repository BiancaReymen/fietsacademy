package be.vdab.fietsacademy.queryresult;

public class IdEnEmailAdres {
	private final long id;
	private final String emailadres;
	
	public IdEnEmailAdres(long id, String emailadres) {
		super();
		this.id = id;
		this.emailadres = emailadres;
	}

	public long getId() {
		return id;
	}

	public String getEmailadres() {
		return emailadres;
	}
	
	
}
