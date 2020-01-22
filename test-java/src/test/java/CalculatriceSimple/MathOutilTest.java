package CalculatriceSimple;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.condition.EnabledOnOs;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class MathOutilTest {
	MathOutil mathoutil;
	
	@BeforeEach
	void Initialisation() {
		mathoutil = new MathOutil();
	}
	
	@AfterEach
	void Nettoyage() {
		System.out.println("Nettoyage..........");
	}
	
	@Test
	@Tag("Math")
	@DisplayName("Le test Addition")
	void TestAddition() {
		int expected = 4 ;
		int actuel = mathoutil.Addition(1, 3);
		assertEquals(expected,actuel,"c'est l'opération addition");
	}
	
	@Test
	@DisplayName("Le test Cercle")
	@EnabledOnOs(OS.WINDOWS)
	void TestCercle() {
		assertEquals(314.1592653589793,mathoutil.Cercle(10), "c'est le Cercle");
	}
	
	@Test
	@Tag("Math")
	@DisplayName("Le test Division")
	void Division() {
		assertThrows(ArithmeticException.class,()->mathoutil.Division(1, 0), "c'est la division avec un resultats égale à 0");
	}
	
	@Test
	@Tag("Math")
	@DisplayName("Le test Multiplication")
	void Multiplication() {
		assertAll(()->assertEquals(0,mathoutil.Multiplication(1, 0)),
				()->assertEquals(60, mathoutil.Multiplication(15, 4)),
				()->assertEquals(60,mathoutil.Multiplication(15, 4))
		);
	}
}
