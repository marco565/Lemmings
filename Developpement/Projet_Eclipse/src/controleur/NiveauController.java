/**
 * 
 */
package controleur;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modele.jeu.partie.niveau.Niveau;
import modele.jeu.partie.niveau.lemming.Lemming;
import modele.jeu.partie.niveau.lemming.Position;
import modele.jeu.partie.niveau.lemming.aptitude.AptitudeInvalideException;
import modele.jeu.partie.niveau.lemming.aptitude.TypeAptitude;
import vue.swing.jeu.JFrameJeuView;
import vue.swing.niveau.JPanelNiveauControlView;
import vue.swing.niveau.JPanelNiveauDisplayView;
import vue.swing.niveau.NiveauControlView;
import vue.swing.niveau.NiveauDisplayView;

/**
 * @author Paul
 *         Cette classe est le controleur du niveau.
 *         Elle gere l'affichage d'un niveau, et les
 *         actions associ�es.
 */
// TODO enlever getter et setter sur controls et display
public class NiveauController {
	// Les vues
	/**
	 * le panel de contr�le du niveau
	 */
	private NiveauControlView controls;
	/**
	 * le panel d'affichage du niveau
	 */
	private NiveauDisplayView display;
	/**
	 * la fenetre dans laquelle afficher le niveau
	 */
	private JFrameJeuView fenetre;

	// le mod�le
	/**
	 * le niveau
	 */
	private Niveau niveau;

	/**
	 * Lemming selectionn� sur l'affichage et a transmettre au contr�le
	 */
	private Lemming lemmingSelected;

	/**
	 * S�mantique : Cr�e le controleur du niveau
	 * Pr�conditions :
	 * Postconditions :
	 * 
	 * @param niveau
	 */
	public NiveauController(Niveau niveau, JFrameJeuView fenetre) {
		this.niveau = niveau;
		this.fenetre = fenetre;
		this.controls = new JPanelNiveauControlView(this, niveau.getInfos());
		this.display = new JPanelNiveauDisplayView(this, niveau.getCarte());
		this.lemmingSelected = null;

		this.addListenerToModel();
	}

	/**
	 * S�mantique : Ajoute les listeners (vues) au mod�le
	 * Pr�conditions :
	 * Postconditions :
	 */
	private void addListenerToModel() {
		this.niveau.getInfos().addListener(this.controls);
		this.niveau.addListener(this.display);
	}

	/**
	 * S�mantique : Fermer les vues du controleur
	 * Pr�conditions :
	 * Postconditions :
	 */
	public void closeViews() {
		this.controls.close();
		this.display.close();
	}

	/**
	 * S�mantique : Afficher les vues du controleur dans la fenetre
	 * Pr�conditions :
	 * Postconditions :
	 */
	public void displayView() {

		this.controls.display();
		this.display.display();
		this.fenetre.displayNiveau(this.controls, this.display);
		this.fenetre.display();
	}

	/**
	 * S�mantique : Lance le niveau
	 * Pr�conditions :
	 * Postconditions :
	 */
	public void lancerNiveau() {
		while (!this.niveau.getInfos().isFinDeNiveau()) {
			this.niveau.miseAJour();
			try {
				Thread.sleep(1);
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		JOptionPane popup = new JOptionPane();
		JFrame framePop = new JFrame();
		String message;
		if (this.niveau.getInfos().isGagne()) {
			message = "Bravo";
		} else {
			message = "Boouuuh";
		}
		popup.showMessageDialog(framePop, message);
		this.closeViews();
	}

	/**
	 * S�mantique : Change l'etat du jeu, en pause ou pas. Ce sont les vues qui
	 * le demandent
	 * Pr�conditions :
	 * Postconditions :
	 * 
	 * @param b
	 *            si true, met le niveau en pause, sinon reprend le niveau
	 */
	public void notifyJeuEnPause() {
		// inverser l'etat de la pause
		this.niveau.getInfos().setJeuEnPause(
				!this.niveau.getInfos().isJeuEnPause());
	}

	/**
	 * S�mantique : Changer le lemming selectionne. C'est l'affichage qui
	 * le demande
	 * Pr�conditions :
	 * Postconditions :
	 * 
	 * @param p
	 */
	public void notifyLemmingSelectedChanged(Position p) {
		Lemming lem = this.niveau.getLemming(p.getX(), p.getY());
		if (lem != null) {
			this.lemmingSelected = lem;
		}
		this.notifyUpdateLemmingInfos();
	}

	/**
	 * S�mantique : M�thode lien entre affichage et contr�le, permettant
	 * d'afficher le lemming selectionn�.
	 * Pr�conditions :
	 * Postconditions :
	 */
	public void notifyUpdateLemmingInfos() {
		if (this.lemmingSelected != null) {
			this.controls.updateSelectedLemmingInfos(this.lemmingSelected
					.getDirectionActuelle().getPosition(), this.lemmingSelected
					.getAptitudeEnCours().getType());
		}
	}

	/**
	 * S�mantique : Change la vitesse d'apparition des lemmings
	 * Pr�conditions :
	 * Postconditions :
	 * 
	 * @param vitesseApparition
	 */
	public void notifyVitesseApparition(int vitesseApparition) {
		this.niveau.getInfos().setVitesseApparition(vitesseApparition);
	}

	/**
	 * S�mantique : Chnage l'aptitude du lemming selectionn�
	 * Pr�conditions :
	 * Postconditions :
	 * 
	 * @param position
	 */
	public void notitfyAptitudeChanged(Position position) {
		// recuperer l'aptitude selectionn�e
		TypeAptitude aptitude = this.controls.getAptitudeSelectionnee();
		if (aptitude != null) {
			// changer le lemming selectionn� avec la position
			this.notifyLemmingSelectedChanged(position);
			try {
				// changer son aptitude
				this.niveau.changerAptitude(this.lemmingSelected, aptitude);
			}
			catch (AptitudeInvalideException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * S�mantique : Changer la vitesse du jeu.
	 * Pr�conditions :
	 * Postconditions :
	 * 
	 * @param vitesseJeu
	 */
	public void notitfyVitesseJeuChanged(int vitesseJeu) {
		this.niveau.getInfos().setVitesseJeu(vitesseJeu);
	}
}
