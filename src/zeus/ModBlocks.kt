package zeus

import zeus.turrets.ArcTurret

object ModBlocks {
    init {
        2.let {
            ArcTurret("arc-$it", it)
        }
    }
}