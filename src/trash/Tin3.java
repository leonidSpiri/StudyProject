package trash;

import java.util.Scanner;

public class Tin3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] modes = new int[n][k];
        for (int i = 0; i < n; i++) {
            int mode = scanner.nextInt() - 1;
            modes[i][mode] = 1;
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            boolean found = false;
            for (int j = 0; j < k; j++) {
                if (modes[a][j] == 1 && modes[b][j] == 1) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                result++;
                for (int j = 0; j < k; j++) {
                    if (modes[a][j] == 1 || modes[b][j] == 1) {
                        modes[a][j] = 1;
                        modes[b][j] = 1;
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }
}

/*
Нина работает в исследовательском центре, сотрудники которого наблюдают за движением звезд.

В центре есть n телескопов, которые можно использовать для наблюдения за звездами. Каждый из телескопов может работать в одном из k режимов. С предыдущей серии наблюдений телескоп с номером i находится в режиме pi.

Для качественного наблюдения за одной звездой необходимо одновременно использовать 2 различных телескопа, включенных в одинаковом режиме. Следующей ночью ученые планируют провести наблюдения за m звездами, причем звезду i исследователи хотят увидеть с помощью телескопов ai и bi.

Нине поручили переключить минимальное количество телескопов в нужные режимы заранее так, чтобы можно было качественно пронаблюдать все m звезд, не меняя режимы во время следующих наблюдений. Конечно же, Нина справилась со своей задачей и знает, сколько телескопов ей пришлось переключить. А сможете ли найти это число вы?

Формат входных данных

В первой строке дано три целых числа n,m,k — количество телескопов, количество звезд и количество режимов у телескопа.
Во второй строке дано n разделённых пробелами целых чисел  — режимы, в которых остались телескопы с предыдущего наблюдения.
В каждой из следующих m строк находится по два целых числа ai и bi — номера телескопов, которые необходимо использовать для наблюдения за звездой.

Формат выходных данных

Выведите одно целое число — минимальное количество телескопов, которые необходимо перевести в другой режим, чтобы пронаблюдать все m звезд.

Пример 1
Ввод =
3 2 3
1 2 3
1 2
1 3

Вывод = 2

Пример 2
Ввод =
4 3 3
1 1 3 3
1 2
2 1
3 4

Вывод = 0
*/