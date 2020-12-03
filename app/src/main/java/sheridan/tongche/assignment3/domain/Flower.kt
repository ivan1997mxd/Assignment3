package sheridan.tongche.assignment3.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Flower(
    val label: String,
    val text: String,
    val price: String,
    val picture: String,
    val id: Long = 0L
) : Parcelable