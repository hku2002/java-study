package pattern.facade.nofacade;

public class NoFacadeMain {

    public static void main(String[] args) {
        OrderServiceNoFacade orderService = new OrderServiceNoFacade();
        orderService.order();
    }
}
