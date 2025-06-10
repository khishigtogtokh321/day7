package com.example;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetProduct {
   private static final Logger logger = LogManager.getLogger(GetProduct.class);

   public Product getProduct() {
        Scanner read = new Scanner(System.in);

        System.out.print("Авж буй хүний нэр: ");
        String fName = read.nextLine();
        if (fName.trim().isEmpty()) {
            logger.error("Хэрэглэгчийн нэр хоосон байна.");
            throw new IllegalArgumentException("Хэрэглэгчийн нэр хоосон байж болохгүй.");
        }

        System.out.print("Барааны нэр: ");
        String pName = read.nextLine();
        if (pName.trim().isEmpty()) {
            logger.error("Барааны нэр хоосон байна.");
            throw new IllegalArgumentException("Барааны нэр хоосон байж болохгүй.");
        }

        System.out.print("Барааны код: ");
        String code = read.nextLine();
        if (code.trim().isEmpty()) {
            logger.error("Барааны код хоосон байна.");
            throw new IllegalArgumentException("Барааны код хоосон байж болохгүй.");
        }
        if (code.length() == 3) {
            char firstChar = code.charAt(0);
            char secondChar = code.charAt(1);
            char thirdChar = code.charAt(2);
            if (!Character.isLetter(firstChar) || !Character.isDigit(secondChar) || !Character.isDigit(thirdChar)) {
                logger.error("Бар код буруу байна.");
                throw new IllegalArgumentException("Барааны код буруу байна.");
            }
        } else {
            logger.error("Бар код буруу байна.");
            throw new IllegalArgumentException("Барааны код буруу байна.");
        }

        System.out.print("Тоо ширхэг: ");
        double quantity = read.nextDouble();
        if (quantity < 0) {
            logger.error("Тоо ширхэг сөрөг байна.");
            throw new IllegalArgumentException("Тоо ширхэг сөрөг байж болохгүй.");
        }

        double MAX = 50.0;
        if (quantity > MAX) {
            logger.error("Тоо ширхэг хэтэрсэн.");
            throw new IllegalArgumentException("Тоо ширхэг хэтэрсэн.");
        }

        System.out.print("Барааны үнэ: ");
        double price = read.nextDouble();
        if (price < 0) {
            logger.error("Үнэ сөрөг байна.");
            throw new IllegalArgumentException("Үнэ сөрөг байж болохгүй.");
        }

        return new Product(fName, pName, code, quantity, price);
    }
}
