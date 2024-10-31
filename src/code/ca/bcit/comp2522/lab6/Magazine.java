package ca.bcit.comp2522.lab6;

/**
 * Represents a magazine that extends the Literature class.
 *
 * @author Linh Hoang
 * @author Pouyan Norouzi
 */
public class Magazine extends Literature
{
   private final String title;

   /**
    * Constructs a Magazine with the specified title.
    *
    * @param title The title of the magazine.
    * @throws IllegalArgumentException if the title is null or empty.
    */
   public Magazine(String title)
   {
      validateTitle(title);

      this.title = title;
   }

   /**
    * Retrieves the title of the magazine.
    *
    * @return The title of the magazine.
    */
   @Override
   public String getTitle()
   {
      return title;
   }

   /*
    * Validates the title of the magazine.
    *
    * @param title The title to validate.
    * @throws IllegalArgumentException if the title is null or blank.
    */
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

