package Logic;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.DefaultHandler;
import Graph.Graph;

public class XmlNodeParser extends DefaultHandler {
	private AttributesImpl attributes = new AttributesImpl();
	private ElementContent elements;
	protected Graph graph;
	
	private ElementContent latestTag;
	
	public XmlNodeParser(Graph graph) {
		this.graph = graph;
	}
	
	//Factory funktion zum aufruf des ElementContent konstruktors
	protected ElementContent getElementContent(String qName, AttributesImpl attributes) {
		return new ElementContent(qName, attributes);
	}
	
	public void endDocument() {
		System.out.println("End of Document reached");
	}
	
	//Knoten Informationen
	protected class ElementContent{
		protected String qName;
		public String innerXML;
		protected AttributesImpl attributes;
		protected ArrayList<ElementContent> children = new ArrayList<ElementContent>();
		
		public ElementContent(String qName, AttributesImpl attributes) {
			this.qName = qName;
			this.attributes = attributes;
		}
		
		public void addChild(ElementContent element) {
			children.add(element);
		}
		
		//Knoten informationen an Graph übertragen
		public void elementIsReady() {
			String id = "";
			double lon = 0;
			double lat = 0;
			
			if(qName == "node") {
				try {
					for(int i = 0; i<attributes.getLength(); i++) {
						if(attributes.getQName(i) == "id") {
							id = attributes.getValue(i);
						}
					}
					
					for(ElementContent child:children) {
						for(int i = 0; i<child.attributes.getLength(); i++) {
							if (child.attributes.getQName(i).contains("key") && child.attributes.getValue(i).contains("lat") && child.innerXML != "") {
								lat = Double.parseDouble(child.innerXML);
							} else if (child.attributes.getQName(i).contains("key") && child.attributes.getValue(i).contains("lon") && child.innerXML != "") {
								lon = Double.parseDouble(child.innerXML);
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				if(id != "" && lon != 0 && lat != 0) {
					graph.addNode(id, lon, lat);
				}
			}
		}
	}

	//Tag Name und Attribute parsen
	public void startElement(String nameSpaceURI, String localName, String qName, Attributes atts) {
		if (qName == "node" || qName == "edge") {
			if(elements != null) {
				elements.elementIsReady();
				elements = null;
			}
			
			attributes = new AttributesImpl();
			for (int i = 0; i < atts.getLength(); i++) {
				attributes.addAttribute("", "", atts.getQName(i), "", atts.getValue(i));
			}
			elements = getElementContent(qName, attributes);
			latestTag = elements;
		} else if (qName == "data"){
			attributes = new AttributesImpl();
			for (int i = 0; i < atts.getLength(); i++) {
				attributes.addAttribute("", "", atts.getQName(i), "", atts.getValue(i));
			}
			
			if(elements != null) {
				latestTag = getElementContent(qName, attributes);
				elements.addChild(latestTag);
			}
		}
	}
	
	public void endElement(String namespaceUI, String localName, String qName) {
		if(qName == "node" || qName == "edge") {
			if(elements != null) {
				elements.elementIsReady();
				elements = null;
				latestTag = null;
			}
		}
		
	}

	//Text im Tag parsen
	public void characters(char[] ch, int start, int length) {
		String innerXML = "";
		for(int i = start; i < start + length; i++) {
			innerXML += ch[i];
		}
		if (latestTag != null) {
			latestTag.innerXML = innerXML;
		}
	}
}
