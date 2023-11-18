package com.egeozturk.formulaappv04.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.math.*

@HiltViewModel
class CalculatorScreenViewModel @Inject constructor(): ViewModel() {
    var calculationSeq = mutableStateOf("")
    var result = mutableStateOf<Double>(0.0)
    var numberOfParenthesis = 0
    var isRadianOn = mutableStateOf(false)

    var isNegative = false

    fun checkByLabel (label: String) {
        val endsWithOperation = calculationSeq.value.endsWith(' ') || calculationSeq.value.isEmpty() || calculationSeq.value.endsWith('(')

        if (label.toIntOrNull() != null) {
            if (calculationSeq.value.endsWith(")") ||
                calculationSeq.value.endsWith("%") ||
                calculationSeq.value.endsWith("!") ||
                calculationSeq.value.endsWith("e") ||
                calculationSeq.value.endsWith("π")) {

                calculationSeq.value += " × $label"
            } else {
                calculationSeq.value += label
            }
        } else if (label == "+") {
            if (!endsWithOperation) {
                calculationSeq.value += " + "
                isNegative = false
            }
        }else if (label == "-") {
            if (!endsWithOperation) {
                calculationSeq.value += " - "
                isNegative = false
            }
        }else if (label == "×") {
            if (!endsWithOperation) {
                calculationSeq.value += " × "
                isNegative = false
            }
        }else if (label == "÷") {       //÷
            if (!endsWithOperation) {
                calculationSeq.value += " ÷ "
                isNegative = false
            }
        } else if (label == "=") {
            if (!endsWithOperation && numberOfParenthesis == 0 && !calculationSeq.value.endsWith('-')) {
                calculate()
            }
        } else if (label == "C") {
            calculationSeq.value = ""
            result.value = 0.0
            numberOfParenthesis = 0
            isNegative = false
        } else if (label == "," && calculationSeq.value.isNotEmpty()) {
            if (calculationSeq.value.last().digitToIntOrNull() != null) {
                calculationSeq.value += "."
            }
        } else if (label == "(") {
            if (!calculationSeq.value.endsWith(' ') && !calculationSeq.value.endsWith('-') && calculationSeq.value.isNotEmpty() && !calculationSeq.value.endsWith('(')) {
                calculationSeq.value += " × ("
                isNegative = false

            } else {
                calculationSeq.value += "("
            }
            numberOfParenthesis++
        } else if (label == ")") {
            if (!endsWithOperation && numberOfParenthesis > 0 && !calculationSeq.value.endsWith('-')) {
                calculationSeq.value += ")"
                numberOfParenthesis--
            }

        }else if (label == "+/-") {

            calculationSeq.value = toggleNegative(calculationSeq.value)

            //calculationSeq.value.endsWith(' ') || calculationSeq.value.isEmpty() || calculationSeq.value.endsWith('-')
            /* if (endsWithOperation || calculationSeq.value.endsWith('-')) {
                if (!isNegative) {
                    calculationSeq.value += "(-"
                    numberOfParenthesis++
                    isNegative = true
                } else  {           //eksiyi parantezin disina koyuyor bunu yapmamali
                    calculationSeq.value = calculationSeq.value.removeRange(calculationSeq.value.lastIndex - 1, calculationSeq.value.lastIndex + 1)
                    isNegative = false
                    numberOfParenthesis--
                }
            } else {
                var lastOpIx = -1
                calculationSeq.value.forEachIndexed { index, c ->
                    if (c == ' ' || c == '(') {
                        lastOpIx = index
                    }
                }
                val newNumber = calculationSeq.value.substring(lastOpIx + 1)

                if (calculationSeq.value.length > 1 && calculationSeq.value[lastOpIx + 2] == '-') {        //sadece bu kismin toggle olamasi calismiyor
                    calculationSeq.value = calculationSeq.value.replaceRange(lastOpIx + 1, calculationSeq.value.lastIndex + 1, newNumber.removeRange(0,2))
                    isNegative = false
                    numberOfParenthesis--

                } else {
                    calculationSeq.value = calculationSeq.value.replaceRange(lastOpIx + 1, calculationSeq.value.lastIndex + 1, "(-$newNumber")
                    isNegative = true
                    numberOfParenthesis++
                }

            }

             */
        }
    }

