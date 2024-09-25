package zeus

import mindustry.content.Items
import mindustry.type.ItemStack
import zeus.turrets.arc.AirArc
import zeus.turrets.arc.LandArc
import zeus.turrets.lancer.Lancer

object ModBlocks {
    init {
        (2..4).forEach {
            LandArc(it)
        }

        AirArc(2)

        Lancer("hybrid-lancer") {
            requirements = requirements.plus(ItemStack(Items.plastanium, 25))
            range *= 1.2f

            targetAir = true
            shootType.collidesAir = true
        }
    }
}