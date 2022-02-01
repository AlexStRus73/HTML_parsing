import java.util.logging.Level;
import java.util.logging.Logger;

public class incertURL {
    private String url;
    private static final Logger logger = Logger.getLogger(main.class.getName());
    public incertURL (String URL){
        if (validURL(URL)) this.url = URL;
        else this.url = "";
    }

    /**
     * Метод, проверяющий URL на валидность.
     */
    public boolean validURL (String URL) {
        if(URL.matches("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]")) {
            System.out.println("String contains URL");
            logger.log(Level.INFO, "Пользователь ввел корректный URL");
            return true;
        } else {
            System.out.println("Unvalid URL");
            logger.log(Level.WARNING, "Некорректный URL", new Throwable());
            return false;
        }

    }


    public String getURL () {
        return url;
    }

}
