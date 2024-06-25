package com.gildedrose.updaters

import com.gildedrose.Item

class BackstagePassUpdater: BaseUpdater() {

    override fun update(item: Item) {
        item.updateQuality()
        cleanUp(item)
    }

    private fun Item.updateQuality() {
        when {
            sellIn <= 0 -> quality = 0
            sellIn <= 5 -> quality += 3
            sellIn <= 10 -> quality += 2
            else -> quality += 1
        }
    }
}