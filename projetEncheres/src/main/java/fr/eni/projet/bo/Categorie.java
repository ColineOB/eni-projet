package fr.eni.projet.bo;

import java.io.Serializable;

/*Classe créée juste sur la base de l'UML + getters/setters + To String 
 * + 3 Constructeurs (sans paramètres, avec tous les paramètres, juste sans 
 * le noUtilisateur */
public class Categorie implements Serializable {

	private static final long serialVersionUID = 1L;

	private int noCategorie;
	private String libelle;

	
	public Categorie() {
		super();
	}

	public Categorie(String libelle) {
		super();
		this.libelle = libelle;
	}

	public Categorie(int noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}

	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Categorie [noCategorie=");
		builder.append(noCategorie);
		builder.append(", libelle=");
		builder.append(libelle);
		builder.append("]");
		return builder.toString();
	}

}
