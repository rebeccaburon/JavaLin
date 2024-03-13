package app.entities;

public class Items {

    private int itemId;
    private String brand;
    private String titel;
    private String body;
    private int price;

    public Items(int itemId, String brand, String titel, String body, int price) {
        this.itemId = itemId;
        this.brand = brand;
        this.titel = titel;
        this.body = body;
        this.price = price;
    }

    public Items(int itemId, String brand, String titel, int price) {
        this.itemId = itemId;
        this.brand = brand;
        this.titel = titel;
        this.price = price;
    }

    public int getItemId() {
        return itemId;
    }

    public String getBrand() {
        return brand;
    }

    public String getTitel() {
        return titel;
    }

    public String getBody() {
        return body;
    }

    public int getPrice() {
        return price;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

