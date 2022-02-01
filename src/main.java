import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.*;
import java.util.*;

public class main {

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

