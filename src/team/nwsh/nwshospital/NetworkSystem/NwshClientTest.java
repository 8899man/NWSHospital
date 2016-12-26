package team.nwsh.nwshospital.NetworkSystem;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class NwshClientTest {
	
	private JTextArea incoming;

	private JTextField outgoing;

	private BufferedReader reader;

	private PrintWriter writer;

	private Socket socket;

	public static void main(String[] args)
	{
		NwshClientTest client = new NwshClientTest();
		client.startUp();
	}

	/**
	 * @author Liu Yummy
	 * @create 2016/12/26 11:14
	 * ����ͻ��˵�����,�����Ĺ���:
	 * 1. ��ʼ������
	 * 2. ��������˷�����Ϣ
	 * 3. �ӷ���˶�ȡ��Ϣ,��ӡ.
	 */
	public void startUp()
	{
		// ���µ�GUI�������
		JFrame frame = new JFrame("�򵥵�����ͻ���");
        JPanel mainPanel = new JPanel();
        
        incoming = new JTextArea(15,20); 
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
       
        JScrollPane qScroller = new JScrollPane(incoming);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        

        outgoing = new JTextField(20);
        

        JButton sendButton = new JButton("����");
        // ����ע��һ��actionListener,����������Ϣ����
        sendButton.addActionListener(new SendButtonListener());

        
        mainPanel.add(qScroller);
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        
        // ��ʼ��������Ϣ
        setupNetwork();
        
        // ������յ�����Ϣ
        Thread readerThread = new Thread(new IncomingReader());
        readerThread.start();
          
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(400,500);
        frame.setVisible(true);
	}

	private void setupNetwork()
	{
		try
		{
			// ���������ʼ��: ����socket����,��ȡsocket�����������
			socket = new Socket("127.0.0.1", 5000);
			
			InputStreamReader stream = new InputStreamReader(socket.getInputStream());
			reader = new BufferedReader(stream);
			
			writer = new PrintWriter(socket.getOutputStream());
			
			System.out.println("�����ʼ���Ѿ����,�����������!");
		} catch (UnknownHostException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public class SendButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				// ��socket��д����Ϣ
				writer.println(outgoing.getText());
				writer.flush();
			} catch (Exception ex)
			{
				ex.printStackTrace();
			} finally 
			{
				// �ر�������
				writer.flush();
				System.out.println("writer closed");
			}
			//�������������
			outgoing.setText("");
			outgoing.requestFocus();
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		try
		{
			// ��socket��д����Ϣ
			writer.println(outgoing.getText());
			writer.flush();
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally 
		{
			// �ر�������
			writer.flush();
			// System.out.println("writer closed");
		}
		//�������������
		outgoing.setText("");
		outgoing.requestFocus();
	}
	
	
	
	public class IncomingReader implements Runnable
	{
		public void run()
		{
			String message;
			try
			{
				// ��socket�ж�ȡ��Ϣ
				while((message = reader.readLine()) != null)
				{
					System.out.println("The message received is " + message);
					incoming.append(message + "\n");
				}
			} catch (IOException e)
			{
				e.printStackTrace();
			}
//			finally
//			{
//				try
//				{
//					// �ر�������
//					reader.close();
//					System.out.println("reader closed");
//				} catch (IOException e)
//				{
//					e.printStackTrace();
//				}
//			}
		}
	}
}
