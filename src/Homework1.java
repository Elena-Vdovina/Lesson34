import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Homework1 {
  public static void main(String[] args) throws IOException {
// Напишите программу создания небольшого словаря сленговых программерских выражений,
// чтобы она потом по запросу возвращала значения из этого словаря.
// Формат входных данных
//  Файл dict.txt
//   В первой строке задано одно целое число n — количество слов в словаре.
//   В следующих n строках записаны слова и их определения, разделенные двоеточием и символом пробела.
//  Ввод с клавиатуры
//   В первой строке записано целое число m — количество поисковых слов, чье определение нужно вывести.
//   В следующих m строках записаны сами слова, по одному на строке.
// Формат выходных данных
//  Для каждого слова, независимо от регистра символов, если оно присутствует в словаре,
//  необходимо вывести на экран его определение.
// Если слова в словаре нет, программа должна вывести "Не найдено", без кавычек.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Map<String, String> dictionary = dictBild();
    try {
      int m = Integer.parseInt(br.readLine());
      for (int i = 0; i < m; ++i) {
        String line = br.readLine();
        checkOutput(dictionary, line);
      }
    } catch (NumberFormatException e) {
      System.err.println("Неправильный формат числа: " + e.getMessage());
    }
  }

  public static Map<String, String> dictBild() throws IOException {
    int n = 0;
    Map<String, String> dictionary = new HashMap<>();
    try {
      File inputFile = new File("res/dict.txt");
      BufferedReader fr = new BufferedReader(new FileReader(inputFile));
      try {
        n = Integer.parseInt(fr.readLine());
      } catch (NumberFormatException e) {
        System.err.println("Неправильный формат числа: " + e.getMessage());
        System.exit(1);
      }
      if (n > 0) {
        for (String line = fr.readLine(); line != null; line = fr.readLine()) {
          int dot = line.indexOf(':');
          if (dot > 0) {
            String word = line.toLowerCase().substring(0, dot);
            String definition = line.substring(dot + 2);
            dictionary.put(word, definition);
          }
        }
      }
      fr.close();
    } catch (FileNotFoundException e) {
      System.err.println("Файл не найден: " + e.getMessage());
    }
    return dictionary;
  }

  public static void checkOutput(Map<String, String> dictionary, String line) {
    String word = line.toLowerCase();
    if (dictionary.containsKey(word)) {
      String definition = dictionary.get(word);
      System.out.println(line + ": " + definition);
    } else {
      System.out.println("Не найдено");
    }
  }
}
