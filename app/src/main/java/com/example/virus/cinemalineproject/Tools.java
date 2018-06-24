package com.example.virus.cinemalineproject;

public class Tools {
    public static String getNames(String actors) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < actors.length(); i++) {
            if (actors.charAt(i) != '<')
                sb.append(actors.charAt(i));
            else if (actors.charAt(i) == '<') {
                while (actors.charAt(i) != '>')
                    i++;
            }

        }
        return sb.toString();
    }

    public static String changeImageUrlToBiggerSize(String url) {
        StringBuffer temp = new StringBuffer(url);
        for (int i = temp.length() - 1; i > 0; i--) {
            if (temp.charAt(i) == '/') {
                temp.deleteCharAt(i + 1);
                return temp.toString();

            }
        }
        return temp.toString();
    }

        public static String changeImageUrlToBiggestSize(String url) {
            StringBuffer temp = new StringBuffer(url);
            for (int i = temp.length() - 1; i > 0; i--) {
                if (temp.charAt(i) == '/') {
                    temp.deleteCharAt(i + 1);
                    temp.deleteCharAt(i + 1);
                    temp.deleteCharAt(i + 1);
                    return temp.toString();

                }
            }
        return temp.toString();
    }
}