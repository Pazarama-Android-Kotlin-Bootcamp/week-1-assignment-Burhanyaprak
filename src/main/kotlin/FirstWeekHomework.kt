fun main(args: Array<String>) {
    //1. CodeUsernameValidation
    println("codelandUsernameValidation: "+ codelandUsernameValidation("aa_"))
    println("codelandUsernameValidation: "+ codelandUsernameValidation("u__hello_world123"))

    //2. Complete the aVeryBigSum
    println("completeTheAVeryBigSum: " + completeTheAVeryBigSum())

    //3. First Factorial
    println("firstFactorial: " + firstFactorial(5))

    //5. Question Marks
    println("questionsMarks: " + questionsMarks("aa6?9"))
    println("questionsMarks: " + questionsMarks("acc?7??sss?3rr1??????5"))
}

//1. CodeUsernameValidation
fun codelandUsernameValidation(str: String): Boolean {
    if (str.length in 4..25) {
        if (str.first().isLetter()) {
            if (str.last() != '_') {
                if (onlyLetterNumberUnderscoreValidation(str)) {
                    return true
                }
            }
        }
    }
    return false
}
fun onlyLetterNumberUnderscoreValidation(str: String): Boolean {
    for (characters in str) {
        if (!characters.isLetter() && !characters.isDigit() && characters != '_') {
            return false
        }
    }
    return true
}

//2. Complete the aVeryBigSum
fun completeTheAVeryBigSum(): Long {
    print("Please enter numbers of Array: ")
    val arrayNumbers = readLine()
    val arrayOfBigNumbers = arrayNumbers?.split(" ")?.toTypedArray() // if you want to add numbers manually, use this block.
    //val arrayOfBigNumbers: Array<Int> = arrayOf(Int.MAX_VALUE, Int.MAX_VALUE, Int.MAX_VALUE , 10) // if you do not want to add numbers manually, you can use this block.
    var sumOfArray: Long = 0

    for (number in arrayOfBigNumbers!!){
        sumOfArray += number.toInt()
    }

    return sumOfArray
}

//3. First Factorial
fun firstFactorial(num: Int): Int {
    var factorialSum = 1
    for (i in 1..num) {
        factorialSum *= i
    }
    return factorialSum
}

//5. Question Marks
fun questionsMarks(str: String): Boolean {
    var questionMarksCount = 0
    var lastDigit = 0
    var result = false

    for (item in str) {
        if (item.isDigit()) {
            val digit = item.digitToInt()
            val sumOfPairDigit = digit + lastDigit
            lastDigit = digit

            if (sumOfPairDigit != 10) {
                questionMarksCount = 0
                continue
            }

            if (questionMarksCount != 3){
                return false
            }
            else {
                result = true
            }

            questionMarksCount = 0
        } else if (item == '?') questionMarksCount++
    }

    return result
}
