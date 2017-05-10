package it.polito.tdp.metrodeparis.model;

public class Linea {
	
	private int id;
	private String nome;
	private int velocità;
	private int intervallo;
	
	public Linea(int id, String nome, int velocità, int intervallo) {
		this.id = id;
		this.nome = nome;
		this.velocità = velocità;
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
	 * @return the velocità
	 */
	public int getVelocità() {
		return velocità;
	}

	/**
	 * @param velocità the velocità to set
	 */
	public void setVelocità(int velocità) {
		this.velocità = velocità;
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
		return String.format("Linea [id=%s, nome=%s, velocità=%s, intervallo=%s]", id, nome, velocità, intervallo);
	}

	
}
