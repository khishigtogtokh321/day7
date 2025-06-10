package com.example;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Inventory {
    private static final Logger logger = LogManager.getLogger(Inventory.class);
    private List<Product> products;

    public Inventory() {
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        boolean found = false;
        for (Product p : products) {
            if (p.getCode().equals(product.getCode())) {
                p.quantity += product.getQuantity();
                p.price = product.getPrice();
                found = true;
                break;
            }
        }
        if (!found) {
            products.add(product);
        }
        logger.info("Бараа амжилттай нэмэгдлээ: {} - {} - {}", product.getCode(), product.getProductName(), product.getQuantity());
    }

    public boolean getProduct(Product product) {
        String code = product.getCode();
        double quantity = product.getQuantity();

        for (Product p : products) {
            if (p.code.equals(code)) {
                if (p.quantity >= quantity) {
                    p.quantity -= quantity;
                    logger.info("{} кодтой {:.1f} ширхэг {} бараа нөөцөөс хасагдлаа.", p.code, quantity, p.productName);
                    return true;
                } else {
                    logger.warn("Хангалттай тоо ширхэг байхгүй байна: шаардлагатай = {}, байгаа = {}", quantity, p.quantity);
                    return false;
                }
            }
        }

        logger.warn("Бараа олдсонгүй: {}", code);
        return false;
    }

    public void listInventory() {
        logger.info("Нөөцийн жагсаалт:");
        for (Product p : products) {
            logger.info("- {} ({}): {:.1f} ширхэг, үнэ: {:.2f} төгрөг, нэмсэн: {}", 
                p.productName, p.code, p.quantity, p.price, p.fromName);
        }
    }
}
