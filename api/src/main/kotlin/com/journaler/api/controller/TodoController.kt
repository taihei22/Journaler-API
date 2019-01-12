package com.journaler.api.controller

import com.journaler.api.data.Todo
import com.journaler.api.service.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todos")
@EnableAutoConfiguration
class TodoController {

    @Autowired
    private lateinit var service: TodoService

    /**
     * Get todos.
     */
    @GetMapping(
            //value = "/obtain",
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun getTodos(): List<Todo> = service.getTodos()

    /**
     * Insert item.
     */
    @PutMapping(
            //value = "/insert",
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
            consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun insertTodo(
            @RequestBody todo: Todo
    ) = service.isertTodo(todo)

    /**
     * Remove item by Id.
     */
    @DeleteMapping(
            value = "/{id}",
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun deleteTodo(@PathVariable(name = "id") id: String): Boolean
        = service.deleteTodo(id)

    /**
     * Update item.
     */
    @PostMapping(
            //value = "/update",
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
            consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun updateNote(@RequestBody todo: Todo): Boolean
        = service.updateTodo(todo)
}
