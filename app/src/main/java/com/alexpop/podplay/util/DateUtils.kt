package com.alexpop.podplay.util

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
        fun jsonDateToShortDate(jsonData: String?): String{
            if (jsonData ==null){
                return "-"
            }
            val inFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            val date = inFormat.parse(jsonData)
            val outputFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault())

            return outputFormat.format(date)
        }
    }