package DeliveryVO;

import java.io.*;
import java.util.Scanner;

public class Review {

    private String reviewSavePath = "reviews.txt"; // 모든 리뷰를 저장하는 파일


    // 리뷰 작성 메서드
    public void writeReview(String restaurantName, String reviewText) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reviewSavePath, true))) {
            System.out.println("리뷰를 저장합니다1000: " + reviewSavePath); // 경로 확인용 디버깅 메시지
            writer.write("음식점: " + restaurantName + "\n");
            writer.write("리뷰: " + reviewText + "\n");
            writer.write("----\n");
            writer.flush(); // 파일에 강제로 기록
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

            // 디버깅 메시지: 리뷰 읽기 시작
            System.out.println("리뷰 읽기 시작: " + restaurantName);

            while ((line = reader.readLine()) != null) {
                // 가게 이름을 검색 (공백 및 대소문자 무시)
                if (line.trim().equalsIgnoreCase("음식점: " + restaurantName.trim())) {
                    isRestaurantFound = true;
                    reviews.append(line).append("\n");  // 가게 이름 추가
                    continue;
                }
                if (isRestaurantFound) {
                    if (line.equals("----")) {  // 리뷰 끝을 나타내는 구분선
                        break;  // 해당 가게 리뷰가 끝나면 루프 종료
                    }
                    reviews.append(line).append("\n");  // 리뷰 내용 추가
                }
            }
        } catch (IOException e) {
            System.out.println("리뷰를 읽는 도중 오류가 발생했습니다.");
            e.printStackTrace();
        }

        // 리뷰가 없을 경우 메시지 반환
        if (reviews.length() == 0) {
            return "작성된 리뷰가 없습니다.";
        }

        // 디버깅 메시지: 읽은 리뷰 출력
        System.out.println("읽은 리뷰: " + reviews.toString());

        return reviews.toString();
    }


}


