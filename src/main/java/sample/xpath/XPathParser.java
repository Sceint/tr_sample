package sample.xpath;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XPathParser {
	XPath xpath;
	Document document;

	XPathParser(String inputFile) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		document = dBuilder.parse(inputFile);

		XPathFactory xpathFactory = XPathFactory.newInstance();
		xpath = xpathFactory.newXPath();
	}

	public String getStudentByRollNo(int rollNo) throws XPathExpressionException {
		String name = null;
		XPathExpression expr = xpath.compile("/students/student[@rollno='" + rollNo + "']/nickname/text()");
		name = (String) expr.evaluate(document, XPathConstants.STRING);

		return name;
	}

	public List<String> getStudentWithMarksGreaterThan(int marks) throws XPathExpressionException {
		List<String> namesOfStudents = new ArrayList<>();

		XPathExpression expr = xpath.compile("/students/student[marks>" + marks + "]/nickname/text()");

		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);

		for (int index = 0; index < nodes.getLength(); index++)
			namesOfStudents.add(nodes.item(index).getNodeValue());

		return namesOfStudents;
	}
}
