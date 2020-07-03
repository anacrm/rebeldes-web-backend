package com.anacrm.rebeldeswebbackend;

import com.anacrm.rebeldeswebbackend.model.Inventory;
import com.anacrm.rebeldeswebbackend.model.Location;
import com.anacrm.rebeldeswebbackend.model.Rebel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;


@SpringBootTest
public class RebelTest {
    @Test
    void testHasValidId() {
        Rebel rebel = getTestRebel();

        assertThat(rebel.getId()).isGreaterThan(0);
    }

    @Test
    void testSetLocation(){

        Rebel rebel = getTestRebel();

        Location newLocation = new Location(44f,14f,"Joao pessoa");

        rebel.setLocation(newLocation);

        assertThat(rebel.getLocation()).isEqualTo(newLocation);
    }

    @Test
    void testAddReport(){
        Rebel rebel = getTestRebel();

        assertThat(rebel.isTraitor()).isFalse();
        rebel.addReport();
        assertThat(rebel.isTraitor()).isFalse();
        rebel.addReport();
        assertThat(rebel.isTraitor()).isFalse();
        rebel.addReport();
        assertThat(rebel.isTraitor()).isTrue();
    }

    private Rebel getTestRebel() {

        Location location = new Location(58f, 87f, "Campina Grande");
        Inventory inventory = new Inventory(5, 2, 0, 1);
        return new Rebel("Ana", 29, "F", location, inventory);
    }

}
