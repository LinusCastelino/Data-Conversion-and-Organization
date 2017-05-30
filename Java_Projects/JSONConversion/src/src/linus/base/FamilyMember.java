package src.linus.base;

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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public boolean isHOF() {
		return isHOF;
	}
	public void setHOF(boolean isHOF) {
		this.isHOF = isHOF;
	}
	
	public String getRelationToHOF(){
		return relationToHOF;
	}
	public void setRelationToHOF(String relation){
		relationToHOF= relation;
	}
}    //FamilyMember
