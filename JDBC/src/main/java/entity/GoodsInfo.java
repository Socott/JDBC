package entity;

public class GoodsInfo {
    private int catid;
    private String title;
    private double price;

    public int getCatid() {
        return catid;
    }

    public void setCatid(int catid) {
        this.catid = catid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "GoodsInfo{" +
                "catid=" + catid +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
