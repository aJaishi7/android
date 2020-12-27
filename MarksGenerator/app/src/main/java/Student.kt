import java.io.Serializable
import java.util.Comparator

class Student : Serializable {

    var studentId: Int
    var studentName: String
    var androidMarks: Int
    var apiMarks: Int
    var iotMarks: Int

    constructor(
        studentId: Int,
        studentName: String,
        androidMarks: Int,
        apiMarks: Int,
        iotMarks: Int
    ) {
        this.studentId = studentId
        this.studentName = studentName
        this.androidMarks = androidMarks
        this.apiMarks = apiMarks
        this.iotMarks = iotMarks
    }

    override fun toString(): String {
        return "$studentId $studentName $androidMarks $apiMarks $iotMarks";
    }

    fun getTotalMarks(): Int {
        return androidMarks + apiMarks + iotMarks
    }

    fun getAverage(): Int {
        val marks = getTotalMarks() / 3;
        return marks;
    }


}