    fun checkSideByLabel (label: String) {
        if (label == "!" && calculationSeq.value.isNotEmpty()) {
            if (calculationSeq.value.endsWith(')') || calculationSeq.value.last().digitToIntOrNull() != null) {
                calculationSeq.value += "!"
            }
        } else if (label == "%" && calculationSeq.value.isNotEmpty()) {
            if (calculationSeq.value.endsWith(')') || calculationSeq.value.last().digitToIntOrNull() != null || calculationSeq.value.endsWith('!')) {
                calculationSeq.value += "%"
            }
        } else if (label == "sin") {
            if (!calculationSeq.value.endsWith(' ') && !calculationSeq.value.endsWith('-') && calculationSeq.value.isNotEmpty() && !calculationSeq.value.endsWith('(')) {
                calculationSeq.value += " × sin("
                isNegative = false

            } else {
                calculationSeq.value += "sin("
            }
            numberOfParenthesis++
        } else if (label == "cos") {
            if (!calculationSeq.value.endsWith(' ') && !calculationSeq.value.endsWith('-') && calculationSeq.value.isNotEmpty() && !calculationSeq.value.endsWith('(')) {
                calculationSeq.value += " × cos("
                isNegative = false

            } else {
                calculationSeq.value += "cos("
            }
            numberOfParenthesis++
        } else if (label == "tan") {
            if (!calculationSeq.value.endsWith(' ') && !calculationSeq.value.endsWith('-') && calculationSeq.value.isNotEmpty() && !calculationSeq.value.endsWith('(')) {
                calculationSeq.value += " × tan("
                isNegative = false

            } else {
                calculationSeq.value += "tan("
            }
            numberOfParenthesis++
        } else if (label == "cot") {
            if (!calculationSeq.value.endsWith(' ') && !calculationSeq.value.endsWith('-') && calculationSeq.value.isNotEmpty() && !calculationSeq.value.endsWith('(')) {
                calculationSeq.value += " × cot("
                isNegative = false

            } else {
                calculationSeq.value += "cot("
            }
            numberOfParenthesis++
        } else if (label == "sec") {
            if (!calculationSeq.value.endsWith(' ') && !calculationSeq.value.endsWith('-') && calculationSeq.value.isNotEmpty() && !calculationSeq.value.endsWith('(')) {
                calculationSeq.value += " × sec("
                isNegative = false

            } else {
                calculationSeq.value += "sec("
            }
            numberOfParenthesis++
        } else if (label == "csc") {
            if (!calculationSeq.value.endsWith(' ') && !calculationSeq.value.endsWith('-') && calculationSeq.value.isNotEmpty() && !calculationSeq.value.endsWith('(')) {
                calculationSeq.value += " × csc("
                isNegative = false

            } else {
                calculationSeq.value += "csc("
            }
            numberOfParenthesis++
        } else if (label == "√") {
            if (!calculationSeq.value.endsWith(' ') && !calculationSeq.value.endsWith('-') && calculationSeq.value.isNotEmpty() && !calculationSeq.value.endsWith('(')) {
                calculationSeq.value += " × √("
                isNegative = false

            } else {
                calculationSeq.value += "√("
            }
            numberOfParenthesis++
        } else if (label == "xⁿ") {
            if (!calculationSeq.value.endsWith(' ') && !calculationSeq.value.endsWith('-') && calculationSeq.value.isNotEmpty() && !calculationSeq.value.endsWith('(')) {
                calculationSeq.value += "^("
                isNegative = false
                numberOfParenthesis ++
            }
        } else if (label == "π") {
            if (!calculationSeq.value.endsWith(' ') && !calculationSeq.value.endsWith('-') && calculationSeq.value.isNotEmpty() && !calculationSeq.value.endsWith('(')) {
                calculationSeq.value += " × π"
                isNegative = false

            } else {
                calculationSeq.value += "π"
            }
        } else if (label == "e") {
            if (!calculationSeq.value.endsWith(' ') && !calculationSeq.value.endsWith('-') && calculationSeq.value.isNotEmpty() && !calculationSeq.value.endsWith('(')) {
                calculationSeq.value += " × e"
                isNegative = false

            } else {
                calculationSeq.value += "e"
            }
        } else if (label == "|x|") {
            if (!calculationSeq.value.endsWith(' ') && !calculationSeq.value.endsWith('-') && calculationSeq.value.isNotEmpty() && !calculationSeq.value.endsWith('(')) {
                calculationSeq.value += " × abs("
                isNegative = false

            } else {
                calculationSeq.value += "abs("
            }
            numberOfParenthesis++
        } else if (label == "log") {
            if (!calculationSeq.value.endsWith(' ') && !calculationSeq.value.endsWith('-') && calculationSeq.value.isNotEmpty() && !calculationSeq.value.endsWith('(')) {
                calculationSeq.value += " × log("
                isNegative = false

            } else {
                calculationSeq.value += "log("
            }
            numberOfParenthesis++
        } else if (label == "ln") {
            if (!calculationSeq.value.endsWith(' ') && !calculationSeq.value.endsWith('-') && calculationSeq.value.isNotEmpty() && !calculationSeq.value.endsWith('(')) {
                calculationSeq.value += " × ln("
                isNegative = false

            } else {
                calculationSeq.value += "ln("
            }
            numberOfParenthesis++
        }
    }

