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
		
		// ���侲�� ��ư
		ImageIcon bbt = new ImageIcon("img/review_write_btn.png");
		JButton btnreview= new JButton(bbt);
		btnreview.setSize(117, 35);
		btnreview.setLocation(317, 540);
		
		btnreview.setContentAreaFilled(false);
		btnreview.setBorderPainted(false);
		btnreview.setFocusPainted(false);
		add(btnreview);



		// ���侲�� ��ư
		btnreview.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ����� �޽���: ���� �ۼ� ȭ������ �̵��� �� ���� �̸� Ȯ��


				// ���� �̸��� null���� Ȯ��


				// ���� ���� Ȯ�� (��: Cart.getInstance().isPaymentCompleted() �޼��� ���)
				if (!Cart.getInstance().isPaymentCompleted()) {
					JOptionPane.showMessageDialog(null, "���並 �ۼ��Ϸ��� ������ �Ϸ��ؾ� �մϴ�.");
					return; // ������ �Ϸ���� ������ ���� �ۼ� ȭ������ �̵����� ����
				}

				// ������ �Ϸ�� ��� ���� �ۼ� ȭ������ �̵�
				FrameBase.getDispose();
				FrameBase.getInstance(new FrameReviewWrite(homePanel, name));
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
						FrameBase.getDispose();
						
						FrameBase.getInstance(new FrameGgim(homePanel,name,address));
						
					}
				});
				// �ֹ���Ȳ��ư ������
				btnOrder.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// ����� �̵���
						FrameBase.getDispose();
						FrameBase.getInstance(new FrameOrder(homePanel,name,address));
					}
				});
				// ī�װ���ư ������
				btnCategory.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// ����� �̵���
						FrameBase.getDispose();
						FrameBase.getInstance(new FrameCategory(homePanel,name,address));
					}
				});
				// ��ٱ��Ϲ�ư ������
				btnCart.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// ����� �̵���
						FrameBase.getDispose();
						FrameBase.getInstance(new FrameCart(homePanel,name,address));
					}
				});
				// ���������� ������
				btnMypage.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// ����� �̵���
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
