package utils;


public class Helper {

    private static String currentEmail;

    public static String getCurrentEmail() {
        return currentEmail;
    }

    private Helper(){}

    public static String getRandomEmail() {
        String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabacdefghijklmnopqrstuvwxyz";
        StringBuilder randomString = new StringBuilder();
        int sizeResultString = 1 + (int) (Math.round(Math.random() * 9));
        int index;
        for (int i = 1; i <= sizeResultString; i++){
            index = (int) (Math.round(Math.random() * (symbols.length() - 1)));
            randomString.append(symbols.charAt(index));
        }
        currentEmail = randomString + "+wpt@yandex.ru";
        return randomString + "+wpt@yandex.ru";
    }

    public static int getRandomNumber(int number){
        return 1 + (int) (Math.round(Math.random() * (number - 1)));
    }

}
