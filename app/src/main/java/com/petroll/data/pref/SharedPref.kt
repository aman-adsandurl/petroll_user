package com.petroll.data.pref

import com.chibatching.kotpref.KotprefModel

object SharedPref : KotprefModel() {

    var fcmToken by nullableStringPref()
    var authToken by nullableStringPref()

    var isLogin by booleanPref(default = false)
    var profileStatus by booleanPref(default = false)

    var languageCode by stringPref("en")

    var isIntroShown by booleanPref(default = false)

    fun clearPref() {
//        doAsync { FirebaseMessaging.getInstance().deleteToken() }
        val introFlag = isIntroShown
        clear()
        isIntroShown = introFlag
    }
}