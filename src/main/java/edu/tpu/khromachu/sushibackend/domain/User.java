package edu.tpu.khromachu.sushibackend.domain;

import javax.persistence.*;

@Entity
@Table(name = "Users", indexes = {
        @Index(name = "users_login_uindex", columnList = "login", unique = true),
        @Index(name = "users_usertype_index", columnList = "userType"),
        @Index(name = "users_phone_uindex", columnList = "phone", unique = true)
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "login", nullable = false)
    private String login;

    @Lob
    @Column(name = "password", nullable = false)
    private String password;

    @Lob
    @Column(name = "phone")
    private String phone;

    @Column(name = "userType", nullable = false)
    private Integer userType;

    @Lob
    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Lob
    @Column(name = "secondName")
    private String secondName;

    @Lob
    @Column(name = "address")
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}