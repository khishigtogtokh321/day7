package com.example;
import java.time.LocalDate;

public class Product {

    String fromName; //Хэн нэмсэн
    LocalDate date; //Хэзээ нэмсэн
    String productName; //Барааны нэр
    String code; //Барааны код
    double quantity; //Тоо ширхэг
    double price; //Барааны үнэ

   public Product(String fromName, String productName, String code, double quantity, double price) {
    if (fromName == null || fromName.trim().isEmpty()) {
        throw new IllegalArgumentException("Нэр хоосон байж болохгүй");
    }
    if (productName == null || productName.trim().isEmpty()) {
        throw new IllegalArgumentException("Барааны нэр хоосон байж болохгүй");
    }
    if (code == null || code.trim().isEmpty()) {
        throw new IllegalArgumentException("Барааны код хоосон байж болохгүй");
    }
    if (quantity < 0) {
        throw new IllegalArgumentException("Барааны тоо ширхэг сөрөг байж болохгүй");
    }
    if (price < 0) {
        throw new IllegalArgumentException("Барааны үнэ сөрөг байж болохгүй");
    }

    this.fromName = fromName;
    this.productName = productName;
    this.code = code;
    this.quantity = quantity;
    this.price = price;
    this.date = LocalDate.now();
}

    public String getFromName() {  return fromName;}
    public LocalDate getDate() {   return date;}
    public String getProductName() {   return productName;}
    public String getCode() {   return code;}
    public double getQuantity() {   return quantity;}
    public double getPrice() {   return price;}

}