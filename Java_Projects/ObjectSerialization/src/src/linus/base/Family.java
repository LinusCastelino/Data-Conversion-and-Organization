package src.linus.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Family implements Serializable{

	private int id;
	private String familyName;
	private int numOfFamilyMembers;
	private List<FamilyMember> familyMembers;
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id= id;
	}
	
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
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
