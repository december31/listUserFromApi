package com.example.listuserfromapi.models

import android.os.Parcel
import android.os.Parcelable

data class User(
	var id: Int,
	var name: String,
	var age: Int,
	var job: String,
): Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readInt(),
		parcel.readString()!!,
		parcel.readInt(),
		parcel.readString()!!
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeInt(id)
		parcel.writeString(name)
		parcel.writeInt(age)
		parcel.writeString(job)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<User> {
		override fun createFromParcel(parcel: Parcel): User {
			return User(parcel)
		}

		override fun newArray(size: Int): Array<User?> {
			return arrayOfNulls(size)
		}
	}

}