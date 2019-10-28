import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
   Write a program that checks whether a sequence of HTML tags
   is properly nested. For each opening tag, such as <p>, there
   must be a closing tag </p>. A tag such as <p> may have other
   tags inside, for example <p> <ul> <li> </li> </ul> <a> </a> </p>

   The inner tags must be closed before the outer ones.
   Your program should process a file containing tags.
   For simplicity, assume that the tags are separated by
   spaces, and that there is no text inside the tags.
*/
public class HTMLChecker
{
   public static void main(String[] args)
   {
      String filename = "TagSample1.html";

      try (Scanner in = new Scanner(new File(filename)))
      {
Stack<String> tags = new Stack<>();
         while (in.hasNext()){
            String tag = in.next();
            tags.push(tag);
         }
         Stack<String> test = new Stack<>();
         
         test.push(tags.pop());
         boolean properlyNested = true;
         while (!tags.empty() && properlyNested){
            String tag = tags.pop();
            if (tag.contains("/")){
               test.push(tag);
            }
            else{
               if (tag.charAt(1) == test.peek().charAt(2)){
                  test.pop();
               }
               else{
                  properlyNested = false;
               }
            }
         }
         
         if (!properlyNested){
            System.out.println("The HTML tags are not properly nested.");
         }
         else{
            System.out.println("The HTML tags are properly nested");
         }






      }
      catch (FileNotFoundException e)
      {
         System.out.println("Cannot open: " + filename);
      }

   }
}
