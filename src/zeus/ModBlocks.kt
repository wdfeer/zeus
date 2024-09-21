package zeus

object ModBlocks {
    init {
        repeat(6) { ArcTurret("arc-$it", it) }
    }
}