import java.util.HashMap;
import java.util.Map;

/**
 * Метод получает строку, разбирает ее на отдельные слова с учетом списка разделителей,
 * приводит все слова к верхнему регистру, заносит в HashMap и считает повторы. Выводит в консоль результат.
 */
public class textFormat {
    private final String LIST = "\\s*(\\s|,|\\.|!|\\?|\\\"|\\;|\\:|\\[|\\]|\\(|\\)|\n|\r|\t|\u0085)\\s*";

    public void parseFormat (String text) {
        HashMap<String,Integer > Names = new HashMap<>();
        for (String retval : text.split(LIST)) {
            String val = retval.toUpperCase();
            if (Names.containsKey(val)) {
                int Name = Names.get(val);
                Names.put(val, (Name + 1));
            } else     Names.put(val, 1);
        }
        for (Map.Entry entry : Names.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }

}