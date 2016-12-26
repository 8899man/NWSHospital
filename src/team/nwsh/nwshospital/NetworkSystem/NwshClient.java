package team.nwsh.nwshospital.NetworkSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class NwshClient {
	
	// private JTextArea incoming;
	
	public String incoming = null;

	// private JTextField outgoing;
	
	public String outgoing;

	private BufferedReader reader;

	private PrintWriter writer;

	private Socket socket;

	/**
	 * @author Liu Yummy
	 * @create 2016/12/26 11:14
	 * ����ͻ��˵�����,�����Ĺ���:
	 * 1. ��ʼ������;
	 * 2. ��ͻ��˷�����Ϣ��֪ͨ�����ˢ��;
	 * 3. �ӷ���˶�ȡ��Ϣ,��̬ˢ�±�������;
	 * ���⣬ԭ���뽫����д��ģ�����������
	 * ���Ƿ���IncomingReader�ڵ��õ�ʱ���޷��������ã�
	 * �������Ҵ�ģ����Ϊѧϰʹ�ã�
	 */
	public void startUp()
	{
        outgoing = "new";

        setupNetwork();
        
        // ������յ�����Ϣ
        Thread readerThread = new Thread(new IncomingReader());
        readerThread.start();

	}

	private void setupNetwork() {
		try {
			// ���������ʼ��: ����socket����,��ȡsocket�����������
			socket = new Socket("127.0.0.1", 5000);
			
			InputStreamReader stream = new InputStreamReader(socket.getInputStream());
			reader = new BufferedReader(stream);
			
			writer = new PrintWriter(socket.getOutputStream());
			
			System.out.println("�����ʼ���Ѿ����,�����������!");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void SendMessage() {
		try {
			// ��socket��д����Ϣ
			writer.println(outgoing);
			writer.flush();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// ������������ˢ��
			writer.flush();
			// System.out.println("writer closed");
		}
	}
	
	public class IncomingReader implements Runnable {
		public void run() {
			String message;
			try {
				// ��socket�ж�ȡ��Ϣ
				while((message = reader.readLine()) != null) {
					System.out.println("The message received is " + message);
					incoming = message;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
