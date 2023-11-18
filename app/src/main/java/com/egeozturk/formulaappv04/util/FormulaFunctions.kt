package com.egeozturk.formulaappv04.util

import kotlin.math.*

class FormulaFunctions (vararg val v: Double?, val nullIndex: Int, val constant: Double) {

    private fun triangleCheck(a: Double, b: Double, c: Double): Boolean {
        return (a + b) > c && c > abs(a - b) &&
                (c + b) > a && a > abs(c - b) &&
                (a + c) > b && b > abs(c - a)
    }

    private fun factorial (n: Double): Double {
        var i = n
        var result = 1.0
        while (i > 0 ) {
            result *= i
            i--
        }
        return result
    }

    private fun findPrimeNumberUntil (limit: Long): ArrayList<Long> {

        //async yap

        val primeNumberList = arrayListOf<Long>()
        var dividedNumber = limit

        var primeIndex = 2L

        while (primeIndex <= dividedNumber) {

            if (dividedNumber % primeIndex == 0L) {
                primeNumberList.add(primeIndex)
                dividedNumber /= primeIndex
            } else {
                if (primeIndex == 2L) {
                    primeIndex++
                } else {
                    primeIndex += 2
                }

            }
        }

        return primeNumberList
    }

    private fun isPrime (number: Double): Boolean {
        var checkingLimit = sqrt(number).toInt()

        if (number < 2) {                   // Sieve of Eratosthenes kullanabilirsin
            return false
        }

        while(checkingLimit >= 2) {
            if (number % checkingLimit == .0) {
                return false
            } else {
                checkingLimit--
            }
        }

        return true
    }

    private fun findPositiveIntegerDivisor(number: Double): ArrayList<Int> {

        val intNumber = number.toInt()

        val smallDivisors = arrayListOf(1)
        val bigDivisors = arrayListOf(intNumber)

        var i = 2

        while (i <= sqrt(number)) {

            if (number % i == 0.0) {

                if (i * i != intNumber) {
                    bigDivisors.add(0, intNumber / i)
                }
                smallDivisors.add(i)
            }

            i++
        }

        return (smallDivisors + bigDivisors) as ArrayList<Int>
    }

    private fun gcd(num1: Double, num2: Double) : Long {     //greatest common divisor

        var gcd = 1L                                            //Euclidean algorithm kullanabilirsin
        var firstNumber = num1
        var secondNumber = num2

        var i = 2

        while (firstNumber >= i && secondNumber >= i) {
            if (firstNumber % i == 0.0 && secondNumber % i == 0.0) {
                gcd *= i
                firstNumber /= i
                secondNumber /= i
            } else if (firstNumber % i == 0.0) {
                firstNumber /= i
            } else if (secondNumber % i == 0.0) {
                secondNumber /= i
            } else {
                i++
            }
        }

        return gcd
    }

    private fun lcm(num1: Double, num2: Double) : Long {

        var lcm = 1L
        var firstNumber = num1
        var secondNumber = num2

        var i = 2

        while (firstNumber >= i || secondNumber >= i) {
            if (firstNumber % i == 0.0 && secondNumber % i == 0.0) {
                lcm *= i
                firstNumber /= i
                secondNumber /= i
            } else if (firstNumber % i == 0.0) {
                firstNumber /= i
                lcm *= i
            } else if (secondNumber % i == 0.0) {
                secondNumber /= i
                lcm *= i
            } else {
                i++
            }
        }

        return lcm
    }


    //Math--------------------------------------------------------------------------------------------

