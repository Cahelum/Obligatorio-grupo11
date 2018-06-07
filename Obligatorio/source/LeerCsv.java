package source;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import nodoSimple.MyLinkedList;

public class LeerCSV {
	//https://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/ nos fue de mucha utilidad para la creación de esta clase
    private static final char DEFAULT_SEPARATOR = ';';
    private static final char DEFAULT_QUOTE = '"';

    public static void lectura(Obligatorio obligatorio) {
    	String csvFile = "v_producto_real_updated.csv";
    	Scanner scanner= null;
       	try {
        
        scanner = new Scanner(new File(csvFile),"UTF-8");
        parseLine(scanner.nextLine());
        while (scanner.hasNext()) {
            MyLinkedList<String> line = parseLine(scanner.nextLine());
            String nombreProducto= line.getElementFrom(0);
            String nombreDeFantasia= line.getElementFrom(1);
            String status=line.getElementFrom(20);
            String idProduct=line.getElementFrom(2);
            String clase=line.getElementFrom(10);
            String pais=line.getElementFrom(13);
            String marca=line.getElementFrom(12);
            String empresa=line.getElementFrom(5);
            String ruc=line.getElementFrom(23);
            String rubro=line.getElementFrom(3);
            obligatorio.crearProductoSoloStrings (nombreProducto, nombreDeFantasia, status, idProduct, clase, pais, marca, empresa, ruc, rubro);
            }
    	scanner.close();   

    
       	} catch (FileNotFoundException e) {
       		e.printStackTrace();
       	} catch (IOException e) {
       		e.printStackTrace();
       	}
    }

    public static MyLinkedList<String> parseLine(String cvsLine) {
        return parseLine(cvsLine, DEFAULT_SEPARATOR, DEFAULT_QUOTE);
    }

    public static MyLinkedList<String> parseLine(String cvsLine, char separators) {
        return parseLine(cvsLine, separators, DEFAULT_QUOTE);
    }

    public static MyLinkedList<String> parseLine(String cvsLine, char separators, char customQuote) {

        MyLinkedList<String> result = new MyLinkedList<>();

        //if empty, return!
        if (cvsLine == null) {
            return result;
        }

        if (customQuote == ' ') {
            customQuote = DEFAULT_QUOTE;
        }

        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR;
        }

        StringBuffer curVal = new StringBuffer();
        boolean inQuotes = false;
        boolean startCollectChar = false;
        boolean doubleQuotesInColumn = false;

        char[] chars = cvsLine.toCharArray();

        for (char ch : chars) {

            if (inQuotes) {
                startCollectChar = true;
                if (ch == customQuote) {
                    inQuotes = false;
                    doubleQuotesInColumn = false;
                } else {

                    //Fixed : allow "" in custom quote enclosed
                    if (ch == '\"') {
                        if (!doubleQuotesInColumn) {
                            curVal.append(ch);
                            doubleQuotesInColumn = true;
                        }
                    } else {
                        curVal.append(ch);
                    }

                }
            } else {
                if (ch == customQuote) {

                    inQuotes = true;

                    //Fixed : allow "" in empty quote enclosed
                    if (chars[0] != '"' && customQuote == '\"') {
                        curVal.append('"');
                    }

                    //double quotes in column will hit this!
                    if (startCollectChar) {
                        curVal.append('"');
                    }

                } else if (ch == separators) {

                    result.add(curVal.toString());

                    curVal = new StringBuffer();
                    startCollectChar = false;

                } else if (ch == '\r') {
                    //ignore LF characters
                    continue;
                } else if (ch == '\n') {
                    //the end, break!
                    break;
                } else {
                    curVal.append(ch);
                }
            }

        }

        result.add(curVal.toString());

        return result;
    }

}