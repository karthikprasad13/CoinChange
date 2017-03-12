import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.Test;

import solutions.Part1;
import solutions.Part2;

public class TestAlgo {

	@Test
	public void testPart1() {
		assertEquals(7775, Part1.countWays(200));
		assertEquals(10, Part1.countWays(20));
		assertEquals(1, Part1.countWays(0));
		assertEquals(0, Part1.countWays(-10));
	}

	@Test
	public void testPart2() throws FileNotFoundException {

		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		String[] args = new String[] { "src/java/test/input" };
		Part2.main(args);

		assertEquals("Accepted suggestions: \r\n100  50  25  20  5  \r\n100  50  20  20  10  \r\n100  25  25  25  25  \r\n"
				+ "50  50  50  25  25  \r\n", outContent.toString());
	}
	
	@Test
	public void testPart2Input1() throws FileNotFoundException {

		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		String[] args = new String[] { "src/java/test/input1" };
		Part2.main(args);

		assertEquals("Accepted suggestions: \r\n100  100  \r\n", outContent.toString());
	}
	
	@Test
	public void testPart2Input2() throws FileNotFoundException {

		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		String[] args = new String[] { "src/java/test/input2" };
		Part2.main(args);

		assertEquals("Accepted suggestions: \r\n100  50  50  \r\n", outContent.toString());
	}
	
	@Test
	public void testPart2Input3() throws FileNotFoundException {

		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		String[] args = new String[] { "src/java/test/input3" };
		Part2.main(args);

		assertEquals("Accepted suggestions: \r\n100  50  25  25  \r\n50  50  50  50  \r\n", outContent.toString());
	}

}
