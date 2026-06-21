public class FactoryTest {
    public static void main(String[] args) {
        // 1. Create a Word Factory to make a Word document
        DocumentFactory wordFactory = new WordFactory();
        Document myWordDoc = wordFactory.createDocument();
        myWordDoc.open();

        // 2. Create a PDF Factory to make a PDF document
        DocumentFactory pdfFactory = new PdfFactory();
        Document myPdfDoc = pdfFactory.createDocument();
        myPdfDoc.open();

        // 3. Create an Excel Factory to make an Excel document
        DocumentFactory excelFactory = new ExcelFactory();
        Document myExcelDoc = excelFactory.createDocument();
        myExcelDoc.open();
    }
}
