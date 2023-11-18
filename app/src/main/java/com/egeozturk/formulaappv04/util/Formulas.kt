package com.egeozturk.formulaappv04.util

import com.egeozturk.formulaappv04.R
import com.egeozturk.formulaappv04.model.FormulaModel
import com.egeozturk.formulaappv04.util.Constants.avogadroConstant
import com.egeozturk.formulaappv04.util.Constants.bohrRadius
import com.egeozturk.formulaappv04.util.Constants.boltzmannConstant
import com.egeozturk.formulaappv04.util.Constants.constantForGravitationalAccelerationInsidePlanet
import com.egeozturk.formulaappv04.util.Constants.coulombConstant
import com.egeozturk.formulaappv04.util.Constants.diracConstant
import com.egeozturk.formulaappv04.util.Constants.faradayConstant
import com.egeozturk.formulaappv04.util.Constants.gasConstant
import com.egeozturk.formulaappv04.util.Constants.gasConstant100
import com.egeozturk.formulaappv04.util.Constants.gravitationalConstant
import com.egeozturk.formulaappv04.util.Constants.permeabilityOfFreeSpace
import com.egeozturk.formulaappv04.util.Constants.piNumber
import com.egeozturk.formulaappv04.util.Constants.speedOfLight

object Formulas {

    val math = R.string.maths
    val chem = R.string.chemistry
    val phy = R.string.physics

    //MATH

