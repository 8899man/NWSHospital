package team.nwsh.nwshospital.DirectorSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import team.nwsh.nwshospital.MySQLConnect;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import team.nwsh.nwshospital.MySQLConnect;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class DirectorSectionQuery extends JFrame implements ActionListener  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
    JTable Smjt=null;
    JScrollPane Smjsp=null;
	JButton BtnNewButton = new JButton("\u67E5\u8BE2");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DirectorPharmacyQuery frame = new DirectorPharmacyQuery();
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
	public DirectorSectionQuery() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lbNewLabel = new JLabel("\u8BF7\u8F93\u5165\u79D1\u5BA4\u540D\uFF1A");
		panel.add(lbNewLabel);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		BtnNewButton.addActionListener(this);
		panel.add(BtnNewButton);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		JButton btnNewButton_2 = new JButton("\u9000\u51FA");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
				//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		
		JButton button = new JButton("\u751F\u6210\u997C\u72B6\u56FE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(button);
		panel_1.add(btnNewButton_2);

		
		
		setTitle("\u79D1\u5BA4\u60C5\u51B5\u67E5\u8BE2");

		SectionModel sm=new SectionModel();
		Smjt=new JTable(sm);
		Smjsp=new JScrollPane(Smjt);
		getContentPane().add(Smjsp);
		this.setBounds(12, 76, 380, 560);
		this.setVisible(true);

		}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO �Զ����ɵķ������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if(arg0.getSource()==BtnNewButton)//���
		{
			String name=this.textField.getText().trim();//��ȡtextfield��Ϣ
			//String sql="select * from MEDICINE where MED_NAME='"+name+"'";//ʵ��ģ����ѯ
			String sql="SELECT SECTIONS.SEC_ID, SECTIONS.SEC_NAME, (SELECT IFNULL(SUM(IFNULL(RESULTS.RES_SUM,0)),0) FROM RESULTS WHERE RESULTS.ACC_ID =  (SELECT ACC_ID FROM ACCOUNTS WHERE ACCOUNTS.SEC_ID = SECTIONS.SEC_ID )),(SELECT COUNT(*) AS SEC_NUMBER FROM RESULTS WHERE RESULTS.ACC_ID = (SELECT ACC_ID FROM ACCOUNTS WHERE ACCOUNTS.SEC_ID = SECTIONS.SEC_ID )) FROM SECTIONS WHERE CAST(SECTIONS.SEC_ID AS UNSIGNED INT)>=5000 AND SECTIONS.SEC_NAME LIKE '%"+name+"%'";
			SectionModel sm=new SectionModel(sql);
			Smjt.setModel(sm);
		}
	}
}


