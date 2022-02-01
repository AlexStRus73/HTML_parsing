import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.*;
import java.util.*;
import java.util.logging.*;

public class main {
   // private static Logger log = Logger.getLogger(main.class.getName());

  /*  handlers = java.util.logging.FileHandler
    .level= WARNING
    java.util.logging.FileHandler.pattern = application_log.txt
    java.util.logging.FileHandler.limit = 1000000
    java.util.logging.FileHandler.count = 5
    java.util.logging.FileHandler.formatter = java.util.logging.SimpleFormatter*/

    public static void main(String[] args) {
        System.out.println("Please, input web adress...");
        Scanner scanner = new Scanner(System.in);
        incertURL incert = new incertURL(scanner.nextLine());
        textFormat form = new textFormat();
        scanner.close();

        try{
            if (!incert.getURL().isEmpty()) {
                Document doc = Jsoup.connect(incert.getURL()).get();
                String text = doc.text();                            // получаем текст страницы
                form.parseFormat(text);
            }
        } catch(IOException e){
        System.out.println("Ошибка ввода/вывода: "+ e);
    }
    }
}




//https://simbirsoft.com