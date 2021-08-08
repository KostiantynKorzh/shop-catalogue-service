package me.study.catalogue_service.repository;

import me.study.catalogue_service.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByIdIn(List<Long> ids);
}
