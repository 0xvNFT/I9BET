package com.i9betstoryphat.i9bet.utils

import com.i9betstoryphat.i9bet.data.Content
import com.i9betstoryphat.i9bet.data.LoginPhone
import com.orhanobut.hawk.Hawk

object AppUtils {

    private const val login = "LOGIN_PHONE"
    private const val love = "LOVE_STORY"
    fun saveLogin(item: LoginPhone) {
        Hawk.put(login, item)
    }

    fun getLogin(): LoginPhone? {
        return Hawk.get(login)
    }

    fun saveLoveStory(list: ArrayList<Content>) {
        Hawk.put(love, list)
    }

    fun getLoveStory(): ArrayList<Content>? {
       return Hawk.get(love)
    }
}