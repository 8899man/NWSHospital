package team.nwsh.nwshospital.DirectorSystem;
import java.awt.Font;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.axis.CategoryAxis;  
import org.jfree.chart.axis.ValueAxis;  
import org.jfree.chart.plot.CategoryPlot;  
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.data.category.CategoryDataset;  
import org.jfree.data.category.DefaultCategoryDataset;

import team.nwsh.nwshospital.MySQLConnect;  
  
public class BarChart {  
    ChartPanel frame1;  
    static String sql = null;  
    static MySQLConnect db = null;  
    static ResultSet ret = null; 
 
    public  BarChart(){  
        CategoryDataset dataset = getDataSet();  
        JFreeChart chart = ChartFactory.createBarChart3D(  
                             "ҽԺ������ҵ��", // ͼ�����  
                            "������", // Ŀ¼�����ʾ��ǩ  
                            "�����ܽ��", // ��ֵ�����ʾ��ǩ  
                            dataset, // ���ݼ�  
                            PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ  
                            true,           // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)  
                            false,          // �Ƿ����ɹ���  
                            false           // �Ƿ�����URL����  
                            );  
        
        FileOutputStream fos_jpg=null;  
        try {  
            fos_jpg=new FileOutputStream("D:\\BarChart.jpg");  
            //����Ĳ����ֱ����������������ͼ�����ݡ���ȡ��߶ȡ���ע��Ϣ  
            ChartUtilities.writeChartAsJPEG(fos_jpg, 1.0f, chart,400, 300,null);  
        }catch (Exception e) {  
            e.printStackTrace();  
        }finally{  
            try {  
                fos_jpg.close();  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
          
        //�����￪ʼ  
        CategoryPlot plot=chart.getCategoryPlot();//��ȡͼ���������  
        CategoryAxis domainAxis=plot.getDomainAxis();         //ˮƽ�ײ��б�  
         domainAxis.setLabelFont(new Font("����",Font.BOLD,14));         //ˮƽ�ײ�����  
         domainAxis.setTickLabelFont(new Font("����",Font.BOLD,12));  //��ֱ����  
         ValueAxis rangeAxis=plot.getRangeAxis();//��ȡ��״  
         rangeAxis.setLabelFont(new Font("����",Font.BOLD,15));  
          chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));  
          chart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������  
            
          //�������������Ȼ�����е�࣬��ֻΪһ��Ŀ�ģ����������������  
            
         frame1=new ChartPanel(chart,true);      }  //����Ҳ������chartFrame,����ֱ������һ��������Frame  
           
    }  
       private static CategoryDataset getDataSet() {  
           DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
//           dataset.addValue(100, "����", "ƻ��");  
//           dataset.addValue(100, "�Ϻ�", "ƻ��");  
//           dataset.addValue(100, "����", "ƻ��");  
//           dataset.addValue(200, "����", "����");  
//           dataset.addValue(200, "�Ϻ�", "����");  
//           dataset.addValue(200, "����", "����");  
//           dataset.addValue(300, "����", "����");  
//           dataset.addValue(300, "�Ϻ�", "����");  
//           dataset.addValue(300, "����", "����");  
//           dataset.addValue(400, "����", "�㽶");  
//           dataset.addValue(400, "�Ϻ�", "�㽶");  
//           dataset.addValue(400, "����", "�㽶");  
//           dataset.addValue(500, "����", "��֦");  
//           dataset.addValue(500, "�Ϻ�", "��֦");  
//           dataset.addValue(500, "����", "��֦");  
   		sql = "SELECT   (SELECT IFNULL(SUM(IFNULL(RESULTS.RES_SUM,0)),0) FROM RESULTS WHERE RESULTS.ACC_ID =  (SELECT ACC_ID FROM ACCOUNTS WHERE ACCOUNTS.SEC_ID = SECTIONS.SEC_ID )),SECTIONS.SEC_NAME FROM SECTIONS WHERE CAST(SECTIONS.SEC_ID AS UNSIGNED INT)>=5000"	;					// �˴���дҪִ�е����
   	    db = new MySQLConnect(sql);							// �½�һ�����ݿ�����
   	    try {
   			ret = db.pst.executeQuery();					// ִ��sql��䣬�õ������
   			while (ret.next()) {
   	            dataset.addValue(ret.getInt(1),ret.getString(2),ret.getString(2));
   	     //return dataset; 
   	        }
   	        ret.close();		// �ر�ִ�е��������
   	        db.close();			// �ر����ݿ�����
   		} catch (SQLException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
		return dataset;
       }
            
public ChartPanel getChartPanel(){  
    return frame1;  
      
}  
}  