package com.example.listuserfromapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.JsonReader
import android.widget.TextView
import androidx.core.os.bundleOf
import com.example.listuserfromapi.models.User
import com.google.gson.Gson
import kotlinx.coroutines.*
import org.json.JSONObject
import org.json.JSONStringer
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity(), Coordinator {

	val requestCode = 1

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val url = URL("https://api.dev.bkplus.tech/ringtone/testusers")
		val connection = url.openConnection() as HttpURLConnection
		connection.requestMethod = "GET"

		GlobalScope.launch {
			getUsers()
		}
	}

	private fun getUsers() {
		val res = callApi("https://api.dev.bkplus.tech/ringtone/testusers")
		runOnUiThread {
			setUpUserList(res!!)
		}
	}

	private suspend fun test() {
		GlobalScope.launch {
			delay(3000)
			print("Hello World")
		}
	}

	private fun setUpUserList(usersJson: String) {
		val users = Gson().fromJson(usersJson, Array<User>::class.java)
		val trans = supportFragmentManager.beginTransaction()
		for (user in users) {
			trans.add(R.id.usersList, UserListItem(user))
		}
		trans.commit()
	}

	private fun callApi(apiUrl: String): String? {
		val url: URL
		var connection: HttpURLConnection? = null
		try {
			url = URL(apiUrl)
			connection = url.openConnection() as HttpURLConnection

			connection.requestMethod = "GET"

			var result = ""
			val reader = InputStreamReader(connection.inputStream)
			val br = BufferedReader(reader)
			var data: String?
			while (true) {
				data = br.readLine()
				if (data == null) {
					break
				}
				result += data
			}
			return result
		} catch (e: Exception) {
			println("Stack trace begin")
			e.printStackTrace()
		}
		return null
	}

	override fun showDetails(user: User) {
		val intent = Intent(this@MainActivity, UserDetailsActivity::class.java)
		val bundle = Bundle()
		bundle.putParcelable("user", user)
		intent.putExtras(bundle)
		startActivityForResult(intent, requestCode)
	}

	@Deprecated("Deprecated in Java")
	override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
		super.onActivityResult(requestCode, resultCode, data)
	}

}