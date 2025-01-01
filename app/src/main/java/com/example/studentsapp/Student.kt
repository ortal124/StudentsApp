import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Student(
    val name: String,
    val id: String,
    val isChecked: Boolean,
    val imageResId: Int
) : Parcelable
