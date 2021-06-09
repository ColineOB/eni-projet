package fr.eni.projet.bll;

import java.sql.SQLException;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.dal.CodesResultatDAL;
import fr.eni.projet.dal.DAOFactory;
import fr.eni.projet.dal.InscriptionDAO;
import fr.eni.projet.servlets.CodesResultatServlets;
import jakarta.servlet.http.HttpSession;

public class InscriptionManager {
	private InscriptionDAO inscriptionDAO;
	
	public InscriptionManager() {
		this.inscriptionDAO=DAOFactory.getInscriptionDAO();
	}
	
	public Utilisateur inscrireUtilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, int credit, boolean administrateur) throws BusinessException, SQLException {
BusinessException exception = new BusinessException();
this.validerPseudoAlphanum(pseudo, exception);
this.verifMailBoolean(email, exception);
this.verifPseudoBoolean(pseudo, exception);
		
		Utilisateur user =null;
		
			//si il n'y a pas d'erreur j'ajoute les infos à l'Utilisateur
		if(!exception.hasErreurs())
		{
			user = new Utilisateur();
			user.setPseudo(pseudo);
			user.setNom(nom);
			user.setPrenom(prenom);
			user.setEmail(email);
			user.setTelephone(telephone);
			user.setRue(rue);
			user.setCodePostal(codePostal);
			user.setVille(ville);
			user.setMotDePasse(motDePasse);
			user.setCredit(credit);
			user.setAdministrateur(administrateur);
			this.inscriptionDAO.inscrireUtilisateur(user);
		}
		else
		{
			throw exception;
		}
		return user;
	}

	private void validerPseudoAlphanum(String pseudo, BusinessException exception) {
		
		    for (int i=0; i<pseudo.length(); i++) {
		        char c = pseudo.charAt(i);
		        if (c < 0x30 || (c >= 0x3a && c <= 0x40) || (c > 0x5a && c <= 0x60) || c > 0x7a)
		        	exception.ajouterErreur(CodesResultatServlets.PSEUDO_ALPHANUMERIQUE);
		    }
		}
		private void verifMailBoolean(String email, BusinessException exception) {
			if(!inscriptionDAO.verifMail(email)) {
				exception.ajouterErreur(CodesResultatDAL.EMAIL_DEJA_PRIS);
			}
		}
		private void verifPseudoBoolean(String pseudo, BusinessException exception) {
			if(!inscriptionDAO.verifPseudo(pseudo)) {
				exception.ajouterErreur(CodesResultatDAL.PSEUDO_DEJA_PRIS);
			}
		}
	
}
