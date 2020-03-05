package com.example.mynewroomdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.mynewroomdb.RoomWholeAPplication.Companion.coroutineScope
import com.example.mynewroomdb.adapter.RecylerAdapter
import com.example.mynewroomdb.database.DatabaseEntityModel
import com.example.mynewroomdb.database.MainRootDatabase
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    @BindView(R.id.fab)
    lateinit var floatingActionButton: FloatingActionButton

    @BindView(R.id.recycler_view)
    lateinit var recyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

    }

    override fun onResume() {
        super.onResume()
        showDatas()
    }

    private fun showDatas() {

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        coroutineScope. launch {

            applicationContext?.let{

                val notes = MainRootDatabase(it).getDatabaseDao().getAllNotes()
                recyclerView.adapter = RecylerAdapter(notes)
            }
        }

    }

    @OnClick(R.id.fab)
    fun onFabClicked() {
        val intent = Intent(applicationContext, AddValuesActivity::class.java)
        startActivity(intent)
    }

}
