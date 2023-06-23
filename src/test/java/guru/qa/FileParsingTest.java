package guru.qa;

import com.google.gson.Gson;
import com.opencsv.CSVReader;
import guru.qa.model.UserModel;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class FileParsingTest {
	ClassLoader cl = FileParsingTest.class.getClassLoader();
	Gson gson = new Gson();

	@Test
	public void zipCsvTest() throws Exception {
		try (ZipFile zipFile = new ZipFile("src/test/resources/csv.zip");) {
			Enumeration<? extends ZipEntry> entries = zipFile.entries();
			while (entries.hasMoreElements()) {
				ZipEntry entry = entries.nextElement();
				InputStream stream = zipFile.getInputStream(entry);
				Reader reader = new InputStreamReader(stream);
				CSVReader csvReader = new CSVReader(reader);
				List<String[]> content = csvReader.readAll();
				Assertions.assertEquals(3, content.size());

				final String[] firstRow = content.get(0)[0].split(";");
				final String[] secondRow = content.get(1)[0].split(";");
				final String[] thirdRow = content.get(2)[0].split(";");

				Assertions.assertArrayEquals(new String[]{"Summer", "June"}, firstRow);
				Assertions.assertArrayEquals(new String[]{"Spring", "October"}, secondRow);
				Assertions.assertArrayEquals(new String[]{"Winter", "January"}, thirdRow);
			}
		}
	}

	@Test
	public void zipPdfTest() throws Exception {
		try (ZipFile zipFile = new ZipFile("src/test/resources/pdf.zip");) {
			Enumeration<? extends ZipEntry> entries = zipFile.entries();
			while (entries.hasMoreElements()) {
				ZipEntry entry = entries.nextElement();
				Assertions.assertEquals("qaquru.pdf", entry.getName());
			}
		}
	}

	@Test
	public void zipXlsxTest() throws Exception {
		try (ZipFile zipFile = new ZipFile("src/test/resources/xlsx.zip");) {
			Enumeration<? extends ZipEntry> entries = zipFile.entries();
			while (entries.hasMoreElements()) {
				ZipEntry entry = entries.nextElement();
				InputStream stream = zipFile.getInputStream(entry);
				Assertions.assertEquals("book1.xlsx", entry.getName());
				XSSFWorkbook wb = new XSSFWorkbook(stream);
				XSSFSheet sheet = wb.getSheetAt(0);
				Assertions.assertEquals("Summer", sheet.getRow(0).getCell(0).toString());
				Assertions.assertEquals("Spring", sheet.getRow(1).getCell(0).toString());
				Assertions.assertEquals("Winter", sheet.getRow(2).getCell(0).toString());
			}
		}
	}

	@Test
	public void userJsonTest() throws Exception {
		try (InputStream stream = cl.getResourceAsStream("user.json");
			 Reader reader = new InputStreamReader(stream)) {
			UserModel jsonObject = gson.fromJson(reader, UserModel.class);

			Assertions.assertEquals(2, jsonObject.getPage(), "Должна быть вторая страница");
			Assertions.assertEquals(7, jsonObject.getData().get(0).getId());
			Assertions.assertEquals("Michael", jsonObject.getData().get(0).getFirstName());
			Assertions.assertEquals("michael.lawson@reqres.in", jsonObject.getData().get(0).getEmail());
			Assertions.assertEquals("Lawson", jsonObject.getData().get(0).getLastName());
		}
	}
}
