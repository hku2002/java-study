package pattern.singleton.bnb.contents;

public class Category {

    private Category() {}

    private static final class CategoryHolder {
        private static final Category CATEGORY_INSTANCE = new Category();
    }

    public static Category getInstance() {
        return CategoryHolder.CATEGORY_INSTANCE;
    }

    public String getLink() {
        return "/link/category";
    }

    public String getIconImgPath() {
        return "/images/category.webp";
    }

    public String getDescription() {
        return "카테고리";
    }

}