    val pythagoreanTheorem = FormulaModel(R.string.pythagorean_theorem, math, "a² + b² = c²", 1, listOf(
        R.string.side1,
        R.string.side2,
        R.string.hypotenuse
    ))
    val rectangleAreaFormula = FormulaModel(R.string.rectangle_area_formula, math, "a × b = A", 2, listOf(
        R.string.side1,
        R.string.side2,
        R.string.area
    ))
    val circumferenceOfCircle = FormulaModel(R.string.circumference_of_circle, math, "2 × π × r = C", 5, listOf(
        R.string.radius,
        R.string.circumference
    ), piNumber)
    val areaOfCircle = FormulaModel(R.string.area_of_circle, math, "π × r² = A", 6, listOf(
        R.string.radius,
        R.string.area
    ), piNumber)
    val surfaceAreaOfSphere = FormulaModel(R.string.surface_area_of_sphere, math, "4 × π × r² = A", 7, listOf(
        R.string.radius,
        R.string.surface_area
    ), piNumber)
    val volumeOfSphere = FormulaModel(R.string.volume_of_sphere, math, "π × r³ × 4 ÷ 3 = V", 8, listOf(
        R.string.radius,
        R.string.volume
    ), piNumber)
    val sumOfInteriorAnglesOfPolygons = FormulaModel(R.string.sum_of_interior_angles_of_polygons, math, "(n - 2) × 180 = S", 9, listOf(
        R.string.number_of_sides,
        R.string.sum_of_interior_angles
    ))
    val numberOfDiagonals = FormulaModel(R.string.number_of_diagonals, math, "n × (n - 3) ÷ 2 = ND", 10, listOf(
        R.string.number_of_sides,
        R.string.number_of_diagonals_result
    ))
    val rootsOfQuadraticEquation = FormulaModel(R.string.roots_of_quadratic_equation, math, "ax² + bx + c = 0" + "\n" + "x = (-b ± √(b² - 4ac)) ÷ 2a", 11, listOf(
        R.string.first_coefficient,
        R.string.second_coefficient,
        R.string.third_coefficient
    ), requiresNull = false)
    val volumeOfRectangularPrism = FormulaModel(R.string.volume_of_rectangular_prism, math, "l × w × h = V", 12, listOf(
        R.string.length,
        R.string.width,
        R.string.height,
        R.string.volume
    ))
    val volumeOfCylinder = FormulaModel(R.string.volume_of_cylinder, math, "π × r² × h = V", 13, listOf(
        R.string.radius,
        R.string.height,
        R.string.volume
    ), piNumber)
    val areaOfTriangle = FormulaModel(R.string.area_of_triangle, math, "b × h ÷ 2 = A", 14, listOf(
        R.string.base,
        R.string.height,
        R.string.area
    ))
    val heronsFormula = FormulaModel(R.string.herons_formula, math, "s = (a + b + c) ÷ 2" + "\n" + "A = √(s(s - a)(s - b)(s - c))",15, listOf(
        R.string.side1,
        R.string.side2,
        R.string.side3
    ), requiresNull = false)
    val permutation = FormulaModel(R.string.permutation, math, "P(n,r) = n! ÷ (n - r)!" + "\n" + "r ≤ n", 20, listOf(
        R.string.n,
        R.string.r
    ), requiresNull = false)
    val combination = FormulaModel(R.string.combination, math, "C(n,r) = n! ÷ ((n -r)! × r!)" + "\n" + "r ≤ n", 21, listOf(
        R.string.n,
        R.string.r
    ), requiresNull = false)
    val volumeOfPyramid = FormulaModel(R.string.volume_of_pyramid, math, "A × h ÷ 3 = V", 24, listOf(
        R.string.base_area,
        R.string.height,
        R.string.volume
    ))
    val volumeOfCone = FormulaModel(R.string.volume_of_cone, math, "π × r² × h ÷ 3 = V", 25, listOf(
        R.string.radius,
        R.string.height,
        R.string.volume
    ), piNumber)
    val surfaceAreaOfCone = FormulaModel(R.string.surface_area_of_cone, math, "π × r × (r + L) = A", 26, listOf(
        R.string.radius,
        R.string.slant_height_of_the_cone,
        R.string.surface_area
    ), piNumber)
    val surfaceAreaOfRectangularPrism = FormulaModel(R.string.surface_area_of_rectangular_prism, math, "2 × (ab + ac + bc) = A", 27, listOf(
        R.string.side1,
        R.string.side2,
        R.string.side3,
        R.string.surface_area
    ))
    val lawOfCosines = FormulaModel(R.string.law_of_cosines, math, "a² = b² + c² - 2bc × cosα", 28, listOf(
        R.string.side2,
        R.string.side3,
        R.string.angle_between_b_and_c
    ), requiresNull = false)
    val lawOfSines = FormulaModel(R.string.law_of_sines, math, "sinα ÷ a = sinβ ÷ b", 29, listOf(
        R.string.angle1,
        R.string.side1,
        R.string.angle2,
        R.string.side2,
    ))
    val doubleAngleSinSame = FormulaModel(R.string.double_angle_formula_for_sine, math, "sin(2α) =" + "\n" + "2 × sinα × cosα", 30 , listOf(
            R.string.angle1
    ), requiresNull = false)
    val doubleAngleSinDifferent = FormulaModel(R.string.sum_formula_for_sine, math, "sin(α + β) =" + "\n" + "sinα × cosβ + sinβ × cosα", 31 , listOf(
        R.string.angle1,
        R.string.angle2
    ), requiresNull = false)
    val doubleAngleCosSame = FormulaModel(R.string.double_angle_formula_for_cosine, math, "cos(2α) =" + "\n" + "2 × cos²α - 1 =" + "\n" + "1 - 2 × sin²α =" + "\n" + "cos²α - sin²α", 32 , listOf(
        R.string.angle1
    ), requiresNull = false)
    val doubleAngleCosDifferent = FormulaModel(R.string.sum_formula_for_cosine, math, "cos(α + β) =" + "\n" + "cosα × cosβ - sinα × sinβ", 33 , listOf(
        R.string.angle1,
        R.string.angle2
    ), requiresNull = false)
    val doubleAngleTanSame = FormulaModel(R.string.double_angle_formula_for_tangent, math, "tan(2α) =" + "\n" + "2 × tanα ÷ (1 - tan²α)", 34 , listOf(
        R.string.angle1
    ), requiresNull = false)
    val doubleAngleTanDifferent = FormulaModel(R.string.sum_formula_for_tangent, math, "tan(α + β) =" + "\n" + "(tanα + tanβ) ÷ (1 - tanα × tanβ)", 35 , listOf(
        R.string.angle1,
        R.string.angle2
    ), requiresNull = false)
    val areaOfHexagon = FormulaModel(R.string.area_of_regular_hexagon, math, "A = 3√3 × a² ÷ 2", 36, listOf(
        R.string.area,
        R.string.side1
    ))
    val numberOfSubsetsFormula = FormulaModel(R.string.number_of_subsets_formula, math, "NS = 2ⁿ", 200, listOf(
        R.string.number_of_subsets,
        R.string.number_of_elements
    ))
    val numberOfProperSubsetsFormula = FormulaModel(R.string.number_of_proper_subsets_formula, math, "NS = 2ⁿ - 1", 201, listOf(
        R.string.number_of_subsets,
        R.string.number_of_elements
    ))
    val primeFactorFinder = FormulaModel(R.string.prime_factor_finder, math, " ", 202, listOf(
        R.string.number
    ), requiresNull = false)
    val primeNumberChecker = FormulaModel(R.string.prime_number_checker, math, " ", 203, listOf(
        R.string.number
    ), requiresNull = false)
    val positiveIntegerDivisorFinder = FormulaModel(R.string.positive_integer_divisor_finder, math, " ", 204, listOf(
        R.string.number
    ), requiresNull = false)
    val greatestCommonDivisor = FormulaModel(R.string.greatest_common_divisor, math, "GCD(a, b)", 205, listOf(
        R.string.number1,
        R.string.number2
    ), requiresNull = false)
    val leastCommonMultiple = FormulaModel(R.string.least_common_multiple, math, "LCM(a, b)", 206, listOf(
        R.string.number1,
        R.string.number2
    ), requiresNull = false)
    val rootCalculator = FormulaModel(R.string.root_calculator, math, "y = ⁱ√(xⁿ)", 207, listOf(
        R.string.root,
        R.string.radicand,
        R.string.exponent,
        R.string.index
    ))
    val triangleInequalityCalculator = FormulaModel(R.string.triangle_inequality_calculator, math, "|b − c| < a < b + c\n|a − c| < b < a + c\n|a − b| < c < a + b", 208, listOf(
        R.string.side1,
        R.string.side2,
        R.string.side3
    ), requiresNull = false)
    val areaOfEquilateralTriangle = FormulaModel(R.string.area_of_equilateral_triangle_formula, math, "A = a² × √(3) ÷ 4", 209, listOf(
        R.string.area,
        R.string.side1
    ))
    val factorialFormula = FormulaModel(R.string.factorial_formula, math, "n! =\n1 × 2 × 3 × ... × (n - 1) × n", 210, listOf(
        R.string.n_number
    ), requiresNull = false)
    val cyclicPermutationFormula = FormulaModel(R.string.cyclic_permutation_formula, math, "f = (n - 1)!", 211, listOf(
        R.string.number_of_elements
    ), requiresNull = false)
    val sumOfCoefficientsOfEvenDegreeTermsInPolynomial = FormulaModel(R.string.sum_of_coefficients_of_even_degree_terms_in_polynomial, math, "P(1) + P(-1) ÷ 2", 212, listOf(), noFormula = true)
    val sumOfCoefficientsOfOddDegreeTermsInPolynomial = FormulaModel(R.string.sum_of_coefficients_of_odd_degree_terms_in_polynomial, math, "P(1) - P(-1) ÷ 2", 213, listOf(), noFormula = true)
    val squaredBinomialExpansion = FormulaModel(R.string.second_degree_binomial_expansion, math, "(x + y)² = x² + 2xy + y²", 214, listOf(
        R.string.x,
        R.string.y
    ), requiresNull = false)
    val cubedBinomialExpansion = FormulaModel(R.string.third_degree_binomial_expansion, math, "(x + y)³ =\nx³ + 3x²y + 3xy² + y³", 215, listOf(
        R.string.x,
        R.string.y
    ), requiresNull = false)
    val squaredTrinomialExpansion = FormulaModel(R.string.second_degree_trinomial_expansion, math, "(x + y + z)² =\nx² + y² + z² + 2(xy + xz + yz)", 216, listOf(
        R.string.x,
        R.string.y,
        R.string.z
    ), requiresNull = false)
    val factoringDifferenceOfTwoSquares = FormulaModel(R.string.factorisation_of_difference_of_two_squares, math, "x² - y² = (x + y)(x - y)", 217, listOf(
        R.string.x,
        R.string.y
    ), requiresNull = false)
    val factoringDifferenceOfTwoCubes = FormulaModel(R.string.factorisation_of_difference_of_two_cubes, math, "x³ - y³ =\n(x - y)(x² + xy + y²)", 218, listOf(
        R.string.x,
        R.string.y
    ), requiresNull = false)
    val factoringSumOfTwoCubes = FormulaModel(R.string.factorisation_of_sum_of_two_cubes, math, "x³ + y³ =\n(x + y)(x² - xy + y²)", 219, listOf(
        R.string.x,
        R.string.y
    ), requiresNull = false)
    val factoringSumOfXnYn = FormulaModel(R.string.factorisation_of_sum_of_xn_and_yn, math, "xⁿ + yⁿ =\n(x + y)(xⁿ⁻¹y⁰ - xⁿ⁻²y¹ + ... + x⁰yⁿ⁻¹)", 220 , listOf(
        R.string.x,
        R.string.y,
        R.string.n
    ), requiresNull = false)
    val factoringDifferenceOfXnYn = FormulaModel(R.string.factorisation_of_difference_of_xn_and_yn, math, "xⁿ - yⁿ =\n(x - y)(xⁿ⁻¹y⁰ + xⁿ⁻²y¹ + ... + x⁰yⁿ⁻¹)", 221 , listOf(
        R.string.x,
        R.string.y,
        R.string.n
    ), requiresNull = false)
    val binomialExpansions = FormulaModel(R.string.binomial_expansions, math, "(x + y)ⁿ =\nC(n,0) × xⁿy⁰ + C(n,1) × xⁿ⁻¹y¹ + ... + C(n,n) × x⁰yⁿ", 222 , listOf(
        R.string.x,
        R.string.y,
        R.string.n
    ), requiresNull = false)
    val anInteriorAngleOfRegularPolygonFormula = FormulaModel(R.string.interior_angle_of_regular_polygon, math, "A = (n - 2) × 180° ÷ n", 223, listOf(
        R.string.interior_angle,
        R.string.number_of_sides
    ))
    val anExteriorAngleOfRegularPolygonFormula = FormulaModel(R.string.exterior_angle_of_regular_polygon, math, "A = 360° ÷ n", 224, listOf(
        R.string.exterior_angle,
        R.string.number_of_sides
    ))
    val areaOfRegularPolygon = FormulaModel(R.string.area_of_regular_polygon, math, "A = n × L × r ÷ 2", 225, listOf(
        R.string.area,
        R.string.number_of_sides,
        R.string.length_of_one_side,
        R.string.radius_of_inscribed_circle
    ))
    val areaOfTrapezoidFormula = FormulaModel(R.string.area_of_trapezoid_formula, math, "A = (a + b) × h ÷ 2", 226, listOf(
        R.string.area,
        R.string.base1,
        R.string.base2,
        R.string.height
    ))
    val areaOfParallelogramFormula = FormulaModel(R.string.area_of_parallelogram_formula, math, "A = a × h", 227, listOf(
        R.string.area,
        R.string.side,
        R.string.height
    ))
    val areaOfSquareFormula = FormulaModel(R.string.area_of_square_formula, math, "A = a²", 228, listOf(
        R.string.area,
        R.string.side
    ))
    val lengthOfSpaceDiagonalInRectangularPrismFormula = FormulaModel(R.string.length_of_space_diagonal_in_rectangular_prism_formula, math, "l = √(a² + b² + c²)", 229, listOf(
        R.string.length,
        R.string.side1,
        R.string.side2,
        R.string.side3
    ))
    val volumeOfCubeFormula = FormulaModel(R.string.volume_of_cube_formula, math, "V = a³", 230, listOf(
        R.string.volume,
        R.string.side
    ))
    val surfaceAreaOfCubeFormula = FormulaModel(R.string.surface_area_of_cube_formula, math, "A = 6a²" , 231, listOf(
        R.string.surface_area,
        R.string.side
    ))
    val surfaceAreaOfCylinder = FormulaModel(R.string.surface_area_of_cylinder_formula, math, "A = 2πr² + 2πrh", 232, listOf(
        R.string.surface_area,
        R.string.radius,
        R.string.height
    ), constant = piNumber)
    val heightOfRegularTetrahedronFormula = FormulaModel(R.string.height_of_regular_tetrahedron_formula, math, "h = a√(6) ÷ 3", 233, listOf(
        R.string.height,
        R.string.side
    ))
    val surfaceAreaOfRegularTetrahedronFormula = FormulaModel(R.string.surface_area_of_regular_tetrahedron_formula, math, "A = a² × √(3)", 234, listOf(
        R.string.area,
        R.string.side
    ))
    val volumeOfRegularTetrahedronFormula = FormulaModel(R.string.volume_of_regular_tetrahedron_formula, math, "V = a³ × √(2) ÷ 12", 235, listOf(
        R.string.area,
        R.string.side
    ))
    val radianDegreeConverter = FormulaModel(R.string.radian_degree_converter, math, "D ÷ 360° = R ÷ 2π", 236, listOf(
        R.string.degree_value,
        R.string.radian_value
    ), piNumber)
    val principalAngleFinder = FormulaModel(R.string.principal_angle_finder, math, "θ - 360°n = α", 237, listOf(
        R.string.angle
    ), requiresNull = false)
    val distanceBetweenTwoPointsOnTheAnalyticalPlaneFormula = FormulaModel(R.string.distance_between_two_points_on_the_analytical_plane_formula, math, "d = √((x₂ - x₁)² + (y₂ - y₁)²)",238, listOf(
        R.string.distance,
        R.string.x_coordinate2,
        R.string.x_coordinate1,
        R.string.y_coordinate2,
        R.string.y_coordinate1
    ))
    val coordinatesOfTheMidpointOfALineSegmentFormula = FormulaModel(R.string.coordinates_of_the_midpoint_of_a_line_segment_formula, math, "C(x₀,y₀) =\nC((x₁ + x₂) ÷ 2, (y₁ + y₂) ÷ 2)", 239, listOf(
        R.string.x_coordinate1,
        R.string.x_coordinate2,             //bunu ve altindakini tum degerleri olcebilecek gibi yap
        R.string.y_coordinate1,
        R.string.y_coordinate2
    ), requiresNull = false)
    val coordinatesOfTheCentroidOfATriangleFormula = FormulaModel(R.string.coordinates_of_the_centroid_of_a_triangle_formula, math, "G(x₀,y₀) =\nG((x₁ + x₂ + x₃) ÷ 3, (y₁ + y₂ + y₃) ÷ 3)", 240, listOf(
        R.string.x_coordinate1,
        R.string.x_coordinate2,
        R.string.x_coordinate3,
        R.string.y_coordinate1,
        R.string.y_coordinate2,
        R.string.y_coordinate3
    ), requiresNull = false)
    val averageRateOfChangeFormula = FormulaModel(R.string.average_rate_of_change_formula, math, "m = (f(b) - f(a)) ÷ (b - a)", 241, listOf(
        R.string.average_rate_of_change,
        R.string.function_result1,
        R.string.function_result2,
        R.string.b,
        R.string.a
    ))
    val exponentialFunctionFormula = FormulaModel(R.string.exponential_function_formula, math, "f(n) = aⁿ", 242, listOf(
        R.string.fn,
        R.string.a,
        R.string.n
    ))
    val logarithmFormula = FormulaModel(R.string.logarithm_formula, math, "y = logₐx", 243, listOf(
        R.string.y,
        R.string.a,
        R.string.x
    ))
    val naturalLogarithmFormula = FormulaModel(R.string.natural_logarithm_formula, math, "y = ln(x)", 244, listOf(
        R.string.y,
        R.string.x
    ))
    val nthTermOfAnArithmeticSequenceFormula = FormulaModel(R.string.nth_term_of_an_arithmetic_sequence_formula, math, "a_n = a₁ + d(n - 1)", 245, listOf(
        R.string.nth_term,
        R.string.first_term,
        R.string.index_of_last_term,
        R.string.common_difference
    ))
    val sumOfTheMembersOfAnArithmeticSequenceFormula = FormulaModel(R.string.sum_of_the_members_of_an_arithmetic_sequence_formula, math, "S_n = n(a₁ + a_n) ÷ 2", 246, listOf(
        R.string.sum_of_sequence_members,
        R.string.index_of_last_term,
        R.string.first_term,
        R.string.nth_term
    ))
    val nthTermOfAGeometricSequenceFormula = FormulaModel(R.string.nth_term_of_a_geometric_sequence_formula, math, "a_n = a₁ × rⁿ⁻¹", 247, listOf(
        R.string.nth_term,
        R.string.first_term,
        R.string.common_ratio,
        R.string.index_of_last_term
    ))
    val sumOfTheMembersOfAGeometricSequenceFormula = FormulaModel(R.string.sum_of_the_members_of_a_geometric_sequence_formula, math, "S_n = a₁ × (1 - rⁿ) ÷ (1 - r)", 248, listOf(
        R.string.sum_of_sequence_members,
        R.string.first_term,
        R.string.common_ratio,
        R.string.index_of_last_term,
    ))
    val productOfTheMembersOfAGeometricSequenceFormula = FormulaModel(R.string.product_of_the_members_of_a_geometric_sequence_formula, math, "P_n = a₁ⁿ × √(rⁿ⁽ⁿ⁻¹⁾)", 249, listOf(
        R.string.product_of_sequence_members,
        R.string.first_term,
        R.string.common_ratio,
        R.string.index_of_last_term,
    ))
    val fibonacciSequenceStartingFrom1TermFinder = FormulaModel(R.string.fibonacci_sequence_starting_from_1_term_finder, math, "F₁ = 1", 250, listOf(
        R.string.wanted_term
    ), requiresNull = false)
    val nthPowerOfiCalculator = FormulaModel(R.string.nth_power_of_i_calculator, math, "i² = -1; i³ = -i; i⁴ = 1\niⁿ = ?", 251, listOf(
        R.string.n
    ), requiresNull = false)
    val rotationOfAPointAroundOriginFormula = FormulaModel(R.string.rotation_of_a_point_around_origin_formula, math, "A'(x × cos(α) – y × sin(α),\nx × sin(α) + y × cos(α))", 252, listOf(
        R.string.x,
        R.string.y,
        R.string.rotation_angle
    ), requiresNull = false)        //title overflows in smaller screens
    val reflectionAcrossXAxisFormula = FormulaModel(R.string.reflection_across_x_axis_formula, math, "A(x,y) => A'(x',y') = (x,-y)", 253, listOf(
        R.string.x,
        R.string.y
    ), requiresNull = false)
    val reflectionAcrossYAxisFormula = FormulaModel(R.string.reflection_across_y_axis_formula, math, "A(x,y) => A'(x',y') = (-x,y)", 254, listOf(
        R.string.x,
        R.string.y
    ), requiresNull = false)
    val reflectionAcrossYXFormula = FormulaModel(R.string.reflection_across_yx_formula, math, "A(x,y) => A'(x',y') = (y,x)", 255, listOf(
        R.string.x,
        R.string.y
    ), requiresNull = false)
    val reflectionAcrossYminusXFormula = FormulaModel(R.string.reflection_across_y_minusx_formula, math, "A(x,y) => A'(x',y') = (-y,-x)", 256, listOf(
        R.string.x,
        R.string.y
    ), requiresNull = false)
    val reflectionAcrossXAFormula = FormulaModel(R.string.reflection_across_xa_formula, math, "A(x,y) =>\nA'(x',y') = (2a - x, y)", 257, listOf(
        R.string.x,
        R.string.y,
        R.string.a
    ), requiresNull = false)
    val reflectionAcrossYAFormula = FormulaModel(R.string.reflection_across_ya_formula, math, "A(x,y) =>\nA'(x',y') = (x, 2a - y)", 258, listOf(
        R.string.x,
        R.string.y,
        R.string.a
    ), requiresNull = false)
    val reflectionOverOriginFormula = FormulaModel(R.string.reflection_over_origin_formula, math, "A(x,y) => A'(x',y') = (-x,-y)", 259, listOf(
        R.string.x,
        R.string.y
    ), requiresNull = false)
    val reflectionOfALineAcrossXAxisFormula = FormulaModel(R.string.reflection_of_a_line_across_x_axis_formula, math, "L = (ax + by + c = 0) =>\nL' = (ax - by + c = 0)", 260 , listOf(
        R.string.a,
        R.string.b,
        R.string.c
    ), requiresNull = false)
    val reflectionOfALineAcrossYAxisFormula = FormulaModel(R.string.reflection_of_a_line_across_y_axis_formula, math, "L = (ax + by + c = 0) =>\nL' = (-ax + by + c = 0)", 261 , listOf(
        R.string.a,
        R.string.b,
        R.string.c
    ), requiresNull = false)
    val reflectionOfALineAcrossYXFormula = FormulaModel(R.string.reflection_of_a_line_across_yx_formula, math, "L = (ax + by + c = 0) =>\nL' = (ax + by + c = 0)", 262 , listOf(
        R.string.a,
        R.string.b,
        R.string.c
    ), requiresNull = false)
    val reflectionOfALineAcrossYminusXFormula = FormulaModel(R.string.reflection_of_a_line_across_y_minusx_formula, math, "L = (ax + by + c = 0) =>\nL' = (-ax + -by + c = 0)", 263 , listOf(
        R.string.a,
        R.string.b,
        R.string.c
    ), requiresNull = false)
    val reflectionOfALineAcrossXDFormula = FormulaModel(R.string.reflection_of_a_line_across_xd_formula, math, "L = (ax + by + c = 0) =>\nL' = (a(2d - x) + by + c = 0)", 264 , listOf(
        R.string.a,
        R.string.b,
        R.string.c,
        R.string.d
    ), requiresNull = false)
    val reflectionOfALineAcrossYEFormula = FormulaModel(R.string.reflection_of_a_line_across_ye_formula, math, "L = (ax + by + c = 0) =>\nL' = (ax + b(2e - y) + c = 0)", 265 , listOf(
        R.string.a,
        R.string.b,
        R.string.c,
        R.string.e
    ), requiresNull = false)
    val reflectionOfALineOverOriginFormula = FormulaModel(R.string.reflection_of_a_line_over_origin_formula, math, "L = (ax + by + c = 0) =>\nL' = (-ax + -by + c = 0)", 266 , listOf(
        R.string.a,
        R.string.b,
        R.string.c
    ), requiresNull = false)


