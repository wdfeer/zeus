package zeus

import zeus.turrets.ArcTurret

object ModBlocks {
    init {
        (2..3).forEach {
            ArcTurret("arc-$it", it)
        }
    }
}