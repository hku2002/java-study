package pattern.singleton.bnb;

import pattern.singleton.bnb.contents.*;

public class Bnb {

    private final Home home = Home.getInstance();
    private final Category category = Category.getInstance();
    private final Community community = Community.getInstance();

    private Bnb() {}

    private static final class BnbHolder {
        private static final Bnb BNB_INSTANCE = new Bnb();
    }

    public static Bnb getInstance() {
        return BnbHolder.BNB_INSTANCE;
    }

    public Home getHome() {
        return home;
    }

    public Category getCategory() {
        return category;
    }

    public Community getCommunity() {
        return community;
    }

}
