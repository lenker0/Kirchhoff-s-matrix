public class Kirchhoffs {

    /**
     * Создание матрицы Кирхгофа и подсчет остовных деревьев
     */
    public int spanningTrees(int[][] tree) {
        int n = tree.length, degree;
        int[][] LaplacianMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            degree = 0;
            for (int j = 0; j < n; j++) {
                degree += tree[i][j];
                LaplacianMatrix[i][j] = -tree[i][j];
            }
            LaplacianMatrix[i][i] = degree;
        }
        System.out.println("Матрица Кирхгофа: ");
        showMatrix(LaplacianMatrix);;
        return calculateMatrix(getMinor(LaplacianMatrix,0,0));
    }

    /**
     * Вывод матрицы (int)
     */
    public void showMatrix(int[][] tree) {
        for (int[] L : tree) {
            System.out.print("|");
            for (int M : L) {
                System.out.print(M + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println();
    }

    /** рекурсивная функция - вычисляет значение определителя. Если на входе
     * определитель 2х2 - просто вычисляем (крест-на-крест),
     * иначе раскладываем на миноры. Для каждого минора вычисляем его
     * определитель, рекурсивно вызывая ту же функцию.
     */
    public int calculateMatrix(int[][] matrix) {
        int calcResult = 0;
        if (matrix.length == 2) {
            calcResult = matrix[0][0] * matrix[1][1] - matrix[1][0]
                    * matrix[0][1];
        } else {
            int koeff = 1;
            for (int i = 0; i < matrix.length; i++)
            {
                if (i % 2 == 1)
                    // проверка на четность для определение коэффициента перед слагаемым
                    koeff = -1;
                else
                    koeff = 1;
                calcResult += koeff * matrix[0][i] * calculateMatrix(this.getMinor(matrix, 0, i));
            }
        }
        return calcResult;
    }

    /**
     * функция, которая возвращает нужный минор. На входе - определитель, из
     * которого надо достать минор
     *  и номера строк-столбцов, которое надо вычеркнуть
     */
    private int[][] getMinor(int[][] matrix, int row, int column) {
        int minorLength = matrix.length - 1;
        int[][] minor = new int[minorLength][minorLength];
        // эти переменные для того, чтобы "пропускать" ненужные нам строку и столбец
        int dI = 0, dJ = 0;
        for (int i = 0; i <= minorLength; i++)
        {
            dJ = 0;
            for (int j = 0; j <= minorLength; j++)
            {
                if (i == row) {
                    dI = 1;
                    break;
                }
                else
                    if (j == column)
                        dJ = 1;
                    else
                        minor[i - dI][j - dJ] = matrix[i][j];
            }
        }
        return minor;
    }

    // неориентированный граф 1
    public void tessCase1() {
        int[][] tree = {{0, 1, 1, 0},
                        {1, 0, 1, 0},
                        {1, 1, 0, 1},
                        {0, 0, 1, 0}};
        System.out.println("Введенный граф: ");
        showMatrix(tree);
        int value = spanningTrees(tree);
        System.out.println("Число остовных деревьев = " + value);
    }

    // неориентированный граф 2
    public void tessCase2() {
        int[][] tree = {{0, 1, 1, 0},
                        {1, 0, 1, 1},
                        {1, 1, 0, 1},
                        {0, 1, 1, 0}};
        System.out.println("Введенный граф: ");
        showMatrix(tree);
        int value = spanningTrees(tree);
        System.out.println("Число остовных деревьев = " + value);
    }

    // несвязный граф
    public void tessCase3() {
        int[][] tree = {{0, 1, 1, 0},
                        {1, 0, 1, 0},
                        {1, 1, 0, 0},
                        {0, 0, 0, 0}};
        System.out.println("Введенный граф: ");
        showMatrix(tree);
        int value = spanningTrees(tree);
        System.out.println("Число остовных деревьев = " + value);
    }

    // ориентированный граф
    public void tessCase4() {
        int[][] tree = {{0, 1, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};
        System.out.println("Введенный граф: ");
        showMatrix(tree);
        int value = spanningTrees(tree);
        System.out.println("Число остовных деревьев = " + value);
    }

    // Полный граф
    public void tessCase5() {
        int[][] tree = {{0, 1, 1, 1},
                        {1, 0, 1, 1},
                        {1, 1, 0, 1},
                        {1, 1, 1, 0}};
        System.out.println("Введенный граф: ");
        showMatrix(tree);
        int value = spanningTrees(tree);
        System.out.println("Число остовных деревьев = " + value);
    }

}
