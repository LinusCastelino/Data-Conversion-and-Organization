package src.linus.base;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"name","HOF","age","sex","relationToHOF"})
public class FamilyMember {
	private String name;
	private int age;
	private String sex;
	private boolean isHOF; //head of Family
	private String relationToHOF;
	
	public FamilyMember(){
		
	}
	
	public FamilyMember(String name, int age, String sex, boolean isHOF, String relationToHOF){
		this.name = name;
		this.age= age;
		this.sex=sex;
		this.isHOF=isHOF;
		this.relationToHOF=relationToHOF;
	}
	
	@XmlElement(name="MemberName")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@XmlElement
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@XmlElement(name="HeadOfFamily")
	public boolean isHOF() {
		return isHOF;
	}
	public void setHOF(boolean isHOF) {
		this.isHOF = isHOF;
	}
	
	@XmlElement
	public String getRelationToHOF(){
		return relationToHOF;
	}
	public void setRelationToHOF(String relation){
		relationToHOF= relation;
	}
}    //FamilyMember
