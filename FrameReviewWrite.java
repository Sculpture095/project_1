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

        // 결제 완료 여부 확인
        if (!Cart.getInstance().isPaymentCompleted()) {
            JOptionPane.showMessageDialog(null, "결제를 완료한 후에만 리뷰를 작성할 수 있습니다.");
            FrameBase.getDispose();
            FrameBase.getInstance(new FrameCategory(homePanel));// 리뷰 작성 화면에서 나감
            return;
        }
        JLabel lbl = new JLabel("리뷰를 작성해주세요:");
        lbl.setBounds(20, 20, 200, 30);
        add(lbl);
        //리뷰 입력 필드
        JTextArea reviewTextArea = new JTextArea();
        reviewTextArea.setBounds(20, 60, 300, 150);
        add(reviewTextArea);
        //리뷰 제출 버튼 클릭 시
        JButton submitButton = new JButton("리뷰 제출");
        submitButton.setBounds(20, 220, 100, 30);
        add(submitButton);

        // 리뷰 제출 버튼 클릭 시
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String reviewText = reviewTextArea.getText();

                // 디버깅용 메시지
                System.out.println("리뷰 작성 버튼 클릭됨");

                Review review = new Review();
                review.writeReview(storeName, reviewText);  // 작성한 리뷰 저장

                JOptionPane.showMessageDialog(null, "리뷰가 성공적으로 저장되었습니다.");

                // 화면 전환
                FrameBase.getDispose();
                FrameBase.getInstance(new FrameCategory(homePanel, storeName, ""));
            }
        });
    }
}