    private fun calculate () {
        var calculationTemp = calculationSeq.value
        calculationTemp = constantCheck(calculationTemp)
        calculationTemp = operateInPara(calculationTemp)
       result.value = operate(calculationTemp)
    }


    fun deleteCalculation() {
        val length = calculationSeq.value.length
        if (length > 0) {
            val endsWithTri = calculationSeq.value.endsWith("cos(") ||calculationSeq.value.endsWith("sin(") || calculationSeq.value.endsWith("tan(") || calculationSeq.value.endsWith("cot(") || calculationSeq.value.endsWith("sec(") || calculationSeq.value.endsWith("csc(")

            if (calculationSeq.value.endsWith(" ")) {
                calculationSeq.value = calculationSeq.value.removeRange(length - 3, length)
                isNegative = false
            } else if (endsWithTri || calculationSeq.value.endsWith("abs(") || calculationSeq.value.endsWith("log(")) {
                calculationSeq.value = calculationSeq.value.removeRange(length - 4, length)
                //isNegative = false
                numberOfParenthesis--
            } else if (calculationSeq.value.endsWith("ln(")) {
                calculationSeq.value = calculationSeq.value.removeRange(length - 3, length)
                numberOfParenthesis--

            } else if (calculationSeq.value.endsWith("√(") || calculationSeq.value.endsWith("^(") || calculationSeq.value.endsWith("(-")) {
                calculationSeq.value = calculationSeq.value.removeRange(length - 2, length)
                numberOfParenthesis--
                //isNegative = false

            }  else {
                if (calculationSeq.value.endsWith("(")){
                    numberOfParenthesis--
                } else if (calculationSeq.value.endsWith(")")){
                    numberOfParenthesis++
                }
                calculationSeq.value = calculationSeq.value.removeRange(length - 1, length)
            }

        }

    }

    private fun toggleNegative (calculation: String) : String {     //calismiyo tekrar bak
        var calculationTemp = " $calculation"

        if (calculationTemp.endsWith("(-")) {
            calculationTemp = calculationTemp.removeRange(calculationTemp.lastIndex - 1, calculationTemp.length)
            numberOfParenthesis--
        } else if (calculationTemp.endsWith(')') || calculationTemp.endsWith('!') || calculationTemp.endsWith('%')) {
            calculationTemp += " × (-"
            numberOfParenthesis++
        } else if (calculationTemp.isEmpty() || calculationTemp.endsWith(' ') || calculationTemp.endsWith('(')) {
            calculationTemp += "(-"
            numberOfParenthesis++
        } else if (calculationTemp.last().digitToIntOrNull() != null || calculationTemp.last() == 'e'|| calculationTemp.last() == 'π') {
            var i = calculationTemp.lastIndex
            var c = calculationTemp.last()

            while ((c.digitToIntOrNull() != null || c == '.' ||  (c == 'e' && calculationTemp[i - 1] != 's') || c == 'π') && i > 0) {
                i--
                c = calculationTemp[i]

            }
            var startNumIx : Int = i + 1

            if (calculationTemp[startNumIx - 1] == '-') {
                calculationTemp = calculationTemp.removeRange(startNumIx - 2, startNumIx)
                numberOfParenthesis--
            } else {
                calculationTemp = calculationTemp.replaceRange(startNumIx, startNumIx, "(-")      //burasi hatali olabilir
                numberOfParenthesis++
            }

        }

        return calculationTemp.removeRange(0,1)
    }

