package src.linus.jaxb;

import java.io.File;
import java.math.BigInteger;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import generated.AssetDetails;
import generated.AssetDetails.OwnerDetails;
import generated.ObjectFactory;

public class AssetDetails_ObjectToXML {

	public void convertObjectToXML(AssetDetails ad){
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(AssetDetails.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			//To validate against a schema
			//SchemaFactory schemaFac = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			//Schema schema = schemaFac.newSchema(new File("D:\\PracticePrograms\\JAXB_practice\\assetDetails.xsd"));
			//marshaller.setSchema(schema);
			
			marshaller.marshal(ad, System.out);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}    //convertObjectToXML
	
	public static void main(String arg[]){
		ObjectFactory of = new ObjectFactory();
		
		AssetDetails ad = of.createAssetDetails();
		ad.setAssetId("456");
		ad.setOwner("Linus Castelino");
		
		OwnerDetails od = of.createAssetDetailsOwnerDetails();
		od.setName("Linus Castelino");
		od.setAge(new BigInteger("23"));
		od.setCompany("TCS");
		od.setSex("Male");
		
		ad.setOwnerDetails(od);
		
		AssetDetails_ObjectToXML o2xml = new AssetDetails_ObjectToXML();
		
		o2xml.convertObjectToXML(ad);
	}    //main()

}    //AssetDetails_ObjectToXML
