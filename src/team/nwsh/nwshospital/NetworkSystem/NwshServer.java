package team.nwsh.nwshospital.NetworkSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class NwshServer extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NwshServer frame = new NwshServer();
					new NwshServer().startUp();
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
	public NwshServer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	// ����ͻ����б�
	private ArrayList clientList = new ArrayList();;
	
	
	/**
	 * ����������˵�����
	 *
	 */
	public void startUp()
	{
		try
		{
			// ������������ServerSocket����,�����˿ں�5000
			ServerSocket serverSocket = new ServerSocket(5000);
			
			// ��ѯ�ȴ��ͻ�������
			while(true)
			{
				// �ȴ��ͻ�������,������������;��������ʱ,����һ���Ը������socket����
				Socket clientSocket = serverSocket.accept();
				
				// ���ÿͻ��˼��뵽�б���
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
				clientList.add(writer);
				
				// ����ClientHandler����,ͨ��socket����ͨ��
				Thread t = new Thread(new ClientHandler(clientSocket));
				t.start();

				System.out.println("��Client������");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Liu Yummy
	 * @create 2016/12/26 11:14
	 * �ͻ��˴�����, ��Ҫ����:
	 * 1.���տͻ��˷�������Ϣ;
	 * 2.����Ϣת�������ͻ���.
	 */
	public class ClientHandler implements Runnable {
		private BufferedReader reader;
		private Socket socket;
		
		/**
		 * ClientHandler�Ĺ��캯��
		 * @param clientSocket
		 */
		public ClientHandler(Socket clientSocket) {
			
			try {
				// �õ�socket����
				socket = clientSocket;
				
				// �õ��ͻ��˷�������Ϣ
				InputStreamReader isReader = new InputStreamReader(socket.getInputStream());
				reader = new BufferedReader(isReader);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void run() {
			String message;
			try {
				while((message = reader.readLine()) != null) {
					System.out.println("�ͻ�����Ϣ: " + message);
					// ���ͻ��˷�������Ϣת�����пͻ���
					notifyAllClients(message);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * @param message
	 */
	public void notifyAllClients(String message) {
		// �õ��ͻ����б�ĵ�����,�﷨��ʽΪ Iterator it = clientList.iterator();
		Iterator it = clientList.iterator();
		
		while(it.hasNext()) {
			try {
				// �õ���Iterator������ǿ��ת����PrintWriter
				PrintWriter writer = (PrintWriter) it.next();
				writer.println(message);
				writer.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
	}
}
