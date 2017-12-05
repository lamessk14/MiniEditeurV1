package command;
import java.util.*;
import receiver.MoteurEditeurImplem;

/**
 * @author COULIBALY Fanta & Louise-Agnès MACKONGO 
 */

public class Couper implements Command {

	//Déclaration de variables
		private MoteurEditeurImplem moteur;

	    /**
	     * Constructeur
	     */
	    public Couper(MoteurEditeurImplem moteur1) {
	    	moteur = moteur1;
	    }

	    /**
	     * Exécution de la fonction couper dans l'objet moteur
	     */
	    @Override
	    public void execute() {
	        moteur.couper();
	    }

}