import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Homework2 {
  public static void main(String[] args) throws IOException {
// В файловую систему одного суперкомпьютера проник вирус, который сломал контроль за правами
// доступа к файлам. Для каждого файла известно, с какими действиями можно к нему обращаться:
//    запись W,
//    чтение R,
//    запуск X.
// Файл files.txt
//   В первой строке содержится число N — количество файлов, содержащихся в данной файловой системе.
//   В следующих N строчках содержатся имена файлов и допустимых с ними операций, разделенные
//   пробелами.
// Файл operations.txt
//   Далее указано чиcло M — количество запросов к файлам.
//   В последних M строках указан запрос вида Операция Файл.
//   К одному и тому же файлу может быть применено любое количество запросов.
// Вам требуется восстановить контроль над правами доступа к файлам.
// Файл results.txt
// Ваша программа для каждого запроса должна будет выводить Файл: Операция: OK, если над файлом
// выполняется допустимая операция, или же Файл: Операция: Access denied, если операция недопустима.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Map<String, String> filesOperator = new HashMap<>();
    for (int i = 0; i < n; ++i) {
      String line = br.readLine();
      int dot = line.indexOf(' ');
      String files = line.toLowerCase().substring(0, dot);
      String operat = line.toLowerCase().substring(dot + 1);
      filesOperator.put(files, operat);
    }
    int m = Integer.parseInt(br.readLine());
    for (int i = 0; i < m; ++i) {
      String line = br.readLine();
      int dot = line.indexOf(' ');
      String file = line.toLowerCase().substring(dot + 1);
      String operation = line.toLowerCase().substring(0, dot);
      String operN = operation.substring(0, 1);
      if (filesOperator.containsKey(file)) {
        if (filesOperator.get(file).contains(operN)) {
          System.out.println(file + ": " + operation + ": OK");
        } else {
          System.out.println(file + ": " + operation + ": Access denied");
        }
      }
    }
  }
}
