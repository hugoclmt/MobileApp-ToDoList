package entity

class TaskList (){

    private val listOfTasks: MutableList<Task> = mutableListOf()

    fun addTask(task: Task) {
        listOfTasks.add(task)
    }

    fun removeTask(task: Task) {
        listOfTasks.remove(task)
    }

    fun getListOfTask(): MutableList<Task> {
        return listOfTasks
    }

    fun toggleTaskDone(task: Task){
        task.toggleDone()
    }
}