package net.aspw.client.features.module.modules.client

import net.aspw.client.features.module.Module
import net.aspw.client.features.module.ModuleCategory
import net.aspw.client.features.module.ModuleInfo
import net.aspw.client.value.ListValue

import net.minecraft.util.ResourceLocation
import java.util.*

@ModuleInfo(name = "Cape", category = ModuleCategory.CLIENT, array = false)
class Cape : Module() {

    val styleValue = ListValue(
        "Style",
        arrayOf(
            "None",
            "NewNightX",
            "OldNightX",
            "Infinity",
            "As",
            "Defoko1",
            "Defoko2",
            "Defoko3",
            "Defoko4",
            "Funny",
            "Astolfo",
            "Exhibition",
            "Novoline",
            "Dortware",
            "Nuta",
            "Moon",
            "Rise1",
            "Rise2",
            "Tenacity",
            "FDP",
            "Lunar",
            "Minecon2011",
            "Minecon2012",
            "Minecon2013",
            "Minecon2015",
            "Minecon2016",
            "Migrator",
            "Vanilla"
        ),
        "NewNightX"
    )

    private val capeCache = hashMapOf<String, CapeStyle>()
    fun getCapeLocation(value: String): ResourceLocation {
        if (capeCache[value.uppercase(Locale.getDefault())] == null) {
            try {
                capeCache[value.uppercase(Locale.getDefault())] =
                    CapeStyle.valueOf(value.uppercase(Locale.getDefault()))
            } catch (e: Exception) {
                capeCache[value.uppercase(Locale.getDefault())] = CapeStyle.NONE
            }
        }
        return capeCache[value.uppercase(Locale.getDefault())]!!.location
    }

    enum class CapeStyle(val location: ResourceLocation) {
        NONE(ResourceLocation("client/cape/none.png")),
        NEWNIGHTX(ResourceLocation("client/cape/newnightx.png")),
        OLDNIGHTX(ResourceLocation("client/cape/oldnightx.png")),
        INFINITY(ResourceLocation("client/cape/infinity.png")),
        AS(ResourceLocation("client/cape/as.png")),
        DEFOKO1(ResourceLocation("client/cape/defoko1.png")),
        DEFOKO2(ResourceLocation("client/cape/defoko2.png")),
        DEFOKO3(ResourceLocation("client/cape/defoko3.png")),
        DEFOKO4(ResourceLocation("client/cape/defoko4.png")),
        FUNNY(ResourceLocation("client/cape/funny.png")),
        ASTOLFO(ResourceLocation("client/cape/astolfo.png")),
        EXHIBITION(ResourceLocation("client/cape/exhibition.png")),
        NOVOLINE(ResourceLocation("client/cape/novoline.png")),
        DORTWARE(ResourceLocation("client/cape/dortware.png")),
        NUTA(ResourceLocation("client/cape/nuta.png")),
        MOON(ResourceLocation("client/cape/moon.png")),
        RISE1(ResourceLocation("client/cape/rise1.png")),
        RISE2(ResourceLocation("client/cape/rise2.png")),
        TENACITY(ResourceLocation("client/cape/tenacity.png")),
        FDP(ResourceLocation("client/cape/fdp.png")),
        LUNAR(ResourceLocation("client/cape/lunar.png")),
        MINECON2011(ResourceLocation("client/cape/2011.png")),
        MINECON2012(ResourceLocation("client/cape/2012.png")),
        MINECON2013(ResourceLocation("client/cape/2013.png")),
        MINECON2015(ResourceLocation("client/cape/2015.png")),
        MINECON2016(ResourceLocation("client/cape/2016.png")),
        MIGRATOR(ResourceLocation("client/cape/migrator.png")),
        VANILLA(ResourceLocation("client/cape/vanilla.png"))
    }

    override val tag: String
        get() = styleValue.get()

    init {
        state = true
    }
}