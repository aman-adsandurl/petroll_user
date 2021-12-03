package com.petroll.data.network

import com.petroll.BuildConfig

const val DOMAIN = BuildConfig.B

const val API_BASE_URL = DOMAIN.plus(BuildConfig.S)

const val DEVICE_TYPE = "A" // Android, iOS
const val TIME_OUT = 180L