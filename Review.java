package DeliveryVO;

import java.io.*;
import java.util.Scanner;

public class Review {

    private String reviewSavePath ="reviews.txt"; // 모든 리뷰를 저장하는 파일



    // 리뷰 작성 메서드
    public void writeReview(String restaurantName, String reviewText) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reviewSavePath, true))) {
            writer.write("음식점: " + restaurantName + "\n");
            writer.write("리뷰: " + reviewText + "\n");
            writer.write("----\n");
        } catch (Exception e) {
            System.out.println("리뷰를 저장하는 도중 오류가 발생했습니다.");
        }
    }

    // 특정 가게의 리뷰를 읽는 메서드
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

