package src.linus.ser.convert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;

import src.linus.base.Families;
import src.linus.base.Family;
import src.linus.base.FamilyMember;

public class SerToObjectConverter {
	public Families deserializeObject(FileInputStream fis){
		try{
			ObjectInputStream ois = new ObjectInputStream(fis);
			Families families = (Families)ois.readObject();
			return families;
		}
		catch(Exception e){
			System.out.println(e);
			return null;
		}
	}    //deserializeObject()
	
	public static void main(String arg[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter absolute path of .ser file :");
		String fInputStream = br.readLine();
		
		FileInputStream fis= new FileInputStream(fInputStream);
		
		SerToObjectConverter stoc = new SerToObjectConverter();
		Families families = stoc.deserializeObject(fis);
		
		if(families != null){
			for(Family family : families.getFamily()){
				System.out.println(family.getId());
				System.out.println(family.getFamilyName());
				System.out.println(family.getNumOfFamilyMembers());
				
				for(FamilyMember member : family.getFamilyMembers()){
					System.out.println(member.getName());
					System.out.println(member.getAge());
					System.out.println(member.getSex());
					System.out.println(member.getRelationToHOF());
					System.out.println("Head of Family : "+member.isHOF());
				}
			}
		}
	}    //main()
}    //SerToObject
