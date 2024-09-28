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
            requirements = requirements.plus(ItemStack(Items.plastanium, 35))
            range *= 1.05f
            shootType.damage *= 0.8f
            reload *= 0.6f

            targetAir = true
            shootType.collidesAir = true
        }
    }
}