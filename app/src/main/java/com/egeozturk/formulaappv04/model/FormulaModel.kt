package com.egeozturk.formulaappv04.model

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.egeozturk.formulaappv04.R
import com.egeozturk.formulaappv04.util.Constants.avogadroConstant
import com.egeozturk.formulaappv04.util.Constants.bohrRadius
import com.egeozturk.formulaappv04.util.Constants.boltzmannConstant
import com.egeozturk.formulaappv04.util.Constants.constantForGravitationalAccelerationInsidePlanet
import com.egeozturk.formulaappv04.util.Constants.coulombConstant
import com.egeozturk.formulaappv04.util.Constants.diracConstant
import com.egeozturk.formulaappv04.util.Constants.eNumber
import com.egeozturk.formulaappv04.util.Constants.faradayConstant
import com.egeozturk.formulaappv04.util.Constants.gasConstant
import com.egeozturk.formulaappv04.util.Constants.gasConstant100
import com.egeozturk.formulaappv04.util.Constants.gravitationalConstant
import com.egeozturk.formulaappv04.util.Constants.permeabilityOfFreeSpace
import com.egeozturk.formulaappv04.util.Constants.piNumber
import com.egeozturk.formulaappv04.util.Constants.speedOfLight
import com.egeozturk.formulaappv04.util.FormulaFunctions
import kotlin.math.*


