package command;
import java.util.*;

import invoker.MyIHM;
import receiver.MoteurEditeurImplem;

/**
 * @author COULIBALY Fanta & Louise-Agnès MACKONGO 
 */

public class InsererTxt implements Command {

	/**
	 * Déclaration des variables
	 */
	private MoteurEditeurImplem moteur;
	private MyIHM ihm;
	
	/**
	 * Création de la commande InsererTxt
	 * 
	 * @param moteur1
	 * @param ihm1
	 */
	public InsererTxt(MoteurEditeurImplem moteur1, MyIHM ihm1) {
		moteur = moteur1;
		ihm = ihm1;
	}

	/**
	 * Exécution de la commande insererTxt
	 */
	@Override
	public void execute() {
		moteur.insererTxt(ihm.getDernierCharactere());
	}

}