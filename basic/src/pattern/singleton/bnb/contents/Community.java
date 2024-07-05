package pattern.singleton.bnb.contents;

public class Community {

    private Community() {}

    private static final class CommunityHolder {
        private static final Community COMMUNITY_INSTANCE = new Community();
    }

    public static Community getInstance() {
        return CommunityHolder.COMMUNITY_INSTANCE;
    }

    public String getLink() {
        return "/link/community";
    }

    public String getIconImgPath() {
        return "/images/community.webp";
    }

    public String getDescription() {
        return "커뮤니티";
    }

}
