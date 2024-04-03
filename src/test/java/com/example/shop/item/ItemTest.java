package com.example.shop.item;


import com.example.shop.domain.item.Item;
import com.example.shop.repository.ItemRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.yaml")
@Transactional
public class ItemTest {
    @Autowired
    ItemRepository itemRepository;

    @Test
    @DisplayName("상품 저장 테스트")
    public void createItemTest() {

        Item item = new Item();
        item.setName("test");
        item.setInfo("test");
        item.setPrice(1000);
        item.setStock(100);

        Item savedItem = itemRepository.save(item);
    }
}