    //fark formulleri de eklenebilir
    // hacim
    // cevre
    // ic acilar toplami
    // kosegen sayisi
    // turev integral
    // dizi formulleri
    // logaritma ?
    // polinom formulleri
    // fonksiyon oteleme vs.
    // parabol
    // esitsizlik
    // olasilik ve kosullu olasilik
    // limit
    // alt kume sayisi
    // mod
    // 2. dereceden denklemlerin kokunu bulma
    // ucgenin ve dairenin alani
    // FARKLI YONTEM standart sapmayi hesaplamak icin formulu goster ama dizinin elemanlirinin tumunu str olarak iste sonra hesapla
    // ortalama, mod, en ortadaki sayi
    // ceyrekler???
    // permutasyon kombinasyon
    // BELKI polinom bolmesi ve carpanlara ayirma
    // kati cisimlerin alan formulleri
    // nokta ve dogrunun otelenmesi, dondurulmesi, vs. (cis de ekle)
    // cemberin alani ama farkli fomuller ile (dortgen cizilen, heron)
    // toplam fark formulleri, diger trigonometri formulleri
    // cember analitigi (yaricap, acik formul, alan, ...)
    // log ve ustel grafikleri
    // bazi log ozellikleri
    // dizi kismi toplam (dizi kurali gerekli)





    //CHEMISTRY
    val idealGasLaw = FormulaModel(R.string.ideal_gas_law, chem, "P × V = n × R × T", 3, listOf(
        R.string.pressure,
        R.string.volume,
        R.string.number_of_moles,
        //"Ideal Gaz Sabiti", //sabitleri de tanimla
        R.string.temperature

    ), gasConstant)
    val kineticEnergyOfGas = FormulaModel(R.string.kinetic_energy_of_gas, chem, "E = k × T × 3 ÷ 2", 22, listOf(
        R.string.kinetic_energy,
        R.string.absolute_tempetarute
    ), boltzmannConstant)
    val velocityOfGasParticles = FormulaModel(R.string.velocity_of_gas_particles, chem, "v = √(3 × R × T ÷ M)", 23, listOf(
        R.string.velocity,
        R.string.absolute_tempetarute,
        R.string.mass_of_a_mole_of_the_gas
    ), gasConstant100)
    var idealGasLaw2 = FormulaModel(R.string.ideal_gas_law2, chem, "P × Mₐ = d × R × T", 161, listOf(
        R.string.pressure,
        R.string.molar_mass,
        R.string.density,
        R.string.temperature
    ), gasConstant)
    var boylesLaw = FormulaModel(R.string.boyles_law, chem, "P₁ × V₁ = P₂ × V₂", 170 , listOf(
        R.string.pressure1,
        R.string.volume1,
        R.string.pressure2,
        R.string.volume2
    ))
    var charlessLaw = FormulaModel(R.string.charless_law, chem, "V₁ ÷ T₁ = V₂ ÷ T₂", 171, listOf(
        R.string.volume1,
        R.string.temperature1,
        R.string.volume2,
        R.string.temperature2
    ))
    var gayLussacsLaw = FormulaModel(R.string.gay_lussacs_law, chem, "P₁ ÷ T₁ = P₂ ÷ T₂", 172, listOf(
        R.string.pressure1,
        R.string.temperature1,
        R.string.pressure2,
        R.string.temperature2
    ))
    var avogadrosLaw = FormulaModel(R.string.avogadros_law, chem, "V₁ ÷ n₁ = V₂ ÷ n₂", 173, listOf(
        R.string.volume1,
        R.string.number_of_moles1,
        R.string.volume2,
        R.string.number_of_moles2
    ))
    var numberOfMolesFormula = FormulaModel(R.string.number_of_moles_formula, chem, "n = N ÷ Nₐ", 174, listOf(
        R.string.number_of_moles,
        R.string.number_of_particles
    ), avogadroConstant)
    var numberOfMolesFormula2 = FormulaModel(R.string.number_of_moles_formula2, chem, "n = m ÷ Mₐ", 175, listOf(
        R.string.number_of_moles,
        R.string.mass,
        R.string.molar_mass
    ))
    var atomicMassFormula = FormulaModel(R.string.atomic_mass_formula, chem, "M = Mₐ ÷ Nₐ", 176, listOf(
        R.string.atomic_mass,
        R.string.molar_mass
    ), avogadroConstant)
    var numberOfMolesFormulaForGasesUnderNormalConditions = FormulaModel(R.string.number_of_moles_formula_for_gases_under_normal_conditions, chem, "n = V ÷ 22.4", 177, listOf(
        R.string.number_of_moles,
        R.string.volume
    ))
    var massPercentCompositionFormula = FormulaModel(R.string.mass_percent_composition_formula, chem, "MPC = (m ÷ M) × 100%", 178, listOf(
        R.string.mass_percent_composition,
        R.string.solute_mass,
        R.string.total_mixture_mass
    ))
    var volumePercentCompositionFormula = FormulaModel(R.string.volume_percent_composition_formula, chem, "VPC =\n(V ÷ V_total) × 100%", 179, listOf(
        R.string.volume_percent_composition,
        R.string.solute_volume,
        R.string.total_mixture_volume
    ))
    var ppmFormula = FormulaModel(R.string.ppm_formula, chem, "ppm = (m ÷ M) × 10⁶", 180, listOf(
        R.string.ppm,
        R.string.solute_mass,
        R.string.total_mixture_mass
    ))
    var ppbFormula = FormulaModel(R.string.ppb_formula, chem, "ppb = (m ÷ M) × 10⁹", 181, listOf(
        R.string.ppb,
        R.string.solute_mass,
        R.string.total_mixture_mass
    ))
    var averageKineticEnergyFormulaOfGasMolecules = FormulaModel(R.string.average_kinetic_energy_formula_of_gas_molecules, chem, "E = (3 / 2) × k × T", 182, listOf(
        R.string.kinetic_energy,
        R.string.temperature
    ),boltzmannConstant)
    var grahamsLawOfDiffusion = FormulaModel(R.string.grahams_law_of_diffusion, chem, "v₁ ÷ v₂ = √(Mₐ₂ ÷ Mₐ₁)", 183, listOf(
        R.string.diffusion_rate1,
        R.string.diffusion_rate2,
        R.string.molar_mass2,
        R.string.molar_mass1
    ))
    var averageVelocityOfGasMoleculesFormula = FormulaModel(R.string.average_velocity_of_gas_molecules_formula, chem, "v = √(3k × T ÷ Mₐ)", 184, listOf(
        R.string.average_velocity,
        R.string.temperature,
        R.string.molar_mass
    ), boltzmannConstant)
    var diffusionRateEquation = FormulaModel(R.string.diffusion_rate_equation, chem, "v₁ ÷ v₂ =\n√(T₁ × Mₐ₂ ÷ (T₂ × Mₐ₁))", 185, listOf(
        R.string.diffusion_rate1,
        R.string.diffusion_rate2,
        R.string.temperaturex,
        R.string.temperaturey,
        R.string.molar_mass2,
        R.string.molar_mass1
    ))
    var partialPressureFormula = FormulaModel(R.string.partial_pressure_formula, chem, "Pᵢ =\nP_total × nᵢ ÷ n_total", 186, listOf(
        R.string.partial_pressure,
        R.string.total_pressure,
        R.string.mole_number_of_wanted_gas,
        R.string.total_mole_number
    ))
    var molarityFormula = FormulaModel(R.string.molarity_formula, chem, "M = n ÷ V", 187, listOf(
        R.string.molarity,
        R.string.mole_number_of_solute,
        R.string.volume_of_solvent
    ))
    var molalityFormula = FormulaModel(R.string.molality_formula, chem, "m = n ÷ M", 188, listOf(
        R.string.molality,
        R.string.mole_number_of_solute,
        R.string.mass_of_solvent
    ))
    var changeOfConcentrationEquation = FormulaModel(R.string.change_of_concentration_equation, chem, "M₁ × V₁ = M₂ × V₂", 189, listOf(
        R.string.molarity1,
        R.string.volume1,
        R.string.molarity2,
        R.string.volume2
    ))
    var molarityFormula2 = FormulaModel(R.string.molarity_formula2, chem, "M =\nd × MPC × 10 ÷ Mₐ", 190, listOf(
        R.string.molarity,
        R.string.density,
        R.string.mass_percent_composition,
        R.string.molar_mass_of_solute
    ))
    var boilingPointElevationFormula = FormulaModel(R.string.boiling_point_elevation_formula, chem, "ΔT = K_b × m × i", 191, listOf(
        R.string.boiling_point_elevation,
        R.string.ebullioscopic_constant,
        R.string.molality,
        R.string.number_of_particles_ions
    ))
    var freezingPointDepressionFormula = FormulaModel(R.string.freezing_point_depression_formula, chem, "ΔT = K_f × m × i", 192, listOf(
        R.string.freezing_point_depression,
        R.string.cryoscopic_constant,
        R.string.molality,
        R.string.number_of_particles_ions
    ))
    var enthalpyFormula = FormulaModel(R.string.enthalpy_formula, chem, "ΔH° =\n∑ΔH°(p) - ∑ΔH°(r)", 193, listOf(
        R.string.enthalpy,
        R.string.sum_of_standard_formation_enthalpies_product,
        R.string.sum_of_standard_formation_enthalpies_reactants
    ))
    var enthalpyFormula2 = FormulaModel(R.string.enthalpy_formula2, chem, "ΔH° =\n∑ΔH°(bb) - ∑ΔH°(bf)", 194, listOf(
        R.string.enthalpy,
        R.string.energies_of_bonds_broken,
        R.string.energies_of_bonds_formed
    ))
    var reactionRateFormula = FormulaModel(R.string.reaction_rate_formula, chem, "v = Δm ÷ Δt", 195, listOf(
        R.string.reaction_rate,
        R.string.change_in_mass,
        R.string.change_in_time
    ))
    var reactionRateFormula2 = FormulaModel(R.string.reaction_rate_formula2, chem, "v = ΔP ÷ Δt", 196, listOf(
        R.string.reaction_rate,
        R.string.change_in_partial_pressure,
        R.string.change_in_time
    ))
    var relationshipBetweenEquilibriumConstants = FormulaModel(R.string.relationship_between_equilibrium_constants, chem, "K_p =\nK_c × (R × T) ^ (∆n)", 197, listOf(
        R.string.equilibrium_constant_for_partial_pressure,
        R.string.equilibrium_constant_for_concentration,
        R.string.temperature,
        R.string.difference_in_mole_number_of_gaseous_products_and_reactants
    ), gasConstant)
    var nernstEquation = FormulaModel(R.string.nernst_equation, chem, "E =\nE⁰ - (0.0592 ÷ n) × log(Q)", 198, listOf(
        R.string.cell_potential,
        R.string.standard_cell_potential,
        R.string.number_of_moles,
        R.string.equilibrium_constantq
    ))
    var massOfProducedSubstanceDuringElectrolysisFormula = FormulaModel(R.string.mass_of_produced_substance_during_electrolysis_formula, chem, "m =\nI × t × Mₐ ÷ (F × n)", 199, listOf(
        R.string.mass,
        R.string.current,
        R.string.time,
        R.string.molar_mass_of_substance,
        R.string.number_of_electrons_exchanged
    ), faradayConstant)



