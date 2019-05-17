package com.skaggsm.jmumblelink

import io.kotlintest.properties.Gen
import io.kotlintest.properties.assertAll
import io.kotlintest.specs.StringSpec
import org.amshove.kluent.`should equal`

/**
 * Created by Mitchell Skaggs on 5/17/2019.
 */
class MumbleLinkImplTest : StringSpec({
    "Given a link to Mumble, when data is written, then the basic data is persisted correctly"{
        MumbleLinkImpl().use {
            it.uiVersion = 2
            it.uiTick++
            it.name = "Testname"
            it.avatarPosition = floatArrayOf(0f, 0f, 0f)

            it.uiVersion `should equal` 2
            it.uiTick `should equal` 1
            it.name `should equal` "Testname"
            it.avatarPosition `should equal` floatArrayOf(0f, 0f, 0f)
        }
    }

    "Given a link to Mumble, when a name is written, it should be readable"{
        assertAll(Gen.string().map { it + it + it }.filter { it.length <= 255 }) { name: String ->
            MumbleLinkImpl().use {
                it.name = name

                it.name `should equal` name
            }
        }
    }
})
