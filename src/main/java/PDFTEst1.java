import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.canvas.draw.DashedLine;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.element.LineSeparator;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

import java.io.FileOutputStream;
import java.io.IOException;

public class PDFTEst1 {
    public static void main(String[] args) throws IOException {
        PdfDocument document = new PdfDocument(new PdfWriter(new FileOutputStream("iTextHelloWorld.pdf")));

        document.setDefaultPageSize(PageSize.A4);

        PdfCanvas pdfCanvas = new PdfCanvas(document.addNewPage());

        ///////////////eazydaily address details////////////////////////////////////
        Canvas canvas = new Canvas(pdfCanvas, new Rectangle(36, 700, 200, 130));
        PdfFont font = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
        PdfFont bold = PdfFontFactory.createFont(StandardFonts.TIMES_BOLD);
        Paragraph p = new Paragraph()
                .add(new Text("EazyDaily Media Pvt. Ltd.\n").setFont(bold))
                .add(new LineSeparator(new DashedLine()))
                .add(new Text("<registered address line 1>\n").setFont(font).setFontSize(10))
                .add(new Text("<registered address line 2>\n").setFont(font).setFontSize(10))
                .add(new Text("<registered address line 3>\n").setFont(font).setFontSize(10))
                .add(new Text("Email: ").setFont(bold).setFontSize(12)).add(new Text("invoicing@ezzo.in\n").setFont(font).setFontSize(12))
                .add(new Text("GSTIN: ").setFont(bold).setFontSize(12)).add(new Text("<GSTIN of eazydaily>\n").setFont(font).setFontSize(12))
                .add(new Text("PAN: ").setFont(bold).setFontSize(12)).add(new Text("<PAN of eazydaily>\n").setFont(font).setFontSize(12));

        canvas.add(p);
        canvas.close();




        document.close();
    }
}
