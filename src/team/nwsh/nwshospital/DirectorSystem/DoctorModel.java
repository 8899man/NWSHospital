/**
 * �����ҵ�һ��Doctor���ģ��
 */
package team.nwsh.nwshospital.DirectorSystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.*;

import team.nwsh.nwshospital.MySQLConnect;

public class DoctorModel extends AbstractTableModel {
	Vector RowData,ColumnNames;
    static String sql = null;  
    static MySQLConnect db = null;  
    static ResultSet ret = null; 
 
    //ͨ�����ݵ�sql������������ģ��
    public DoctorModel(String sql)
    {
    	//������ͷ  
    	ColumnNames= new Vector();	
		ColumnNames.add("���");
		ColumnNames.add("����");
		ColumnNames.add("����");
		ColumnNames.add("�����ܽ��");
		ColumnNames.add("�������˴�");
		RowData=new Vector(); 						// �˴���дҪִ�е����
	    db = new MySQLConnect(sql);							// �½�һ�����ݿ�����
	    try {
			ret = db.pst.executeQuery();					// ִ��sql��䣬�õ������
			while (ret.next()) {
	            Vector hang=new Vector();
	        	hang.add(ret.getString(1));
	        	hang.add(ret.getString(2));
	        	hang.add(ret.getString(3));
	        	hang.add(ret.getDouble(4));
	        	hang.add(ret.getInt(5));
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
    public DoctorModel()
    {
		ColumnNames= new Vector();
		ColumnNames.add("���");
		ColumnNames.add("����");
		ColumnNames.add("����");
		ColumnNames.add("�����ܽ��");
		ColumnNames.add("�������˴�");
		//������ͷ

		RowData=new Vector(); 
		sql = "SELECT ACC_ID,ACC_NAME,(SELECT SEC_NAME FROM SECTIONS WHERE SECTIONS.SEC_ID=ACCOUNTS.SEC_ID),(SELECT IFNULL(SUM(IFNULL(RES_SUM,0)),0) FROM RESULTS WHERE RESULTS.ACC_ID=ACCOUNTS.ACC_ID),(SELECT COUNT(*) FROM RESULTS WHERE RESULTS.ACC_ID=ACCOUNTS.ACC_ID) FROM ACCOUNTS WHERE CAST(ACCOUNTS.ACC_ID AS UNSIGNED INT)>=500000";						// �˴���дҪִ�е����
	    db = new MySQLConnect(sql);							// �½�һ�����ݿ�����
	    try {
			ret = db.pst.executeQuery();					// ִ��sql��䣬�õ������
			while (ret.next()) {
	            Vector hang=new Vector();
	            hang.add(ret.getString(1));
	        	hang.add(ret.getString(2));
	        	hang.add(ret.getString(3));
	        	hang.add(ret.getDouble(4));
	        	hang.add(ret.getInt(5));
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
