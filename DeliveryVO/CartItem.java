package DeliveryVO;

public class CartItem {
    //장바구니 항목 클래스
    private Menu menu; //장바구니에 들어간 메뉴
    private int quantity; //수량

    public CartItem(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
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

    @Override
    public String toString() {
        return
                "메뉴: " + menu +"\n"+
                "수량: " + quantity;

    }
}
