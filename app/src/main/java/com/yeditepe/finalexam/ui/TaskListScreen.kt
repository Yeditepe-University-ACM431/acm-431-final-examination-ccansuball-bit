package com.yeditepe.finalexam.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.yeditepe.finalexam.model.Task
import com.yeditepe.finalexam.viewmodel.TaskViewModel

@Composable
fun TaskListScreen(navController: NavController, viewModel: TaskViewModel = viewModel()) {

    // TODO 3: Read task list from ViewModel
    val tasks by viewModel.tasks.collectAsState()

    Column {
        // TODO 4: Display task titles and completion status
        LazyColumn {
            items(tasks) { task ->
                TaskRow(task = task, navController = navController)
            }
        }
    }
}

@Composable
fun TaskRow(task: Task, navController: NavController) {

    Text(
        text = "${task.title} - ${if (task.isCompleted) "Completed" else "Not Completed"}",
        modifier = Modifier.clickable {
            // TODO 3: Navigate to detail screen with task title
            navController.navigate("taskDetail/${task.title}")
        }
    )
}
