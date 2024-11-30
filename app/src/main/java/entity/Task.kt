package entity
data class Task (val id: Int, val description : String, val level : Int, var isDone : Boolean = false)
{
    fun toggleDone(){
        this.isDone = !this.isDone
    }
}