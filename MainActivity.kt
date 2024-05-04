package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var editTextData: EditText
    private lateinit var buttonSubmit: Button
    private lateinit var buttonShow: Button
    private lateinit var queue: RequestQueue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        queue = Volley.newRequestQueue(this)

        editTextData = findViewById(R.id.editTextData)
        buttonSubmit = findViewById(R.id.buttonSubmit)
        buttonShow = findViewById(R.id.buttonShow)

        buttonSubmit.setOnClickListener {
            val data = editTextData.text.toString()
            Log.d(TAG, "Data to be sent: $data")
            sendDataToServer(data)
        }

        buttonShow.setOnClickListener {
            showAllDataFromServer()
        }
    }

    private fun sendDataToServer(data: String) {
        val serverUrl = "http://172.16.58.71/insert_data.php"
        val stringRequest = StringRequest(Request.Method.GET, "$serverUrl?data=$data",
            { response ->
                Log.d(TAG, "Response received: $response")
                Toast.makeText(this@MainActivity, response, Toast.LENGTH_SHORT).show()
            },
            { error ->
                Log.e(TAG, "Error: ${error.message}", error)
                Toast.makeText(this@MainActivity, "Error: ${error.message}", Toast.LENGTH_SHORT).show()
            })
        queue.add(stringRequest)
    }

    private fun showAllDataFromServer() {
        val serverUrl = "http://172.16.58.71/get_all_data.php"
        val jsonArrayRequest = JsonArrayRequest(Request.Method.GET, serverUrl, null,
            { response ->
                val resultList = mutableListOf<Entry>()
                for (i in 0 until response.length()) {
                    val jsonObject = response.getJSONObject(i)
                    resultList.add(Entry(jsonObject.getString("id"), jsonObject.getString("entry_text")))
                }
                val adapter = EntryAdapter(resultList)
                findViewById<RecyclerView>(R.id.recyclerView).apply {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    this.adapter = adapter
                }
            },
            { error ->
                Log.e(TAG, "Error: ${error.message}", error)
                Toast.makeText(this@MainActivity, "Error: ${error.message}", Toast.LENGTH_SHORT).show()
            })
        queue.add(jsonArrayRequest)
    }

    companion object {
        private const val TAG = "MainActivity"
    }

}
