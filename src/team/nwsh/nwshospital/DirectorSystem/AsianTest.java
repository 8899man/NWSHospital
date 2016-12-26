package team.nwsh.nwshospital.DirectorSystem;

import java.io.FileOutputStream;  
import java.io.IOException;  
import com.lowagie.text.*;  
import com.lowagie.text.pdf.PdfWriter;  
import com.lowagie.text.pdf.BaseFont;  
import com.lowagie.text.Font;  
import java.awt.Color;  

public class AsianTest {  

  public static void AT(String[] args) {  

      // ����һ��Document����  
      Document document = new Document();  

      try {  

          // ������Ϊ AsianTest.pdf ���ĵ�  
          PdfWriter.getInstance(document, new FileOutputStream(  
                  "D://Report.pdf"));  

          /** 
           * �½�һ������,iText�ķ��� STSongStd-Light �����壬��iTextAsian.jar ����propertyΪ��׺ 
           * UniGB-UCS2-H �Ǳ��룬��iTextAsian.jar ����cmapΪ��׺ H �������ְ�ʽ�� ��棬 ��Ӧ�� V 
           * �������� 
           */  
          BaseFont bfChinese = BaseFont.createFont("STSongStd-Light",  
                  "UniGB-UCS2-H", false);  

          Font bold_fontChinese = new Font(bfChinese, 12, Font.BOLD,  
                  Color.BLACK);  
          Font italic_fontChinese = new Font(bfChinese, 12, Font.ITALIC,  
                  Color.BLACK);  
          Font impressFont = new Font(bfChinese, 16, Font.BOLDITALIC,  
                  Color.BLACK);  
          // ���ĵ�����Ҫд������  
          document.open();  

          // ����һ������  
          // Paragraph par = new Paragraph("����", fontChinese);  

          // document.add(par);  
          //  
          document.add(new Paragraph(" ", bold_fontChinese));  
          document.add(new Paragraph(" ", bold_fontChinese));  
          document.add(new Paragraph(" ", bold_fontChinese));  
          String[] Trainspotting1 = { "ѡ��������ѡ������ѡ��ְҵ��ѡ���ͥ��",  
                  "ѡ��ɶ�Ĵ�ʵ�,ѡ��ϴ�»����������������,", "ѡ�񽡿����͵��̴�����ҽ����,ѡ��¥���,",  
                  "ѡ���������,ѡ����װ�����������,ѡ����ڸ������������װ,",  
                  "ѡ���տ����ĵ���Ϸ��Ŀ,�߿��߳���ʳ����ѡ�����δ��,ѡ����������", "̫��ѡ��,��ѡ��ʲô,��ѡ��ѡ��" };  
          String[] Trainspotting2 = { "���ǵ�Ӱ���»𳵡���ͷ���԰ס�", "����һ�����ڡ�ѡ�񡱵Ĺ��¡�" };  
          String[] Benjamin1 = { "��Щ�˾��ںӱ߳�������,", "��Щ�˱��������,",  
                  "��Щ�˶��������ŷǷ����츳,", "��Щ����������,", "���˻���Ӿ,", "���˶�����Ŧ��,",  
                  "���˻ᱳɯʿ����,", "����Щ�ˡ�������ĸ��,", "Ҳ��Щ��,�����������衣",  
                  "Goodnight  Daisy", "Goodnight  Benjamin" };  
          String[] Benjamin2 = { "���ǵ�Ӱ�����������桷��β���԰ס�", "����һ�����ڡ�������Ĺ��¡�" };  
          String[] text1 = { "����˵���ǣ�", "����ѡ��ͬʱ�����Ǵ����" };  
          String[] text2 = { "��ȥ�޿�ѡ���ѡ���ֻ�ѡ���ѡ��",  
                  "����Ȥ��һ���£�������(̫���)ѡ�����ǻ����ѡ��", "ͬʱ�������ֻ���ο��������" };  
          String[] text3 = { "�ڿ�ʼ�ͽ���֮�䣬ѡ����ʲô���ֻ���ʲô���һ���֪����" };  
          String[] text4 = { "���֪��ô��" };  
          //  
          for (String s : Trainspotting1) {  
              document.add(new Paragraph(s, italic_fontChinese));  
              document.add(new Paragraph(" ", italic_fontChinese));  
          }  
          for (String s : Trainspotting2) {  
              document.add(new Paragraph(s, bold_fontChinese));  
          }  
          document.add(new Paragraph(" ", bold_fontChinese));  
          document.add(new Paragraph(" ", bold_fontChinese));  
          document.add(new Paragraph(" ", bold_fontChinese));  
          for (String s : Benjamin1) {  
              document.add(new Paragraph(s, italic_fontChinese));  
              document.add(new Paragraph(" ", italic_fontChinese));  
          }  
          for (String s : Benjamin2) {  
              document.add(new Paragraph(s, bold_fontChinese));  
          }  
          document.add(new Paragraph(" ", bold_fontChinese));  
          document.add(new Paragraph(" ", bold_fontChinese));  
          document.add(new Paragraph(" ", bold_fontChinese));  
          for (String s : text1) {  
              document.add(new Paragraph(s, bold_fontChinese));  
          }  
          document.add(new Paragraph(" ", bold_fontChinese));  
          for (String s : text2) {  
              document.add(new Paragraph(s, bold_fontChinese));  
          }  
          document.add(new Paragraph(" ", bold_fontChinese));  
          for (String s : text3) {  
              document.add(new Paragraph(s, bold_fontChinese));  
          }  
          document.add(new Paragraph(" ", bold_fontChinese));  
          for (String s : text4) {  
              document.add(new Paragraph(s, bold_fontChinese));  
          }  
          document.add(new Paragraph(" ", bold_fontChinese));  
          //  
          String[] end = { "Some people were born to sit by a river...",  
                  "Some get struck by light...",  
                  "Some have an ear for music...", "Some are artists...",  
                  "Some swim...", "Some know buttons...",  
                  "Some know Shakespeare...", "Some are mothers...",  
                  "And some people can dance..." };  
          for (String s : end) {  
              document.add(new Paragraph(s, bold_fontChinese));  
          }  
          document.add(new Paragraph(  
                  "by the way, some people can write code.��", impressFont));  

          // Chapter  
          Paragraph title1 = new Paragraph("Chapter 1", italic_fontChinese);  
          Chapter chapter1 = new Chapter(title1, 1);  
          chapter1.setNumberDepth(0);  
          Paragraph title11 = new Paragraph(  
                  "This is Section 1 in Chapter 1����", italic_fontChinese);  
          Section section1 = chapter1.addSection(title11);  
          Paragraph someSectionText = new Paragraph(  
                  "This text comes as part of section 1 of chapter 1.");  
          section1.add(someSectionText);  
          someSectionText = new Paragraph("Following is a 3 X 2 table.");  
          section1.add(someSectionText);  
          //  
          document.add(chapter1);  
          //  
          // ����һ��ͼƬ  

          Image jpeg1 = Image.getInstance("D:/BarChart.jpg");  
          Image jpeg2 = Image.getInstance("D:/HistogramChart.jpg");  
          Image jpeg3 = Image.getInstance("D:/PieChart.jpg");  
          Image jpeg4 = Image.getInstance("D:/SectorChart.jpg");  

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