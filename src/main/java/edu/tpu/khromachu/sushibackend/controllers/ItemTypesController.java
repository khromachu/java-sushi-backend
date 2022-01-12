package edu.tpu.khromachu.sushibackend.controllers;

import edu.tpu.khromachu.sushibackend.domain.ItemType;
import edu.tpu.khromachu.sushibackend.repository.ItemTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemTypesController {

    @Autowired
    private ItemTypeRepository itr;

    @GetMapping("/api/item-types/get/all")
    public List<ItemType> getAllItemTypes(){
        System.out.println(itr.findAll().toString());
        return itr.findAll();
    }
}
