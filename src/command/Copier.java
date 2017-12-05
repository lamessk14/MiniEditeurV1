package command;
import java.util.*;

import receiver.MoteurEditeurImplem;
/**
 * @author COULIBALY Fanta & Louise-Agn�s MACKONGO 
 */

public class Copier implements Command {

	//D�claration de variables
		private MoteurEditeurImplem moteur;

	    /**
	     * Constructeur
	     */
	    public Copier(MoteurEditeurImplem moteur1) {
	    	moteur = moteur1;
	    }

	    /**
	     * ex�cution de la fonction copier dans l'objet moteur
	     */
	    @Override
	    public void execute() {
	        moteur.copier();
	    }

}