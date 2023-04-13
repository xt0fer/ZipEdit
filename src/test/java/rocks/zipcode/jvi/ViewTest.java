package rocks.zipcode.jvi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ViewTest {
	@Mock
	private int height;
	@Mock
	private int width;
	@Mock
	private int startX;
	@Mock
	private int startY;

	private View view;

	@Before
	public void setup() {
		this.view = new View(height, width, startX, startY);
	}

	@Test
	public void shouldPrintBufferContent() {
		view.printBufferContent();

		// TODO: assert scenario
	}

	@Test
	public void shouldResetCursor() {
		view.resetCursor();

		// TODO: assert scenario
	}

	@Test
	public void shouldPrintString() {
		// TODO: initialize args
		String text = "test string";

		view.printString(text);

		// TODO: assert scenario
	}

	@Test
	public void shouldGetHeight() {
		int actualValue = view.getHeight();

		// TODO: assert scenario
	}
}
