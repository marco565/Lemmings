/**
 * 
 */
package controleur;

import java.io.File;

import modele.jeu.FichierInvalideException;
import modele.jeu.partie.Partie;
import vue.swing.jeu.JFrameJeuView;
import vue.swing.partie.JPanelPartieView;
import vue.swing.partie.PartieView;

/**
 * @author Paul
 *         Cette classe est le controleur de la partie.
 *         Elle gere l'affichage des diff�rents niveaux d'une partie, et les
 *         actions associ�es.
 *         **Pour l'instant il n'y a pas d'IHM, donc cette classe est l� pour de
 *         futurs �volutions
 */
public class PartieController {
	// les vues
	/**
	 * le fenetre o� afficher
	 */
	private JFrameJeuView fenetre;
	/**
	 * le vue de la partie
	 */
	private PartieView vue;
	// le mod�le
	/**
	 * le partie
	 */
	private Partie partie;

	// le fichier du niveau
	String fichier;

	/**
	 * le controleur du Niveau
	 */
	private NiveauController controleurNiveau;

	/**
	 * S�mantique : Cr�e un controleur de partie
	 * Pr�conditions :
	 * Postconditions :
	 * 
	 * @param partie
	 * @param fenetre
	 */
	public PartieController(Partie partie, JFrameJeuView fenetre) {
		this.partie = partie;
		this.fenetre = fenetre;
		this.vue = new JPanelPartieView(this);

		this.addListenerToModel();
	}

	/**
	 * S�mantique : Ajoute les listeners(vues) au mod�le
	 * Pr�conditions :
	 * Postconditions :
	 */
	private void addListenerToModel() {
	}

	/**
	 * S�mantique : ferme les vues
	 * Pr�conditions :
	 * Postconditions :
	 */
	public void closeViews() {
		this.vue.close();
	}

	/**
	 * S�mantique : affiche les vues
	 * Pr�conditions :
	 * Postconditions :
	 */
	public void displayView() {
		// this.vue.display();
		this.fenetre.displayPartie(this.vue);
	}

	/**
	 * S�mantique : Lancer la partie
	 * Pr�conditions :
	 * Postconditions :
	 * 
	 * @param fic
	 */
	public void lancerPartie(String fic) {
		this.notifyChoixNiveau(fic);
	}

	/**
	 * S�mantique : Choisir le niveau
	 * Pr�conditions :
	 * Postconditions :
	 * 
	 * @param fic
	 */
	public void notifyChoixNiveau(String fic) {
		try {
			// cree le controleur du niveau
			this.controleurNiveau = new NiveauController(
					this.partie.ajouterNiveau(new File(fic)), this.fenetre);
		}
		catch (FichierInvalideException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// afficher les vues
		this.controleurNiveau.displayView();
		// lancer le niveau
		this.controleurNiveau.lancerNiveau();
	}
}