    private fun constantCheck (calculation: String) : String {
        var calculationTemp = "$calculation "
        var i = 0

        while (calculationTemp.length > i) {
            if (calculationTemp[i] == 'e' && calculationTemp[i + 1] != 'c') {
                calculationTemp = calculationTemp.replaceRange(i, i + 1, E.toString())
            }
            i ++
        }

        calculationTemp = calculationTemp.replace("π", PI.toString(), false)
        //calculationTemp = calculationTemp.replace("e", E.toString(), false)

        return calculationTemp.removeRange(calculationTemp.lastIndex, calculationTemp.length)
    }

    private fun factorialCheck (calculation: String): String {
        var calculationTemp = calculation
        var lastOpIx = -1
        var i = 0

        if (calculation.contains("NaN") ) {
            return "NaN"
        } else if (calculation.contains("Infinity")) {
            return "Infinity"
        }

        while (calculationTemp.length > i) {
            val c = calculationTemp[i]
            if (c == '!') {
                val factorialNumber = calculationTemp.substring(lastOpIx + 1, i).toDouble()
                val factorialResult = factorial(factorialNumber)
                calculationTemp = calculationTemp.replace(calculationTemp.substring(lastOpIx + 1, i + 1), factorialResult)
                i = i + factorialResult.length - 1

            } else if (c == ' ') {
                lastOpIx = i
                i++
            } else {
                i++
            }
        }

        return calculationTemp
    }

    private fun percentCheck (calculation: String): String {
        var calculationTemp = calculation
        var lastOpIx = -1
        var i = 0
        var isMulOrDiv = false

        if (calculation.contains("NaN") ) {
            return "NaN"
        } else if (calculation.contains("Infinity")) {
            return "Infinity"
        }

        while (calculationTemp.length > i) {
            val c = calculationTemp[i]
            if (c == '%') {
                var percentNumber: Double

                if (lastOpIx == -1) {
                    percentNumber = calculationTemp.substring(lastOpIx + 1, i).toDouble() / 100
                    calculationTemp = calculationTemp.replace(calculationTemp.substring(lastOpIx + 1, i + 1), percentNumber.toString())
                    if (i + 2 < calculationTemp.length) {
                        isMulOrDiv = calculationTemp[i + 2] == '×' || calculationTemp[i + 2] == '÷'
                    }
                    i = percentNumber.toString().length
                } else if (i + 2 < calculationTemp.length) {
                    if (isMulOrDiv || (calculationTemp[i + 2] == '×' || calculationTemp[i + 2] == '÷' ||  calculationTemp[lastOpIx -1] == '÷' || calculationTemp[lastOpIx -1] == '×')){

                        percentNumber = calculationTemp.substring(lastOpIx + 1, i).toDouble() / 100
                        calculationTemp = calculationTemp.replace(calculationTemp.substring(lastOpIx + 1, i + 1), percentNumber.toString())
                        isMulOrDiv = calculationTemp[i + 2] == '×' || calculationTemp[i + 2] == '÷'
                        i = lastOpIx + percentNumber.toString().length + 1

                    } else {
                        var percentCalculation = calculationTemp.substring(0, lastOpIx - 2)
                        percentCalculation = operateInPara(percentCalculation)
                        val percentCalculationResult = operate(percentCalculation)

                        percentNumber = calculationTemp.substring(lastOpIx + 1, i).toDouble() / 100 * percentCalculationResult
                        calculationTemp = calculationTemp.replace(calculationTemp.substring(lastOpIx + 1, i + 1), percentNumber.toString())
                        i = lastOpIx + percentNumber.toString().length + 1
                    }

                } else if (lastOpIx != -1){        //son sayi degeri
                    if (isMulOrDiv ||  calculationTemp[lastOpIx -1] == '÷' || calculationTemp[lastOpIx -1] == '×'){

                        percentNumber = calculationTemp.substring(lastOpIx + 1, i).toDouble() / 100
                        calculationTemp = calculationTemp.replace(calculationTemp.substring(lastOpIx + 1), percentNumber.toString())
                        i = lastOpIx + percentNumber.toString().length + 1

                    } else {
                        var percentCalculation = calculationTemp.substring(0, lastOpIx - 2)
                        percentCalculation = operateInPara(percentCalculation)
                        val percentCalculationResult = operate(percentCalculation)

                        percentNumber = calculationTemp.substring(lastOpIx + 1, i).toDouble() / 100 * percentCalculationResult
                        calculationTemp = calculationTemp.replace(calculationTemp.substring(lastOpIx + 1, i + 1), percentNumber.toString())
                        i = lastOpIx + percentNumber.toString().length + 1
                    }
                }

            } else if (c == ' ') {
                lastOpIx = i
                i++
            } else {
                i++
            }
        }
        return calculationTemp
    }

