package src.linus.xmlvalidator;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XMLValidator {

	public static void main(String ...a) throws Exception{
		System.out.println("*****Validate XML against XSD*****");
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		//System.out.print("\nPlease enter the path of XML file :\t");
		String xmlPath = "D:\\PracticePrograms\\JAXB_practice\\assetDetails.xml"; //br.readLine();
		//System.out.print("Please enter the path of XSD file :\t");
		String xsdPath = "D:\\PracticePrograms\\JAXB_practice\\assetDetails.xsd"; //br.readLine();
		
		XMLValidator xv= new XMLValidator();
		boolean successFlag = xv.validateXMLAgainstSchema(xmlPath, xsdPath);
		if(successFlag){
			System.out.println("\nXML successfully validated against specified schema");
		}
		else{
			System.out.println("\nXML validation against specified schema failed.");
		}
	}    //main()
	
	public boolean validateXMLAgainstSchema(String XMLFilePath, String XSDFilePath){
		try{
			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = schemaFactory.newSchema(new File(XSDFilePath));
			Validator schemaValidator= schema.newValidator();
			schemaValidator.validate(new StreamSource(new File(XMLFilePath)));
		}
		catch(SAXException e){
			System.out.println("SAXException encountered while validating " +
					"the xml against specified XSD"+e);
			return false;
		}
		catch(IOException e){
			System.out.println("IException encountered while validating " +
					"the xml against specified XSD"+e);
			System.exit(1);
		}
		catch(IllegalArgumentException e){
			System.out.println("XML not validated against specified XSD "+e);
			return false;
		}
		catch(Exception e){
			System.out.println("Exception occurred while validating the XML against given XSD "+e);
			System.exit(1);
		}
		return true;
	}    //validateXMLAgainstSchema()
}    //XMLValidator


/*
 * Reference:
 * http://www.journaldev.com/895/how-to-validate-xml-against-xsd-in-java
*/
