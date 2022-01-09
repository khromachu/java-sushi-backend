package edu.tpu.khromachu.sushibackend.controllers;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {
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
    //router.post('/edit/status', async (req, res) => {
    //  try{
    //    const order = await db.Orders.update(
    //      { status: req.body['status'] },
    //      { where: { id: req.body['id'] } })
    //    res.send(order)
    //  }
    //  catch (err){
    //    res.status(500).send(err.message)
    //  }
    //})
    //
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
