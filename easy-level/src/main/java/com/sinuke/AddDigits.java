package com.sinuke;

public class AddDigits {

    // This problem is "digital root" problem

    public int addDigits(int num) {
        return 1 + ((num - 1) % 9);
    }

    public int addDigitsRecursive(int num) {
        var result = 0;

        while (num > 0) {
            result += (num % 10);
            num /= 10;
        }

        if (result > 9) result = addDigitsRecursive(result);

        return result;
    }

}
