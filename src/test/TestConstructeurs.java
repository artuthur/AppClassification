package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.Iris;
import main.Pokemon;
import main.Titanic;

public class TestConstructeurs {

	@Test
	public void test_Pokemon() {
		Pokemon p = new Pokemon("test", 120, 145, 19.0, 18, 12, 123, 14, 15, "", "", 16.0, false);
		assertEquals("test", p.name);
		assertEquals(120, p.attack);
		assertEquals(145, p.baseEggSteps);
		assertTrue(19.0 == p.captureRate);
		assertEquals(18, p.defense);
		assertEquals(12, p.experienceGrowth);
		assertEquals(123, p.hp);
		assertEquals(14, p.spAttack);
		assertEquals(15, p.spDefense);
		assertEquals("", p.type1);
		assertEquals("", p.type2);
		assertTrue(16.0 == p.speed);
		assertFalse(p.isLegendary);
	}

	@Test
	public void test_Iris() {
		Iris i = new Iris(1.0, 2.0, 3.0, 4.0, "Setosa");
		assertTrue(1.0 == i.sepalLength);
		assertTrue(2.0 == i.sepalWidth);
		assertTrue(3.0 == i.petalLength);
		assertTrue(4.0 == i.petalWidth);
		assertEquals("Setosa", i.variety);
		
		assertTrue(1.0 == i.getSepalLength());
		assertTrue(2.0 == i.getSepalWidth());
		assertTrue(3.0 == i.getPetalLength());
		assertTrue(4.0 == i.getPetalWidth());
		assertEquals("Setosa", i.getVariety());
	}
	
	@Test
	public void test_Titanic() {
		Titanic t = new Titanic(1, true, 2, "test", "male", 20.0, 2, 4, "azerty", 5.0, "cabin", 'a');
		assertEquals(1, t.passengerId);
		assertTrue(t.survived);
		assertEquals(2, t.pClass);
		assertEquals("test", t.name);
		assertEquals("male", t.sex);
		assertTrue(20.0 == t.age );
		assertEquals(2, t.sibSp);
		assertEquals(4, t.parch);
		assertEquals("azerty", t.ticket);
		assertTrue(5.0 == t.fare);
		assertEquals("cabin", t.cabin);
		assertEquals('a', t.embarked);
	}
	
}
