package subtask1

class PolynomialConverter {

    //  Complete the following function
    fun convertToStringFrom(numbers: Array<Int>): String? {
        // throw NotImplementedError("Not implemented")
        var string: String? = ""
        if (numbers.size == 0)
            string = null
        else {
            for ((index, number) in numbers.withIndex()) {
                var sum: String = ""
                when (number) {
                    0 -> sum = ""
                    1 -> sum = " + x"
                    -1 -> sum = " - x"
                    else -> {
                        val sign = if (number < 0) " - " else " + "

                        val degree = if ((numbers.size - index - 1) == 0) ""
                        else if ((numbers.size - index - 1) == 1) "x"
                        else "x^${numbers.size - index - 1}"

                        sum = sign + java.lang.Math.abs(number) + degree
                    }
                }
                string = string + sum
            }
        }

        return if (string != null) string.substring(3, string.length) else string
    }
}
