package DeliveryVO;

import java.io.*;
import java.util.Scanner;

public class Review {

    private String reviewSave ="reviews.txt"; // 모든 리뷰를 저장하는 파일

    Scanner scan = new Scanner(System.in);

    // 리뷰 작성 메서드
    public void writeReview(String storeName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reviewSave, true))) {
            System.out.println("리뷰를 입력하세요:");
            String reviewText = scan.nextLine();
            writer.write("가게: " + storeName + "\n리뷰: " + reviewText + "\n----\n");
        } catch (Exception e) {
            System.out.println("리뷰를 저장하는 도중 오류가 발생했습니다.");
        }
    }

    // 특정 가게의 리뷰를 읽는 메서드
    void readReviews(String storeName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(reviewSave))) {
            String line;
            boolean storeFound = false;
            while ((line = reader.readLine()) != null) {
                if (line.contains("가게: " + storeName)) {
                    storeFound = true;
                    System.out.println(line); // 가게 정보 출력
                    while ((line = reader.readLine()) != null && !line.equals("----")) {
                        System.out.println(line); // 리뷰 내용 출력
                    }
                    System.out.println("--------------------");
                }
            }
            if (!storeFound) {
                System.out.println(storeName + "에 대한 리뷰가 없습니다.");
            }
        } catch (Exception e) {
            System.out.println("리뷰를 읽는 도중 오류가 발생했습니다.");
        }
    }
}
