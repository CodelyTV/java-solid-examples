package tv.codely.solid_principles.liskov_substitution_principle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

final class SquareShould {
	@Test
	void not_respect_the_liskov_substitution_principle_breaking_the_rectangle_laws_while_modifying_its_length() {
		Integer squareLengthAndWidth = 2;
		Square square = new Square(squareLengthAndWidth);

		Integer newSquareLength = 4;
		square.setLength(newSquareLength);

        Integer expectedAreaTakingIntoAccountRectangleLaws = 8;

        assertNotEquals(expectedAreaTakingIntoAccountRectangleLaws, square.getArea());
	}
}
