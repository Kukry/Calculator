import java.util.Scanner;
enum Rim
{
    I(1,"I"), II(2, "II"), III(3,"III"), IV(4,"IV"),
    V(5,"V"), VI(6, "VI"), VII(7, "VII"), VIII(8,"VIII"),
    IX(9, "IX"), X(10, "X"), XI(11, "XI"), XII(12, "XII"),
    XIII(13,"XIII"), XIV(14,"XIV"), XV(15,"XV"), XVI(16,"XVI"),
    XVII(17,"XVII"), XVIII(18,"XVIII"), XIX(19,"XIX"), XX(20,"XX"),
    XXI(21,"XXI"), XXIV(24,"XXIV"), XXV(25,"XXV"), XXVII(27,"XXVII"),
    XXVIII(28,"XXVIII"), XXX(30,"XXX"), XXXII(32,"XXXII"), XXXV(35,"XXXV"),
    XXXVI(36,"XXXVI"),    XL(40,"XL"), XLII(42,"XLII"), XLV(45,"XLV"),
    XLVIII(48,"XLVIII"), L(50,"L"), LIV(54,"LIV"), LVI(56,"LVI"),
    LX(60, "LX"), LXIII(63,"LXIII"), LXIV(64,"LXIV"), LXX(70,"LXX"),
    LXXII(72,"LXXII"), LXXX(80,"LXXX"), LXXXI(81,"LXXXI"), XC(90,"XC"),
    C(100,"C");
    private final int arabNum;
    private final String rimNum;
    Rim(int arabNum, String rimNum)
    {
        this.arabNum = arabNum;
        this.rimNum = rimNum;
    }
    public int getArabNum()
    {
        return arabNum;
    }
    public String getRimNum()
    {
        return rimNum;
    }
}
class Shablon {
    boolean checkShablon(String str) {
        int spaceCount = 0;
        boolean check = true;
        String str1 = str.trim();
        for( char c : str1.toCharArray())
        {
            if (c == ' ')
            {
                spaceCount++;
            }
        }
        if (spaceCount == 2) {
            char[] my = str1.toCharArray();
            for (int i = 0; i < my.length; i++) {
                if (my[i] == ' ' && my[i + 1] == ' ') {
                    check = false;
                    return check;
                } else check = true;
            }
            for (int i = 0; i < my.length; i++) {
                if (my[i] == ' ' && my[i + 1] != ' ') {
                    if (my[i + 2] == ' ') {
                    check = true;
                    break;}
                    else if (my[i + 2] != ' ')
                    { check = false; break;}
                } else check = false;
            }
        } else check =false;
        return check;
    }
}
class Func {

