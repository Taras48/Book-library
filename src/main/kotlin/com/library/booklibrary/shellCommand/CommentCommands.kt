package com.library.Commentlibrary.shellCommand

import com.library.Commentlibrary.service.CommentService
import com.library.booklibrary.dto.CommentDto
import com.library.booklibrary.service.OutputConsoleService
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod

@ShellComponent
class CommentCommands(
    private val commentService: CommentService,
    private val outputConsoleService: OutputConsoleService,
) {

    @ShellMethod(value = "Delete Comment by Id", key = ["dc", "delete"])
    fun deleteCommentById(id: Long, text: String) {
        commentService.deleteCommentById(id)
    }

    @ShellMethod(value = "Get all Comments", key = ["gac", "get all"])
    fun getAllComments() {
        commentService.getAllComments()?.map { outputConsoleService.outputComment(it) }
    }

    @ShellMethod(value = "Get all Comments by Book Id", key = ["gacBybId", "get cooments by b id"])
    fun getCommentsByBookId(id: Long) {
        commentService.getCommentsByBookId(id)?.map { outputConsoleService.outputComment(it) }
    }

    @ShellMethod(value = "Get Comment by id", key = ["gb", "get Comment"])
    fun getCommentById(id: Long) {
        commentService.findCommentById(id)?.let { outputConsoleService.outputComment(it) }
    }

    @ShellMethod(value = "Save Comment", key = ["sc", "save Comment"])
    fun insertComment(text: String) {
        commentService.saveComment(CommentDto(text = text))
            .let { outputConsoleService.outputComment(it) }
    }

    @ShellMethod(value = "Update Comment", key = ["uc", "update Comment"])
    fun updateCommentNameById(id: Long, text: String) {
        commentService.updateCommentTextById(id, text)
    }
}