    // denge formulleri
    // molarite - molalite
    // atom alt parcaciklarinin sayilarini hesaplamak
    // 3 temel yasa (kutle korunumu, sabit oranlar yasasi, birlesme yasasi?
    // mol formulleri
    // gazlarin hiz ve kinetik enerji formulu
    // cozunurluk formulleri
    // entalpi formulleri
    // tepkime hiz formulu ?
    // faraaday cinsinden ifade etme gibi birsey
    // SONRAKI GUNCELLEME C, H, O sayisi girilecek ve onun ne olabilecegi altta yazacam
    // quantum sayilari tablosunu ekleyebilirim
    //mulliken elctronegativity



    //PHYSICS
    val kineticEnergyFormula = FormulaModel(R.string.kinetic_energy_formula, phy, "m × v² ÷ 2 = E", 4, listOf(
        R.string.mass,
        R.string.velocity,
        R.string.kinetic_energy
    ))
    val gravitationalPotentialEnergy = FormulaModel(R.string.gravitational_potential_energy, phy, "m × g × h = E", 16, listOf(
        R.string.mass,
        R.string.gravitational_acceleration,
        R.string.height,
        R.string.potential_energy
    ))
    val elasticPotentialEnergy = FormulaModel(R.string.elastic_potential_energy, phy, "k × (Δx)² ÷ 2 = E", 17, listOf(
        R.string.spring_constant,
        R.string.amount_of_compression,
        R.string.potential_energy
    ))
    val forceFormula = FormulaModel(R.string.force_formula, phy, "F = m × a", 18, listOf(
        R.string.force,
        R.string.mass,
        R.string.acceleration
    ))
    val workFormula = FormulaModel(R.string.work_formula, phy, "W = F × Δx × cos\uD835\uDF03",19, listOf(
        R.string.work,
        R.string.force,
        R.string.displacement,
        R.string.angle_between_d_and_f
    ))
    val powerFormula = FormulaModel(R.string.power_formula, phy, "P = E ÷ t", 37, listOf(
        R.string.power,
        R.string.energy,
        R.string.time
    ))
    val ohmsLaw = FormulaModel(R.string.ohms_law, phy, "V = I × R", 38, listOf(
        R.string.voltage,
        R.string.current,
        R.string.resistance
    ))
    val electricalPowerFormula = FormulaModel(R.string.electric_power_formula, phy, "P = V × I",39, listOf(
        R.string.power,
        R.string.voltage,
        R.string.current
    ))      //diger alternatifleri de ekleyebilirsin
    val electricCurrentFormula = FormulaModel(R.string.electric_power_formula, phy, "I = q ÷ t", 40, listOf(
        R.string.current,
        R.string.electric_charge,
        R.string.time
    ))
    val electricFieldFormula = FormulaModel(R.string.electric_field_formula, phy, "E = F ÷ q", 41, listOf(
        R.string.electric_field,
        R.string.electric_force,
        R.string.electric_charge
    ))
    val coulombsLaw = FormulaModel(R.string.coulombs_law, phy, "|F| = k × |q₁| × |q₂| ÷ d²", 42, listOf(
        R.string.electrostatic_force,
        R.string.electric_charge1,
        R.string.electric_charge2,
        R.string.distance
    ), coulombConstant)
    val electricPotentialEnergy = FormulaModel(R.string.electric_potential_energy, phy, "E = k × q₁ × q₂ ÷ d", 43, listOf(
        R.string.energy,
        R.string.electric_charge1,
        R.string.electric_charge2,
        R.string.distance
    ), coulombConstant)
    val electricFieldFormula2 = FormulaModel(R.string.electric_field_formula2, phy, "E = k × q ÷ d²", 44, listOf(
        R.string.energy,
        R.string.electric_charge,
        R.string.distance
    ), coulombConstant)
    val capacitanceFormula = FormulaModel(R.string.capacitance_formula, phy, "C = q ÷ V", 45, listOf(
        R.string.capacitance,
        R.string.electric_charge,
        R.string.voltage
    ))
    val pressureOfSolids = FormulaModel(R.string.pressure_of_solids, phy, "P = F ÷ A", 46, listOf(
        R.string.pressure,
        R.string.force,
        R.string.surface_area
    ))
    val pressureOfLiquids = FormulaModel(R.string.pressure_of_liquids, phy, "P = h × d × g", 47, listOf(
        R.string.pressure,
        R.string.height,
        R.string.density,
        R.string.gravitational_acceleration
    ))
    val electricalPowerFormula2 = FormulaModel(R.string.electric_power_formula2, phy, "P = I² × R", 48, listOf(
        R.string.power,
        R.string.current,
        R.string.resistance
    ))
    val resistanceOfAConductor = FormulaModel(R.string.resistance_of_conductor, phy, "R = ρ × l ÷ A", 49, listOf(
        R.string.resistance,
        R.string.electrical_resistivity,
        R.string.length,
        R.string.cross_sectional_area
    ))
    val electricPotentialFormula = FormulaModel(R.string.electric_potential_formula, phy, "V = k × q ÷ d", 50, listOf(
        R.string.voltage,
        R.string.electric_charge,
        R.string.distance
    ), coulombConstant)
    val electricFieldBetweenTwoChargedPlates = FormulaModel(R.string.electric_field_between_two_charged_plates, phy, "E = V ÷ d", 51, listOf(
        R.string.electric_field,
        R.string.voltage,
        R.string.distance
    ))
    val forceBetweenTwoChargedPlates = FormulaModel(R.string.force_between_two_charged_plates, phy, "F = q × V ÷ d", 52, listOf(
        R.string.force,
        R.string.electric_charge,
        R.string.voltage,
        R.string.distance
    ))
    val accelerationBetweenTwoChargedPlates = FormulaModel(R.string.acceleration_between_two_charged_plates, phy, "a = q × V ÷ (d × m)", 53, listOf(
        R.string.acceleration,
        R.string.electric_charge,
        R.string.voltage,
        R.string.distance,
        R.string.mass
    ))
    val transformerEquation = FormulaModel(R.string.transformer_equation, phy, "V₁ / V₂ = N₁ / N₂", 54, listOf(
        R.string.primary_voltage,
        R.string.secondary_voltage,
        R.string.number_of_turns_in_the_primary,
        R.string.number_of_turns_in_the_secondary
    ))
    val magneticFieldOfStraightWire = FormulaModel(R.string.magnetic_field_of_straight_wires, phy, "B = μ0 × I ÷ (2π × d)"  + "\n" + "k = μ0 ÷ 4π", 55, listOf(
        R.string.magnetic_field,
        R.string.current,
        R.string.distance
    ), permeabilityOfFreeSpace)
    val magneticFieldOfCurrentLoops = FormulaModel(R.string.magnetic_field_of_current_loops, phy, "B = μ0 × I × N ÷ 2r"  + "\n" + "k = μ0 ÷ 4π", 56, listOf(
        R.string.magnetic_field,
        R.string.current,
        R.string.number_of_turns,
        R.string.radius,
    ), permeabilityOfFreeSpace)
    val magneticFieldOfSolenoids = FormulaModel(R.string.magnetic_field_of_solenoids, phy, "B = μ0 × I × N ÷ l"  + "\n" + "k = μ0 ÷ 4π", 57, listOf(
        R.string.magnetic_field,
        R.string.current,
        R.string.number_of_turns,
        R.string.length_of_solenoid,
    ), permeabilityOfFreeSpace)
    val magneticForceOfWires = FormulaModel(R.string.magnetic_force_of_current_carrying_wires, phy, "F = B × I × l × sinθ", 58, listOf(
        R.string.force,
        R.string.magnetic_field,
        R.string.current,
        R.string.length,
        R.string.angle_between_l_and_b
    ))
    val lorenzForceFormula = FormulaModel(R.string.lorentz_force_formula, phy, "F = q × v × B", 59, listOf(
        R.string.force,
        R.string.electric_charge,
        R.string.velocity,
        R.string.magnetic_field
    ))
    val radiusOfOrbitOfChargeInMagneticField = FormulaModel(R.string.radius_of_orbit_of_a_charge_in_magnetic_field, phy, "r = m × v ÷ (B × q)", 60, listOf(
        R.string.radius,
        R.string.mass,
        R.string.velocity,
        R.string.magnetic_field,
        R.string.electric_charge
    ))
    val magneticFluxFormula = FormulaModel(R.string.magnetic_flux_formula, phy, "Φ = B × A × cosθ", 61, listOf(
        R.string.magnetic_flux,
        R.string.magnetic_field,
        R.string.surface_area,
        R.string.angle_between_a_and_b
    ))
    val electromagneticInductionFormula = FormulaModel(R.string.electromagnetic_induction_formula, phy, "EMF = -∆Φ ÷ ∆t", 62, listOf(
        R.string.electromotive_force,
        R.string.change_in_magnetic_flux,
        R.string.change_in_time
    ))
    val selfInductionEMKFormula = FormulaModel(R.string.self_induction_emf_formula, phy, "EMF = -L × (∆I ÷ ∆t)", 63, listOf(
        R.string.electromotive_force,
        R.string.inductance,
        R.string.change_in_current,
        R.string.change_in_time
    ))
    val peakEMFInAGenerator = FormulaModel(R.string.peak_electromotive_force_in_a_generator, phy, "EMF = "  + "\n" + "N × B × A × ω × cos(θ)", 64, listOf(
        R.string.electromotive_force,
        R.string.number_of_turns,
        R.string.magnetic_field,
        R.string.area_of_the_coil,
        R.string.angular_velocity,
        R.string.angle_between_b_and_normal_of_coil_plane
    ))
    val relativeMotionFormula = FormulaModel(R.string.relative_motion_formula, phy, "vᵣ = v₂ - v₁", 65, listOf(
        R.string.relative_velocity,
        R.string.observed_velocity,
        R.string.observer_velocity
    ))
    val velocityFormula = FormulaModel(R.string.velocity_formula, phy, "v = Δx ÷ t", 66, listOf(
        R.string.velocity_formula,
        R.string.displacement,
        R.string.time
    ))
    val accelerationFormula = FormulaModel(R.string.acceleration_formula, phy, "a = v ÷ t", 67, listOf(
        R.string.acceleration,
        R.string.velocity,
        R.string.time
    ))
    val acceleratedMotionFormula = FormulaModel(R.string.accelerated_motion_formula, phy, "Δx = (v0 × t) + (a × t² ÷ 2)", 68, listOf(
        R.string.displacement,
        R.string.initial_velocity,
        R.string.time,
        R.string.acceleration
    ))
    val heatFormula = FormulaModel(R.string.heat_formula, phy, "Q = m × c × ΔT", 69, listOf(
        R.string.heat,
        R.string.mass,
        R.string.heat_capacity,
        R.string.change_in_temperature
    ))
    val heatOfTransformationFormula = FormulaModel(R.string.heat_of_transformation_formula, phy, "Q = m × L", 70, listOf(
        R.string.heat,
        R.string.mass,
        R.string.heat_of_transformation
    ))
    val hookesLaw = FormulaModel(R.string.hookes_law, phy, "F = k × x", 71, listOf(
        R.string.force,
        R.string.spring_constant,
        R.string.distance
    ))
    val linearVelocityFormula = FormulaModel(R.string.linear_velocity_formula, phy, "v = 2π × r × f", 72, listOf(
        R.string.velocity,
        R.string.radius,
        R.string.frequency
    ), piNumber)
    val linearVelocityFormula2 = FormulaModel(R.string.linear_velocity_formula_2, phy, "v = ω × r",73, listOf(
        R.string.velocity,
        R.string.angular_velocity,
        R.string.radius
    ))
    val angularVelocityFormula = FormulaModel(R.string.angular_velocity_formula, phy, "ω = 2π × f", 74, listOf(
        R.string.angular_velocity,
        R.string.frequency
    ), piNumber)
    val centripetalForceFormula = FormulaModel(R.string.centripetal_force_formula, phy, "F = m × r × ω²", 75, listOf(
        R.string.force,
        R.string.mass,
        R.string.radius,
        R.string.angular_velocity
    ))
    val centripetalForceFormula2 = FormulaModel(R.string.centripetal_force_formula_2, phy, "F = m × v² ÷ r", 76, listOf(
        R.string.force,
        R.string.mass,
        R.string.velocity,
        R.string.radius
    ))
    val centripetalAccelerationFormula = FormulaModel(R.string.centripetal_acceleration_formula, phy, "F = r × ω²", 77, listOf(
        R.string.acceleration,
        R.string.radius,
        R.string.angular_velocity
    ))
    val centripetalAccelerationFormula2 = FormulaModel(R.string.centripetal_acceleration_formula_2, phy, "F = v² ÷ r", 78, listOf(
        R.string.acceleration,
        R.string.velocity,
        R.string.radius
    ))
    val minimumVelocityOfAnObjectRotatingInsideACylinder = FormulaModel(R.string.min_velo_of_an_object_rotating_in_a_cylinder, phy, "v_min = √(g × r × k)", 79, listOf(
        R.string.minimum_velocity,
        R.string.gravitational_acceleration,
        R.string.radius,
        R.string.coefficent_of_friction
    ))
    val velocityOfWavesFormula = FormulaModel(R.string.velocity_of_waves_formula, phy, "v = λ × f", 80, listOf(
        R.string.velocity,
        R.string.wavelength,
        R.string.frequency
    ))
    val luminousFluxFormula = FormulaModel(R.string.luminous_flux_formula, phy, "Φ = I × 4π", 81, listOf(
        R.string.luminous_flux,
        R.string.luminous_intensity
    ), piNumber)
    val illuminanceFormula = FormulaModel(R.string.illuminance_formula, phy, "E = I ÷ r²", 82, listOf(
        R.string.illuminance,
        R.string.luminous_intensity,
        R.string.radius
    ))
    val velocityDuringSimpleHarmonicMotion = FormulaModel(R.string.velocity_during_simple_harmonic_motion, phy, "v = ω × √(r² - x²)", 83, listOf(
        R.string.velocity,
        R.string.angular_velocity,
        R.string.radius,
        R.string.oscillation
    ))      // bu formul yanlis
    val horizontalVelocityDuringSimpleHarmonicMotion = FormulaModel(R.string.horizontal_velocity_during_simple_harmonic_motion, phy, "v_x = ω × r × sin(ωt)", 84, listOf(
        R.string.angular_velocity,
        R.string.radius,
        R.string.time
    ), requiresNull = false)
    val verticalVelocityDuringSimpleHarmonicMotion = FormulaModel(R.string.vertical_velocity_during_simple_harmonic_motion, phy, "v_y = ω × r × cos(ωt)", 85, listOf(
        R.string.angular_velocity,
        R.string.radius,
        R.string.time
    ), requiresNull = false)
    val horizontalVelocityDuringSimpleHarmonicMotion2 = FormulaModel(R.string.horizontal_velocity_during_simple_harmonic_motion2, phy, "v_x = ω × r × sin(θ)", 86, listOf(
        R.string.horizontal_velocity,
        R.string.angular_velocity,
        R.string.radius,
        R.string.angle
    ))
    val verticalVelocityDuringSimpleHarmonicMotion2 = FormulaModel(R.string.vertical_velocity_during_simple_harmonic_motion2, phy, "v_y = ω × r × cos(θ)", 87, listOf(
        R.string.vertical_velocity,
        R.string.angular_velocity,
        R.string.radius,
        R.string.angle
    ))
    var horizontalLocationDuringSimpleHarmonicMotion = FormulaModel(R.string.horizontal_location_during_simple_harmonic_motion, phy, "x = r × cos(ωt)", 88, listOf(
        R.string.horizontal_location,
        R.string.radius,
        R.string.angular_velocity,
        R.string.time
    ))
    var verticalLocationDuringSimpleHarmonicMotion = FormulaModel(R.string.vertical_location_during_simple_harmonic_motion, phy, "y = r × sin(ωt)", 89, listOf(
        R.string.vertical_location,
        R.string.radius,
        R.string.angular_velocity,
        R.string.time
    ))
    var horizontalLocationDuringSimpleHarmonicMotion2 = FormulaModel(R.string.horizontal_location_during_simple_harmonic_motion2, phy, "x = r × cos(θ)", 90, listOf(
        R.string.horizontal_location,
        R.string.radius,
        R.string.angle
    ))
    var verticalLocationDuringSimpleHarmonicMotion2 = FormulaModel(R.string.vertical_location_during_simple_harmonic_motion2, phy, "y = r × sin(θ)", 91, listOf(
        R.string.vertical_location,
        R.string.radius,
        R.string.angle
    ))
    var horizontalAccelerationDuringSimpleHarmonicMotion = FormulaModel(R.string.horizontal_acceleration_during_simple_harmonic_motion, phy, "a_x = ω² × r × cos(ωt)", 92, listOf(
        R.string.angular_velocity,
        R.string.radius,
        R.string.time
    ), requiresNull = false)

