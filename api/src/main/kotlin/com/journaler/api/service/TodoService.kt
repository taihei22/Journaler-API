package com.journaler.api.service

import com.journaler.api.data.Todo
import org.springframework.stereotype.Service
import java.util.*

@Service("Todo service")
class TodoService{

    fun getTodos(): List<Todo> = listOf(
            Todo(
                    UUID.randomUUID().toString(),
                    "My forst Todo",
                    "This is a message for the 1st Todo.",
                    System.currentTimeMillis()
            ),
            Todo(
                    UUID.randomUUID().toString(),
                    "My second Todo",
                    "This is a message for the 2nd Todo.",
                    System.currentTimeMillis()
            )
    )

    fun isertTodo(todo: Todo): Todo {
        todo.id = UUID.randomUUID().toString()
        return todo
    }

    fun deleteTodo(id: String): Boolean = false

    fun updateTodo(todo: Todo): Boolean = true
}