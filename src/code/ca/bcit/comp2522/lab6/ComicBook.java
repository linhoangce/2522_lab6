package ca.bcit.comp2522.lab6;

/**
 * Represents a comic book that extends the Literature class.
 *
 * @author Linh Hoang
 * @author Pouyan Norouzi
 */
public class ComicBook extends Literature
{
   private final String title;

   /**
    * Constructs a ComicBook with the specified title.
    *
    * @param title The title of the comic book.
    * @throws IllegalArgumentException if the title is null or empty.
    */
   public ComicBook(final String title)
   {
      validateTitle(title);

      this.title = title;
   }

   /**
    * Retrieves the title of the comic book.
    *
    * @return The title of the comic book.
    */
   @Override
   public String getTitle()
   {
      return title;
   }

   /*
    * Validates the title of the comic book.
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
