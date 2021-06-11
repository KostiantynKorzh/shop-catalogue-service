package me.study.catalogue_service.mapper;

import me.study.catalogue_service.dto.ItemDTO;
import me.study.catalogue_service.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    //    @Mapping(target = "password", ignore = true)
    ItemDTO toDTO(Item item);
    List<ItemDTO> map(List<Item> items);
}

