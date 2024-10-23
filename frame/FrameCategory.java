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

		// 한식 버튼
		ImageIcon koreanbt = new ImageIcon("img/category_jjigae.png");
		JButton btnKorean = new JButton(koreanbt);
		btnKorean.setSize(78, 70);
		btnKorean.setLocation(54, 168);

		btnKorean.setContentAreaFilled(false);
		btnKorean.setBorderPainted(false);
		btnKorean.setFocusPainted(false);

		// 중식 버튼
		ImageIcon chinabt = new ImageIcon("img/category_jajangmyeon.png");
		JButton btnChina = new JButton(chinabt);
		btnChina.setSize(81, 57);
		btnChina.setLocation(211, 177);

		btnChina.setContentAreaFilled(false);
		btnChina.setBorderPainted(false);
		btnChina.setFocusPainted(false);
		// 일식 버튼
		ImageIcon japanbt = new ImageIcon("img/category_sushi.png");
		JButton btnJapan = new JButton(japanbt);
		btnJapan.setSize(109, 66);
		btnJapan.setLocation(350, 175);

		btnJapan.setContentAreaFilled(false);
		btnJapan.setBorderPainted(false);
		btnJapan.setFocusPainted(false);
		// 양식 버튼
		ImageIcon americanbt = new ImageIcon("img/category_pasta.png");
		JButton btnAmerican = new JButton(americanbt);
		btnAmerican.setSize(98, 70);
		btnAmerican.setLocation(43, 320);
		
		btnAmerican.setContentAreaFilled(false);
		btnAmerican.setBorderPainted(false);
		btnAmerican.setFocusPainted(false);
		// 치킨 버튼
		ImageIcon chickenbbt = new ImageIcon("img/category_chicken.png");
		JButton btnChicken = new JButton(chickenbbt);
		btnChicken.setSize(91, 84);
		btnChicken.setLocation(201, 313);

		btnChicken.setContentAreaFilled(false);
		btnChicken.setBorderPainted(false);
		btnChicken.setFocusPainted(false);
		// 분식 버튼
		ImageIcon bunsikbt = new ImageIcon("img/category_toppogi.png");
		JButton btnBunsik = new JButton(bunsikbt);
		btnBunsik.setSize(92, 70);
		btnBunsik.setLocation(368, 323);

		btnBunsik.setContentAreaFilled(false);
		btnBunsik.setBorderPainted(false);
		btnBunsik.setFocusPainted(false);
		// 패스트푸드 버튼
		ImageIcon fastfoodbt = new ImageIcon("img/category_hamburger.png");
		JButton btnFastfood = new JButton(fastfoodbt);
		btnFastfood.setSize(66, 69);
		btnFastfood.setLocation(58, 472);

		btnFastfood.setContentAreaFilled(false);
		btnFastfood.setBorderPainted(false);
		btnFastfood.setFocusPainted(false);
		// 고기 버튼
		ImageIcon meatbt = new ImageIcon("img/category_meat.png");
		JButton btnMeat = new JButton(meatbt);
		btnMeat.setSize(80, 80);
		btnMeat.setLocation(212, 472);

		btnMeat.setContentAreaFilled(false);
		btnMeat.setBorderPainted(false);
		btnMeat.setFocusPainted(false);
		// 카페/디저트 버튼
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

		// 한식버튼 누르면
		btnKorean.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 여기로 이동함
				Category koreanCategory = RestaurantDAO.getCategory("한식");
				FrameBase.getDispose(); // 현재 프레임 닫기
				FrameBase.getInstance(new FrameKorean(homePanel)); // 새로운 프레임으로 전환
			}
		});
		// 중식버튼 누르면
				btnChina.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// 여기로 이동함
						FrameBase.getDispose(); // 현재 프레임 닫기
						FrameBase.getInstance(new FrameChina(homePanel)); // 새로운 프레임으로 전환
					}
				});

		// 일식버튼 누르면
		btnJapan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 여기로 이동함
				FrameBase.getDispose(); // 현재 프레임 닫기
				FrameBase.getInstance(new FrameJapan(homePanel)); // 새로운 프레임으로 전환
			}
		});
		// 양식버튼 누르면
		btnAmerican.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 여기로 이동함
				FrameBase.getDispose(); // 현재 프레임 닫기
				FrameBase.getInstance(new FrameAmerican(homePanel)); // 새로운 프레임으로 전환
			}
		});
		// 치킨버튼 누르면
		btnChicken.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 여기로 이동함
				FrameBase.getDispose(); // 현재 프레임 닫기
				FrameBase.getInstance(new FrameChicken(homePanel)); // 새로운 프레임으로 전환
			}
		});
		// 분식버튼 누르면
		btnBunsik.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 여기로 이동함
				FrameBase.getDispose(); // 현재 프레임 닫기
				FrameBase.getInstance(new FrameBunsik(homePanel)); // 새로운 프레임으로 전환
			}
		});
		// 패스트푸드버튼 누르면
		btnFastfood.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getDispose(); // 현재 프레임 닫기
				FrameBase.getInstance(new FrameFastfood(homePanel)); // 새로운 프레임으로 전환
			}
		});
		// 고기버튼 누르면
		btnMeat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getDispose(); // 현재 프레임 닫기
				FrameBase.getInstance(new FrameMeat(homePanel)); // 새로운 프레임으로 전환
			}
		});
		// 카페/디저트버튼 누르면
		btnCafe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getDispose(); // 현재 프레임 닫기
				FrameBase.getInstance(new FrameCafe(homePanel)); // 새로운 프레임으로 전환
			}
		});



		// 찜버튼 버튼
		ImageIcon ggimbt = new ImageIcon("img/heart_icon.png");
		JButton btnGgim = new JButton(ggimbt);
		btnGgim.setSize(39, 38);
		btnGgim.setLocation(32, 685);

		btnGgim.setContentAreaFilled(false);
		btnGgim.setBorderPainted(false);
		btnGgim.setFocusPainted(false);
		// 주문현황 버튼
		ImageIcon orderbt = new ImageIcon("img/order_icon.png");
		JButton btnOrder = new JButton(orderbt);
		btnOrder.setSize(38, 38);
		btnOrder.setLocation(125, 685);

		btnOrder.setContentAreaFilled(false);
		btnOrder.setBorderPainted(false);
		btnOrder.setFocusPainted(false);
		// 카테고리 버튼
		ImageIcon categorybt = new ImageIcon("img/home_icon.png");
		JButton btnCategory = new JButton(categorybt);
		btnCategory.setSize(47, 39);
		btnCategory.setLocation(225, 685);

		btnCategory.setContentAreaFilled(false);
		btnCategory.setBorderPainted(false);
		btnCategory.setFocusPainted(false);
		// 장바구니 버튼
		ImageIcon cartbt = new ImageIcon("img/cart_icon.png");
		JButton btnCart = new JButton(cartbt);
		btnCart.setSize(44, 38);
		btnCart.setLocation(325, 685);

		btnCart.setContentAreaFilled(false);
		btnCart.setBorderPainted(false);
		btnCart.setFocusPainted(false);
		// 마이페이지 버튼
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

		// 찜버튼 누르면
		btnGgim.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 여기로 이동함
				FrameBase.getDispose(); // 현재 프레임 닫기
				FrameBase.getInstance(new FrameGgim(homePanel)); // 새로운 프레임으로 전환
				
			}
		});
		// 주문현황버튼 누르면
		btnOrder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getDispose(); // 현재 프레임 닫기
				FrameBase.getInstance(new FrameOrder(homePanel)); // 새로운 프레임으로 전환
			}
		});
		// 카테고리버튼 누르면
		btnCategory.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getDispose(); // 현재 프레임 닫기
				FrameBase.getInstance(new FrameCategory(homePanel)); // 새로운 프레임으로 전환
			}
		});
		// 장바구니버튼 누르면
		btnCart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getDispose(); // 현재 프레임 닫기
				FrameBase.getInstance(new FrameCart(homePanel)); // 새로운 프레임으로 전환
			}
		});
		// 마이페이지 누르면
		btnMypage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getDispose(); // 현재 프레임 닫기
				FrameBase.getInstance(new FrameMypage(homePanel)); // 새로운 프레임으로 전환
			}
		});

		ImageIcon mainBg = new ImageIcon("img/category_bg.jpg");
		JLabel lblmb = new JLabel(mainBg);
		lblmb.setSize(500, 800);
		lblmb.setLocation(0, -20);
		add(lblmb);

	}
}
