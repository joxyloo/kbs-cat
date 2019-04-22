
import java.util.ArrayList;

//database
public class allDisease {

	private Disease disease1, disease2, disease3, disease4, disease5, disease6, disease7, disease8, disease9, disease10,
			disease11, disease12, disease13, disease14, disease15, disease16, disease17, disease18, disease19,
			disease20, disease21, disease22, disease23, disease24;
	private ArrayList<Disease> dList = new ArrayList<Disease>();
	private Disease[] dArray = new Disease[26];

	// Disease next;
	// int currentDIndex = -1;

	public allDisease() {

		Stack d1 = new Stack();
		d1.push("Brownish Coloured Tongue");
		d1.push("Mouth Ulcers");
		d1.push("Bloody Urine");
		d1.push("Bad Breath");
		d1.push("Constipation");
		d1.push("Frequent Urinating");
		d1.push("Excessive Thirst");
		d1.push("Weakness");
		d1.push("Loss of Appetite");
		d1.push("Diarrhea");
		d1.push("Weight Loss");
		d1.push("Vomiting");

		disease1 = new Disease("Chronic Kidney Disease", d1);

		Stack d2 = new Stack();
		d2.push("Straining to Urinate");
		d2.push("Redness Skin");
		d2.push("Inflammation of Eyes");
		d2.push("Sneezing");
		d2.push("Discharge from Eyes");
		d2.push("Hair Loss");
		d2.push("Frequent Urinating");
		d2.push("Loss of Appetite");
		d2.push("Diarrhea");
		d2.push("Weight Loss");

		disease2 = new Disease("Feline Immunodeficiency Virus (FIV)", d2);

		Stack d3 = new Stack();
		d3.push("Fragile Skin");
		d3.push("Curled Ear Tips");
		d3.push("Swollen Abdomen");
		d3.push("Increase in Appetite");
		d3.push("Hair Loss");
		d3.push("Excessive Thirst");
		d3.push("Weakness");
		d3.push("Diarrhea");
		d3.push("Weight Loss");
		d3.push("Vomiting");

		disease3 = new Disease("Cushing’s Disease", d3);

		Stack d4 = new Stack();
		d4.push("Snoring");
		d4.push("Wheezing");
		d4.push("Swollen Paws");
		d4.push("Itchy");
		d4.push("Watery Eyes");
		d4.push("Sneezing");
		d4.push("Coughing");
		d4.push("Diarrhea");
		d4.push("Vomiting");

		disease4 = new Disease("Allergy", d4);

		Stack d5 = new Stack();
		d5.push("Runny Nose");
		d5.push("Watery Eyes");
		d5.push("Sneezing");
		d5.push("Discharge from Eyes");
		d5.push("Coughing");
		d5.push("Difficulty Breathing");
		d5.push("Loss of Appetite");

		disease5 = new Disease("Upper Respiratory Tract", d5);

		Stack d6 = new Stack();
		d6.push("Unexplained Bleeding from Body");
		d6.push("Coughing");
		d6.push("Difficulty Breathing");
		d6.push("Loss of Appetite");
		d6.push("Diarrhea");
		d6.push("Weight Loss");
		d6.push("Vomiting");

		disease6 = new Disease("Cancer", d6);

		Stack d7 = new Stack();
		d7.push("Difficulty Walking");
		d7.push("Seizure");
		d7.push("Coughing");
		d7.push("Loss of Appetite");
		d7.push("Weight Loss");
		d7.push("Vomiting");

		disease7 = new Disease("Heartworm", d7);

		Stack d8 = new Stack();
		d8.push("Watery Stool");
		d8.push("Bloody Stool");
		d8.push("Loss of Appetite");
		d8.push("Diarrhea");
		d8.push("Vomiting");

		disease8 = new Disease("Campylobacteriosis", d8);

		Stack d9 = new Stack();
		d9.push("Swollen Abdomen");
		d9.push("Difficulty Breathing");
		d9.push("Weakness");
		d9.push("Weight Loss");
		d9.push("Vomiting");

		disease9 = new Disease("Cardiomyopathy", d9);

		Stack d10 = new Stack();
		d10.push("Difficulty Breathing");
		d10.push("Weakness");
		d10.push("Weight Loss");
		d10.push("Vomiting");

		disease10 = new Disease("Abdominal Distension", d10);

		Stack d11 = new Stack();
		d11.push("Bloody Stool");
		d11.push("Constipation");
		d11.push("Diarrhea");
		d11.push("Vomiting");

		disease11 = new Disease("Lymphoma", d11);

		Stack d12 = new Stack();
		d12.push("Increase in Appetite");
		d12.push("Excessive Thirst");
		d12.push("Weight Loss");
		d12.push("Vomiting");

		disease12 = new Disease("Diabetes", d12);

		Stack d13 = new Stack();
		d13.push("Loss of Appetite");
		d13.push("Diarrhea");
		d13.push("Weight Loss");
		d13.push("Vomiting");

		disease13 = new Disease("Inflammatory Bowel Disease", d13);

		Stack d14 = new Stack();
		d14.push("Excessive Thirst");
		d14.push("Diarrhea");
		d14.push("Weight Loss");
		d14.push("Vomiting");

		disease14 = new Disease("Hyperthyroidism", d14);

		Stack d15 = new Stack();
		d15.push("Clouded Cornea");
		d15.push("Sensitive to Light");
		d15.push("Inflammation of Eyes");
		d15.push("Discharge from Eyes");

		disease15 = new Disease("Corneal Ulcer", d15);

		Stack d16 = new Stack();
		d16.push("Dandruff");
		d16.push("Redness Skin");
		d16.push("Itchy");
		d16.push("Hair Loss");

		disease16 = new Disease("Ringworm", d16);

		Stack d17 = new Stack();
		d17.push("Loss of Appetite");
		d17.push("Weight Loss");
		d17.push("Vomiting");

		disease17 = new Disease("Pancreatitis", d17);

		Stack d18 = new Stack();
		d18.push("Dark Stool");
		d18.push("Constipation");
		d18.push("Diarrhea");

		disease18 = new Disease("Hookworm Infection", d18);

		Stack d19 = new Stack();
		d19.push("Drooling");
		d19.push("Bad Breath");
		d19.push("Vomiting");

		disease19 = new Disease("Tooth Pathology", d19);

		Stack d20 = new Stack();
		d20.push("Urinating Small Amount");
		d20.push("Bloody Urine");
		d20.push("Frequent Urinating");

		disease20 = new Disease("Feline Lower Urinary Tract Disease", d20);

		Stack d21 = new Stack();
		d21.push("Diarrhea");
		d21.push("Weight Loss");
		d21.push("Vomiting");

		disease21 = new Disease("Giardiasis", d21);

		Stack d22 = new Stack();
		d22.push("Head Tilting");
		d22.push("Drooling");

		disease22 = new Disease("Rabies", d22);

		Stack d23 = new Stack();
		d23.push("Seizure");
		d23.push("Weight Loss");

		disease23 = new Disease("Kidney Failure", d23);

		Stack d24 = new Stack();
		d24.push("Mouth Bleeding");
		d24.push("Bad Breath");

		disease24 = new Disease("Gingivitis", d24);

		dList.add(disease1);
		dList.add(disease2);
		dList.add(disease3);
		dList.add(disease4);
		dList.add(disease5);
		dList.add(disease6);
		dList.add(disease7);
		dList.add(disease8);
		dList.add(disease9);
		dList.add(disease10);
		dList.add(disease11);
		dList.add(disease12);
		dList.add(disease13);
		dList.add(disease14);
		dList.add(disease15);
		dList.add(disease16);
		dList.add(disease17);
		dList.add(disease18);
		dList.add(disease19);
		dList.add(disease20);
		dList.add(disease21);
		dList.add(disease22);
		dList.add(disease23);
		dList.add(disease24);

		dArray[0] = disease1;
		dArray[1] = disease2;
		dArray[2] = disease3;
		dArray[3] = disease4;
		dArray[4] = disease5;
		dArray[5] = disease6;
		dArray[6] = disease7;
		dArray[7] = disease8;
		dArray[8] = disease9;
		dArray[9] = disease10;
		dArray[10] = disease11;
		dArray[11] = disease12;
		dArray[12] = disease13;
		dArray[13] = disease14;
		dArray[14] = disease15;
		dArray[15] = disease16;
		dArray[16] = disease17;
		dArray[17] = disease18;
		dArray[18] = disease19;
		dArray[19] = disease20;
		dArray[20] = disease21;
		dArray[21] = disease22;
		dArray[22] = disease23;
		dArray[23] = disease24;

	}

	public ArrayList<Disease> getAllDisease() {
		return dList;
	}

	public Disease[] getDiseaseArray() {
		return dArray;
	}

	// public Disease getNextDisease(){
	//
	// currentDIndex++;
	//
	// if (currentDIndex >= dList.size()) {
	// currentDIndex = 0;
	// }
	//
	// return (next = dList.get(currentDIndex));
	//
	// }
}
