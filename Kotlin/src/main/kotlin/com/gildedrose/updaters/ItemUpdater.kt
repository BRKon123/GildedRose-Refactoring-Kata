package com.gildedrose.updaters
import com.gildedrose.Item


class ItemUpdater {

    // update using corresponding function
    fun update(item: Item) {
        getUpdater(item).update(item)
    }

    private fun getUpdater(item: Item): BaseUpdater {
        return when (item.name) {
            ItemType.conjured -> ConjuredUpdater()
            ItemType.backstagePass -> BackstagePassUpdater()
            ItemType.agedBrie -> AgedBrieUpdater()
            else -> NormalUpdater()
        }
    }
}