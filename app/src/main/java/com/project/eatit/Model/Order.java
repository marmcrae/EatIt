package com.project.eatit.Model;

public class Order {
    private String ProduceId;
    private String ProduceName;
    private String Quantity;
    private String Price;
    private String Discount;


    public Order() {

    }


    public Order(String produceId, String produceName, String quantity, String price, String discount) {
        ProduceId = produceId;
        ProduceName = produceName;
        Quantity = quantity;
        Price = price;
        Discount = discount;
    }

    public String getProduceId() {
        return ProduceId;
    }

    public void setProduceId(String produceId) {
        ProduceId = produceId;
    }

    public String getProduceName() {
        return ProduceName;
    }

    public void setProduceName(String produceName) {
        ProduceName = produceName;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }
}
