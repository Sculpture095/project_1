package DeliveryVO;

import java.io.*;
import java.util.Scanner;

public class Review {

    private String reviewSave ="reviews.txt"; // ��� ���並 �����ϴ� ����

    Scanner scan = new Scanner(System.in);

    // ���� �ۼ� �޼���
    public void writeReview(String storeName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reviewSave, true))) {
            System.out.println("���並 �Է��ϼ���:");
            String reviewText = scan.nextLine();
            writer.write("����: " + storeName + "\n����: " + reviewText + "\n----\n");
        } catch (Exception e) {
            System.out.println("���並 �����ϴ� ���� ������ �߻��߽��ϴ�.");
        }
    }

    // Ư�� ������ ���並 �д� �޼���
    void readReviews(String storeName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(reviewSave))) {
            String line;
            boolean storeFound = false;
            while ((line = reader.readLine()) != null) {
                if (line.contains("����: " + storeName)) {
                    storeFound = true;
                    System.out.println(line); // ���� ���� ���
                    while ((line = reader.readLine()) != null && !line.equals("----")) {
                        System.out.println(line); // ���� ���� ���
                    }
                    System.out.println("--------------------");
                }
            }
            if (!storeFound) {
                System.out.println(storeName + "�� ���� ���䰡 �����ϴ�.");
            }
        } catch (Exception e) {
            System.out.println("���並 �д� ���� ������ �߻��߽��ϴ�.");
        }
    }
}