    fun pythagoreanTheoremFunction () : String {
        when (nullIndex) {
            0 -> {
                return sqrt((v[2]!!).pow(2) - (v[1]!!).pow(2)).toString()
            }
            1 -> {
                return sqrt((v[2]!!).pow(2) - (v[0]!!).pow(2)).toString()
            }
            2 -> {
                return (sqrt((v[0]!!).pow(2) + (v[1]!!).pow(2))).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun rectangleAreaFormulaFunction (): String {
        when (nullIndex) {
            0 -> {      //side one
                return (v[2]!! / v[1]!!).toString()
            }
            1 -> {      //side one
                return (v[2]!! / v[0]!!).toString()
            }
            2 -> {      //side one
                return (v[0]!! * v[1]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun circumferenceOfCircleFormulaFunction() : String {
        when (nullIndex) {
            0 -> {      //radius
                return (v[1]!! / (2 * PI)).toString()
            }
            1 -> {      //circumference
                return (v[0]!! * 2 * PI).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun areaOfCircleFormulaFunction() : String {
        when (nullIndex) {
            0 -> {      //radius
                return sqrt(v[1]!! / PI).toString()
            }
            1 -> {      //area
                return (PI * v[0]!!.pow(2)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun surfaceAreaOfSphereFormulaFunction() : String {
        when (nullIndex) {
            0 -> {      //radius
                return sqrt(v[1]!! / (4 * constant)).toString()
            }
            1 -> {      //surface area
                return (4 * constant * v[0]!!.pow(2)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun volumeOfSphereFormulaFunction() : String {
        when (nullIndex) {
            0 -> {      //radius
                return Math.cbrt(3 * v[1]!! / (4 * constant)).toString()
            }
            1 -> {      //volume
                return (constant * v[0]!!.pow(3) * 4 / 3).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun sumOfInteriorAnglesOfPolygonsFormulaFunction() : String {
        when (nullIndex) {
            0 -> {      //number of sides
                return (v[1]!! / 180 + 2).toString()
            }
            1 -> {      //sum
                return ((v[0]!! - 2) * 180).toString()
            } else -> {
                return "NaN"
            }
        }
    }

    fun numberOfDiagonalsFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //number of sides
                return ((3 + sqrt(9 + 8 * v[1]!!)) / 2).toString()
            }
            1 -> {      //number of diagonals
                return (v[0]!! * (v[0]!! - 3) / 2).toString()
            } else -> {
                return "NaN"
            }
        }
    }

    fun rootsOfQuadraticEquationFunction(): String {
        val x1 = (-v[1]!! - sqrt(v[1]!!.pow(2) - 4 * v[0]!! * v[2]!!)) / (2 * v[0]!!)
        val x2 = (-v[1]!! + sqrt(v[1]!!.pow(2) - 4 * v[0]!! * v[2]!!)) / (2 * v[0]!!)

        return "x₁ = $x1\nx₂ = $x2"
        //x₁
        // sonra irreal sayilar icin de yaz
    }

    fun volumeOfRectangularPrismFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //length
                return (v[3]!! / (v[1]!! * v[2]!!)).toString()
            }
            1 -> {      //width
                return (v[3]!! / (v[0]!! * v[2]!!)).toString()
            }
            2 -> {      //height
                return (v[3]!! / (v[1]!! * v[0]!!)).toString()
            }
            3 -> {      //volume
                return (v[0]!! * v[1]!! * v[2]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun volumeOfCylinderFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //radius
                return sqrt(v[2]!! / (v[1]!! * constant)).toString()
            }
            1 -> {      //height
                return (v[2]!! / (constant * v[0]!!.pow(2))).toString()
            }
            2 -> {      //Volume
                return (constant * v[0]!!.pow(2) * v[1]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun areaOfTriangleFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //base
                return (v[2]!! * 2 / v[1]!!).toString()
            }
            1 -> {      //height
                return (v[2]!! * 2 / v[0]!!).toString()
            }
            2 -> {      //area
                return (v[0]!! * v[1]!! / 2).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun heronsFormulaFunction(): String {
        if (triangleCheck(v[0]!!, v[1]!! , v[2]!!)) {
            val s = (v[0]!! + v[1]!! + v[2]!!) / 2
            return "Area of Triangle: " + sqrt(s * (s - v[0]!!) * (s - v[1]!!) * (s - v[2]!!)).toString()
        } else {
            return "notTriangle"
        }
    }

    fun permutationFunction(): String {
        return (factorial(v[0]!!) / factorial(v[0]!! - v[1]!!)).toString()
    }

    fun combinationFunction(): String {
        return (factorial(v[0]!!) / factorial(v[0]!! - v[1]!!)).toString()
    }

    fun volumeOfPyramidFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //area
                return (v[2]!! * 3 / v[1]!!).toString()
            }
            1 -> {      //height
                return (v[2]!! * 3 / v[0]!!).toString()
            }
            2 -> {      //volume
                return (v[0]!! * v[1]!! / 3).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun volumeOfConeFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //radius
                return sqrt(v[2]!! * 3 / (constant * v[1]!!)).toString()
            }
            1 -> {      //height
                return (v[2]!! * 3 / (constant * v[0]!!.pow(2))).toString()
            }
            2 -> {      //volume
                return (constant * v[0]!!.pow(2) * v[1]!! / 3).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun surfaceAreaOfConeFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //radius
                return ((-v[1]!! + sqrt(v[1]!!.pow(2) + 4 * v[2]!! / constant)) / 2).toString()
            }
            1 -> {      //slant height
                return ((v[2]!! - constant * v[0]!!.pow(2)) / (constant * v[0]!!)).toString()
            }
            2 -> {      //surface area
                return (constant * v[0]!! * (v[0]!! + v[1]!!)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun surfaceAreaOfRectangularPrismFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //side1
                return ((v[3]!! - 2 * v[1]!! * v[2]!!) / 2 / (v[1]!! + v[2]!!)).toString()
            }
            1 -> {      //side2
                return ((v[3]!! - 2 * v[0]!! * v[2]!!) / 2 / (v[0]!! + v[2]!!)).toString()
            }
            2 -> {      //side3
                return ((v[3]!! - 2 * v[1]!! * v[0]!!) / 2 / (v[1]!! + v[0]!!)).toString()
            }
            3 -> {      //surface area
                return (2 * (v[0]!! * v[1]!! + v[0]!! * v[2]!! + v[2]!! * v[1]!!)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun lawOfCosinesFunction(): String {
        return "a = " + sqrt(v[0]!!.pow(2) + v[1]!!.pow(2) - 2 * v[0]!! * v[1]!! * cos(v[2]!! / (180 / PI))).toString()
    }

    fun lawOfSinesFunction(): String {
        when (nullIndex) {
            0 -> {      //angle1
                return (asin(v[1]!! * sin(v[2]!! / (180 / PI)) / v[3]!!) * (180 / PI)).toString()
            }
            1 -> {      //side1
                return (v[3]!! * sin(v[0]!! / (180 / PI)) / sin(v[2]!! / (180 / PI))).toString()
            }
            2 -> {      //angle2
                return (asin(v[3]!! * sin(v[0]!! / (180 / PI)) / v[1]!!) * (180 / PI)).toString()
            }
            3 -> {      //side2
                return (v[1]!! * sin(v[2]!! / (180 / PI)) / sin(v[0]!! / (180 / PI))).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun doubleAngleFormulaForSineFunction(): String {
        return "sin(2α) = " + sin(2 * v[0]!! / (180 / PI)).toString()
    }

    fun sumFormulaForSineFunction(): String {
        return "sin(α + β) = " + sin((v[0]!! + v[1]!!) / (180 / PI)).toString()
    }

    fun doubleAngleFormulaForCosineFunction(): String {
        return "cos(2α) = " + cos(2 * v[0]!! / (180 / PI)).toString()
    }

    fun sumFormulaForCosineFunction(): String {
        return "cos(α + β) = " + cos((v[0]!! + v[1]!!) / (180 / PI)).toString()
    }

    fun doubleAngleFormulaForTangentFunction(): String {
        return "tan(2α) = " + tan(2 * v[0]!! / (180 / PI)).toString()
    }

    fun sumFormulaForTangentFunction(): String {
        return "tan(α + β) = " + tan((v[0]!! + v[1]!!) / (180 / PI)).toString()
    }

    fun areaOfRegularHexagonFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //area
                return (v[1]!!.pow(2) * 3 * sqrt(3.0) / 2).toString()
            }
            1 -> {      //side1
                return sqrt(2 * v[0]!! / (3 * sqrt(3.0))).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun numberOfSubsetFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //subset
                return ((2.0).pow(v[1]!!)).toString()
            }
            1 -> {      //elements
                return (log(v[0]!!, 2.0)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun numberOfProperSubsetFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //subset
                return ((2.0).pow(v[1]!!) - 1).toString()
            }
            1 -> {      //elements
                return (log(v[0]!! + 1, 2.0)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun primeFactorFinderFunction(): String {
        if (v[0]!! < 2) {
            return "NaN"
        } else {

            val primeFactorList = findPrimeNumberUntil(v[0]!!.toLong())
            primeFactorList.add(0)

            var primeFactorString = ""
            var previousNumber = primeFactorList[0]
            var numberOfRepeats = 0

            primeFactorList.forEach {

                if (previousNumber == it) {
                    numberOfRepeats++
                } else {

                    if (numberOfRepeats == 1) {
                        primeFactorString += "$previousNumber × "
                    } else {
                        primeFactorString += "$previousNumber^$numberOfRepeats × "
                    }

                    numberOfRepeats = 1
                }

                previousNumber = it
            }
            primeFactorString = primeFactorString.removeRange(primeFactorString.length - 3, primeFactorString.length)

            //println("Prime Numbers: ${primeFactorString}")
            return primeFactorString
        }
    }

    fun primeNumberCheckerFunction(): String {
        val primeValue = isPrime(v[0]!!)

        if (primeValue) {
            return "prime"
        } else {
            return "not prime"
        }
    }

    fun positiveIntegerDivisorFinder(): String {
        val divisors = findPositiveIntegerDivisor(v[0]!!)

        var divisorString = ""

        divisors.forEach {
            divisorString += "$it, "
        }

        return divisorString.removeRange(divisorString.length - 2, divisorString.length)
    }

    fun greatestCommonDivisorFunction(): String {
        return gcd(v[0]!!, v[1]!!).toString()
    }

    fun leastCommonMultipleFunction(): String {
        return lcm(v[0]!!, v[1]!!).toString()
    }

    fun rootCalculatorFunction(): String {
        when (nullIndex) {
            0 -> {      //root
                return (v[1]!!.pow(v[2]!! / v[3]!!)).toString()
            }
            1 -> {      //radicand
                return (v[0]!!.pow(v[3]!! / v[2]!!)).toString()
            }
            2 -> {      //exponent
                return (log(v[0]!!, v[1]!!) * v[3]!!).toString()
            }
            3 -> {      //index
                return (v[2]!! / log(v[0]!!, v[1]!!)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun triangleInequalityCalculatorFunction(): String {
        if (triangleCheck(v[0]!!, v[1]!!, v[2]!!)) {
            return "triangle"
        } else {
            return "notTriangle"
        }
    }

    fun areaOfEquilateralTriangleFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //root
                return (v[1]!!.pow(2) * sqrt(3.0) / 4).toString()
            }
            1 -> {      //radicand
                return sqrt(v[0]!! * 4 / sqrt(3.0)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun factorialFormulaFunction(): String {
        return (factorial(v[0]!!)).toString()
    }

    fun cyclicPermutationFormula(): String {
        return (factorial(v[0]!! - 1.0)).toString()
    }

    fun secondDegreeBinomialExpansionFunction(): String {
        return (v[0]!! + v[1]!!).pow(2.0).toString()
    }

    fun thirdDegreeBinomialExpansionFunction(): String {
        return (v[0]!! + v[1]!!).pow(3.0).toString()
    }

    fun secondDegreeTrinomialExpansionFunction(): String {
        return (v[0]!! + v[1]!! + v[2]!!).pow(2.0).toString()
    }

    fun factorisationOfDifferenceOfTwoSquares(): String {
        return (v[0]!!.pow(2.0) - v[1]!!.pow(2.0)).toString()
    }

    fun factorisationOfDifferenceOfTwoCubes(): String {
        return (v[0]!!.pow(3.0) - v[1]!!.pow(3.0)).toString()
    }

    fun factorisationOfSumOfTwoCubesFunction(): String {
        return (v[0]!!.pow(3.0) + v[1]!!.pow(3.0)).toString()
    }

    fun factorisationOfSumOfXnAndYnFunction(): String {
        return (v[0]!!.pow(v[2]!!) + v[1]!!.pow(v[2]!!)).toString()
    }

    fun factorisationOfDifferenceOfXnAndYnFunction(): String {
        return (v[0]!!.pow(v[2]!!) - v[1]!!.pow(v[2]!!)).toString()
    }

    fun binomialExpansionsFunction(): String {
        return (v[0]!! + v[1]!!).pow(v[2]!!).toString()
    }

    fun interiorAngleOfRegularPolygonFunction (): String {
        when (nullIndex) {
            0 -> {
                return "A = " + ((v[1]!! - 2) * 180 / v[1]!!).toString() + "°"
            }
            1 -> {
                return "n = " + (360 / (180 - v[0]!!)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun exteriorAngleOfRegularPolygonFunction(): String {
        when (nullIndex) {
            0 -> {
                return "A = " + (360 / v[1]!!).toString() + "°"
            }
            1 -> {
                return "n = " + (360 / v[0]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun areaOfTrapezoidFormulaFunction(): String {
        when (nullIndex) {
            0 -> {
                return "A = " + ((v[1]!! + v[2]!!) * v[3]!! / 2).toString()
            }
            1 -> {
                return "a = " + (2 * v[0]!! / v[3]!! - v[2]!!).toString()
            }
            2 -> {
                return "b = " + (2 * v[0]!! / v[3]!! - v[1]!!).toString()
            }
            3 -> {
                return "h = " + (2 * v[0]!! / (v[2]!! + v[1]!!)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun areaOfParallelogramFormulaFunction(): String {
        when (nullIndex) {
            0 -> {
                return "A = " + (v[1]!! * v[2]!!).toString()
            }
            1 -> {
                return "a = " + (v[0]!! / v[2]!!).toString()
            }
            2 -> {
                return "h = " + (v[0]!! / v[1]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun areaOfSquareFormulaFunction(): String {
        when (nullIndex) {
            0 -> {
                return "A = " + (v[1]!! * v[1]!!).toString()
            }
            1 -> {
                return "a = " + (sqrt(v[0]!!)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun lengthOfSpaceDiagonalInRectangularPrismFormulaFunction(): String {
        when (nullIndex) {
            0 -> {
                return "A = " + (sqrt((v[1]!!).pow(2.0) + (v[2]!!).pow(2.0) + (v[3]!!).pow(2.0))).toString()
            }
            1 -> {
                return "a = " + (sqrt((v[0]!!).pow(2.0) - (v[2]!!).pow(2.0) - (v[3]!!).pow(2.0))).toString()
            }
            2 -> {
                return "b = " + (sqrt((v[0]!!).pow(2.0) - (v[1]!!).pow(2.0) - (v[3]!!).pow(2.0))).toString()
            }
            3 -> {
                return "c = " + (sqrt((v[0]!!).pow(2.0) - (v[2]!!).pow(2.0) - (v[1]!!).pow(2.0))).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun volumeOfCubeFormulaFunction(): String {
        when (nullIndex) {
            0 -> {
                return "V = " + (v[1]!!.pow(3.0)).toString()
            }
            1 -> {
                return "a = " + (v[0]!!.pow(1.0 / 3.0)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun surfaceAreaOfCubeFormulaFunction(): String {
        when (nullIndex) {
            0 -> {
                return "A = " + (v[1]!!.pow(2.0) * 6).toString()
            }
            1 -> {
                return "a = " + (sqrt(v[0]!! / 6)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun surfaceAreaOfCylinderFormulaFunction(): String {
        when (nullIndex) {
            0 -> {
                return "A = " + (2 * constant * v[1]!! * (v[1]!! + v[2]!!)).toString() + " = " + (2 * v[1]!! * (v[1]!! + v[2]!!)).toString() + "π"
            }
            1 -> {
                return "r = " + ((-2 * v[2]!! * constant + sqrt(4 * v[2]!!.pow(2.0) * constant.pow(2.0) + 8 * v[0]!! * constant)) / (4 * constant)).toString()
            }
            2 -> {
                return "h = " + (v[0]!! / (2 * constant * v[1]!!) - v[1]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun heightOfRegularTetrahedronFormulaFunction(): String {
        when (nullIndex) {
            0 -> {
                return "h = " + (v[1]!! * sqrt(6.0) / 3).toString()
            }
            1 -> {
                return "a = " + (3 * v[0]!! / sqrt(6.0)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun surfaceAreaOfRegularTetrahedronFormulaFunction(): String {
        when (nullIndex) {
            0 -> {
                return "A = " + (v[1]!! * v[1]!! * sqrt(3.0)).toString()
            }
            1 -> {
                return "a = " + sqrt(v[0]!! / sqrt(3.0)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun volumeOfRegularTetrahedronFormulaFunction(): String {
        when (nullIndex) {
            0 -> {
                return "V = " + (v[1]!!.pow(3.0) * sqrt(2.0) / 12).toString()
            }
            1 -> {
                return "a = " + ((v[0]!! * 12 / sqrt(2.0)).pow(1.0 / 3.0)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun radianDegreeConverterFunction(): String {
        when (nullIndex) {
            0 -> {
                return "D = " + (v[1]!! * 180 / constant).toString() + "° = " + (v[1]!! * 180).toString() + "° ÷ π"
            }
            1 -> {
                return "R = " + (v[0]!! * constant / 180).toString() + " rad = " + (v[0]!! / 180).toString() + "π rad"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun principalAngleFinderFunction(): String {
        var resultAngle = v[0]!!

        while (resultAngle >= 360) {
            resultAngle -= 360
        }

        return "α = $resultAngle°"
    }

    fun distanceBetweenTwoPointsOnTheAnalyticalPlaneFormulaFunction(): String {
        when (nullIndex) {
            0 -> {
                return "d = " + sqrt((v[1]!! - v[2]!!).pow(2.0) + (v[3]!! - v[4]!!).pow(2.0)).toString()
            }
            1 -> {
                return "x₂ = " + (sqrt(v[0]!!.pow(2.0) - (v[3]!! - v[4]!!).pow(2.0)) + v[2]!!).toString()
            }
            2 -> {
                return "x₁ = " + (-sqrt(v[0]!!.pow(2.0) - (v[3]!! - v[4]!!).pow(2.0)) + v[1]!!).toString()
            }
            3 -> {
                return "y₂ = " + (sqrt(v[0]!!.pow(2.0) - (v[1]!! - v[2]!!).pow(2.0)) + v[4]!!).toString()
            }
            4 -> {
                return "y₁ = " + (-sqrt(v[0]!!.pow(2.0) - (v[1]!! - v[2]!!).pow(2.0)) + v[3]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun coordinatesOfTheMidpointOfALineSegmentFormulaFunction(): String {
        val xResult = (v[0]!! + v[1]!!) / 2
        val yResult = (v[2]!! + v[3]!!) / 2

        return "C(x₀,y₀) = ($xResult, $yResult)"
    }

    fun coordinatesOfTheCentroidOfATriangleFormulaFunction(): String {
        val xResult = (v[0]!! + v[1]!! + v[2]!!) / 3
        val yResult = (v[4]!! + v[3]!! + v[5]!!) / 3

        return "G(x₀,y₀) = ($xResult, $yResult)"
    }

    fun averageRateOfChangeFormulaFunction(): String {
        when (nullIndex) {
            0 -> {
                return "m = " + ((v[1]!! - v[2]!!) / (v[3]!! - v[4]!!)).toString()
            }
            1 -> {
                return "f(b) = " + (v[0]!! * (v[3]!! - v[4]!!) + v[2]!!).toString()
            }
            2 -> {
                return "f(a) = " + (-v[0]!! * (v[3]!! - v[4]!!) + v[1]!!).toString()
            }
            3 -> {
                return "b = " + ((v[1]!! - v[2]!!) / v[0]!! + v[4]!!).toString()
            }
            4 -> {
                return "a = " + (-(v[1]!! - v[2]!!) / v[0]!! + v[3]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun exponentialFunctionFormulaFunction(): String {
        when (nullIndex) {
            0 -> {
                return "f(n) = " + (v[1]!!.pow(v[2]!!)).toString()
            }
            1 -> {
                return "a = " + (v[0]!!.pow(1 / v[2]!!)).toString()
            }
            2 -> {
                return "n = " + (log(v[0]!!, v[1]!!)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun logarithmFormulaFunction(): String {
        when (nullIndex) {
            0 -> {
                return "y = " + (log(v[2]!!, v[1]!!)).toString()
            }
            1 -> {
                return "a = " + (v[2]!!.pow(1 / v[0]!!)).toString()
            }
            2 -> {
                return "x = " + (v[1]!!.pow(v[0]!!)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun naturalLogarithmFormulaFunction(): String {
        when (nullIndex) {
            0 -> {
                return "y = " + (ln(v[1]!!)).toString()
            }
            1 -> {
                return "x = " + (E.pow(v[0]!!)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun rthTermOfAnArithmeticSequenceFormulaFunction(): String {
        when (nullIndex) {
            0 -> {
                return "a_n = " + (v[1]!! + v[3]!! * (v[2]!! - 1)).toString()
            }
            1 -> {
                return "a₁ = " + (v[0]!! - v[3]!! * (v[2]!! - 1)).toString()
            }
            2 -> {
                return "n = " + ((v[0]!! - v[1]!!) / (v[3]!!) + 1).toString()
            }
            3 -> {
                return "d = " + ((v[0]!! - v[1]!!) / (v[2]!! - 1)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun sumOfTheMembersOfAnArithmeticSequenceFormulaFunction(): String {
        when (nullIndex) {
            0 -> {
                return "S_n = " + (v[1]!! * (v[2]!! + v[3]!!) / 2).toString()
            }
            1 -> {
                return "n = " + (v[0]!! / (v[2]!! + v[3]!!) * 2).toString()
            }
            2 -> {
                return "a₁ = " + (v[0]!! * 2 / v[1]!! - v[3]!!).toString()
            }
            3 -> {
                return "a_n = " + (v[0]!! * 2 / v[1]!! - v[2]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun nthTermOfAGeometricSequenceFormulaFunction(): String {
        when (nullIndex) {
            0 -> {
                return "a_n = " + (v[1]!! * v[2]!!.pow(v[3]!! - 1)).toString()
            }
            1 -> {
                return "a₁ = " + (v[0]!! / v[2]!!.pow(v[3]!! - 1)).toString()
            }
            2 -> {
                return "r = " + ((v[0]!! / v[1]!!).pow(1 / (v[3]!! - 1))).toString()
            }
            3 -> {
                return "n = " + (log(v[0]!! * v[2]!! / v[1]!!, v[2]!!)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun sumOfTheMembersOfAGeometricSequenceFormulaFunction(): String {
        when (nullIndex) {
            0 -> {
                return "S_n = " + (v[1]!! * (1 - v[2]!!.pow(v[3]!!)) / (1 - v[2]!!)).toString()
            }
            1 -> {
                return "a₁ = " + (v[0]!! / (1 - v[2]!!.pow(v[3]!!)) / (1 - v[2]!!)).toString()
            }
            2 -> {
                return "r = " + ("").toString()     //burayi yap
            }
            3 -> {
                return "n = " + (log(1 - (1 - v[2]!!) * v[0]!! / v[1]!!, v[2]!!)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun productOfTheMembersOfAGeometricSequenceFormulaFunction(): String {
        when (nullIndex) {
            0 -> {
                return "P_n = " + (v[1]!!.pow(v[3]!!) * sqrt(v[2]!!.pow(v[3]!! * (v[3]!! - 1)))).toString()
            }
            1 -> {
                return "a₁ = " + (v[0]!! / sqrt(v[2]!!.pow(v[3]!! * (v[3]!! - 1)))).pow(1 / v[3]!!).toString()
            }
            2 -> {
                return "r = " + (v[0]!! / v[1]!!.pow(v[3]!!)).pow(2 / (v[3]!! * (v[3]!! - 1))).toString()     //burayi yap
            }
            3 -> {

                var nGuess = 1
                while (v[0]!! != v[1]!!.pow(nGuess) * sqrt(v[2]!!.pow(nGuess * (nGuess - 1)))) {
                    nGuess++
                    if (nGuess == 999999) {
                        return "NaN"
                    }
                }

                return "n = " + (nGuess).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun fibonacciSequenceStartingFrom1TermFinderFunction(): String {
        val n = v[0]!!
        var i = 3
        var result = 1.0
        var oldResult = 1.0

        while (i <= n) {
            result += oldResult
            oldResult = result - oldResult
            i++
        }
        return "F_n = $result"
    }

    fun nthPowerOfiCalculatorFunction(): String {
        val n = v[0]!!.toInt()
        val result: String = if (n % 4 == 0) {
            "1"
        } else if (n % 4 == 1) {
            "i"
        } else if (n % 4 == 2) {
            "-1"
        } else {
            "-i"
        }

        return "iⁿ = $result"
    }

    fun rotationOfAPointAroundOriginFormulaFunction(): String {
        val newX = v[0]!! * cos(v[2]!! * PI / 180) - v[1]!! * sin(v[2]!! * PI / 180)
        val newY = v[0]!! * sin(v[2]!! * PI / 180) + v[1]!! * cos(v[2]!! * PI / 180)

        return "A'(x,y) = ($newX,$newY)"
    }

    fun reflectionAcrossXAxisFormulaFunction(): String {
        val newX = v[0]!!
        val newY = -v[1]!!

        return "A'(x',y') = ($newX, $newY)"
    }

    fun reflectionAcrossYAxisFormulaFunction(): String {
        val newX = -v[0]!!
        val newY = v[1]!!

        return "A'(x',y') = ($newX, $newY)"
    }

    fun reflectionAcrossYXFormulaFunction(): String {
        val newX = v[1]!!
        val newY = v[0]!!

        return "A'(x',y') = ($newX, $newY)"
    }

    fun reflectionAcrossYminusXFormulaFunction(): String {
        val newX = -v[1]!!
        val newY = -v[0]!!

        return "A'(x',y') = ($newX, $newY)"
    }

    fun reflectionAcrossXAFormulaFunction(): String {
        val newX = 2 * v[2]!! - v[0]!!
        val newY = v[1]!!

        return "A'(x',y') = ($newX, $newY)"
    }

    fun reflectionAcrossYAFormulaFunction(): String {
        val newX = v[0]!!
        val newY = 2 * v[2]!! - v[1]!!

        return "A'(x',y') = ($newX, $newY)"
    }

    fun reflectionOverOriginFormulaFunction(): String {
        val newX = -v[0]!!
        val newY = -v[1]!!

        return "A'(x',y') = ($newX, $newY)"
    }

    fun reflectionOfALineAcrossXAxisFormulaFunction(): String {
        return "L' = (" + v[0]!! + ")x + (" + -v[1]!! + ")y + " + v[2]!! + " = 0"
    }

    fun reflectionOfALineAcrossYAxisFormulaFunction(): String {
        return "L' = (" + -v[0]!! + ")x + (" + v[1]!! + ")y + " + v[2]!! + " = 0"
    }

    fun reflectionOfALineAcrossYXFormulaFunction(): String {
        return "L' = (" + v[0]!! + ")x + (" + v[1]!! + ")y + " + v[2]!! + " = 0"
    }
    fun reflectionOfALineAcrossYminusXFormulaFunction(): String {
        return "L' = (" + -v[0]!! + ")x + (" + -v[1]!! + ")y + " + v[2]!! + " = 0"
    }
    fun reflectionOfALineAcrossXDFormulaFunction(): String {
        return "L' = " + v[0]!! + "(${v[3]!! * 2} - x) + (" + v[1]!! + ")y + " + v[2]!! + " = 0"
    }
    fun reflectionOfALineAcrossYEFormulaFunction(): String {
        return "L' = (" + -v[0]!! + ")x + ${v[1]!!}(${v[3]!! * 2} - y) + " + v[2]!! + " = 0"
    }
    fun reflectionOfALineOverOriginFormulaFunction(): String {
        //devam et
        //bunun ve usttekinin dogrulunu kontrol et
        return "L' = - (" + v[0]!! + ")x - (" + v[1]!! + ")y + " + v[2]!! + " = 0"
    }



    //Chemistry--------------------------------------------------------------------------------

    fun idealGasLawFunction(): String {
        when (nullIndex) {
            0 -> {
                return "P = " + (v[2]!! * constant * v[3]!! / v[1]!!).toString()
            }
            1 -> {
                return "V = " + (v[2]!! * constant * v[3]!! / v[0]!!).toString()
            }
            2 -> {
                return "n = " + (v[1]!! * v[0]!! / constant / v[3]!!).toString()
            }
            3 -> {
                return "T = " + (v[1]!! * v[0]!! / constant / v[2]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun kineticEnergyOfGasFormulaFunction(): String {
        when (nullIndex) {
            0 -> {
                return "E = " + (constant * v[1]!! * 3 / 2).toString()
            }
            1 -> {
                return "T = " + (v[0]!! / (constant * 3 / 2)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun velocityOfGasParticlesFormulaFunction(): String {
        when (nullIndex) {
            0 -> {  //velocity
                return "v = " + sqrt(3 * v[1]!! * constant * 100 /v[2]!!).toString()
            }
            1 -> {  //temperature
                return "T = " + (v[0]!!.pow(2) * v[2]!! / (3 * constant * 100)).toString()
            }
            2 -> { //mass
                return "m = " + (3 * constant * 100 * v[1]!! / v[0]!!.pow(2)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun idealGasLaw2Function(): String {
        when (nullIndex) {
            0 -> {
                return "P = " + (v[2]!! * constant * v[3]!! / v[1]!!).toString() + " Pa"
            }
            1 -> {
                return "Mₐ = " + (v[2]!! * constant * v[3]!! / v[0]!!).toString() + "kg/mol"        //bu birime bakk!!!
            }
            2 -> {
                return "d = " + (v[1]!! * v[0]!! / constant / v[3]!!).toString() + " kg/m³"
            }
            3 -> {
                return "T = " + (v[1]!! * v[0]!! / constant / v[2]!!).toString() + " K"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun boylesLawFunction(): String {
        when (nullIndex) {
            0 -> {      //pressure
                return "P₁ = " + (v[2]!! * v[3]!! / v[1]!!).toString() + " Pa"
            }
            1 -> {      //volume
                return "V₁ = " + (v[2]!! * v[3]!! / v[0]!!).toString() + " m³"
            }
            2 -> {      //pressure
                return "P₂ = " + (v[1]!! * v[0]!! / v[3]!!).toString() + " Pa"
            }
            3 -> {      //volume
                return "V₂ = " + (v[1]!! * v[0]!! / v[2]!!).toString() + " m³"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun charlessLawFunction(): String {
        when (nullIndex) {
            0 -> {      //vol
                return "V₁ = " + (v[2]!! * v[1]!! / v[3]!!).toString() + " m³"
            }
            1 -> {      //temp
                return "T₁ = " + (v[3]!! * v[0]!! / v[2]!!).toString() + " K"
            }
            2 -> {      //vol
                return "V₂ = " + (v[0]!! * v[3]!! / v[1]!!).toString() + " m³"
            }
            3 -> {      //temp
                return "T₂ = " + (v[1]!! * v[2]!! / v[0]!!).toString() + " K"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun gayLussacsLawFunction(): String {
        when (nullIndex) {
            0 -> {      //pressure
                return "P₁ = " + (v[2]!! * v[1]!! / v[3]!!).toString() + " Pa"
            }
            1 -> {      //temp
                return "T₁ = " + (v[3]!! * v[0]!! / v[2]!!).toString() + " K"
            }
            2 -> {      //pressure
                return "P₂ = " + (v[0]!! * v[3]!! / v[1]!!).toString() + " Pa"
            }
            3 -> {      //temp
                return "T₂ = " + (v[1]!! * v[2]!! / v[0]!!).toString() + " K"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun avogadrosLawFunction(): String {
        when (nullIndex) {
            0 -> {      //vol
                return "V₁ = " + (v[2]!! * v[1]!! / v[3]!!).toString() + " m³"
            }
            1 -> {      //moles
                return "n₁ = " + (v[3]!! * v[0]!! / v[2]!!).toString() + " mol"
            }
            2 -> {      //vol
                return "V₂ = " + (v[0]!! * v[3]!! / v[1]!!).toString() + " m³"
            }
            3 -> {      //moles
                return "n₂ = " + (v[1]!! * v[2]!! / v[0]!!).toString() + " mol"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun numberOfMolesFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //moles
                return "n = " + (v[1]!! / constant).toString() + " mol"
            }
            1 -> {      //particles
                return "N = " + (v[0]!! * constant).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun numberOfMolesFormula2Function(): String {
        when (nullIndex) {
            0 -> {      //moles
                return "n = " + (v[1]!! / v[2]!!).toString() + " mol"
            }
            1 -> {      //mass
                return "m = " + (v[0]!! * v[2]!!).toString() + " kg"
            }
            2 -> {      //molar mass
                return "Mₐ = " + (v[1]!! / v[0]!!).toString() + " kg/mol"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun atomicMassFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //atomic mass           ///bunun biriminin ne olarak girilcegini sec
                return "M = " + (v[1]!! / constant).toString() + " kg = " + (v[1]!!).toString() + " amu"
            }
            1 -> {      //molar mass
                return "Mₐ = " + (v[0]!! * constant).toString() + " kg/mol"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun numberOfMolesFormulaForGasesUnderNormalConditionsFunction(): String {
        when (nullIndex) {
            0 -> {      //moles
                return "n = " + (v[1]!! / 22.4).toString() + " mol"
            }
            1 -> {      //vol
                return "V = " + (v[0]!! * 22.4).toString() + " L"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun massPercentCompositionFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //MPC
                return "MPC = " + (v[1]!! / v[2]!! * 100).toString() + " %"
            }
            1 -> {      // solute mass
                return "m = " + (v[0]!! * v[2]!! / 100).toString() + " kg"
            }
            2 -> {      // mixture mass
                return "M = " + (v[1]!! / (v[0]!! / 100)).toString() + " kg"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun volumePercentCompositionFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //VPC
                return "VPC = " + (v[1]!! / v[2]!! * 100).toString() + " %"
            }
            1 -> {      // solute volume
                return "V = " + (v[0]!! * v[2]!! / 100).toString() + " L"
            }
            2 -> {      // mixture volume
                return "V_total = " + (v[1]!! / (v[0]!! / 100)).toString() + " L"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun ppmFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //ppm
                return "ppm = " + (v[1]!! / v[2]!! * 1000000).toString()
            }
            1 -> {      // solute mass
                return "m = " + (v[0]!! * v[2]!! / 1000000).toString() + " kg"
            }
            2 -> {      // mixture mass
                return "M = " + (v[1]!! / (v[0]!! / 1000000)).toString() + " kg"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun ppbFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //ppb
                return "ppb = " + (v[1]!! / v[2]!! * 1000000000).toString()
            }
            1 -> {      // solute mass
                return "m = " + (v[0]!! * v[2]!! / 1000000000).toString() + " kg"
            }
            2 -> {      // mixture mass
                return "M = " + (v[1]!! / (v[0]!! / 1000000000)).toString() + " kg"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun averageKineticEnergyFormulaOfGasMoleculesFunction(): String {
        when (nullIndex) {
            0 -> {      //Energy
                return "E = " + (constant * v[1]!! * 3 / 2).toString() + " J = " + (v[1]!! * 3 / 2).toString() + "k J"
            }
            1 -> {      // temp
                return "T = " + (v[0]!! * 2 / 3 / constant).toString() + " K = " + (v[0]!! * 2 / 3).toString() + "/k K"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun grahamsLawOfDiffusionFunction(): String {
        when (nullIndex) {
            0 -> {      //diff velo
                return "v₁ = " + (v[1]!! * sqrt(v[2]!! / v[3]!!)).toString() + " m/s"
            }
            1 -> {      // diff velo
                return "v₂ = " + (v[0]!! / sqrt(v[2]!! / v[3]!!)).toString() + " m/s"
            }
            2 -> {      //molmas
                return "Mₐ₂ = " + ((v[0]!! / v[1]!!).pow(2) * v[3]!!).toString() + " kg/mol"
            }
            3 -> {      // molmas
                return "Mₐ₁ = " + (v[2]!! / (v[0]!! / v[1]!!).pow(2)).toString() + " kg/mol"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun averageVelocityOfGasMoleculesFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //velo
                return "v = " + sqrt(v[1]!! * 3 * constant / v[2]!!).toString() + " m/s = " + sqrt(v[1]!! * 3 / v[2]!!).toString() + "√(k) m/s"
            }
            1 -> {      // temp
                return "T = " + (v[0]!!.pow(2) * v[2]!! / 3 / constant).toString() + " K = " + (v[0]!!.pow(2) * v[2]!! / 3).toString() + "/k K"
            }
            2 -> {      //molmas
                return "Mₐ = " + (v[1]!! * 3 * constant / v[0]!!.pow(2)).toString() + " kg/mol = " + (v[1]!! * 3 / v[0]!!.pow(2)).toString() + "k kg/mol"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun diffusionRateEquationFunction(): String {
        when (nullIndex) {
            0 -> {      //diff velo
                return "v₁ = " + (v[1]!! * sqrt(v[2]!! * v[4]!! / (v[3]!! * v[5]!!))).toString() + " m/s"
            }
            1 -> {      // diff velo
                return "v₂ = " + (v[0]!! / sqrt(v[2]!! * v[4]!! / (v[3]!! * v[5]!!))).toString() + " m/s"
            }
            2 -> {      //temp
                return "T₁ = " + ((v[0]!! / v[1]!!).pow(2) * v[3]!! * v[5]!! / v[4]!!).toString() + " K"
            }
            3 -> {      // temp
                return "T₂ = " + (v[2]!! / (v[0]!! / v[1]!!).pow(2)  * v[4]!! / v[5]!!).toString() + " K"
            }
            4 -> {      //molmas
                return "Mₐ₂ = " + ((v[0]!! / v[1]!!).pow(2) * v[3]!! * v[5]!! / v[2]!!).toString() + " kg/mol"
            }
            5 -> {      // molmas
                return "Mₐ₁ = " + (v[2]!! / (v[0]!! / v[1]!!).pow(2)  * v[4]!! / v[3]!!).toString() + " kg/mol"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun partialPressureFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //partial p
                return "Pᵢ = " + (v[1]!! * v[2]!! / v[3]!!).toString() + " Pa"
            }
            1 -> {      // total p
                return "P_total = " + (v[0]!! * v[3]!! / v[2]!!).toString() + " Pa"
            }
            2 -> {      //num mol
                return "nᵢ = " + (v[0]!! * v[3]!! / v[1]!!).toString() + " mol"
            }
            3 -> {      // num mol
                return "n_total = " + (v[1]!! * v[2]!! / v[0]!!).toString() + " K"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun molarityFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //mlarity
                return "M = " + (v[1]!! / v[2]!!).toString() + " mol/L"
            }
            1 -> {      // mol
                return "n = " + (v[0]!! * v[2]!!).toString() + " mol"
            }
            2 -> {      //vol
                return "V = " + (v[1]!! / v[0]!!).toString() + " L"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun molalityFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //molality
                return "m = " + (v[1]!! / v[2]!!).toString() + " mol/kg"
            }
            1 -> {      // mol
                return "n = " + (v[0]!! * v[2]!!).toString() + " mol"
            }
            2 -> {      //mass
                return "M = " + (v[1]!! / v[0]!!).toString() + " kg"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun changeOfConcentrationEquationFunction(): String {
        when (nullIndex) {
            0 -> {      //molarity
                return "M₁ = " + (v[2]!! * v[3]!! / v[1]!!).toString() + " mol/m³"
            }
            1 -> {      // vol
                return "V₁ = " + (v[2]!! * v[3]!! / v[0]!!).toString() + " m³"
            }
            2 -> {      //molarity
                return "M₂ = " + (v[0]!! * v[1]!! / v[3]!!).toString() + " mol/kg"
            }
            3 -> {      //vol
                return "V₂ = " + (v[0]!! * v[1]!! / v[2]!!).toString() + " m³"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun molarityFormula2Function(): String {
        when (nullIndex) {
            0 -> {      //molarity
                return "M = " + (v[2]!! * v[1]!! * 10 / v[3]!!).toString() + " mol/kg"      //birime bak
            }
            1 -> {      // density
                return "d = " + (v[0]!! * v[3]!! / v[2]!! / 10).toString() + " kg/m³"
            }
            2 -> {      //mpc
                return "MPC = " + (v[0]!! * v[3]!! / v[1]!! / 10).toString() + " %"
            }
            3 -> {      //molmas
                return "Mₐ = " + (v[2]!! * v[1]!! * 10 / v[0]!!).toString() + " kg/mol"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun boilingPointElevationFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //elevation
                return "ΔT = " + (v[2]!! * v[1]!! *  v[3]!!).toString() + " K"
            }
            1 -> {      // constant
                return "K_b = " + (v[0]!! / v[2]!! /  v[3]!!).toString() + " L/mol"
            }
            2 -> {      //molality
                return "m = " + (v[0]!! / v[1]!! /  v[3]!!).toString() + " mol/L"
            }
            3 -> {      //particles ions
                return "i = " + (v[0]!! / v[2]!! /  v[1]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun freezingPointDepressionFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //elevation
                return "ΔT = " + (v[2]!! * v[1]!! *  v[3]!!).toString() + " K"
            }
            1 -> {      // constant
                return "K_f = " + (v[0]!! / v[2]!! /  v[3]!!).toString() + " L/mol"
            }
            2 -> {      //molality
                return "m = " + (v[0]!! / v[1]!! /  v[3]!!).toString() + " mol/L"
            }
            3 -> {      //particles ions
                return "i = " + (v[0]!! / v[2]!! /  v[1]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun enthalpyFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //change
                return "ΔH° = " + (v[1]!! - v[2]!!).toString() + " J"
            }
            1 -> {      // products
                return "∑ΔH°(p) = " + (v[0]!! + v[2]!!).toString() + " J"
            }
            2 -> {      //reactants
                return "∑ΔH°(r) = " + (v[1]!! - v[0]!!).toString() + " J"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun enthalpyFormula2Function(): String {
        when (nullIndex) {
            0 -> {      //change
                return "ΔH° = " + (v[1]!! - v[2]!!).toString() + " J"
            }
            1 -> {      // products
                return "∑ΔH°(bb) = " + (v[0]!! + v[2]!!).toString() + " J"
            }
            2 -> {      //reactants
                return "∑ΔH°(bf) = " + (v[1]!! - v[0]!!).toString() + " J"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun reactionRateFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //rate
                return "v = " + (v[1]!! / v[2]!!).toString() + " kg/s"
            }
            1 -> {      // change in mass
                return "Δm = " + (v[0]!! * v[2]!!).toString() + " kg"
            }
            2 -> {      //change in time
                return "Δt = " + (v[1]!! / v[0]!!).toString() + " s"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun reactionRateFormula2Function(): String {
        when (nullIndex) {
            0 -> {      //rate
                return "v = " + (v[1]!! / v[2]!!).toString() + " Pa/s"
            }
            1 -> {      // change in pressure
                return "ΔP = " + (v[0]!! * v[2]!!).toString() + " Pa"
            }
            2 -> {      //change in time
                return "Δt = " + (v[1]!! / v[0]!!).toString() + " s"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun relationshipBetweenEquilibriumConstantsFunction(): String {
        when (nullIndex) {
            0 -> {      //eq co pres
                return "K_p = " + (v[1]!! * (constant * v[2]!!).pow(v[3]!!)).toString()
            }
            1 -> {      // eq co con
                return "K_c = " + (v[0]!! / (v[2]!! * constant).pow(v[3]!!)).toString()
            }
            2 -> {      //temp
                return "T = " + ((v[0]!! / v[1]!!).pow(1 / v[3]!!) / constant).toString() + " K"
            }
            3 -> {      //difference
                return "∆n = " + (log(v[0]!! / v[1]!!, v[2]!! * constant)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun nernstEquationFunction(): String {
        when (nullIndex) {
            0 -> {      //cell pot
                return "E = " + (v[1]!! - 0.0592 / v[2]!! * log(v[3]!!, 10.0)).toString() + " V"
            }
            1 -> {      // standard cell pot
                return "E⁰ = " + (v[0]!! + 0.0592 / v[2]!! * log(v[3]!!, 10.0)).toString() + " V"
            }
            2 -> {      //mole numbe
                return "n = " + (0.0592 * log(v[3]!!, 10.0) / (v[1]!! - v[0]!!)).toString() + " mol"        //yuvarla
            }
            3 -> {      //equ
                return "Q = " + ((10.0).pow((v[1]!! - v[0]!!) * v[2]!! / 0.0592)).toString()                    //yuvarla
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun massOfProducedSubstanceDuringElectrolysisFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //mass
                return "m = " + (v[1]!! * v[2]!! * v[3]!! / (constant * v[4]!!)).toString() + " kg"     //birime bak
            }
            1 -> {      // current
                return "I = " + (v[0]!! * v[4]!! * constant / (v[2]!! * v[3]!!)).toString() + " A"
            }
            2 -> {      //time
                return "t = " + (v[0]!! * v[4]!! * constant / (v[1]!! * v[3]!!)).toString() + " s"
            }
            3 -> {      //molar mass
                return "Mₐ = " + (v[0]!! * v[4]!! * constant / (v[2]!! * v[1]!!)).toString() + " kg/mol"
            }
            4 -> {      //electrones
                return "n = " + (v[1]!! * v[2]!! * v[3]!! / (constant * v[0]!!)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }


    //Physics---------------------------------------------------------------------------------------

    fun kineticEnergyFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //mass
                return (2 * v[2]!! / v[1]!!.pow(2)).toString()
            }
            1 -> {      //velocity
                return sqrt(2 * v[2]!! / v[0]!!).toString()
            }
            2 -> {      //kinetic energy
                return (v[0]!! * v[1]!!.pow(2) / 2).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun gravitationalPotentialEnergyFunction(): String {
        when (nullIndex) {
            0 -> {      //mass
                return (v[3]!! / (v[2]!! * v[1]!!)).toString()
            }
            1 -> {      //gravitational acceleration
                return (v[3]!! / (v[0]!! * v[2]!!)).toString()
            }
            2 -> {      //height
                return (v[3]!! / (v[0]!! * v[1]!!)).toString()
            }
            3 -> {      //potential energy
                return (v[0]!! * v[1]!! * v[2]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun elasticPotentialEnergyFunction(): String {
        when (nullIndex) {
            0 -> {      //spring constant
                return (2 * v[2]!! / v[1]!!.pow(2)).toString()
            }
            1 -> {      //length change
                return sqrt(2 * v[2]!! / v[0]!!).toString()
            }
            2 -> {      //potential energy
                return (v[0]!! * v[1]!!.pow(2) / 2).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun forceFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //Force
                return (v[1]!! * v[2]!!).toString()
            }
            1 -> {      //mass
                return (v[0]!! / v[2]!!).toString()
            }
            2 -> {      //acceleration
                return (v[0]!! / v[1]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun workFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //Work
                return (v[1]!! * v[2]!! * cos(v[3]!! / (180 / PI))).toString()       //hata olabilir
            }
            1 -> {      //Force
                return (v[0]!! / (v[2]!! * cos(v[3]!! / (180 / PI)))).toString()
            }
            2 -> {      //displacement
                return (v[0]!! / (v[1]!! * cos(v[3]!! / (180 / PI)))).toString()
            }
            3 -> {      //angle
                return (acos(v[0]!! / (v[1]!! * v[2]!!)) * (180 / PI)).toString() + "º"
                // yuvarlama algoritmasi yaz
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun powerFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //POwer
                return (v[1]!! / v[2]!!).toString()
            }
            1 -> {      //Energy
                return (v[0]!! * v[2]!!).toString()
            }
            2 -> {      //TIme
                return (v[1]!! / v[0]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun ohmsLawFunction(): String {
        when (nullIndex) {
            0 -> {      //Voltage
                return (v[1]!! * v[2]!!).toString()
            }
            1 -> {      //Current
                return (v[0]!! / v[2]!!).toString()
            }
            2 -> {      //Resistance
                return (v[0]!! / v[1]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun electricPowerFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //power
                return (v[1]!! * v[2]!!).toString()
            }
            1 -> {      //voltage
                return (v[0]!! / v[2]!!).toString()
            }
            2 -> {      //current
                return (v[0]!! / v[1]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun electricCurrentFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //current
                return (v[1]!! / v[2]!!).toString()
            }
            1 -> {      //charge
                return (v[0]!! * v[2]!!).toString()
            }
            2 -> {      //time
                return (v[1]!! / v[0]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun electricFieldFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //field
                return (v[1]!! / v[2]!!).toString()
            }
            1 -> {      //force
                return (v[0]!! * v[2]!!).toString()
            }
            2 -> {      //charge
                return (v[1]!! / v[0]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun coulombsLawFunction(): String {
        when (nullIndex) {
            0 -> {      //force
                return "|F| = " + abs(constant * v[1]!! * v[2]!! / v[3]!!.pow(2)).toString() + " = " + abs(v[1]!! * v[2]!! / v[3]!!.pow(2)).toString() + "k"
            }
            1 -> {      //charge1
                return "q₁ = " + abs(v[0]!! * v[3]!!.pow(2) / (constant * v[2]!!)).toString() + " = " + abs(v[0]!! * v[3]!!.pow(2) / (v[2]!!)).toString() + "/k"
            }
            2 -> {      //charge2
                return "q₂ = " + abs(v[0]!! * v[3]!!.pow(2) / (constant * v[1]!!)).toString() + " = " + abs(v[0]!! * v[3]!!.pow(2) / (v[1]!!)).toString() + "/k"
            }
            3 -> {      //distance
                return "d = " + sqrt(abs(constant * v[1]!! * v[2]!! / v[0]!!)).toString()  + " = " + sqrt(abs(v[1]!! * v[2]!! / v[0]!!)).toString() + "k"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun electricPotentialEnergyFunction(): String {
        when (nullIndex) {
            0 -> {      //energy
                return "E = " + (constant * v[1]!! * v[2]!! / v[3]!!).toString() + " = " + (v[1]!! * v[2]!! / v[3]!!).toString() + "k"
            }
            1 -> {      //charge1
                return "q₁ = " + (v[0]!! * v[3]!! / (constant * v[2]!!)).toString() + " = " + (v[0]!! * v[3]!! / (v[2]!!)).toString() + "/k"
            }
            2 -> {      //charge2
                return "q₂ = " + (v[0]!! * v[3]!! / (constant * v[1]!!)).toString() + " = " + (v[0]!! * v[3]!! / (v[1]!!)).toString() + "/k"
            }
            3 -> {      //distance
                return "d = " + (constant * v[1]!! * v[2]!! / v[0]!!).toString()  + " = " + (v[1]!! * v[2]!! / v[0]!!).toString() + "k"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun electricFieldFormula2Function(): String {
        when (nullIndex) {
            0 -> {      //field
                return "E = " + (constant * v[1]!! / v[2]!!.pow(2)).toString() + " = " + (v[1]!! / v[2]!!.pow(2)).toString() + "k"
            }
            1 -> {      //charge
                return "q = " + (v[2]!!.pow(2) * v[0]!! / constant).toString() + " = " + (v[2]!!.pow(2) * v[0]!!).toString() + "/k"
            }
            2 -> {      //distance
                return "d = " + sqrt(abs(constant * v[1]!! / v[0]!!)).toString()  + " = " + sqrt(abs(v[1]!! / v[0]!!)).toString() + "k"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun capacitanceFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //capacitance
                return "C = " + (v[1]!! / v[2]!!).toString()
            }
            1 -> {      //charge
                return "q = " + (v[0]!! * v[2]!!).toString()
            }
            2 -> {      //voltage
                return "V = " + (v[1]!! / v[0]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun pressureOfSolidsFunction(): String {
        when (nullIndex) {
            0 -> {      //pressure
                return "P = " + (v[1]!! / v[2]!!).toString()
            }
            1 -> {      //force
                return "F = " + (v[0]!! * v[2]!!).toString()
            }
            2 -> {      //area
                return "A = " + (v[1]!! / v[0]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun pressureOfLiquidsFunction(): String {
        when (nullIndex) {
            0 -> {      //pressure
                return "P = " + (v[1]!! * v[2]!! * v[3]!!).toString()
            }
            1 -> {      //height
                return "h = " + (v[0]!! / (v[2]!! * v[3]!!)).toString()
            }
            2 -> {      //density
                return "d = " + (v[0]!! / (v[1]!! * v[3]!!)).toString()
            }
            3 -> {      //g
                return "g = " + (v[0]!! / (v[2]!! * v[1]!!)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun electricPowerFormula2Function(): String {
        when (nullIndex) {
            0 -> {      //power
                return "P = " + (v[1]!!.pow(2) * v[2]!!).toString()
            }
            1 -> {      //current
                return "I = " + sqrt(v[0]!! / v[2]!!).toString()
            }
            2 -> {      //resistance
                return "R = " + (v[0]!! / v[1]!!.pow(2)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun resistanceOfConductorFunction(): String {
        when (nullIndex) {
            0 -> {      //resistance
                return "R = " + (v[1]!! * v[2]!! / v[3]!!).toString()
            }
            1 -> {      //resistivity
                return "ρ = " + (v[0]!! * v[3]!! / v[2]!!).toString()
            }
            2 -> {      //length
                return "l = " + (v[0]!! * v[3]!! / v[1]!!).toString()
            }
            3 -> {      //area
                return "A = " + (v[1]!! * v[2]!! / v[0]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun electricPotentialFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //potential
                return "V = " + (constant * v[1]!! / v[2]!!).toString() + " = " + (v[1]!! / v[2]!!).toString() + "k"
            }
            1 -> {      //charge
                return "q = " + (v[2]!! * v[0]!! / constant).toString() + " = " + (v[2]!! * v[0]!!).toString() + "/k"
            }
            2 -> {      //distance
                return "d = " + abs(constant * v[1]!! / v[0]!!).toString()  + " = " + abs(v[1]!! / v[0]!!).toString() + "k"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun electricFieldBetweenTwoChargedPlatesFunction(): String {
        when (nullIndex) {
            0 -> {      //field
                return "E = " + (v[1]!! / v[2]!!).toString()
            }
            1 -> {      //voltage
                return "V = " + (v[2]!! * v[0]!!).toString()
            }
            2 -> {      //distance
                return "d = " + abs(v[1]!! / v[0]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun forceBetweenTwoChargedPlatesFunction(): String {
        when (nullIndex) {
            0 -> {      //force
                return "F = " + (v[2]!! * v[1]!! / v[3]!!).toString()
            }
            1 -> {      //charge
                return "q = " + (v[0]!! * v[3]!! / v[2]!!).toString()
            }
            2 -> {      //voltage
                return "V = " + (v[0]!! * v[3]!! / v[1]!!).toString()
            }
            3 -> {      //distance
                return "d = " + abs(v[2]!! * v[1]!! / v[0]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun accelerationBetweenTwoChargedPlatesFunction(): String {
        when (nullIndex) {
            0 -> {      //acceleration
                return "a = " + (v[2]!! * v[1]!! / (v[3]!! * v[4]!!)).toString()
            }
            1 -> {      //charge
                return "q = " + (v[0]!! * v[3]!! * v[4]!! / v[2]!!).toString()
            }
            2 -> {      //voltage
                return "V = " + (v[0]!! * v[3]!! * v[4]!! / v[1]!!).toString()
            }
            3 -> {      //distance
                return "d = " + abs(v[2]!! * v[1]!! / (v[0]!! * v[4]!!)).toString()
            }
            4 -> {      //mass
                return "m = " + abs(v[2]!! * v[1]!! / (v[3]!! * v[0]!!)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun transformerEquationFunction(): String {
        when (nullIndex) {
            0 -> {      //pri v
                return "V₁ = " + (v[2]!! * v[1]!! / v[3]!!).toString()
            }
            1 -> {      //sec v
                return "V₂ = " + (v[3]!! * v[0]!! / v[2]!!).toString()
            }
            2 -> {      //pri N
                return "N₁ = " + (v[3]!! * v[0]!! / v[1]!!).toString()
            }
            3 -> {      //sec N
                return "N₂ = " + (v[2]!! * v[1]!! / v[0]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun magneticFieldOfStraightWiresFunction(): String {
        when (nullIndex) {
            0 -> {      //magnetic field
                return "B = " + (v[1]!! / v[2]!! / 2).toString() + " × μ0 / π = " + (2 * v[1]!! / v[2]!!) + "k"
            }
            1 -> {      //current
                return "I = " + (2 * v[0]!! * v[2]!!).toString() + " × π / μ0 = " + (v[0]!! * v[2]!! / 2) + "/ k"
            }
            2 -> {      //distance
                return "d = " + (v[1]!! / v[0]!! / 2).toString() + " × μ0 / π = " + (2 * v[1]!! / v[0]!!) + "k"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun magneticFieldOfCurrentLoopsFunction(): String {
        when (nullIndex) {
            0 -> {      //magnetic field
                return "B = " + (v[2]!! * v[1]!! / v[3]!! / 2).toString() + " × μ0 = " + (v[2]!! * 2 * v[1]!! / v[3]!!) + "π × k"
            }
            1 -> {      //current
                return "I = " + (2 * v[0]!! * v[3]!! / v[2]!!).toString() + " / μ0 = " + (v[0]!! * v[3]!! / v[2]!! / 2) + "/ (k × π)"
            }
            2 -> {      //turns
                return "N = " + (2 * v[0]!! * v[3]!! / v[1]!!).toString() + " / μ0 = " + (v[0]!! * v[3]!! / v[1]!! / 2) + "/ (k × π)"
            }
            3 -> {      //radius
                return "r = " + (v[2]!! * v[1]!! / v[0]!! / 2).toString() + " × μ0 = " + (v[2]!! * 2 * v[1]!! / v[0]!!) + "π × k"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun magneticFieldOfSolenoidsFunction(): String {
        when (nullIndex) {
            0 -> {      //magnetic field
                return "B = " + (v[2]!! * v[1]!! / v[3]!!).toString() + " × μ0 = " + (v[2]!! * 4 * v[1]!! / v[3]!!) + "π × k"
            }
            1 -> {      //current
                return "I = " + (v[0]!! * v[3]!! / v[2]!!).toString() + " / μ0 = " + (v[0]!! * v[3]!! / v[2]!! / 4) + "/ (k × π)"
            }
            2 -> {      //turns
                return "N = " + (v[0]!! * v[3]!! / v[1]!!).toString() + " / μ0 = " + (v[0]!! * v[3]!! / v[1]!! / 4) + "/ (k × π)"
            }
            3 -> {      //radius
                return "l = " + (v[2]!! * v[1]!! / v[0]!!).toString() + " × μ0 = " + (v[2]!! * 4 * v[1]!! / v[0]!!) + "π × k"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun magneticForceOfCurrentCarryingWiresFunction(): String {
        when (nullIndex) {
            0 -> {      //force
                return "F = " + (v[1]!! * v[2]!! * v[3]!! * sin(v[4]!! / (180 / PI))).toString()
            }
            1 -> {      //field
                return "B = " + (v[0]!! / (v[2]!! * v[3]!! * sin(v[4]!! / (180 / PI)))).toString()
            }
            2 -> {      //current
                return "I = " + (v[0]!! / (v[1]!! * v[3]!! * sin(v[4]!! / (180 / PI)))).toString()
            }
            3 -> {      //length
                return "l = " + (v[0]!! / (v[2]!! * v[1]!! * sin(v[4]!! / (180 / PI)))).toString()
            }
            4 -> {      //angle
                return "θ = " + ((180 / PI) * asin(v[0]!! / (v[2]!! * v[1]!! * v[3]!!))).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun lorentzForceFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //force
                return "F = " + (v[1]!! * v[2]!! * v[3]!!).toString()
            }
            1 -> {      //charge
                return "q = " + (v[0]!! / (v[2]!! * v[3]!!)).toString()
            }
            2 -> {      //velocity
                return "v = " + (v[0]!! / (v[1]!! * v[3]!!)).toString()
            }
            3 -> {      //field
                return "B = " + (v[0]!! / (v[2]!! * v[1]!!)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun radiusOfOrbitOfAChargeInMagneticFieldFunction(): String {
        when (nullIndex) {
            0 -> {      //radius
                return "r = " + (v[1]!! * v[2]!! / (v[3]!! * v[4]!!)).toString()
            }
            1 -> {      //mass
                return "m = " + (v[0]!! * v[3]!! * v[4]!! / v[2]!!).toString()
            }
            2 -> {      //velo
                return "v = " + (v[0]!! * v[3]!! * v[4]!! / v[1]!!).toString()
            }
            3 -> {      //field
                return "B = " + (v[1]!! * v[2]!! / (v[0]!! * v[4]!!)).toString()
            }
            4 -> {      //charge
                return "q = " + (v[1]!! * v[2]!! / (v[3]!! * v[0]!!)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun magneticFluxFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //flux
                return "Φ = " + (v[1]!! * v[2]!! * cos(v[3]!! / (180 / PI))).toString()
            }
            1 -> {      //field
                return "B = " + (v[0]!! / (v[2]!! * cos(v[3]!! / (180 / PI)))).toString()
            }
            2 -> {      //area
                return "A = " + (v[0]!! / (v[1]!! * cos(v[3]!! / (180 / PI)))).toString()
            }
            3 -> {      //angle
                return "θ = " + (acos(v[0]!! / (v[2]!! * v[1]!!)) * (180 / PI)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun electromagneticInductionFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //emf
                return "EMF = " + (-v[1]!! / v[2]!!).toString()
            }
            1 -> {      //flux
                return "∆Φ = " + (-v[2]!! * v[0]!!).toString()
            }
            2 -> {      //time
                return "∆t = " + (-v[1]!! / v[0]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun selfInductionEmfFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //emf
                return "EMF = " + (-v[1]!! * v[2]!! / v[3]!!).toString()
            }
            1 -> {      //induction
                return "L = " + (-v[3]!! * v[0]!! / v[2]!!).toString()
            }
            2 -> {      //current
                return "∆I = " + (-v[3]!! * v[0]!! / v[1]!!).toString()
            }
            3 -> {      //time
                return "∆t = " + (-v[1]!! * v[2]!! / v[0]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun peakElectromotiveForceInAGeneratorFunction(): String {
        when (nullIndex) {
            0 -> {      //emf
                return "EMF = " + (v[1]!! * v[2]!! * v[3]!! * v[4]!! * cos(v[5]!! / (180 / PI))).toString()
            }
            1 -> {      //turns
                return "N = " + (v[0]!! / (v[2]!! * v[3]!! * v[4]!! * cos(v[5]!! / (180 / PI)))).toString()
            }
            2 -> {      //field
                return "B = " + (v[0]!! / (v[1]!! * v[3]!! * v[4]!! * cos(v[5]!! / (180 / PI)))).toString()
            }
            3 -> {      //area
                return "A = " + (v[0]!! / (v[2]!! * v[1]!! * v[4]!! * cos(v[5]!! / (180 / PI)))).toString()
            }
            4 -> {      //angular velo
                return "ω = " + (v[0]!! / (v[2]!! * v[3]!! * v[1]!! * cos(v[5]!! / (180 / PI)))).toString()
            }
            5 -> {      //angle
                return "θ = " + (acos(v[0]!! / (v[2]!! * v[3]!! * v[4]!! * v[1]!!)) * (180 / PI)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun relativeMotionFormulaFunction(): String {
        when (nullIndex) {
            0 -> {         //relative
                return "vᵣ = " + (v[1]!! - v[2]!!).toString()
            }
            1 -> {          //v2
                return "v₂ = " + (v[0]!! + v[2]!!).toString()
            }
            2 -> {          //v1
                return "v₁ = " + (v[1]!! - v[0]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun velocityFormulaFunction(): String {
        when (nullIndex) {
            0 -> {         //velo
                return "v = " + (v[1]!! / v[2]!!).toString()
            }
            1 -> {          //disp
                return "Δx = " + (v[0]!! + v[2]!!).toString()
            }
            2 -> {          //time
                return "t = " + abs(v[1]!! / v[0]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun accelerationFormulaFunction(): String {
        when (nullIndex) {
            0 -> {         //acc
                return "a = " + (v[1]!! / v[2]!!).toString()
            }
            1 -> {          //velo
                return "v = " + (v[0]!! + v[2]!!).toString()
            }
            2 -> {          //time
                return "t = " + abs(v[1]!! / v[0]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun acceleratedMotionFormulaFunction(): String {
        when (nullIndex) {
            0 -> {         //disp
                return "Δx = " + (v[1]!! * v[2]!! + v[3]!! * v[2]!!.pow(2) / 2).toString()
            }
            1 -> {          //init v
                return "v0 = " + ((v[0]!! - v[2]!!.pow(2) * v[3]!! / 2) / v[2]!!).toString()
            }
            2 -> {          //time
                val x1 = (-2 * v[1]!! - sqrt(4 * v[1]!!.pow(2) + 8 * v[3]!! * v[0]!!)) / (2 * v[3]!!)
                val x2 = (-2 * v[1]!! + sqrt(4 * v[1]!!.pow(2) + 8 * v[3]!! * v[0]!!)) / (2 * v[3]!!)
                var result = ""

                if (x1 > 0 && x2 > 0) {
                    result = "$x1 or $x2"
                } else if (x1 > 0) {
                    result = x1.toString()
                } else if (x2 > 0) {
                    result = x2.toString()
                }
                return "t = $result"
            }
            3 -> {          //acc
                return "a = " + (2 * (v[0]!! - v[1]!! * v[2]!!) / v[2]!!.pow(2)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun heatFormulaFunction(): String {
        when (nullIndex) {
            0 -> {         //heat
                return "Q = " + (v[1]!! * v[2]!! * v[3]!!).toString()
            }
            1 -> {          //mass
                return "m = " + (v[0]!! / (v[2]!! * v[3]!!)).toString()
            }
            2 -> {          //heat c
                return "c = " + (v[0]!! / (v[1]!! * v[3]!!)).toString()
            }
            3 -> {          //change in temp
                return "ΔT  = " + (v[0]!! / (v[2]!! * v[1]!!)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun heatOfTransformationFormulaFunction(): String {
        when (nullIndex) {
            0 -> {         //heat
                return "Q = " + (v[1]!! * v[2]!!).toString()
            }
            1 -> {          //mass
                return "m = " + (v[0]!! / v[2]!!).toString()
            }
            2 -> {          //trans heat
                return "L = " + (v[0]!! / v[1]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun hookesLawFunction(): String {
        when (nullIndex) {
            0 -> {         //force
                return "F = " + (v[1]!! * v[2]!!).toString()
            }
            1 -> {          //constant
                return "k = " + (v[0]!! / v[2]!!).toString()
            }
            2 -> {          //distance
                return "x = " + (v[0]!! / v[1]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun linearVelocityFormulaFunction(): String {
        when (nullIndex) {
            0 -> {         //velo
                return "v = " + (2 * constant * v[1]!! * v[2]!!).toString() + " = " + (2 * v[1]!! * v[2]!!).toString() + "π"
            }
            1 -> {          //radius
                return "r = " + (v[0]!! / (v[2]!! * 2 * constant)).toString() + " = " + (v[0]!! / (v[2]!! * 2)).toString() + " / π"
            }
            2 -> {          //frequency
                return "f = " + (v[0]!! / (v[1]!! * 2 * constant)).toString() + " = " + (v[0]!! / (v[1]!! * 2)).toString() + " / π"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun linearVelocityFormula2Function(): String {
        when (nullIndex) {
            0 -> {         //velo
                return "v = " + (v[1]!! * v[2]!!).toString()
            }
            1 -> {          //angular velo
                return "ω = " + (v[0]!! / (v[2]!!)).toString()
            }
            2 -> {          //radius
                return "r = " + (v[0]!! / (v[1]!!)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun angularVelocityFormulaFunction(): String {
        when (nullIndex) {
            0 -> {         //velo
                return "ω = " + (2 * constant * v[1]!!).toString() + " = " + (2 * v[1]!!).toString() + "π"
            }
            1 -> {          //frequ
                return "f = " + (v[0]!! / (2 * constant)).toString() + " = " + (v[0]!! / (2)).toString() + " / π"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun centripetalForceFormulaFunction(): String {
        when (nullIndex) {
            0 -> {         //force
                return "F = " + (v[1]!! * v[2]!! * v[3]!!.pow(2)).toString()
            }
            1 -> {          //mass
                return "m = " + (v[0]!! / (v[2]!! * v[3]!!.pow(2))).toString()
            }
            2 -> {         //radius
                return "r = " + (v[0]!! / (v[1]!! * v[3]!!.pow(2))).toString()
            }
            3 -> {          //angular velo
                return "ω = " + sqrt(abs(v[0]!! / (v[1]!! * v[2]!!))).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun centripetalForceFormula2Function(): String {
        when (nullIndex) {
            0 -> {         //force
                return "F = " + (v[1]!! * v[2]!!.pow(2) / v[3]!!).toString()
            }
            1 -> {          //mass
                return "m = " + (v[0]!! * v[3]!! / v[2]!!.pow(2)).toString()
            }
            2 -> {         //velo
                return "v = " + sqrt(abs(v[0]!! * v[3]!! / v[1]!!)).toString()
            }
            3 -> {          //radius
                return "r = " + (v[1]!! * v[2]!!.pow(2) / v[0]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun centripetalAccelerationFormulaFunction(): String {
        when (nullIndex) {
            0 -> {         //force
                return "a = " + (v[1]!! * v[2]!!.pow(2)).toString()
            }
            1 -> {         //radius
                return "r = " + (v[0]!! / (v[2]!!.pow(2))).toString()
            }
            2 -> {          //angular velo
                return "ω = " + sqrt(abs(v[0]!! / (v[1]!!))).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun centripetalAccelerationFormula2Function(): String {
        when (nullIndex) {
            0 -> {         //acc
                return "a = " + (v[1]!!.pow(2) / v[2]!!).toString()
            }
            1 -> {         //velo
                return "v = " + sqrt(abs(v[0]!! * v[2]!!)).toString()
            }
            2 -> {          //radius
                return "r = " + (v[1]!!.pow(2) / v[0]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun minVeloOfAnObjectRotatingInACylinderFunction(): String {
        when (nullIndex) {
            0 -> {         //velo
                return "v_min = " + sqrt(v[1]!! * v[2]!! * v[3]!!).toString()
            }
            1 -> {         //gra acc
                return "g = " + (v[0]!!.pow(2) / (v[2]!! * v[3]!!)).toString()
            }
            2 -> {          //radius
                return "r = " + (v[0]!!.pow(2) / (v[1]!! * v[3]!!)).toString()
            }
            3 -> {          //coefficient
                return "k = " + (v[0]!!.pow(2) / (v[2]!! * v[1]!!)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun velocityOfWavesFormulaFunction(): String {
        when (nullIndex) {
            0 -> {         //velo
                return "v = " + (v[1]!! * v[2]!!).toString()
            }
            1 -> {         //wavelength
                return "λ = " + (v[0]!! / (v[2]!!)).toString()
            }
            2 -> {          //freq
                return "f = " + (v[0]!! / (v[1]!!)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun luminousFluxFormulaFunction(): String {
        when (nullIndex) {
            0 -> {         //flux
                return "Φ = " + (v[1]!! * 4 * constant).toString() + " = " + (v[1]!! * 4).toString() + "π"
            }
            1 -> {         //intensity
                return "I = " + (v[0]!! / (4 * constant)).toString() + " = " + (v[0]!! / 4).toString() + " / π"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun illuminanceFormulaFunction(): String {
        when (nullIndex) {
            0 -> {         //illuminance
                return "E = " + (v[1]!! / v[2]!!.pow(2)).toString()
            }
            1 -> {         //intensity
                return "I = " + (v[0]!! * v[2]!!.pow(2)).toString()
            }
            2 -> {         //radius
                return "r = " + sqrt(v[1]!! / v[0]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun velocityDuringSimpleHarmonicMotionFunction(): String {
        when (nullIndex) {
            0 -> {         //velo
                return "v = " + (v[1]!! * sqrt(abs(v[2]!!.pow(2) - v[3]!!.pow(2)))).toString()
            }
            1 -> {         //angular velo
                return "ω = " + (v[0]!! / sqrt(v[2]!!.pow(2) - v[3]!!.pow(2))).toString()
            }
            2 -> {         //radius
                return "r = " + sqrt(abs(v[0]!!.pow(2) / v[1]!!.pow(2) + v[3]!!.pow(2))).toString()
            }
            3 -> {         //oscillation
                return "x = " + sqrt(abs(v[2]!!.pow(2) - v[0]!!.pow(2) / v[1]!!.pow(2))).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun horizontalVelocityDuringSimpleHarmonicMotionFunction(): String {
        return "v_x = " + (v[0]!! * v[1]!! * sin(v[0]!! * v[2]!! / (180 / PI))).toString()
    }

    fun verticalVelocityDuringSimpleHarmonicMotionFunction(): String {
        return "v_y = " + (v[0]!! * v[1]!! * cos(v[0]!! * v[2]!! / (180 / PI))).toString()
    }

    fun horizontalVelocityDuringSimpleHarmonicMotion2Function(): String {
        when (nullIndex) {
            0 -> {         //velo
                return "v_x = " + (v[1]!! * v[2]!! * sin(v[3]!! / (180 / PI))).toString()
            }
            1 -> {         //ang velo
                return "ω = " + (v[0]!! / (v[2]!! * sin(v[3]!! / (180 / PI)))).toString()
            }
            2 -> {         //radius
                return "r = " + (v[0]!! / (v[1]!! * sin(v[3]!! / (180 / PI)))).toString()
            }
            3 -> {         //angle
                return "θ = " + (asin(v[0]!! / (v[1]!! * v[2]!!)) * (180 / PI)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun verticalVelocityDuringSimpleHarmonicMotion2Function(): String {
        when (nullIndex) {
            0 -> {         //velo
                return "v_y = " + (v[1]!! * v[2]!! * cos(v[3]!! / (180 / PI))).toString()
            }
            1 -> {         //ang velo
                return "ω = " + (v[0]!! / (v[2]!! * cos(v[3]!! / (180 / PI)))).toString()
            }
            2 -> {         //radius
                return "r = " + (v[0]!! / (v[1]!! * cos(v[3]!! / (180 / PI)))).toString()
            }
            3 -> {         //angle
                return "θ = " + (acos(v[0]!! / (v[1]!! * v[2]!!)) * (180 / PI)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun horizontalLocationDuringSimpleHarmonicMotionFunction(): String {
        when (nullIndex) {
            0 -> {         //x
                return "x = " + (v[1]!! * cos(v[3]!! * v[2]!! / (180 / PI))).toString()
            }
            1 -> {         //radius
                return "r = " + (v[0]!! / cos(v[3]!! * v[2]!! / (180 / PI))).toString()
            }
            2 -> {         //ang velo
                return "ω = " + (acos(v[0]!! / v[1]!!) * (180 / PI) / v[3]!!).toString()
            }
            3 -> {         //time
                return "t = " + (acos(v[0]!! / v[1]!!) * (180 / PI) / v[2]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun verticalLocationDuringSimpleHarmonicMotionFunction(): String {
        when (nullIndex) {
            0 -> {         //y
                return "y = " + (v[1]!! * sin(v[3]!! * v[2]!! / (180 / PI))).toString()
            }
            1 -> {         //radius
                return "r = " + (v[0]!! / sin(v[3]!! * v[2]!! / (180 / PI))).toString()
            }
            2 -> {         //ang velo
                return "ω = " + (asin(v[0]!! / v[1]!!) * (180 / PI) / v[3]!!).toString()
            }
            3 -> {         //time
                return "t = " + (asin(v[0]!! / v[1]!!) * (180 / PI) / v[2]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun horizontalLocationDuringSimpleHarmonicMotion2Function(): String {
        when (nullIndex) {
            0 -> {         //x
                return "x = " + (v[1]!! * cos(v[2]!! / (180 / PI))).toString()
            }
            1 -> {         //radius
                return "r = " + (v[0]!! / cos(v[2]!! / (180 / PI))).toString()
            }
            2 -> {         //angle
                return "θ = " + (acos(v[0]!! / v[1]!!) * (180 / PI) ).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun verticalLocationDuringSimpleHarmonicMotion2Function(): String {
        when (nullIndex) {
            0 -> {         //y
                return "y = " + (v[1]!! * sin(v[2]!! / (180 / PI))).toString()
            }
            1 -> {         //radius
                return "r = " + (v[0]!! / sin(v[2]!! / (180 / PI))).toString()
            }
            2 -> {         //angle
                return "θ = " + (asin(v[0]!! / v[1]!!) * (180 / PI)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun horizontalAccelerationDuringSimpleHarmonicMotionFunction(): String {
        return "a_x = " + (v[0]!!.pow(2) * v[1]!! * cos(v[0]!! * v[2]!! / (180 / PI))).toString()
    }

    fun verticalAccelerationDuringSimpleHarmonicMotionFunction(): String {
        return "a_y = " + (v[0]!!.pow(2) * v[1]!! * sin(v[0]!! * v[2]!! / (180 / PI))).toString()
    }

    fun horizontalAccelerationDuringSimpleHarmonicMotion2Function(): String {
        when (nullIndex) {
            0 -> {         //acc
                return "a_x = " + (v[1]!!.pow(2) * v[2]!! * cos(v[3]!! / (180 / PI))).toString()
            }
            1 -> {         //ang velo
                return "ω = " + sqrt(abs(v[0]!! / (v[2]!! * cos(v[3]!! / (180 / PI))))).toString()
            }
            2 -> {         //radius
                return "r = " + (v[0]!! / (v[1]!!.pow(2) * cos(v[3]!! / (180 / PI)))).toString()
            }
            3 -> {         //angle
                return "θ = " + (acos(v[0]!! / (v[1]!!.pow(2) * v[2]!!)) * (180 / PI)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun verticalAccelerationDuringSimpleHarmonicMotion2Function(): String {
        when (nullIndex) {
            0 -> {         //acc
                return "a_y = " + (v[1]!!.pow(2) * v[2]!! * sin(v[3]!! / (180 / PI))).toString()
            }
            1 -> {         //ang velo
                return "ω = " + sqrt(abs(v[0]!! / (v[2]!! * sin(v[3]!! / (180 / PI))))).toString()
            }
            2 -> {         //radius
                return "r = " + (v[0]!! / (v[1]!!.pow(2) * sin(v[3]!! / (180 / PI)))).toString()
            }
            3 -> {         //angle
                return "θ = " + (asin(v[0]!! / (v[1]!!.pow(2) * v[2]!!)) * (180 / PI)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun horizontalRestoringForceDuringSimpleHarmonicMotionFunction(): String {
        return "F_x = " + (v[0]!! * v[1]!!.pow(2) * v[2]!! * cos(v[1]!! * v[3]!! / (180 / PI))).toString()
    }

    fun verticalRestoringForceDuringSimpleHarmonicMotionFunction(): String {
        return "F_y = " + (v[0]!! * v[1]!!.pow(2) * v[2]!! * sin(v[1]!! * v[3]!! / (180 / PI))).toString()
    }

    fun horizontalRestoringForceDuringSimpleHarmonicMotion2Function(): String {
        when (nullIndex) {
            0 -> {         //force
                return "F_x = " + (v[1]!! * v[2]!!.pow(2) * v[3]!! * cos(v[4]!! / (180 / PI))).toString()
            }
            1 -> {         //mass
                return "m = " + (v[0]!! / (v[3]!! * v[2]!!.pow(2) * cos(v[4]!! / (180 / PI)))).toString()
            }
            2 -> {         //ang velo
                return "ω = " + sqrt(abs(v[0]!! / (v[1]!! * v[3]!! * cos(v[4]!! / (180 / PI))))).toString()
            }
            3 -> {         //radius
                return "r = " + (v[0]!! / (v[1]!! * v[2]!!.pow(2) * cos(v[4]!! / (180 / PI)))).toString()
            }
            4 -> {         //angle
                return "θ = " + (acos(v[0]!! / (v[1]!! * v[2]!!.pow(2) * v[3]!!)) * (180 / PI)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun verticalRestoringForceDuringSimpleHarmonicMotion2Function(): String {
        when (nullIndex) {
            0 -> {         //force
                return "F_y = " + (v[1]!! * v[2]!!.pow(2) * v[3]!! * sin(v[4]!! / (180 / PI))).toString()
            }
            1 -> {         //mass
                return "m = " + (v[0]!! / (v[3]!! * v[2]!!.pow(2) * sin(v[4]!! / (180 / PI)))).toString()
            }
            2 -> {         //ang velo
                return "ω = " + sqrt(abs(v[0]!! / (v[1]!! * v[3]!! * sin(v[4]!! / (180 / PI))))).toString()
            }
            3 -> {         //radius
                return "r = " + (v[0]!! / (v[1]!! * v[2]!!.pow(2) * sin(v[4]!! / (180 / PI)))).toString()
            }
            4 -> {         //angle
                return "θ = " + (asin(v[0]!! / (v[1]!! * v[2]!!.pow(2) * v[3]!!)) * (180 / PI)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun periodOfSpringPendulumDuringSimpleHarmonicMotionFunction(): String {
        when (nullIndex) {
            0 -> {         //period
                return "T = " + (2 * constant * sqrt(v[1]!! / v[2]!!)).toString() + " = " + (2 * sqrt(v[1]!! / v[2]!!)).toString() + "π"
            }
            1 -> {         //mass
                return "m = " + (v[0]!!.pow(2) * v[2]!! / (4 * constant.pow(2))).toString() + " = " + (v[0]!!.pow(2) * v[2]!! / 4).toString() + " / π²"
            }
            2 -> {         //contant
                return "k = " + (4 * constant.pow(2) * v[1]!! / v[0]!!.pow(2)).toString() + " = " + (4 * v[1]!! / v[0]!!.pow(2)).toString() + "π²"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun periodOfSimplePendulumDuringSimpleHarmonicMotionFunction(): String {
        when (nullIndex) {
            0 -> {         //period
                return "T = " + (2 * constant * sqrt(v[1]!! / v[2]!!)).toString() + " = " + (2 * sqrt(v[1]!! / v[2]!!)).toString() + "π"
            }
            1 -> {         //length
                return "L = " + (v[0]!!.pow(2) * v[2]!! / (4 * constant.pow(2))).toString() + " = " + (v[0]!!.pow(2) * v[2]!! / 4).toString() + " / π²"
            }
            2 -> {         //gra acc
                return "g = " + (4 * constant.pow(2) * v[1]!! / v[0]!!.pow(2)).toString() + " = " + (4 * v[1]!! / v[0]!!.pow(2)).toString() + "π²"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun maximumSafeSpeedAnObjectCanTakeOnAFrictionalTurnFunction(): String {
        when (nullIndex) {
            0 -> {         //velo
                return "v_max = " + sqrt(v[1]!! * v[2]!! * v[3]!!).toString()
            }
            1 -> {         //fric co
                return "k = " + (v[0]!!.pow(2) / (v[2]!! * v[3]!!)).toString()
            }
            2 -> {         //gra acc
                return "g = " + (v[0]!!.pow(2) / (v[1]!! * v[3]!!)).toString()
            }
            3 -> {         //radius
                return "r = " + (v[0]!!.pow(2) / (v[2]!! * v[1]!!)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun safeSpeedDuringTurningOnAnInclinedAndFrictionlessTurnFunction(): String {
        when (nullIndex) {
            0 -> {         //velo
                return "v = " + sqrt(v[1]!! * v[2]!! * tan(v[3]!! / (180 / PI))).toString()
            }
            1 -> {         //gra acc
                return "g = " + (v[0]!!.pow(2) / (v[2]!! * tan(v[3]!! / (180 / PI)))).toString()
            }
            2 -> {         //radius
                return "r = " + (v[0]!!.pow(2) / (v[1]!! * tan(v[3]!! / (180 / PI)))).toString()
            }
            3 -> {         //angle
                return "θ = " + (atan(v[0]!!.pow(2) / (v[2]!! * v[1]!!)) * (180 / PI)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun safeSpeedDuringTurningInACylinderFunction(): String {
        when (nullIndex) {
            0 -> {         //velo
                return "v = " + sqrt(v[1]!! * v[2]!! / v[3]!!).toString()
            }
            1 -> {         //gra acc
                return "g = " + (v[0]!!.pow(2) * v[3]!! / v[2]!!).toString()
            }
            2 -> {         //radius
                return "r = " + (v[0]!!.pow(2) * v[3]!! / v[1]!!).toString()
            }
            3 -> {         //coeff
                return "k = " + (v[1]!! * v[2]!! / v[0]!!.pow(2)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun momentOfInertiaFormulaFunction(): String {
        when (nullIndex) {
            0 -> {         //moment
                return "I = " + (v[1]!! / v[2]!!).toString()
            }
            1 -> {         //momentum
                return "L = " + (v[0]!! * v[2]!!).toString()
            }
            2 -> {         //ang velo
                return "ω = " + (v[1]!! / v[0]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun momentOfInertiaOfSolidSpheresFunction(): String {
        when (nullIndex) {
            0 -> {         //moment
                return "I = " + (v[1]!! * v[2]!!.pow(2) * 2 / 5).toString()
            }
            1 -> {         //mass
                return "m = " + (v[0]!! * 5 / (v[2]!!.pow(2) * 2)).toString()
            }
            2 -> {         //radius
                return "r = " + sqrt(v[0]!! * 5 / (v[1]!! * 2)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun momentOfInertiaOfSolidCylindersFunction(): String {
        when (nullIndex) {
            0 -> {         //moment
                return "I = " + (v[1]!! * v[2]!!.pow(2) / 2).toString()
            }
            1 -> {         //mass
                return "m = " + (v[0]!! * 2 / (v[2]!!.pow(2))).toString()
            }
            2 -> {         //radius
                return "r = " + sqrt(v[0]!! * 2 / (v[1]!!)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun momentOfInertiaOfDisksFunction(): String {
        when (nullIndex) {
            0 -> {         //moment
                return "I = " + (v[1]!! * v[2]!!.pow(2) / 2).toString()
            }
            1 -> {         //mass
                return "m = " + (v[0]!! * 2 / (v[2]!!.pow(2))).toString()
            }
            2 -> {         //radius
                return "r = " + sqrt(v[0]!! * 2 / (v[1]!!)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun momentOfInertiaOfRingsFunction(): String {
        when (nullIndex) {
            0 -> {         //moment
                return "I = " + (v[1]!! * v[2]!!.pow(2)).toString()
            }
            1 -> {         //mass
                return "m = " + (v[0]!! / (v[2]!!.pow(2))).toString()
            }
            2 -> {         //radius
                return "r = " + sqrt(v[0]!! / (v[1]!!)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun momentOfInertiaOfRodsFunction(): String {
        when (nullIndex) {
            0 -> {         //moment
                return "I = " + (v[1]!! * v[2]!!.pow(2) / 12).toString()
            }
            1 -> {         //mass
                return "m = " + (v[0]!! * 12 / (v[2]!!.pow(2))).toString()
            }
            2 -> {         //length
                return "L = " + sqrt(v[0]!! * 12 / (v[1]!!)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun rotationalKineticEnergyFormulaFunction(): String {
        when (nullIndex) {
            0 -> {         //energy
                return "E = " + (v[1]!! * v[2]!!.pow(2) / 2).toString()
            }
            1 -> {         //moment
                return "I = " + (v[0]!! * 2 / (v[2]!!.pow(2))).toString()
            }
            2 -> {         //ang velo
                return "ω = " + sqrt(v[0]!! * 2 / (v[1]!!)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun kineticEnergyOfARotatingObjectFunction(): String {
        when (nullIndex) {
            0 -> {         //energy
                return "E = " + (v[1]!! * v[2]!!.pow(2) / 2 + v[3]!! * v[4]!!.pow(2) / 2).toString()
            }
            1 -> {         //mass
                return "m = " + ((2 * v[0]!! - v[3]!! * v[4]!!.pow(2)) / v[2]!!.pow(2)).toString()
            }
            2 -> {         //lin velo
                return "v = " + sqrt((2 * v[0]!! - v[3]!! * v[4]!!.pow(2)) / v[1]!!).toString()
            }
            3 -> {         //moment
                return "I = " + ((2 * v[0]!! - v[1]!! * v[2]!!.pow(2)) / v[4]!!.pow(2)).toString()
            }
            4 -> {         //ang velo
                return "ω = " + sqrt((2 * v[0]!! - v[1]!! * v[2]!!.pow(2)) / v[3]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun angularMomentumFormulaFunction(): String {
        when (nullIndex) {
            0 -> {         //ang
                return "L = " + (v[1]!! * v[2]!!).toString()
            }
            1 -> {         //lin
                return "P = " + (v[0]!! / v[2]!!).toString()
            }
            2 -> {         //radius
                return "r = " + (v[0]!! / v[1]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun angularMomentumFormula2Function(): String {
        when (nullIndex) {
            0 -> {         //ang
                return "L = " + (v[1]!! * v[2]!! * v[3]!!).toString()
            }
            1 -> {         //mass
                return "m = " + (v[0]!! / (v[2]!! * v[3]!!)).toString()
            }
            2 -> {         //velo
                return "v = " + (v[0]!! / (v[1]!! * v[3]!!)).toString()
            }
            3 -> {         //radius
                return "r = " + (v[0]!! / (v[2]!! * v[1]!!)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun angularMomentumFormula3Function(): String {
        when (nullIndex) {
            0 -> {         //ang
                return "L = " + (v[1]!! * v[2]!!).toString()
            }
            1 -> {         //lin
                return "I = " + (v[0]!! / v[2]!!).toString()
            }
            2 -> {         //radius
                return "ω = " + (v[0]!! / v[1]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun torqueFormulaFunction(): String {
        when (nullIndex) {
            0 -> {         //torque
                return "τ = " + (v[1]!! * v[2]!! * sin(v[3]!! / (180 / PI))).toString()
            }
            1 -> {         //radius
                return "r = " + (v[0]!! / (v[2]!! * sin(v[3]!! / (180 / PI)))).toString()
            }
            2 -> {         //force
                return "F = " + (v[0]!! / (v[1]!! * sin(v[3]!! / (180 / PI)))).toString()
            }
            3 -> {         //force
                return "α = " + (asin(v[0]!! / v[1]!! / v[2]!!)  * (180 / PI)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun torqueFormula2Function(): String {
        when (nullIndex) {
            0 -> {         //torque
                return "τ = " + (v[1]!! * v[2]!!).toString()
            }
            1 -> {         //moment
                return "I = " + (v[0]!! / v[2]!!).toString()
            }
            2 -> {         //ang acc
                return "α = " + (v[0]!! / v[1]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun tangentialAccelerationFormulaFunction(): String {
        when (nullIndex) {
            0 -> {         //tan acc
                return "a_t = " + (v[1]!! * v[2]!!).toString()
            }
            1 -> {         //ang acc
                return "α = " + (v[0]!! / v[2]!!).toString()
            }
            2 -> {         //radius
                return "r = " + (v[0]!! / v[1]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun gravitationalForceFormulaFunction(): String {
        when (nullIndex) {
            0 -> {         //force
                return "F = " + (v[1]!! * v[2]!! * constant / v[3]!!.pow(2)).toString() + " = " + (v[1]!! * v[2]!! / v[3]!!.pow(2)).toString() + "G"
            }
            1 -> {         //mass1
                return "m₁ = " + (v[0]!! * v[3]!!.pow(2) / (constant * v[2]!!)).toString() + " = " + (v[0]!! * v[3]!!.pow(2) / (v[2]!!)).toString() + " / G"
            }
            2 -> {         //mass2
                return "m₂ = " + (v[0]!! * v[3]!!.pow(2) / (constant * v[1]!!)).toString() + " = " + (v[0]!! * v[3]!!.pow(2) / (v[1]!!)).toString() + " / G"
            }
            3 -> {         //distance
                return "d = " + sqrt(v[1]!! * v[2]!! * constant / v[0]!!).toString() + " = " + sqrt(v[1]!! * v[2]!! / v[0]!!).toString() + "√(G)"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun gravitationalAccelerationFormulaAboveSurfaceFunction(): String {
        when (nullIndex) {
            0 -> {         //acc
                return "g = " + (v[1]!! * constant / v[2]!!.pow(2)).toString() + " = " + (v[1]!! / v[2]!!.pow(2)).toString() + "G"
            }
            1 -> {         //mass
                return "M = " + (v[0]!! * v[2]!!.pow(2) / (constant)).toString() + " = " + (v[0]!! * v[2]!!.pow(2)).toString() + " / G"
            }
            2 -> {         //distance
                return "d = " + sqrt(v[1]!! * constant / v[0]!!).toString() + " = " + sqrt(v[1]!! / v[0]!!).toString() + "√(G)"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun gravitationalAccelerationFormulaInsidePlanetFunction(): String {
        when (nullIndex) {
            0 -> {         //acc
                return "g = " + (v[1]!! * constant * v[2]!!).toString() + " = " + (v[1]!! * v[2]!!).toString() + "k"
            }
            1 -> {         //distance
                return "r = " + (v[0]!! / (v[2]!! * constant)).toString() + " = " + (v[0]!! / (v[2]!!)).toString() + " / k"
            }
            2 -> {         //density
                return "d = " + (v[0]!! / (v[1]!! * constant)).toString() + " = " + (v[0]!! / (v[1]!!)).toString() + " / k"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun gravitationalPotentialEnergyOfAnOrbitingSatelliteFunction(): String {
        when (nullIndex) {
            0 -> {         //energy
                return "E = " + (-v[1]!! * constant * v[2]!! / v[3]!!).toString() + " = " + (-v[1]!! * v[2]!! / v[3]!!).toString() + "G"
            }
            1 -> {         //mass pl
                return "M = " + (-v[0]!! * v[3]!! / (v[2]!! * constant)).toString() + " = " + (-v[0]!! * v[3]!! / (v[2]!!)).toString() + " / G"
            }
            2 -> {         //mass stl
                return "m = " + (-v[0]!! * v[3]!! / (v[1]!! * constant)).toString() + " = " + (-v[0]!! * v[3]!! / (v[1]!!)).toString() + " / G"
            }
            3 -> {         //radius
                return "r = " + (-v[1]!! * constant * v[2]!! / v[0]!!).toString() + " = " + (-v[1]!! * v[2]!! / v[0]!!).toString() + "G"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun escapeVelocityFormulaFunction(): String {
        when (nullIndex) {
            0 -> {         //velo
                return "v = " + sqrt(2 * constant * v[1]!! / v[2]!!).toString() + " = " + sqrt(2 * v[1]!! / v[2]!!).toString() + "√(G)"
            }
            1 -> {         //mass pl
                return "M = " + (v[0]!!.pow(2) * v[2]!! / (2 * constant)).toString() + " = " + (v[0]!!.pow(2) * v[2]!! / (2)).toString() + " / G"
            }
            2 -> {         //distance
                return "d = " + (2 * constant * v[1]!! / v[0]!!.pow(2)).toString() + " = " + (2 * v[1]!! / v[0]!!.pow(2)).toString() + "G"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun escapeEnergyFormulaFunction(): String {
        when (nullIndex) {
            0 -> {         //energy
                return "E = " + (v[1]!! * constant * v[2]!! / v[3]!!).toString() + " = " + (v[1]!! * v[2]!! / v[3]!!).toString() + "G"
            }
            1 -> {         //mass pl
                return "M = " + (v[0]!! * v[3]!! / (v[2]!! * constant)).toString() + " = " + (v[0]!! * v[3]!! / (v[2]!!)).toString() + " / G"
            }
            2 -> {         //mass obj
                return "m = " + (v[0]!! * v[3]!! / (v[1]!! * constant)).toString() + " = " + (v[0]!! * v[3]!! / (v[1]!!)).toString() + " / G"
            }
            3 -> {         //distance
                return "d = " + (v[1]!! * constant * v[2]!! / v[0]!!).toString() + " = " + (v[1]!! * v[2]!! / v[0]!!).toString() + "G"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun lawOfPeriodsFunction(): String {
        when (nullIndex) {
            0 -> {
                return "T₁ = " + sqrt(v[1]!!.pow(3) * v[2]!!.pow(2) / v[3]!!.pow(3)).toString()
            }
            1 -> {
                return "R₁ = " + (v[3]!!.pow(3) * v[0]!!.pow(2) / v[2]!!.pow(2)).pow(1.0 / 3.0).toString()
            }
            2 -> {
                return "T₂ = " + sqrt(v[3]!!.pow(3) * v[0]!!.pow(2) / v[1]!!.pow(3)).toString()
            }
            3 -> {
                return "R₂ = " + (v[1]!!.pow(3) * v[2]!!.pow(2) / v[0]!!.pow(2)).pow(1.0 / 3.0).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun fringeSpacingFormulaDoubleSlitFunction(): String {
        when (nullIndex) {
            0 -> {      //spacing
                return "Δx = " + (v[1]!! * v[2]!! / (v[3]!! * v[4]!!)).toString()
            }
            1 -> {      //wavelenght
                return "λ = " + (v[0]!! * v[3]!! * v[4]!! / v[2]!!).toString()
            }
            2 -> {      //distance
                return "L = " + (v[0]!! * v[3]!! * v[4]!! / v[1]!!).toString()
            }
            3 -> {      //distance slits
                return "d = " + (v[1]!! * v[2]!! / (v[0]!! * v[4]!!)).toString()
            }
            4 -> {      //Refractive Index
                return "n = " + (v[1]!! * v[2]!! / (v[3]!! * v[0]!!)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun fringeSpacingFormulaSingleSlitFunction(): String {
        when (nullIndex) {
            0 -> {      //spacing
                return "Δx = " + (v[1]!! * v[2]!! / (v[3]!! * v[4]!!)).toString()
            }
            1 -> {      //wavelenght
                return "λ = " + (v[0]!! * v[3]!! * v[4]!! / v[2]!!).toString()
            }
            2 -> {      //distance
                return "L = " + (v[0]!! * v[3]!! * v[4]!! / v[1]!!).toString()
            }
            3 -> {      //width
                return "w = " + (v[1]!! * v[2]!! / (v[0]!! * v[4]!!)).toString()
            }
            4 -> {      //Refractive Index
                return "n = " + (v[1]!! * v[2]!! / (v[3]!! * v[0]!!)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun angularMomentumOfAnOrbitingElectronFunction(): String {
        when (nullIndex) {
            0 -> {      //ang mom
                return "L = " + (v[1]!! * constant).toString() + " = " + (v[1]!!).toString() + "ħ"
            }
            1 -> {      //level
                return "n = " + (v[0]!! / constant).toString() + " = " + (v[0]!!).toString() + " / ħ"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun orbitingRadiusOfAnElectronFunction(): String {
        when (nullIndex) {
            0 -> {      //radius
                return "r = " + (v[1]!!.pow(2) * constant / v[2]!!).toString() + " = " + (v[1]!!.pow(2) / v[2]!!).toString() + "a₀"
            }
            1 -> {      //level
                return "n = " + sqrt(v[0]!! * v[2]!! / constant).toString() + " = " + sqrt(v[0]!! * v[2]!!).toString() + " / √(a₀)"
            }
            2 -> {      //atomic number
                return "Z = " + (v[1]!!.pow(2) * constant / v[0]!!).toString() + " = " + (v[1]!!.pow(2) / v[0]!!).toString() + "a₀"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun energyOfElectronInBohrOrbitFunction(): String {
        when (nullIndex) {
            0 -> {      //energy
                return "E = " + (-13.6 * v[1]!!.pow(2) / v[2]!!.pow(2)).toString()
            }
            1 -> {      //atomic number
                return "Z = " + sqrt(v[0]!! * v[2]!!.pow(2) / -13.6).toString()
            }
            2 -> {      //level
                return "n = " + sqrt(-13.6 * v[1]!!.pow(2) / v[0]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun energyStoredInCapacitorFunction(): String {
        when (nullIndex) {
            0 -> {      //energy
                return "E = " + (v[1]!! * v[2]!! / 2).toString()
            }
            1 -> {      //charge
                return "q = " + (v[0]!! * 2 / v[2]!!).toString()
            }
            2 -> {      //voltage
                return "V = " + (v[0]!! * 2 / v[1]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun energyStoredInCapacitor2Function(): String {
        when (nullIndex) {
            0 -> {      //energy
                return "E = " + (v[1]!! * v[2]!!.pow(2) / 2).toString()
            }
            1 -> {      //capacitance
                return "C = " + (v[0]!! * 2 / v[2]!!.pow(2)).toString()
            }
            2 -> {      //voltage
                return "V = " + sqrt(v[0]!! * 2 / v[1]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun capacitanceOfCapacitorFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //capacitance
                return "C = " + (v[1]!! * v[2]!! / v[3]!!).toString()
            }
            1 -> {      //constant
                return "ε = " + (v[0]!! * v[3]!! / v[2]!!).toString()
            }
            2 -> {      //area
                return "A = " + (v[0]!! * v[3]!! / v[1]!!).toString()
            }
            3 -> {      //distance
                return "d = " + (v[1]!! * v[2]!! / v[0]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun torqueOfACurrentCarryingLoopInMagneticFieldFunction(): String {
        when (nullIndex) {
            0 -> {      //torque
                return "τ = " + (v[1]!! * v[2]!! * v[3]!! * v[4]!!).toString()
            }
            1 -> {      //turns
                return "N = " + (v[0]!! / (v[2]!! * v[3]!! * v[4]!!)).toString()
            }
            2 -> {      //magfield
                return "B = " + (v[0]!! / (v[1]!! * v[3]!! * v[4]!!)).toString()
            }
            3 -> {      //current
                return "I = " + (v[0]!! / (v[2]!! * v[1]!! * v[4]!!)).toString()
            }
            4 -> {      //area
                return "A = " + (v[0]!! / (v[2]!! * v[3]!! * v[1]!!)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun rootMeanSquareVoltageFormulaSinusoidalWaveformFunction(): String {
        when (nullIndex) {
            0 -> {      //rms
                return "V_rms = " + (v[1]!! / sqrt(2.0)).toString()
            }
            1 -> {      //peak
                return "V_peak = " + (v[0]!! * sqrt(2.0)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun rootMeanSquareVoltageFormulaTriangleWaveformFunction(): String {
        when (nullIndex) {
            0 -> {      //rms
                return "V_rms = " + (v[1]!! / sqrt(3.0)).toString()
            }
            1 -> {      //peak
                return "V_peak = " + (v[0]!! * sqrt(3.0)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun rootMeanSquareVoltageFormulaSquareWaveformFunction(): String {
        when (nullIndex) {
            0 -> {      //rms
                return "V_rms = " + (v[1]!!).toString()
            }
            1 -> {      //peak
                return "V_peak = " + (v[0]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun rootMeanSquareCurrentFormulaSinusoidalWaveformFunction(): String {
        when (nullIndex) {
            0 -> {      //rms
                return "I_rms = " + (v[1]!! / sqrt(2.0)).toString()
            }
            1 -> {      //peak
                return "I_peak = " + (v[0]!! * sqrt(2.0)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun rootMeanSquareCurrentFormulaTriangleWaveformFunction(): String {
        when (nullIndex) {
            0 -> {      //rms
                return "I_rms = " + (v[1]!! / sqrt(3.0)).toString()
            }
            1 -> {      //peak
                return "I_peak = " + (v[0]!! * sqrt(3.0)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun rootMeanSquareCurrentFormulaSquareWaveformFunction(): String {
        when (nullIndex) {
            0 -> {      //rms
                return "I_rms = " + (v[1]!!).toString()
            }
            1 -> {      //peak
                return "I_peak = " + (v[0]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun efficiencyFormulaFunction(): String {
        return "Efficiency = " + (v[0]!! / v[1]!! * 100).toString() + "%"
    }

    fun weightFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //weight
                return "G = " + (v[1]!! * v[2]!!).toString()
            }
            1 -> {      //mass
                return "m = " + (v[0]!! / v[2]!!).toString()
            }
            2 -> {      //gra acc
                return "g = " + (v[0]!! / v[1]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun frictionForceFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //f force
                return "F = " + (v[1]!! * v[2]!!).toString()
            }
            1 -> {      //co
                return "k = " + (v[0]!! / v[2]!!).toString()
            }
            2 -> {      //normal force
                return "N = " + (v[0]!! / v[1]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun velocityFormulaWithoutTimeFunction(): String {
        when (nullIndex) {
            0 -> {      //ffinal
                return "v = " + sqrt(v[1]!!.pow(2) + 2 * v[2]!! * v[3]!!).toString()
            }
            1 -> {      //init
                return "v₀ = " + sqrt(v[0]!!.pow(2) - 2 * v[2]!! * v[3]!!).toString()
            }
            2 -> {      //acc
                return "a = " + ((v[0]!!.pow(2) - v[1]!!.pow(2)) / (2 * v[3]!!)).toString()
            }
            3 -> {      //disp
                return "Δx = " + ((v[0]!!.pow(2) - v[1]!!.pow(2)) / (2 * v[2]!!)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun downwardProjectileMotionHeightFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //height
                return "h = " + (v[1]!! * v[2]!! + v[3]!! * v[2]!!.pow(2) / 2).toString()
            }
            1 -> {      //init
                return "v₀ = " + (v[0]!! / v[2]!! - v[3]!! * v[2]!! / 2).toString()
            }
            2 -> {      //time
                return "t = " + ((-v[1]!! + sqrt(v[1]!!.pow(2) + 2 * v[0]!! * v[3]!!)) / v[3]!!).toString()
            }
            3 -> {      //gra acc
                return "g = " + (2 * (v[0]!! - v[1]!! * v[2]!!) / v[2]!!.pow(2)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun upwardProjectileMotionHeightFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //height
                return "h = " + (v[1]!! * v[2]!! - v[3]!! * v[2]!!.pow(2) / 2).toString()
            }
            1 -> {      //init
                return "v₀ = " + (v[0]!! / v[2]!! + v[3]!! * v[2]!! / 2).toString()
            }
            2 -> {      //time
                return "t = " + ((-v[1]!! - sqrt(v[1]!!.pow(2) - 2 * v[0]!! * v[3]!!)) / -v[3]!!).toString()
            }
            3 -> {      //gra acc
                return "g = " + (-(2 * (v[0]!! - v[1]!! * v[2]!!) / v[2]!!.pow(2))).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun downwardProjectileMotionVelocityFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //velo
                return "v = " + (v[1]!! + v[3]!! * v[2]!!).toString()
            }
            1 -> {      //init
                return "v₀ = " + (v[0]!! - v[3]!! * v[2]!!).toString()
            }
            2 -> {      //time
                return "t = " + ((v[0]!! - v[1]!!) / v[3]!!).toString()
            }
            3 -> {      //gra acc
                return "g = " + ((v[0]!! - v[1]!!) / v[2]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun upwardProjectileMotionVelocityFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //velo
                return "v = " + (v[1]!! - v[3]!! * v[2]!!).toString()
            }
            1 -> {      //init
                return "v₀ = " + (v[0]!! + v[3]!! * v[2]!!).toString()
            }
            2 -> {      //time
                return "t = " + ((v[0]!! - v[1]!!) / -v[3]!!).toString()
            }
            3 -> {      //gra acc
                return "g = " + ((v[0]!! - v[1]!!) / -v[2]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun upwardProjectileMotionFlightTimeFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //time
                return "t = " + (2 * v[1]!! / v[2]!!).toString()
            }
            1 -> {      //init
                return "v₀ = " + (v[0]!! * v[2]!! / 2).toString()
            }
            2 -> {      //gra acc
                return "g = " + (2 * v[1]!! / v[0]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun upwardProjectileMotionMaximumHeightFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //height
                return "h_max = " + (v[1]!!.pow(2) / v[2]!! / 2).toString()
            }
            1 -> {      //init
                return "v₀ = " + sqrt(v[0]!! * v[2]!! * 2).toString()
            }
            2 -> {      //gra acc
                return "g = " + (v[1]!!.pow(2) / v[0]!! / 2).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun freeFallHeightFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //height
                return "h = " + (v[2]!!.pow(2) * v[1]!! / 2).toString()
            }
            1 -> {      //gra acc
                return "g = " + (v[0]!! * 2 / v[2]!!.pow(2)).toString()
            }
            2 -> {      //time
                return "t = " + sqrt(2 * v[0]!! / v[1]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun freeFallVerticalVelocityFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //height
                return "v = " + (v[2]!! * v[1]!!).toString()
            }
            1 -> {      //gra acc
                return "g = " + (v[0]!! / v[2]!!).toString()
            }
            2 -> {      //time
                return "t = " + (v[0]!! / v[1]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun freeFallVelocityFormulaWithoutTimeFunction(): String {
        when (nullIndex) {
            0 -> {      //height
                return "v = " + sqrt(2 * v[2]!! * v[1]!!).toString()
            }
            1 -> {      //gra acc
                return "g = " + (v[0]!!.pow(2) / v[2]!! / 2).toString()
            }
            2 -> {      //time
                return "t = " + (v[0]!!.pow(2) / v[1]!! / 2).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun impulseFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //impulse
                return "I = " + (v[2]!! * v[1]!!).toString()
            }
            1 -> {      //force
                return "F = " + (v[0]!! / v[2]!!).toString()
            }
            2 -> {      //change time
                return "Δt = " + (v[0]!! / v[1]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun momentumFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //momentum
                return "P = " + (v[2]!! * v[1]!!).toString()
            }
            1 -> {      //mass
                return "m = " + (v[0]!! / v[2]!!).toString()
            }
            2 -> {      //velo
                return "v = " + (v[0]!! / v[1]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun centralElasticCollisionVelocitiesEquationFunction(): String {
        when (nullIndex) {
            0 -> {      //i1
                return "v₁ = " + (v[2]!! + v[3]!! - v[1]!!).toString()
            }
            1 -> {      //f1
                return "v₁' = " + (v[2]!! + v[3]!! - v[0]!!).toString()
            }
            2 -> {      //i2
                return "v₂ = " + (v[1]!! + v[0]!! - v[3]!!).toString()
            }
            3 -> {      //f2
                return "v₂' = " + (v[1]!! + v[0]!! - v[2]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun screwEquationFunction(): String {
        when (nullIndex) {
            0 -> {      //force
                return "F = " + (v[2]!! * v[3]!! / (v[1]!! * 2 * constant)).toString()
            }
            1 -> {      //radius
                return "b = " + (v[2]!! * v[3]!! / (v[0]!! * 2 * constant)).toString()
            }
            2 -> {      //r force
                return "R = " + (v[0]!! * v[1]!! * 2 * constant / v[3]!!).toString()
            }
            3 -> {      //thread
                return "a = " + (v[0]!! * v[1]!! * 2 * constant / v[2]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun illuminanceFormula2Function(): String {
        when (nullIndex) {
            0 -> {      //Illu
                return "E = " + (v[1]!! / v[2]!!).toString()
            }
            1 -> {      //Flux
                return "ϕ = " + (v[0]!! * v[2]!!).toString()
            }
            2 -> {      //Area
                return "A = " + (v[1]!! / v[0]!!).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun numberOfImagesFormulaIntersectingMirrorsFunction(): String {
        when (nullIndex) {
            0 -> {      //number
                return "n = " + (360 / v[1]!! - 1).toString()
            }
            1 -> {      //angle
                return "α = " + (360 / (v[0]!! + 1)).toString()
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun absoluteRefractiveIndexFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //index
                return "n = " + (constant / v[1]!!).toString()
            }
            1 -> {      //speed
                return "v = " + (constant / v[0]!!).toString() + " m/s"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun buoyantForceFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //force
                return "F = " + (v[1]!! * v[2]!! * v[3]!!).toString()  + " N"
            }
            1 -> {      //volume
                return "V = " + (v[0]!! / (v[3]!! * v[2]!!)).toString() + " m³"
            }
            2 -> {      //density
                return "d = " + (v[0]!! / (v[1]!! * v[3]!!)).toString() + " kg/m³"
            }
            3 -> {      //gra acc
                return "g = " + (v[0]!! / (v[1]!! * v[2]!!)).toString() + " m/s²"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun electricEnergyFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //energy
                return "E = " + (v[1]!! * v[2]!!).toString()  + " J"
            }
            1 -> {      //charge
                return "q = " + (v[0]!! / (v[2]!!)).toString() + " C"
            }
            2 -> {      //voltage
                return "V = " + (v[0]!! / (v[1]!!)).toString() + " V"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun totalWorkDoneFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //Work
                return "W = " + (v[1]!! * v[2]!!).toString()  + " J"
            }
            1 -> {      //Power
                return "P = " + (v[0]!! / (v[2]!!)).toString() + " W"
            }
            2 -> {      //time
                return "t = " + (v[0]!! / (v[1]!!)).toString() + " s"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun fahrenheitCelsiusConverterFunction(): String {
        when (nullIndex) {
            0 -> {      //celsius
                return "T_c = " + ((v[1]!! - 32) / 1.8).toString()  + " °C"
            }
            1 -> {      //fahrenheit
                return "T_f = " + (v[0]!! * 1.8 + 32).toString() + " °F"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun heatConductionRateFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //rate
                return "ΔQ/Δt = " + (-v[1]!! * v[2]!! * v[3]!! / v[4]!!).toString()  + " J/s"
            }
            1 -> {      //thermal
                return "k = " + (-v[0]!! * v[4]!! / v[3]!! / v[2]!!).toString() + " W/m⋅K"
            }
            2 -> {      //surface a
                return "A = " + (-v[0]!! * v[4]!! / v[3]!! / v[1]!!).toString()  + " m²"
            }
            3 -> {      //change in time
                return "ΔT = " + (-v[0]!! * v[4]!! / v[1]!! / v[2]!!).toString() + " K"
            }
            4 -> {      //distance
                return "x = " + (-v[1]!! * v[2]!! * v[3]!! / v[0]!!).toString()  + " m"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun linearExpansionFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //expansion
                return "ΔL = " + (v[1]!! * v[2]!! * v[3]!!).toString()  + " m"
            }
            1 -> {      //inital len
                return "L₀ = " + (v[0]!! / (v[3]!! * v[2]!!)).toString() + " m"
            }
            2 -> {      //coo
                return "λ = " + (v[0]!! / (v[1]!! * v[3]!!)).toString() + " K⁻¹"
            }
            3 -> {      //change in temp
                return "ΔT = " + (v[0]!! / (v[1]!! * v[2]!!)).toString() + " K"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun superficialExpansionFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //expansion
                return "ΔA = " + (v[1]!! * v[2]!! * v[3]!!).toString()  + " m²"
            }
            1 -> {      //inital area
                return "A₀ = " + (v[0]!! / (v[3]!! * v[2]!!)).toString() + " m²"
            }
            2 -> {      //coo
                return "γ = " + (v[0]!! / (v[1]!! * v[3]!!)).toString() + " K⁻¹"
            }
            3 -> {      //change in temp
                return "ΔT = " + (v[0]!! / (v[1]!! * v[2]!!)).toString() + " K"
            }
            else -> {
                return "NaN"
            }
        }
    }

    fun volumetricExpansionFormulaFunction(): String {
        when (nullIndex) {
            0 -> {      //expansion
                return "ΔV = " + (v[1]!! * v[2]!! * v[3]!!).toString()  + " m³"
            }
            1 -> {      //inital vol
                return "V₀ = " + (v[0]!! / (v[3]!! * v[2]!!)).toString() + " m³"
            }
            2 -> {      //coo
                return "β = " + (v[0]!! / (v[1]!! * v[3]!!)).toString() + " K⁻¹"
            }
            3 -> {      //change in temp
                return "ΔT = " + (v[0]!! / (v[1]!! * v[2]!!)).toString() + " K"
            }
            else -> {
                return "NaN"
            }
        }
    }
}