    private fun squareRootCheck (calculation: String) : String {        //negatif deger alinca NaN verio
        var calculationTemp = "$calculation "
        var i = 0

        var lastNumberIndex = 0
        var lastRootIndex = -1

        if (calculation.contains("NaN") ) {
            return "NaN"
        } else if (calculation.contains("Infinity")) {
            return "Infinity"
        }

        while (i < calculationTemp.length) {
            val c = calculationTemp[i]

            if (c == '√') {
                lastRootIndex = i
                i++
            } else if (c.digitToIntOrNull() != null) {
                lastNumberIndex = i
                i++
            } else if ((c == ' ' || c == '^') && lastRootIndex != -1) {
                println("Root: $calculationTemp")
                val rootNumber = calculationTemp.substring(lastRootIndex + 1 ,lastNumberIndex + 1)
                if (rootNumber.toDoubleOrNull() != null) {

                    val rootResult = sqrt(rootNumber.toDouble()).toString()
                    calculationTemp = calculationTemp.replaceRange(lastRootIndex, lastNumberIndex + 1, rootResult)
                    i = lastRootIndex + rootResult.length       //bir sebepten dolayi olmuyo stringde bisi var
                    lastRootIndex = -1

                } else {
                    i++
                }
            } else i++
        }
        return calculationTemp.removeRange(calculationTemp.lastIndex, calculationTemp.length)
    }

    private fun powerCheck(calculation: String) : String {      // ilk sayida ! ya da % varsa o funlari cagar
        var calculationTemp = "$calculation "
        var i = 0
        var startNumIx = -1
        var lastNumIx = 0
        var lastPowIx = -1

        if (calculation.contains("NaN") ) {
            return "NaN"
        } else if (calculation.contains("Infinity")) {
            return "Infinity"
        }

        while (calculationTemp.length > i) {
            val c = calculationTemp[i]

            if (c == '^') {
                lastPowIx = i
                i++
            } else if (c.digitToIntOrNull() != null) {
                lastNumIx = i
                i++
            } else if (c == ' ') {
                if (lastPowIx != -1) {
                    var base = calculationTemp.substring(startNumIx + 1, lastPowIx)
                    val power = calculationTemp.substring(lastPowIx + 1, lastNumIx + 1).toDouble()

                    base = factorialCheck(base)
                    base = percentCheck(base)

                    val result = base.toDouble().pow(power).toString()

                    calculationTemp = calculationTemp.replaceRange(startNumIx + 1, lastNumIx + 1, result)
                    i = startNumIx + result.length + 1
                    lastPowIx = -1
                } else {
                    startNumIx = i      //bosluk tuttugu icin islem yaparken 1 fazlasini al
                    i++
                }
            } else {
                i++
            }
        }

        return calculationTemp.removeRange(calculationTemp.lastIndex, calculationTemp.length)
    }

