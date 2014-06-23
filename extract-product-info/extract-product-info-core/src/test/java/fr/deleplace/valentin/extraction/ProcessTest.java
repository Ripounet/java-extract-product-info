package fr.deleplace.valentin.extraction;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

public class ProcessTest {

	@Test
	public void testExtract() throws IOException {
		InputStream in = ClassLoader
				.getSystemResourceAsStream("product.html");
		Process process = new Process();
		ProductFields data = process.extractFromStream(in,"UTF-8", "http://www.etronics.com/");

		assertEquals("HP DesignJet T520 36-in ePrinter Printer Accessories",
				data.getTitle());
		assertEquals("$3,427.00", data.getPrice());
		assertEquals("HP", data.getBrand());
		assertEquals("HP", data.getManufacturer());
		assertEquals("CQ893A#B1K", data.getNumber());
		assertEquals(
				"In the Box - HP Designjet T520 ePrinter, printhead, ink cartridges, printer stand, quick reference guide, setup poster, startup software, power cord, CD software, 1-year warrantyFeatures. Achieve accurate lines, sharp details up to 2400 dpi from the first print with a long-life printhead. Process complex files at high speeds, D prints in 35 seconds, thanks to 1 GB RAM and HP-GL/2 technology. The intuitive, full-color, 4.3-inch touchscreen simplifies navigation & printing. Easily set up your printer and connect everyone in your workgroup, thanks to built-in Wi-Fi",
				data.getShortDescription());
		assertTrue(data.getCategories().contains("Electronics"));
		assertTrue(data.getCategories().contains("Some stuff"));
	}

}
