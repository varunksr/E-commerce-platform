package com.task.eCommerce.api;

import com.task.eCommerce.domain.Item;
import com.task.eCommerce.dto.ItemDTO;
import com.task.eCommerce.repository.ItemRepository;
import com.task.eCommerce.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "v1/item")
public class ItemResource {

    private final ItemRepository itemRepository;
    private final ItemService itemService;

    @Autowired
    public ItemResource(ItemRepository itemRepository,
                        ItemService itemService){
        this.itemRepository = itemRepository;
        this.itemService = itemService;
    }

    @GetMapping("{itemId}")
    public Item getItem(@PathVariable String itemId){
        return itemRepository.findByItemId(itemId);
    }

    @PostMapping("addItem")
    public Item addItem(ItemDTO itemDTO) throws Exception {
        return itemService.addItem(itemDTO);
    }

    @PutMapping("updateItem")
    public Item updateItem(ItemDTO itemDTO) throws Exception {
        return  itemService.updateItem(itemDTO);
    }

    @DeleteMapping("{itemId}")
    public Item deleteItem(@PathVariable String itemId){
        return itemRepository.deleteByItemId(itemId);
    }

    @GetMapping("getAllItems")
    public List<Item> fetchAllItems(){
        return itemRepository.findAll();
    }

}
