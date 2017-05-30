package src.linus.base;

public class FamilyFactory {

	public Family createFamily(){
		return new Family();
	}
	
	public Families createFamiliesContainer(){
		return new Families();
	}
	
	public FamilyMember createFamilyMember(){
		return new FamilyMember();
	}
	
	public FamilyMember createFamilyMember(String name, int age, String sex, boolean isHOF, String relationToHOF){
		return new FamilyMember(name, age, sex, isHOF, relationToHOF); 
	}
}    //FamilyFactory
