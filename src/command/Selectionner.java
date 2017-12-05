package command;

import java.util.*;
import invoker.MyIHM;
import receiver.MoteurEditeurImplem;

/**
 * @author COULIBALY Fanta & Louise-Agnès MACKONGO 
 */

public class Selectionner implements Command {

	//Déclaration des variables
	private MoteurEditeurImplem moteur;
	private MyIHM ihm;

	//Constructeur
	public Selectionner(MoteurEditeurImplem moteur1, MyIHM ihm1) {
		this.moteur = moteur1;
		this.ihm = ihm1;
	}

	@Override
	public void execute() {
		moteur.selectionner(ihm.getDebutSelection(), ihm.getFinSelection());
	}

}