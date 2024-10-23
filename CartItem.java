package DeliveryVO;

public class CartItem {
    //장바구니 항목 클래스
    private Menu menu; //장바구니에 들어간 메뉴
    private int quantity; //수량
    private Restaurant restaurant;

    public CartItem(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;

    }

    public CartItem(Menu menu, int quantity, Restaurant restaurant) {
        this.menu = menu;
        this.quantity = quantity;
        this.restaurant = restaurant;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }
    double getTotalPrice(){
       return menu.getPrice()*quantity;
    }

 public Restaurant getRestaurant(){
        return this.restaurant;
 }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return
                "메뉴: " + menu +"\n"+
                "수량: " + quantity;

    }
}