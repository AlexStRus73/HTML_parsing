public class incertURL {
    private String url;

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
            return true;
        } else {
            System.out.println("Unvalid URL");
            return false;
        }

    }


    public String getURL () {
        return url;
    }

}
