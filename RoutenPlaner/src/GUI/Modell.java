package GUI;

import java.util.ArrayList;
import java.util.Observable;

public class Modell extends Observable{
	private ArrayList<Integer> resultListNodes;		//Sp�ter m�ssen hier Knoten statt Int sein
	private int minDistance;
	
	public void setResults(int minDistance, ArrayList<Integer> resultNodes) {
		this.minDistance = minDistance;
		this.resultListNodes = resultNodes;
		setChanged();
		//notifyObservers(arg); 						//EventArgs Klasse schreiben
	}
}
