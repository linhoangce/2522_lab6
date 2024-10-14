package ca.bcit.comp2522.lab6;

import java.util.ArrayList;
import java.util.List;

public class BookStore<T extends Literature>
{
   private final List<T> items = new ArrayList<>();

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
}
