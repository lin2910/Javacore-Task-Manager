package ru.netology.javacore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodosTests {

    Todos todos;

    @BeforeEach
    public void init() {
        todos = new Todos();
    }

    @Test
    public void addTaskInEmptyTodos() {
        String task = "First task";
        todos.addTask(task);

        String result = "First task";

        assertEquals(result, todos.getAllTasks());
    }

    @Test
    public void addTaskInNaturalOrder() {
        String firstTask = "FirstTask";
        String secondTask = "SecondTask";
        todos.addTask(firstTask);
        todos.addTask(secondTask);

        String result = "FirstTask SecondTask";

        assertEquals(result, todos.getAllTasks());
    }

    @Test
    public void addTackNull() {
        todos.addTask(null);

        String result = "";
        assertEquals(result, todos.getAllTasks());
    }

    @Test
    public void addTaskNotInNaturalOrder(){
        String firstTask = "FirstTask";
        String secondTask = "ThirdTask";
        String thirdTask = "SecondTask";
        todos.addTask(firstTask);
        todos.addTask(secondTask);
        todos.addTask(thirdTask);

        String result = "FirstTask SecondTask ThirdTask";

        assertEquals(result, todos.getAllTasks());
    }
}
