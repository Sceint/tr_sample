package sample.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class UserSAXHandler extends DefaultHandler {
	boolean isFirstName = false;
	boolean isLastName = false;
	boolean isNickName = false;
	boolean isMarks = false;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("student")) {
			String rollNo = attributes.getValue("rollno");
			System.out.println("\nRoll No     : " + rollNo);
		} else if (qName.equalsIgnoreCase("firstname")) {
			isFirstName = true;
		} else if (qName.equalsIgnoreCase("lastname")) {
			isLastName = true;
		} else if (qName.equalsIgnoreCase("nickname")) {
			isNickName = true;
		} else if (qName.equalsIgnoreCase("marks")) {
			isMarks = true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if (qName.equalsIgnoreCase("student")) {
			System.out.println("End Element : " + qName);
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {

		if (isFirstName) {
			System.out.println("First Name  : " + new String(ch, start, length));
			isFirstName = false;
		} else if (isLastName) {
			System.out.println("Last Name   : " + new String(ch, start, length));
			isLastName = false;
		} else if (isNickName) {
			System.out.println("Nick Name   : " + new String(ch, start, length));
			isNickName = false;
		} else if (isMarks) {
			System.out.println("Marks       : " + new String(ch, start, length));
			isMarks = false;
		}
	}
}
