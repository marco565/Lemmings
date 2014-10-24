/**
 * 
 */
package vue.swing.partie;

import controleur.PartieController;

/**
 * @author Paul
 * 
 */
public abstract class PartieView {
	private PartieController controller;

	/**
	 * S�mantique : Cr�e un NiveauDisplayView
	 * Pr�conditions :
	 * Postconditions :
	 * 
	 * @param controller
	 */
	public PartieView(PartieController controller) {
		this.controller = controller;
	}

	public abstract void close();

	public abstract void display();

	public final PartieController getController() {
		return this.controller;
	}
}
