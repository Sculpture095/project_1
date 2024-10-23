package frame.foodcategory;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import frame.FrameBase;
import frame.FrameCart;
import frame.FrameCategory;
import frame.FrameGgim;
import frame.FrameMypage;
import frame.FrameOrder;

public class FrameMeat extends JPanel{
JPanel frameMeatPanel;
	
	public FrameMeat(JPanel homePanel) {
		this.frameMeatPanel = homePanel;
		setBackground(new Color(255, 255, 255));	
		setLayout(null);
		setSize(500, 800);
		
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

		// 찜 버튼 누르면
		btnGgim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 찜 화면으로 전환
				FrameBase.getDispose();
				FrameBase.getInstance(new FrameGgim(homePanel));
			}
		});

		// 주문현황 버튼 누르면
		btnOrder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 주문 현황 화면으로 전환
				FrameBase.getDispose();
				FrameBase.getInstance(new FrameOrder(homePanel));
			}
		});

		// 장바구니 버튼 누르면
		btnCart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 장바구니 화면으로 전환
				FrameBase.getDispose();
				FrameBase.getInstance(new FrameCart(homePanel));
			}
		});

		// 마이페이지 버튼 누르면
		btnMypage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 마이페이지 화면으로 전환
				FrameBase.getDispose();
				FrameBase.getInstance(new FrameMypage(homePanel));
			}
		});
		ImageIcon mainBg = new ImageIcon("img/list_8_bg.jpg");
		JLabel lblmb = new JLabel(mainBg);
		lblmb.setSize(500, 800);
		lblmb.setLocation(0, -20);
		add(lblmb);
		
	}
}
