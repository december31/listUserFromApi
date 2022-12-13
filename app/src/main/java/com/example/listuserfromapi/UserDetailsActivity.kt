package com.example.listuserfromapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listuserfromapi.models.User

class UserDetailsActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_user_details)

		val bundle = intent.extras
		val user = bundle?.getParcelable<User>("user")

		val trans = supportFragmentManager.beginTransaction()
		trans.add(R.id.userDetails, UserDetail("username", user!!.name))
		trans.add(R.id.userDetails, UserDetail("age", user.age.toString()))
		trans.add(R.id.userDetails, UserDetail("job", user.job))
		trans.commit()
	}
}