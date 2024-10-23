package DeliveryVO;

import java.io.*;
import java.util.Scanner;

public class Review {

    private String reviewSavePath = "reviews.txt"; // ��� ���並 �����ϴ� ����


    // ���� �ۼ� �޼���
    public void writeReview(String restaurantName, String reviewText) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reviewSavePath, true))) {
            System.out.println("���並 �����մϴ�1000: " + reviewSavePath); // ��� Ȯ�ο� ����� �޽���
            writer.write("������: " + restaurantName + "\n");
            writer.write("����: " + reviewText + "\n");
            writer.write("----\n");
            writer.flush(); // ���Ͽ� ������ ���
        } catch (Exception e) {
            System.out.println("���並 �����ϴ� ���� ������ �߻��߽��ϴ�.");
        }
    }

    // Ư�� ������ ���並 �д� �޼���
    public String readReviews(String restaurantName) {
        StringBuilder reviews = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(reviewSavePath))) {
            String line;
            boolean isRestaurantFound = false;

            // ����� �޽���: ���� �б� ����
            System.out.println("���� �б� ����: " + restaurantName);

            while ((line = reader.readLine()) != null) {
                // ���� �̸��� �˻� (���� �� ��ҹ��� ����)
                if (line.trim().equalsIgnoreCase("������: " + restaurantName.trim())) {
                    isRestaurantFound = true;
                    reviews.append(line).append("\n");  // ���� �̸� �߰�
                    continue;
                }
                if (isRestaurantFound) {
                    if (line.equals("----")) {  // ���� ���� ��Ÿ���� ���м�
                        break;  // �ش� ���� ���䰡 ������ ���� ����
                    }
                    reviews.append(line).append("\n");  // ���� ���� �߰�
                }
            }
        } catch (IOException e) {
            System.out.println("���並 �д� ���� ������ �߻��߽��ϴ�.");
            e.printStackTrace();
        }

        // ���䰡 ���� ��� �޽��� ��ȯ
        if (reviews.length() == 0) {
            return "�ۼ��� ���䰡 �����ϴ�.";
        }

        // ����� �޽���: ���� ���� ���
        System.out.println("���� ����: " + reviews.toString());

        return reviews.toString();
    }


}


