package Logic;

import org.xml.sax.helpers.AttributesImpl;

import Graph.Graph;

public class XmlEdgeParser extends XmlNodeParser{

	public XmlEdgeParser(Graph graph) {
		super(graph);
	}
	
	@Override
	protected ElementContent getElementContent(String qName, AttributesImpl attributes) {
		return new ElementContent(qName, attributes);
	}
	
	protected class ElementContent extends XmlNodeParser.ElementContent{
		public ElementContent(String qName, AttributesImpl attributes) {
			super(qName,attributes);
		}
		
		//Kanten Informationen an Graph übertragen
		public void elementIsReady() {
			String sourceId = "";
			String targetId = "";
			float weight = 0;
			try {
				if (this.qName == "edge") {
					for(int i = 0; i < attributes.getLength(); i++) {
						if (attributes.getQName(i) == "source") {
							sourceId = attributes.getValue(i);
						} else if (attributes.getQName(i) == "target") {
							targetId = attributes.getValue(i);
						}
					}
					
					for (XmlNodeParser.ElementContent child:children) {
						if (child.qName == "data") {
							for(int i = 0; i < child.attributes.getLength(); i++) {
								if (child.attributes.getQName(i).contains("key")&& child.attributes.getValue(i).contains("gewicht") && child.innerXML != "") {
									weight = Float.parseFloat(child.innerXML);
								}
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (sourceId != "" && targetId != "" && weight != 0) {
				graph.addEdge(sourceId, targetId, weight);
			}
		}
	}
	
}
