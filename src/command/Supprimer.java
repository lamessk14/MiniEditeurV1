package command;

import receiver.MoteurEditeurImplem;

/**
 * @author COULIBALY Fanta & Louise-Agnès MACKONGO 
 */

public class Supprimer implements Command {
	private MoteurEditeurImplem moteur;

	/**
	 * Création de la commande supprimer
	 * @param moteur1
	 */
	public Supprimer(MoteurEditeurImplem moteur1) {
		this.moteur = moteur1;
	}

	/**
	 * Exécution de la commande supprimer
	 */
	@Override
	public void execute() {
		moteur.supprimer();
	}

}
