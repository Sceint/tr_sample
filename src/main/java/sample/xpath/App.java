package sample.xpath;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

public class App {
	public static void main(String[] args) {
		try {
			XPathParser parser = new XPathParser("studentData.xml");

			System.out.println(parser.getStudentByRollNo(493));

			List<String> names = parser.getStudentWithMarksGreaterThan(87);
			System.out.println("Students with marks > 87 : " + names);

		} catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException e) {
			e.printStackTrace();
		}

	}
}
