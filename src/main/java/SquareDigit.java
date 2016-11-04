/**
 * https://www.codewars.com/kata/square-every-digit/java
 */

class SquareDigit {

    int squareDigits(int n) {
        String squareDigit = "";
        for (String number : String.valueOf(n).split("")) {
            squareDigit += (int) Math.pow(Integer.parseInt(number), 2);
        }

        return Integer.parseInt(squareDigit);
    }

}
