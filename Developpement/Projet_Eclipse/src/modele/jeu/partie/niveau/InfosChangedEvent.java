/**
 * 
 */
package modele.jeu.partie.niveau;

import java.util.EventObject;
import java.util.Map;

import modele.jeu.partie.niveau.lemming.aptitude.TypeAptitude;

/**
 * @author Paul
 * 
 */
public class InfosChangedEvent extends EventObject {

	/**
	 * S�mantique : Cr�e un DonneesEvent
	 * Pr�conditions :
	 * Postconditions :
	 * 
	 * @param source
	 * @param nombreTotal
	 * @param nombreASauver
	 * @param tempsImparti
	 * @param vitesseJeu
	 * @param vitesseApparition
	 */
	public InfosChangedEvent(InfosNiveau infos) {
		super(infos);
	}

	/**
	 * S�mantique : R�cup�re le detail des aptitudes possibles (nom et nombre
	 * restant par aptitude)
	 * Pr�conditions :
	 * Postconditions :
	 * 
	 * @return le detail des aptitudes
	 */
	public Map<TypeAptitude, Integer> getDetailsAptitudes() {
		InfosNiveau infos = (InfosNiveau) this.source;
		return infos.getDetailsAptitudes();
	}

	/**
	 * S�mantique : R�cup�re le nombre d'aptitudes de ce type
	 * Pr�conditions :
	 * Postconditions :
	 * 
	 * @param nom
	 * @return
	 */
	public int getNombreAptitude(TypeAptitude nom) {
		InfosNiveau infos = (InfosNiveau) this.source;
		return infos.getNombreAptitude(nom);
	}

	/**
	 * S�mantique : R�cup�re le nombre de lemmings apparus depuis le d�but du
	 * niveau
	 * Pr�conditions :
	 * Postconditions : < nombreLemmingsTotal
	 * 
	 * @return le nombre de lemmings apparus
	 */
	public int getNombreLemmingsApparus() {
		InfosNiveau infos = (InfosNiveau) this.source;
		return infos.getNombreLemmingsApparus();
	}

	/**
	 * S�mantique : R�cup�re le nombre de lemmings restant a sauver
	 * Pr�conditions :
	 * Postconditions : >= 0
	 * 
	 * @return le nombre de lemmings a sauver
	 */
	public int getNombreLemmingsASauver() {
		InfosNiveau infos = (InfosNiveau) this.source;
		return infos.getNombreLemmingsASauver();
	}

	/**
	 * R�cup�re le nombreLemmingsEnJeu
	 * 
	 * @return le nombreLemmingsEnJeu
	 */
	public int getNombreLemmingsEnJeu() {
		InfosNiveau infos = (InfosNiveau) this.source;
		return infos.getNombreLemmingsEnJeu();
	}

	/**
	 * S�mantique : R�cup�re le nombre de lemmings morts
	 * Pr�conditions :
	 * Postconditions : >=0 et <= getNombreLemmingsTotal()
	 * 
	 * @return le nombre de lemmings morts
	 */
	public int getNombreLemmingsMorts() {
		InfosNiveau infos = (InfosNiveau) this.source;
		return infos.getNombreLemmingsMorts();
	}

	/**
	 * S�mantique : R�cup�re le nombre de lemmings sauv�s
	 * Pr�conditions :
	 * Postconditions : >= 0 et <= getNombreLemmingsASauver()
	 * 
	 * @return le nombre de lemmings sauves
	 */
	public int getNombreLemmingsSauves() {
		InfosNiveau infos = (InfosNiveau) this.source;
		return infos.getNombreLemmingsSauves();
	}

	/**
	 * S�mantique : R�cup�re le nombre total de lemmings du niveau
	 * Pr�conditions :
	 * Postconditions : >= 0
	 * 
	 * @return le nombre total de lemmings du niveau
	 */
	public int getNombreLemmingsTotal() {
		InfosNiveau infos = (InfosNiveau) this.source;
		return infos.getNombreLemmingsTotal();
	}

	/**
	 * R�cup�re le tempsImparti
	 * 
	 * @return le tempsImparti
	 */
	public int getTempsImparti() {
		InfosNiveau infos = (InfosNiveau) this.source;
		return infos.getTempsImparti();
	}

	/**
	 * S�mantique : R�cup�re le temps restant
	 * Pr�conditions :
	 * Postconditions : >= 0 && <= temps imparti
	 * 
	 * @return le temps restant
	 */
	public int getTempsRestant() {
		InfosNiveau infos = (InfosNiveau) this.source;
		return infos.getTempsRestant();
	}

	/**
	 * S�mantique : R�cup�re la vitesse d'apparition des lemmings
	 * Pr�conditions :
	 * Postconditions : >= 0 && <= VITESSE_APPARITION_LEMMINGS_MAX
	 * 
	 * @return la vitesse du jeu
	 */
	public int getVitesseApparitionLemmings() {
		InfosNiveau infos = (InfosNiveau) this.source;
		return infos.getVitesseApparitionLemmings();
	}

	/**
	 * S�mantique : R�cup�re le vitesseApparitionLemmingsMin
	 * Pr�conditions :
	 * Postconditions : >= 0 && <= VITESSE_APPARITION_LEMMINGS_MAX
	 * 
	 * @return le vitesseApparitionLemmingsMin
	 */
	public int getVitesseApparitionLemmingsMin() {
		InfosNiveau infos = (InfosNiveau) this.source;
		return infos.getVitesseApparitionLemmingsMin();
	}

	/**
	 * S�mantique : R�cup�re la vitesse du jeu
	 * Pr�conditions :
	 * Postconditions : >= 0 && <= VITESSE_JEU_MAX
	 * 
	 * @return la vitesse du jeu
	 */
	public int getVitesseJeu() {
		InfosNiveau infos = (InfosNiveau) this.source;
		return infos.getVitesseJeu();
	}

	/**
	 * R�cup�re le jeuEnPause
	 * 
	 * @return le jeuEnPause
	 */
	public boolean isJeuEnPause() {
		InfosNiveau infos = (InfosNiveau) this.source;
		return infos.isJeuEnPause();
	}
}
