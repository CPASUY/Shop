package model;
import exceptions.NoAgeException;
import exceptions.NormativeException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ShopTest {
	private Client client;
	private String type;
	private String number;
	private Shop shop;
	public void setupStage1() {
		String name="Mi Barrio Te Quiere";
		shop=new Shop (name);
		type="Identification";
		number="1193033579";
		client = new Client (type,number);
	}
	public void setupStage2() {
		String name="Mi Barrio Te Quiere";
		shop=new Shop (name);
		type="Cedula";
		number="1193033569";
		client = new Client (type,number);
	}
	public void setupStage3() {
		String name="Mi Barrio Te Quiere";
		shop=new Shop (name);
		type="Pasaporte";
		number="1193033539";
		client = new Client (type,number);
	}
	@Test
	void testAllowEntry1 () {
		setupStage1();
		try {
		shop.allowEntry(type,number);
		assertTrue(false);
		fail();
		}catch(NoAgeException e) {
			assertTrue(true);
		}catch(NormativeException e) {
			fail();
		}
	}
	@Test
	void testAllowEntry2() {
		setupStage2();
		try {
			shop.allowEntry(type,number);
			assertTrue(!type.equals(Client.CI));
			assertTrue(true);
		}catch(NoAgeException e) {
			fail();
		}catch(NormativeException e) {
			fail();
		}
	}
	@Test
	void testAllowEntry3() {
		setupStage3();
		try {
			shop.allowEntry(type,number);
			assertTrue(!type.equals(Client.CI));
			assertTrue(false);
		}catch(NoAgeException e) {
			fail();
		}catch(NormativeException e) {
			assertTrue(true);
		}
	}
	

}
