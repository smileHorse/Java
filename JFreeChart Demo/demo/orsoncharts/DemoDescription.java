package demo.orsoncharts;


public class DemoDescription {

   private String className;
   private String fileName;
   private String descriptionFileName;


   public DemoDescription(String var1, String var2, String var3) {
      this.className = var1;
      this.fileName = var2;
      this.descriptionFileName = var3;
   }

   public String getClassName() {
      return this.className;
   }

   public String getFileName() {
      return this.fileName;
   }

   public String getDescriptionFileName() {
      return this.descriptionFileName;
   }

   public String toString() {
      return this.fileName;
   }
}
