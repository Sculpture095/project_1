package DeliveryVO;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    //장바구니 클래스
    private List<CartItem> cartItems;

    public Cart() {
        this.cartItems = new ArrayList<>();

    }
    //장바구니에 메뉴 추가
    void addItems(Menu menu, int quantity){
        cartItems.add(new CartItem(menu,quantity));
    }
    //장바구니의 메뉴 합산
    double getTotalPrice(){
        double total = 0;
        for(CartItem item : cartItems){
            total += item.getTotalPrice();
        }
        return total;
    }
    void showAllCart(){
        if(cartItems.isEmpty()){
            System.out.println("장바구니가 비어있습니다."); //추후 비어있는 사진으로 수정
        }else {
            for(CartItem item:cartItems){
                System.out.println(item); //추후 장바구니 페이지에 넣을 예정
            }
        }
    }
    void clearCart(){
        cartItems.clear();
    }


}
