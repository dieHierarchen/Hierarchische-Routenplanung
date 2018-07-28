package GUI;

import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingWorker;
import javax.xml.bind.TypeConstraintException;
import javax.xml.soap.Node;

public class Presenter implements Observer{
	
	private Modell modell;
	private LoadingScreenWorker loadingWorker;
	private AlgorithmWorker algoWorker;
	private MainWindow mainWindow;
	private LoadingAppWindow loadingScreen;
	
	public Presenter() {
		modell = new Modell();
		modell.addObserver(this);
		
		mainWindow = new MainWindow(this);
		loadingScreen = new LoadingAppWindow();
		loadingWorker = new LoadingScreenWorker(modell);
		algoWorker = new AlgorithmWorker(modell, "notSetYet");
	}

	public void startApplication() throws InterruptedException {
		//Wenn Work startet �ffne LoadingScreen
		loadingScreen.setVisible(true);
		loadingWorker.execute();
	}

	@Override
	public void update(Observable o, Object arg) {
		try {
			
			if (!(arg instanceof Integer)) {
				throw new TypeConstraintException("arg has to be a Integer 1 <= arg <= 2");
			}
			
			int eventHandle = (Integer) arg;
			
			if (eventHandle == 1) {
				startMainApplication();
			}
			if (eventHandle == 2) {
				mainWindow.stopProgressBar();
				mainWindow.displayResults(modell.getresultList(), modell.getminDist());
				System.out.println("Finished Work");
			}
		}
		catch (Exception e) {
		
		}
	}
	
	private void startMainApplication() {
		loadingScreen.setVisible(false);	
		mainWindow.setComboBoxes(modell.getAllNames(), modell.getAlgorithms());
		mainWindow.setVisible(true);
	}

	
	public void StartCalculation(String start, String destination, String Algorithm) {
		//Test
		System.out.printf("StartPoint is: %s; Destination is %s, Algorithm is: %s \n", start, destination, Algorithm);
		//test end
		
		//get startNode and destination Node from Graph
//		node startNode = null;
//		node destinationNode = null;
//		
//		while (start == null && destination == null) {
//			for (Node n : modell.getHighWayGraph().getAllNodes()) {
//				if (n.getName() == start) {
//					startNode = n;
//				}
//				if (n.getName() == destination) {
//					destinationNode = n;
//				}
//			}
		
			
		if (algoWorker.getState() == SwingWorker.StateValue.PENDING ||
				algoWorker.getState() == SwingWorker.StateValue.DONE) {
			algoWorker = new AlgorithmWorker(modell, Algorithm);
			mainWindow.displayProgressBar();
			algoWorker.execute();
			System.out.println("Send Worker to work!");
		}
		else {
			//MessageBox ("Is running at the moment!");
			System.out.println("Is currently running!");
		}
		
	}
}
