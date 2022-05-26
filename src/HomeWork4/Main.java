package HomeWork4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static int size = 3;
    static int[][] gameArray = new int[size][size];
    static int round = 0;


    public static void main(String[] args) {

        startGame();

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
        String game = "☢ ";
        for (int i = 1; i <= size; i++) {
            game += "_" + i + "_";
        }
        game += "\n";
        for (int i = 1; i < size + 1; i++) {
            game += i + "|";
            for (int j = 1; j < size + 1; j++) {
                if (array[i - 1][j - 1] == 0) game += " - ";
                else if (array[i - 1][j - 1] == 100) game += " Х ";
                else if (array[i - 1][j - 1] == 1) game += " О ";
                if (j == size) game += "\n";
            }
        }
        System.out.println(game);
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

    static void sayHallo() {
        System.out.println();
        System.out.println("Короче Меченый, я написал этот код и в благородства играть не буду, сыграем в крестики-нолики и мы в расчёте.");
        System.out.println("Заодно посмотрим как быстро у тебя башка после Git,a прояснится.\nА по твоей теме постараюсь разузнать. Хрен его знает на кой ляд тебе эта Java сдалась,");
        System.out.println("но я в чужие дела не лезу, хочешь кодить значит есть зачем.");
        System.out.println();
    }

    static void playerTurn() {
        System.out.println("Ваш ход. Введите 2 целых числа от 1 до " + size + ", где 1-е число строка, 2-е стобец.");
        int line = intScan() - 1;
        if (line > size - 1 || line < 0) {
            while (line > size - 1 || line < 0) {
                System.out.println("Введено неверное значение, введите число от 1 до " + size + " !");
                line = intScan() - 1;
            }
        }
        int column = intScan() - 1;
        if (column > size - 1 || column < 0) {
            while (column > size - 1 || column < 0) {
                System.out.println("Введено неверное значение, введите число от 1 до " + size + " !");
                column = intScan() - 1;
            }

        }
        if (gameArray[line][column] != 0) {
            while (true) {
                int oldTurn = gameArray[line][column];

                System.out.println("Поле уже занято ! Выберете другие значения.");
                line = intScan() - 1;
                if (line > size - 1 || line < 0) {
                    while (line > size - 1 || line < 0) {
                        System.out.println("Введено неверное значение, введите число от 1 до " + size + " !");
                        line = intScan() - 1;
                    }
                }
                column = intScan() - 1;
                if (column > size - 1 || column < 0) {
                    while (column > size - 1 || column < 0) {
                        System.out.println("Введено неверное значение, введите число от 1 до " + size + " !");
                        column = intScan() - 1;
                    }
                }
                int newTurn = gameArray[line][column];
                if (newTurn != oldTurn && newTurn == 0) {
                    gameArray[line][column] = 100;
                    break;
                }
            }
        } else gameArray[line][column] = 100;
        arrayToString(gameArray);
    }

    static void computerTurn() {
        System.out.println("Ход компьютера");
        while (true) {

            int computerLine = random.nextInt(0, size);
            int computerColumn = random.nextInt(0, size);
            int computerTurn = gameArray[computerLine][computerColumn];
            if (computerTurn == 0) {
                gameArray[computerLine][computerColumn] = 1;
                break;
            }
        }
        arrayToString(gameArray);

    }

    static boolean checkVictory() {
        int victoryCount1 = 0;
        for (int i = 0; i < size; i++) {
            int verticalLine = 0;
            int horizontalLine = 0;
            for (int j = 0; j < size; j++) {
                verticalLine += gameArray[j][i];
                horizontalLine += gameArray[i][j];
                if (verticalLine == 100 * (size - round)) {
                    System.out.println("ПОБЕДИЛ ИГРОК ! ");
                    victoryCount1++;
                    return true;
                } else if (verticalLine == (size - round)) {
                    System.out.println("ПОБЕДИЛ КОМПЬЮТЕР ! ");
                    victoryCount1++;
                    return true;
                } else if (horizontalLine == (size - round)) {
                    System.out.println("ПОБЕДИЛ КОМПЬЮТЕР ! ");
                    victoryCount1++;
                    return true;
                } else if (horizontalLine == 100 * (size - round)) {
                    System.out.println("ПОБЕДИЛ ИГРОК ! ");
                    victoryCount1++;
                    return true;
                }


            }

        }

        int victoryCount2 = 0;
        int leftDiagonal = 0;
        int rightDiagonal = 0;
        for (int i = 0; i < size; i++) {


            leftDiagonal += gameArray[i][i];
            rightDiagonal += gameArray[i][gameArray.length - 1 - i];
            if (leftDiagonal == 100 * (size - round)) {
                System.out.println("ПОБЕДИЛ ИГРОК ! ");
                victoryCount2++;
                return true;
            } else if (leftDiagonal == (size - round)) {
                System.out.println("ПОБЕДИЛ КОМПЬЮТЕР ! ");
                victoryCount2++;
                return true;
            } else if (rightDiagonal == (size - round)) {
                System.out.println("ПОБЕДИЛ КОМПЬЮТЕР ! ");
                victoryCount2++;
                return true;
            } else if (rightDiagonal == 100 * (size - round)) {
                System.out.println("ПОБЕДИЛ ИГРОК ! ");
                victoryCount2++;
                return true;
            }

        }
        leftDiagonal = 0;
        int leftDiagonal2 = 0;
        rightDiagonal = 0;
        int rightDiagonal2 = 0;
        int victoryCount3 = 0;

        for (int i = 0; i < round; i++) {
            for (int j = 0; j < gameArray[i].length - round + i; j++) {
                leftDiagonal += gameArray[j + round - i][j];
                leftDiagonal2 += gameArray[j][j + round - i];
                if (leftDiagonal == 100 * (size - round) || leftDiagonal2 == 100 * (size - round)) {
                    System.out.println("ПОБЕДИЛ ИГРОК ! ");
                    victoryCount3++;
                    return true;
                } else if (leftDiagonal == (size - round) || leftDiagonal2 == (size - round)) {
                    System.out.println("ПОБЕДИЛ КОМПЬЮТЕР ! ");
                    victoryCount3++;
                    return true;
                }

            }
            if (victoryCount3 > 0) {
                break;
            }
            leftDiagonal = 0;
            leftDiagonal2 = 0;
        }
        if (victoryCount3 == 0) {
            for (int i = 0; i < round; i++) {
                for (int j = 0; j < gameArray[i].length + i - round; j++) {
                    rightDiagonal += gameArray[j][gameArray.length - 1 + i - round - j];
                    rightDiagonal2 += gameArray[gameArray.length - 1 - j][round - i + j];
                    if (rightDiagonal == (size - round) || rightDiagonal2 == (size - round)) {
                        System.out.println("ПОБЕДИЛ КОМПЬЮТЕР ! ");
                        victoryCount3++;
                        return true;
                    } else if (rightDiagonal == 100 * (size - round) || rightDiagonal2 == 100 * (size - round)) {
                        System.out.println("ПОБЕДИЛ ИГРОК ! ");
                        victoryCount3++;
                        return true;
                    }

                }
                if (victoryCount3 > 0) {
                    break;
                }
                rightDiagonal = 0;
                rightDiagonal2 = 0;
            }
        }


        if (victoryCount2 == 0 && victoryCount1 == 0 && victoryCount3 == 0) {
            int turnCount = 0;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (gameArray[i][j] == 0) {
                        turnCount++;
                    }
                }
            }
            if (turnCount == 0) {
                System.out.println("ХОДОВ БОЛЬШЕ НЕТ. НИЧЬЯ !");
                turnCount = 0;
                return true;
            }
        }

        return false;
    }

    static boolean continueGame() {
        System.out.println();
        System.out.println("Продолжаем игру ? Напишите 'ДА' или 'НЕТ'");
        scanner.nextLine();
        String answer = scanner.nextLine();
        if ("ДА".equalsIgnoreCase(answer)) {
            return true;
        } else if ("НЕТ".equalsIgnoreCase(answer)) {
            return false;
        } else {
            while (true) {
                System.out.println("Непонятный ответ ! Напишите 'ДА' или 'НЕТ'");
                answer = scanner.nextLine();
                if ("ДА".equalsIgnoreCase(answer)) {
                    return true;
                } else if ("НЕТ".equalsIgnoreCase(answer)) {
                    return false;
                }
            }
        }

    }

    static void startGame() {
        sayHallo();

        while (true) {
            System.out.println("Раунд : " + (round + 1) + "\tПоле : " + size + " Х " + size);
            System.out.println("Игрок играет за крестики, компьютер за нолики.");
            System.out.println("Количесвто крестиков или ноликов, которе нужно набрать для победы : " + (size - round) + "\n");
            for (int i = 0; i <= size * size; i++) {
                boolean stopGame = checkVictory();
                if (stopGame == true) {
                    break;
                }
                playerTurn();
                stopGame = checkVictory();
                if (stopGame == true) {
                    break;
                }
                computerTurn();

            }
            boolean nextRound = continueGame();
            if (nextRound == false) {
                System.out.println("Ну провертришься - заходи !");
                break;
            } else if (nextRound == true) {
                round++;
                size += 2;
                gameArray = new int[size][size];
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        gameArray[i][j] = 0;
                    }

                }
            }

        }

    }
}




