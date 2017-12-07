package client;

import java.util.*;
import java.util.HashMap;

import observer.ObserverImplem;
import receiver.*;
import command.*;

/**
 * @author COULIBALY Fanta & Louise-Agn�s MACKONGO 
 */
public class MonAppli {
	/**
	 * D�claration des variables
	 */
	private MoteurEditeurImplem moteur;
	private ObserverImplem ihm;
	private HashMap<String,Command> commandes;

    /**
     * Cr�ation de tous les objets qui permettront le fonctionnement de l'application
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
/**
 * Initialisation des diff�rentes fonctions (copier, coller, couper...) du pattern Command
 * Il n'y a qu'une seule classe Observer. Il s'agit du moteurEditeur
 * Affichage de l'interface graphique
 */
    public void start(){
		ihm.initComposants(commandes);
		moteur.registerObserver(ihm);
		ihm.afficher();
	}
/**
 * Ex�cution du main
 * 
 * @param args
 */
	public static void main(String args[]) {
		MonAppli monAppli = new MonAppli();
		monAppli.start();
	}
/**
 * 
 * @return l'objet moteur �diteur
 */
	public MoteurEditeurImplem getMoteur(){
		return moteur;
	}
/**
 * 
 * @return le client ihm
 */
	public ObserverImplem getIHM(){
		return ihm;
	}
/**
 * 
 * @return les diff�rentes commandes
 */
	public HashMap<String,Command> getCommandes(){
		return commandes;
	}

}