package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LogParser {


    public static Collection<Long> getTimestampsByDescription(String xml, String description) throws Exception {

        List<Long> valores = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        Document doc = builder.parse(is);
        Element e = doc.getDocumentElement();
        NodeList contents = doc.getElementsByTagName("event");
        for (int i = 0; i < contents.getLength(); ++i)
        {
            Element elemA = (Element) contents.item(i);
            NodeList valueListB = elemA.getElementsByTagName("description");
            NodeList subList = valueListB.item(0).getChildNodes();
            if(subList.item(0).getNodeValue().equals(description)){
                XPath xPath =  XPathFactory.newInstance().newXPath();
                String xpathId2 = "/log/event["+(i+1)+"]/@timestamp";
                String id2=xPath.compile(xpathId2).evaluate(doc);
                valores.add(Long.valueOf(id2));
            }
        }
        return valores;
    }

    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<log>\n" +
                        "    <event timestamp=\"1614285589\">\n" +
                        "        <description>Intrusion detected</description>\n" +
                        "    </event>\n" +
                        "    <event timestamp=\"1614286432\">\n" +
                        "        <description>Intrusion ended</description>\n" +
                        "    </event>\n" +
                        "</log>";
        //getTimestampsByDescription(xml, "Intrusion ended");
        Collection<Long> timestamps = getTimestampsByDescription(xml, "Intrusion ended");
        for(long timestamp: timestamps)
           System.out.println(timestamp);
    }
}