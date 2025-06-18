package com.sinuke.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueEmailAddresses {

    public int numUniqueEmails(String[] emails) {
        Map<String, Set<String>> map = new HashMap<>();

        for (var email : emails) {
            int atIndex = email.indexOf('@');
            var domain = email.substring(atIndex + 1);
            var user = email.substring(0, atIndex);
            int plusIndex = user.indexOf('+');
            if (plusIndex != -1) user = user.substring(0, plusIndex);
            user = user.replace(".", "");

            if (!map.containsKey(domain)) map.put(domain, new HashSet<>());
            map.get(domain).add(user);
        }

        return map.values().stream()
                .mapToInt(Set::size)
                .reduce(Integer::sum)
                .orElse(0);
    }

}
