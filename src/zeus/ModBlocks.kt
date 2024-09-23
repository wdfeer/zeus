package zeus

import zeus.turrets.AirArc
import zeus.turrets.LandArc

object ModBlocks {
    init {
        (2..4).forEach {
            LandArc(it)
        }

        AirArc(2)
    }
}