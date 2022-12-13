package com.example.listuserfromapi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.listuserfromapi.models.User
import org.w3c.dom.Text

class UserListItem(private val user: User): Fragment(), View.OnClickListener {
	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		return inflater.inflate(R.layout.user_list_item, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		view.findViewById<TextView>(R.id.username).text = user.name
		view.findViewById<TextView>(R.id.job).text = user.job
		view.setOnClickListener(this)
	}

	override fun onClick(p0: View?) {
		val activity = activity
		if (activity is Coordinator) {
			activity.showDetails(user)
		}
	}
}