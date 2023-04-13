package rocks.zipcode.jvi;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BufferTest {
	@Mock
	private int maxLines;

	private Buffer buffer;

	@Before
	public void setup() {
		this.buffer = new Buffer(maxLines);
	}

	@Test
	public void shouldReadFile() {
		String fileName = "test.txt";

		String actualValue = buffer.readFile(fileName);

		// TODO: assert scenario
	}

	@Test
	public void shouldReplaceChar() {
		char c = 'x';
		int x = 0;
		int y = 0;

		//buffer.replaceChar(c, x, y);

		// TODO: assert scenario
	}

	@Test
	public void shouldInsertChar() {
		char c = 'z';
		int x = 0;
		int y = 0;

		//buffer.insertChar(c, x, y);

		// TODO: assert scenario
	}

	@Test
	public void shouldInsertString() {
		String s = "foo";
		int x = 0;
		int y = 0;

		buffer.insertString(s, x, y);

		// TODO: assert scenario
	}

	@Test
	public void shouldInsertNewLine() {
		int x = 0;
		int y = 0;

		buffer.insertNewLine(x, y);

		// TODO: assert scenario
	}

	@Test
	public void shouldDeleteChar() {
		int x = 0;
		int y = 0;

		//buffer.deleteChar(x, y);

		// TODO: assert scenario
	}

	@Test
	public void shouldDeleteLine() {
		int y = 0;

		buffer.deleteLine(y);

		// TODO: assert scenario
	}

	@Test
	public void shouldClear() {
		buffer.clear();

		// TODO: assert scenario
	}

	@Test
	public void shouldGetNumLines() {
		int actualValue = buffer.getNumLines();

		// TODO: assert scenario
	}

	@Test
	public void shouldGetLines() {
		int lineStart = 0;
		int lineFinish = 0;

		String[] actualValue = buffer.getLines(lineStart, lineFinish);

		// TODO: assert scenario
	}

	@Test
	public void shouldGetLine() {
		int y = 0;

		String actualValue = buffer.getLine(y);

		// TODO: assert scenario
	}

	@Test
	public void shouldGetFileName() {
		String actualValue = buffer.getFileName();

		// TODO: assert scenario
	}

	@Test
	public void shouldSaveFile() {
		buffer.saveFile();

		// TODO: assert scenario
	}

	@Test
	public void shouldUnsavedChanges() {
		boolean actualValue = buffer.unsavedChanges();

		// TODO: assert scenario
	}

	@Test
	public void shouldEnableInsertMode() {
		buffer.enableInsertMode();

		// TODO: assert scenario
	}

	@Test
	public void shouldDisableInsertMode() {
		buffer.disableInsertMode();

		// TODO: assert scenario
	}

	@Test
	public void shouldClipboard() {
		String actualValue = buffer.clipboard();

		// TODO: assert scenario
	}

	@Test
	public void shouldGetClipboardLines() {
		int actualValue = buffer.getClipboardLines();

		// TODO: assert scenario
	}

	@Test
	public void shouldContents() {

		Buffer buffer = new Buffer(20);
		String expectedString = "this is a test";

		buffer.setContent(expectedString);
		String actualValue = buffer.contents();

		// TODO: assert scenario
		assertEquals("contents work", expectedString, actualValue);
	}
}
