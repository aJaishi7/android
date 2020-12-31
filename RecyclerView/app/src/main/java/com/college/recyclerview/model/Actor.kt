package com.college.recyclerview.model

import android.os.Parcel
import android.os.Parcelable

data class Actor(
    val actorId: Int? = null,
    val actorName: String? = null,
    val actorImage: String? = null,
    val actorAddredss: String? = null,
    val actorSalary: Float? = null
):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Float::class.java.classLoader) as? Float
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(actorId)
        parcel.writeString(actorName)
        parcel.writeString(actorImage)
        parcel.writeString(actorAddredss)
        parcel.writeValue(actorSalary)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Actor> {
        override fun createFromParcel(parcel: Parcel): Actor {
            return Actor(parcel)
        }

        override fun newArray(size: Int): Array<Actor?> {
            return arrayOfNulls(size)
        }
    }

}