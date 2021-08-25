package me.study.catalogue_service.dto.request;

import java.util.LinkedList;
import java.util.List;

public record NewItemRequest(String title, Double price, String imagePath, List<Long> categoryIds) {
    public NewItemRequest {
        if (categoryIds == null) {
            categoryIds = new LinkedList<>();
        }
    }
}
