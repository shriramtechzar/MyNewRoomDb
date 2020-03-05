package com.example.mynewroomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.mynewroomdb.database.DatabaseEntityModel
import com.example.mynewroomdb.database.MainRootDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class AddValuesActivity : AppCompatActivity() {

    @BindView(R.id.submit_button)
    lateinit var submitUpdateButton: Button

    @BindView(R.id.name_edit_text)
    lateinit var titleEditText: EditText

    @BindView(R.id.description_edit_text)
    lateinit var descriptionEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_values)
        ButterKnife.bind(this)

    }

    override fun onBackPressed() {

        finish()
    }

    @OnClick(R.id.submit_button)
    fun submitUpdate() {
        if (titleEditText.text.toString() == "") {
            titleEditText.error = "Enter Valid Title"
            return
        }
        if (descriptionEditText.text.toString() == "") {
            descriptionEditText.error = "Enter Valid Description"
            return
        }

        RoomWholeAPplication.coroutineScope.launch {
            applicationContext?.let {
                val mNote = DatabaseEntityModel(
                    titleEditText.text.toString(),
                    descriptionEditText.text.toString()
                )

                MainRootDatabase(it).getDatabaseDao().addNote(mNote)
                Log.e("Note", "Saved")
                finish()
            }
        }


    }

}
