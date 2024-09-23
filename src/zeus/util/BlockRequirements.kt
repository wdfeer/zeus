package zeus.util

import mindustry.type.Item
import mindustry.type.ItemStack

fun createRequiredStacks(items: List<Pair<Item, Int>>): Array<ItemStack> =
    ItemStack.with(*items.flatMap { listOf(it.first, it.second) }.toTypedArray())