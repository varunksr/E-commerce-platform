package com.task.eCommerce.service;

import com.task.eCommerce.domain.Item;
import com.task.eCommerce.dto.ItemDTO;
import com.task.eCommerce.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }


    public Item addItem(ItemDTO itemDTO) throws Exception {
        if(itemRepository.findByItemCode(itemDTO.getItemCode()).isPresent()){
            throw new Exception("Item already present with itemCode");
        } else {
            Item item = new Item();
            item.setItemId(UUID.randomUUID().toString());
            item.setItemName(itemDTO.getItemName());
            item.setInStock(itemDTO.getInStock());
            item.setPrice(itemDTO.getPrice());

            return itemRepository.save(item);
        }
    }

    public Item updateItem(ItemDTO itemDTO) throws Exception {

        Optional<Item> item = itemRepository.findByItemCode(itemDTO.getItemCode());
        if(item.isPresent()){
            Item updatedItem = mapToItem(itemDTO, item.get());

            return itemRepository.save(updatedItem);
        }else {
            throw new Exception("No Item present for Item code mentioned");
        }
    }

    private Item mapToItem(ItemDTO itemDTO, Item item){
        if(itemDTO.getInStock() != null){
            item.setInStock(itemDTO.getInStock());
        }

        if(itemDTO.getItemName() != null){
            item.setItemName(itemDTO.getItemName());
        }

        if(itemDTO.getPrice() != null){
            item.setPrice(itemDTO.getPrice());
        }

        return item;
    }
}
