package edu.tpu.khromachu.sushibackend.controllers;

import edu.tpu.khromachu.sushibackend.domain.Item;
import edu.tpu.khromachu.sushibackend.domain.ItemType;
import edu.tpu.khromachu.sushibackend.repository.ItemRepository;
import edu.tpu.khromachu.sushibackend.repository.ItemTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ItemsController {

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

    @Autowired
    private ItemRepository ir;
    @Autowired
    private ItemTypeRepository itr;

    @GetMapping("/api/items/get/by/id/")
    public Item getItemById(Integer id) {
        Optional<Item> item = ir.findById(id);
        return item.orElse(null);
    }

    //@PostMapping("/api/items/post/create")
    //public Item (){

    //}
    //router.post('/create', async (req, res) => {
    //  try{
    //    const newItem = await db.Items.create(req.body)
    //    res.send(newItem)
    //  }
    //  catch (err){
    //    res.status(500).send(err.message)
    //  }
    //})
    //

    //@PostMapping("/api/items/post/edit")
    //router.post('/edit', async (req, res) => {
    //  try{
    //    const newAttrs = { ...req.body, id: undefined }
    //    const item = await db.Items.update(newAttrs, { where: {id: req.body['id']} })
    //    res.send(item)
    //  }
    //  catch (err){
    //    res.status(500).send(err.message)
    //  }
    //})
    //
    //export default router
}