    private fun trigonometryCheck (calculation: String) : String {
        var calculationTemp = "$calculation "
        var i = 3

        var lastNumberIndex = 0

        var lastTriIndex = -1
        var lastTri = ""

        if (calculation.contains("NaN") ) {
            return "NaN"
        } else if (calculation.contains("Infinity")) {
            return "Infinity"
        }

        while (i < calculationTemp.length) {

            var func = calculationTemp.substring(i - 3, i)
            println("triResult: $func")
            if (func == "sin" || func == "cos" ||func == "tan" ||func == "cot" ||func == "sec" ||func == "csc") {
                lastTriIndex = i
                lastTri = func
                i++

            } else if (calculationTemp[i] == '+' || calculationTemp[i] == '-' || calculationTemp[i] == '×' || calculationTemp[i] == '÷') {
                lastTriIndex = -1
                i++
            }  else if ((calculationTemp[i] == ' ' || calculationTemp[i] == '^') && lastTriIndex != -1) {

                val triNumber = calculationTemp.substring(lastTriIndex, lastNumberIndex + 1)
                var triResult = 0.0

                if (triNumber.toDoubleOrNull() != null) {       //sanirim calisiyor her durum icin dene
                    when (lastTri) {
                        "sin" -> {

                            triResult = if (isRadianOn.value) {
                                sin(triNumber.toDouble())
                            } else {
                                sin(triNumber.toDouble() / (180 / PI))
                            }
                        }
                        "cos" -> {
                            triResult = if (isRadianOn.value) {
                                cos(triNumber.toDouble())
                            } else {
                                cos(triNumber.toDouble() / (180 / PI))
                            }
                        }
                        "tan" -> {
                            triResult = if (isRadianOn.value) {
                                tan(triNumber.toDouble())
                            } else {
                                tan(triNumber.toDouble() / (180 / PI))
                            }
                        }
                        "cot" -> {
                            triResult = if (isRadianOn.value) {
                                1 / tan(triNumber.toDouble())
                            } else {
                                1 / tan(triNumber.toDouble() / (180 / PI))
                            }
                        }
                        "sec" -> {          //calismiyor ama bunun disinda hata vermek yerine nan ya da inf veriyo

                            triResult = if (isRadianOn.value) {
                                1 / cos(triNumber.toDouble())
                            } else {
                                1 / cos(triNumber.toDouble() / (180 / PI))
                            }


                        }
                        "csc" -> {
                            triResult = if (isRadianOn.value) {
                                1 / sin(triNumber.toDouble())
                            } else {
                                1 / sin(triNumber.toDouble() / (180 / PI))      //hata mesaji ver
                            }
                        }


                    }

                    if (abs(triResult) < 1.0E-15) {
                        triResult = 0.0
                    } else if (triResult > 1.0E15) {
                        triResult = Double.POSITIVE_INFINITY
                    } else if (triResult < -1.0E15) {
                        triResult = Double.NEGATIVE_INFINITY
                    }

                    println("secResult: $triResult")

                    calculationTemp = calculationTemp.replaceRange(lastTriIndex - 3, lastNumberIndex + 1, triResult.toString())
                    i = lastTriIndex + triResult.toString().length
                } else i++

            } else if (calculationTemp[i].digitToIntOrNull() != null) {
                lastNumberIndex = i
                i++
            } else {
                i++
            }
        }

        calculationTemp = calculationTemp.removeRange(calculationTemp.lastIndex, calculationTemp.lastIndex + 1)
        return calculationTemp
    }

    private fun absoluteCheck(calculation: String): String {
        var calculationTemp = "$calculation "
        var lastAbsIx = -1
        var lastNumIx = 0
        var i = 3

        if (calculation.contains("NaN") ) {
            return "NaN"
        } else if (calculation.contains("Infinity")) {
            return "Infinity"
        }

        while (i < calculationTemp.length) {
            val c = calculationTemp[i]

            if (calculationTemp.substring(i - 3, i) == "abs") {
                lastAbsIx = i
                i++
            } else if (c.digitToIntOrNull() != null) {
                lastNumIx = i
                i++
            } else if ((c == ' ' || c == '^') && lastAbsIx != -1) {
                val absResult = abs(calculationTemp.substring(lastAbsIx, lastNumIx + 1).toDouble()).toString()
                calculationTemp = calculationTemp.replaceRange(lastAbsIx - 3, lastNumIx + 1, absResult)
                i = lastAbsIx - 3 + absResult.length
                lastAbsIx = -1

            } else i++
        }

        return calculationTemp.removeRange(calculationTemp.lastIndex, calculationTemp.length)
    }

    private fun logCheck (calculation: String): String {        // 0 ve daha kucuk bisey konulursa NaN veriyo oyle olursa uyari mesaji ver
        var calculationTemp = "$calculation "
        var lastNumIx = 0
        var lastLogIx = -1
        var i = 3

        if (calculation.contains("NaN") ) {
            return "NaN"
        } else if (calculation.contains("Infinity")) {
            return "Infinity"
        }

        while (calculationTemp.length > i) {                      //hata mesaji ver
            val c = calculationTemp[i]

            if (calculationTemp.substring(i - 3, i) == "log") {
                lastLogIx = i
                i++
            }  else if (c.digitToIntOrNull() != null) {
                lastNumIx = i
                i++
            }  else if ((c == ' ' || c == '^') && lastLogIx != -1) {
                val logResult = log10(calculationTemp.substring(lastLogIx, lastNumIx + 1).toDouble()).toString()
                calculationTemp = calculationTemp.replaceRange(lastLogIx - 3, lastNumIx + 1, logResult)
                i = lastLogIx - 3 + logResult.length
                lastLogIx = -1

            } else i++
        }

        return calculationTemp.removeRange(calculationTemp.lastIndex, calculationTemp.length)
    }

