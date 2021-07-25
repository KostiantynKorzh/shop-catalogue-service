package me.study.catalogue_service.dto;

import lombok.Data;

import java.util.Date;

@Data

public class ItemDTO {

    private Long id;

    private String title;

    private Double price;

    private String imagePath;

    private String createdAt;

}
