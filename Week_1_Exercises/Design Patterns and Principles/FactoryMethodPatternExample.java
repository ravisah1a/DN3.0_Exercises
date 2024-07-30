abstract class Document {
}
interface WordDocument {
    void createWordDocument();
}
interface PdfDocument {
    void createPdfDocument();
}
interface ExcelDocument {
    void createExcelDocument();
}
class ConcreteWordDocument extends Document implements WordDocument {
    public void createWordDocument() {
    }
}
class ConcretePdfDocument extends Document implements PdfDocument {
    public void createPdfDocument() {
    }
}

class ConcreteExcelDocument extends Document implements ExcelDocument {
    public void createExcelDocument() {
    }
}
abstract class DocumentFactory {
    public abstract Document createDocument();
}
class WordDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new ConcreteWordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new ConcretePdfDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new ConcreteExcelDocument();
    }
}


public class DocumentManagementSystem {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();

    }
}