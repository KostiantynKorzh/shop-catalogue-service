package me.study.catalogue_service.dto;

import lombok.Data;

@Data

public class OrderItemDTO {

    private String title;

    private Double price;

    private String imagePath;

}
