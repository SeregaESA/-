import com.sun.xml.internal.fastinfoset.util.CharArray;


import java.io.IOException;
import java.util.Scanner;

public class SeregaMain {


    public static void main(String[] args) {

        Scanner scaner = new Scanner(System.in);
        String input = scaner.nextLine();
        System.out.println(calc(input));
    }

    public static String calc(String input) {
        String[] array = input.split(" ");
        char char1 = array[0].charAt(0);
        char char2 = array[2].charAt(0);
        if (Character.isLetter(char1) && Character.isLetter(char2) && (array.length == 3)) {
            SeregaArab a = SeregaArab.valueOf(array[0]);
            SeregaArab b = SeregaArab.valueOf(array[2]);
            int two = b.getTranslation();
            int one = a.getTranslation();
            switch (array[1]) {
                case "+":
                    Rim rim1 = new Rim();
                        return rim1.rimOut((one + two));
                case "-":
                    Rim rim2 = new Rim();
                        return rim2.rimOut((one - two));
                case "*":
                    Rim rim3 = new Rim();
                        return rim3.rimOut((one * two));
                case "/":
                    Rim rim4 = new Rim();
                        return rim4.rimOut((one / two));
                default:
                    throw new RuntimeException("Неверная арифметическая операция");
            }

        } else if (!(Character.isLetter(char1)) && !(Character.isLetter(char2)) && (array.length == 3)) {
            int one = Integer.parseInt(array[0]);
            int two = Integer.parseInt(array[2]);
            if ((one > 0) && (one <= 10) && (two > 0) && (two <= 10)) {
                switch (array[1]) {
                    case "+":
                        return String.valueOf((one + two));
                    case "-":
                        return String.valueOf((one - two));
                    case "*":
                        return String.valueOf((one * two));
                    case "/":
                        return String.valueOf((one / two));
                    default:
                        throw new RuntimeException("Неверная арифметическая операция");
                }
            } else {
                throw new RuntimeException("Введено не подходящее число");
            }
        }
        else {
            throw new RuntimeException("Введено неверное выражение");
        }
    }

}
 class Rim {
    String rimOut(int rew)  {
        int[] rimOne = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1};
        String [] rimTwo = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String result = "";
        if (rew >= 1) {
            for (int i = 0; i < rimOne.length; i++){
                while (rew >= rimOne[i]){
                    result += rimTwo[i];
                    rew -= rimOne[i];
                }
            }
        } else {
            throw new RuntimeException("Результат меньше 0");
        }
        return result;
    }
}








