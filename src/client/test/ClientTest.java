package client.test;
import static org.junit.Assert.*;

import java.util.HashMap;

import observer.ObserverImplem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import receiver.MoteurEditeurImplem;
import command.Command;
import client.MonAppli;

/**
 * @author COULIBALY Fanta & Louise-Agnès MACKONGO 
 */
public class ClientTest {
	MonAppli client;
	MoteurEditeurImplem moteur;
	ObserverImplem ihm;
	HashMap<String,Command> commandes;

	@Before
	/**
	 * Actions effectuées avant les tests
	 * 
	 * Création des différents objets qui permettront d'effectuer les tests
	 * @throws Exception
	 */
	public void setUp() throws Exception {
		client = new MonAppli();
		moteur = client.getMoteur();
		ihm = client.getIHM();
		commandes = client.getCommandes();
		ihm.initComposants(commandes);
		moteur.registerObserver(ihm);
	}

	/**
	 * Actions réalisées après les tests
	 * 
	 * Libération des différents objets
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		client = null;
		moteur = null;
		ihm = null;
		commandes = null;
	}
/**
 * Vérification de la correspondance entre les commandes et les noms de commande
 */
	@Test
	public void testCommandes() {
		 assertEquals(commandes.get("couper"), ihm.getCommand("couper") );
		 assertEquals(commandes.get("copier"), ihm.getCommand("copier")); 
		 assertEquals(commandes.get("coller"), ihm.getCommand("coller"));
		 assertEquals(commandes.get("selectionner"), ihm.getTextArea().getCommand("selectionner")); 
		 assertEquals(commandes.get("insererTxt"), ihm.getTextArea().getCommand("insererTxt")); 
		 assertEquals(commandes.get("delete"), ihm.getTextArea().getCommand("supprimer")); 
	}
	
	/**
	 * Vérification de l'existence d'observers
	 */
	@Test
	public void testObservers() {
		 assertTrue(moteur.getObservers().contains(ihm)); 
	}
	
	/**
	 * Insertion d'une chaîne de caractères(papa), dernier caractère coupé puis collé
	 * au même emplacement de départ
	 * Sélection de la chaîne de caractère, copie puis coller
	 */
	@Test
	public void testMoteur(){
		moteur.insererTxt('p');
		moteur.insererTxt('a');
		moteur.insererTxt('p');
		moteur.insererTxt('a');
		assertEquals("papa", ihm.getTextArea().getText());
		moteur.supprimer();
		assertEquals("pap",ihm.getTextArea().getText());
		moteur.selectionner(0, 3);
		moteur.couper();
		assertEquals("",ihm.getTextArea().getText());
		assertEquals("pap",moteur.getPressePapierTexte());
		moteur.coller();
		assertEquals("pap",ihm.getTextArea().getText());
		moteur.insererTxt('a');
		moteur.insererTxt(' ');
		assertEquals("papa ",ihm.getTextArea().getText());
		moteur.selectionner(0, 5);
		moteur.copier();
		moteur.selectionner(5, 5);
		moteur.coller();
		assertEquals("papa papa ",ihm.getTextArea().getText());
	}

}
