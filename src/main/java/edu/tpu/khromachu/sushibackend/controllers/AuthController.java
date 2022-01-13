package edu.tpu.khromachu.sushibackend.controllers;

import edu.tpu.khromachu.sushibackend.bean.JsonResult;
import edu.tpu.khromachu.sushibackend.domain.Item;
import edu.tpu.khromachu.sushibackend.domain.ItemType;
import edu.tpu.khromachu.sushibackend.domain.User;
import edu.tpu.khromachu.sushibackend.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class AuthController {

    static Map<Integer, User> users = Collections.synchronizedMap(new HashMap<Integer, User>());

    @Autowired
    private UserRepository ur;

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

    @PostMapping("/api/users/register")
    public void Register(@RequestBody Map<String, Object> user) {
        System.out.println(user);
        User newUser = new User();

        newUser.setAddress((String) user.get("address"));
        newUser.setFirstName((String) user.get("firstName"));
        newUser.setLogin((String) user.get("login"));
        newUser.setPassword((String) user.get("password"));
        newUser.setPhone((String) user.get("phone"));
        newUser.setSecondName((String) user.get("secondName"));
        newUser.setUserType((Integer) user.get("userType"));

        ur.save(newUser);
    }

    @PostMapping("/api/users/editProfile/{id}")
    public void editProfile(@PathVariable Integer id,
                           @RequestBody Map<String, Object> userDetails){

        System.out.println(id);
        User user = ur.getById(id);

        user.setAddress((String)userDetails.get("address"));
        user.setFirstName((String)userDetails.get("firstName"));
        user.setLogin((String)userDetails.get("login"));
        user.setPassword((String)userDetails.get("password"));
        user.setPhone((String)userDetails.get("phone"));
        user.setSecondName((String)userDetails.get("secondName"));
        user.setUserType((Integer)userDetails.get("userType"));

        ur.save(user);
    }
}