    int func(int x, String operation, int y) {
        int rez = 0;
        switch (operation) {
            case "+":
                rez = x + y;
                break;
            case "-":
                rez = x - y;
                break;
            case "*":
                rez = x * y;
                break;
            case "/":
                rez = x / y;
                break;
            default:
        }
        return rez;
    }
}
public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("""
                Калькулятор умеет считать целые числа от 1 до 10 включительно
                Использовать можно как арабские так и римские цифры
                Используемый формат ввода данных 'x o y', где х и у операнды, а о - операция (+ - * /)
                Между операцией и операндом необходимо ввести пробел
                Команда 'exit' завершает работу калькулятора""");
        while (!input.equals("exit")) {
            System.out.println("\nВведите арифметическую операцию в формате 'x о y', пример: '2 + 5' или 'VI / II'");
            System.out.print(calc(input.nextLine())); }
    }
    public static String calc(String input) {
        Shablon shablon = new Shablon();
        Func func = new Func();
        int x = 0;
        int y = 0;
        int rez;
        String output = null;
        if (input.equals("exit")) {System.exit(0);}
        else {
            if (input.length() > 4 && input.length() < 12) {
                if (shablon.checkShablon(input)) {
                    String[] operation = input.split(" ");
                    if (operation[0].charAt(0) == '-' || operation[2].charAt(0) == '-') {
                        try {
                            throw new Exception();
                        } catch (Exception e) {
                            output = "Ошибка - введено отрицательное число";
                        }
                    } else if (operation[0].charAt(0) == '0' || operation[2].charAt(0) == '0') {
                        try {
                            throw new Exception();
                        } catch (Exception e) {
                            output = "Ошибка - введен 0";
                        }
                    } else if (operation[1].charAt(0) != '+' && operation[1].charAt(0) != '-'
                            && operation[1].charAt(0) != '*' && operation[1].charAt(0) != '/') {
                        try {
                            throw new Exception();
                        } catch (Exception e) {
                            output = "Ошибка - введена неверная операция";
                        }
                    } else //если нет ошибок - отрицательные, 0, неверная операция
                    {
                        if ((operation[0].equals("I") || operation[0].equals("II") || operation[0].equals("III") || operation[0].equals("IV")
                                || operation[0].equals("V") || operation[0].equals("VI") || operation[0].equals("VII") || operation[0].equals("VIII")
                                || operation[0].equals("IX") || operation[0].equals("X")) &&
                                (operation[2].equals("I") || operation[2].equals("II") || operation[2].equals("III") || operation[2].equals("IV")
                                        || operation[2].equals("V") || operation[2].equals("VI") || operation[2].equals("VII") || operation[2].equals("VIII")
                                        || operation[2].equals("IX") || operation[2].equals("X"))) {
                            switch (operation[0]) {
                                case "I":
                                    x = Rim.I.getArabNum();
                                    break;
                                case "II":
                                    x = Rim.II.getArabNum();
                                    break;
                                case "III":
                                    x = Rim.III.getArabNum();
                                    break;
                                case "IV":
                                    x = Rim.IV.getArabNum();
                                    break;
                                case "V":
                                    x = Rim.V.getArabNum();
                                    break;
                                case "VI":
                                    x = Rim.VI.getArabNum();
                                    break;
                                case "VII":
                                    x = Rim.VII.getArabNum();
                                    break;
                                case "VIII":
                                    x = Rim.VIII.getArabNum();
                                    break;
                                case "IX":
                                    x = Rim.IX.getArabNum();
                                    break;
                                case "X":
                                    x = Rim.X.getArabNum();
                                    break;
                                default:
                            }
                            switch (operation[2]) {
                                case "I":
                                    y = Rim.I.getArabNum();
                                    break;
                                case "II":
                                    y = Rim.II.getArabNum();
                                    break;
                                case "III":
                                    y = Rim.III.getArabNum();
                                    break;
                                case "IV":
                                    y = Rim.IV.getArabNum();
                                    break;
                                case "V":
                                    y = Rim.V.getArabNum();
                                    break;
                                case "VI":
                                    y = Rim.VI.getArabNum();
                                    break;
                                case "VII":
                                    y = Rim.VII.getArabNum();
                                    break;
                                case "VIII":
                                    y = Rim.VIII.getArabNum();
                                    break;
                                case "IX":
                                    y = Rim.IX.getArabNum();
                                    break;
                                case "X":
                                    y = Rim.X.getArabNum();
                                    break;
                                default:
                            }
                            rez = func.func(x, operation[1], y);
                            switch (rez) {
                                case 1:
                                    output = Rim.I.getRimNum();
                                    break;
                                case 2:
                                    output = Rim.II.getRimNum();
                                    break;
                                case 3:
                                    output = Rim.III.getRimNum();
                                    break;
                                case 4:
                                    output = Rim.IV.getRimNum();
                                    break;
                                case 5:
                                    output = Rim.V.getRimNum();
                                    break;
                                case 6:
                                    output = Rim.VI.getRimNum();
                                    break;
                                case 7:
                                    output = Rim.VII.getRimNum();
                                    break;
                                case 8:
                                    output = Rim.VIII.getRimNum();
                                    break;
                                case 9:
                                    output = Rim.IX.getRimNum();
                                    break;
                                case 10:
                                    output = Rim.X.getRimNum();
                                    break;
                                case 11:
                                    output = Rim.XI.getRimNum();
                                    break;
                                case 12:
                                    output = Rim.XII.getRimNum();
                                    break;
                                case 13:
                                    output = Rim.XIII.getRimNum();
                                    break;
                                case 14:
                                    output = Rim.XIV.getRimNum();
                                    break;
                                case 15:
                                    output = Rim.XV.getRimNum();
                                    break;
                                case 16:
                                    output = Rim.XVI.getRimNum();
                                    break;
                                case 17:
                                    output = Rim.XVII.getRimNum();
                                    break;
                                case 18:
                                    output = Rim.XVIII.getRimNum();
                                    break;
                                case 19:
                                    output = Rim.XIX.getRimNum();
                                    break;
                                case 20:
                                    output = Rim.XX.getRimNum();
                                    break;
                                case 21:
                                    output = Rim.XXI.getRimNum();
                                    break;
                                case 24:
                                    output = Rim.XXIV.getRimNum();
                                    break;
                                case 25:
                                    output = Rim.XXV.getRimNum();
                                    break;
                                case 27:
                                    output = Rim.XXVII.getRimNum();
                                    break;
                                case 28:
                                    output = Rim.XXVIII.getRimNum();
                                    break;
                                case 30:
                                    output = Rim.XXX.getRimNum();
                                    break;
                                case 32:
                                    output = Rim.XXXII.getRimNum();
                                    break;
                                case 35:
                                    output = Rim.XXXV.getRimNum();
                                    break;
                                case 36:
                                    output = Rim.XXXVI.getRimNum();
                                    break;
                                case 40:
                                    output = Rim.XL.getRimNum();
                                    break;
                                case 42:
                                    output = Rim.XLII.getRimNum();
                                    break;
                                case 45:
                                    output = Rim.XLV.getRimNum();
                                    break;
                                case 48:
                                    output = Rim.XLVIII.getRimNum();
                                    break;
                                case 50:
                                    output = Rim.L.getRimNum();
                                    break;
                                case 54:
                                    output = Rim.LIV.getRimNum();
                                    break;
                                case 56:
                                    output = Rim.LVI.getRimNum();
                                    break;
                                case 60:
                                    output = Rim.LX.getRimNum();
                                    break;
                                case 63:
                                    output = Rim.LXIII.getRimNum();
                                    break;
                                case 64:
                                    output = Rim.LXIV.getRimNum();
                                    break;
                                case 70:
                                    output = Rim.LXX.getRimNum();
                                    break;
                                case 72:
                                    output = Rim.LXXII.getRimNum();
                                    break;
                                case 80:
                                    output = Rim.LXXX.getRimNum();
                                    break;
                                case 81:
                                    output = Rim.LXXXI.getRimNum();
                                    break;
                                case 90:
                                    output = Rim.XC.getRimNum();
                                    break;
                                case 100:
                                    output = Rim.C.getRimNum();
                                    break;
                                default:
                            }
                            if (rez < 0) {
                                try {
                                    throw new Exception();
                                } catch (Exception e) {
                                    output = "Ошибка вычисления - в римской системе нет отрицательных чисел";
                                }
                            } else if (rez < 1) {
                                try {
                                    throw new Exception();
                                } catch (Exception e) {
                                    output = "Ошибка - результат вычисления меньше единицы";
                                }
                            }
                        } else if ((operation[0].equals("1") || operation[0].equals("2") || operation[0].equals("3") || operation[0].equals("4")
                                || operation[0].equals("5") || operation[0].equals("6") || operation[0].equals("7") || operation[0].equals("8")
                                || operation[0].equals("9") || operation[0].equals("10")) &&
                                (operation[2].equals("1") || operation[2].equals("2") || operation[2].equals("3") || operation[2].equals("4")
                                        || operation[2].equals("5") || operation[2].equals("6") || operation[2].equals("7") || operation[2].equals("8")
                                        || operation[2].equals("9") || operation[2].equals("10"))) {
                            switch (operation[0]) {
                                case "1":
                                    x = Integer.parseInt(operation[0]);
                                    break;
                                case "2":
                                    x = Integer.parseInt(operation[0]);
                                    break;
                                case "3":
                                    x = Integer.parseInt(operation[0]);
                                    break;
                                case "4":
                                    x = Integer.parseInt(operation[0]);
                                    break;
                                case "5":
                                    x = Integer.parseInt(operation[0]);
                                    break;
                                case "6":
                                    x = Integer.parseInt(operation[0]);
                                    break;
                                case "7":
                                    x = Integer.parseInt(operation[0]);
                                    break;
                                case "8":
                                    x = Integer.parseInt(operation[0]);
                                    break;
                                case "9":
                                    x = Integer.parseInt(operation[0]);
                                    break;
                                case "10":
                                    x = Integer.parseInt(operation[0]);
                                    break;
                                default:
                            }
                            switch (operation[2]) {
                                case "1":
                                    y = Integer.parseInt(operation[2]);
                                    break;
                                case "2":
                                    y = Integer.parseInt(operation[2]);
                                    break;
                                case "3":
                                    y = Integer.parseInt(operation[2]);
                                    break;
                                case "4":
                                    y = Integer.parseInt(operation[2]);
                                    break;
                                case "5":
                                    y = Integer.parseInt(operation[2]);
                                    break;
                                case "6":
                                    y = Integer.parseInt(operation[2]);
                                    break;
                                case "7":
                                    y = Integer.parseInt(operation[2]);
                                    break;
                                case "8":
                                    y = Integer.parseInt(operation[2]);
                                    break;
                                case "9":
                                    y = Integer.parseInt(operation[2]);
                                    break;
                                case "10":
                                    y = Integer.parseInt(operation[2]);
                                    break;
                                default:
                            }
                            rez = func.func(x, operation[1], y);
                            output = Integer.toString(rez);
                        } else {

                            try {
                                throw new Exception();
                            } catch (Exception e) {
                                output = "Ошибка - введенная строка не соотвествует формату 'x о y' пример: '2 + 5' или" +
                                        " 'VI / II' (2 операнда и одна операция)";
                            }
                        }
                    }
                } else {  try {
                    throw new Exception();
                } catch (Exception e) {
                    output = "Ошибка - введенная строка не соотвествует формату 'x о y' пример: '2 + 5' или +'VI / II' (2 операнда и одна операция)";
                }
                }
            }
            else {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    output = "Ошибка - введенная строка не соотвествует формату 'x о y' пример: '2 + 5' или +'VI / II' (2 операнда и одна операция)";
                }
            }
        } return output;
    }
}