package fr.eni.projet.bo;

import java.io.Serializable;
import java.sql.Date;

/*Classe créée juste sur la base de l'UML + getters/setters + To String 
 * + 3 Constructeurs (sans paramètres, avec tous les paramètres, juste sans 
 * le noUtilisateur */
public class Enchere implements Serializable {

	private static final long serialVersionUID = 1L;

	private int noUtilisateur;
	private int noArticle;
	private Date dateEncheres;
	private int montant_encheres;

	public Enchere() {
		super();
	}

	public Enchere(int no_article, Date dateEncheres, int montant_encheres) {
		super();
		this.noArticle = no_article;
		this.dateEncheres = dateEncheres;
		this.montant_encheres = montant_encheres;
	}

	public Enchere(int noUtilisateur, int no_article, Date dateEncheres, int montant_encheres) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.noArticle = no_article;
		this.dateEncheres = dateEncheres;
		this.montant_encheres = montant_encheres;
	}

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public int getNo_article() {
		return noArticle;
	}

	public void setNo_article(int no_article) {
		this.noArticle = no_article;
	}

	public Date getDateEncheres() {
		return dateEncheres;
	}

	public void setDateEncheres(Date dateEncheres) {
		this.dateEncheres = dateEncheres;
	}

	public int getMontant_encheres() {
		return montant_encheres;
	}

	public void setMontant_encheres(int montant_encheres) {
		this.montant_encheres = montant_encheres;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Enchere [noUtilisateur=");
		builder.append(noUtilisateur);
		builder.append(", no_article=");
		builder.append(noArticle);
		builder.append(", dateEncheres=");
		builder.append(dateEncheres);
		builder.append(", montant_encheres=");
		builder.append(montant_encheres);
		builder.append("]");
		return builder.toString();
	}

}
