package edu.tpu.khromachu.sushibackend.controllers;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    //router.post('/by/pwd', async (req,res) => {
    //  try{
    //    const authData = req.body
    //    const userToAuth = await db.Users.findOne(
    //      { where: {
    //          login: authData.login,
    //          password: authData.password
    //        }
    //      })
    //    if (!userToAuth) {
    //      res.status(404).send(`Error: no user with login ${authData.login}`)
    //    }
    //    else if (authData?.password === userToAuth.password){
    //      await db.Tokens.destroy({ where: {
    //          expireAt: {[Op.lt]: new Date()}
    //        }
    //      })
    //      const expireDate = new Date()
    //      expireDate.setDate(expireDate.getDate() + 30)
    //      const token = await db.Tokens.create({
    //        userId: userToAuth.id,
    //        expireAt: expireDate
    //      })
    //      res.json({user: userToAuth, token: token.token})
    //    }
    //    else
    //      res.status(401).send('Password is incorrect')
    //  }
    //  catch (err){
    //    res.status(500).send(err.message)
    //  }
    //
    //})
    //router.post('/by/token', async (req,res) => {
    //  try{
    //    const authData = req.body
    //    const tokenInDb = await db.Tokens.findByPk(authData?.token)
    //    if (!tokenInDb) {
    //      res.status(404).send(`Error: token not found`)
    //    }
    //    else if (new Date(tokenInDb.expireAt) > new Date()) {
    //      const expireDate = new Date()
    //      expireDate.setDate(expireDate.getDate() + 30)
    //      tokenInDb.expireAt = expireDate.toISOString()
    //      await tokenInDb.save()
    //      const user = await db.Users.findByPk(tokenInDb.userId)
    //      res.send({ user, token: tokenInDb.token })
    //    }
    //    else {
    //      await tokenInDb.destroy()
    //      res.status(401).send('Token expired')
    //    }
    //  }
    //  catch (err){
    //    res.status(500).send(err.message)
    //  }
    //
    //})
    //router.post('/logout', async (req,res) => {
    //  try{
    //    const authData = req.body
    //    console.log(authData)
    //    const tokenInDb = await db.Tokens.findByPk(authData?.token)
    //    if (!tokenInDb) {
    //      res.status(404).send(`Error: token not found`)
    //    }
    //    else {
    //      await tokenInDb.destroy()
    //      res.send('Unauthorised successful')
    //    }
    //  }
    //  catch (err){
    //    res.status(500).send(err.message)
    //  }
    //
    //})
    //router.post('/register', async (req,res) => {
    //  try{
    //    const authData = req.body
    //    const user = await db.Users.create({
    //      login: authData.login,
    //      phone: authData.phone,
    //      password: authData.password,
    //      firstName: authData.firstName,
    //      secondName: authData.secondName
    //    })
    //    res.send(user)
    //  }
    //  catch (err){
    //    res.status(500).send(err.message)
    //  }
    //})
    //
    //router.post('/profile/edit', async (req,res) => {
    //  try{
    //    const authData = req.body
    //    await db.Users.update({
    //      address: authData.address,
    //      phone: authData.phone,
    //      firstName: authData.firstName,
    //      secondName: authData.secondName
    //    }, { where: { id: authData.id } })
    //    const user = await db.Users.findByPk(authData.id)
    //    res.send(user)
    //  }
    //  catch (err){
    //    res.status(500).send(err.message)
    //  }
    //})
    //
    //
    //export default router
}
