package zeus

object ModBlocks {
    init {
        (2..9).forEach {
            ArcTurret("arc-$it", it)
        }
    }
}