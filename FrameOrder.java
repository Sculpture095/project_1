package frame;

import DeliveryVO.Cart;
import DeliveryVO.Restaurant;
import DeliveryVO.RestaurantDAO;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FrameOrder extends JPanel{
JPanel frameMypagePanel;
	
	public FrameOrder(JPanel homePanel,String name,String address) {
		this.frameMypagePanel = homePanel;
		setBackground(new Color(255, 255, 255));	
		setLayout(null);
		setSize(500, 800);
		
		// 리뷰쓰기 버튼
		ImageIcon bbt = new ImageIcon("img/review_write_btn.png");
		JButton btnreview= new JButton(bbt);
		btnreview.setSize(117, 35);
		btnreview.setLocation(317, 540);
		
		btnreview.setContentAreaFilled(false);
		btnreview.setBorderPainted(false);
		btnreview.setFocusPainted(false);
		add(btnreview);



		// 리뷰쓰기 버튼
		btnreview.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 디버깅 메시지: 리뷰 작성 화면으로 이동할 때 가게 이름 확인


				// 가게 이름이 null인지 확인


				// 결제 여부 확인 (예: Cart.getInstance().isPaymentCompleted() 메서드 사용)
				if (!Cart.getInstance().isPaymentCompleted()) {
					JOptionPane.showMessageDialog(null, "리뷰를 작성하려면 결제를 완료해야 합니다.");
					return; // 결제가 완료되지 않으면 리뷰 작성 화면으로 이동하지 않음
				}

				// 결제가 완료된 경우 리뷰 작성 화면으로 이동
				FrameBase.getDispose();
				FrameBase.getInstance(new FrameReviewWrite(homePanel, name));
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
						FrameBase.getDispose();
						
						FrameBase.getInstance(new FrameGgim(homePanel,name,address));
						
					}
				});
				// 주문현황버튼 누르면
				btnOrder.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// 여기로 이동함
						FrameBase.getDispose();
						FrameBase.getInstance(new FrameOrder(homePanel,name,address));
					}
				});
				// 카테고리버튼 누르면
				btnCategory.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// 여기로 이동함
						FrameBase.getDispose();
						FrameBase.getInstance(new FrameCategory(homePanel,name,address));
					}
				});
				// 장바구니버튼 누르면
				btnCart.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// 여기로 이동함
						FrameBase.getDispose();
						FrameBase.getInstance(new FrameCart(homePanel,name,address));
					}
				});
				// 마이페이지 누르면
				btnMypage.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// 여기로 이동함
						FrameBase.getDispose();
						FrameBase.getInstance(new FrameMypage(homePanel,name,address));
					}
				});
		ImageIcon mainBg = new ImageIcon("img/order_status_bg.jpg");
		JLabel lblmb = new JLabel(mainBg);
		lblmb.setSize(500, 800);
		lblmb.setOpaque(true);
		lblmb.setLocation(0, -20);
		add(lblmb);
		
	}

}
