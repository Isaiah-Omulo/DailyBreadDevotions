package com.nyandori.dailybreaddevotions

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.nyandori.dailybreaddevotions.databinding.ActivityMainBinding
import com.nyandori.dailybreaddevotions.ui.theme.DailyBreadDevotionsTheme
import android.view.View
class MainActivity : ComponentActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var devotionAdapter: DevotionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getDevotions()

    }
    fun getDevotions(){
        binding.progressBar.visibility = View.VISIBLE
        FirebaseFirestore.getInstance().collection("devotions")
             .get().addOnSuccessListener {

           val devotionList = it.toObjects(DevotionModel::class.java)
           setupDevotionRecyclerView(devotionList)
            }.addOnFailureListener{
                Toast.makeText(this, "It has failed", Toast.LENGTH_LONG).show()

            }
    }

    fun setupDevotionRecyclerView(devotionList: List<DevotionModel>){
        binding.progressBar.visibility = View.GONE
        devotionAdapter = DevotionAdapter(devotionList.reversed())
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false )

        binding.recyclerView.adapter = devotionAdapter

    }
}
