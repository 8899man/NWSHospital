package team.nwsh.nwshospital;

import java.sql.*;

/**
 * 
 * @author Liu Yummy
 * 
 *	�������������֪����¹��ܵ��÷�����ʱ����ʹ�õģ�
 *	���λ�� Commit �� Push ʱ�����ļ����� Unstaged Changes �ڣ�
 *	���⽫���ļ����ǣ�Ӱ��������Ա��лл������
 *
 *	This Class is used to test new functions and temporary tests!
 *	In order not to misunderstand other team mates, 
 *	please ***KEEP*** this class in Unstaged Changes when you are going to Commit or Push!
 *	Thanks for your cooperation!
 *		   
 */

public class NWSHospital {

    static String sql = null;  
    static MySQLConnect db = null;  
    static ResultSet ret = null;  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sql = "SELECT * FROM ACCOUNTS";						// �˴���дҪִ�е����
        db = new MySQLConnect(sql);							// �½�һ�����ݿ�����
        try {
			ret = db.pst.executeQuery();					// ִ��sql��䣬�õ������
			while (ret.next()) {
                String uid = ret.getString("ACC_NAME");		// ��ȡִ��sql��������������ΪACC_NAME��һ��ֵ	
                System.out.println(uid);					// �����ȡ��ֵ
            }
	        ret.close();		// �ر�ִ�е��������
	        db.close();			// �ر����ݿ�����
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("* * * * * * * * * * ����ΪMySQL���ݿ����ӽ�ѧ���� * * * * * * * * * *");
        System.out.println("    * * * * * * * * * * ���潫��ʽ������ʼ���� * * * * * * * * * *");
        /** 
         * 
         * @author Liu Yummy
         * 
         * 	���潫��ʽ��ʼ���򣡸�λ�Ѿ�����ʹ�ô�ģ���¼�����Ե�ģ����ȥ
         * 	��ģ����û������λ���в��� ACCOUNTS ��
         * 
         */
        
        GeneralLogin JFrame_Login = new GeneralLogin();		// �½���¼����
        JFrame_Login.setResizable(false);					// ���õ�¼���ڴ�С�����޸�
        JFrame_Login.setLocationRelativeTo(null);			// �����ڷ�������Ļ������
        JFrame_Login.setVisible(true);						// ��������
        
	}

}
