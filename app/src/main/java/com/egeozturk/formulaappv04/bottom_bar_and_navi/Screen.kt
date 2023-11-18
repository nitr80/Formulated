package com.egeozturk.formulaappv04.bottom_bar_and_navi

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.egeozturk.formulaappv04.R

sealed class Screen(
    val route: String,
    @StringRes val title: Int,
    @DrawableRes val icon1 : Int? = null,
    @DrawableRes val icon2 : Int? = null
) {

    object Home : Screen("home", R.string.home_page, R.drawable.home_icon_focused, R.drawable.home_icon_unfocused)
    object Formula : Screen("formula", R.string.search_page, R.drawable.search_button_focused_v2, R.drawable.search_button_unfocused)
    object List : Screen("list", R.string.lists_page, R.drawable.list_icon_focused, R.drawable.list_icon_unfocused)
    object Calculator : Screen("calculator", R.string.calculate_page, R.drawable.calculator_icon_focused, R.drawable.calculator_icon_unfocused)
    //object Profile : Screen("profile", R.string.profile_page, icon = R.drawable.profileicon)
    object UnitConversion : Screen("unit_conversion", R.string.unit_conversion)
    object ToolList: Screen("tool_list", R.string.tool_list)
    object Solution: Screen("solution", R.string.solution)   //formul ve hesaplamasi
    object FormulaListInListScreen: Screen("formula_list_in_list_screen", R.string.formula_list_in_list_screen)
    object AddList: Screen("add_list", R.string.add_list)
    object Info: Screen("info", R.string.info)           //formul bilgisi
    object AddFormulaForNewList: Screen("add_formula_for_new_list", R.string.add_formula_for_new_list)
    object AddToList: Screen("add_to_list", R.string.add_to_list)
    object Subscription: Screen("settings", R.string.subscription)

}