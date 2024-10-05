package com.struggles_hovel.SH_backend;
import java.util.List;
import java.util.Map;

public class UploadCardsRequest {
    private List<Map<String, Integer>> cardList;
    private String username;

    // Getters and setters
    public List<Map<String, Integer>> getCardList() {
        return cardList;
    }

    public void setCardList(List<Map<String, Integer>> cardList) {
        this.cardList = cardList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
