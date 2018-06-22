package GUI;

import java.util.Observable;
import java.util.Observer;

public class Presenter implements Observer{

	public void startApplication() throws InterruptedException {
		//Lade XML Parser und generiere Graph aller Autobahnen mit Hilfe eines BackgroundWorkers
		//Wenn Work startet �ffne LoadingScreen
		LoadingAppWindow loadingScreen = new LoadingAppWindow();
		loadingScreen.setVisible(true);		
		
		//Sobald XML geparst ist, schlie�e LadeScreen und �ffne Hauptfenster
		Thread.sleep(5000);
		loadingScreen.setVisible(false);
		//
		MainWindow mainWindow = new MainWindow();
		mainWindow.setVisible(true);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		//Draw Graph into MainWindow		
	}
}