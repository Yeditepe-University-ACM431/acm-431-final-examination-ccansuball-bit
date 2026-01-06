package com.yeditepe.finalexam.viewmodel

import androidx.lifecycle.ViewModel
import com.yeditepe.finalexam.model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TaskViewModel : ViewModel() {

    // TODO 1: Create a mutable state list of Task objects
    // Initially add at least 2 tasks
    private val _tasks = MutableStateFlow(
        listOf(
            Task(1, "Task 1", false),
            Task(2, "Task 2", true)
        )
    )
    val tasks: StateFlow<List<Task>> = _tasks.asStateFlow()


    fun toggleTask(taskId: Int) {
        // TODO 2: Update isCompleted for the given task
        _tasks.update { currentTasks ->
            currentTasks.map { task ->
                if (task.id == taskId) {
                    task.copy(isCompleted = !task.isCompleted)
                } else {
                    task
                }
            }
        }
    }
}
