package com.sinuke.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveSubFoldersFromTheFilesystem {

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>(folder.length);
        int i = 0;
        while (i < folder.length) {
            var root = folder[i];
            int j = i + 1;
            while (j < folder.length) {
                if (folder[j].length() > root.length() && folder[j].startsWith(root) && folder[j].charAt(root.length()) == '/') j++;
                else break;
            }
            result.add(root);
            i = j;
        }
        return result;
    }

}
