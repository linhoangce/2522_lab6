package ca.bcit.comp2522.lab6;

public class Magazine extends Literature
{
   private final String title;

   public Magazine(String title)
   {
      validateTitle(title);

      this.title = title;
   }

   @Override
   public String getTitle()
   {
      return title;
   }

   private static void validateTitle(final String title)
   {
      if(title == null)
      {
         throw new IllegalArgumentException("Title must not be null!");
      }

      if(title.isBlank())
      {
         throw new IllegalArgumentException("Title must not be empty!");
      }
   }
}

