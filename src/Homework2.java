import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    Map<String, String> filesOperator = filesBild();
    cheakOperation(filesOperator);
  }

  public static Map<String, String> filesBild() throws IOException {
    BufferedReader frFiles = new BufferedReader(new FileReader("res/files.txt"));
    int n = Integer.parseInt(frFiles.readLine());
    Map<String, String> filesOperator = new HashMap<>();
    for (int i = 0; i < n; ++i) {
      String line = frFiles.readLine();
      int dot = line.indexOf(' ');
      String files = line.toLowerCase().substring(0, dot);
      String operat = line.toLowerCase().substring(dot + 1);
      filesOperator.put(files, operat);
    }
    frFiles.close();
    return filesOperator;
  }

  public static void cheakOperation(Map<String, String> filesOperator) throws IOException {
    BufferedReader frOperat = new BufferedReader(new FileReader("res/operations.txt"));
    FileWriter fw = new FileWriter("res/results.txt");
    int m = Integer.parseInt(frOperat.readLine());
    for (int i = 0; i < m; ++i) {
      String line = frOperat.readLine();
      int dot = line.indexOf(' ');
      String file = line.toLowerCase().substring(dot + 1);
      String operation = line.toLowerCase().substring(0, dot);
      String operN = operation.substring(0, 1);
      if (filesOperator.containsKey(file)) {
        if (filesOperator.get(file).contains(operN)) {
          fw.write(file + ": " + operation + ": OK\n");
        } else {
          fw.write(file + ": " + operation + ": Access denied\n");
        }
      }
    }
    fw.close();
    frOperat.close();
  }
}

