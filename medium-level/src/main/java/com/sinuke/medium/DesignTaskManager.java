package com.sinuke.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class DesignTaskManager {

    public static class TaskManager {

        private final Map<Integer, Map<Integer, Task>> users;
        private final Map<Integer, Task> tasks;
        private final TreeSet<Task> sorted;

        public TaskManager(List<List<Integer>> tasks) {
            this.users = new HashMap<>();
            this.tasks = new HashMap<>();
            this.sorted = new TreeSet<>(Comparator.<Task>comparingInt(f -> f.priority).thenComparing(f -> f.id));

            for (var list : tasks) {
                var task = new Task(list.get(1), list.get(2), list.get(0));

                this.users.putIfAbsent(list.get(0), new HashMap<>());
                this.users.get(list.get(0)).put(list.get(1), task);

                this.tasks.put(list.get(1), task);

                this.sorted.add(task);
            }
        }

        public void add(int userId, int taskId, int priority) {
            var task = new Task(taskId, priority, userId);

            users.putIfAbsent(userId, new HashMap<>());
            users.get(userId).put(taskId, task);

            tasks.put(taskId, task);

            sorted.add(task);
        }

        public void edit(int taskId, int newPriority) {
            var task = tasks.get(taskId);
            sorted.remove(task);
            task.priority = newPriority;
            sorted.add(task);
        }

        public void rmv(int taskId) {
            var task = tasks.remove(taskId);
            users.get(task.userId).remove(taskId);
            sorted.remove(task);
        }

        public int execTop() {
            return sorted.isEmpty() ? -1 : sorted.pollLast().userId;
        }

        private static class Task {
            int id;
            int priority;
            int userId;

            Task(int id, int priority, int userId) {
                this.id = id;
                this.priority = priority;
                this.userId = userId;
            }
        }
    }

}
