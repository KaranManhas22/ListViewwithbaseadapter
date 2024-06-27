package com.karan.listviewwithbaseadapter

import android.app.Dialog
import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.karan.listviewwithbaseadapter.databinding.ActivityMainBinding
import com.karan.listviewwithbaseadapter.databinding.CustomDialogboxBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var array = arrayListOf("karan", "chaitnya", "yoyo")
    var List_adapter = List_adapter(array)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.list.adapter = List_adapter
        binding.btnfloating.setOnClickListener {
            val dialogBinding = CustomDialogboxBinding.inflate(layoutInflater)
            val dialog = Dialog(this).apply {
                setContentView(dialogBinding.root)
                window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            }


            dialogBinding.btnadd.setOnClickListener {
                array.add(dialogBinding.etname.text.toString())
                dialog.dismiss()
                startActivity(intent)
                List_adapter.notifyDataSetChanged()
            }
            dialog.setCancelable(false)
            dialog.show()


        }
        binding.list.setOnItemLongClickListener{parent,View,position,id->
            array.removeAt(position)
            List_adapter.notifyDataSetChanged()
            return@setOnItemLongClickListener true


        }

    }

}