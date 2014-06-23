package fr.deleplace.valentin.extraction;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilityTest {

	@Test
	public void testFlatten() {
		assertEquals(null, Extractors.flatten(null));
		assertEquals("a", Extractors.flatten("a").trim());
		assertEquals("a", Extractors.flatten("a\n").trim());
		assertEquals("a", Extractors.flatten("a\n\n").trim());
		assertEquals("a", Extractors.flatten("\na\n").trim());
		assertEquals("a: b", Extractors.flatten("a:\nb").trim());
	}

}
