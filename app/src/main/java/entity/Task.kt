package entity
data class Task (val id: Long, val description : String, val level : Int, var isDone : Boolean = false)