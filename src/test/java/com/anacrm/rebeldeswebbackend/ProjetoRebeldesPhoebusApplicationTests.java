package com.anacrm.rebeldeswebbackend;

import com.anacrm.rebeldeswebbackend.controller.RebelController;
import com.anacrm.rebeldeswebbackend.model.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProjetoRebeldesPhoebusApplicationTests {

	@Autowired
	private RebelController rebelController;


	@Test
	@Order(1)
	void contextLoads() {
		assertThat(this.rebelController).isNotNull();
	}

	@Test
	@Order(2)
	void test404UpdateLocation() {
		Location location = new Location(47f,44f,"Campina Grande");

		ResponseStatusException exception= Assertions.assertThrows(ResponseStatusException.class,()->{
			rebelController.updateLocation(1,location);
		});
		assertThat(exception.getStatus()).isEqualTo(HttpStatus.NOT_FOUND);
		assertThat(exception.getReason()).isEqualTo( "Rebel not found");
	}

	@Test
	@Order(3)
	void test404ReportRebel() {


		ResponseStatusException exception= Assertions.assertThrows(ResponseStatusException.class,()->{
			rebelController.reportRebel(1);
		});
		assertThat(exception.getStatus()).isEqualTo(HttpStatus.NOT_FOUND);
		assertThat(exception.getReason()).isEqualTo( "Rebel not found");

	}

	@Test
	@Order(4)
	void test404Negotiate() {

		Inventory buyerOffer = new Inventory(1,2,3,4);
		Inventory buyerSeller = new Inventory(4,3,2,1);

		Negotiation negotiation = new Negotiation(1,buyerOffer,2,buyerSeller);
		ResponseStatusException exception= Assertions.assertThrows(ResponseStatusException.class,()->{
			rebelController.negotiate(negotiation);
		});
		assertThat(exception.getStatus()).isEqualTo(HttpStatus.NOT_FOUND);
		assertThat(exception.getReason()).isEqualTo( "Rebel not found");

	}

	@Test
	@Order(5)
	void testCreateRebelOk() {

		Location location = new Location(58f, 87f, "Campina Grande");
		Inventory inventory1 = new Inventory(4, 0, 0, 0);
		Inventory inventory2 = new Inventory(0, 6, 0, 0);
		Inventory inventory3 = new Inventory(0, 0, 12, 0);
		Inventory inventory4= new Inventory(0, 0, 0, 18);
		Rebel rebel1 = new Rebel("Ana", 29, "F", location, inventory1);
		Rebel rebel2 = new Rebel("Carolina", 29, "F", location, inventory2);
		Rebel rebel3 = new Rebel("Medeiros", 29, "F", location, inventory3);
		Rebel rebel4 = new Rebel("Reis", 29, "F", location, inventory4);

		rebelController.createRebel(rebel1);
		assertThat(rebelController.all().size()).isEqualTo(1);

		rebelController.createRebel(rebel2);
		assertThat(rebelController.all().size()).isEqualTo(2);

		rebelController.createRebel(rebel3);
		assertThat(rebelController.all().size()).isEqualTo(3);

		rebelController.createRebel(rebel4);
		assertThat(rebelController.all().size()).isEqualTo(4);
	}

	@Test
	@Order(6)
	void testNegotiateWithDifferentPoints() {

		Inventory buyerOffer = new Inventory(1,0,0,0);
		Inventory buyerSeller = new Inventory(0,0,0,1);
		Negotiation negotiation = new Negotiation(1,buyerOffer,4,buyerSeller);
		ResponseStatusException exception= Assertions.assertThrows(ResponseStatusException.class,()->{
			rebelController.negotiate(negotiation);
		});
		assertThat(exception.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST);
		assertThat(exception.getReason()).isEqualTo("Can't negotiate offers with different points");

	}

	@Test
	@Order(7)
	void testReportRebelOk() {

		Rebel rebel = rebelController.reportRebel(1);
		assertThat(rebel.isTraitor()).isFalse();
		rebelController.reportRebel(1);
		assertThat(rebel.isTraitor()).isFalse();
		rebelController.reportRebel(1);
		assertThat(rebel.isTraitor()).isTrue();
	}

	@Test
	@Order(8)
	void testNegotiateWithTraitors() {
		Inventory buyerOffer = new Inventory(1,0,0,0);
		Inventory buyerSeller = new Inventory(0,0,0,4);

		Negotiation negotiation = new Negotiation(1,buyerOffer,4,buyerSeller);
		ResponseStatusException exception= Assertions.assertThrows(ResponseStatusException.class,()->{
			rebelController.negotiate(negotiation);
		});
		assertThat(exception.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST);
		assertThat(exception.getReason()).isEqualTo("Can't negotiate offers with traitors");

	}

	@Test
	@Order(9)
	void testUpdateLocationOk() {
		Location location = new Location(77f, 54f, "Patos");
		Rebel rebel = rebelController.updateLocation(2,location);
		assertThat(rebel.getLocation()).isEqualTo(location);
	}

	@Test
	@Order(10)
	void testReportsOk() {

		Report report = rebelController.completeReport();
		assertThat(report.getTraitors()).isEqualTo(0.25f);
		assertThat(report.getRebels()).isEqualTo(0.75f);
		assertThat(report.getAverageWeapons()).isEqualTo(0f);
		assertThat(report.getAverageAmmo()).isEqualTo(2f);
		assertThat(report.getAverageWater()).isEqualTo(4f);
		assertThat(report.getAverageFood()).isEqualTo(6f);
		assertThat(report.getLostPoints()).isEqualTo(16);
	}

	@Test
	@Order(11)
	void testNegotiateOk() {

		Inventory buyerOffer = new Inventory(0,2,0,0);
		Inventory sellerOffer = new Inventory(0,0,0,6);

		Negotiation negotiation = new Negotiation(2,buyerOffer,4,sellerOffer);

		Rebel rebel = rebelController.negotiate(negotiation);

		assertThat(rebel.getInventory().getFood()).isEqualTo(6);
		assertThat(rebel.getInventory().getAmmo()).isEqualTo(4);
	}







}
