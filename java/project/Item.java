package project;

import java.util.Objects;

public class Item {
	private String IID;
	private String product;
    private Double price;

    public Item(String IID, String product, Double price) {
    	this.IID = IID;
        this.product = product;
        this.price = price;
    }
    public String getIID() {
        return IID;
    }
    public void setIID(String IID) {
        this.IID = IID;
    }
    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return IID + " - " + product + " - " + price;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return IID.equals(item.IID) && product.equals(item.product) && price.equals(item.price);
    }
    @Override
    public int hashCode() {
        return Objects.hash(IID, product, price);
    }
}
