package src.linus.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import src.linus.base.Families;
import src.linus.base.Family;
import src.linus.base.FamilyFactory;

public class Families_ObjectToXML {
	
	public void convertObjectToXML(Families families){
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(Families.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			//marshaller.marshal(families, new File("D:\\Families_output.xml"));
			marshaller.marshal(families, System.out);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}    //convertObjectToXML
	
	public static void main(String ...a){
		FamilyFactory ff = new FamilyFactory();
		
		Families families = ff.createFamiliesContainer();
		
		Family family1 = ff.createFamily();
		families.getFamily().add(family1);
		family1.setId(1);
		family1.setFamilyName("Castelino");
		family1.getFamilyMembers().add(ff.createFamilyMember("Linus", 23, "Male", false, "Son"));
		family1.getFamilyMembers().add(ff.createFamilyMember("Lionel", 17, "Male", false, "Son"));
		family1.getFamilyMembers().add(ff.createFamilyMember("Pramila", 48, "Female", false, "Wife"));
		family1.getFamilyMembers().add(ff.createFamilyMember("Louis", 56, "Male", true, "Self"));
		
		Family family2 = ff.createFamily();
		families.getFamily().add(family2);
		family2.setId(2);
		family2.setFamilyName("Andrade");
		family2.getFamilyMembers().add(ff.createFamilyMember("Jason", 35, "Male", true, "Self"));
		family2.getFamilyMembers().add(ff.createFamilyMember("Veena", 30, "Female", false, "Wife"));
		family2.getFamilyMembers().add(ff.createFamilyMember("Evin",8,"Male",false,"Son"));
		
		Families_ObjectToXML fox = new Families_ObjectToXML();
		fox.convertObjectToXML(families);
	}
}
