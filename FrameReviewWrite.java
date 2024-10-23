package frame;

import DeliveryVO.Cart;
import DeliveryVO.Review;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameReviewWrite extends JPanel {

    public FrameReviewWrite(JPanel homePanel, String storeName) {
        setLayout(null);
        setSize(500, 800);

        // ���� �Ϸ� ���� Ȯ��
        if (!Cart.getInstance().isPaymentCompleted()) {
            JOptionPane.showMessageDialog(null, "������ �Ϸ��� �Ŀ��� ���並 �ۼ��� �� �ֽ��ϴ�.");
            FrameBase.getDispose();
            FrameBase.getInstance(new FrameCategory(homePanel));// ���� �ۼ� ȭ�鿡�� ����
            return;
        }
        JLabel lbl = new JLabel("���並 �ۼ����ּ���:");
        lbl.setBounds(20, 20, 200, 30);
        add(lbl);
        //���� �Է� �ʵ�
        JTextArea reviewTextArea = new JTextArea();
        reviewTextArea.setBounds(20, 60, 300, 150);
        add(reviewTextArea);
        //���� ���� ��ư Ŭ�� ��
        JButton submitButton = new JButton("���� ����");
        submitButton.setBounds(20, 220, 100, 30);
        add(submitButton);

        // ���� ���� ��ư Ŭ�� ��
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String reviewText = reviewTextArea.getText();

                // ������ �޽���
                System.out.println("���� �ۼ� ��ư Ŭ����");

                Review review = new Review();
                review.writeReview(storeName, reviewText);  // �ۼ��� ���� ����

                JOptionPane.showMessageDialog(null, "���䰡 ���������� ����Ǿ����ϴ�.");

                // ȭ�� ��ȯ
                FrameBase.getDispose();
                FrameBase.getInstance(new FrameCategory(homePanel, storeName, ""));
            }
        });
    }
}
