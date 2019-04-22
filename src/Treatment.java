import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Treatment extends JFrame implements ActionListener {
	private JPanel panel;
	private JTextArea txt_cure;
	private JLabel lbl_disease;
	private Cure[] treatment = new Cure[24];
	private Disease disease;
	private JButton btnHow;
	private JTextArea txtrWeGotDisease;
	private JTextArea txtSymptoms;
	private ArrayList<String> symptomList;
	private JButton btnClose;
	private String True[] = new String[50];
	
	public Treatment(Disease disease, String truearr[]) {
		this.True = truearr;
		this.disease = disease;
		this.symptomList =  disease.getSymptoms().getAllSymptom();
		Container pane = getContentPane();
		pane.setBackground(Color.white);
		getContentPane().setLayout(null);
		
		
		panel = new JPanel();
		panel.setBounds(0, 0, 577, 489);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txt_cure = new JTextArea();
		txt_cure.setEditable(false);
		txt_cure.setLineWrap(true);
		txt_cure.setBounds(0, 92, 577, 312);
		panel.add(txt_cure);
		
		lbl_disease = new JLabel("Here are our suggestion for the treatment to "+ disease.getDiseaseName() +":");
		lbl_disease.setBounds(22, 41, 527, 16);
		panel.add(lbl_disease);
		

		Icon icon = UIManager.getIcon("OptionPane.questionIcon");
		btnHow = new JButton("How do i get this?", icon);
		btnHow.setRequestFocusEnabled(false);
		btnHow.setBounds(10, 424, 299, 51);
		panel.add(btnHow);
		
		btnClose = new JButton("Close");
		btnClose.setBounds(431, 426, 118, 47);
		panel.add(btnClose);
		btnClose.addActionListener(this);
		btnHow.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Treatment");
		setSize(589, 545);
		setLocationRelativeTo(null);
		setVisible(true);
		//Disease 1
		String[] cure0 = {"-Medications to lower blood pressure. (e.g., propranolol, atenolol, or enalapril)\n\n" +
				"-Nutritional supplements that reduce BUN (Azodyl) and phosphorus levels. (Epakitin)\n\n" +
				"-Omega 3 fatty acids to protect the kidneys.\n\n" +
				"-Medications to treat or prevent stomach ulcers. (e.g., ranitidine, famotidine, omeprazole, sucralfate)\n\n" +
				"-Potassium supplements.\n\n" +
				"-Medications decrease blood phosphorous levels. (e.g., calcium carbonate)\n\n" +
				"-Calcitriol to slow the progression of chronic renal failure.\n\n" +
				"-Medications to treat anemia. (e.g., erythropoietin or darbepoetin)\n\n" +
				"-Anti-nausea medications. (e.g., maropitant or ondansetron)"};
		treatment[0]= new Cure("Chronic Kidney Disease", cure0);
		
		//Disease 2
		String[] cure1 = {"-Medication for secondary infections.\n\n"+
				"-Healthy, palatable diet to encourage good nutrition.\n\n"+
				"-Fluid and electrolyte replacement therapy.\n\n"+
				"-Anti-inflammatory drugs.\n\n" +
				"-Immune-enhancing drugs.\n\n"+
				"-Parasite control."};
		treatment[1]= new Cure("Feline Immunodeficiency Virus (FIV)", cure1);
		
		//Disease 3
		String[] cure2 = {"-The treatment options for cats with Cushing’s disease are fairly limited.\n\n"};
		treatment[2]= new Cure("Cushing’s Disease", cure2);
		
		//Disease 4
		String[] cure3 = {"-antihistamines, such as diphenhydramine (Benadryl), loratadine (Claritin) or cetirizine (Zyrtec).\n\n"+
				"-corticosteroid nasal sprays such as fluticasone (Flonase) or mometasone (Nasonex).\n\n"+
				"-over-the-counter decongestant sprays.\n\n"+
				"-cromolyn sodium, which prevents the release of immune system chemicals and may reduce symptoms.\n\n"+
				"-leukotriene inhibitors, such as montelukast. (Singulair)\n\n" + 
				"-allergy shots known as immunotherapy. (a series of shots that desensitize you to an allergen)"};
		treatment[3]= new Cure("Allergy", cure3);
		
		//Disease 5
		String[] cure4 = {"-Antibiotics.\n\n"};
		treatment[4]= new Cure("Upper Respiratory Tract", cure4);
		
		//Disease 6
		String[] cure5 = {"-Surgery- removing lump or bump. \n\n"+
				"-Chemotherapy. \n\n"+
				"-Radiation therapy."};
		treatment[5]= new Cure("Cancer", cure5);
		
		//Disease 7
		String[] cure6 = {"-Unfortunately, there is no approved drug therapy for heartworm infection in cats."};
		treatment[6]= new Cure("Heartworm", cure6);
		
		//Disease 8
		String[] cure7 = {"-Antibiotics to treat the infection.\n\n" + 
				"-Fluids to replace lost fluids.\n\n" + 
				"-A bland diet to rest the stomach while your cat recovers.\n\n" + 
				"-Isolate the affected cats from other pets to reduce transmission."};
		treatment[7]= new Cure("Campylobacteriosis", cure7);
		
		//Disease 9
		String[] cure8 = {"-Diltiazim to slow the heart rate, treat irregular heart beats, and possibly reduce the enlargement in the left ventricle.\n\n" + 
				"-Beta blockers to slow the heart rate, correct irregular heart beats, and control blockage of the blood flow. These are not used if the cat has congestive heart failure.\n\n" + 
				"-Ace inhibitors, in cases with congestive heart failure, to improve the flow through the ventricle.\n\n" + 
				"-Aspirin to decrease risk of blood clots.\n\n" + 
				"-Warfarin to prevent blood clotting.\n\n" + 
				"-Furosemide (diuretic) to remove excess fluid from the body.\n\n" + 
				"-Spironolactone (a diuretic used sometimes in conjunction with furosemide) for cats with congestive heart failure.\n\n" + 
				"-Nitroglycerin ointment, to improve flow by dilating (opening) the ventricle and arteries."};
		treatment[8]= new Cure("Cardiomyopathy", cure8);
		
		//Disease 10
		String[] cure9 = {"-Anti-inflammatory drug.\n\n" + 
				"-Antibiotics.\n\n" + 
				"-Plasma transfusion.\n\n" + 
				"-Surgery."};
		treatment[9]= new Cure("Pancreatitis", cure9);
		
		//Disease 11
		String[] cure10 = {"-Abdominocentesis.\n\n" + 
				"-Diuretics.\n\n" + 
				"-Surgical removal.\n\n" + 
				"-Antibiotics."};
		treatment[10]= new Cure("Abdominal Distension", cure10);
			
		//Disease 12
		String[] cure11 = {"-Chemotherapy.\n\n" + 
				"-Surgery."};
		treatment[11]= new Cure("Lymphoma", cure11);
		
		//Disease 13
		String[] cure12 = {"-Insulin injections.\n\n" + 
				"-Oral hypoglycemic medications.\n\n" + 
				"-Diet."};
		treatment[12]= new Cure("Diabetes", cure12);
		
		//Disease 14
		String[] cure13 = {"-Dietary therapy.\n\n" + 
				"-Corticosteroids."};
		treatment[13]= new Cure("Inflammatory Bowel Disease", cure13);
		
		//Disease 15
		String[] cure14 = {"-Antithyroid medication.\n\n" + 
				"-Surgical removal of thyroid gland.\n\n" + 
				"-Radioactive iodine therapy."};
		treatment[14]= new Cure("Hyperthyroidism", cure14);
		
		//Disease 16
		String[] cure15 = {"-Antibiotic eye ointment.\n\n" + 
				"-Optical pain medication.\n\n" + 
				"-Elizabethan collar to prevent rubbing or scratching.\n\n" + 
				"-Chronic ulcer surgery."};
		treatment[15]= new Cure("Corneal Ulcer", cure15);
		
		//Disease 17
		String[] cure16 = {"-Ointment on affected skin.\n\n" + 
				"-Antifungal drug."};
		treatment[16]= new Cure("Ringworm", cure16);
		
		//Disease 18
		String[] cure17 = {"-Deworming medication.\n\n" + 
				"-Nutritional and iron supplements."};
		treatment[17]= new Cure("Hookworm Infection", cure17);

		//Disease 19
		String[] cure18 = {"-Cleaning cat’s teeth."};
		treatment[18]= new Cure("Tooth Pathology", cure18);
		
		//Disease 20
		String[] cure19 = {"-Medication.\n\n" + 
				"-Diet.\n\n" + 
				"-Stress relief."};
		treatment[19]= new Cure("Feline Lower Urinary Tract Disease", cure19);
		
		//Disease 21
		String[] cure20 = {"-Medical drug."};
		treatment[20]= new Cure("Giardiasis", cure20);
		
		//Disease 22
		String[] cure21 = {"-No treatment available, please keep your cat quarantined."};
		treatment[21]= new Cure("Rabies", cure21);

		//Disease 23
		String[] cure22 = {"-Drugs to enhance urine production.\n\n" + 
				"-Therapeutic diet.\n\n" + 
				"-Management of electrolyte abnormalities.\n\n" + 
				"-Fluid therapy.\n\n" + 
				"-Correction of anemia.\n\n" + 
				"-Medication for high blood pressure, vomiting or gastrointestinal problems.\n\n" + 
				"-Dialysis.\n\n" + 
				"-Kidney transplant."};
		treatment[22]= new Cure("Kidney Failure", cure22);
		
		//Disease 24
		String[] cure23 = {"-Cleaning cat’s teeth.\n\n" + 
				"-Antibiotics.\n\n" + 
				"-Scaling of inflammation-inducing plaque from the teeth.\n\n" + 
				"-Immunosuppressive drug."};
		treatment[23]= new Cure("Gingivitis", cure23);
		
		
		//this will detect what disease and cure to display into the txtarea
		for(int i =0; i<24; i++) {
			if(disease.getDiseaseName().equals(treatment[i].getDiseaseName())){
				System.out.println("Here are our suggestion for the treatment to "+ disease.getDiseaseName() +":"+
						treatment[i].getCureOnly());
				txt_cure.setText(treatment[i].getCureOnly());
			}
		}
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(btnHow == obj) {
			this.setSize(new Dimension(830, 535));
			txtrWeGotDisease = new JTextArea();
			txtrWeGotDisease.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtrWeGotDisease.setText("We got "+ disease.getDiseaseName() +" because you met the criteria of the following symptoms:");
			txtrWeGotDisease.setBounds(591, 13, 205, 50);
			txtrWeGotDisease.setLineWrap(true);
			panel.add(txtrWeGotDisease);
			
			txtSymptoms = new JTextArea();
			txtSymptoms.setBounds(590, 84, 205, 320);
			JScrollPane scroll1 = new JScrollPane(txtSymptoms, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);;
			scroll1.setBounds(590, 84, 205, 320);
			panel.add(scroll1);
			txtSymptoms.setCaretPosition(0);
			String theList = "";
			
			for(String temp: symptomList) {
				theList = temp+"\n"+theList;
			}
			theList = "Symptoms of the " +disease.getDiseaseName()+":\n"+theList;
			theList += "\nAnd your cat have the following symptoms:\n";
			int truecount = 0;
			for (int n = 0; n < True.length; n++) {
				if (True[n] == null) {
					break;
				} else {
					truecount++;
				}
			}
			for(int j=0;j<truecount;j++){
				theList += True[j]+"\n";
			}
			txtSymptoms.setText(theList);
			txtSymptoms.setLineWrap(true);
			panel.setBounds(0,0, 809, 535);
		}
		if(btnClose == obj) {
			int n = JOptionPane.showConfirmDialog(this, "Thanks for using us. DO YOU WISH TO START A NEW DIAGNOSIS?", "Continue?", JOptionPane.YES_NO_OPTION);
			if(n==JOptionPane.YES_OPTION){
	        	new MainScreen();
	        	this.dispose();
        	}else{
	        	this.dispose();
        	}
		}
	}
}
