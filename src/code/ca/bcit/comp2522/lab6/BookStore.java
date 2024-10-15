package ca.bcit.comp2522.lab6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookStore<T extends Literature>
{
   private final List<T> items;

   public BookStore()
   {
      items = new ArrayList<>();
   }

   public List<T> getItems()
   {
      return items;
   }

   public void addItem(final T item)
   {
      if(item != null)
      {
         items.add(item);
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

   public void printBookTitle(String title)
   {
      items.forEach(item ->
      {
         if (item.getTitle().contains(title))
         {
            System.out.println(item.getTitle());
         }
      });
   }

   public void printTitlesInAlphaOrder()
   {
      items.sort((o1, o2) -> o1.getTitle().compareToIgnoreCase(o2.getTitle()));
      items.forEach(item -> System.out.println(item.getTitle()));
   }

   public void addNovelsToCollection(List<? super Novel> novelCollection)
   {
      for (T item : items)
      {
         if (item instanceof Novel)
         {
            novelCollection.add((Novel) item);
         }
      }
   }

   static class BookStoreInfo
   {
      public void displayInfo(String storeName, int itemCount)
      {
         System.out.println("BookStore: " + storeName + ", Items: " + itemCount);
      }
   }

   class NovelStatistics
   {
      public double averageTitleLength()
      {
         int totalLength = 0;
         for (T item : items)
         {
            totalLength += item.getTitle().length();
         }
         return (double) totalLength / items.size();
      }
   }
}
