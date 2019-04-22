

public class Cure {
	
	String name;
	String[] cure;

	public Cure(String n, String[] s){
		name = n;
		cure = s;
	}
	
	public String getDiseaseName(){
		return name;
	}
	
	public String[] getCures(){
		return cure;
	}
	public String getCureOnly(){
		return cure[0];
	}
}
