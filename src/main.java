import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.*;
import java.util.*;
import java.util.logging.*;

public class main {
    private static final Logger logger = Logger.getLogger(main.class.getName());

    public static void main(String[] args) throws Exception {
        try {
            LogManager.getLogManager().readConfiguration(
                    main.class.getResourceAsStream("/log.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
        Handler filehandler = new FileHandler();
        logger.setUseParentHandlers(false);
        logger.addHandler(filehandler);

        System.out.println("Please, input web adress...");
        Scanner scanner = new Scanner(System.in);
        incertURL incert = new incertURL(scanner.nextLine());
        logger.log(Level.INFO, "Пользователь завершил ввод");
        textFormat form = new textFormat();
        scanner.close();

        try{
            if (!incert.getURL().isEmpty()) {
                Document doc = Jsoup.connect(incert.getURL()).get();
                String text = doc.text();                            // получаем текст страницы
                logger.log(Level.INFO, "Парсинг проведен успешно");
                form.parseFormat(text);
            }
        } catch(IOException e){
        System.out.println("Ошибка ввода/вывода: "+ e);
        logger.log(Level.WARNING, "Ошибка ввода/вывода", new Throwable());
    }
    }
}

