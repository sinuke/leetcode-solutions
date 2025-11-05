package com.sinuke.easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class CouponCodeValidator {

    private final Set<String> bl = Set.of(
            "electronics",
            "grocery",
            "pharmacy",
            "restaurant"
    );

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<Coupon> coupons = new ArrayList<>(code.length);
        for (int i = 0; i < code.length; i++) {
            if (isActive[i] && isValidBusinessLine(businessLine[i]) && isValidCode(code[i])) {
                coupons.add(new Coupon(code[i], businessLine[i]));
            }
        }

        return coupons.stream()
                .sorted(Comparator.comparing((Coupon c) -> c.businessLine).thenComparing(c -> c.code))
                .map(c -> c.code)
                .toList();
    }

    private boolean isValidCode(String code) {
        if (code.isEmpty()) return false;
        for (char c : code.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != '_') return false;
        }
        return true;
    }

    private boolean isValidBusinessLine(String businessLine) {
        return bl.contains(businessLine);
    }

    private record Coupon(String code, String businessLine) {}

}
