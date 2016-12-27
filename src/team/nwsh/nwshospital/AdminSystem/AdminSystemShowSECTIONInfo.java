package team.nwsh.nwshospital.AdminSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import team.nwsh.nwshospital.MySQLConnect;
import team.nwsh.nwshospital.AdminSystem.SECTIONSModel;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import team.nwsh.nwshospital.MySQLConnect;

public class AdminSystemShowSECTIONInfo extends JFrame implements ActionListener  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
    JTable jt=null;
    JScrollPane jsp=null;
	JButton BtnNewButton = new JButton("��ѯ");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSystemShowSECTIONInfo frame = new AdminSystemShowSECTIONInfo();
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
	public AdminSystemShowSECTIONInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("�������˻���");
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		BtnNewButton.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		
		BtnNewButton.addActionListener(this);
		panel.add(BtnNewButton);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton_3 = new JButton("�޸�");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminSystemSectionChange newframe = new AdminSystemSectionChange();
				newframe.setVisible(true);
				
			}
		});
		btnNewButton_3.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		panel_1.add(btnNewButton_3);
		JButton btnNewButton_4 = new JButton("ɾ��");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="DELETE FROM SECTIONS WHERE SEC_NAME = ('"+textField.getText()+"')";
				MySQLConnect con=new MySQLConnect(sql);	
				int key=1;//����һ���м���������ж�������Ϣ�Ĵ��ڣ�����ɹ� �� ����ɹ�
				try{
					if(textField.getText().equals("")){
						JOptionPane.showMessageDialog(null, "���ݲ���Ϊ��"); key=0;}
					if(key==1){ con.pst.executeUpdate();   JOptionPane.showMessageDialog(null, "����ɹ�");}
					con.pst.executeUpdate();
				}catch(SQLException e1){
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		panel_1.add(btnNewButton_4);
		JButton btnNewButton_2 = new JButton("\u8FD4\u56DE");
		btnNewButton_2.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminSystem newframe = new AdminSystem();
				newframe.setVisible(true);
				
				dispose();
				//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		panel_1.add(btnNewButton_2);

		
		
		setTitle("\u79D1\u5BA4\u60C5\u51B5\u67E5\u8BE2");

        SECTIONSModel mm=new SECTIONSModel();
        jt=new JTable(mm);
		jsp=new JScrollPane(jt);
		getContentPane().add(jsp);
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
			String sql="select * from SECTIONS where SEC_NAME like'%"+name+"%'";
			SECTIONSModel mm=new SECTIONSModel(sql);
			jt.setModel(mm);
		}
	}
}


