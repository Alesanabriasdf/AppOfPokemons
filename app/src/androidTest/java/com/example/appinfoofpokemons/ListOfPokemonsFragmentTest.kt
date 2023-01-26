package com.example.appinfoofpokemons

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.clearText
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.appinfoofpokemons.view.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ListOfPokemonsFragmentTest {

    //testeado exitosamente en un emulador Pixel 2 XL API 28
    //recordar desactivar las animaciones desde las opciones de desarrollador del dispositivo

    @Rule
    @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testNoPokemonsFoundTextViewShow() {
        onView(withId(R.id.edit_text_search))
            .perform(typeText("2"))

        Espresso.closeSoftKeyboard()

        onView(withId(R.id.tv_no_info)).check(matches(withText("No encontramos pokemons con ese nombre...")))
    }

    @Test
    fun testNoPokemonsFoundTextViewGoAway() {
        onView(withId(R.id.edit_text_search))
            .perform(typeText("2"))

        Espresso.closeSoftKeyboard()

        onView(withId(R.id.edit_text_search))
            .perform(clearText())

        onView(withId(R.id.tv_no_info)).check(matches(withText("")))
    }

}