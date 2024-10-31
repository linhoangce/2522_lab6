package ca.bcit.comp2522.lab6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Represents a generic bookstore that holds items of type Literature.
 *
 * @param <T> The type of items this bookstore holds, extending Literature.
 *
 * @author Linh Hoang
 * @author Pouyan Norouzi
 */
public class BookStore<T extends Literature>
{
   private static int itemCount = 0;

   private final List<T> items;
   private final String  storeName;

   /**
    * Constructs a BookStore with a specified name.
    *
    * @param storeName The name of the bookstore.
    * @throws IllegalArgumentException if the store name is null or empty.
    */
   public BookStore(final String storeName)
   {
      validateName(storeName);

      this.storeName = storeName;
      items = new ArrayList<>();
   }

   /**
    * @return storeName as a String
    */
   public String getStoreName()
   {
      return storeName;
   }

   /**
    * A static nested class providing information about the bookstore.
    */
   public static class BookStoreInfo
   {
      /**
       * Displays the name and item count of the bookstore.
       *
       * @param storeName The name of the bookstore.
       * @param itemCount The count of items in the bookstore.
       */
      public static void displayInfo(final String storeName, final int itemCount)
      {
         System.out.println("BookStore: " + storeName + ", Items: " + itemCount);
      }
   }

   /**
    * A non-static nested class providing statistical information about the bookstore.
    */
   public class BookStoreStatistics
   {

      /**
       * Calculates the average length of item titles in the bookstore.
       *
       * @return The average title length as a double.
       */
      public double averageTitleLength()
      {
         final double result;
         int totalLength;

         totalLength = 0;

         for(final T item : items)
         {
            totalLength += item.getTitle().length();
         }

         result = (double) totalLength / items.size();

         return result;
      }
   }

   /**
    * Adds an item to the bookstore, if the item is not null.
    *
    * @param item The item to add.
    */
   public void addItem(final T item)
   {
      if(item != null)
      {
         items.add(item);
         itemCount++;
      }
   }

   /**
    * Prints the titles of all items in the bookstore.
    */
   public void printItem()
   {
      for(final T item : items)
      {
         if(item != null)
         {
            System.out.println(item.getTitle());
         }
      }
   }

   /**
    * Prints whether each item's title contains the specified string.
    *
    * @param title The title substring to search for.
    */
   public void printBookTitle(final String title)
   {
      items.forEach(item->{
         System.out.println(item.getTitle().contains(title));
      });
   }

   /**
    * Prints the titles of all items in the bookstore in alphabetical order.
    */
   public void printTitlesInAlphaOrder()
   {
      items.sort(Comparator.comparing(Literature::getTitle, String::compareToIgnoreCase));
      items.forEach(item->System.out.println(item.getTitle()));
   }

   /**
    * Adds all novels from the bookstore to the provided novel collection.
    *
    * @param novelCollection The collection to add novels to.
    */
   public void addNovelsToCollection(List<? super Novel> novelCollection)
   {
      for(final T item : items)
      {
         if(item instanceof Novel)
         {
            novelCollection.add((Novel) item);
         }
      }
   }

   /**
    * Validates the bookstore's name.
    *
    * @param name The name to validate.
    * @throws IllegalArgumentException if the name is null or blank.
    */
   private static void validateName(final String name)
   {
      if(name == null || name.isBlank())
      {
         throw new IllegalArgumentException("Name must not be empty!");
      }
   }

   /**
    * The main method demonstrates the use of the BookStore class.
    *
    * @param args Command-line arguments (not used).
    */
   public static void main(final String[] args)
   {
      final BookStore<Literature> store;
      final BookStore<Literature>.BookStoreStatistics stat;

      store = new BookStore<>("The Magic Bookstore");
      stat  = store.new BookStoreStatistics();

      store.addItem(new Novel("War and Peace"));
      store.addItem(new ComicBook("Spider-Man"));
      store.addItem(new Magazine("National Geographic"));

      store.printItem();

      store.items.sort(new Comparator<Literature>()
      {
         @Override
         public int compare(Literature o1, Literature o2)
         {
            return Integer.compare(o1.getTitle().length(), o2.getTitle().length());
         }
      });

      System.out.println("********** Sorted List ***********");
      store.printItem();
      BookStore.BookStoreInfo.displayInfo(store.getStoreName(), itemCount);


      System.out.println("Average title length: " + stat.averageTitleLength());
   }
}
