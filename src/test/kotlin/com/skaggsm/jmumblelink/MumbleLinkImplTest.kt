package com.skaggsm.jmumblelink

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.filter
import io.kotest.property.arbitrary.map
import io.kotest.property.arbitrary.string
import io.kotest.property.checkAll

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

            it.uiVersion shouldBe 2
            it.uiTick shouldBe 1
            it.name shouldBe "Testname"
            it.avatarPosition shouldBe floatArrayOf(0f, 0f, 0f)
        }
    }

    "Given a link to Mumble, when a name is written, it should be readable"{
        checkAll(Arb.string().map { it + it + it }.filter { it.length <= 255 }) { name: String ->
            MumbleLinkImpl().use {
                it.name = name

                it.name shouldBe name
            }
        }
    }
})
