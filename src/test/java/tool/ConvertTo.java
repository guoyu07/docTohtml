package tool;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;

/**
 *  @author john
 */
public class ConvertTo {
    public static void main(String[] args) throws IOException {
        String path = "src/main/resources/test.docx";
        String  path2 = "src/main/resources/test2.doc";
        InputStream inputStream = new FileInputStream(new File
                (path2));
        XWPFDocument document = null;
        try {
            document = new XWPFDocument(inputStream);
        } catch (IOException e) {
            HWPFDocument document2 = new HWPFDocument(inputStream);
            e.printStackTrace();
        }
//        HWPFDocument document = new HWPFDocument(inputStream);
        System.out.println(document.getDocument());
        XWPFWordExtractor extractor = new XWPFWordExtractor(document);
        System.out.println(extractor.getText());

    }

    public static String ToHtml(String path) throws Exception{
//        String content = new StringBuffer().toString();
        if (path.equals("") || path == null) {
            path = "src/main/resources/test.docx";
        }
        InputStream inputStream = new FileInputStream(new File(path));
        XWPFDocument document = new XWPFDocument(inputStream);
        XWPFWordExtractor extractor = new XWPFWordExtractor(document);
        return extractor.getText();
    }

}