    var verticalAccelerationDuringSimpleHarmonicMotion = FormulaModel(R.string.vertical_acceleration_during_simple_harmonic_motion, phy, "a_y = ω² × r × sin(ωt)", 93, listOf(
        R.string.angular_velocity,
        R.string.radius,
        R.string.time
    ), requiresNull = false)
    var horizontalAccelerationDuringSimpleHarmonicMotion2 = FormulaModel(R.string.horizontal_acceleration_during_simple_harmonic_motion2, phy, "a_x = ω² × r × cos(θ)", 94, listOf(
        R.string.horizontal_acceleration,
        R.string.angular_velocity,
        R.string.radius,
        R.string.angle
    ))
    var verticalAccelerationDuringSimpleHarmonicMotion2 = FormulaModel(R.string.vertical_acceleration_during_simple_harmonic_motion2, phy, "a_y = ω² × r × sin(θ)", 95, listOf(
        R.string.vertical_acceleration,
        R.string.angular_velocity,
        R.string.radius,
        R.string.angle
    ))
    var horizontalRestoringForceDuringSimpleHarmonicMotion = FormulaModel(R.string.horizontal_restoring_force_during_simple_harmonic_motion, phy, "F_x =\nm × ω² × r × cos(ωt)", 96, listOf(
        R.string.mass,
        R.string.angular_velocity,
        R.string.radius,
        R.string.time
    ), requiresNull = false)
    var verticalRestoringForceDuringSimpleHarmonicMotion = FormulaModel(R.string.vertical_restoring_force_during_simple_harmonic_motion, phy, "F_y =\nm × ω² × r × sin(ωt)", 97, listOf(
        R.string.mass,
        R.string.angular_velocity,
        R.string.radius,
        R.string.time
    ), requiresNull = false)
    var horizontalRestoringForceDuringSimpleHarmonicMotion2 = FormulaModel(R.string.horizontal_restoring_force_during_simple_harmonic_motion2, phy, "F_x =\nm × ω² × r × cos(θ)", 98, listOf(
        R.string.horizontal_restoring_force,
        R.string.mass,
        R.string.angular_velocity,
        R.string.radius,
        R.string.angle
    ))
    var verticalRestoringForceDuringSimpleHarmonicMotion2 = FormulaModel(R.string.vertical_restoring_force_during_simple_harmonic_motion2, phy, "F_y =\nm × ω² × r × sin(θ)", 99, listOf(
        R.string.vertical_restoring_force,
        R.string.mass,
        R.string.angular_velocity,
        R.string.radius,
        R.string.angle
    ))
    var periodOfSpringPendulumDuringSimpleHarmonicMotion = FormulaModel(R.string.period_of_spring_pendulum_during_simple_harmonic_motion, phy, "T = 2π × √(m ÷ k)", 100, listOf(
        R.string.period,
        R.string.mass,
        R.string.spring_constant
    ), piNumber)
    var periodOfSimplePendulumDuringSimpleHarmonicMotion = FormulaModel(R.string.period_of_simple_pendulum_during_simple_harmonic_motion, phy, "T = 2π × √(L ÷ g)", 101, listOf(
        R.string.period,
        R.string.length_of_rope,
        R.string.gravitational_acceleration
    ), piNumber)
    var maximumSafeSpeedAnObjectCanTakeOnAFrictionalTurn = FormulaModel(R.string.maximum_safe_speed_an_object_can_take_on_a_frictional_turn, phy, "v_max = √(k × g × r)", 102, listOf(
        R.string.maximum_velocity,
        R.string.coefficent_of_friction,
        R.string.gravitational_acceleration,
        R.string.radius
    ))
    var safeSpeedDuringTurningOnAnInclinedAndFrictionlessTurn = FormulaModel(R.string.safe_speed_during_turning_on_an_inclined_and_frictionless_turn, phy, "v = √(g × r × tan(θ))", 103, listOf(
        R.string.velocity,
        R.string.gravitational_acceleration,
        R.string.radius,
        R.string.slope_angle
    ))
    var safeSpeedDuringTurningInACylinder = FormulaModel(R.string.safe_speed_during_turning_in_a_cylinder, phy, "v = √(g × r ÷ k)", 104, listOf(
        R.string.velocity,
        R.string.gravitational_acceleration,
        R.string.radius,
        R.string.coefficent_of_friction
    ))
    var momentOfInertiaFormula = FormulaModel(R.string.moment_of_inertia_formula, phy, "I = L ÷ ω", 105, listOf(
        R.string.moment_of_inertia,
        R.string.angular_momentum,
        R.string.angular_velocity
    ))
    var momentOfInertiaOfSpheres = FormulaModel(R.string.moment_of_inertia_of_solid_spheres, phy, "I = (2/5) × m × r²", 106, listOf(
        R.string.moment_of_inertia,
        R.string.mass,
        R.string.radius
    ))
    var momentOfInertiaOfCylinders = FormulaModel(R.string.moment_of_inertia_of_solid_cylinders, phy, "I = (1/2) × m × r²", 107, listOf(
        R.string.moment_of_inertia,
        R.string.mass,
        R.string.radius
    ))
    var momentOfInertiaOfDisks = FormulaModel(R.string.moment_of_inertia_of_disks, phy, "I = (1/2) × m × r²", 108, listOf(
        R.string.moment_of_inertia,
        R.string.mass,
        R.string.radius
    ))
    var momentOfInertiaOfRings = FormulaModel(R.string.moment_of_inertia_of_rings, phy, "I = m × r²", 109, listOf(
        R.string.moment_of_inertia,
        R.string.mass,
        R.string.radius
    ))
    var momentOfInertiaOfRods = FormulaModel(R.string.moment_of_inertia_of_rods, phy, "I = (1/12) × m × L²", 110, listOf(
        R.string.moment_of_inertia,
        R.string.mass,
        R.string.length_of_rod
    ))
    var rotationalKineticEnergyFormula = FormulaModel(R.string.rotational_kinetic_energy_formula, phy, "E = I × ω² ÷ 2", 111, listOf(
        R.string.energy,
        R.string.moment_of_inertia,
        R.string.angular_velocity
    ))
    var kineticEnergyOfRotatingObject = FormulaModel(R.string.kinetic_energy_of_a_rotating_object, phy, "E = " + "\n" + "(m × v² ÷ 2) + (I × ω² ÷ 2)", 112, listOf(
        R.string.energy,
        R.string.mass,
        R.string.linear_velocity,
        R.string.moment_of_inertia,
        R.string.angular_velocity
    ))
    var angularMomentumFormula = FormulaModel(R.string.angular_momentum_formula, phy, "L = P × r", 113, listOf(
        R.string.angular_momentum,
        R.string.linear_momentum,
        R.string.radius
    ))
    var angularMomentumFormula2 = FormulaModel(R.string.angular_momentum_formula2, phy, "L = m × v × r", 114, listOf(
        R.string.angular_momentum,
        R.string.mass,
        R.string.velocity,
        R.string.radius
    ))
    var angularMomentumFormula3 = FormulaModel(R.string.angular_momentum_formula3, phy, "L = I × ω", 115, listOf(
        R.string.angular_momentum,
        R.string.moment_of_inertia,
        R.string.angular_velocity
    ))
    var torqueFormula = FormulaModel(R.string.torque_formula, phy, "τ = r × F × sin(α)", 116, listOf(
        R.string.torque,
        R.string.radius,
        R.string.force,
        R.string.angle_between_force_and_radius
    ))
    var torqueFormula2 = FormulaModel(R.string.torque_formula2, phy, "τ = I × α", 117, listOf(
        R.string.torque,
        R.string.moment_of_inertia,
        R.string.angular_acceleration
    ))
    var tangentialAccelerationFormula = FormulaModel(R.string.tangential_acceleration_formula, phy, "a_t = α × r", 118, listOf(
        R.string.tangential_acceleration,
        R.string.angular_acceleration,
        R.string.radius
    ))
    var gravitationalForceFormula = FormulaModel(R.string.gravitational_force_formula, phy, "F = G × m₁ × m₂ ÷ d²", 119, listOf(
        R.string.force,
        R.string.mass1,
        R.string.mass2,
        R.string.distance_between_objects
    ), gravitationalConstant)
    var gravitationalAccelerationFormulaAboveSurface = FormulaModel(R.string.gravitational_acceleration_formula_above_surface, phy, "g = G × M ÷ d²", 120, listOf(
        R.string.gravitational_acceleration,
        R.string.mass_of_the_planet,
        R.string.distance_between_planet_and_object
    ), gravitationalConstant)
    var gravitationalAccelerationFormulaInsidePlanet = FormulaModel(R.string.gravitational_acceleration_formula_inside_planet, phy, "g = k × r × d", 121, listOf(
        R.string.gravitational_acceleration,
        R.string.distance_between_object_and_planet_r,
        R.string.density_of_the_planet
    ), constantForGravitationalAccelerationInsidePlanet)
    var gravitationalPotentialEnergyOfAnOrbitingSatellite = FormulaModel(R.string.gravitational_potential_energy_of_an_orbiting_satellite, phy, "E = -G × M × m ÷ r", 122, listOf(
        R.string.potential_energy,
        R.string.mass_of_the_planet,
        R.string.mass_of_satellite,
        R.string.orbit_radius
    ), gravitationalConstant)
    var escapeVelocityFormula = FormulaModel(R.string.escape_velocity_formula, phy, "v = √(2G × M ÷ d)", 123, listOf(
        R.string.velocity,
        R.string.mass_of_the_planet,
        R.string.distance_between_planet_and_object
    ), gravitationalConstant)
    var escapeEnergyFormula = FormulaModel(R.string.escape_energy_formula, phy, "E = G × M × m ÷ d", 124, listOf(
        R.string.energy,
        R.string.mass_of_the_planet,
        R.string.mass_of_object,
        R.string.distance_between_planet_and_object
    ), gravitationalConstant)
    var lawOfPeriods = FormulaModel(R.string.law_of_periods, phy, "T₁² / R₁³ = T₂² / R₂³", 125, listOf(
        R.string.period1,
        R.string.average_radius1,
        R.string.period2,
        R.string.average_radius2
    ))
    var fringeSpacingFormulaDoubleSlit = FormulaModel(R.string.fringe_spacing_formula_double_slit, phy, "Δx = λ × L ÷ (d × n)", 126, listOf(
        R.string.fringe_spacing,
        R.string.wavelength,
        R.string.distance_between_screen_and_slits,
        R.string.distance_between_slits,
        R.string.refractive_index
    ))
    var fringeSpacingFormulaSingleSlit = FormulaModel(R.string.fringe_spacing_formula_single_slit, phy, "Δx = λ × L ÷ (w × n)", 127, listOf(
        R.string.fringe_spacing,
        R.string.wavelength,
        R.string.distance_between_screen_and_slit,
        R.string.width_of_slit,
        R.string.refractive_index
    ))
    var angularMomentumOfAnOrbitingElectron = FormulaModel(R.string.angular_momentum_of_an_orbiting_electron, phy, "L = n × ħ", 128, listOf(
        R.string.angular_momentum,
        R.string.number_representing_the_orbit
    ), diracConstant)
    var orbitingRadiusOfAnElectron = FormulaModel(R.string.orbiting_radius_of_an_electron, phy, "r = a₀ × n² ÷ Z", 129, listOf(
        R.string.radius,
        R.string.number_representing_the_orbit,
        R.string.atomic_number
    ), bohrRadius)
    var energyOfElectronInBohrOrbits = FormulaModel(R.string.energy_of_electron_in_bohr_orbit, phy, "E = -13.6 × Z² ÷ n²", 130, listOf(
        R.string.energy,
        R.string.atomic_number,
        R.string.number_representing_the_orbit
    ))
    var energyStoredInCapacitor = FormulaModel(R.string.energy_stored_in_capacitor, phy, "E = q × V ÷ 2", 131, listOf(
        R.string.energy,
        R.string.electric_charge,
        R.string.voltage
    ))
    var energyStoredInCapacitor2 = FormulaModel(R.string.energy_stored_in_capacitor2, phy, "E = C × V² ÷ 2", 132, listOf(
        R.string.energy,
        R.string.capacitance,
        R.string.voltage
    ))
    var capacitanceOfCapacitorFormula = FormulaModel(R.string.capacitance_of_capacitor_formula, phy, "C = ε × A ÷ d", 133, listOf(
        R.string.capacitance,
        R.string.dielectric_constant,
        R.string.area_of_the_plates,
        R.string.distance_between_the_plates
    ))
    var torqueOfACurrentCarryingLoopInMagneticField = FormulaModel(R.string.torque_of_a_current_carrying_loop_in_magnetic_field, phy, "τ = N × B × I × A", 134, listOf(
        R.string.torque,
        R.string.number_of_turns,
        R.string.magnetic_field,
        R.string.current,
        R.string.area_of_the_loop
    ))
    var rootMeanSquareVoltageFormulaSinusoidalWaveform = FormulaModel(R.string.root_mean_square_voltage_formula_sinusoidal_waveform, phy, "V_rms = V_peak ÷ √(2)", 135, listOf(
        R.string.root_mean_square_voltage,
        R.string.peak_voltage
    ))
    var rootMeanSquareVoltageFormulaTriangleWaveform = FormulaModel(R.string.root_mean_square_voltage_formula_triangle_waveform, phy, "V_rms = V_peak ÷ √(3)", 136, listOf(
        R.string.root_mean_square_voltage,
        R.string.peak_voltage
    ))
    var rootMeanSquareVoltageFormulaSquareWaveform = FormulaModel(R.string.root_mean_square_voltage_formula_square_waveform, phy, "V_rms = V_peak", 137, listOf(
        R.string.root_mean_square_voltage,
        R.string.peak_voltage
    ))
    var rootMeanSquareCurrentFormulaSinusoidalWaveform = FormulaModel(R.string.root_mean_square_current_formula_sinusoidal_waveform, phy, "I_rms = I_peak ÷ √(2)", 138, listOf(
        R.string.root_mean_square_current,
        R.string.peak_current
    ))
    var rootMeanSquareCurrentFormulaTriangleWaveform = FormulaModel(R.string.root_mean_square_current_formula_triangle_waveform, phy, "I_rms = I_peak ÷ √(3)", 139, listOf(
        R.string.root_mean_square_current,
        R.string.peak_current
    ))
    var rootMeanSquareCurrentFormulaSquareWaveform = FormulaModel(R.string.root_mean_square_current_formula_square_waveform, phy, "I_rms = I_peak", 140, listOf(
        R.string.root_mean_square_current,
        R.string.peak_current
    ))
    var efficiencyFormula = FormulaModel(R.string.efficiency_formula, phy, "Efficiency = \n" + "(O ÷ I) × 100%", 141, listOf(
        R.string.output,
        R.string.input
    ), requiresNull = false)
    var weightFormula = FormulaModel(R.string.weight_formula, phy, "G = m × g", 142, listOf(
        R.string.weight,
        R.string.mass,
        R.string.gravitational_acceleration
    ))
    var frictionForceFormula = FormulaModel(R.string.friction_force_formula, phy, "F = k × N", 143, listOf(
        R.string.friction_force,
        R.string.coefficent_of_friction,
        R.string.normal_force
    ))
    var velocityFormulaWithoutTime = FormulaModel(R.string.velocity_formula_without_time, phy, "v² = v₀² + 2 × a × Δx", 144, listOf(
        R.string.final_velocity,
        R.string.initial_velocity,
        R.string.acceleration,
        R.string.displacement
    ))
    var downwardProjectileMotionHeightFormula = FormulaModel(R.string.downward_projectile_motion_height_formula, phy, "h = \n(v₀ × t) + (g × t² ÷ 2)", 145, listOf(
        R.string.height,
        R.string.initial_velocity,
        R.string.time,
        R.string.gravitational_acceleration
    ))
    var upwardProjectileMotionHeightFormula = FormulaModel(R.string.upward_projectile_motion_height_formula, phy, "h = \n(v₀ × t) - (g × t² ÷ 2)", 146, listOf(
        R.string.height,
        R.string.initial_velocity,
        R.string.time,
        R.string.gravitational_acceleration
    ))
    var downwardProjectileMotionVelocityFormula = FormulaModel(R.string.downward_projectile_motion_velocity_formula, phy, "v = v₀ + (g × t)", 147, listOf(
        R.string.velocity,
        R.string.initial_velocity,
        R.string.time,
        R.string.gravitational_acceleration
    ))
    var upwardProjectileMotionVelocityFormula = FormulaModel(R.string.upward_projectile_motion_velocity_formula, phy, "v = v₀ - (g × t)", 148, listOf(
        R.string.velocity,
        R.string.initial_velocity,
        R.string.time,
        R.string.gravitational_acceleration
    ))
    var upwardProjectileMotionFlightTimeFormula = FormulaModel(R.string.upward_projectile_motion_flight_time_formula, phy, "t = 2 × v₀ ÷ g", 149, listOf(
        R.string.flight_time,
        R.string.initial_velocity,
        R.string.gravitational_acceleration
    ))
    var upwardProjectileMotionMaximumHeightFormula = FormulaModel(R.string.upward_projectile_motion_maximum_height_formula, phy, "h_max = v₀² ÷ (2 × g)", 150, listOf(
        R.string.maximum_height,
        R.string.initial_velocity,
        R.string.gravitational_acceleration
    ))
    var freeFallHeightFormula = FormulaModel(R.string.free_fall_height_formula, phy, "h = g × t² ÷ 2", 151, listOf(
        R.string.height,
        R.string.gravitational_acceleration,
        R.string.time
    ))
    var freeFallVerticalVelocityFormula = FormulaModel(R.string.free_fall_vertical_velocity_formula, phy, "v = g × t", 152, listOf(
        R.string.velocity,
        R.string.gravitational_acceleration,
        R.string.time
    ))
    var freeFallVelocityFormulaWithoutTime = FormulaModel(R.string.free_fall_velocity_formula_without_time, phy, "v² = 2 × g × h", 153, listOf(
        R.string.final_velocity,
        R.string.gravitational_acceleration,
        R.string.height
    ))
    var impulseFormula = FormulaModel(R.string.impulse_formula, phy, "I = F × Δt", 154, listOf(
        R.string.impulse,
        R.string.force,
        R.string.change_in_time
    ))
    var momentumFormula = FormulaModel(R.string.momentum_formula, phy, "P = m × v", 155, listOf(
        R.string.momentum,
        R.string.mass,
        R.string.velocity
    ))
    var centralElasticCollisionVelocitiesEquation = FormulaModel(R.string.central_elastic_collision_velocities_equation, phy, "v₁ + v₁' = v₂ + v₂'", 156, listOf(
        R.string.initial_velocity1,
        R.string.final_velocity1,
        R.string.initial_velocity2,
        R.string.final_velocity2
    ))
    var screwEquation = FormulaModel(R.string.screw_equation, phy, "F × 2π × b = R × a", 157, listOf(
        R.string.applied_force,
        R.string.radius_of_rotation_arm,
        R.string.resistive_force,
        R.string.screw_thread_height
    ), piNumber)
    var illuminanceFormula2 = FormulaModel(R.string.illuminance_formula2, phy, "E = ϕ ÷ A", 158, listOf(
        R.string.illuminance,
        R.string.luminous_flux,
        R.string.area
    ))
    var numberOfImagesIntersectingMirrors = FormulaModel(R.string.number_of_images_formula_intersecting_mirrors, phy, "n = (360 ÷ α) - 1", 159, listOf(
        R.string.number_of_images,
        R.string.angle_between_mirrors
    ))
    var absoluteRefractiveIndexFormula = FormulaModel(R.string.absolute_refractive_index_formula, phy, "n = c ÷ v", 160, listOf(
        R.string.refractive_index,
        R.string.speed_of_light_in_the_medium
    ), constant = speedOfLight)
    var buoyantForceFormula = FormulaModel(R.string.buoyant_force_formula, phy, "F = V × d × g", 162, listOf(
        R.string.buoyant_force,
        R.string.sinking_volume_of_object,
        R.string.density_of_liquid_gas,
        R.string.gravitational_acceleration
    ))
    var electricalEnergyFormula = FormulaModel(R.string.electric_energy_formula, phy, "E = q × V", 163, listOf(
        R.string.energy,
        R.string.electric_charge,
        R.string.voltage
    ))
    var totalWorkDoneFormula = FormulaModel(R.string.total_work_done_formula, phy, "W = P × t", 164, listOf(
        R.string.work,
        R.string.power,
        R.string.time
    ))
    var fahrenheitCelsiusConverter = FormulaModel(R.string.fahrenheit_celsius_converter, phy, "T_c ÷ 100 =\n(T_f - 32) ÷ 180", 165, listOf(
        R.string.temperature_celsius,
        R.string.temperature_fahrenheit
    ))
    var heatConductionRateFormula = FormulaModel(R.string.heat_conduction_rate_formula, phy, "ΔQ/Δt =\n-k × A × (ΔT ÷ x)", 166, listOf(
        R.string.heat_conduction_rate,
        R.string.thermal_conductivity,
        R.string.surface_area,
        R.string.change_in_temperature,
        R.string.distance_in_transmission_direction
    ))
    var linearExpansionFormula = FormulaModel(R.string.linear_expansion_formula, phy, "ΔL = L₀ × λ × ΔT", 167, listOf(
        R.string.change_in_length,
        R.string.initial_length,
        R.string.coefficient_of_linear_expansion,
        R.string.change_in_temperature
    ))
    var superficialExpansionFormula = FormulaModel(R.string.superficial_expansion_formula, phy, "ΔA = A₀ × γ × ΔT", 168, listOf(
        R.string.change_in_area,
        R.string.initial_area,
        R.string.coefficient_of_superficial_expansion,
        R.string.change_in_temperature
    ))
    var volumetricExpansionFormula = FormulaModel(R.string.volumetric_expansion_formula, phy, "ΔV = V₀ × β × ΔT", 169, listOf(
        R.string.change_in_volume,
        R.string.initial_volume,
        R.string.coefficient_of_volumetric_expansion,
        R.string.change_in_temperature
    ))



