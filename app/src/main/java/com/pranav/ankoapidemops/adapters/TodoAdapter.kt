package com.pranav.ankoapidemops.adapters

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pranav.ankoapidemops.R
import com.pranav.ankoapidemops.models.Todo
import kotlinx.android.synthetic.main.list_item_todo.view.*

public class TodoAdapter(
        var todos: ArrayList<Todo>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder?.bindTodo(todos[position]) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        var itemView: View = LayoutInflater.from(parent?.context)
                .inflate(R.layout.list_item_todo, parent, false)

        return TodoViewHolder(itemView)

    }


    fun updateTodos(todos: ArrayList<Todo>) {
        this.todos = todos
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        Log.d("TODOS", todos.size.toString())
        return todos.size
    }


    inner class TodoViewHolder(itemView: View?)
        : RecyclerView.ViewHolder(itemView) {

        fun bindTodo(todo: Todo) {
            itemView.tvTodoTitle.text = todo.title;
        }
    }
}