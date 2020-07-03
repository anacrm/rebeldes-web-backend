package com.anacrm.rebeldeswebbackend;

import com.anacrm.rebeldeswebbackend.model.Inventory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class InventoryTest {
    @Test
    void testGetPoints() {
        Inventory inventory = getTestInventory();
        assertThat(inventory.getPoints()).isEqualTo(20);
    }

    @Test
    void testAdd(){
        Inventory inventory = getTestInventory();
        Inventory inventory2 = getTestInventory();

        inventory.add(inventory2);
        assertThat(inventory.getWeapons()).isEqualTo(2);
        assertThat(inventory.getAmmo()).isEqualTo(4);
        assertThat(inventory.getWater()).isEqualTo(6);
        assertThat(inventory.getFood()).isEqualTo(8);
    }

    @Test
    void testSubtract(){
        Inventory inventory = getTestInventory();
        Inventory inventory2 = getTestInventory();

        inventory.subtract(inventory2);
        assertThat(inventory.getWeapons()).isEqualTo(0);
        assertThat(inventory.getAmmo()).isEqualTo(0);
        assertThat(inventory.getWater()).isEqualTo(0);
        assertThat(inventory.getFood()).isEqualTo(0);
    }

    private Inventory getTestInventory() {
        return new Inventory(1,2,3,4);
    }
}