    private fun lnCheck (calculation: String): String {        // 0 ve daha kucuk bisey konulursa NaN veriyo oyle olursa uyari mesaji ver
        var calculationTemp = "$calculation "
        var lastNumIx = 0
        var lastLnIx = -1
        var i = 2

        if (calculation.contains("NaN") ) {
            return "NaN"
        } else if (calculation.contains("Infinity")) {
            return "Infinity"
        }

        while (calculationTemp.length > i) {
            val c = calculationTemp[i]

            if (calculationTemp.substring(i - 2, i) == "ln") {            //hata mesaji ver
                lastLnIx = i
                i++
            }  else if (c.digitToIntOrNull() != null) {
                lastNumIx = i
                i++
            }  else if ((c == ' ' || c == '^') && lastLnIx != -1) {
                val lnResult = ln(calculationTemp.substring(lastLnIx, lastNumIx + 1).toDouble()).toString()
                calculationTemp = calculationTemp.replaceRange(lastLnIx - 2, lastNumIx + 1, lnResult)
                i = lastLnIx - 2 + lnResult.length
                lastLnIx = -1

            } else i++
        }

        return calculationTemp.removeRange(calculationTemp.lastIndex, calculationTemp.length)
    }

    private fun factorial (number: Double) : String {
        var i = 1
        var result = 1.0
        while (i <= number) {
            result *= i
            i++
        }
        return result.toString()
    }


    private fun operate (calculation: String): Double {
        var calculationTemp = calculation
        val numberList = mutableListOf<Double>()
        val operationList = mutableListOf<Char>()
        var operationPosition = 0

        calculationTemp = absoluteCheck(calculationTemp)
        calculationTemp = logCheck(calculationTemp)
        calculationTemp = lnCheck(calculationTemp)
        calculationTemp = trigonometryCheck(calculationTemp)
        calculationTemp = squareRootCheck(calculationTemp)
        calculationTemp = powerCheck(calculationTemp)
        calculationTemp = factorialCheck(calculationTemp)
        calculationTemp = percentCheck(calculationTemp) + " = "

        if (calculationTemp.contains("NaN") ) {
            return Double.NaN
        } else if (calculation.contains("Infinity")) {
            return Double.POSITIVE_INFINITY
        }

        calculationTemp.forEachIndexed { index, c ->
            if (c == '+' || c == '-' || c == '×' || c == '÷' || c == '=') {
                if (calculationTemp[index + 1] == ' ') {
                    numberList.add(calculationTemp.substring(operationPosition, index - 1).toDouble())
                    if (c != '=') {
                        operationList.add(c)
                        operationPosition = index + 2
                    }
                }
            }
        }

        var i = 0
        while (i < operationList.size) {
            val c = operationList[i]
            if (c == '×') {
                numberList[i] = numberList[i] * numberList[i + 1]
                numberList.removeAt(i + 1)
                operationList.removeAt(i)
            } else if (c == '÷') {
                numberList[i] = numberList[i] / numberList[i + 1]
                numberList.removeAt(i + 1)
                operationList.removeAt(i)
            } else {
                i++
            }
        }

        var j = 0
        while (j < operationList.size) {
            val c = operationList[j]
            if (c == '+') {
                numberList[j] = numberList[j] + numberList[j + 1]
                numberList.removeAt(j + 1)
                operationList.removeAt(j)
            } else if (c == '-' ) {
                numberList[j] = numberList[j] - numberList[j + 1]
                numberList.removeAt(j + 1)
                operationList.removeAt(j)

            } else {
                j++
            }
        }

        return numberList[0]
    }

    private fun operateInPara (calculation: String): String {
        var calculationTemp = calculation
        var paraIx = mutableListOf<Int>()
        var index = 0

        if (calculation.contains("NaN") ) {
            return "NaN"
        } else if (calculation.contains("Infinity")) {
            return "Infinity"
        }

        while (index < calculationTemp.length) {
            val c = calculationTemp[index]
            if (c == '(') {
                paraIx.add(index)
                index++
            } else if (c == ')') {
                val newOperation = calculationTemp.substring(paraIx.last() + 1, index)
                val newResult = operate(newOperation)

                calculationTemp = calculationTemp.replace("($newOperation)", newResult.toString())
                index = paraIx.last()
                paraIx.removeLast()
            } else {
                index++
            }
        }

        return calculationTemp
    }
}