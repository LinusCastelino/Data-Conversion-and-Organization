package src.linus.base;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"family"})
public class Families {
	private List<Family> family;

	@XmlElement(name="Family")
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
