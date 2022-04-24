import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */

    public static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        String numbers = "0123456789", lower_case = "abcdefghijklmnopqrstuvwxyz", upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ", special_characters = "!@#$%^&*()-+";
        boolean numb = false, lower = false, upper = false, specials = false;

        int result = 4;
        for (int i = 0; i < password.length(); i++) {
            String buff = String.valueOf(password.charAt(i));
            if (numbers.contains(buff)) {
                numb = true;
                continue;
            }
            if (lower_case.contains(buff)) {
                lower = true;
                continue;
            }
            if (upper_case.contains(buff)) {
                upper = true;
                continue;
            }
            if (special_characters.contains(buff))
                specials = true;
        }

        if (numb) result--;
        if (lower) result--;
        if (upper) result--;
        if (specials) result--;

        int rest = 6 - n;
        if (rest > result) result = rest;
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        System.out.println(String.valueOf(answer));
        bufferedReader.close();
    }
}