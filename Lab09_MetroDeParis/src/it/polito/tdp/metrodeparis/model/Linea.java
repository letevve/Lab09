package it.polito.tdp.metrodeparis.model;

public class Linea {
	
	private int id;
	private String nome;
	private int velocitÓ;
	private int intervallo;
	
	public Linea(int id, String nome, int velocitÓ, int intervallo) {
		this.id = id;
		this.nome = nome;
		this.velocitÓ = velocitÓ;
		this.intervallo = intervallo;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the velocitÓ
	 */
	public int getVelocitÓ() {
		return velocitÓ;
	}

	/**
	 * @param velocitÓ the velocitÓ to set
	 */
	public void setVelocitÓ(int velocitÓ) {
		this.velocitÓ = velocitÓ;
	}

	/**
	 * @return the intervallo
	 */
	public int getIntervallo() {
		return intervallo;
	}

	/**
	 * @param intervallo the intervallo to set
	 */
	public void setIntervallo(int intervallo) {
		this.intervallo = intervallo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Linea [id=%s, nome=%s, velocitÓ=%s, intervallo=%s]", id, nome, velocitÓ, intervallo);
	}

	
}
