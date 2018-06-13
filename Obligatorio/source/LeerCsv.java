package source;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import de.siegmar.fastcsv.reader.CsvContainer;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;

public class LeerCsv {
	public static void lectura(Obligatorio obligatorio) throws IOException {
		File file = new File("v_producto_real_updated.csv");
		CsvReader csvReader = new CsvReader();
		csvReader.setFieldSeparator(';');
		csvReader.setContainsHeader(true);
		CsvContainer csv;
			csv = csvReader.read(file, StandardCharsets.UTF_8);
			for (CsvRow row : csv.getRows()) {
				
				String nombreProducto = row.getField("nombre"); 
				String nombreDeFantasia= row.getField("nom_fantasia"); 
				String idProduct = row.getField("idprod"); 
				String rubro = row.getField("rubro"); 
				String nroHab = row.getField("nro_hab");
				String empresa = row.getField("empresa"); 
				String clase = row.getField("clase"); 
				String marca = row.getField("marca");
				String pais= row.getField("pais"); 
				String status = row.getField("estado");
				String ruc = row.getField("ruc");
				
				obligatorio.crearProductoSoloStrings(nombreProducto, nombreDeFantasia, status, idProduct, clase, pais, marca, empresa, ruc, rubro, nroHab);
			}
		
		
	}
	// https://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/ nos fue
	// de mucha utilidad para la creación de esta clase
	/*
	 * private static final char DEFAULT_SEPARATOR = ';'; private static final char
	 * DEFAULT_QUOTE = '"';
	 * 
	 * public static void lectura(Obligatorio obligatorio) { String csvFile =
	 * "v_producto_real_updated.csv"; Scanner scanner = null; try {
	 * 
	 * scanner = new Scanner(new File(csvFile), "UTF-8");
	 * parseLine(scanner.nextLine()); while (scanner.hasNext()) {
	 * MyLinkedList<String> line = parseLine(scanner.nextLine()); String
	 * nombreProducto = line.getElementFrom(0); String nombreDeFantasia =
	 * line.getElementFrom(1); String idProduct = line.getElementFrom(2); String
	 * rubro = line.getElementFrom(3); String nroHab = line.getElementFrom(4);
	 * String empresa = line.getElementFrom(5); String clase =
	 * line.getElementFrom(10); String marca = line.getElementFrom(12); String pais
	 * = line.getElementFrom(13); String status = line.getElementFrom(20); String
	 * ruc = line.getElementFrom(23);
	 * obligatorio.crearProductoSoloStrings(nombreProducto, nombreDeFantasia,
	 * status, idProduct, clase, pais, marca, empresa, ruc, rubro, nroHab); }
	 * scanner.close();
	 * 
	 * } catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException
	 * e) { e.printStackTrace(); } }
	 * 
	 * public static MyLinkedList<String> parseLine(String cvsLine) { return
	 * parseLine(cvsLine, DEFAULT_SEPARATOR, DEFAULT_QUOTE); }
	 * 
	 * public static MyLinkedList<String> parseLine(String cvsLine, char separators)
	 * { return parseLine(cvsLine, separators, DEFAULT_QUOTE); }
	 * 
	 * public static MyLinkedList<String> parseLine(String cvsLine, char separators,
	 * char customQuote) {
	 * 
	 * MyLinkedList<String> result = new MyLinkedList<>();
	 * 
	 * // if empty, return! if (cvsLine == null) { return result; }
	 * 
	 * if (customQuote == ' ') { customQuote = DEFAULT_QUOTE; }
	 * 
	 * if (separators == ' ') { separators = DEFAULT_SEPARATOR; }
	 * 
	 * StringBuffer curVal = new StringBuffer(); boolean inQuotes = false; boolean
	 * startCollectChar = false; boolean doubleQuotesInColumn = false;
	 * 
	 * char[] chars = cvsLine.toCharArray();
	 * 
	 * for (char ch : chars) {
	 * 
	 * if (inQuotes) { startCollectChar = true; if (ch == customQuote) { inQuotes =
	 * false; doubleQuotesInColumn = false; } else {
	 * 
	 * // Fixed : allow "" in custom quote enclosed if (ch == '\"') { if
	 * (!doubleQuotesInColumn) { curVal.append(ch); doubleQuotesInColumn = true; } }
	 * else { curVal.append(ch); }
	 * 
	 * } } else { if (ch == customQuote) {
	 * 
	 * inQuotes = true;
	 * 
	 * // Fixed : allow "" in empty quote enclosed if (chars[0] !=
	 * '"' && customQuote == '\"') { curVal.append('"'); }
	 * 
	 * // double quotes in column will hit this! if (startCollectChar) {
	 * curVal.append('"'); }
	 * 
	 * } else if (ch == separators) {
	 * 
	 * result.add(curVal.toString());
	 * 
	 * curVal = new StringBuffer(); startCollectChar = false;
	 * 
	 * } else if (ch == '\r') { // ignore LF characters continue; } else if (ch ==
	 * '\n') { // the end, break! break; } else { curVal.append(ch); } }
	 * 
	 * }
	 * 
	 * result.add(curVal.toString());
	 * 
	 * return result; }
	 */

}