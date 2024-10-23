package DeliveryVO;

import java.io.*;
import java.util.Scanner;

public class Review {

    private String reviewSavePath ="reviews.txt"; // ��� ���並 �����ϴ� ����



    // ���� �ۼ� �޼���
    public void writeReview(String restaurantName, String reviewText) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reviewSavePath, true))) {
            writer.write("������: " + restaurantName + "\n");
            writer.write("����: " + reviewText + "\n");
            writer.write("----\n");
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
            while ((line = reader.readLine()) != null) {
                if (line.contains("Restaurant: " + restaurantName)) {
                    isRestaurantFound = true;
                }
                if (isRestaurantFound) {
                    if (line.equals("----")) {
                        break;
                    }
                    reviews.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reviews.toString();
    }
}

