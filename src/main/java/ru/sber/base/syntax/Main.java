package ru.sber.base.syntax;

public class Main {
    public static void main(String[] args) {
        System.out.println(calculate(" 4 7 5 ++ 8 - 7 4 ----- 5 89 ", "   0      "));
    }

    /**
     * Adds up the numbers.
     * @see <a href="https://www.kgeorgiy.info/courses/prog-intro/homeworks.html">Job Condition (job 2)</a>
     * */
    public static long calculate(String... args) {
        long result = 0, sign = 1;
        for (var arg : args) {
            arg += " ";

            StringBuilder value = new StringBuilder();
            for (int i = 0; i < arg.length(); ++i) {
                if (arg.charAt(i) == '-') {
                    sign *= -1;
                } else if (Character.isDigit(arg.charAt(i))) {
                    value.append(arg.charAt(i));
                } else {
                    if (!value.isEmpty()) {
                        result += Integer.parseInt(value.toString()) * sign;
                        value.setLength(0);
                        sign = 1;
                    }
                }
            }
        }

        return result;
    }
}