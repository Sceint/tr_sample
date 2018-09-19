package sample.dom;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class App {

	public static void main(String[] args) {
		try {
			DOMParser domParser = new DOMParser("studentData.xml");

			//Create new student element.
			domParser.appendNewStudent(domParser.createNewStudentElement("5554", "First", "Last", "Nick", "13"));

			System.out.println("Root element :" + domParser.getNodeName());
			System.out.println("----------------------------");

			NodeList nodeList = domParser.getNodeListByName("student");
			for (int index = 0; index < nodeList.getLength(); index++) {
				Node node = nodeList.item(index);
				System.out.println("\nCurrent Element :" + node.getNodeName());

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					System.out.println("Student RollNo  : " + eElement.getAttribute("rollno"));
					System.out.println("First Name      : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println("Last Name       : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println("Nick Name       : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
					System.out.println("Marks           : " + eElement.getElementsByTagName("marks").item(0).getTextContent());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