    // esneklik - yukseklik potansiyel enerji
    // mekanik enerji
    // guc - tork ilikisi
    // merkezcil kuvvet
    // surtunme kuvveti
    // kadirma kuvveti
    // aydinlanma formulleri
    // dalgo formulleri
    // yogunluk
    // dayaniklilik
    // hiz ve ivme ve bunlarin degisik formulleri
    // Kuvvet
    // is ve guc hesabi
    // verim
    // oz isi, isi sigasi, isi degisimi (q = mct)
    // genlesme??
    // yuk akim iliskisi (akim formulu)
    // potansiyel fark
    // direnc
    // elektrik enerjisi, elektriksel guc
    // basinc
    // frekans ve dalga boyu iliskisi
    // itme momentum
    // SONRAKI GUNCELLEME carpisan iki cismin islem sonucundaki mometnumlerini hesapla
    // tork ve varsa denge
    // elektriksel kuvvet ve alan
    // elektriksel potansiyel
    // elektrik alan ve siga
    // manyetizma ve induklenme
    // transformatorler icin empedans hesaplama?? (direnc ve kapasitor icin)
    // cembersel harekeet
    // acisal momentum ve acisal ivme, hiz
    // kutle cekim
    // kepler yasalari
    // basit harmonik hareket formulleri
    // dalga katari, aydinlik, karanlik formulleri
    // diger dalga formulleri 12. sinif
    // radyoaktivite ve atom fizigi formulleri
    // ozel gorelilik??
    // foto elektrik
    // compton sacilmasi
    // de broglie



