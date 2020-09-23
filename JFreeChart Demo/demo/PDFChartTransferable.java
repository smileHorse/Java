package demo;

import com.orsonpdf.PDFDocument;
import com.orsonpdf.PDFGraphics2D;
import com.orsonpdf.Page;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.geom.Rectangle2D.Double;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.jfree.chart.JFreeChart;

public class PDFChartTransferable implements Transferable {

   final DataFlavor pdfFlavor;
   private JFreeChart chart;
   private int width;
   private int height;


   public PDFChartTransferable(JFreeChart var1, int var2, int var3) {
      this(var1, var2, var3, true);
   }

   public PDFChartTransferable(JFreeChart var1, int var2, int var3, boolean var4) {
      this.pdfFlavor = new DataFlavor("application/pdf", "PDF");

      try {
         this.chart = (JFreeChart)var1.clone();
      } catch (CloneNotSupportedException var6) {
         this.chart = var1;
      }

      this.width = var2;
      this.height = var3;
   }

   public DataFlavor[] getTransferDataFlavors() {
      return new DataFlavor[]{this.pdfFlavor};
   }

   public boolean isDataFlavorSupported(DataFlavor var1) {
      return this.pdfFlavor.equals(var1);
   }

   public Object getTransferData(DataFlavor var1) throws UnsupportedFlavorException, IOException {
      if(this.pdfFlavor.equals(var1)) {
         PDFDocument var2 = new PDFDocument();
         Double var3 = new Double(0.0D, 0.0D, (double)this.width, (double)this.height);
         Page var4 = var2.createPage(var3);
         PDFGraphics2D var5 = var4.getGraphics2D();
         this.chart.draw(var5, var3);
         return new ByteArrayInputStream(var2.getPDFBytes());
      } else {
         throw new UnsupportedFlavorException(var1);
      }
   }
}
