package command;

import receiver.MoteurEditeurImplem;

/**
 * @author COULIBALY Fanta & Louise-Agn�s MACKONGO 
 */

public class Supprimer implements Command {
	private MoteurEditeurImplem moteur;

	/**
	 * Cr�ation de la commande supprimer
	 * @param moteur1
	 */
	public Supprimer(MoteurEditeurImplem moteur1) {
		this.moteur = moteur1;
	}

	/**
	 * Ex�cution de la commande supprimer
	 */
	@Override
	public void execute() {
		moteur.supprimer();
	}

}
