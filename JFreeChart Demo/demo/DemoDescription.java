package demo;


public class DemoDescription {

   private String className;
   private String description;


   public DemoDescription(String var1, String var2) {
      this.className = var1;
      this.description = var2;
   }

   public String getClassName() {
      return this.className;
   }

   public String getDescription() {
      return this.description;
   }

   public String toString() {
      return this.description;
   }
}
