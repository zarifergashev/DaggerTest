package com.example.mruzbek.daggertest.network.pojos

/**
 * Created by mruzbek on 4/20/18.
 */

class WeatherPojoClass(
        var coord: Coord? = null,
        var weather: Array<Weather>? = null,
        var base: String? = null,
        var main: Main? = null,
        var wind: Wind? = null,
        var clouds: Clouds? = null,
        var dt: Long = 0,
        var sys: Sys? = null,
        var id: Long = 0,
        var name: String? = null,
        var code: Int = 0
)