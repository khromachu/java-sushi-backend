package edu.tpu.khromachu.sushibackend.controllers;

import edu.tpu.khromachu.sushibackend.domain.Token;
import edu.tpu.khromachu.sushibackend.domain.User;
import edu.tpu.khromachu.sushibackend.repository.TokenRepository;
import edu.tpu.khromachu.sushibackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@RestController
public class AuthController {

    @Autowired
    private UserRepository ur;

    @Autowired
    private TokenRepository tr;

    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    @GetMapping("/api/users/get/all")
    public List <User> getAllUsers(){
        System.out.println(ur.findAll().toString());
        return ur.findAll();
        }

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

    @PostMapping("/api/auth/by/pwd")
    public ResponseEntity<Map<String, Object>> authByPwd(@RequestBody Map<String, Object> authData){
        User userToAuth = ur.findUserByLoginAndPassword((String) authData.get("login"), (String) authData.get("password"));
        if (userToAuth == null) {
            return (ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null));
        }
        else if (authData.get("password") != userToAuth.getPassword()){
            tr.deleteAllByExpireAtBefore(convertToLocalDateViaInstant(new Date()));
        }
        Token newToken = new Token();
        Date today = new Date();
        UUID uniqueKey = UUID.randomUUID();

        newToken.setId(uniqueKey);
        newToken.setUserId(userToAuth);
        newToken.setExpireAt(convertToLocalDateViaInstant(addDays(today,30)));

        tr.save(newToken);

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PostMapping("/api/auth/by/token")
    public ResponseEntity<Map<String, Object>> authByToken(@RequestBody Map<String, Object> authData) {
    Token tokenInDb = tr.findTokenById(UUID.fromString((String) authData.get("token")));
    Date date = new Date();

        if (tokenInDb == null) {
            return (ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
        }
        else if (tokenInDb.getExpireAt().isAfter(convertToLocalDateViaInstant(date))) {
        Date expireDate = new Date();
        tokenInDb.setExpireAt(convertToLocalDateViaInstant(addDays(expireDate,30)));
        tr.save(tokenInDb);

        User user = tokenInDb.getUserId();
        System.out.println(user);

        return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        else {
            tr.delete(tokenInDb);
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PostMapping("/api/logout")
    public ResponseEntity<Map<String, Object>> logout(@RequestBody Map<String, Object> authData) {
        Token tokenInDb = tr.findTokenById(UUID.fromString((String) authData.get("token")));
        if (tokenInDb == null) {
            return (ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
        }
        else {
            tr.delete(tokenInDb);
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
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
