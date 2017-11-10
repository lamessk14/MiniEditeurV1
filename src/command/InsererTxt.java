package command;
import java.util.*;

import invoker.MonIHM;
import receiver.MoteurEditeurImplem;

/**
 * 
 */
public class InsererTxt implements Command {

	//Déclaration des variables
	private MoteurEditeurImplem moteur;
	private MonIHM ihm;
	
	//Constructeur
	public InsererTxt(MoteurEditeurImplem moteur1, MonIHM ihm1) {
		moteur = moteur1;
		ihm = ihm1;
	}

	@Override
	public void execute() {
		//moteur.insererTxt(ihm.getDernierCharactere());
	}

}