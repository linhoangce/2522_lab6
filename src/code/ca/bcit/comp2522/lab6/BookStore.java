package ca.bcit.comp2522.lab6;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class BookStore<T extends Literature>
{
   private static int itemCount = 0;

   private final List<T> items;
   private final String  storeName;

   public BookStore(final String storeName)
   {
      validateName(storeName);

      this.storeName = storeName;
      items = new ArrayList<>();
   }

   public String getStoreName()
   {
      return storeName;
   }

   public static class BookStoreInfo
   {
      public static void displayInfo(final String storeName, final int itemCount)
      {
         System.out.println("BookStore: " + storeName + ", Items: " + itemCount);
      }
   }

   public class BookStoreStatistics
   {
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

   public void addItem(final T item)
   {
      if(item != null)
      {
         items.add(item);
         itemCount++;
      }
   }

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

   public void printBookTitle(final String title)
   {
      items.forEach(item->{
         System.out.println(item.getTitle().contains(title));
      });
   }

   public void printTitlesInAlphaOrder()
   {
      items.sort(Comparator.comparing(Literature::getTitle, String::compareToIgnoreCase));
      items.forEach(item->System.out.println(item.getTitle()));
   }

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

   private static void validateName(final String name)
   {
      if(name == null || name.isBlank())
      {
         throw new IllegalArgumentException("Name must not be empty!");
      }
   }

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
