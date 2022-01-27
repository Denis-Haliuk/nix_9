package com.alevel.service;

import com.alevel.persistence.datatable.DataTableResponse;
import com.alevel.persistence.entity.category.Category;
import com.alevel.persistence.entity.item.Item;
import com.alevel.persistence.entity.manufacturer.Manufacturer;

import java.util.Optional;
import java.util.Set;


public interface ItemService extends BaseCrudService<Item> {

    DataTableResponse<Item> findByManufacturer(Manufacturer manufacturer);
    DataTableResponse<Item> findByCategories(Long categoriesId);


}
