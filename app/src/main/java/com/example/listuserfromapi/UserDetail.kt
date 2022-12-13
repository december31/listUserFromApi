package com.example.listuserfromapi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class UserDetail(private val key: String, private val value: String): Fragment() {
	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		return inflater.inflate(R.layout.user_detail, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		view.findViewById<TextView>(R.id.lb).text = key
		view.findViewById<EditText>(R.id.edit_text).setText(value)
		view.findViewById<EditText>(R.id.edit_text).isFocusableInTouchMode = false
	}
}