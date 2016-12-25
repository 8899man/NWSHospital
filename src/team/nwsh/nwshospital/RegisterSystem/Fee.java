package team.nwsh.nwshospital.RegisterSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import team.nwsh.nwshospital.MySQLConnect;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fee extends JFrame {
	
	static double F_SUM;
	static String F_SUM_STRING;   //ת��Ϊstring���͵�F_SUM
	static String F_ID;           //���֤��
	static String F_NAME;			//����
	static String F_MED;			//����RESULTS���ѯ����RES_MED ҩƷ�շ�
	static String [] F_MED_SPLIT;	//��F_MED�ָ
	static String F_ITEM;			//����RESULTS���ѯ����RES_ITEM ��Ŀ�շ�
	static String [] F_ITEM_SPLIT;	//��F_ITEM�ָ���
	
	private JPanel contentPane;
	private JTable table;
	private static JTable table_MED;
	private static JTable table_ITEM;
	
	/**
	 * To LiuYeBian:
	 * ����MedicineTable()��������д�����캯�����޸ģ���Ҫ��RegisterSystem��¼��
	 * ����170��181��������µ���������
	 * ���⣬����183��212ҩƷ���շ���Ŀ��ѯ�����������¼Ϊ�յ��жϣ���ֹ��ɷ����в�ѯ����(����ɡ�)
	 * From Liu Yummy
	 */
	public static void MedicineTable() {
		// ҩƷ�б�
		
		// ����SPLIT��ȡ����������Ҫ��ѯ��WHERE���ֵ�SQL���
		int i = 0;
		String String_SQL_MED_ID_GROUP = "";
		while(i < F_MED_SPLIT.length) {
			
			String_SQL_MED_ID_GROUP = String_SQL_MED_ID_GROUP + F_MED_SPLIT[i];
			i = i + 1;
			if(i != F_MED_SPLIT.length) {
				String_SQL_MED_ID_GROUP = String_SQL_MED_ID_GROUP + " OR MED_ID = ";
			}
			
		}
		
	    String String_SQL_MED_NAME = "SELECT MED_ID, MED_NAME, MED_PRICE " +
									 	  "FROM MEDICINE " + 
									 	  "WHERE MED_ID = " + String_SQL_MED_ID_GROUP;
									 	  
		MySQLConnect MySQLConnect_MED_NAME = new MySQLConnect(String_SQL_MED_NAME);
		ResultSet RS_MED_NAME;
		Vector RowData_MED_NAME, ColumnNames_MED_NAME;
		ColumnNames_MED_NAME= new Vector();
		ColumnNames_MED_NAME.add("");
		ColumnNames_MED_NAME.add("");
		ColumnNames_MED_NAME.add("");
		// ������ͷ
		
		RowData_MED_NAME=new Vector(); 
		boolean INT_Found_MED_NAME = false;
	    try {
	    	RS_MED_NAME = MySQLConnect_MED_NAME.pst.executeQuery();
	    	if(RS_MED_NAME.next()) {
	    		INT_Found_MED_NAME = true;
	    		Vector hang_MED=new Vector();
	    		hang_MED.add(RS_MED_NAME.getString("MED_ID"));
	    		hang_MED.add(RS_MED_NAME.getString("MED_NAME"));
	        	hang_MED.add(RS_MED_NAME.getString("MED_PRICE"));
	        	RowData_MED_NAME.add(hang_MED);
				while (RS_MED_NAME.next()) {
		            hang_MED=new Vector();
		            hang_MED.add(RS_MED_NAME.getString("MED_ID"));
		            hang_MED.add(RS_MED_NAME.getString("MED_NAME"));
		            hang_MED.add(RS_MED_NAME.getString("MED_PRICE"));
		        	RowData_MED_NAME.add(hang_MED);
		        }
				RS_MED_NAME.close();
		        MySQLConnect_MED_NAME.close();
	    	}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		table_MED=new JTable() {
			// ���ñ������ݲ����޸�
			public boolean isCellEditable(int row, int column) { 
			    return false;
			}
		};
		
	    // ���������ɵġ������ݼ��ϡ��͡������ݼ��ϡ���Ϊ��������һ���µ� ���ģ��
		DefaultTableModel model_table_MED = new DefaultTableModel(RowData_MED_NAME, ColumnNames_MED_NAME);
		table_MED.setModel(model_table_MED);		// �����ģ�����Ϊ�����ɵ�ģ��ģ��
	
		table_MED.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_MED.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		table_MED.setRowHeight(20);
		
		if(INT_Found_MED_NAME) {
			// START ���� table_MED ���ݾ���
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
			tcr.setHorizontalAlignment(SwingConstants.CENTER);// �����Ͼ�����һ��
			table_MED.setDefaultRenderer(Object.class, tcr);
			// END ���� table_MED ���ݾ���
		}
		// END ��һ����� ҩƷ�շѱ��		
	}
	
	
	public static void ItemTable() {
		// �շ���Ŀ�б�
		
		// ����SPLIT��ȡ����������Ҫ��ѯ��WHERE���ֵ�SQL���
		int i = 0;
		String String_SQL_ITEM_ID_GROUP = "";
		while(i < F_ITEM_SPLIT.length) {
			
			String_SQL_ITEM_ID_GROUP = String_SQL_ITEM_ID_GROUP + F_ITEM_SPLIT[i];
			i = i + 1;
			if(i != F_ITEM_SPLIT.length) {
				String_SQL_ITEM_ID_GROUP = String_SQL_ITEM_ID_GROUP + " OR ITEM_ID = ";
			}
			
		}
		
	    String String_SQL_ITEM_NAME = "SELECT ITEM_ID, ITEM_NAME, ITEM_PRICE " +
									 	  "FROM ITEMS " + 
									 	  "WHERE ITEM_ID = " + String_SQL_ITEM_ID_GROUP;
									 	  
		MySQLConnect MySQLConnect_ITEM_NAME = new MySQLConnect(String_SQL_ITEM_NAME);
		ResultSet RS_ITEM_NAME;
		Vector RowData_ITEM_NAME, ColumnNames_ITEM_NAME;
		ColumnNames_ITEM_NAME= new Vector();
		ColumnNames_ITEM_NAME.add("");
		ColumnNames_ITEM_NAME.add("");
		ColumnNames_ITEM_NAME.add("");
		// ������ͷ
		
		RowData_ITEM_NAME=new Vector(); 
		boolean INT_Found_ITEM_NAME = false;
	    try {
	    	RS_ITEM_NAME = MySQLConnect_ITEM_NAME.pst.executeQuery();
	    	if(RS_ITEM_NAME.next()) {
	    		INT_Found_ITEM_NAME = true;
	    		Vector hang_ITEM=new Vector();
	    		hang_ITEM.add(RS_ITEM_NAME.getString("ITEM_ID"));
	    		hang_ITEM.add(RS_ITEM_NAME.getString("ITEM_NAME"));
	        	hang_ITEM.add(RS_ITEM_NAME.getString("ITEM_PRICE"));
	        	RowData_ITEM_NAME.add(hang_ITEM);
				while (RS_ITEM_NAME.next()) {
		            hang_ITEM=new Vector();
		            hang_ITEM.add(RS_ITEM_NAME.getString("ITEM_ID"));
		            hang_ITEM.add(RS_ITEM_NAME.getString("ITEM_NAME"));
		            hang_ITEM.add(RS_ITEM_NAME.getString("ITEM_PRICE"));
		        	RowData_ITEM_NAME.add(hang_ITEM);
		        }
				RS_ITEM_NAME.close();
		        MySQLConnect_ITEM_NAME.close();
	    	}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		table_ITEM=new JTable() {
			// ���ñ������ݲ����޸�
			public boolean isCellEditable(int row, int column) { 
			    return false;
			}
		};
		
	    // ���������ɵġ������ݼ��ϡ��͡������ݼ��ϡ���Ϊ��������һ���µ� ���ģ��
		DefaultTableModel model_table_ITEM = new DefaultTableModel(RowData_ITEM_NAME, ColumnNames_ITEM_NAME);
		table_ITEM.setModel(model_table_ITEM);		// �����ģ�����Ϊ�����ɵ�ģ��ģ��
	
		table_ITEM.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_ITEM.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		table_ITEM.setRowHeight(20);
		
		if(INT_Found_ITEM_NAME) {
			// START ���� table_ITEM ���ݾ���
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
			tcr.setHorizontalAlignment(SwingConstants.CENTER);// �����Ͼ�����һ��
			table_ITEM.setDefaultRenderer(Object.class, tcr);
			// END ���� table_ITEMITEM ���ݾ���
		}
		// END ��һ����� ҩƷ�շѱ��		
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fee frame = new Fee(null);	// *�޸�*�¹��캯��
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param PAT_ID 
	 */
	public Fee(String PAT_ID) {         // *�޸�*�¹��캯��
		F_ID=PAT_ID;					// *�޸�*�¹��캯�������������֤��ҳ������֤�Ŵ�����F_ID
		//��ѯ����
				String sql_name= "SELECT PAT_NAME FROM PATIENTS WHERE PAT_ID='"+F_ID+"'";
				MySQLConnect con_name= new MySQLConnect(sql_name);
				try {
					ResultSet ResultSet_NAME = con_name.pst.executeQuery();
					while(ResultSet_NAME.next()){
						F_NAME=ResultSet_NAME.getString("PAT_NAME");//�����ֲ�ѯ�����ֵ����F_NAME
					}
					ResultSet_NAME.close();
					con_name.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		//*�޸�*��ѯ���µ�RES_ID����ΪҪ��ȡ����һ��Result�����·���ѯ
		String SQL_RES_ID= "SELECT RESULTS_ID FROM PATIENTS WHERE PAT_ID = '" + F_ID + "' LIMIT 1" ;
		String RES_ID = null;
		MySQLConnect con_RES_ID= new MySQLConnect(SQL_RES_ID);
		try {
			ResultSet ResultSet_RES_ID = con_RES_ID.pst.executeQuery();
			ResultSet_RES_ID.next();
			RES_ID= String.valueOf(ResultSet_RES_ID.getInt("RESULTS_ID"));//�����µ�RES_ID��ѯ�����ֵ����RES_ID
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		//��ѯҩƷ�շѲ��Էǿս����ж�   			*�޸�*��RES_ID���в�ѯ
				String sql_med= "SELECT RES_MED FROM RESULTS WHERE RES_ID="+RES_ID;
				MySQLConnect con_med= new MySQLConnect(sql_med);
				try {
					ResultSet ResultSet_MED = con_med.pst.executeQuery();
						ResultSet_MED.next();
						if(ResultSet_MED.getString("RES_MED").compareTo("NULL")==0){
							JOptionPane.showMessageDialog(null, "ҩƷ�շѲ�ѯ���Ϊ��", "��ʾ", JOptionPane.ERROR_MESSAGE);
						}
						else{ 
							F_MED=ResultSet_MED.getString("RES_MED");//��ҩƷ��ѯ�����ֵ����F_MED
							F_MED_SPLIT=F_MED.split(",");				//split����
						}
							
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//JOptionPane.showMessageDialog(null, "ҩƷ�շѲ�ѯ���Ϊ��", "��ʾ", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
				
		   //��ѯ��Ŀ�շѲ��Էǿս����ж�
				String sql_ITEM= "SELECT RES_ITEMS FROM RESULTS WHERE RES_ID="+RES_ID;
				MySQLConnect con_ITEM= new MySQLConnect(sql_ITEM);
				try {
					ResultSet ResultSet_ITEM = con_ITEM.pst.executeQuery();
					ResultSet_ITEM.next();
					if(ResultSet_ITEM.getString("RES_ITEMS").compareTo("NULL")==0){
						JOptionPane.showMessageDialog(null, "��Ŀ�շѲ�ѯ���Ϊ��", "��ʾ", JOptionPane.ERROR_MESSAGE);
					}
					else {
						F_ITEM=ResultSet_ITEM.getString("RES_ITEMS");//���շ���Ŀ��ѯ�����ֵ����F_ITEM
						F_ITEM_SPLIT=F_ITEM.split(",");				//split����
					}
						
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			//��ѯ�շ��ܼ۲��Էǿս����ж�
				String sql_SUM= "SELECT RES_SUM FROM RESULTS WHERE RES_ID="+RES_ID;
				MySQLConnect con_SUM= new MySQLConnect(sql_SUM);
				try {
					ResultSet ResultSet_SUM = con_SUM.pst.executeQuery();
					ResultSet_SUM.next();
					//ResultSet_SUM.getDouble("RES_SUM");
					F_SUM=ResultSet_SUM.getDouble("RES_SUM");		//���շ��ܼ۲�ѯ�����ֵ����F_SUM
					F_SUM_STRING=Double.toString(F_SUM);			//���תstringΪF_SUM_STRING
					//JOptionPane.showMessageDialog(null, "��Ŀ�շѲ�ѯ���Ϊ��", "��ʾ", JOptionPane.ERROR_MESSAGE);
		
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 673);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(50, 10, 433, 56);
		contentPane.add(panel);
		
		JLabel label = new JLabel("\u6536\u8D39");
		label.setFont(new Font("΢���ź�", Font.BOLD, 16));
		label.setBounds(202, 20, 41, 36);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(50, 76, 433, 40);
		contentPane.add(panel_1);
		
		JLabel label_1 = new JLabel("\u59D3\u540D\uFF1A");
		label_1.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		label_1.setBounds(57, 10, 42, 30);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		label_2.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		label_2.setBounds(189, 10, 70, 30);
		panel_1.add(label_2);
		
		JLabel Label_NAME = new JLabel("");
		Label_NAME.setForeground(Color.BLACK);
		Label_NAME.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		Label_NAME.setBounds(109, 10, 70, 30);
		panel_1.add(Label_NAME);
		Label_NAME.setText(F_NAME);//��ʾ����
		
		JLabel Label_ID = new JLabel("");
		Label_ID.setForeground(Color.BLACK);
		Label_ID.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		Label_ID.setBounds(269, 10, 154, 30);
		panel_1.add(Label_ID);
		Label_ID.setText(F_ID);//��ʾ���֤��
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(50, 126, 433, 211);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_5 = new JLabel("\u836F\u7269\u6536\u8D39\uFF1A");
		label_5.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		label_5.setBounds(10, 10, 70, 30);
		panel_2.add(label_5);
		
		
		
		JLabel lblNewLabel = new JLabel("\u836F\u54C1\u7F16\u53F7");
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		lblNewLabel.setBounds(55, 39, 70, 30);
		panel_2.add(lblNewLabel);
		
		JLabel label_3 = new JLabel("\u836F\u54C1\u540D\u79F0");
		label_3.setFont(new Font("����", Font.PLAIN, 12));
		label_3.setBounds(195, 39, 60, 30);
		panel_2.add(label_3);
		
		JLabel label_6 = new JLabel("\u5355\u4EF7");
		label_6.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		label_6.setBounds(342, 39, 35, 30);
		panel_2.add(label_6);
		
		MedicineTable();
		// table_MED = new JTable();
		table_MED.setBounds(10, 68, 413, 133);
		panel_2.add(table_MED);
		
		JButton button = new JButton("\u5DF2\u6536\u8D39");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
//				for(int i=0;i<F_MED_SPLIT.length;i++){				//split��������
//					System.out.println(F_MED_SPLIT[i]);
//					System.out.println("����Ϊ��"+F_MED_SPLIT.length);
//				}
				
				//System.out.println(F_MED_SPLIT[0]);					//���Դ�ֵ����
				
				String state = "UPDATE STATE SET STA_TUS = 5 WHERE PAT_ID='" + F_ID + "'";
				MySQLConnect STATE = new MySQLConnect(state);
				try {
					STATE.pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "�շѳɹ�����ȥҩ��ȡҩ��", "��ʾ",JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "�շ�ʧ�ܣ�", "��ʾ", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				
			}
		});
		button.setBounds(159, 601, 93, 23);
		contentPane.add(button);
		button.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(50, 347, 433, 244);
		contentPane.add(panel_3);
		
		JLabel label_8 = new JLabel("\u9879\u76EE\u6536\u8D39\uFF1A");
		label_8.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		label_8.setBounds(10, 10, 70, 30);
		panel_3.add(label_8);
		

		
//		DefaultTableCellRenderer r2 = new DefaultTableCellRenderer();   
//		r2.setHorizontalAlignment(JLabel.CENTER);   
//		table_MED.setDefaultRenderer(Object.class,r2);
		
		
		JLabel label_7 = new JLabel("\u9879\u76EE\u7F16\u53F7");
		label_7.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		label_7.setBounds(55, 39, 70, 30);
		panel_3.add(label_7);
		
		JLabel label_9 = new JLabel("\u9879\u76EE\u540D\u79F0");
		label_9.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		label_9.setBounds(195, 39, 70, 30);
		panel_3.add(label_9);
		
		JLabel label_10 = new JLabel("\u5355\u4EF7");
		label_10.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		label_10.setBounds(342, 39, 70, 30);
		panel_3.add(label_10);
		
		ItemTable();
		//table_ITEM = new JTable();
		table_ITEM.setBounds(10, 68, 413, 133);
		panel_3.add(table_ITEM);
		
		JLabel label_4 = new JLabel("\u603B\u4EF7\uFF1A");
		label_4.setBounds(10, 211, 70, 30);
		panel_3.add(label_4);
		label_4.setFont(new Font("΢���ź�", Font.BOLD, 14));
		
		JLabel lblSum = new JLabel("<sum>");
		lblSum.setBounds(55, 211, 85, 30);
		panel_3.add(lblSum);
		lblSum.setFont(new Font("΢���ź�", Font.BOLD, 14));
		lblSum.setText(F_SUM_STRING);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegisterSystem back = new RegisterSystem();
				back.setResizable(false);
				back.setLocationRelativeTo(null);
				back.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				back.setVisible(true);
				dispose();
				
			}
		});
		button_1.setBounds(293, 601, 93, 23);
		contentPane.add(button_1);
		button_1.setFont(new Font("΢���ź�", Font.PLAIN, 12));
	}
}