class FormulaModel(
    @StringRes val name: Int,
    @StringRes val branch: Int,
    val formulaRule: String,
    val id: Int,
    val variableList: List<Int>,
    private val constant: Double = .0,
    val requiresNull: Boolean = true,
    val noFormula: Boolean = false
    ) {

    var icon : Int = 0
    var color : Color = Color.Black
    //var shadeColor : Color = Color.Black
    var constantString = ""


    init {
        when (branch) {
            R.string.maths -> {
                icon = R.drawable.math_icon
                color = com.egeozturk.formulaappv04.ui.theme.PastelLightBlue
                //shadeColor = com.egeozturk.formulaappv04.ui.theme.PastelLightBlueShadeVariant
            }

            R.string.chemistry -> {
                icon = R.drawable.chemistry_icon
                color = com.egeozturk.formulaappv04.ui.theme.PastelGreen
                //shadeColor = com.egeozturk.formulaappv04.ui.theme.PastelGreenShadeVariant
            }

            R.string.physics -> {
                icon = R.drawable.physics_icon
                color = com.egeozturk.formulaappv04.ui.theme.PastelPurple
                //shadeColor = com.egeozturk.formulaappv04.ui.theme.PastelPurpleShadeVariant
            }
        }

        when (constant) {
            piNumber -> {
                constantString = "π = $constant"
            }
            eNumber -> {
                constantString = "e = $constant"
            }
            gasConstant -> {
                constantString = "R = $constant"
            }
            gasConstant100 -> {
                constantString = "R = $constant"     //birim ekle
            }
            boltzmannConstant -> {
                constantString = "k = 1.380649 × 10⁻²³"
            }
            coulombConstant -> {
                constantString = "k = 8.988 × 10⁹"
            }
            permeabilityOfFreeSpace -> {
                constantString = "μ0 = 4π × 10⁻⁷"
            }
            gravitationalConstant -> {
                constantString = "G = 6.67430 × 10⁻¹¹"
            }
            constantForGravitationalAccelerationInsidePlanet -> {
                constantString = "k = 4π × G ÷ 3"
            }
            diracConstant -> {
                constantString = "ħ = h ÷ 2π = 1.054571817 × 10⁻³⁴"
            }
            bohrRadius -> {
                constantString = "a₀ = 5.29 × 10⁻¹¹"
            }
            speedOfLight -> {
                constantString = "c = 299792458 m/s"
            }
            avogadroConstant -> {
                constantString = "Nₐ = 6.022 × 10²³ mol⁻¹"
            }
            faradayConstant -> {
                constantString = "F = 9.64853321233100184 × 10⁴"
            }
        }
    }

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

        if (number < 2) {
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

        var gcd = 1L
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

    fun calculate(vararg v: Double?): String {
        var nullIndex = -1
        for (i in v) {
            if (i == null) {
                nullIndex = v.indexOf(i)
                break
            }
        }
        println("Null Index: $nullIndex")
        val formulaFunc = FormulaFunctions(v = v, nullIndex = nullIndex, constant = constant)

        when (name) {
            //Maths
            R.string.pythagorean_theorem -> {
                return formulaFunc.pythagoreanTheoremFunction()
            }

            R.string.rectangle_area_formula -> {
                return formulaFunc.rectangleAreaFormulaFunction()
            }

            R.string.circumference_of_circle -> {
                return formulaFunc.circumferenceOfCircleFormulaFunction()
            }

            R.string.area_of_circle -> {
                return formulaFunc.areaOfCircleFormulaFunction()
            }

            R.string.surface_area_of_sphere -> {
                return formulaFunc.surfaceAreaOfSphereFormulaFunction()
            }

            R.string.volume_of_sphere -> {
                return formulaFunc.volumeOfSphereFormulaFunction()
            }

            R.string.sum_of_interior_angles_of_polygons -> {
                return formulaFunc.sumOfInteriorAnglesOfPolygonsFormulaFunction()
            }

            R.string.number_of_diagonals -> {
                return formulaFunc.numberOfDiagonalsFormulaFunction()
            }

            R.string.roots_of_quadratic_equation -> {
                return formulaFunc.rootsOfQuadraticEquationFunction()
            }

            R.string.volume_of_rectangular_prism -> {
                return formulaFunc.volumeOfRectangularPrismFormulaFunction()
            }

            R.string.volume_of_cylinder -> {
                return formulaFunc.volumeOfCylinderFormulaFunction()
            }

            R.string.area_of_triangle -> {
                return formulaFunc.areaOfTriangleFormulaFunction()
            }

            R.string.herons_formula -> {
                return formulaFunc.heronsFormulaFunction()
            }

            R.string.permutation -> {       //set limitations
                return formulaFunc.permutationFunction()
            }

            R.string.combination -> {       //set limitations
                return formulaFunc.combinationFunction()
            }

            R.string.volume_of_pyramid -> {
                return formulaFunc.volumeOfPyramidFormulaFunction()
            }

            R.string.volume_of_cone -> {
                return formulaFunc.volumeOfConeFormulaFunction()
            }

            R.string.surface_area_of_cone -> {
                return formulaFunc.surfaceAreaOfConeFormulaFunction()
            }

            R.string.surface_area_of_rectangular_prism -> {
                return formulaFunc.surfaceAreaOfRectangularPrismFormulaFunction()
            }

            R.string.law_of_cosines -> {
                return formulaFunc.lawOfCosinesFunction()
            }

            R.string.law_of_sines -> {
                return formulaFunc.lawOfSinesFunction()
            }

            R.string.double_angle_formula_for_sine -> {
                return formulaFunc.doubleAngleFormulaForSineFunction()
            }       //yuverlama algoritmasi

            R.string.sum_formula_for_sine -> {
                return formulaFunc.sumFormulaForSineFunction()
            }

            R.string.double_angle_formula_for_cosine -> {
                return formulaFunc.doubleAngleFormulaForCosineFunction()
            }

            R.string.sum_formula_for_cosine -> {
                return formulaFunc.sumFormulaForCosineFunction()
            }

            R.string.double_angle_formula_for_tangent -> {
                return formulaFunc.doubleAngleFormulaForTangentFunction()
            }

            R.string.sum_formula_for_tangent -> {
                return formulaFunc.sumFormulaForTangentFunction()
            }

            R.string.area_of_regular_hexagon -> {
                return formulaFunc.areaOfRegularHexagonFormulaFunction()
            }

            R.string.number_of_subsets_formula -> {
                return formulaFunc.numberOfSubsetFormulaFunction()
            }

            R.string.number_of_proper_subsets_formula -> {
                return formulaFunc.numberOfProperSubsetFormulaFunction()
            }

            R.string.prime_factor_finder -> {
                return formulaFunc.primeFactorFinderFunction()
            }

            R.string.prime_number_checker -> {
                return formulaFunc.primeNumberCheckerFunction()
            }

            R.string.positive_integer_divisor_finder -> {
                return formulaFunc.positiveIntegerDivisorFinder()
            }

            R.string.greatest_common_divisor -> {
                return formulaFunc.greatestCommonDivisorFunction()
            }

            R.string.least_common_multiple -> {
                return formulaFunc.leastCommonMultipleFunction()
            }

            R.string.root_calculator -> {
                return formulaFunc.rootCalculatorFunction()
            }

            R.string.triangle_inequality_calculator -> {

                return formulaFunc.triangleInequalityCalculatorFunction()
            }

            R.string.area_of_equilateral_triangle_formula -> {
                return formulaFunc.areaOfEquilateralTriangleFormulaFunction()
            }

            R.string.factorial_formula -> {
                return formulaFunc.factorialFormulaFunction()
            }

            R.string.cyclic_permutation_formula -> {
                return formulaFunc.cyclicPermutationFormula()
            }

            R.string.second_degree_binomial_expansion -> {
                return formulaFunc.secondDegreeBinomialExpansionFunction()
            }
            R.string.third_degree_binomial_expansion -> {
                return formulaFunc.thirdDegreeBinomialExpansionFunction()
            }
            R.string.second_degree_trinomial_expansion -> {
                return formulaFunc.secondDegreeTrinomialExpansionFunction()
            }
            R.string.factorisation_of_difference_of_two_squares -> {
                return formulaFunc.factorisationOfDifferenceOfTwoSquares()
            }
            R.string.factorisation_of_difference_of_two_cubes -> {
                return formulaFunc.factorisationOfDifferenceOfTwoCubes()
            }
            R.string.factorisation_of_sum_of_two_cubes -> {
                return formulaFunc.factorisationOfSumOfTwoCubesFunction()
            }
            R.string.factorisation_of_sum_of_xn_and_yn -> {
                return formulaFunc.factorisationOfSumOfXnAndYnFunction()
            }
            R.string.factorisation_of_difference_of_xn_and_yn -> {
                return formulaFunc.factorisationOfDifferenceOfXnAndYnFunction()
            }
            R.string.binomial_expansions -> {
                return formulaFunc.binomialExpansionsFunction()
            }
            R.string.interior_angle_of_regular_polygon -> {
                return formulaFunc.interiorAngleOfRegularPolygonFunction()
            }

            R.string.exterior_angle_of_regular_polygon -> {
                return formulaFunc.exteriorAngleOfRegularPolygonFunction()
            }

            R.string.area_of_trapezoid_formula -> {
                return formulaFunc.areaOfTrapezoidFormulaFunction()
            }

            R.string.area_of_parallelogram_formula -> {
                return formulaFunc.areaOfParallelogramFormulaFunction()
            }

            R.string.area_of_square_formula -> {
                return formulaFunc.areaOfSquareFormulaFunction()
            }

            R.string.length_of_space_diagonal_in_rectangular_prism_formula -> {
                return formulaFunc.lengthOfSpaceDiagonalInRectangularPrismFormulaFunction()
            }

            R.string.volume_of_cube_formula -> {
                return formulaFunc.volumeOfCubeFormulaFunction()
            }

            R.string.surface_area_of_cube_formula -> {
                return formulaFunc.surfaceAreaOfCubeFormulaFunction()
            }

            R.string.surface_area_of_cylinder_formula -> {
                return formulaFunc.surfaceAreaOfCylinderFormulaFunction()
            }

            R.string.height_of_regular_tetrahedron_formula -> {
                return formulaFunc.heightOfRegularTetrahedronFormulaFunction()
            }

            R.string.surface_area_of_regular_tetrahedron_formula -> {
                return formulaFunc.surfaceAreaOfRegularTetrahedronFormulaFunction()
            }

            R.string.volume_of_regular_tetrahedron_formula -> {
                return formulaFunc.volumeOfRegularTetrahedronFormulaFunction()
            }

            R.string.radian_degree_converter -> {
                return formulaFunc.radianDegreeConverterFunction()
            }

            R.string.principal_angle_finder -> {
                return formulaFunc.principalAngleFinderFunction()
            }

            R.string.distance_between_two_points_on_the_analytical_plane_formula -> {       //bu teknik olarak 2 sonuc gosterebilir o sebeple duzelt
                return formulaFunc.distanceBetweenTwoPointsOnTheAnalyticalPlaneFormulaFunction()
            }

            R.string.coordinates_of_the_midpoint_of_a_line_segment_formula -> {
                return formulaFunc.coordinatesOfTheMidpointOfALineSegmentFormulaFunction()
            }

            R.string.coordinates_of_the_centroid_of_a_triangle_formula -> {

                return formulaFunc.coordinatesOfTheCentroidOfATriangleFormulaFunction()
            }

            R.string.average_rate_of_change_formula -> {       //bu teknik olarak 2 sonuc gosterebilir o sebeple duzelt
                return formulaFunc.averageRateOfChangeFormulaFunction()
            }


            //Chemistry

            R.string.ideal_gas_law -> {
                return formulaFunc.idealGasLawFunction()
            }

            R.string.kinetic_energy_of_gas -> {
                return formulaFunc.kineticEnergyOfGasFormulaFunction()
            }

            R.string.velocity_of_gas_particles -> {
                //sabiti 100 ile carp
                return formulaFunc.velocityOfGasParticlesFormulaFunction()
            }

            R.string.ideal_gas_law2 -> {
                return formulaFunc.idealGasLaw2Function()
            }

            R.string.boyles_law -> {
                return formulaFunc.boylesLawFunction()
            }

            R.string.charless_law -> {
                return formulaFunc.charlessLawFunction()
            }

            R.string.gay_lussacs_law -> {
                return formulaFunc.gayLussacsLawFunction()
            }

            R.string.avogadros_law -> {
                return formulaFunc.avogadrosLawFunction()
            }

            R.string.number_of_moles_formula -> {
                return formulaFunc.numberOfMolesFormulaFunction()
            }

            R.string.number_of_moles_formula2 -> {
                return formulaFunc.numberOfMolesFormula2Function()
            }

            R.string.atomic_mass_formula -> {
                return formulaFunc.atomicMassFormulaFunction()
            }

            R.string.number_of_moles_formula_for_gases_under_normal_conditions -> {
                return formulaFunc.numberOfMolesFormulaForGasesUnderNormalConditionsFunction()
            }

            R.string.mass_percent_composition_formula -> {
                return formulaFunc.massPercentCompositionFormulaFunction()
            }

            R.string.volume_percent_composition_formula -> {
                return formulaFunc.volumePercentCompositionFormulaFunction()
            }

            R.string.ppm_formula -> {
                return formulaFunc.ppmFormulaFunction()
            }

            R.string.ppb_formula -> {
                return formulaFunc.ppbFormulaFunction()
            }

            R.string.average_kinetic_energy_formula_of_gas_molecules -> {
                return formulaFunc.averageKineticEnergyFormulaOfGasMoleculesFunction()
            }

            R.string.grahams_law_of_diffusion -> {
                return formulaFunc.grahamsLawOfDiffusionFunction()
            }

            R.string.average_velocity_of_gas_molecules_formula -> {
                return formulaFunc.averageVelocityOfGasMoleculesFormulaFunction()
            }

            R.string.diffusion_rate_equation -> {
                return formulaFunc.diffusionRateEquationFunction()
            }

            R.string.partial_pressure_formula -> {
                return formulaFunc.partialPressureFormulaFunction()
            }

            R.string.molarity_formula -> {
                return formulaFunc.molarityFormulaFunction()
            }

            R.string.molality_formula -> {
                return formulaFunc.molalityFormulaFunction()
            }

            R.string.change_of_concentration_equation -> {
                return formulaFunc.changeOfConcentrationEquationFunction()
            }

            R.string.molarity_formula2 -> {
                return formulaFunc.molarityFormula2Function()
            }

            R.string.boiling_point_elevation_formula -> {
                return formulaFunc.boilingPointElevationFormulaFunction()
            }

            R.string.freezing_point_depression_formula -> {
                return formulaFunc.freezingPointDepressionFormulaFunction()
            }

            R.string.enthalpy_formula -> {
                return formulaFunc.enthalpyFormulaFunction()
            }

            R.string.enthalpy_formula2 -> {
                return formulaFunc.enthalpyFormula2Function()
            }

            R.string.reaction_rate_formula -> {
                return formulaFunc.reactionRateFormulaFunction()
            }

            R.string.reaction_rate_formula2 -> {
                return formulaFunc.reactionRateFormula2Function()
            }

            R.string.relationship_between_equilibrium_constants -> {
                return formulaFunc.relationshipBetweenEquilibriumConstantsFunction()
            }

            R.string.nernst_equation -> {
                return formulaFunc.nernstEquationFunction()
            }

            R.string.mass_of_produced_substance_during_electrolysis_formula -> {
                return formulaFunc.massOfProducedSubstanceDuringElectrolysisFormulaFunction()
            }


            //Physics

            R.string.kinetic_energy_formula -> {
                return formulaFunc.kineticEnergyFormulaFunction()
            }

            R.string.gravitational_potential_energy -> {
                return formulaFunc.gravitationalPotentialEnergyFunction()
            }

            R.string.elastic_potential_energy -> {
                return formulaFunc.elasticPotentialEnergyFunction()
            }

            R.string.force_formula -> {
                return formulaFunc.forceFormulaFunction()
            }

            R.string.work_formula -> {
                return formulaFunc.workFormulaFunction()
            }

            R.string.power_formula -> {
                return formulaFunc.powerFormulaFunction()
            }

            R.string.ohms_law -> {
                return formulaFunc.ohmsLawFunction()
            }

            R.string.electric_power_formula -> {
                return formulaFunc.electricPowerFormulaFunction()
            }

            R.string.electric_current_formula -> {
                return formulaFunc.electricCurrentFormulaFunction()
            }

            R.string.electric_field_formula -> {
                return formulaFunc.electricFieldFormulaFunction()
            }
            //for constants add a simplification option
            //0 ile bolmeyi sinirla

            R.string.coulombs_law -> {
                return formulaFunc.coulombsLawFunction()
            }

            R.string.electric_potential_energy -> {
                return formulaFunc.electricPotentialEnergyFunction()
            }

            R.string.electric_field_formula2 -> {
                return formulaFunc.electricFieldFormula2Function()
            }

            R.string.capacitance_formula -> {
                return formulaFunc.capacitanceFormulaFunction()
            }

            R.string.pressure_of_solids -> {
                return formulaFunc.pressureOfSolidsFunction()
            }

            R.string.pressure_of_liquids -> {
                return formulaFunc.pressureOfLiquidsFunction()
            }

            R.string.electric_power_formula2 -> {
                return formulaFunc.electricPowerFormula2Function()
            }

            R.string.resistance_of_conductor -> {
                return formulaFunc.resistanceOfConductorFunction()
            }

            R.string.electric_potential_formula -> {
                return formulaFunc.electricPotentialFormulaFunction()
            }

            R.string.electric_field_between_two_charged_plates -> {
                return formulaFunc.electricFieldBetweenTwoChargedPlatesFunction()
            }

            R.string.force_between_two_charged_plates -> {
                return formulaFunc.forceBetweenTwoChargedPlatesFunction()
            }

            R.string.acceleration_between_two_charged_plates -> {
                return formulaFunc.accelerationBetweenTwoChargedPlatesFunction()
            }

            R.string.transformer_equation-> {
                return formulaFunc.transformerEquationFunction()
            }

            R.string.magnetic_field_of_straight_wires -> {
                return formulaFunc.magneticFieldOfStraightWiresFunction()
            }

            R.string.magnetic_field_of_current_loops-> {
                return formulaFunc.magneticFieldOfCurrentLoopsFunction()
            }

            R.string.magnetic_field_of_solenoids-> {
                return formulaFunc.magneticFieldOfSolenoidsFunction()
            }

            R.string.magnetic_force_of_current_carrying_wires-> {
                return formulaFunc.magneticForceOfCurrentCarryingWiresFunction()
            }

            R.string.lorentz_force_formula-> {
                return formulaFunc.lorentzForceFormulaFunction()
            }

            R.string.radius_of_orbit_of_a_charge_in_magnetic_field -> {
                return formulaFunc.radiusOfOrbitOfAChargeInMagneticFieldFunction()
            }

            R.string.magnetic_flux_formula -> {     //cos90 olunca 0 vermiyor
                return formulaFunc.magneticFluxFormulaFunction()
            }

            R.string.electromagnetic_induction_formula -> {     //cos90 olunca 0 vermiyor
                return formulaFunc.electromagneticInductionFormulaFunction()
            }

            R.string.self_induction_emf_formula -> {     //cos90 olunca 0 vermiyor
                return formulaFunc.selfInductionEmfFormulaFunction()
            }

            R.string.peak_electromotive_force_in_a_generator -> {
                return formulaFunc.peakElectromotiveForceInAGeneratorFunction()
            }

            R.string.relative_motion_formula -> {
                return formulaFunc.relativeMotionFormulaFunction()
            }

            R.string.velocity_formula -> {
                return formulaFunc.velocityFormulaFunction()
            }

            R.string.acceleration_formula -> {
                return formulaFunc.accelerationFormulaFunction()
            }

            R.string.accelerated_motion_formula -> {
                return formulaFunc.acceleratedMotionFormulaFunction()
            }

            R.string.heat_formula -> {
                return formulaFunc.heatFormulaFunction()
            }

            R.string.heat_of_transformation_formula -> {
                return formulaFunc.heatOfTransformationFormulaFunction()
            }

            R.string.hookes_law -> {
                return formulaFunc.hookesLawFunction()
            }

            R.string.linear_velocity_formula -> {
                return formulaFunc.linearVelocityFormulaFunction()
            }

            R.string.linear_velocity_formula_2 -> {
                return formulaFunc.linearVelocityFormula2Function()
            }

            R.string.angular_velocity_formula -> {
                return formulaFunc.angularVelocityFormulaFunction()
            }

            R.string.centripetal_force_formula -> {
                return formulaFunc.centripetalForceFormulaFunction()
            }

            R.string.centripetal_force_formula_2 -> {
                return formulaFunc.centripetalForceFormula2Function()
            }

            R.string.centripetal_acceleration_formula -> {
                return formulaFunc.centripetalAccelerationFormulaFunction()
            }

            R.string.centripetal_acceleration_formula_2 -> {
                return formulaFunc.centripetalAccelerationFormula2Function()
            }

            R.string.min_velo_of_an_object_rotating_in_a_cylinder -> {
                return formulaFunc.minVeloOfAnObjectRotatingInACylinderFunction()
            }

            R.string.velocity_of_waves_formula -> {
                return formulaFunc.velocityOfWavesFormulaFunction()
            }

            R.string.luminous_flux_formula -> {
                return formulaFunc.luminousFluxFormulaFunction()
            }

            R.string.illuminance_formula -> {
                return formulaFunc.illuminanceFormulaFunction()
            }

            R.string.velocity_during_simple_harmonic_motion -> {
                return formulaFunc.velocityDuringSimpleHarmonicMotionFunction()
            }

            R.string.horizontal_velocity_during_simple_harmonic_motion -> {
                return formulaFunc.horizontalVelocityDuringSimpleHarmonicMotionFunction()
            }

            R.string.vertical_velocity_during_simple_harmonic_motion -> {
                return formulaFunc.verticalVelocityDuringSimpleHarmonicMotionFunction()
            }

            R.string.horizontal_velocity_during_simple_harmonic_motion2 -> {
                return formulaFunc.horizontalVelocityDuringSimpleHarmonicMotion2Function()
            }

            R.string.vertical_velocity_during_simple_harmonic_motion2 -> {
                return formulaFunc.verticalVelocityDuringSimpleHarmonicMotion2Function()
            }

            R.string.horizontal_location_during_simple_harmonic_motion -> {
                return formulaFunc.horizontalLocationDuringSimpleHarmonicMotionFunction()
            }

            R.string.vertical_location_during_simple_harmonic_motion -> {
                return formulaFunc.verticalLocationDuringSimpleHarmonicMotionFunction()
            }

            R.string.horizontal_location_during_simple_harmonic_motion2 -> {
                return formulaFunc.horizontalLocationDuringSimpleHarmonicMotion2Function()
            }

            R.string.vertical_location_during_simple_harmonic_motion2 -> {
                return formulaFunc.verticalLocationDuringSimpleHarmonicMotion2Function()
            }

            R.string.horizontal_acceleration_during_simple_harmonic_motion -> {
                return formulaFunc.horizontalAccelerationDuringSimpleHarmonicMotionFunction()
            }

            R.string.vertical_acceleration_during_simple_harmonic_motion -> {
                return formulaFunc.verticalAccelerationDuringSimpleHarmonicMotionFunction()
            }

            R.string.horizontal_acceleration_during_simple_harmonic_motion2 -> {
                return formulaFunc.horizontalAccelerationDuringSimpleHarmonicMotion2Function()
            }

            R.string.vertical_acceleration_during_simple_harmonic_motion2 -> {
                return formulaFunc.verticalAccelerationDuringSimpleHarmonicMotion2Function()
            }

            R.string.horizontal_restoring_force_during_simple_harmonic_motion -> {
                return formulaFunc.horizontalRestoringForceDuringSimpleHarmonicMotionFunction()
            }

            R.string.vertical_restoring_force_during_simple_harmonic_motion -> {
                return formulaFunc.verticalRestoringForceDuringSimpleHarmonicMotionFunction()
            }

            R.string.horizontal_restoring_force_during_simple_harmonic_motion2 -> {
                return formulaFunc.horizontalRestoringForceDuringSimpleHarmonicMotion2Function()
            }

            R.string.vertical_restoring_force_during_simple_harmonic_motion2 -> {
                return formulaFunc.verticalRestoringForceDuringSimpleHarmonicMotion2Function()
            }

            R.string.period_of_spring_pendulum_during_simple_harmonic_motion -> {
                return formulaFunc.periodOfSpringPendulumDuringSimpleHarmonicMotionFunction()
            }

            R.string.period_of_simple_pendulum_during_simple_harmonic_motion -> {
                return formulaFunc.periodOfSimplePendulumDuringSimpleHarmonicMotionFunction()
            }

            R.string.maximum_safe_speed_an_object_can_take_on_a_frictional_turn -> {
                return formulaFunc.maximumSafeSpeedAnObjectCanTakeOnAFrictionalTurnFunction()
            }

            R.string.safe_speed_during_turning_on_an_inclined_and_frictionless_turn -> {
                return formulaFunc.safeSpeedDuringTurningOnAnInclinedAndFrictionlessTurnFunction()
            }

            R.string.safe_speed_during_turning_in_a_cylinder -> {
                return formulaFunc.safeSpeedDuringTurningInACylinderFunction()
            }

            R.string.moment_of_inertia_formula -> {
                return formulaFunc.momentOfInertiaFormulaFunction()
            }

            R.string.moment_of_inertia_of_solid_spheres -> {
                return formulaFunc.momentOfInertiaOfSolidSpheresFunction()
            }

            R.string.moment_of_inertia_of_solid_cylinders -> {
                return formulaFunc.momentOfInertiaOfSolidCylindersFunction()
            }

            R.string.moment_of_inertia_of_disks -> {
                return formulaFunc.momentOfInertiaOfDisksFunction()
            }

            R.string.moment_of_inertia_of_rings -> {
                return formulaFunc.momentOfInertiaOfRingsFunction()
            }

            R.string.moment_of_inertia_of_rods -> {
                return formulaFunc.momentOfInertiaOfRodsFunction()
            }

            R.string.rotational_kinetic_energy_formula -> {
                return formulaFunc.rotationalKineticEnergyFormulaFunction()
            }

            R.string.kinetic_energy_of_a_rotating_object -> {
                return formulaFunc.kineticEnergyOfARotatingObjectFunction()
            }

            R.string.angular_momentum_formula -> {
                return formulaFunc.angularMomentumFormulaFunction()
            }

            R.string.angular_momentum_formula2 -> {
                return formulaFunc.angularMomentumFormula2Function()
            }

            R.string.angular_momentum_formula3 -> {
                return formulaFunc.angularMomentumFormula3Function()
            }

            R.string.torque_formula -> {
                return formulaFunc.torqueFormulaFunction()
            }

            R.string.torque_formula2 -> {
                return formulaFunc.torqueFormula2Function()
            }

            R.string.tangential_acceleration_formula -> {
                return formulaFunc.tangentialAccelerationFormulaFunction()
            }

            R.string.gravitational_force_formula -> {
                return formulaFunc.gravitationalForceFormulaFunction()
            }

            R.string.gravitational_acceleration_formula_above_surface -> {
                return formulaFunc.gravitationalAccelerationFormulaAboveSurfaceFunction()
            }

            R.string.gravitational_acceleration_formula_inside_planet -> {
                return formulaFunc.gravitationalAccelerationFormulaInsidePlanetFunction()
            }

            R.string.gravitational_potential_energy_of_an_orbiting_satellite -> {
                return formulaFunc.gravitationalPotentialEnergyOfAnOrbitingSatelliteFunction()
            }

            R.string.escape_velocity_formula -> {
                return formulaFunc.escapeVelocityFormulaFunction()
            }

            R.string.escape_energy_formula -> {
                return formulaFunc.escapeEnergyFormulaFunction()
            }

            R.string.law_of_periods -> {
                return formulaFunc.lawOfPeriodsFunction()
            }

            R.string.fringe_spacing_formula_double_slit -> {
                return formulaFunc.fringeSpacingFormulaDoubleSlitFunction()
            }

            R.string.fringe_spacing_formula_single_slit -> {
                return formulaFunc.fringeSpacingFormulaSingleSlitFunction()
            }

            R.string.angular_momentum_of_an_orbiting_electron -> {
                return formulaFunc.angularMomentumOfAnOrbitingElectronFunction()
            }

            R.string.orbiting_radius_of_an_electron -> {
                return formulaFunc.orbitingRadiusOfAnElectronFunction()
            }

            R.string.energy_of_electron_in_bohr_orbit -> {
                return formulaFunc.energyOfElectronInBohrOrbitFunction()
            }

            R.string.energy_stored_in_capacitor -> {
                return formulaFunc.energyStoredInCapacitorFunction()
            }

            R.string.energy_stored_in_capacitor2 -> {
                return formulaFunc.energyStoredInCapacitor2Function()
            }

            R.string.capacitance_of_capacitor_formula -> {
                return formulaFunc.capacitanceOfCapacitorFormulaFunction()
            }

            R.string.torque_of_a_current_carrying_loop_in_magnetic_field -> {
                return formulaFunc.torqueOfACurrentCarryingLoopInMagneticFieldFunction()
            }

            R.string.root_mean_square_voltage_formula_sinusoidal_waveform -> {
                return formulaFunc.rootMeanSquareVoltageFormulaSinusoidalWaveformFunction()
            }

            R.string.root_mean_square_voltage_formula_triangle_waveform -> {
                return formulaFunc.rootMeanSquareVoltageFormulaTriangleWaveformFunction()
            }

            R.string.root_mean_square_voltage_formula_square_waveform -> {
                return formulaFunc.rootMeanSquareVoltageFormulaSquareWaveformFunction()
            }

            R.string.root_mean_square_current_formula_sinusoidal_waveform -> {
                return formulaFunc.rootMeanSquareCurrentFormulaSinusoidalWaveformFunction()
            }

            R.string.root_mean_square_current_formula_triangle_waveform -> {
                return formulaFunc.rootMeanSquareCurrentFormulaTriangleWaveformFunction()
            }

            R.string.root_mean_square_current_formula_square_waveform -> {
                return formulaFunc.rootMeanSquareCurrentFormulaSquareWaveformFunction()
            }

            R.string.efficiency_formula -> {
                return formulaFunc.efficiencyFormulaFunction()
            }

            R.string.weight_formula -> {
                return formulaFunc.weightFormulaFunction()
            }

            R.string.friction_force_formula -> {
                return formulaFunc.frictionForceFormulaFunction()
            }

            R.string.velocity_formula_without_time -> {
                return formulaFunc.velocityFormulaWithoutTimeFunction()
            }

            R.string.downward_projectile_motion_height_formula -> {
                return formulaFunc.downwardProjectileMotionHeightFormulaFunction()
            }

            R.string.upward_projectile_motion_height_formula -> {
                return formulaFunc.upwardProjectileMotionHeightFormulaFunction()
            }

            R.string.downward_projectile_motion_velocity_formula -> {
                return formulaFunc.downwardProjectileMotionVelocityFormulaFunction()
            }

            R.string.upward_projectile_motion_velocity_formula -> {
                return formulaFunc.upwardProjectileMotionVelocityFormulaFunction()
            }

            R.string.upward_projectile_motion_flight_time_formula -> {
                return formulaFunc.upwardProjectileMotionFlightTimeFormulaFunction()
            }

            R.string.upward_projectile_motion_maximum_height_formula -> {
                return formulaFunc.upwardProjectileMotionMaximumHeightFormulaFunction()
            }

            R.string.free_fall_height_formula -> {
                return formulaFunc.freeFallHeightFormulaFunction()
            }

            R.string.free_fall_vertical_velocity_formula -> {
                return formulaFunc.freeFallVerticalVelocityFormulaFunction()
            }

            R.string.free_fall_velocity_formula_without_time -> {
                return formulaFunc.freeFallVelocityFormulaWithoutTimeFunction()
            }

            R.string.impulse_formula -> {
                return formulaFunc.impulseFormulaFunction()
            }

            R.string.momentum_formula -> {
                return formulaFunc.momentumFormulaFunction()
            }

            R.string.central_elastic_collision_velocities_equation -> {
                return formulaFunc.centralElasticCollisionVelocitiesEquationFunction()
            }

            R.string.screw_equation -> {
                return formulaFunc.screwEquationFunction()
            }

            R.string.illuminance_formula2 -> {
                return formulaFunc.illuminanceFormula2Function()
            }

            R.string.number_of_images_formula_intersecting_mirrors -> {
                return formulaFunc.numberOfImagesFormulaIntersectingMirrorsFunction()
            }

            R.string.absolute_refractive_index_formula -> {
                return formulaFunc.absoluteRefractiveIndexFormulaFunction()
            }

            R.string.buoyant_force_formula -> {
                return formulaFunc.buoyantForceFormulaFunction()
            }

            R.string.electric_energy_formula -> {
                return formulaFunc.electricEnergyFormulaFunction()
            }

            R.string.total_work_done_formula -> {
                return formulaFunc.totalWorkDoneFormulaFunction()
            }

            R.string.fahrenheit_celsius_converter -> {
                return formulaFunc.fahrenheitCelsiusConverterFunction()
            }

            R.string.heat_conduction_rate_formula -> {
                return formulaFunc.heatConductionRateFormulaFunction()
            }

            R.string.linear_expansion_formula -> {
                return formulaFunc.linearExpansionFormulaFunction()
            }

            R.string.superficial_expansion_formula -> {
                return formulaFunc.superficialExpansionFormulaFunction()
            }

            R.string.volumetric_expansion_formula -> {
                return formulaFunc.volumetricExpansionFormulaFunction()
            }
            R.string.exponential_function_formula -> {
                return formulaFunc.exponentialFunctionFormulaFunction()
            }
            R.string.logarithm_formula -> {
                return formulaFunc.logarithmFormulaFunction()
            }
            R.string.natural_logarithm_formula -> {
                return formulaFunc.naturalLogarithmFormulaFunction()
            }
            R.string.nth_term_of_an_arithmetic_sequence_formula -> {
                return  formulaFunc.rthTermOfAnArithmeticSequenceFormulaFunction()
            }
            R.string.sum_of_the_members_of_an_arithmetic_sequence_formula -> {
                return formulaFunc.sumOfTheMembersOfAnArithmeticSequenceFormulaFunction()
            }
            R.string.nth_term_of_a_geometric_sequence_formula -> {
                return formulaFunc.nthTermOfAGeometricSequenceFormulaFunction()
            }
            R.string.sum_of_the_members_of_a_geometric_sequence_formula -> {
                return formulaFunc.sumOfTheMembersOfAGeometricSequenceFormulaFunction()
            }
            R.string.product_of_the_members_of_a_geometric_sequence_formula -> {
                return formulaFunc.productOfTheMembersOfAGeometricSequenceFormulaFunction()
            }
            R.string.fibonacci_sequence_starting_from_1_term_finder -> {
                return formulaFunc.fibonacciSequenceStartingFrom1TermFinderFunction()
            }
            R.string.nth_power_of_i_calculator -> {
                return formulaFunc.nthPowerOfiCalculatorFunction()
            }
            R.string.rotation_of_a_point_around_origin_formula -> {
                return formulaFunc.rotationOfAPointAroundOriginFormulaFunction()
            }
            R.string.reflection_across_x_axis_formula -> {
                return formulaFunc.reflectionAcrossXAxisFormulaFunction()
            }
            R.string.reflection_across_y_axis_formula -> {
                return formulaFunc.reflectionAcrossYAxisFormulaFunction()
            }
            R.string.reflection_across_yx_formula -> {
                return formulaFunc.reflectionAcrossYXFormulaFunction()
            }
            R.string.reflection_across_y_minusx_formula -> {
                return formulaFunc.reflectionAcrossYminusXFormulaFunction()
            }
            R.string.reflection_across_xa_formula -> {
                return formulaFunc.reflectionAcrossXAFormulaFunction()
            }
            R.string.reflection_across_ya_formula -> {
                return formulaFunc.reflectionAcrossYAFormulaFunction()
            }
            R.string.reflection_over_origin_formula -> {
                return formulaFunc.reflectionOverOriginFormulaFunction()
            }
            R.string.reflection_of_a_line_across_x_axis_formula -> {
                return formulaFunc.reflectionOfALineAcrossXAxisFormulaFunction()
            }
            R.string.reflection_of_a_line_across_y_axis_formula -> {
                return formulaFunc.reflectionOfALineAcrossYAxisFormulaFunction()
            }
            R.string.reflection_of_a_line_across_yx_formula -> {
                return formulaFunc.reflectionOfALineAcrossYXFormulaFunction()
            }
            R.string.reflection_of_a_line_across_y_minusx_formula -> {
                return formulaFunc.reflectionOfALineAcrossYminusXFormulaFunction()
            }
            R.string.reflection_of_a_line_across_xd_formula -> {
                return formulaFunc.reflectionOfALineAcrossXDFormulaFunction()
            }
            R.string.reflection_of_a_line_across_ye_formula -> {
                return formulaFunc.reflectionOfALineAcrossYEFormulaFunction()
            }
            R.string.reflection_of_a_line_over_origin_formula -> {
                return formulaFunc.reflectionOfALineOverOriginFormulaFunction()
            }

        }

        return "NaN"
    }
}