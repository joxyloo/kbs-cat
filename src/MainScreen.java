import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;

public class MainScreen extends JFrame implements ActionListener{
	public String username;
	private int usernameAnswer;
	private JButton btnCancel;
	private JButton btnNext;
	private JButton btnNewDiagnosis;
	private JLabel lbl_userName;
	boolean check=false;
	JPanel panel;
	
	public MainScreen() {
		getContentPane().setLayout(null);
		setTitle("Expert System");
		setLocationRelativeTo(null);
		setVisible(true);
		setSize(807,714);
		setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 785, 658);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("===== Cat Expert System =====");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(243, 34, 297, 32);
		panel.add(lblNewLabel);
		
		btnNext = new JButton("Next");
		btnNext.setBounds(648, 604, 122, 38);
		btnNext.addActionListener(this);
		panel.add(btnNext);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(15, 604, 122, 38);
		btnCancel.addActionListener(this);
		panel.add(btnCancel);
		
		btnNewDiagnosis = new JButton("New Diagnosis");
		btnNewDiagnosis.setFont(new Font("Comic Sans MS", Font.PLAIN, 23));
		btnNewDiagnosis.setBounds(287, 484, 212, 107);
		panel.add(btnNewDiagnosis);
		btnNewDiagnosis.addActionListener(this);
		
		lbl_userName = new JLabel("New label");
		lbl_userName.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lbl_userName.setBounds(154, 517, 564, 44);
		panel.add(lbl_userName);
		lbl_userName.hide();
		check=false;
		
		JLabel lbl_pic = new JLabel("");
		lbl_pic.setBounds(191, 90, 434, 378);
		ImageIcon iconimg = new ImageIcon(getClass().getResource("/pic/catDoctor.jpg"));
		Image image = iconimg.getImage();
		Image newimage = image.getScaledInstance(lbl_pic.getWidth(), lbl_pic.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon img = new ImageIcon(newimage);
		panel.add(lbl_pic);
		lbl_pic.setIcon(img);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == btnNewDiagnosis) {
			btnNewDiagnosis.hide();
			username="a";
			username = JOptionPane.showInputDialog(this, "Please input your name:");
			while(username == null || username.equals("")) {
				JOptionPane.showMessageDialog(panel, "There is no name, please input your name");
				username = JOptionPane.showInputDialog(this, "Please input your name:");
			}
			lbl_userName.show();
			check=true;
			lbl_userName.setText("Welcome!! "+username+", Click Next to run the diagnosis!!");
			
		}
		if(obj == btnCancel) {
			System.out.println("Thank you for using us...");
			this.dispose();
		}
		if(obj == btnNext && check==true) {
			System.out.println("The questioning begins....");
			this.setVisible(false);
			new Main(this);
		}
		if(obj == btnNext && check == false) {
			JOptionPane.showMessageDialog(panel, "CLICK Button 'NEW DIAGNOSIS' before continue!");
		}
	}
	public static void main(String[] args) {

		new MainScreen();
		
	}
}
