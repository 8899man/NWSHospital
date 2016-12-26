package team.nwsh.nwshospital.DirectorSystem;

import java.awt.Font;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;  
import java.text.NumberFormat;  
  
import javax.swing.JPanel;  
  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;  
import org.jfree.chart.plot.PiePlot;  
import org.jfree.data.general.DefaultPieDataset;

import team.nwsh.nwshospital.MySQLConnect;  
  
public class SectorChart {  
    ChartPanel frame1;  
    static String sql = null;  
    static MySQLConnect db = null;  
    static ResultSet ret = null; 
    
    public SectorChart(){  
          DefaultPieDataset data = getDataSet();  
          JFreeChart chart = ChartFactory.createPieChart3D("ҽԺҵ����",data,true,false,false);  
        //���ðٷֱ�  
          PiePlot pieplot = (PiePlot) chart.getPlot();  
          DecimalFormat df = new DecimalFormat("0.00%");//���һ��DecimalFormat������Ҫ������С������  
          NumberFormat nf = NumberFormat.getNumberInstance();//���һ��NumberFormat����  
          StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//���StandardPieSectionLabelGenerator����  
          pieplot.setLabelGenerator(sp1);//���ñ�ͼ��ʾ�ٷֱ�  
        
      //û�����ݵ�ʱ����ʾ������  
          pieplot.setNoDataMessage("��������ʾ");  
          pieplot.setCircular(false);  
          pieplot.setLabelGap(0.02D);  
        
          pieplot.setIgnoreNullValues(true);//���ò���ʾ��ֵ  
          pieplot.setIgnoreZeroValues(true);//���ò���ʾ��ֵ  
         frame1=new ChartPanel (chart,true);  
          chart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������  
          PiePlot piePlot= (PiePlot) chart.getPlot();//��ȡͼ���������  
          piePlot.setLabelFont(new Font("����",Font.BOLD,10));//�������  
          chart.getLegend().setItemFont(new Font("����",Font.BOLD,10));  
          
          FileOutputStream fos_jpg=null;  
          try {  
              fos_jpg=new FileOutputStream("D:\\SectorChart.jpg");  
              //����Ĳ����ֱ����������������ͼ�����ݡ���ȡ��߶ȡ���ע��Ϣ  
              ChartUtilities.writeChartAsJPEG(fos_jpg, 1.0f, chart,400, 300,null);  
          }catch (Exception e) {  
              e.printStackTrace();  
          }finally{  
              try {  
                  fos_jpg.close();  
              } catch (Exception e) {  
                  e.printStackTrace();  }}
    }  
    private static DefaultPieDataset getDataSet() {  
        DefaultPieDataset dataset = new DefaultPieDataset();  
        
//        dataset.setValue("ƻ��",100);  
//        dataset.setValue("����",200);  
//        dataset.setValue("����",300);  
//        dataset.setValue("�㽶",400);  
//        dataset.setValue("��֦",500); 
        
        sql = "SELECT (SELECT COUNT(*) AS SEC_NUMBER FROM RESULTS WHERE RESULTS.ACC_ID = "
   				+ "(SELECT ACC_ID FROM ACCOUNTS WHERE ACCOUNTS.SEC_ID = SECTIONS.SEC_ID )) ,"
   				+ "SECTIONS.SEC_NAME FROM SECTIONS WHERE CAST(SECTIONS.SEC_ID AS UNSIGNED INT)>=5000"	;					// �˴���дҪִ�е����
   	    db = new MySQLConnect(sql);							// �½�һ�����ݿ�����
   	    try {
   			ret = db.pst.executeQuery();					// ִ��sql��䣬�õ������
   			while (ret.next()) {
   	            dataset.setValue(ret.getString(2),ret.getInt(1));
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