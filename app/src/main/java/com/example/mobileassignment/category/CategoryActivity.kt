package com.example.mobileassignment.category

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileassignment.R
import com.example.mobileassignment.jobList.jobListActivity
import com.example.mobileassignment.models.Category
import com.google.firebase.database.*

class CategoryActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    private lateinit var ref: DatabaseReference
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CategoryAdapter
    private lateinit var loManage: RecyclerView.LayoutManager
    var maxid: Long = 0
    val cateList: ArrayList<Category>  = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        title = "Category"

        val tv: TextView = findViewById(R.id.textView)

        database = FirebaseDatabase.getInstance().reference

        ref = FirebaseDatabase.getInstance().reference.child("Category")
        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if(dataSnapshot.exists())
                    maxid = dataSnapshot.childrenCount
                for (i in 1..maxid){
                    cateList.add(Category(dataSnapshot.child((i).toString()).child("name").value.toString()))
                    tv.text = dataSnapshot.child((i).toString()).child("name").value.toString()

                }
                tv.visibility = View.INVISIBLE
            }
            override fun onCancelled(databaseError: DatabaseError) {
                // handle error
            }
        })

        buildRecyclerView()

    }

    private fun writeNewUser(userId: String, name: String?) {
        val user = Category(name)
        Toast.makeText(this, userId+" ${user.name}", Toast.LENGTH_LONG).show()
        database.child("Category").child(userId).setValue(user)
    }

    open fun buildRecyclerView(){
        val tv: TextView = findViewById(R.id.textView)
        recyclerView = findViewById(R.id.recycleView)
        recyclerView.setHasFixedSize(true)
        loManage = LinearLayoutManager(this);
        adapter = CategoryAdapter(cateList)
        recyclerView.layoutManager = loManage
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener(CategoryAdapter.OnItemClickListener(
            fun(it: Int) {
                val intent = Intent(this, jobListActivity::class.java)
                intent.putExtra("Name", cateList.get(it).name)
                startActivity(intent)
        }))
    }
}
