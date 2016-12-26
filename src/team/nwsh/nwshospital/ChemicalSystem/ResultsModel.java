package team.nwsh.nwshospital.ChemicalSystem;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.*;

import team.nwsh.nwshospital.MySQLConnect;

public class ResultsModel extends AbstractTableModel {
	
	
		

	Vector RowData,ColumnNames;
    static String sql = null;  
    static MySQLConnect db = null;  
    static ResultSet ret = null; 
    
 
    //ͨ�����ݵ�sql������������ģ��
    public ResultsModel(String sql)
    {
    	//������ͷ  
    	ColumnNames= new Vector();
		ColumnNames.add("����");
		ColumnNames.add("����ҩƷ��");
		RowData=new Vector(); 						// �˴���дҪִ�е����
	    db = new MySQLConnect(sql);							// �½�һ�����ݿ�����
	    try {
			ret = db.pst.executeQuery();					// ִ��sql��䣬�õ������
			while (ret.next()) {
	            Vector hang=new Vector();
	        	hang.add(ret.getString(1));
	        	hang.add(ret.getString(2));
	        	RowData.add(hang);
	        }
	        ret.close();		// �ر�ִ�е��������
	        db.close();			// �ر����ݿ�����
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    //�������캯����ʼ������ģ��
    public ResultsModel()
    {
		ColumnNames= new Vector();
		ColumnNames.add("����");
		ColumnNames.add("����ҩƷ��");
		//������ͷ
		
		
		
		RowData=new Vector(); 
		sql = "SELECT (SELECT PAT_NAME FROM PATIENTS WHERE PATIENTS.PAT_ID=RESULTS.PAT_ID),RES_MED FROM RESULTS ";						// �˴���дҪִ�е����
	    db = new MySQLConnect(sql);							// �½�һ�����ݿ�����
	    try {
			ret = db.pst.executeQuery();// ִ��sql��䣬�õ������
			
			while (ret.next()) {
	            Vector hang=new Vector();
	        	hang.add(ret.getString(1));
	        	hang.add(ret.getString(2));	        	
	        	RowData.add(hang);
	        }
	        ret.close();		// �ر�ִ�е��������
	        db.close();			// �ر����ݿ�����
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

	//�õ����ж�����
	public int getColumnCount() {
		
		// TODO �Զ����ɵķ������
		return this.ColumnNames.size();
	}

	//�õ����ж�����
	public int getRowCount() {
		// TODO �Զ����ɵķ������
		return this.RowData.size();
	}

	@Override
	public String getColumnName(int arg0) {
		// TODO �Զ����ɵķ������
		return (String)this.ColumnNames.get(arg0);
	}


	//�õ�ĳ��ĳ�е�����
	public Object getValueAt(int row, int column) {
		// TODO �Զ����ɵķ������
		return ((Vector)this.RowData.get(row)).get(column);
	}

}
