package rocks.zipcode.jvi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
 
public class BufferTest {
	private int maxLines = 24;

	private Buffer buffer;

	@Before
	public void setup() {
		this.buffer = new Buffer(maxLines);
	}

	@Test
	public void shouldReadFile() {
		String fileName = "test.txt";

		String actualValue = buffer.readFile(fileName);

		assertEquals("", fileName, actualValue);
	}

	@Test
	public void shouldReplaceChar() {
		buffer.clear();
		Character c = 'x';
		int x = 0;
		int y = 0;

		buffer.setContent("z");
		buffer.replaceCharacter(c, x, y);
		String actual = buffer.toString();
		assertEquals("", c.toString()+"\n", actual);
	}

	@Test
	public void shouldReplaceChar2() {
		buffer.clear();
		Character c = 'x';
		int x = 0;
		int y = 1;

		buffer.setContent("zzz");
		buffer.replaceCharacter(c, x, y);
		String actual = buffer.toString();
		assertEquals("", "zxz\n", actual);
	}

	@Test
	public void shouldReplaceChar3() {
		buffer.clear();
		Character c = 'x';
		int x = 1;
		int y = 1;

		buffer.setContent("zzz\nzzz\n");
		buffer.replaceCharacter(c, x, y);
		String actual = buffer.toString();
		assertEquals("", "zzz\nzxz\n", actual);
	}

	@Test
	public void shouldInsertChar() {
		Character expected = 'z';
		buffer.clear();
		//String expected = "foo\nbar\nbaz";
		int x = 0;
		int y = 0;

		buffer.enableInsertMode();
		buffer.insertCharacter(expected, x, y);
		String actual = buffer.toString();
		buffer.disableInsertMode();
		assertEquals("", expected.toString()+"\n", actual);
	}

	@Test
	public void shouldInsertChar2() {
		Character insertch = 'z';
		buffer.clear();
		String start = "foo\nbar\nbaz";
		String expected = "foo\nbzar\nbaz\n";
		int x = 1;
		int y = 1;

		buffer.enableInsertMode();
		buffer.setContent(start);
		buffer.insertCharacter(insertch, x, y);
		String actual = buffer.toString();
		buffer.disableInsertMode();
		assertEquals("", expected, actual);
	}

	@Test
	public void shouldInsertString() {
		buffer.clear();
		String expected = "foobarbaz";
		int x = 0;
		int y = 0;

		buffer.enableInsertMode();
		buffer.insertString(expected, x, y);
		String actual = buffer.toString();
		buffer.disableInsertMode();
		assertEquals("", expected+"\n", actual);
	}

	@Test
	public void shouldInsertString2() {
		buffer.clear();
		String expected = "foo\nbar\nbaz";
		int x = 0;
		int y = 0;

		buffer.enableInsertMode();
		buffer.insertString(expected, x, y);
		String actual = buffer.toString();
		buffer.disableInsertMode();
		assertEquals("", expected+"\n", actual);
	}

	@Test
	public void shouldInsertNewLine() {
		int x = 0;
		int y = 0;
		boolean result = false;
		int l1 = buffer.getNumLines();
		buffer.insertNewLine(x, y);
		int l2 = buffer.getNumLines();
		if (l1 + 1 == l2) result = true;
		assertTrue(null, result);
	}

	@Test
	public void shouldDeleteChar() {
		int x = 0;
		int y = 0;

		//buffer.deleteChar(x, y);

		assertTrue(null, false);
	}

	@Test
	public void shouldDeleteLine() {
		int y = 0;

		boolean result = false;
		int l1 = buffer.getNumLines();
		buffer.deleteLine(y);
		int l2 = buffer.getNumLines();
		if (l1 - 1 == l2) result = true;
		assertTrue(null, result);
	}

	@Test
	public void shouldClear() {
		buffer.setContent("fooooooooo");
		buffer.clear();

		String actual = buffer.toString();
		assertEquals("clear No Worky", "\n", actual);
	}

	@Test
	public void shouldGetNumLines() {
		buffer.clear();
		String src = "foo\nbar\nbaz";
		int expected = 3;
		buffer.setContent(src);
		int actualValue = buffer.getNumLines();

		assertEquals(expected, actualValue);
	}
	@Test
	public void shouldGetNumLines2() {
		buffer.clear();
		int expected = 1;
		int actualValue = buffer.getNumLines();

		assertEquals(expected, actualValue);
	}

	@Test
	public void shouldGetLines() {
		int lineStart = 0;
		int lineFinish = 0;

		//String[] actualValue = buffer.getLines(lineStart, lineFinish);

		assertTrue(null, false);
	}

	@Test
	public void shouldGetLine() {
		int y = 0;

		//String actualValue = buffer.getLine(y);

		assertTrue(null, false);
	}

	@Test
	public void shouldGetFileName() {
		//String actualValue = buffer.getFileName();

		assertTrue(null, false);
	}

	@Test
	public void shouldSaveFile() {
		buffer.saveFile();

		assertTrue(null, false);
	}

	@Test
	public void shouldUnsavedChanges() {
		//boolean actualValue = buffer.unsavedChanges();

		assertTrue(null, false);
	}

	@Test
	public void shouldEnableInsertMode() {
		buffer.enableInsertMode();
		assertTrue("", buffer.insertModeOn());
	}

	@Test
	public void shouldDisableInsertMode() {
		buffer.disableInsertMode();
		assertTrue("", !buffer.insertModeOn());

	}

	@Test
	public void shouldClipboard() {
		//String actualValue = buffer.clipboard();

		assertTrue(null, false);
	}

	@Test
	public void shouldGetClipboardLines() {
		//int actualValue = buffer.getClipboardLines();

		assertTrue(null, false);
	}

	@Test
	public void shouldSetToString() {

		Buffer buf = new Buffer(20);
		buf.clear();
		String expectedString = "this is a test\n";

		buf.setContent(expectedString);
		String actualValue = buf.toString();

		assertEquals("not right", expectedString, actualValue);
	}
}
