import static org.junit.Assert.*;

import java.util.HashMap;

import observer.ObserverImplem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import receiver.MoteurEditeurImplem;
import command.Command;
import client.MonAppli;

public class ClientTest {
	MonAppli client;
	MoteurEditeurImplem moteur;
	ObserverImplem ihm;
	HashMap<String,Command> commandes;

	@Before
	public void setUp() throws Exception {
		client = new MonAppli();
		moteur = client.getMoteur();
		ihm = client.getIHM();
		commandes = client.getCommandes();
		ihm.initComposants(commandes);
		moteur.registerObserver(ihm);
	}

	@After
	public void tearDown() throws Exception {
		client = null;
		moteur = null;
		ihm = null;
		commandes = null;
	}

	@Test
	public void testCommandes() {
		 assertEquals(commandes.get("couper"), ihm.getCommand("couper") );
		 assertEquals(commandes.get("copier"), ihm.getCommand("copier")); 
		 assertEquals(commandes.get("coller"), ihm.getCommand("coller"));
		 assertEquals(commandes.get("selectionner"), ihm.getTextArea().getCommand("selectionner")); 
		 assertEquals(commandes.get("inserer"), ihm.getTextArea().getCommand("inserer")); 
		 assertEquals(commandes.get("supprimer"), ihm.getTextArea().getCommand("supprimer")); 
	}
	
	@Test
	public void testObservers() {
		 assertTrue(moteur.getObservers().contains(ihm)); 
	}
	
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
