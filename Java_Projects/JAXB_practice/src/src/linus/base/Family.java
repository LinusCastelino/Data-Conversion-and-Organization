package src.linus.base;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"numOfFamilyMembers","familyName","familyMembers"})
public class Family {
	private int id;
	private String familyName;
	private int numOfFamilyMembers;
	private List<FamilyMember> familyMembers;
	
	@XmlAttribute(name = "ID",required=true)
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id= id;
	}
	
	@XmlElement(name="FamilyName")
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	@XmlElement
	public int getNumOfFamilyMembers() {
		if(familyMembers == null){
			numOfFamilyMembers = 0;
		}
		else{
			numOfFamilyMembers = familyMembers.size();;
		}
		return numOfFamilyMembers;
	}
	public void setNumOfFamilyMembers(int numOfFamilyMembers) {
		this.numOfFamilyMembers = numOfFamilyMembers;
	}
	
	@XmlElementWrapper(name="FamilyMembers")
	@XmlElement(name="familyMember")
	public List<FamilyMember> getFamilyMembers() {
		if(familyMembers == null){
			familyMembers = new ArrayList<FamilyMember>();
		}
		return familyMembers;
	}
	public void setFamilyMembers(ArrayList<FamilyMember> familyMembers) {
		this.familyMembers = familyMembers;
	}

}    //Family
