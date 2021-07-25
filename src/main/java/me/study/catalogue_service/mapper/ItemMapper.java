package me.study.catalogue_service.mapper;

import me.study.catalogue_service.dto.ItemDTO;
import me.study.catalogue_service.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    //    @Mapping(target = "password", ignore = true)
    @Mapping(target = "createdAt", source = "createdAt",
            dateFormat = "dd-MM-yyyy HH:mm:ss")
    ItemDTO toDTO(Item item);

    @Mapping(target="createdAt", source = "createdAt",
            dateFormat = "dd-MM-yyyy HH:mm:ss")
    List<ItemDTO> map(List<Item> items);
}

