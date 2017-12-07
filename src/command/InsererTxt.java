package command;
import java.util.*;

import invoker.MyIHM;
import receiver.MoteurEditeurImplem;

/**
 * @author COULIBALY Fanta & Louise-Agn�s MACKONGO 
 */

public class InsererTxt implements Command {

	/**
	 * D�claration des variables
	 */
	private MoteurEditeurImplem moteur;
	private MyIHM ihm;
	
	/**
	 * Cr�ation de la commande InsererTxt
	 * 
	 * @param moteur1
	 * @param ihm1
	 */
	public InsererTxt(MoteurEditeurImplem moteur1, MyIHM ihm1) {
		moteur = moteur1;
		ihm = ihm1;
	}

	/**
	 * Ex�cution de la commande insererTxt
	 */
	@Override
	public void execute() {
		moteur.insererTxt(ihm.getDernierCharactere());
	}

}