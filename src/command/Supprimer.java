package command;

import receiver.MoteurEditeurImplem;

/**
 * @author COULIBALY Fanta & Louise-Agn�s MACKONGO 
 */

public class Supprimer implements Command {
	private MoteurEditeurImplem moteur;

	/**
	 * 
	 * @param moteur1
	 */
	public Supprimer(MoteurEditeurImplem moteur1) {
		this.moteur = moteur1;
	}

	@Override
	public void execute() {
		moteur.supprimer();
	}

}
