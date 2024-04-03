package com.example.shop.domain.item;

import com.example.shop.domain.shop.Shop;
import com.example.shop.domain.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.util.ArrayList;

@Entity
@Getter @Setter
public class Item extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private String info;
    private int stock;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "item_image_id")
    @NotFound(action= NotFoundAction.IGNORE)
    private ItemImage itemImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_review_id")
    @NotFound(action=NotFoundAction.IGNORE)
    private ItemReview itemReview;

    public void setItemImage(ItemImage image) {
        this.itemImage = image;
    }

    public void setItemReview(ItemReview review) {
        this.itemReview = review;
    }
}
