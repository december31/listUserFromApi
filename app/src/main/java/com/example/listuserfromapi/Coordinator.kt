package com.example.listuserfromapi

import com.example.listuserfromapi.models.User

interface Coordinator {
	fun showDetails(user: User)
}