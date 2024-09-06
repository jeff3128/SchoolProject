package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Student;
import service.impl.StudentServiceImpl;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class StudentUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField chi;
	private JTextField eng;
	private JTextField id_qry;
	private JTextField id_del;
	private JTextField name_qry;
	private JTextField chi_qry;
	private JTextField eng_qry;
	

    private static StudentServiceImpl ssi=new StudentServiceImpl();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentUI frame = new StudentUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("學員成績管理系統");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel.setBounds(99, 10, 193, 24);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 255));
		panel.setBounds(10, 31, 353, 81);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("姓名:");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(23, 10, 39, 31);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("國文:");
		lblNewLabel_1_1.setBounds(23, 45, 39, 31);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("英文:");
		lblNewLabel_1_1_1.setBounds(129, 45, 39, 31);
		panel.add(lblNewLabel_1_1_1);
		
		name = new JTextField();
		name.setBounds(53, 14, 63, 21);
		panel.add(name);
		name.setColumns(10);
		
		chi = new JTextField();
		chi.setColumns(10);
		chi.setBounds(53, 51, 63, 21);
		panel.add(chi);
		
		eng = new JTextField();
		eng.setColumns(10);
		eng.setBounds(162, 50, 63, 21);
		panel.add(eng);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 128, 192));
		panel_1.setBounds(10, 116, 353, 190);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea output = new JTextArea();
		output.setBounds(10, 9, 333, 138);
		panel_1.add(output);
		
		
		
		JButton btnNewButton = new JButton("新增");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   	String Name=name.getText();
				int Chi=Integer.parseInt(chi.getText());
				int Eng=Integer.parseInt(eng.getText());
				ssi.addStudent(new Student(Name,Chi,Eng));
				name.setText("");
				chi.setText("");
				eng.setText("");
				
				List<Student> l=ssi.findAll();
				String show="";
				for(Student s:l) {
					show=show+"id:"+s.getId()+
							  "\t姓名:"+s.getName()+
							  "\t國文:"+s.getChi()+
							  "\t英文:"+s.getEng()+
							  "\t總分:"+s.getSum()+"\n";	
				}
				output.setText(show);
				
				
			}
		});
		btnNewButton.setBounds(265, 49, 78, 23);
		panel.add(btnNewButton);
		
	
		JButton btnNewButton_1 = new JButton("查詢");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<Student> l=ssi.findAll();
				String show="";
				for(Student s:l) {
					show=show+"id:"+s.getId()+
							  "\t姓名:"+s.getName()+
							  "\t國文:"+s.getChi()+
							  "\t英文:"+s.getEng()+
							  "\t總分:"+s.getSum()+"\n";	
				}
				output.setText(show);
				
			}
		});
		btnNewButton_1.setBounds(264, 157, 79, 23);
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 128));
		panel_2.setBounds(10, 316, 353, 146);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("   id:");
		lblNewLabel_1_1_2.setForeground(new Color(0, 255, 255));
		lblNewLabel_1_1_2.setBounds(10, 32, 39, 31);
		panel_2.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("  姓名:");
		lblNewLabel_1_1_2_1.setForeground(Color.CYAN);
		lblNewLabel_1_1_2_1.setBounds(10, 73, 39, 31);
		panel_2.add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("國文:");
		lblNewLabel_1_1_2_1_1.setForeground(Color.CYAN);
		lblNewLabel_1_1_2_1_1.setBounds(120, 73, 39, 31);
		panel_2.add(lblNewLabel_1_1_2_1_1);
		
		JLabel lblNewLabel_1_1_2_1_1_1 = new JLabel("英文:");
		lblNewLabel_1_1_2_1_1_1.setForeground(Color.CYAN);
		lblNewLabel_1_1_2_1_1_1.setBounds(224, 73, 39, 31);
		panel_2.add(lblNewLabel_1_1_2_1_1_1);
		
		id_qry = new JTextField();
		id_qry.setColumns(10);
		id_qry.setBounds(47, 37, 63, 21);
		panel_2.add(id_qry);
		
		name_qry = new JTextField();
		name_qry.setColumns(10);
		name_qry.setBounds(47, 78, 63, 21);
		panel_2.add(name_qry);
		
		chi_qry = new JTextField();
		chi_qry.setColumns(10);
		chi_qry.setBounds(151, 78, 63, 21);
		panel_2.add(chi_qry);
		
		eng_qry = new JTextField();
		eng_qry.setColumns(10);
		eng_qry.setBounds(265, 78, 78, 21);
		panel_2.add(eng_qry);
		
		JButton btnNewButton_1_1 = new JButton("修改");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int Id=Integer.parseInt(id_qry.getText());
				String Name=(name_qry.getText());
				int Chi=Integer.parseInt(chi_qry.getText());
				int Eng=Integer.parseInt(eng_qry.getText());
				
				ssi.updateStudent(Id, Name, Chi, Eng);
				List<Student> l=ssi.findAll();
				String show="";
				for(Student s:l) {
					show=show+"id:"+s.getId()+
							  "\t姓名:"+s.getName()+
							  "\t國文:"+s.getChi()+
							  "\t英文:"+s.getEng()+
							  "\t總分:"+s.getSum()+"\n";	
				}
				output.setText(show);
				
				
			}
		});
		btnNewButton_1_1.setBounds(265, 114, 78, 23);
		panel_2.add(btnNewButton_1_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 128, 64));
		panel_3.setBounds(10, 472, 353, 61);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_1_2_2 = new JLabel("   id:");
		lblNewLabel_1_1_2_2.setForeground(Color.CYAN);
		lblNewLabel_1_1_2_2.setBounds(29, 10, 39, 31);
		panel_3.add(lblNewLabel_1_1_2_2);
		
		id_del = new JTextField();
		id_del.setColumns(10);
		id_del.setBounds(58, 15, 63, 21);
		panel_3.add(id_del);
		
		JButton btnNewButton_1_1_1 = new JButton("刪除");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int Id=Integer.parseInt(id_del.getText());
			ssi.deleteStudent(Id);
			List<Student> l=ssi.findAll();
			String show="";
			for(Student s:l) {
				show=show+"id:"+s.getId()+
						  "\t姓名:"+s.getName()+
						  "\t國文:"+s.getChi()+
						  "\t英文:"+s.getEng()+
						  "\t總分:"+s.getSum()+"\n";	
			}
			output.setText(show);
			
			}
			
		});
		btnNewButton_1_1_1.setBounds(264, 24, 79, 23);
		panel_3.add(btnNewButton_1_1_1);
	}
}
