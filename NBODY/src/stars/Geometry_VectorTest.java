package stars;

import static org.junit.Assert.*;

import org.junit.Test;

public class Geometry_VectorTest {

	@Test
	public void test_add_to_me() {
		// Simple base case.
		Geometry_Vector a1 = new Geometry_Vector(4.5, 7.3);
		Geometry_Vector b1 = new Geometry_Vector(2.9, 3.5);
		Geometry_Vector answer1 = new Geometry_Vector(4.5 + 2.9, 7.3 + 3.5);

		a1.add_to_me(b1);
		assertEquals(a1.toString(), answer1.toString());

		// Zero case.
		Geometry_Vector a2 = new Geometry_Vector(4.5, 7.3);
		Geometry_Vector b2 = new Geometry_Vector(0, 0);
		Geometry_Vector answer2 = new Geometry_Vector(4.5, 7.3);

		a2.add_to_me(b2);
		assertEquals(a2.toString(), answer2.toString());

		// Test w/ negatives.
		Geometry_Vector a3 = new Geometry_Vector(4.5, 7.3);
		Geometry_Vector b3 = new Geometry_Vector(-2.9, -3.5);
		Geometry_Vector answer3 = new Geometry_Vector(4.5 - 2.9, 7.3 - 3.5);

		a3.add_to_me(b3);
		assertEquals(a3.toString(), answer3.toString());
	}

	@Test
	public void test_subtract_from_me() {
		// Simple base case.
		Geometry_Vector a1 = new Geometry_Vector(4.5, 7.3);
		Geometry_Vector b1 = new Geometry_Vector(2.9, 3.5);
		Geometry_Vector answer1 = new Geometry_Vector(4.5 - 2.9, 7.3 - 3.5);

		a1.subtract_from_me(b1);
		assertEquals(a1.toString(), answer1.toString());

		// Zero case.
		Geometry_Vector a2 = new Geometry_Vector(4.5, 7.3);
		Geometry_Vector b2 = new Geometry_Vector(0, 0);
		Geometry_Vector answer2 = new Geometry_Vector(4.5, 7.3);

		a2.subtract_from_me(b2);
		assertEquals(a2.toString(), answer2.toString());

		// Test w/ negatives.
		Geometry_Vector a3 = new Geometry_Vector(4.5, 7.3);
		Geometry_Vector b3 = new Geometry_Vector(-2.9, -3.5);
		Geometry_Vector answer3 = new Geometry_Vector(4.5 + 2.9, 7.3 + 3.5);

		a3.subtract_from_me(b3);
		assertEquals(a3.toString(), answer3.toString());
	}

	@Test
	public void test_divide_by() {
		// Simple base case.
		Geometry_Vector a1 = new Geometry_Vector(3.4, 7.3);
		Geometry_Vector answer1 = new Geometry_Vector(1.7, 3.65);

		a1.divide_by(2);
		assertEquals(a1.toString(), answer1.toString());

		// Zero case.
		Geometry_Vector a2 = new Geometry_Vector(0, 0);
		Geometry_Vector answer2 = new Geometry_Vector(0, 0);

		a2.divide_by(5);
		assertEquals(a2.toString(), answer2.toString());

		// Test w/ negatives.
		Geometry_Vector a3 = new Geometry_Vector(-2.9, -3.5);
		Geometry_Vector answer3 = new Geometry_Vector(-1.45, -1.75);

		a3.divide_by(2);
		assertEquals(a3.toString(), answer3.toString());
	}

	@Test
	public void test_multiply_me_by() {
		// Simple base case.
		Geometry_Vector a1 = new Geometry_Vector(3.4, 7.3);
		Geometry_Vector answer1 = new Geometry_Vector(6.8, 14.6);

		a1.multiply_me_by(2);
		assertEquals(a1.toString(), answer1.toString());

		// Zero case.
		Geometry_Vector a2 = new Geometry_Vector(0, 0);
		Geometry_Vector answer2 = new Geometry_Vector(0, 0);

		a2.multiply_me_by(5);
		assertEquals(a2.toString(), answer2.toString());

		// Test w/ negatives.
		Geometry_Vector a3 = new Geometry_Vector(-2.9, -3.5);
		Geometry_Vector answer3 = new Geometry_Vector(2.9, 3.5);

		a3.multiply_me_by(-1);
		assertEquals(a3.toString(), answer3.toString());
	}

	@Test
	public void test_magnitude() {
		// Simple base case.
		Geometry_Vector a1 = new Geometry_Vector(1, 1);
		assertEquals(a1.magnitude(), Math.sqrt(2), 0);

		// Base case.
		Geometry_Vector a2 = new Geometry_Vector(5, 2);
		assertEquals(a2.magnitude(), Math.sqrt(29), 0.01);

		// Zero case.
		Geometry_Vector a3 = new Geometry_Vector(0, 0);
		assertEquals(a3.magnitude(), 0, 0);

		// Negative case.
		Geometry_Vector a4 = new Geometry_Vector(-5, -2);
		assertEquals(a4.magnitude(), Math.sqrt(29), 0);
	}

	public void test_normalize() {
		
	}
}
