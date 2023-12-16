package pattern.facade.service;

import pattern.facade.model.Stock;

public class StockService {

    public void stockDeduct(Stock stock, int quantity) {
        stock.deductQuantity(quantity);
    }

}
