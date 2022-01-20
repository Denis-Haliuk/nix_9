package com.alevel.service.impl;

import com.alevel.persistence.entity.item.Item;
import com.alevel.persistence.entity.manufacturer.Manufacturer;
import com.alevel.persistence.repository.item.ItemRepository;
import com.alevel.persistence.repository.item.ManufacturerRepository;
import com.alevel.service.PLPService;
import com.alevel.util.WebUtil;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PLPServiceImpl implements PLPService {

    private final ItemRepository itemRepository;
    private final ManufacturerRepository manufacturerRepository;

    public PLPServiceImpl(
            ItemRepository itemRepository,
            ManufacturerRepository manufacturerRepository) {
        this.itemRepository = itemRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Item> search(Map<String, Object> queryMap) {
        if (queryMap.get(WebUtil.MANUFACTURER_PARAM) != null) {
            Long publisherId = (Long) queryMap.get(WebUtil.MANUFACTURER_PARAM);
            Optional<Manufacturer> manufacturer = manufacturerRepository.findById(publisherId);
            if (manufacturer.isEmpty()) {
                throw new EntityNotFoundException("this manufacturer not found");
            }
            return itemRepository.findByManufacturer(manufacturer.get());
        }
        if (queryMap.get(WebUtil.ITEM_SEARCH_PARAM) != null) {
            String itemName = (String) queryMap.get(WebUtil.ITEM_SEARCH_PARAM);
            return itemRepository.findByNameContaining(itemName);
        }
        return itemRepository.findAll();
    }
}
