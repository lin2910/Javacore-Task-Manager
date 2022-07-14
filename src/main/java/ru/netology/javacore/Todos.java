package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    private List<String> todos;

    public Todos() {
        todos = new ArrayList<>();
    }

    public void addTask(String task) {
        if (task != null)
            todos.add(task);
        else
            System.out.println("Некорректная задача");
    }

    public void removeTask(String task) {
        if (task != null)
            if (todos.contains(task))
                todos.remove(task);
            else
                System.out.println("Нет задачи для удаления в списке дел");
        else
            System.out.println("Некорректная задача");
    }

    public String getAllTasks() {
        return todos.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.joining(" "));
    }

}
