package team.nwsh.nwshospital.DirectorSystem;

import java.sql.ResultSet;
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
import team.nwsh.nwshospital.MySQLConnect;

public class MedicineAlarm {
    static String String_CheckStorgesql = null;   
    static MySQLConnect db = null;  
    static ResultSet Result_Storge = null;    
    
    
public static void main(String[] args) {
		// TODO Auto-generated method stub
    	String_CheckStorgesql= "SELECT MED_NAME,MED_STORGE FROM MEDICINE";	
    	 // �˴���дҪִ�е����
        db = new MySQLConnect(String_CheckStorgesql);							// �½�һ�����ݿ�����
        try {
        	Result_Storge = db.pst.executeQuery();					// ִ��sql��䣬�õ������
			while (Result_Storge.next()) {
                String String_CheckName = Result_Storge.getString("MED_NAME");
                int Int_CheckStorge = Result_Storge.getInt("MED_STORGE");// ��ȡִ��sql��������������ΪACC_NAME��һ��ֵ	
                if (Int_CheckStorge<=20)//�ж�ҩƷ��治��20ʱ����
                { 
                //System.out.println(String_CheckName);
                //System.out.println(Result_Storge.getInt("MED_STORGE"));//����̨���
                JOptionPane.showMessageDialog(null, String_CheckName+"��治�㣬����Ϊ"+Int_CheckStorge, "����", JOptionPane.ERROR_MESSAGE); //��������
                	}
                }
			Result_Storge.close();		// �ر�ִ�е��������
	        db.close();			// �ر����ݿ�����
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

/*���´�һ�����������治���ҩƷ �������� 
 * �ڵ��� ���ǵ����ܻ���ֶ��ҩƷ��治�� ����ͨ��������Jlistչʾ
public void Warning(String[] arg0) {
	setTitle("\u8B66\u544A\uFF01");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 302, 201);
	JPanel contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel WarningLabel = new JLabel("\u8B66\u544A\uFF01");
	WarningLabel.setFont(new Font("����", Font.BOLD, 20));
	WarningLabel.setBounds(111, 10, 63, 34);
	contentPane.add(WarningLabel);
	
	JLabel WarningMarkedWords = new JLabel("\u5728\u5E93\u5B58\u4E2D\u4F59\u91CF\u53EA\u6709");
	WarningMarkedWords.setFont(new Font("����", Font.BOLD, 20));
	WarningMarkedWords.setBounds(69, 72, 192, 40);
	contentPane.add(WarningMarkedWords);
	
	JLabel WarningMedicineName = new JLabel("New label");
	WarningMedicineName.setBounds(10, 87, 54, 15);
	contentPane.add(WarningMedicineName);
	
	JLabel WarningMedicineStorge = new JLabel("New label");
	WarningMedicineStorge.setBounds(244, 87, 54, 15);
	contentPane.add(WarningMedicineStorge);
}
private void setTitle(String string) {
	// TODO �Զ����ɵķ������
	
}
private void setContentPane(JPanel contentPane) {
	// TODO �Զ����ɵķ������
	
}
private void setBounds(int i, int j, int k, int l) {
	// TODO �Զ����ɵķ������
	
}
private void setDefaultCloseOperation(int exitOnClose) {
	// TODO �Զ����ɵķ������
	
}
MedicineAlarm (String n,int a) {

}*/
    }