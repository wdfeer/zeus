package zeus

import zeus.turrets.ArcTurret

object ModBlocks {
    init {
        (2..4).forEach {
            ArcTurret("arc-$it", it)
        }
    }
}