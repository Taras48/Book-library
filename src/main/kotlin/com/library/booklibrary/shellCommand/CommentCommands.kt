package com.library.Commentlibrary.shellCommand

import com.library.Commentlibrary.service.CommentService
import com.library.booklibrary.dto.CommentDto
import com.library.booklibrary.service.OutputConsoleService
import org.h2.tools.Console
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod

@ShellComponent
class CommentCommands(
    private val commentService: CommentService,
    private val outputConsoleService: OutputConsoleService,
) {

    @ShellMethod(key = ["db"])
    fun getDb() {
        Console.main()
    }

    @ShellMethod(value = "Delete Comment by Id", key = ["d", "delete"])
    fun deleteCommentById(id: Long) {
        commentService.deleteCommentById(id)
    }

    @ShellMethod(value = "Get all Comments", key = ["ga", "get all"])
    fun getAllComments() {
        commentService.getAllComments()?.map { outputConsoleService.outputComment(it) }
    }

    @ShellMethod(value = "Get Comment by id", key = ["gb", "get Comment"])
    fun getCommentById(id: Long) {
        commentService.findCommentById(id)?.let { outputConsoleService.outputComment(it) }
    }

    @ShellMethod(value = "Save Comment", key = ["s", "save Comment"])
    fun insertComment(text: String) {
        commentService.saveComment(CommentDto(text = text))
            .let { outputConsoleService.outputComment(it) }
    }

    @ShellMethod(value = "Update Comment", key = ["u", "update Comment"])
    fun updateCommentNameById(id: Long, text: String) {
        commentService.updateCommentTextById(id, text)
    }
}