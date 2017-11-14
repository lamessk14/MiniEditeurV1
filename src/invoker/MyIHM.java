package invoker;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import command.Command;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyIHM extends JFrame {

	private JPanel contentPaneMiniEditeur;
	protected TextArea zoneDeSaisie;
	protected BoutonsCommand couper;
	protected BoutonsCommand copier;
	protected BoutonsCommand coller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyIHM frame = new MyIHM();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public MyIHM() {
		setTitle("MiniEditeurV1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBarMiniEdit = new JMenuBar();
		menuBarMiniEdit.setToolTipText("");
		setJMenuBar(menuBarMiniEdit);
		
		JButton btnCopier = new JButton("Copier");
		menuBarMiniEdit.add(btnCopier);
		
		JButton btnColler = new JButton("Coller");
		menuBarMiniEdit.add(btnColler);
		
		JButton btnCouper = new JButton("Couper");
		btnCouper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		menuBarMiniEdit.add(btnCouper);
		contentPaneMiniEditeur = new JPanel();
		contentPaneMiniEditeur.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPaneMiniEditeur.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPaneMiniEditeur);
		
		JTextArea textAreazoneDeSaisie = new JTextArea();
		textAreazoneDeSaisie.setTabSize(5);
		textAreazoneDeSaisie.setRows(5);
		textAreazoneDeSaisie.setText("");
		contentPaneMiniEditeur.add(textAreazoneDeSaisie, BorderLayout.CENTER);
	}
	
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
	
	public TextArea getTextArea() {
		return zoneDeSaisie;
	}

	
	public char getDernierCharactere() {
		return zoneDeSaisie.getDernierCharactere();
	}

	public int getDebutSelection() {
		return zoneDeSaisie.getSelectionStart();
	}
	
	public int getFinSelection(){
		return zoneDeSaisie.getSelectionEnd();
	}

}
