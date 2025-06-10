package com.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HistoryRecord {
    private static final Logger logger = LogManager.getLogger(HistoryRecord.class);

    public enum ActionType { ADD, GET }

    private ActionType actionType;
    private LocalDateTime dateTime;
    private String userName;
    private String productName;
    private String productCode;
    private double quantity;

    private static List<HistoryRecord> historyRecords = new ArrayList<>();

    public HistoryRecord(ActionType actionType, LocalDateTime dateTime, String userName,
                         String productName, String productCode, double quantity) {
        this.actionType = actionType;
        this.dateTime = dateTime;
        this.userName = userName;
        this.productName = productName;
        this.productCode = productCode;
        this.quantity = quantity;
    }

    public static List<HistoryRecord> getAllRecords() {
        return historyRecords;
    }

    public static void addRecord(HistoryRecord record) {
        historyRecords.add(record);
    }

    public static void listHistory() {
        logger.info("Үйлдлийн түүх:");
        for (HistoryRecord record : historyRecords) {
            logger.info(record.toString());
        }
    }

    @Override
    public String toString() {
        return String.format("[%s] %s: %s кодтой %s бараа %.1f ширхэг, хэрэглэгч: %s",
            dateTime, actionType == ActionType.ADD ? "Нэмсэн" : "Авсан", productCode, productName, quantity, userName);
    }
}
