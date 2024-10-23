package frame;

import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameBase extends JFrame {

	private static FrameBase instance;

	private FrameBase(JPanel e) {
		// �ý��� ����(ȭ�� ũ�⸦ ��� ���� Toolkit)
		Toolkit tk = Toolkit.getDefaultToolkit(); // �ػ�

		// �⺻ JFrame ����
		setTitle("dding-dong");
		setBounds(((int) tk.getScreenSize().getWidth()) / 2 - 250,
				((int) tk.getScreenSize().getHeight()) / 2 - 400,
				500, 800);
		add(e);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư
	}

	// �̱��� ����� ����Ϸ��� �Ѵ�
	public static void getInstance(JPanel e) {
		// static���� ���������Ƿ� �ش� �޼��尡 �����ں��ٵ� ���� ȣ��ȴ�
		instance = new FrameBase(e); // �����ڸ� ���� �⺻ ������ ����

		instance.getContentPane().removeAll(); // ���� ������ ����� ��
		instance.getContentPane().add(e); // ���ο� �г� �߰�

		instance.revalidate(); // ���̾ƿ� �����ڿ��� ���̾ƿ������� �ٽ� ����ϵ��� ����
		instance.repaint(); // ���̾ƿ��� ���� �׸���
	}

	public static void getDispose() {
		instance.dispose(); // ���� ������ �ݱ�
	}
}
