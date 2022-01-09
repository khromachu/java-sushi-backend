package edu.tpu.khromachu.sushibackend.controllers;

import edu.tpu.khromachu.sushibackend.domain.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemsController {

    @GetMapping("/api/items/get/all")
    public List <Item> getAllItems(
            @RequestParam(value = "onPage", required = false, defaultValue = "24") Integer onPage,
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "type", required = false, defaultValue = "1") Integer type,
            @RequestParam(value = "showAll", required = false, defaultValue = "0") Integer showAll)
            //let showOption = showAll === 1 ? {}: {show: true}
            // const items = await db.Items.findAll({
            //      order: ['name'],
            //      limit: itemsOnPage,
            //      offset: itemsOnPage * (pageNumber - 1),
            //      where: {
            //        itemTypeId: itemType,
            //        ...showOption
    {
        //const count = await db.Items.count({ where: { itemTypeId: itemType, ...showOption } })
        //res.send({ pages: Math.ceil(count / itemsOnPage), items })
    }
    @GetMapping("/api/items/get/by/id/")
    //router.get('/get/by/id/:itemId', async (req, res) => {
    //  try{
    //    const item = await db.Items.findByPk(req.params['itemId'])
    //    res.send(item)
    //  }
    //  catch (err){
    //    res.status(500).send(err.message)
    //  }
    //})
    //
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
