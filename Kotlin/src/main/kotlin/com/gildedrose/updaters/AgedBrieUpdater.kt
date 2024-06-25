package com.gildedrose.updaters

import com.gildedrose.Item

class AgedBrieUpdater: BaseUpdater() {
    override fun update(item: Item) {
        item.updateQuality()
        cleanUp(item)
    }

    private fun Item.updateQuality() {
        when {
            sellIn <= 0 -> quality += 2
            else -> quality += 1
        }
    }
}