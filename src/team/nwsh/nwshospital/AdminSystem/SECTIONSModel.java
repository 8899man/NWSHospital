//һ��SECTIONS���ģ��,�����ұ�
package team.nwsh.nwshospital.AdminSystem;


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

public class SECTIONSModel extends AbstractTableModel {
	Vector RowData,ColumnNames;
    static String sql = null;  
    static MySQLConnect db = null;  
    static ResultSet ret = null; 

    //ͨ�����ݵ�sql������������ģ��
    public SECTIONSModel(String sql)
    {
    	//������ͷ
    	ColumnNames= new Vector();
		ColumnNames.add("����ID");
		ColumnNames.add("������");
		ColumnNames.add("��������");
		
		
		RowData=new Vector(); 						// �˴���дҪִ�е����
	    db = new MySQLConnect(sql);							// �½�һ�����ݿ�����
	    try {
			ret = db.pst.executeQuery();					// ִ��sql��䣬�õ������
			while (ret.next()) {
	            Vector hang=new Vector();
	        	hang.add(ret.getString(1));
	        	hang.add(ret.getString(2));
	        	hang.add(ret.getInt(3));
	        	
	        	
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
    public SECTIONSModel()
    {
    	ColumnNames= new Vector();
		ColumnNames.add("����ID");
		ColumnNames.add("������");
		ColumnNames.add("��������");
		
		//������ͷ
		RowData=new Vector(); 
		sql = "SELECT * FROM SECTIONS";						// �˴���дҪִ�е����
	    db = new MySQLConnect(sql);							// �½�һ�����ݿ�����
	    try {
			ret = db.pst.executeQuery();					// ִ��sql��䣬�õ������
			while (ret.next()) {
	            Vector line=new Vector();
	        	line.add(ret.getString(1));
	        	line.add(ret.getString(2));
	        	line.add(ret.getInt(3));
	        	
	        	RowData.add(line);
	        }
	        ret.close();		// �ر�ִ�е��������
	        db.close();			// �ر����ݿ�����
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.RowData.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.ColumnNames.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		// TODO �Զ����ɵķ������
		return ((Vector)this.RowData.get(row)).get(column);
	}

	@Override
	public String getColumnName(int arg0) {
		// TODO �Զ����ɵķ������
		return (String)this.ColumnNames.get(arg0);
	}

    


}