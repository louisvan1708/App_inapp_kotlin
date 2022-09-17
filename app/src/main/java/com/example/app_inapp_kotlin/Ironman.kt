package com.example.app_inapp_kotlin

import android.os.Parcel
import android.os.Parcelable

data class Ironman(
    val name: String,
    val price: String,
    val img: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(price)
        parcel.writeInt(img)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Ironman> {
        override fun createFromParcel(parcel: Parcel): Ironman {
            return Ironman(parcel)
        }

        override fun newArray(size: Int): Array<Ironman?> {
            return arrayOfNulls(size)
        }
    }
}
