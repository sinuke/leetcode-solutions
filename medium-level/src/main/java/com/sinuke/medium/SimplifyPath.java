package com.sinuke.medium;

import java.util.ArrayList;
import java.util.List;

public class SimplifyPath {

    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        List<String> result = new ArrayList<>(paths.length);

        for (String p : paths) {
            if (".".equals(p) || p.isEmpty()) {
                // nothing
            } else if ("..".equals(p)) {
                if (!result.isEmpty()) result.removeLast();
            } else result.add(p);
        }

        return "/" + String.join("/", result);
    }

}
