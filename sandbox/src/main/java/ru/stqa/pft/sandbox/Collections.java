package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
  public static void main(String[] args) {
    //массив
    String[] langs = {"Java", "C#", "Python","PHP"};
    for (int i = 0; i < langs.length; i++) {
      System.out.println("Я хочу выучить " + langs[i]);
    }
    for (String l: langs) {
      System.out.println("Я хочу выучить " + l);
    }

    List<String> languages = new ArrayList<String>();
    languages.add("Java");
    languages.add("C#");
    languages.add("PHP");

    //список
    List<String> languagesList = Arrays.asList("Java", "C#", "Python","PHP");
    for (String l: languagesList) {
      System.out.println("Я хочу выучить " + l);
    }

    for (int i = 0; i < languagesList.size(); i++) {
      System.out.println("Я хочу выучить " + languagesList.get(i));
    }
  }
}
