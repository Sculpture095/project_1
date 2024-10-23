package frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DeliveryVO.Category;
import DeliveryVO.RestaurantDAO;
import frame.foodcategory.FrameAmerican;
import frame.foodcategory.FrameBunsik;
import frame.foodcategory.FrameCafe;
import frame.foodcategory.FrameChicken;
import frame.foodcategory.FrameChina;
import frame.foodcategory.FrameFastfood;
import frame.foodcategory.FrameJapan;
import frame.foodcategory.FrameKorean;
import frame.foodcategory.FrameMeat;

public class FrameCategory extends JPanel {
	JPanel framecategoryPanel;

	public FrameCategory(JPanel homePanel) {
		this.framecategoryPanel = homePanel;
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setSize(500, 800);

		// �ѽ� ��ư
		ImageIcon koreanbt = new ImageIcon("img/category_jjigae.png");
		JButton btnKorean = new JButton(koreanbt);
		btnKorean.setSize(78, 70);
		btnKorean.setLocation(54, 168);

		btnKorean.setContentAreaFilled(false);
		btnKorean.setBorderPainted(false);
		btnKorean.setFocusPainted(false);

		// �߽� ��ư
		ImageIcon chinabt = new ImageIcon("img/category_jajangmyeon.png");
		JButton btnChina = new JButton(chinabt);
		btnChina.setSize(81, 57);
		btnChina.setLocation(211, 177);

		btnChina.setContentAreaFilled(false);
		btnChina.setBorderPainted(false);
		btnChina.setFocusPainted(false);
		// �Ͻ� ��ư
		ImageIcon japanbt = new ImageIcon("img/category_sushi.png");
		JButton btnJapan = new JButton(japanbt);
		btnJapan.setSize(109, 66);
		btnJapan.setLocation(350, 175);

		btnJapan.setContentAreaFilled(false);
		btnJapan.setBorderPainted(false);
		btnJapan.setFocusPainted(false);
		// ��� ��ư
		ImageIcon americanbt = new ImageIcon("img/category_pasta.png");
		JButton btnAmerican = new JButton(americanbt);
		btnAmerican.setSize(98, 70);
		btnAmerican.setLocation(43, 320);
		
		btnAmerican.setContentAreaFilled(false);
		btnAmerican.setBorderPainted(false);
		btnAmerican.setFocusPainted(false);
		// ġŲ ��ư
		ImageIcon chickenbbt = new ImageIcon("img/category_chicken.png");
		JButton btnChicken = new JButton(chickenbbt);
		btnChicken.setSize(91, 84);
		btnChicken.setLocation(201, 313);

		btnChicken.setContentAreaFilled(false);
		btnChicken.setBorderPainted(false);
		btnChicken.setFocusPainted(false);
		// �н� ��ư
		ImageIcon bunsikbt = new ImageIcon("img/category_toppogi.png");
		JButton btnBunsik = new JButton(bunsikbt);
		btnBunsik.setSize(92, 70);
		btnBunsik.setLocation(368, 323);

		btnBunsik.setContentAreaFilled(false);
		btnBunsik.setBorderPainted(false);
		btnBunsik.setFocusPainted(false);
		// �н�ƮǪ�� ��ư
		ImageIcon fastfoodbt = new ImageIcon("img/category_hamburger.png");
		JButton btnFastfood = new JButton(fastfoodbt);
		btnFastfood.setSize(66, 69);
		btnFastfood.setLocation(58, 472);

		btnFastfood.setContentAreaFilled(false);
		btnFastfood.setBorderPainted(false);
		btnFastfood.setFocusPainted(false);
		// ��� ��ư
		ImageIcon meatbt = new ImageIcon("img/category_meat.png");
		JButton btnMeat = new JButton(meatbt);
		btnMeat.setSize(80, 80);
		btnMeat.setLocation(212, 472);

		btnMeat.setContentAreaFilled(false);
		btnMeat.setBorderPainted(false);
		btnMeat.setFocusPainted(false);
		// ī��/����Ʈ ��ư
		ImageIcon cafebt = new ImageIcon("img/category_coffee.png");
		JButton btnCafe = new JButton(cafebt);
		btnCafe.setSize(42, 80);
		btnCafe.setLocation( 392, 472);

		btnCafe.setContentAreaFilled(false);
		btnCafe.setBorderPainted(false);
		btnCafe.setFocusPainted(false);
		
		add(btnCafe);
		add(btnMeat);
		add(btnAmerican);
		add(btnJapan);
		add(btnBunsik);
		add(btnChicken);
		add(btnChina);
		add(btnKorean);
		add(btnFastfood);

		// �ѽĹ�ư ������
		btnKorean.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ����� �̵���
				Category koreanCategory = RestaurantDAO.getCategory("�ѽ�");
				FrameBase.getDispose(); // ���� ������ �ݱ�
				FrameBase.getInstance(new FrameKorean(homePanel)); // ���ο� ���������� ��ȯ
			}
		});
		// �߽Ĺ�ư ������
				btnChina.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// ����� �̵���
						FrameBase.getDispose(); // ���� ������ �ݱ�
						FrameBase.getInstance(new FrameChina(homePanel)); // ���ο� ���������� ��ȯ
					}
				});

		// �ϽĹ�ư ������
		btnJapan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ����� �̵���
				FrameBase.getDispose(); // ���� ������ �ݱ�
				FrameBase.getInstance(new FrameJapan(homePanel)); // ���ο� ���������� ��ȯ
			}
		});
		// ��Ĺ�ư ������
		btnAmerican.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ����� �̵���
				FrameBase.getDispose(); // ���� ������ �ݱ�
				FrameBase.getInstance(new FrameAmerican(homePanel)); // ���ο� ���������� ��ȯ
			}
		});
		// ġŲ��ư ������
		btnChicken.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ����� �̵���
				FrameBase.getDispose(); // ���� ������ �ݱ�
				FrameBase.getInstance(new FrameChicken(homePanel)); // ���ο� ���������� ��ȯ
			}
		});
		// �нĹ�ư ������
		btnBunsik.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ����� �̵���
				FrameBase.getDispose(); // ���� ������ �ݱ�
				FrameBase.getInstance(new FrameBunsik(homePanel)); // ���ο� ���������� ��ȯ
			}
		});
		// �н�ƮǪ���ư ������
		btnFastfood.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getDispose(); // ���� ������ �ݱ�
				FrameBase.getInstance(new FrameFastfood(homePanel)); // ���ο� ���������� ��ȯ
			}
		});
		// ����ư ������
		btnMeat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getDispose(); // ���� ������ �ݱ�
				FrameBase.getInstance(new FrameMeat(homePanel)); // ���ο� ���������� ��ȯ
			}
		});
		// ī��/����Ʈ��ư ������
		btnCafe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getDispose(); // ���� ������ �ݱ�
				FrameBase.getInstance(new FrameCafe(homePanel)); // ���ο� ���������� ��ȯ
			}
		});



		// ���ư ��ư
		ImageIcon ggimbt = new ImageIcon("img/heart_icon.png");
		JButton btnGgim = new JButton(ggimbt);
		btnGgim.setSize(39, 38);
		btnGgim.setLocation(32, 685);

		btnGgim.setContentAreaFilled(false);
		btnGgim.setBorderPainted(false);
		btnGgim.setFocusPainted(false);
		// �ֹ���Ȳ ��ư
		ImageIcon orderbt = new ImageIcon("img/order_icon.png");
		JButton btnOrder = new JButton(orderbt);
		btnOrder.setSize(38, 38);
		btnOrder.setLocation(125, 685);

		btnOrder.setContentAreaFilled(false);
		btnOrder.setBorderPainted(false);
		btnOrder.setFocusPainted(false);
		// ī�װ� ��ư
		ImageIcon categorybt = new ImageIcon("img/home_icon.png");
		JButton btnCategory = new JButton(categorybt);
		btnCategory.setSize(47, 39);
		btnCategory.setLocation(225, 685);

		btnCategory.setContentAreaFilled(false);
		btnCategory.setBorderPainted(false);
		btnCategory.setFocusPainted(false);
		// ��ٱ��� ��ư
		ImageIcon cartbt = new ImageIcon("img/cart_icon.png");
		JButton btnCart = new JButton(cartbt);
		btnCart.setSize(44, 38);
		btnCart.setLocation(325, 685);

		btnCart.setContentAreaFilled(false);
		btnCart.setBorderPainted(false);
		btnCart.setFocusPainted(false);
		// ���������� ��ư
		ImageIcon mypagebt = new ImageIcon("img/user_icon.png");
		JButton btnMypage = new JButton(mypagebt);
		btnMypage.setSize(36, 42);
		btnMypage.setLocation(425, 685);

		btnMypage.setContentAreaFilled(false);
		btnMypage.setBorderPainted(false);
		btnMypage.setFocusPainted(false);

		add(btnGgim);
		add(btnOrder);
		add(btnCategory);
		add(btnCart);
		add(btnMypage);

		// ���ư ������
		btnGgim.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ����� �̵���
				FrameBase.getDispose(); // ���� ������ �ݱ�
				FrameBase.getInstance(new FrameGgim(homePanel)); // ���ο� ���������� ��ȯ
				
			}
		});
		// �ֹ���Ȳ��ư ������
		btnOrder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getDispose(); // ���� ������ �ݱ�
				FrameBase.getInstance(new FrameOrder(homePanel)); // ���ο� ���������� ��ȯ
			}
		});
		// ī�װ���ư ������
		btnCategory.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getDispose(); // ���� ������ �ݱ�
				FrameBase.getInstance(new FrameCategory(homePanel)); // ���ο� ���������� ��ȯ
			}
		});
		// ��ٱ��Ϲ�ư ������
		btnCart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getDispose(); // ���� ������ �ݱ�
				FrameBase.getInstance(new FrameCart(homePanel)); // ���ο� ���������� ��ȯ
			}
		});
		// ���������� ������
		btnMypage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getDispose(); // ���� ������ �ݱ�
				FrameBase.getInstance(new FrameMypage(homePanel)); // ���ο� ���������� ��ȯ
			}
		});

		ImageIcon mainBg = new ImageIcon("img/category_bg.jpg");
		JLabel lblmb = new JLabel(mainBg);
		lblmb.setSize(500, 800);
		lblmb.setLocation(0, -20);
		add(lblmb);

	}
}
