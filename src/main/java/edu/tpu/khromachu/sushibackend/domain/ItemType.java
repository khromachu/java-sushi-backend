package edu.tpu.khromachu.sushibackend.domain;

import javax.persistence.*;

@Entity
@Table(name = "ItemTypes", indexes = {
        @Index(name = "itemtypes_type_uindex", columnList = "type", unique = true),
        @Index(name = "itemtypes_urlname_uindex", columnList = "urlName", unique = true)
})
public class ItemType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "type")
    private String type;

    @Lob
    @Column(name = "urlName", nullable = false)
    private String urlName;

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}