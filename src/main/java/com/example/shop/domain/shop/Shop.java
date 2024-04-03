package com.example.shop.domain.shop;

import com.example.shop.domain.item.Item;
import com.example.shop.domain.user.User;
import com.example.shop.domain.util.Address;
import com.example.shop.domain.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Shop extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private Long id;

    private String name;
    private String info;

    @Embedded
    private Address address;
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> items;

    public void setUSer(User user) {
        this.user = user;
    }

    public void addItems(Item item){
        items.add(item);
    }
}
