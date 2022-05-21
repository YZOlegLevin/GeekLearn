package HomeWork3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        //0 = пустое поле 1 = нолик 2 = крестик
        int[][] gameArray = new int[3][3];
        System.out.println();
        System.out.print("Игра в крестики - нолики");
        arrayToString(gameArray);
        System.out.println("Игрок играет за крестики, компьютер за нолики");
        for (int i = 0; i <= 9; i++) {
            System.out.println("Ваш ход. Введите 2 целых числа от 1 до 3, где 1-е число строка, 2-е стобец");
            int line = intScan() - 1;
            if (line > 2 || line < 0) {
                while (line > 2 || line < 0) {
                    System.out.println("Введено неверное значение, введите число от 1 до 3 !");
                    line = intScan();
                }
            }
            int column = intScan() - 1;
            if (column > 2 || column < 0) {
                while (column > 2 || column < 0) {
                    System.out.println("Введено неверное значение, введите число от 1 до 3 !");
                    column = intScan();
                }

            }
            if (gameArray[line][column] != 0) {
                while (true) {
                    int oldTurn = gameArray[line][column];

                    System.out.println("Поле уже занято ! Выберете другие значения.");
                    line = intScan() - 1;
                    if (line > 2 || line < 0) {
                        while (line > 2 || line < 0) {
                            System.out.println("Введено неверное значение, введите число от 1 до 3 !");
                            line = intScan();
                        }
                    }
                    column = intScan() - 1;
                    if (column > 2 || column < 0) {
                        while (column > 2 || column < 0) {
                            System.out.println("Введено неверное значение, введите число от 1 до 3 !");
                            column = intScan();
                        }
                    }
                    int newTurn = gameArray[line][column];
                    if (newTurn != oldTurn && newTurn == 0) {
                        gameArray[line][column] = 2;
                        break;
                    }
                }
            } else gameArray[line][column] = 2;
            arrayToString(gameArray);
            System.out.print("Ход компьютера.");
            while (true) {
                int test = 0;
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        test += gameArray[j][k];
                    }
                }
                if (test >= 14) break;
                int computerLine = random.nextInt(0, 3);
                int computerColumn = random.nextInt(0, 3);
                int computerTurn = gameArray[computerLine][computerColumn];
                if (computerTurn == 0) {
                    gameArray[computerLine][computerColumn] = 1;
                    break;
                }
            }
            arrayToString(gameArray);
            int winCount = 0;
            for (int j = 0; j < 9; j++) {
                if (gameArray[0][0] == 2 && gameArray[1][1] == 2 && gameArray[2][2] == 2) {
                    System.out.println("ПОБЕДИЛ ИГРОК !");
                    winCount++;
                    break;
                } else if (gameArray[0][0] == 1 && gameArray[1][1] == 1 && gameArray[2][2] == 1) {
                    System.out.println("ПОБЕДИЛ КОМПЬЮТЕР !");
                    winCount++;
                    break;
                } else if (gameArray[0][2] == 2 && gameArray[1][1] == 2 && gameArray[2][0] == 2) {
                    System.out.println("ПОБЕДИЛ ИГРОК !");
                    winCount++;
                    break;
                } else if (gameArray[0][2] == 1 && gameArray[1][1] == 1 && gameArray[2][0] == 1) {
                    System.out.println("ПОБЕДИЛ КОМПЬЮТЕР !");
                    winCount++;
                    break;
                } else if (gameArray[0][0] == 2 && gameArray[0][1] == 2 && gameArray[0][2] == 2) {
                    System.out.println("ПОБЕДИЛ ИГРОК !");
                    winCount++;
                    break;
                } else if (gameArray[0][0] == 1 && gameArray[0][1] == 1 && gameArray[0][2] == 1) {
                    System.out.println("ПОБЕДИЛ КОМПЬЮТЕР !");
                    winCount++;
                    break;
                } else if (gameArray[1][0] == 2 && gameArray[1][1] == 2 && gameArray[1][2] == 2) {
                    System.out.println("ПОБЕДИЛ ИГРОК !");
                    winCount++;
                    break;
                } else if (gameArray[1][0] == 1 && gameArray[1][1] == 1 && gameArray[1][2] == 1) {
                    System.out.println("ПОБЕДИЛ КОМПЬЮТЕР !");
                    winCount++;
                    break;
                } else if (gameArray[2][0] == 2 && gameArray[2][1] == 2 && gameArray[2][2] == 2) {
                    System.out.println("ПОБЕДИЛ ИГРОК !");
                    winCount++;
                    break;
                } else if (gameArray[2][0] == 1 && gameArray[2][1] == 1 && gameArray[2][2] == 1) {
                    System.out.println("ПОБЕДИЛ КОМПЬЮТЕР !");
                    winCount++;
                    break;
                } else if (gameArray[0][0] == 2 && gameArray[1][0] == 2 && gameArray[2][0] == 2) {
                    System.out.println("ПОБЕДИЛ ИГРОК !");
                    winCount++;
                    break;
                } else if (gameArray[0][0] == 1 && gameArray[1][0] == 1 && gameArray[2][0] == 1) {
                    System.out.println("ПОБЕДИЛ КОМПЬЮТЕР !");
                    winCount++;
                    break;
                } else if (gameArray[0][1] == 2 && gameArray[1][1] == 2 && gameArray[2][1] == 2) {
                    System.out.println("ПОБЕДИЛ ИГРОК !");
                    winCount++;
                    break;
                } else if (gameArray[0][1] == 1 && gameArray[1][1] == 1 && gameArray[2][1] == 1) {
                    System.out.println("ПОБЕДИЛ КОМПЬЮТЕР !");
                    winCount++;
                    break;
                } else if (gameArray[0][2] == 2 && gameArray[1][2] == 2 && gameArray[2][2] == 2) {
                    System.out.println("ПОБЕДИЛ ИГРОК !");
                    winCount++;
                    break;
                } else if (gameArray[0][1] == 1 && gameArray[1][1] == 1 && gameArray[2][1] == 1) {
                    System.out.println("ПОБЕДИЛ КОМПЬЮТЕР !");
                    winCount++;
                    break;
                }
            }
            if (winCount > 0) break;
        }
    }


    static int intScan() {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Введите целое число");
                scanner.next();
            }
        }
    }

    static void arrayToString(int[][] array) {
        String game = "\n---------------\n";
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                if (array[i - 1][j - 1] == 0) game += "|   |";
                else if (array[i - 1][j - 1] == 2) game += "| X |";
                else if (array[i - 1][j - 1] == 1) game += "| O |";
                if (j == 3) game += "\n---------------\n";
            }
        }
        System.out.println();
        System.out.println(game);
        System.out.println();
    }

    static void printArray(int[] array) {
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }

    static void printArray(int[][] array) {
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    static int[] createRandomIntArray(int size, int min, int max) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(min, max);
        }

        return array;
    }

}


