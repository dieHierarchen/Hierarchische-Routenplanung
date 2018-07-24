package GUI;

import java.util.Observable;
import java.util.Observer;

import javax.xml.bind.TypeConstraintException;

public class Presenter implements Observer{
	
	private Modell modell;
	private LoadingScreenWorker loadingWorker;
	private MainWindow mainWindow;
	private LoadingAppWindow loadingScreen;
	
	public Presenter() {
		modell = new Modell();
		modell.addObserver(this);
		
		mainWindow = new MainWindow();
		loadingScreen = new LoadingAppWindow();
		loadingWorker = new LoadingScreenWorker(modell);
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
				DrawResultMainWindow();
			}
		}
		catch (Exception e) {
			
		}
	}
	
	private void startMainApplication() {
		loadingScreen.setVisible(false);
		mainWindow.setVisible(true);
	}
	
	private void DrawResultMainWindow() {
		//Zeichne result in MainWindow PictureFrame
	}
}
