public class incertURL {
    private String URL;

    public incertURL (String URL){              //Объявляем конструктор
        if (validURL(URL)) this.URL = URL;
        else this.URL = "";
    }

    public boolean validURL (String URL) {      // Метод, проверяющий URL на валидность
        if(URL.matches("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]")) {
            System.out.println("String contains URL");
            return true;
        } else {
            System.out.println("Unvalid URL");
            return false;
        }

    }


    public String getURL () {
        return URL;
    }

}
