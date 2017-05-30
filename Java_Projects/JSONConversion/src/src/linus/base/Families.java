package src.linus.base;

import java.util.ArrayList;
import java.util.List;

public class Families {
	private List<Family> family;

	public List<Family> getFamily() {
		if(family == null){
			family = new ArrayList<Family>();
		}
		return family;
	}

	public void setFamily(List<Family> family) {
		this.family = family;
	}
	
}    //Families
