import java.awt.List;
import java.util.ArrayList;
import java.util.Map.Entry;

import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.DefaultHandler;

import Graph.Graph;

public class XmlNodeParser extends DefaultHandler {
	private AttributesImpl attributes = new AttributesImpl();
	private ElementContent elements;
	protected Graph graph;
	
	public XmlNodeParser(Graph graph) {
		this.graph = graph;
	}
	
	protected ElementContent getElementContent(String qName, AttributesImpl attributes) {
		return new ElementContent(qName, attributes);
	}
	
	public void endDocument() {
	}
	
	protected class ElementContent{
		private String qName;
		private AttributesImpl attributes;
		protected ArrayList<ElementContent> children = new ArrayList<ElementContent>();
		
		public ElementContent(String qName, AttributesImpl attributes) {
			this.qName = qName;
			this.attributes = attributes;
		}
		
		public void addChild(ElementContent element) {
			children.add(element);
		}
		
		public AttributePair getAttributePair() {
			String key = "";
			String value = "";
			for(int i = 0; i<attributes.getLength(); i++) {
				if(attributes.getQName(i).contains("k")) {
					key = attributes.getValue(i);
				}else if (attributes.getQName(i).contains("v")) {
					value = attributes.getValue(i);
				}
			}
			return new AttributePair(key,value);
		}
		
		public void elementIsReady() {
			int id = 0;
			String name = "";
			double lon = 0;
			double lat = 0;
			
			for(ElementContent child:children) {
				AttributePair pair = child.getAttributePair();
				if (pair.key.contains("name")) {
					name = pair.value;
				}
			}
			
			for(int i = 0; i<attributes.getLength(); i++) {
				switch(attributes.getQName(i)) {
				case "id":
					id = Integer.parseInt(attributes.getValue(i));
				case "lon":
					lon = Double.parseDouble(attributes.getValue(i));
				case "lat":
					lat = Double.parseDouble(attributes.getValue(i));
				}
			}
			
			if(id != 0 && name != "" && lon != 0 && lat != 0) {
				graph.addNode(name, id, lon, lat);
			}
		}
	}
	
	protected class AttributePair{
		public String value;
		public String key;
		public AttributePair(String key, String value) {
			this.value = value;
			this.key = key;
		}
	}

	
	public void startElement(String nameSpaceURI, String localName, String qName, Attributes atts) {
		if (qName == "node") {
			if(elements != null) {
				elements.elementIsReady();
				elements = null;
			}
			
			attributes = new AttributesImpl();
			for (int i = 0; i < atts.getLength(); i++) {
				attributes.addAttribute("", "", atts.getQName(i), "", atts.getValue(i));
			}
			elements = getElementContent(qName, attributes);
		} else if (qName == "tag"){
			attributes = new AttributesImpl();
			for (int i = 0; i < atts.getLength(); i++) {
				attributes.addAttribute("", "", atts.getQName(i), "", atts.getValue(i));
			}
			
			if(elements != null) {
				elements.addChild(getElementContent(qName, attributes));
			}
		}
	}
	
	public void endElement(String namespaceUI, String localName, String qName) {
		if(qName == "node") {
			if(elements != null) {
				elements.elementIsReady();
				elements = null;
			}
		}
	}
	
	public void characters(char[] ch, int start, int length) {
		
	}
}
