package sample.dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParser {
	Document document;

	DOMParser(String inputFile) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		document = dBuilder.parse(inputFile);
	}

	public Node createNewStudentElement(String rollNo, String firstName, String lastName, String nickName,
	        String marks) {
		Element root = null;

		root = document.createElement("student");
		root.setAttribute("rollno", rollNo);

		Element innerElement = document.createElement("firstname");
		innerElement.setTextContent(firstName);
		root.appendChild(innerElement);

		innerElement = document.createElement("lastname");
		innerElement.setTextContent(lastName);
		root.appendChild(innerElement);

		innerElement = document.createElement("nickname");
		innerElement.setTextContent(nickName);
		root.appendChild(innerElement);

		innerElement = document.createElement("marks");
		innerElement.setTextContent(marks);
		root.appendChild(innerElement);

		return root;
	}

	public String getNodeName() {
		return document.getDocumentElement().getNodeName();
	}

	//Only does it internally.
	public void appendNewStudent(Node student) {
		document.getDocumentElement().appendChild(student);
	}

	public NodeList getNodeListByName(String name) {
		return document.getElementsByTagName(name);
	}
}
