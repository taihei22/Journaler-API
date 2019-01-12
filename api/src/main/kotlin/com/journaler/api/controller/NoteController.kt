package com.journaler.api.controller

import com.journaler.api.data.Note
import com.journaler.api.service.NoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/notes")
@EnableAutoConfiguration
class NoteController {

    @Autowired
    private lateinit var service: NoteService

    /**
     * Get notes.
     */
    @GetMapping(
            //value = "/obtain",
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun getNotes() = service.getNotes()

    /**
     * Insert note.
     */
    @PutMapping(
            //value = "/insert",
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
            consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun insertNote(
            @RequestBody note: Note
    ) = service.insertNote(note)

    /**
     * Remove note by Id.
     */
    @DeleteMapping(
            value = "/{id}",
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun deleteNote(@PathVariable(name = "id") id: String): Boolean
        = service.deleteNote(id)

    /**
     * Update item.
     */
    @PostMapping(
            //value = "/update",
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
            consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun updateNote(@RequestBody note: Note): Boolean = service.updateNote(note)
}
