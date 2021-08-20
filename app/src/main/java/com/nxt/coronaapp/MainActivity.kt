package com.nxt.coronaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.nxt.coronaapp.api.RetroInstance
import com.nxt.coronaapp.api.RetroService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var listCountry: ArrayList<Countries>? = null
    var itemAdapter: ItemAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listCountry = ArrayList()

        itemAdapter = ItemAdapter(listCountry!!)

        rv.adapter = itemAdapter
        rv.layoutManager = LinearLayoutManager(this)

        createData()

    }

    private fun createData() {
        val api = RetroInstance.getInstance().create(RetroService::class.java)

        GlobalScope.launch(Dispatchers.Main) {
            val response = api.getDataFromApi()
            if (response.isSuccessful) {
                tv.text = "Global"
                tv_word_new_confirmed.text =
                    response.body()!!.Global.NewConfirmed.toString()
                tv_word_total_confirmed.text =
                    response.body()!!.Global.TotalConfirmed.toString()
                tv_word_total_deaths.text = response.body()!!.Global.TotalDeaths.toString()

                itemAdapter?.listCountry = response.body()!!.Countries
                itemAdapter!!.notifyDataSetChanged()
            }
        }
    }

    /** private fun createData() {
    RetroInstance.getInstance().create(RetroService::class.java)
    .getDataFromApi().enqueue(object : retrofit2.Callback<Model> {
    override fun onResponse(call: Call<Model>, response: Response<Model>) {
    if (response.isSuccessful) {
    tv.text = "Global"
    tv_word_new_confirmed.text =
    response.body()!!.Global.NewConfirmed.toString()
    tv_word_total_confirmed.text =
    response.body()!!.Global.TotalConfirmed.toString()
    tv_word_total_deaths.text = response.body()!!.Global.TotalDeaths.toString()

    itemAdapter?.listCountry = response.body()!!.Countries
    itemAdapter!!.notifyDataSetChanged()
    }
    }

    override fun onFailure(call: Call<Model>, t: Throwable) {

    }

    })
    }*/
}