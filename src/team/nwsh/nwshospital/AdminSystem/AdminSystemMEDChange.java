package team.nwsh.nwshospital.AdminSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import team.nwsh.nwshospital.MySQLConnect;

import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AdminSystemMEDChange extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSystemMEDChange frame = new AdminSystemMEDChange();
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
	public AdminSystemMEDChange() {
		setTitle("\u4FEE\u6539\u836F\u54C1\u4FE1\u606F\u3002");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label_1 = new Label("\u836F\u54C1\u540D\uFF1A");
		label_1.setBounds(34, 32, 77, 25);
		contentPane.add(label_1);
		
		Label label_2 = new Label("\u836F\u54C1\u4EF7\u683C\uFF1A");
		label_2.setBounds(33, 61, 77, 25);
		contentPane.add(label_2);
		
		Label label_3 = new Label("\u836F\u54C1\u6570\u91CF\uFF1A");
		label_3.setBounds(34, 91, 77, 25);
		contentPane.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(177, 33, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(177, 64, 86, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(178, 96, 86, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton button = new JButton("\u4FDD\u5B58");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql="UPDATE MEDICINE SET MED_NAME=('"+textField_1.getText()+"') ,MED_PRICE = ('"+textField_2.getText()+"'),MED_STORGE = ('"+textField_3.getText()+"') WHERE MED_ID =('"+textField.getText()+"')";
				   MySQLConnect con=new MySQLConnect(sql);
				   int key=1;//����һ���м���������ж�������Ϣ�Ĵ��ڣ�����ɹ� �� ����ɹ�
				   try{
					if(textField.getText().equals("")||textField_1.getText().equals("")||textField_2.getText().equals("")||textField_3.getText().equals("")) 
				   {JOptionPane.showMessageDialog(null, "���ݲ���Ϊ��"); key=0;}	
				   if(key==1) { con.pst.executeUpdate();   JOptionPane.showMessageDialog(null, "����ɹ�");}
				   }catch(SQLException e1){
					   e1.printStackTrace();
				   }
			}
		});
		button.setBounds(302, 174, 113, 27);
		contentPane.add(button);
		
		Label label = new Label("\u836F\u54C1ID");
		label.setBounds(33, 127, 77, 25);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(178, 132, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
