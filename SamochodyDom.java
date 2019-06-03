
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;
class Samochod{
	String typ;
	String marka;
	String model;
	String kolor;
	String skrzyniaBiegow;
	String paliwo;
	

}
public class SamochodyDom {
	File xmlFile = new File("Samochody.xml");
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();


	String id;
	String field;

	void print(String filename) throws SAXException, IOException, ParserConfigurationException {
		xmlFile = new File(filename);

		DocumentBuilder dBuilder = factory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);

		doc.getDocumentElement().normalize();

		//System.out.println(doc.getDocumentElement().getNodeName());

		NodeList nList = doc.getElementsByTagName("samochod");
		System.out.printf("Samochody !!! \n\n");
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			//System.out.println("\nCurrent Element: " + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element elem = (Element) nNode;

				Node node = elem.getElementsByTagName("typ").item(0);
				System.out.printf("Typ: %s\n", node.getTextContent());

				node = elem.getElementsByTagName("marka").item(0);
				System.out.printf("Marka: %s\n", node.getTextContent());
				
				node = elem.getElementsByTagName("model").item(0);
				System.out.printf("Model: %s\n", node.getTextContent());

				node = elem.getElementsByTagName("kolor").item(0);
				System.out.printf("Kolor: %s\n",node.getTextContent());

				node = elem.getElementsByTagName("skrzyniaBiegow").item(0);
				System.out.printf("Skrzynia Biegow: %s\n",node.getTextContent());

				node = elem.getElementsByTagName("paliwo").item(0);
				System.out.printf("Paliwo : %s\n\n",node.getTextContent());

				

			}
		}
	}

	void chooseSamochod() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Choose car to chage:");
		id = keyboard.nextLine();
	}


	void updateAction() throws ParserConfigurationException, SAXException, IOException, TransformerException {
		chooseSamochod();
		DocumentBuilder dBuilder = factory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);
		doc.getDocumentElement().normalize();

		Element wypozyczalnia = doc.getDocumentElement();
		NodeList nl = wypozyczalnia.getElementsByTagName("samochod");
		Element ee = (Element) nl.item(Integer.parseInt(id)-1);
		//do ee przypisujemy produkt o podanym id

		System.out.print("Typ : ");
		System.out.print(ee.getElementsByTagName("typ").item(0).getTextContent()+"\n");
		System.out.print("Marka : ");
		System.out.print(ee.getElementsByTagName("marka").item(0).getTextContent()+"\n");
		System.out.print("Model : ");
		System.out.print(ee.getElementsByTagName("model").item(0).getTextContent()+"\n");
		System.out.print("Kolor : ");
		System.out.print(ee.getElementsByTagName("kolor").item(0).getTextContent()+"\n");
		System.out.print("Skrzynia Biegow : ");
		System.out.print(ee.getElementsByTagName("skrzyniaBiegow").item(0).getTextContent()+"\n");
		System.out.print("Paliwo : ");
		System.out.print(ee.getElementsByTagName("paliwo").item(0).getTextContent()+"\n");
		System.out.println("Podaj nowe wartosci. (typ,marka,model,kolor,Skrzynia Biegow,paliwo). Puste pola pozostawiaja je niezmienione.");
		Scanner keyboard = new Scanner(System.in);
		String in1 = keyboard.nextLine();
		if(!in1.isEmpty()) ee.getElementsByTagName("typ").item(0).setTextContent(in1);
		in1 = keyboard.nextLine();
		if(!in1.isEmpty()) ee.getElementsByTagName("marka").item(0).setTextContent(in1);
		in1 = keyboard.nextLine();
		if(!in1.isEmpty()) ee.getElementsByTagName("model").item(0).setTextContent(in1);
		in1 = keyboard.nextLine();
		if(!in1.isEmpty()) ee.getElementsByTagName("kolor").item(0).setTextContent(in1);
		in1 = keyboard.nextLine();
		if(!in1.isEmpty()) ee.getElementsByTagName("skrzyniaBiegow").item(0).setTextContent(in1);
		in1 = keyboard.nextLine();
		if(!in1.isEmpty()) ee.getElementsByTagName("paliwo").item(0).setTextContent(in1);
	
		TransformerFactory tff = TransformerFactory.newInstance();
		Transformer tf = tff.newTransformer();
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		tf.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC,"yes");
		DOMSource ds = new DOMSource(doc);
		StreamResult sr = new StreamResult("SamochodyUpdate.xml");
		tf.transform(ds, sr);
		}

		void deleteAction() throws SAXException, IOException, ParserConfigurationException, TransformerException {
		chooseSamochod();
		DocumentBuilder dBuilder = factory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);
		doc.getDocumentElement().normalize();

		Element kebabownia = doc.getDocumentElement();
		NodeList nl = kebabownia.getElementsByTagName("samochod");
		Element ee = (Element) nl.item(Integer.parseInt(id)-1);

		ee.getParentNode().removeChild(ee);


		TransformerFactory tff = TransformerFactory.newInstance();
		Transformer tf = tff.newTransformer();
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		tf.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC,"yes");
		DOMSource ds = new DOMSource(doc);
		StreamResult sr = new StreamResult("SamochodyDelete.xml");
		tf.transform(ds, sr);
}


	public static void main(String argv[])  throws SAXException, IOException, ParserConfigurationException, TransformerException{
		SamochodyDom a = new SamochodyDom();
		a.print("Samochody.xml");
		a.updateAction();
		a.deleteAction();
		
	} 
}

   


