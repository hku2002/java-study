package pattern.facade.facade;

public class FacadeMain {

    public static void main(String[] args) {
        OrderFacade orderFacade = new OrderFacade();
        orderFacade.order();
    }
}
