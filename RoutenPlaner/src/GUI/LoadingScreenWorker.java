/**
 * @author Robin.Schneider
 */

package GUI;

import javax.swing.SwingWorker;
import Graph.Graph;
import Logic.XmlParser;
import Logic.XmlReadyCallback;

public class LoadingScreenWorker extends SwingWorker<Integer, Integer> implements XmlReadyCallback{
	
	private Modell modell;
	
	public LoadingScreenWorker(Modell modell) {
		this.modell = modell;
	}
	
	@Override
	protected Integer doInBackground() throws Exception {
		
		Graph graph = new Graph();
		XmlParser parser = new XmlParser(graph, this);
		parser.startParsing();
		return null;
	}

	@Override
	public void readingXmlDone(Graph newGraph) {
		modell.setHighWayGraph(newGraph);
	}
	
}
