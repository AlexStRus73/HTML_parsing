import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.*;
import java.util.*;

public class main {

    public static void main(String[] args) {
        System.out.println("Please, input web adress...");
        Scanner scanner = new Scanner(System.in);
        incertURL incert = new incertURL(scanner.nextLine());
        scanner.close();
        HashMap<String,Integer > Names = new HashMap<>();

        try{
            if (!incert.getURL().isEmpty()) {
                Document doc = Jsoup.connect(incert.getURL()).get();
                String text = doc.text();                            // получаем текст страницы
                for (String retval : text.split("\\s*(\\s|,|\\.|!|\\?|\\\"|\\;|\\:|\\[|\\]|\\(|\\)|\n|\r|\t)\\s*")) {
                    if (Names.containsKey(retval)) {                //если значение ключа ранее уже было внесено - прибавляй 1
                        int Name = Names.get(retval);
                        Names.put(retval,(Name+1));
                    } else {Names.put(retval, 1);}                  //иначе вносим
                }
                for (Map.Entry entry: Names.entrySet()) {           //вывод HashMap в консоль
                    System.out.println(entry);
                }
                }
        } catch(IOException e){
        System.out.println("Ошибка ввода/вывода: "+ e);
    }
    }
}



// ' ', ',', '.', '!', '?', '"', ';', ':', '[', ']', '(', ')', '\n', '\r', '\t'
//https://simbirsoft.com