package team.nwsh.nwshospital.DirectorSystem;

import java.io.FileOutputStream;  
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import com.lowagie.text.*;  
import com.lowagie.text.pdf.PdfWriter;
import team.nwsh.nwshospital.MySQLConnect;
import com.lowagie.text.pdf.BaseFont;  
import com.lowagie.text.Font;  
import java.awt.Color;  

public class AsianTest {    
    static String sql = null;  
    static MySQLConnect db = null;  
    static ResultSet ret = null; 
    
    
  public static void AT(String[] args) {  
      // ����һ��Document����  
	  
      Document document = new Document();  
      try {  
          // ������Ϊ AsianTest.pdf ���ĵ�  
          PdfWriter.getInstance(document, new FileOutputStream(  
                  "C:\\REPORT\\HospitalReport.pdf"));  
          /** 
           * �½�һ������,iText�ķ��� STSongStd-Light �����壬��iTextAsian.jar ����propertyΪ��׺ 
           * UniGB-UCS2-H �Ǳ��룬��iTextAsian.jar ����cmapΪ��׺ H �������ְ�ʽ�� ��棬 ��Ӧ�� V 
           * �������� 
           */  
          BaseFont bfChinese = BaseFont.createFont("STSongStd-Light",  
                  "UniGB-UCS2-H", false);  

          Font bold_fontChinese = new Font(bfChinese, 12, Font.BOLD,  
                  Color.BLACK);  
          Font italic_fontChinese = new Font(bfChinese, 36, Font.ITALIC,  
                  Color.BLACK);  
          Font impressFont = new Font(bfChinese, 16, Font.BOLDITALIC,  
                  Color.BLACK);  
          // ���ĵ�����Ҫд������  
          document.open();  
          // ����һ������  
          // Paragraph par = new Paragraph("����", fontChinese);  
          // document.add(par); 
          //����Ϊ����������
          //String[] WoZuiShuai = { "������˧��" };  
          // for (String s : WoZuiShuai) {  
          //document.add(new Paragraph(s, italic_fontChinese));  
          //document.add(new Paragraph(" ", italic_fontChinese));  
          //  
          // Chapter  
          Paragraph title11 = new Paragraph("ҽԺ���ڹ����������", italic_fontChinese);  
          Chapter chapter11 = new Chapter(title11, 1);  
          title11.setAlignment(Element.ALIGN_CENTER);
          chapter11.setNumberDepth(0); 
          Paragraph title1 = new Paragraph("���棡ҩƷ��治�㣡������£�", bold_fontChinese);  
          Chapter chapter1 = new Chapter(title1, 1);  
          chapter1.setNumberDepth(0);  
        //test����һ�����еı��
          Table TM=new Table(2);
          //���ñ߿�
          TM.setBorder(1);
          //������ͷ 

          Cell cellTM1=new Cell(new Phrase("ҩƷ��",bold_fontChinese));
          cellTM1.setHorizontalAlignment(Element.ALIGN_CENTER);
          cellTM1.setVerticalAlignment(Element.ALIGN_CENTER);
          cellTM1.setHeader(true);
          cellTM1.setBackgroundColor(Color.RED);

          Cell cellTM2=new Cell(new Phrase("���",bold_fontChinese));
          cellTM2.setHorizontalAlignment(Element.ALIGN_CENTER);
          cellTM2.setVerticalAlignment(Element.ALIGN_CENTER);
          cellTM2.setHeader(true);
          cellTM2.setBackgroundColor(Color.RED);
          TM.addCell(cellTM1);
          TM.addCell(cellTM2);
          //��Ӵ˴����ÿҳ������ʾ��ͷ
          TM.endHeaders();
          //���´���������Ǵ���������,����ÿ��������,������Ϊ ��� ������ �����ܽ�� �������˴�
          sql = "SELECT MED_NAME,MED_STORGE FROM MEDICINE"	;// �˴���дҪִ�е����
  	    db = new MySQLConnect(sql);							// �½�һ�����ݿ�����
  	    try {
  			ret = db.pst.executeQuery();					// ִ��sql��䣬�õ������
  			while (ret.next()) {
  				String String_CheckName = ret.getString("MED_NAME");
  	             int Int_CheckStorge = ret.getInt("MED_STORGE");// ��ȡִ��sql��������������ΪACC_NAME��һ��ֵ	
  	             if (Int_CheckStorge<=20){
                //���ñ�ŵ�Ԫ��
                Cell cell11=new Cell(new Phrase(ret.getString(1),bold_fontChinese));
                //����������Ԫ��
                Cell cell22=new Cell(new Phrase(ret.getString(2)));
                //��Ԫ��ˮƽ���뷽ʽ
                cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
                //��Ԫ��ֱ���뷽ʽ
                cell11.setVerticalAlignment(Element.ALIGN_CENTER);

                cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell22.setVerticalAlignment(Element.ALIGN_CENTER);
                TM.addCell(cell11);
                TM.addCell(cell22);
  	             }
  	        }
  	        ret.close();		// �ر�ִ�е��������
  	        db.close();			// �ر����ݿ�����
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}    
  	  document.add(chapter11); 
  	  document.add(chapter1);    
      document.add(TM);

          //����һ����
          Paragraph par3=new Paragraph("���ҹ������",bold_fontChinese);
          //���þ��ж���
          par3.setAlignment(Element.ALIGN_CENTER);
          //��ӵ��ĵ�
          document.add(par3);
          //����һ�����еı��
          Table table=new Table(4);
          //���ñ߿�
          table.setBorder(1);
          //������ͷ
          Cell cell1=new Cell(new Phrase("���",bold_fontChinese));
          cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
          cell1.setVerticalAlignment(Element.ALIGN_CENTER);
          cell1.setHeader(true);
          cell1.setBackgroundColor(Color.RED);

          Cell cell2=new Cell(new Phrase("������",bold_fontChinese));
          cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
          cell2.setVerticalAlignment(Element.ALIGN_CENTER);
          cell2.setHeader(true);
          cell2.setBackgroundColor(Color.RED);

          Cell cell3=new Cell(new Phrase("�����ܽ��",bold_fontChinese));
          cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
          cell3.setVerticalAlignment(Element.ALIGN_CENTER);
          cell3.setHeader(true);
          cell3.setBackgroundColor(Color.RED);

          Cell cell4=new Cell(new Phrase("�������˴�",bold_fontChinese));
          cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
          cell4.setVerticalAlignment(Element.ALIGN_CENTER);
          cell4.setHeader(true);
          cell4.setBackgroundColor(Color.RED);
          
          

          table.addCell(cell1);
          table.addCell(cell2);
          table.addCell(cell3);
          table.addCell(cell4);
          //��Ӵ˴����ÿҳ������ʾ��ͷ
          table.endHeaders();
          //���´���������Ǵ���������,����ÿ��������,������Ϊ ��� ������ �����ܽ�� �������˴�
          sql = "SELECT SECTIONS.SEC_ID, SECTIONS.SEC_NAME, (SELECT round(IFNULL(SUM(IFNULL(RESULTS.RES_SUM,0)),0),2) FROM RESULTS WHERE RESULTS.ACC_ID =  (SELECT ACC_ID FROM ACCOUNTS WHERE ACCOUNTS.SEC_ID = SECTIONS.SEC_ID )),(SELECT COUNT(*) AS SEC_NUMBER FROM RESULTS WHERE RESULTS.ACC_ID = (SELECT ACC_ID FROM ACCOUNTS WHERE ACCOUNTS.SEC_ID = SECTIONS.SEC_ID )) FROM SECTIONS WHERE CAST(SECTIONS.SEC_ID AS UNSIGNED INT)>=5000"	;// �˴���дҪִ�е����
  	    db = new MySQLConnect(sql);							// �½�һ�����ݿ�����
  	    try {
  			ret = db.pst.executeQuery();					// ִ��sql��䣬�õ������
  			while (ret.next()) {
                //���ñ�ŵ�Ԫ��
                Cell cell11=new Cell(new Phrase(ret.getString(1)));
                //����������Ԫ��
                Cell cell22=new Cell(new Phrase(ret.getString(2),bold_fontChinese));
                //�����Ա�Ԫ��
                Cell cell33=new Cell(new Phrase(ret.getString(3)));
                //���ñ�ע��Ԫ��
                Cell cell44=new Cell(new Phrase(ret.getString(4)));

                //��Ԫ��ˮƽ���뷽ʽ
                cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
                //��Ԫ��ֱ���뷽ʽ
                cell11.setVerticalAlignment(Element.ALIGN_CENTER);

                cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell22.setVerticalAlignment(Element.ALIGN_CENTER);

                cell33.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell33.setVerticalAlignment(Element.ALIGN_CENTER);

                cell44.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell44.setVerticalAlignment(Element.ALIGN_CENTER);

                table.addCell(cell11);
                table.addCell(cell22);
                table.addCell(cell33);
                table.addCell(cell44);
  	        }
  			
  	        ret.close();		// �ر�ִ�е��������
  	        db.close();			// �ر����ݿ�����
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}



          //test end
          document.add(table);
          Image jpeg1 = Image.getInstance("C:\\REPORT\\BarChart.jpg");  
          Image jpeg2 = Image.getInstance("C:\\REPORT\\HistogramChart.jpg");  
          Image jpeg3 = Image.getInstance("C:\\REPORT\\PieChart.jpg");  
          Image jpeg4 = Image.getInstance("C:\\REPORT\\SectorChart.jpg");  

          
          // ͼƬ����  
          jpeg1.setAlignment(Image.ALIGN_CENTER);  
          jpeg2.setAlignment(Image.ALIGN_CENTER);  
          jpeg3.setAlignment(Image.ALIGN_CENTER);  
          jpeg4.setAlignment(Image.ALIGN_CENTER);  
          
          document.add(jpeg1);  
          document.add(jpeg2); 
          document.add(jpeg3); 
          document.add(jpeg4); 
      } catch (DocumentException de) {  
          System.err.println(de.getMessage());  
      } catch (IOException ioe) {  
          System.err.println(ioe.getMessage());  
      }  

      
      // �رմ򿪵��ĵ�  
      document.close();  
  }  
  
}
 