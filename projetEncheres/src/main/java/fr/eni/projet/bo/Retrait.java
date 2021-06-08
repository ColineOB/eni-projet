package fr.eni.projet.bo;

import java.io.Serializable;

/*Classe créée juste sur la base de l'UML + getters/setters + To String 
 * + 3 Constructeurs (sans paramètres, avec tous les paramètres, juste sans 
 * le noUtilisateur */
public class Retrait implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int noArticle;
	private String rue;
	private String code_postal;
	private String ville;

	
	public Retrait() {
		super();
	}

	public Retrait(String rue, String code_postal, String ville) {
		super();
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
	}

	public Retrait(int noArticle, String rue, String code_postal, String ville) {
		super();
		this.noArticle = noArticle;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
	}

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Retrait [noArticle=");
		builder.append(noArticle);
		builder.append(", rue=");
		builder.append(rue);
		builder.append(", code_postal=");
		builder.append(code_postal);
		builder.append(", ville=");
		builder.append(ville);
		builder.append("]");
		return builder.toString();
	}

}
