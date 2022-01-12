package edu.tpu.khromachu.sushibackend.controllers;

import edu.tpu.khromachu.sushibackend.domain.Item;
import edu.tpu.khromachu.sushibackend.domain.ItemType;
import edu.tpu.khromachu.sushibackend.exception.ItemNotFoundException;
import edu.tpu.khromachu.sushibackend.repository.ItemRepository;
import edu.tpu.khromachu.sushibackend.repository.ItemTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ItemsController {

    @Autowired
    private ItemRepository ir;

    @Autowired
    private ItemTypeRepository itr;

    @GetMapping("/api/items/get/all")
    public List <Item> getAllItems(
            @RequestParam(value = "onPage", required = false, defaultValue = "24") Integer itemsOnPage,
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "type", required = false, defaultValue = "1") Integer type,
            @RequestParam(value = "showAll", required = false, defaultValue = "0") Integer showAll){
        System.out.println(itr.findAll().toString());
        ItemType itemType = itr.findById(type).orElse(null);
        assert itemType != null;
        System.out.println(itemType.getType());
        if (showAll == 1){
            Page<Item> items = ir.findAllByItemTypeIdOrderByName(itemType, (Pageable) PageRequest.of(page, itemsOnPage));
            System.out.println(items.getTotalElements());
            return items.getContent();
        }
        else {
            Page<Item> items = ir.findAllByItemTypeIdAndShowTrueOrderByName(itemType, (Pageable) PageRequest.of(page, itemsOnPage));
            return items.getContent();
        }
    }

    @GetMapping("/api/items/get/by/id/")
    public Item getItemById(Integer id) {
        Optional<Item> item = ir.findById(id);
        return item.orElse(null);
    }

    @PostMapping("/api/items/create")
    public void createNote(@RequestBody Map<String, Object> item){
        System.out.println(item);
        Item newItem = new Item();
        ItemType itemType = itr.getById((Integer) item.get("itemTypeId"));

        newItem.setName((String)item.get("name"));
        newItem.setCost((double)item.get("cost"));
        newItem.setImgUrl((String)item.get("imgUrl"));
        newItem.setDescription((String)item.get("description"));
        newItem.setWeight((Integer)item.get("weight"));
        newItem.setShow((boolean)item.get("show"));
        newItem.setItemType(itemType);

        ir.save(newItem);
    }

    @PostMapping("/api/items/update/{id}")
    public void updateItem(@PathVariable Integer id,
                           @RequestBody Map<String, Object> itemDetails){

        System.out.println(id);
        Item item = ir.getById(id);

        item.setName((String)itemDetails.get("name"));
        item.setCost((double)itemDetails.get("cost"));
        item.setImgUrl((String)itemDetails.get("imgUrl"));
        item.setDescription((String)itemDetails.get("description"));
        item.setWeight((Integer)itemDetails.get("weight"));
        item.setShow((boolean)itemDetails.get("show"));
        ItemType itemType = itr.getById((Integer) itemDetails.get("itemTypeId"));
        item.setItemType(itemType);

        ir.save(item);
    }
}