    //LIST
    val formulaListInit = listOf(
        pythagoreanTheorem,
        rectangleAreaFormula,
        idealGasLaw,
        kineticEnergyFormula,
        circumferenceOfCircle,
        areaOfCircle,
        surfaceAreaOfSphere,
        volumeOfSphere,
        sumOfInteriorAnglesOfPolygons,
        numberOfDiagonals,
        rootsOfQuadraticEquation,
        volumeOfRectangularPrism,
        volumeOfCylinder,
        areaOfTriangle,
        heronsFormula,
        gravitationalPotentialEnergy,
        elasticPotentialEnergy,
        forceFormula,
        workFormula,
        permutation,
        combination,
        kineticEnergyOfGas,
        velocityOfGasParticles,
        volumeOfPyramid,
        volumeOfCone,
        surfaceAreaOfCone,
        surfaceAreaOfRectangularPrism,
        lawOfCosines,
        lawOfSines,
        doubleAngleSinSame,
        doubleAngleSinDifferent,
        doubleAngleCosSame,
        doubleAngleCosDifferent,
        doubleAngleTanSame,
        doubleAngleTanDifferent,
        areaOfHexagon,
        powerFormula,
        ohmsLaw,
        electricalPowerFormula,
        electricCurrentFormula,
        electricFieldFormula,
        coulombsLaw,
        electricPotentialEnergy,
        electricFieldFormula2,
        capacitanceFormula,
        pressureOfSolids,
        pressureOfLiquids,
        electricalPowerFormula2,
        resistanceOfAConductor,
        electricPotentialFormula,
        electricFieldBetweenTwoChargedPlates,
        forceBetweenTwoChargedPlates,
        accelerationBetweenTwoChargedPlates,
        transformerEquation,
        magneticFieldOfStraightWire,
        magneticFieldOfCurrentLoops,
        magneticFieldOfSolenoids,
        magneticForceOfWires,
        lorenzForceFormula,
        radiusOfOrbitOfChargeInMagneticField,
        magneticFluxFormula,
        electromagneticInductionFormula,
        selfInductionEMKFormula,
        peakEMFInAGenerator,
        relativeMotionFormula,
        velocityFormula,
        accelerationFormula,
        acceleratedMotionFormula,
        heatFormula,
        heatOfTransformationFormula,
        hookesLaw,
        linearVelocityFormula,
        linearVelocityFormula2,
        angularVelocityFormula,
        centripetalForceFormula,
        centripetalForceFormula2,
        centripetalAccelerationFormula,
        centripetalAccelerationFormula2,
        minimumVelocityOfAnObjectRotatingInsideACylinder,
        velocityOfWavesFormula,
        luminousFluxFormula,
        illuminanceFormula,
        velocityDuringSimpleHarmonicMotion,
        horizontalVelocityDuringSimpleHarmonicMotion,
        verticalVelocityDuringSimpleHarmonicMotion,
        horizontalVelocityDuringSimpleHarmonicMotion2,
        verticalVelocityDuringSimpleHarmonicMotion2,
        horizontalLocationDuringSimpleHarmonicMotion,
        verticalLocationDuringSimpleHarmonicMotion,
        horizontalLocationDuringSimpleHarmonicMotion2,
        verticalLocationDuringSimpleHarmonicMotion2,
        horizontalAccelerationDuringSimpleHarmonicMotion,
        verticalAccelerationDuringSimpleHarmonicMotion,
        horizontalAccelerationDuringSimpleHarmonicMotion2,
        verticalAccelerationDuringSimpleHarmonicMotion2,
        horizontalRestoringForceDuringSimpleHarmonicMotion,
        verticalRestoringForceDuringSimpleHarmonicMotion,
        horizontalRestoringForceDuringSimpleHarmonicMotion2,
        verticalRestoringForceDuringSimpleHarmonicMotion2,
        periodOfSpringPendulumDuringSimpleHarmonicMotion,
        periodOfSimplePendulumDuringSimpleHarmonicMotion,
        maximumSafeSpeedAnObjectCanTakeOnAFrictionalTurn,
        safeSpeedDuringTurningOnAnInclinedAndFrictionlessTurn,
        safeSpeedDuringTurningInACylinder,
        momentOfInertiaFormula,
        momentOfInertiaOfSpheres,
        momentOfInertiaOfCylinders,
        momentOfInertiaOfDisks,
        momentOfInertiaOfRings,
        momentOfInertiaOfRods,
        rotationalKineticEnergyFormula,
        kineticEnergyOfRotatingObject,
        angularMomentumFormula,
        angularMomentumFormula2,
        angularMomentumFormula3,
        torqueFormula,
        torqueFormula2,
        tangentialAccelerationFormula,
        gravitationalForceFormula,
        gravitationalAccelerationFormulaAboveSurface,
        gravitationalAccelerationFormulaInsidePlanet,
        gravitationalPotentialEnergyOfAnOrbitingSatellite,
        escapeVelocityFormula,
        escapeEnergyFormula,
        lawOfPeriods,
        fringeSpacingFormulaDoubleSlit,
        fringeSpacingFormulaSingleSlit,
        angularMomentumOfAnOrbitingElectron,
        orbitingRadiusOfAnElectron,
        energyOfElectronInBohrOrbits,
        energyStoredInCapacitor,
        energyStoredInCapacitor2,
        capacitanceOfCapacitorFormula,
        torqueOfACurrentCarryingLoopInMagneticField,
        rootMeanSquareVoltageFormulaSinusoidalWaveform,
        rootMeanSquareVoltageFormulaTriangleWaveform,
        rootMeanSquareVoltageFormulaSquareWaveform,
        rootMeanSquareCurrentFormulaSinusoidalWaveform,
        rootMeanSquareCurrentFormulaTriangleWaveform,
        rootMeanSquareCurrentFormulaSquareWaveform,
        efficiencyFormula,
        weightFormula,
        frictionForceFormula,
        velocityFormulaWithoutTime,
        downwardProjectileMotionHeightFormula,
        upwardProjectileMotionHeightFormula,
        downwardProjectileMotionVelocityFormula,
        upwardProjectileMotionVelocityFormula,
        upwardProjectileMotionFlightTimeFormula,
        upwardProjectileMotionMaximumHeightFormula,
        freeFallHeightFormula,
        freeFallVerticalVelocityFormula,
        freeFallVelocityFormulaWithoutTime,
        impulseFormula,
        momentumFormula,
        centralElasticCollisionVelocitiesEquation,
        screwEquation,
        illuminanceFormula2,
        numberOfImagesIntersectingMirrors,
        absoluteRefractiveIndexFormula,
        idealGasLaw2,
        buoyantForceFormula,
        electricalEnergyFormula,
        totalWorkDoneFormula,
        fahrenheitCelsiusConverter,
        heatConductionRateFormula,
        linearExpansionFormula,
        superficialExpansionFormula,
        volumetricExpansionFormula,
        boylesLaw,
        charlessLaw,
        gayLussacsLaw,
        avogadrosLaw,
        numberOfMolesFormula,
        numberOfMolesFormula2,
        atomicMassFormula,
        numberOfMolesFormulaForGasesUnderNormalConditions,
        massPercentCompositionFormula,
        volumePercentCompositionFormula,
        ppmFormula,
        ppbFormula,
        averageKineticEnergyFormulaOfGasMolecules,
        grahamsLawOfDiffusion,
        averageVelocityOfGasMoleculesFormula,
        diffusionRateEquation,
        partialPressureFormula,
        molarityFormula,
        molalityFormula,
        changeOfConcentrationEquation,
        molarityFormula2,
        boilingPointElevationFormula,
        freezingPointDepressionFormula,
        enthalpyFormula,
        enthalpyFormula2,
        reactionRateFormula,
        reactionRateFormula2,
        relationshipBetweenEquilibriumConstants,
        nernstEquation,
        massOfProducedSubstanceDuringElectrolysisFormula,
        numberOfSubsetsFormula,
        numberOfProperSubsetsFormula,
        primeFactorFinder,
        primeNumberChecker,
        positiveIntegerDivisorFinder,
        greatestCommonDivisor,
        leastCommonMultiple,
        rootCalculator,
        triangleInequalityCalculator,
        areaOfEquilateralTriangle,
        factorialFormula,
        cyclicPermutationFormula,
        sumOfCoefficientsOfEvenDegreeTermsInPolynomial,
        sumOfCoefficientsOfOddDegreeTermsInPolynomial,
        squaredBinomialExpansion,
        cubedBinomialExpansion,
        squaredTrinomialExpansion,
        factoringDifferenceOfTwoSquares,
        factoringDifferenceOfTwoCubes,
        factoringSumOfTwoCubes,
        factoringSumOfXnYn,
        factoringDifferenceOfXnYn,
        binomialExpansions,
        anInteriorAngleOfRegularPolygonFormula,
        anExteriorAngleOfRegularPolygonFormula,
        areaOfRegularPolygon,
        areaOfTrapezoidFormula,
        areaOfParallelogramFormula,
        areaOfSquareFormula,
        lengthOfSpaceDiagonalInRectangularPrismFormula,
        volumeOfCubeFormula,
        surfaceAreaOfCubeFormula,
        surfaceAreaOfCylinder,
        heightOfRegularTetrahedronFormula,
        surfaceAreaOfRegularTetrahedronFormula,
        volumeOfRegularTetrahedronFormula,
        radianDegreeConverter,
        principalAngleFinder,
        distanceBetweenTwoPointsOnTheAnalyticalPlaneFormula,
        coordinatesOfTheMidpointOfALineSegmentFormula,
        coordinatesOfTheCentroidOfATriangleFormula,
        averageRateOfChangeFormula,
        exponentialFunctionFormula,
        logarithmFormula,
        naturalLogarithmFormula,
        nthTermOfAnArithmeticSequenceFormula,
        sumOfTheMembersOfAnArithmeticSequenceFormula,
        nthTermOfAGeometricSequenceFormula,
        sumOfTheMembersOfAGeometricSequenceFormula,
        productOfTheMembersOfAGeometricSequenceFormula,
        fibonacciSequenceStartingFrom1TermFinder,
        nthPowerOfiCalculator,
        rotationOfAPointAroundOriginFormula,
        reflectionAcrossXAxisFormula,
        reflectionAcrossYAxisFormula,
        reflectionAcrossYXFormula,
        reflectionAcrossYminusXFormula,
        reflectionAcrossXAFormula,
        reflectionAcrossYAFormula,
        reflectionOverOriginFormula,
        reflectionOfALineAcrossXAxisFormula,
        reflectionOfALineAcrossYAxisFormula,
        reflectionOfALineAcrossYXFormula,
        reflectionOfALineAcrossYminusXFormula,
        reflectionOfALineAcrossXDFormula,
        reflectionOfALineAcrossYEFormula,
        reflectionOfALineOverOriginFormula
        )


    //Ideas

    //included note pad (especially for tablets)
    //ml to understand problems in note pad
}