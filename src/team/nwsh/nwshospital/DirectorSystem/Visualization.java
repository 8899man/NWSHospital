package team.nwsh.nwshospital.DirectorSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

public class Visualization extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Visualization frame = new Visualization();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Visualization() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	public void Cake(){
        // Ĭ����������  
        DefaultPieDataset dataType = new DefaultPieDataset();  
        // ���ݲ��� ���ݣ�����  
        dataType.setValue("IE6", 156);  
        dataType.setValue("IE7", 230);  
        dataType.setValue("IE8", 45);  
        dataType.setValue("���", 640);  
        dataType.setValue("�ȸ�", 245);    
        DefaultPieDataset data = dataType;  
            // ������ͨ��״ͼ���� 3D ����  
            // ����3D��״ͼ  
            PiePlot3D plot = new PiePlot3D(data);  
            JFreeChart chart = new JFreeChart(  
                    "�û�ʹ�õ����������",            // ͼ�α���  
                    JFreeChart.DEFAULT_TITLE_FONT, // ��������  
                    plot,                          // ͼ��������  
                    true                           // �Ƿ���ʾͼ��  
            );  

            // ����ͼƬ�б߿�  
            chart.setBorderVisible(true);  
            // ��������  
            Font kfont = new Font("����", Font.PLAIN, 12);    // �ײ�  
            Font titleFont = new Font("����", Font.BOLD, 25); // ͼƬ����  
            // ͼƬ����  
            chart.setTitle(new TextTitle(chart.getTitle().getText(), titleFont));  
            // �ײ�  
            chart.getLegend().setItemFont(kfont);  
	//test end
}
}