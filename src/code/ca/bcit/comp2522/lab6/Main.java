package ca.bcit.comp2522.lab6;

public class Main
{
   public static void main(String[] args)
   {
      final BookStore<Literature> bookStore;

      bookStore = new BookStore<>();

      bookStore.addItem(new Novel("Z"));
      bookStore.addItem(new ComicBook("Batman"));
      bookStore.addItem(new Magazine("A"));

      bookStore.printTitlesInAlphaOrder();
   }
}