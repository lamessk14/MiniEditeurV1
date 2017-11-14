package invoker;

import javax.swing.JTextArea;

import command.Command;

public class TextArea extends JTextArea {
	
	private int debutSelection;
	private int finSelection;
	private char dernierChar;
	private Command selectionner;
	private Command inserer;
	
	public void setSelection(int debutSelection1, int finSelection1) {
		debutSelection = debutSelection1;
		finSelection = finSelection1;
	}
	
	public Command getCommand(String nom) {
		if(nom == "selectionner"){
			return selectionner;
		} else if (nom == "inserer"){
			return inserer;
		} else {
			return null;
		}
	}
	
	public char getDernierCharactere() {
		return dernierChar;
	}

	public void MAJ(String texte, int debutSelection1, int finSelection1) {
		setText(texte);
		setSelectionStart(debutSelection1);
		setSelectionEnd(finSelection1);
		setSelection(debutSelection1, finSelection1);
		requestFocusInWindow();
	}

}
