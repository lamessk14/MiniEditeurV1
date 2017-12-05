package command;
import java.util.*;

import invoker.MyIHM;
import receiver.MoteurEditeurImplem;

/**
 * @author COULIBALY Fanta & Louise-Agn�s MACKONGO 
 */

public class InsererTxt implements Command {

	//D�claration des variables
	private MoteurEditeurImplem moteur;
	private MyIHM ihm;
	
	//Constructeur
	public InsererTxt(MoteurEditeurImplem moteur1, MyIHM ihm1) {
		moteur = moteur1;
		ihm = ihm1;
	}

	@Override
	public void execute() {
		moteur.insererTxt(ihm.getDernierCharactere());
	}

}