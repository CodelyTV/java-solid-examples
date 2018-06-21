package tv.codely.solid_principles.liskov_substitution_principle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class RectangleShould {
	@Test
	void calculate_its_area() {
        Integer rectangleLength = 2;
        Integer rectangleWidth = 2;
		Rectangle rectangle = new Rectangle(rectangleLength, rectangleWidth);

        Integer expectedArea = 4;

        assertEquals(expectedArea, rectangle.getArea());
	}
}
