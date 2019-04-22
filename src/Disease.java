
public class Disease {
	
	String name;
	Stack symptoms;
	Boolean isFinalDisease, isPossibleDisease;

	public Disease(String n, Stack s){
		name = n;
		symptoms = s;
		isFinalDisease = false;
		isPossibleDisease = true;
	}
	
	public String getDiseaseName(){
		return name;
	}
	
	public Stack getSymptoms(){
		return symptoms;
	}
	
	
	
}
