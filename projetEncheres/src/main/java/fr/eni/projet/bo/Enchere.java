package fr.eni.projet.bo;

import java.io.Serializable;
import java.sql.Date;

/*Classe créée juste sur la base de l'UML + getters/setters + To String 
 * + 3 Constructeurs (sans paramètres, avec tous les paramètres, juste sans 
 * le noUtilisateur */
public class Enchere implements Serializable {

	private static final long serialVersionUID = 1L;

	private Utilisateur user;
	private ArticleVendu article;
	private Date dateEncheres;
	private int montant_encheres;
	
	/**
	 * Constructeur
	 *
	 */
	public Enchere() {
		super();
	}

	/**
	 * Constructeur
	 *
	 * @param user
	 * @param article
	 * @param dateEncheres
	 * @param montant_encheres
	 */
	public Enchere(Utilisateur user, ArticleVendu article, Date dateEncheres, int montant_encheres) {
		super();
		this.user = user;
		this.article = article;
		this.dateEncheres = dateEncheres;
		this.montant_encheres = montant_encheres;
	}

	/**
	 * Getter user
	 *
	 * @return user
	 */
	public Utilisateur getUser() {
		return user;
	}

	/**
	 * Setter user
	 *
	 * @param user: user to set
	 */
	public void setUser(Utilisateur user) {
		this.user = user;
	}

	/**
	 * Getter article
	 *
	 * @return article
	 */
	public ArticleVendu getArticle() {
		return article;
	}

	/**
	 * Setter article
	 *
	 * @param article: article to set
	 */
	public void setArticle(ArticleVendu article) {
		this.article = article;
	}

	/**
	 * Getter dateEncheres
	 *
	 * @return dateEncheres
	 */
	public Date getDateEncheres() {
		return dateEncheres;
	}

	/**
	 * Setter dateEncheres
	 *
	 * @param dateEncheres: dateEncheres to set
	 */
	public void setDateEncheres(Date dateEncheres) {
		this.dateEncheres = dateEncheres;
	}

	/**
	 * Getter montant_encheres
	 *
	 * @return montant_encheres
	 */
	public int getMontant_encheres() {
		return montant_encheres;
	}

	/**
	 * Setter montant_encheres
	 *
	 * @param montant_encheres: montant_encheres to set
	 */
	public void setMontant_encheres(int montant_encheres) {
		this.montant_encheres = montant_encheres;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Enchere [user=");
		builder.append(user);
		builder.append(", article=");
		builder.append(article);
		builder.append(", dateEncheres=");
		builder.append(dateEncheres);
		builder.append(", montant_encheres=");
		builder.append(montant_encheres);
		builder.append("]");
		return builder.toString();
	}

}
