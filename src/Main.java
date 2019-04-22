import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class Main extends JFrame implements ActionListener {

	private JLabel lblQuestion, lblPicture;
	private JButton btnYes = new JButton("YES");
	private JButton btnNo = new JButton("NO");
	boolean finalDisease = false;
	String testing = "";
	String True[] = new String[50];
	String False[] = new String[50];
	private int TrueLength = 0;
	int counttrue = 0;
	int countfalse = 0;
	private allDisease aa = new allDisease();
	private int count;
	private Disease[] dArray = aa.getDiseaseArray();
	private MainScreen prevScreen;
	private JButton btnWhy;
	private Disease whyDisease;
	private ArrayList<String> symptomList;

	public Main(MainScreen prevScreen) {
		this.prevScreen = prevScreen;
		
		Container pane = getContentPane();
		pane.setBackground(Color.white);
		pane.setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Expert System");
		setSize(692, 513);
		setLocationRelativeTo(null);
		setVisible(true);

		JPanel p1 = new JPanel();
		p1.setLayout(null);
		lblQuestion = new JLabel("Hi "+prevScreen.username+ ". Does your cat has Vomiting?");
		lblQuestion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQuestion.setBounds(66, 310, 589, 39);
		p1.add(lblQuestion);
		btnYes.setBounds(58, 377, 165, 52);
		p1.add(btnYes);
		btnNo.setBounds(263, 374, 165, 58);
		p1.add(btnNo);

		pane.add(p1);

		btnWhy = new JButton("Why?");
		btnWhy.setBounds(470, 377, 145, 52);
		p1.add(btnWhy);
		btnWhy.addActionListener(this);

		lblPicture = new JLabel();
		lblPicture.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		lblPicture.setBounds(102, 10, 468, 284);
		ImageIcon icon = new ImageIcon(getClass().getResource("/pic/Vomiting.jpg"));
		Image image = icon.getImage();
		Image newimage = image.getScaledInstance(lblPicture.getWidth(), lblPicture.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon img = new ImageIcon(newimage);
		lblPicture.setIcon(img);
		p1.add(lblPicture);

		count = 0;

		btnYes.addActionListener(this);
		btnNo.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		Object obj = e.getSource();
		int currentDIndex = 0;
		int noindex = 0;

		if (obj == btnYes) {

			for (int i = 0; i < 24; i++) {
				int acount = i;
				Disease s = dArray[acount];
				this.symptomList =  s.getSymptoms().getAllSymptom();
				if (s.isFinalDisease == false && s.isPossibleDisease == true) {
					// System.out.println(s.getDiseaseName());
					Stack ss = s.getSymptoms();

					for (int k = 0; k < ss.size(); k++) {
						boolean flag = true;
						for (int j = 0; j < True.length; j++) {
							String a = ss.peek().toString();
							if (a.equals(True[j])) {
								ss.pop();
							}
						}
						for (int j = 0; j < False.length; j++) {

							for (int l = 0; l < 24; l++) {

								for (int m = 0; m < dArray[l].getSymptoms().size(); m++) {

									String a = dArray[l].getSymptoms().peek().toString();
									if (a.equals(True[j])) {
										dArray[l].getSymptoms().pop();
									}
									if (a.equals(False[j])) {
										dArray[l].isPossibleDisease = false;
										break;
									}
								}
							}

						}
						if (flag == false)
							break;
						// for (int j = 0; j < False.length; j++) {

						String a = ss.pop().toString();
						System.out.println("Throw into true array: " + s.getDiseaseName() + " " + a);
						True[counttrue] = a;
						counttrue++;
						if (!ss.isEmpty()) {
							lblQuestion.setText(
									"Hi "+ prevScreen.username + ". Does your cat has " + ss.peek().toString() + " ?");

							ImageIcon icon = new ImageIcon(
									getClass().getResource("/pic/" + ss.peek().toString() + ".jpg"));
							Image image = icon.getImage();
							Image newimage = image.getScaledInstance(lblPicture.getWidth(), lblPicture.getHeight(),
									Image.SCALE_SMOOTH);
							ImageIcon img = new ImageIcon(newimage);
							lblPicture.setIcon(img);

							whyDisease = s;

						}

						if (ss.isEmpty()) {
							int TrueLength = 0;
							for (int n = 0; n < True.length; n++) {
								if (True[n] == null) {
									break;
								} else {
									TrueLength++;
								}
							}
							if (s.getSymptoms().originalSize() == TrueLength) {
								System.out.println("Your cat have " + s.getDiseaseName());
								finalDisease = true;
								JOptionPane.showMessageDialog(this, "Your cat have " + s.getDiseaseName());
								new Treatment(s, True);
								this.dispose();
							}
							if (s.getSymptoms().originalSize() != TrueLength) {
								JOptionPane.showMessageDialog(this, "We cant find the disease for you");
								String truesympton="";
								for(int n =0; n< TrueLength; n++){
									truesympton = True[n]+"\n"+truesympton;
								}
								String dieseasesympton="";
								for(String temp: symptomList) {
									dieseasesympton += temp+"\n";
								}
								JOptionPane.showMessageDialog(this, "The closest disease we diagnose is "+s.getDiseaseName()+":\n"+dieseasesympton+"\n"+ "Compare to the sympton you have:\n"+truesympton);
								int reply = JOptionPane.showConfirmDialog(this, "Do you wish to see the treatment for the closest disease we found?", "Proceed?", JOptionPane.YES_NO_OPTION);
						        if (reply == JOptionPane.YES_OPTION) {
						          new Treatment(s, True);
						          prevScreen.dispose();
						          this.dispose();
						        }
						        else {
						        	int n = JOptionPane.showConfirmDialog(this, "Thanks for using us. DO YOU WISH TO START A NEW DIAGNOSIS?", "Continue?", JOptionPane.YES_NO_OPTION);
						        	if(n==JOptionPane.YES_OPTION){
							        	new MainScreen();
							        	prevScreen.dispose();
							        	this.dispose();
						        	}else{
							        	prevScreen.dispose();
							        	this.dispose();
						        	}
						        }
							}
						}
						for (int j = 0; j < False.length; j++) {

							for (int l = 0; l < 24; l++) {

								for (int m = 0; m < dArray[l].getSymptoms().size(); m++) {

									String b = dArray[l].getSymptoms().peek().toString();
									if (b.equals(True[j])) {
										dArray[l].getSymptoms().pop();
									}
									if (b.equals(False[j])) {
										dArray[l].isPossibleDisease = false;
										break;
									}
								}
							}

						}
						for (int j = 0; j < True.length; j++) {
							if (dArray[j].isPossibleDisease == true && !dArray[j].getSymptoms().isEmpty()) {

								lblQuestion.setText("Hi "+ prevScreen.username + ". Does your cat has " + dArray[j].getSymptoms().peek().toString() + " ?");

								ImageIcon icon = new ImageIcon(getClass()
										.getResource("/pic/" + dArray[j].getSymptoms().peek().toString() + ".jpg"));
								Image image = icon.getImage();
								Image newimage = image.getScaledInstance(lblPicture.getWidth(), lblPicture.getHeight(),
										Image.SCALE_SMOOTH);
								ImageIcon img = new ImageIcon(newimage);
								lblPicture.setIcon(img);

								whyDisease = dArray[j];
								break;

							}
						}

						break;

					}
					break;

				}

			}
		}

		if (obj == btnNo) {
			int checkNoDisease = 0;
			// int real = Integer.parseInt(lblQuestion.getText().substring(1, 2));
			for (int i = 0; i < 24; i++) {
				int acount = i;
				Disease s = dArray[acount];
				boolean flag = true;

				if (s.isFinalDisease == false && s.isPossibleDisease == true) {

					Stack ss = s.getSymptoms();

					for (int k = 0; k < s.getSymptoms().size(); k++) {

						if (s.isFinalDisease == false && s.isPossibleDisease == true) {

							for (int j = 0; j < False.length; j++) {

								for (int l = 0; l < 24; l++) {

									for (int m = 0; m < dArray[l].getSymptoms().size(); m++) {

										String a = dArray[l].getSymptoms().peek().toString();
										if (a.equals(True[j])) {
											dArray[l].getSymptoms().pop();
										}
										if (a.equals(False[j])) {
											dArray[l].isPossibleDisease = false;
											break;
										}
									}
								}

							}

							String b = s.getSymptoms().pop().toString();

							System.out.println("Throw into false array: " + s.getDiseaseName() + " " + b);
							False[countfalse] = b;
							countfalse++;
							s.isPossibleDisease = false;
							dArray[acount].isPossibleDisease = false;
							count = 1;
							for (int j = 0; j < False.length; j++) {

								for (int l = 0; l < 24; l++) {

									for (int m = 0; m < dArray[l].getSymptoms().size(); m++) {

										String a = dArray[l].getSymptoms().peek().toString();
										if (a.equals(True[j])) {
											dArray[l].getSymptoms().pop();
										}
										if (a.equals(False[j])) {
											dArray[l].isPossibleDisease = false;
											break;
										}
									}
								}

							}
							int TrueLength = 0;
							for (int n = 0; n < True.length; n++) {
								if (True[n] == null) {
									break;
								} else {
									TrueLength++;
								}
							}
							for (int j = 0; j < 24; j++) {

								if (dArray[j].getSymptoms().isEmpty()) {
									if (dArray[j].getSymptoms().originalSize() == TrueLength
											&& dArray[j].isPossibleDisease == true) {

										System.out.println("Your cat have " + dArray[j].getDiseaseName() + " "
												+ dArray[j].getSymptoms().originalSize() + " " + TrueLength + " "
												+ s.getDiseaseName());
										finalDisease = true;
										JOptionPane.showMessageDialog(this,
												"Your cat have " + dArray[j].getDiseaseName());
										new Treatment(dArray[j], True);
										this.dispose();
										break;
									} else if (dArray[j].getSymptoms().originalSize() != TrueLength
											&& dArray[j].isPossibleDisease == true) {
										JOptionPane.showMessageDialog(this,
												"We cant find the disease for you");
										System.out.println(TrueLength + " " + dArray[j].getSymptoms().originalSize()
												+ " " + s.getDiseaseName());
										String truesympton="";
										for(int n =0; n< TrueLength; n++){
											truesympton = True[n]+"\n"+truesympton;
										}
										String dieseasesympton="";
										for(String temp: symptomList) {
											dieseasesympton += temp+"\n";
										}
										
										JOptionPane.showMessageDialog(this, "The closest disease we diagnose is "+s.getDiseaseName()+":\n"+dieseasesympton+"\n"+ "Compare to the sympton you have:\n"+truesympton);
										int reply = JOptionPane.showConfirmDialog(this, "Do you wish to see the treatment for the closest disease we found?", "Proceed?", JOptionPane.YES_NO_OPTION);
								        if (reply == JOptionPane.YES_OPTION) {
								          new Treatment(s, True);
								          this.dispose();
								        }
								        else {
								        	int n = JOptionPane.showConfirmDialog(this, "Thanks for using us. DO YOU WISH TO START A NEW DIAGNOSIS?", "Continue?", JOptionPane.YES_NO_OPTION);
								        	if(n==JOptionPane.YES_OPTION){
									        	new MainScreen();
									        	this.dispose();
									        	prevScreen.dispose();
								        	}else{
									        	this.dispose();
									        	prevScreen.dispose();
								        	}
								        }
									}else if(dArray[j].getSymptoms().originalSize() != TrueLength
											&& dArray[j].isPossibleDisease == false) {
										JOptionPane.showMessageDialog(this,
												"We cant find the disease for you");
										int n = JOptionPane.showConfirmDialog(this, "Thanks for using us. DO YOU WISH TO START A NEW DIAGNOSIS?", "Continue?", JOptionPane.YES_NO_OPTION);
							        	if(n==JOptionPane.YES_OPTION){
								        	new MainScreen();
								        	this.dispose();
								        	prevScreen.dispose();
							        	}else{
								        	this.dispose();
								        	prevScreen.dispose();
							        	}
									}
									

								} else if (dArray[j].isPossibleDisease == true && !dArray[j].getSymptoms().isEmpty()) {

									// change the question after the input
									lblQuestion.setText("Hi "+ prevScreen.username + ". Does your cat has " + dArray[j].getSymptoms().peek().toString() + " ?");

									// change the image according to the question
									ImageIcon icon = new ImageIcon(getClass()
											.getResource("/pic/" + dArray[j].getSymptoms().peek().toString() + ".jpg"));
									Image image = icon.getImage();
									Image newimage = image.getScaledInstance(lblPicture.getWidth(),
											lblPicture.getHeight(), Image.SCALE_SMOOTH);
									ImageIcon img = new ImageIcon(newimage);
									lblPicture.setIcon(img);

									whyDisease = dArray[j];
									break;

								}
							}
							break;
						}

					}
					break;

				}

			}
			int checkgotDisease = 0;
			for (int j = 0; j < 24; j++) {
				if (dArray[j].isPossibleDisease == false) {
					checkNoDisease++;
				}
				if(True[j]!=null) {
					checkgotDisease++;
				}
			}
			if (checkNoDisease == 24 && checkgotDisease==0) {
				System.out.println("sorry we cannot diagnose the disease");
				JOptionPane.showMessageDialog(this, "Sorry we cannot diagnose any related disease "+checkNoDisease);
				int n = JOptionPane.showConfirmDialog(this, "Thanks for using us. DO YOU WISH TO START A NEW DIAGNOSIS?", "Continue?", JOptionPane.YES_NO_OPTION);
				if(n==JOptionPane.YES_OPTION){
		        	new MainScreen();
		        	prevScreen.dispose();
		        	this.dispose();
	        	}else{
		        	prevScreen.dispose();
		        	this.dispose();
	        	}
			}
		}

		if (btnWhy == obj) {
			int truecount = 0;
			for (int n = 0; n < True.length; n++) {
				if (True[n] == null) {
					break;
				} else {
					truecount++;
				}
			}
			if (whyDisease == null) {
				String truesympton="";
				for(int i =0; i< truecount; i++){
					truesympton += True[i]+"\n";

				}
				truesympton+="you have no any symptom yet.";
				JOptionPane.showMessageDialog(this, "Based on symptom you have, We suspect that your cat have Chronic kidney disease:\n"+truesympton,
						"Why?", JOptionPane.INFORMATION_MESSAGE);

			} else {
				String truesympton="";
				for(int i =0; i< truecount; i++){
					truesympton += True[i]+"\n";
				}
				JOptionPane.showMessageDialog(this,
						"Based on symptoms you have, We suspect that your cat have " + whyDisease.getDiseaseName()+":\n"
						+ truesympton ,	"Why?", JOptionPane.INFORMATION_MESSAGE);
			}
		}

	}
}
