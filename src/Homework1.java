import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    BufferedReader fr = new BufferedReader(new FileReader("res/dict.txt"));
    int n = Integer.parseInt(fr.readLine());
    Map<String, String> dictionary = new HashMap<>(n);
    for (String line = fr.readLine(); line != null; line = fr.readLine()) {
      int dot = line.indexOf(':');
      String word = line.toLowerCase().substring(0, dot);
      String definition = line.substring(dot + 2);
      dictionary.put(word, definition);
    }
    fr.close();

    int m = Integer.parseInt(br.readLine());
    for (int i = 0; i < m; ++i) {
      String line = br.readLine();
      String word = line.toLowerCase();
      if (dictionary.containsKey(word)) {
        String definition = dictionary.get(word);
        System.out.println(line + ": " + definition);
      } else {
        System.out.println("Не найдено");
      }
    }
  }
}
