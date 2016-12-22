package team.nwsh.nwshospital.DirectorSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import team.nwsh.nwshospital.MySQLConnect;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class DirectorSystem extends JFrame {

	private JPanel DirectorMianMeau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {  
					DirectorSystem frame = new DirectorSystem();
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
	public DirectorSystem() {
		setTitle("\u9662\u957F\u67E5\u8BE2\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		DirectorMianMeau = new JPanel();
		DirectorMianMeau.setBorder(new EmptyBorder(5, 5, 5, 5));
		DirectorMianMeau.setLayout(new BorderLayout(0, 0));
		setContentPane(DirectorMianMeau);
		
		JPanel panel = new JPanel();
		DirectorMianMeau.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton PharmacyQuery = new JButton("\u836F\u623F\u60C5\u51B5\u67E5\u8BE2");
		PharmacyQuery.setFont(new Font("����", Font.BOLD, 20));
		PharmacyQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DirectorPharmacyQuery newJTablb = new DirectorPharmacyQuery();//ҳ����ת
			}
		});
		PharmacyQuery.setBounds(28, 121, 193, 78);
		panel.add(PharmacyQuery);
		
		JButton SectionQuery = new JButton("\u79D1\u5BA4\u60C5\u51B5\u67E5\u8BE2");
		SectionQuery.setFont(new Font("����", Font.BOLD, 20));
		SectionQuery.setBounds(28, 228, 193, 78);
		SectionQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DirectorSectionQuery newframe = new DirectorSectionQuery();//ҳ����ת
			newframe.setVisible(true);
			}
		});
		panel.add(SectionQuery);
		
		JButton DoctorQuery = new JButton("\u533B\u751F\u60C5\u51B5\u67E5\u8BE2");
		DoctorQuery.setFont(new Font("����", Font.BOLD, 20));
		DoctorQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DirectorDoctorQuery newframe = new DirectorDoctorQuery();//ҳ����ת
				newframe.setVisible(true);
			}
		});
		DoctorQuery.setBounds(28, 334, 193, 78);
		panel.add(DoctorQuery);
		
		JLabel MedicineAlarm = new JLabel("");
		MedicineAlarm.setBounds(284, 31, 443, 78);
		panel.add(MedicineAlarm);
		
		JButton CreatReport = new JButton("\u751F\u6210\u62A5\u544A");
		CreatReport.setFont(new Font("����", Font.BOLD, 20));
		CreatReport.setBounds(455, 121, 158, 78);
		panel.add(CreatReport);
		
		JButton PublishReport = new JButton("\u5BFC\u51FA\u62A5\u544A");
		PublishReport.setFont(new Font("����", Font.BOLD, 20));
		PublishReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		PublishReport.setBounds(455, 228, 158, 78);
		panel.add(PublishReport);
		
		JButton MainMeauQuitButton = new JButton("\u9000\u51FA");
		MainMeauQuitButton.setFont(new Font("����", Font.BOLD, 20));
		MainMeauQuitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				System.exit(0);
			}
		});
		MainMeauQuitButton.setBounds(455, 334, 158, 78);
		panel.add(MainMeauQuitButton);
		
		JLabel MainMeauTitle = new JLabel("\u9662\u957F\u67E5\u8BE2\u7CFB\u7EDF");
		MainMeauTitle.setFont(new Font("����", Font.BOLD, 30));
		MainMeauTitle.setBounds(28, 22, 378, 68);
		panel.add(MainMeauTitle);
		
		JLabel label = new JLabel("\u67E5\u8BE2\u7EDF\u8BA1\u836F\u623F\u5404\u4E2A\u836F\u54C1\u7684\u5269\u4F59\u5E93\u5B58\u91CF");
		label.setFont(new Font("����", Font.PLAIN, 12));
		label.setBounds(231, 142, 214, 41);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u67E5\u8BE2\u7EDF\u8BA1\u6BCF\u4E2A\u79D1\u5BA4\u7684\u6302\u53F7\u91CF\u548C\u603B\u91D1\u989D");
		label_1.setFont(new Font("����", Font.PLAIN, 12));
		label_1.setBounds(231, 249, 214, 41);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u67E5\u8BE2\u7EDF\u8BA1\u6BCF\u4E2A\u533B\u751F\u7684\u5C31\u8BCA\u6570\u91CF\u548C\u91D1\u989D");
		label_2.setFont(new Font("����", Font.PLAIN, 12));
		label_2.setBounds(231, 359, 193, 32);
		panel.add(label_2);
		
		MedicineAlarm();
	}
	
	
	//����һ������ͨ�������ݿ���ҩƷ�������о���
	static private void MedicineAlarm(){
	    String String_CheckStorgesql = null;   
	    MySQLConnect db = null;  
	    ResultSet Result_Storge = null;  
    	String_CheckStorgesql= "SELECT MED_NAME,MED_STORGE FROM MEDICINE";	
       db = new MySQLConnect(String_CheckStorgesql);							// �½�һ�����ݿ�����
       try {
       	Result_Storge = db.pst.executeQuery();					// ִ��sql��䣬�õ������
			while (Result_Storge.next()) {
               String String_CheckName = Result_Storge.getString("MED_NAME");
               int Int_CheckStorge = Result_Storge.getInt("MED_STORGE");// ��ȡִ��sql��������������ΪACC_NAME��һ��ֵ	
               if (Int_CheckStorge<=20)//�ж�ҩƷ��治��20ʱ����
               { 
               System.out.println(String_CheckName);
               System.out.println(Result_Storge.getInt("MED_STORGE"));//����̨���
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

}
