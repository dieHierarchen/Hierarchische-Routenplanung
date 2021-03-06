package Logic;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import Graph.Graph;

public class XmlParser {
	private Graph graph;
	private XmlReadyCallback readyCallback;
	
	public XmlParser(Graph graph, XmlReadyCallback readyCallback) {
		this.graph = graph;
		this.readyCallback = readyCallback;
	}
	
	public void startParsing() {
		String path = "ShortedXmlHighwaysOnly.xml";
		
		//Knoten aus XML in Graph schreiben
		DefaultHandler nodeHandler = new XmlNodeParser(graph);
		SAXParserFactory nodeFactory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = nodeFactory.newSAXParser();
			parser.parse(new File(path), nodeHandler);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Parsing of Nodes done");
		
		//Kanten aus XML in Graph schreiben
		DefaultHandler edgeHandler = new XmlEdgeParser(graph);
		SAXParserFactory edgeFactory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = edgeFactory.newSAXParser();
			parser.parse(new File(path), edgeHandler);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		readyCallback.readingXmlDone(graph);
	}
}
