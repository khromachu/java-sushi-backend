package edu.tpu.khromachu.sushibackend.controllers;

import edu.tpu.khromachu.sushibackend.domain.Order;
import edu.tpu.khromachu.sushibackend.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OrdersController {
    @Autowired
    private OrderRepository or;

    //router.get('/get/all/:userId', async (req,res) => {
    //  try{
    //    const user = await db.Users.findByPk(req.params['userId'])
    //    if (user){
    //      const userIdOption = user.userType === 2 ? {}: { clientId: user.id }
    //      const ordersOnPage = + req.query['onPage'] || 24
    //      const pageNumber = + req.query['page'] || 1
    //      const orders = await db.Orders.findAll({
    //        order: [['createdAt', 'DESC']],
    //        limit: ordersOnPage,
    //        offset: ordersOnPage * (pageNumber - 1),
    //        where: {
    //          ...userIdOption
    //        }
    //      })
    //      const count = await db.Orders.count({ where: {
    //          ...userIdOption
    //        } })
    //      res.send({ pages: Math.ceil(count / ordersOnPage), orders })
    //    }
    //    else {
    //      res.status(401).send('Unauthorized')
    //    }
    //  }
    //  catch (err){
    //    res.status(500).send(err.message)
    //  }
    //})
    //
    //router.get('/get/by/id/:orderId', async (req,res) => {
    //  try{
    //    const order = await db.Orders.findByPk(+req.params['orderId'], {
    //      include: {
    //        model: db.Items, as: 'itemId_Items',
    //        attributes: ['id', 'name', 'show'],
    //        through: { attributes: ['cost', 'count'] }
    //      }
    //    })
    //
    //    res.send(order)
    //  }
    //  catch (err){
    //    res.status(500).send(err.message)
    //  }
    //})
    //
    //
    //router.post('/create', async (req, res) => {
    //  try{
    //    const orderData = req.body
    //    const order = await db.Orders.create({ ...orderData, items: undefined, status: 1 })
    //    const items = await db.ItemsInOrders.bulkCreate(orderData.items.map(item => {
    //      return {
    //        orderId: order.id,
    //        itemId: item.itemId,
    //        count: item.count,
    //        cost: item.cost
    //      }
    //    }))
    //    res.send(order)
    //  }
    //  catch (err){
    //    res.status(500).send(err.message)
    //  }
    //})
    //
    @PostMapping("/api/orders/updateStatus/{id}")
    public void updateOrderStatus(@PathVariable Integer id,
                           @RequestBody Map<String, Object> orderDetails){

        System.out.println(id);
        Order order = or.getById(id);

        order.setStatus((Integer)orderDetails.get("status"));

        or.save(order);
    }

    //router.get('/get/diff/:userId', async (req,res) => {
    //  try{
    //    const user = await db.Users.findByPk(req.params['userId'])
    //    if (user){
    //      const userIdOption = user.userType === 2 ? {}: { clientId: user.id }
    //      const orders = await db.Orders.findAll({
    //        order: [['createdAt', 'DESC']],
    //        attributes: ['id', 'status'],
    //        where: {
    //          ...userIdOption,
    //          status: {
    //            [Op.notIn]: [0, 5]
    //          }
    //        }
    //      })
    //
    //      res.send(orders)
    //    }
    //    else {
    //      res.status(401).send('Unauthorized')
    //    }
    //  }
    //  catch (err){
    //    res.status(500).send(err.message)
    //  }
    //})
    //
    //export default router
}
