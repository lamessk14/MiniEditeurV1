package client;

import java.util.*;
import java.util.HashMap;

import observer.ObserverImplem;
import receiver.*;
import command.*;

/**
 * 
 */
public class MonAppli {
	
	private MoteurEditeurImplem moteur;
	private ObserverImplem ihm;
	private HashMap<String,Command> commandes;

    /**
     * Default constructor
     */
    public MonAppli() {
    	moteur = new MoteurEditeurImplem();
		ihm = new ObserverImplem(moteur);
		commandes = new HashMap<String,Command>();
		commandes.put("couper", new Couper(moteur));
		commandes.put("copier", new Copier(moteur));
		commandes.put("coller", new Coller(moteur));
		commandes.put("selectionner", new Selectionner(moteur, ihm));
		commandes.put("inserer", new InsererTxt(moteur, ihm));
		commandes.put("supprimer", new Supprimer(moteur));
    }

    public void start(){
		ihm.initComposants(commandes);
		moteur.registerObserver(ihm);
		ihm.afficher();
	}

	public static void main(String args[]) {
		MonAppli monAppli = new MonAppli();
		monAppli.start();
	}

	public MoteurEditeurImplem getMoteur(){
		return moteur;
	}
	
	public ObserverImplem getIHM(){
		return ihm;
	}
	
	public HashMap<String,Command> getCommandes(){
		return commandes;
	}

}