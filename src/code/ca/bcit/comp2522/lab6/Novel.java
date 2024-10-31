package ca.bcit.comp2522.lab6;

/**
 * Represents a novel that extends the Literature class.
 *
 * @author Linh Hoang
 * @author Pouyan Norouzi
 */
public class Novel extends Literature
{

   private final String title;

   /**
    * Constructs a Novel with the specified title.
    *
    * @param title The title of the novel.
    * @throws IllegalArgumentException if the title is null or empty.
    */
   public Novel(final String title)
   {
      validateTitle(title);

      this.title = title;
   }

   /**
    * Retrieves the title of the novel.
    *
    * @return The title of the novel.
    */
   @Override
   public String getTitle()
   {
      return title;
   }

   /*
    * Validates the title of the novel.
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
