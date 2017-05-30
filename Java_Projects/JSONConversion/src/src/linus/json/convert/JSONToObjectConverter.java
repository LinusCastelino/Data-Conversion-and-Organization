package src.linus.json.convert;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.codehaus.jackson.map.ObjectMapper;

import src.linus.base.Families;
import src.linus.base.Family;
import src.linus.base.FamilyMember;

public class JSONToObjectConverter {
	
	public Families convertJSONToObject(String jsonObject){
		Families families= null;
		try{
			ObjectMapper mapper = new ObjectMapper();
			families = mapper.readValue(jsonObject, Families.class);
		}
		catch(Exception e){
			System.out.println(e);
		}
		return families;
	}    //convertJSONToObject
	
	public static void main(String ...a) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter JSON object :");
		String jsonObject = br.readLine();
		
		JSONToObjectConverter jtoc = new JSONToObjectConverter();
		Families families = jtoc.convertJSONToObject(jsonObject);
		
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
	}
}    //JSONToObjectConverter

/*
 * {"family":[{"id":1,"familyName":"Castelino","numOfFamilyMembers":4,"familyMembers":[{"name":"Linus","age":23,"sex":"Male","relationToHOF":"Son","hof":false},{"name":"Lionel","age":17,"sex":"Male","relationToHOF":"Son","hof":false},{"name":"Pramila","age":48,"sex":"Female","relationToHOF":"Wife","hof":false},{"name":"Louis","age":56,"sex":"Male","relationToHOF":"Self","hof":true}]},{"id":2,"familyName":"Andrade","numOfFamilyMembers":3,"familyMembers":[{"name":"Jason","age":35,"sex":"Male","relationToHOF":"Self","hof":true},{"name":"Veena","age":30,"sex":"Female","relationToHOF":"Wife","hof":false},{"name":"Evin","age":8,"sex":"Male","relationToHOF":"Son","hof":false}]}]}
 */
