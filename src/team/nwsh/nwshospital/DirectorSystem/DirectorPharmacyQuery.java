package team.nwsh.nwshospital.DirectorSystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import team.nwsh.nwshospital.MySQLConnect;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class DirectorPharmacyQuery extends JFrame{
	Vector RowData,ColumnNames;
    JTable jt=null;
    JScrollPane jsp=null;
    static String sql = null;  
    static MySQLConnect db = null;  
    static ResultSet ret = null; 
     public static void main(String[] args) throws SQLException
     {
    	 DirectorPharmacyQuery DirectorPharmacyQuery=new DirectorPharmacyQuery();
     }


public DirectorPharmacyQuery() throws SQLException
{
	setTitle("\u836F\u623F\u60C5\u51B5\u67E5\u8BE2");
	ColumnNames= new Vector();
	ColumnNames.add("���");
	ColumnNames.add("ҩƷ��");
	ColumnNames.add("����");
	ColumnNames.add("���");
	//������ͷ
	
	RowData=new Vector(); 
	sql = "SELECT * FROM MEDICINE";						// �˴���дҪִ�е����
    db = new MySQLConnect(sql);							// �½�һ�����ݿ�����
    try {
		ret = db.pst.executeQuery();					// ִ��sql��䣬�õ������
		while (ret.next()) {
            Vector hang=new Vector();
        	hang.add(ret.getInt(1));
        	hang.add(ret.getString(2));
        	hang.add(ret.getInt(3));
        	hang.add(ret.getInt(4));
        	RowData.add(hang);
        }
        ret.close();		// �ر�ִ�е��������
        db.close();			// �ر����ݿ�����
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	jt=new JTable(RowData,ColumnNames);
	jsp=new JScrollPane(jt);
	this.add(jsp);
	this.setBounds(12, 76, 380, 560);
	this.setVisible(true);
	}

}