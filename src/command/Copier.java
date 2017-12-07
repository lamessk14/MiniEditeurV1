package command;
import java.util.*;

import receiver.MoteurEditeurImplem;
/**
 * @author COULIBALY Fanta & Louise-Agnès MACKONGO 
 */

public class Copier implements Command {

	//Déclaration de variables
		private MoteurEditeurImplem moteur;

	    /**
	     * Permet de créer la commande copier
	     */
	    public Copier(MoteurEditeurImplem moteur1) {
	    	moteur = moteur1;
	    }

	    /**
	     * exécution de la fonction copier dans l'objet moteur
	     */
	    @Override
	    public void execute() {
	        moteur.copier();
	    }

}