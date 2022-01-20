package com.alevel.persistence.repository.item;

import com.alevel.persistence.entity.category.Category;
import com.alevel.persistence.entity.item.Item;
import com.alevel.persistence.entity.manufacturer.Manufacturer;
import com.alevel.persistence.repository.BaseRepository;

import java.util.List;

public interface ItemRepository extends BaseRepository<Item> {

    List<Item> findByManufacturer(Manufacturer manufacturer);
    List<Item> findByNameContaining(String name);
}
