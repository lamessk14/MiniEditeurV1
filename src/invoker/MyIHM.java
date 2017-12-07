package invoker;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import command.Command;

import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

/**
 * @author COULIBALY Fanta & Louise-Agnès MACKONGO 
 */
public class MyIHM extends JFrame {
	
/**
 * Déclaration des variables
 */
	private JFrame frame;
	private JPanel contentPaneMiniEditeur;
	protected TextArea zoneDeSaisie;
	protected BoutonsCommand couper;
	protected BoutonsCommand copier;
	protected BoutonsCommand coller;

	/**
	 * Create the frame.
	 */
	public MyIHM() {
		frame = new JFrame("Mini-EditeurV1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 400, 400);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
	}
	
	/**
	 * Initialisation des différents boutons + création de l'interface graphique et les éléments
	 * qui la compose
	 * 
	 * @param commandes
	 */
	public void initComposants(HashMap<String,Command> commandes){
		zoneDeSaisie = new TextArea(commandes);
		couper = Bouton("Couper", commandes.get("couper"));
		copier = Bouton("Copier", commandes.get("copier"));
		coller = Bouton("Coller", commandes.get("coller"));
		
		GroupLayout glContentPane = new GroupLayout(frame.getContentPane());
		glContentPane.setHorizontalGroup(
				glContentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, glContentPane.createSequentialGroup()
					.addGroup(glContentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(zoneDeSaisie, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
						.addGroup(glContentPane.createSequentialGroup()
							.addComponent(couper, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(copier, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(coller, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(0))
		);
		glContentPane.setVerticalGroup(
				glContentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(glContentPane.createSequentialGroup()
					.addGroup(glContentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(couper)
						.addComponent(copier)
						.addComponent(coller))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(zoneDeSaisie, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(glContentPane);
	}
	
	/**
	 * Affichage de l'interface graphique de l'application qui contient les différents
	 * éléments qui ont créés dans la fonction initComposants(HashMap<String,Command> commandes)
	 */
	public void afficher(){
		frame.pack();
		frame.setLocationRelativeTo(null);
		zoneDeSaisie.requestFocusInWindow();
		frame.setVisible(true);
	}
/**
 * 
 * @param nom
 * @param commande
 * @return une commande(couper, coller, copier) ainsi que le nom
 * qui lui est assoicié
 */
	private BoutonsCommand Bouton(String nom, Command commande) {
		BoutonsCommand boutonsCommand = new BoutonsCommand(nom, commande);
		boutonsCommand.setMaximumSize(new Dimension(Short.MAX_VALUE, boutonsCommand.getPreferredSize().height));
		boutonsCommand.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		
		boutonsCommand.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				zoneDeSaisie.requestFocusInWindow();
			}
		});
		return boutonsCommand;
	}
	
	/**
	 * 
	 * @param nom
	 * @return la commande associée au nom de commande donné en paramètre
	 */
	public Command getCommand(String nom) {
		if(nom == "couper"){
			return couper.getCommand();
		} else if (nom == "copier"){
			return copier.getCommand();
		} else if (nom == "coller"){
			return coller.getCommand();
		} else {
			return null;
		}
	}
	
	/**
	 * 
	 * @return la zone de saisie
	 */
	public TextArea getTextArea() {
		return zoneDeSaisie;
	}

	/**
	 * 
	 * @return le dernier caractère
	 */
	public char getDernierCharactere() {
		return zoneDeSaisie.getDernierCharactere();
	}

	/**
	 * 
	 * @return la position du début de la sélection
	 */
	public int getDebutSelection() {
		return zoneDeSaisie.getSelectionStart();
	}
	
	/**
	 * 
	 * @return la position de la fin de la sélection
	 */
	public int getFinSelection(){
		return zoneDeSaisie.getSelectionEnd();
	}

}
