package com.gildedrose

import com.gildedrose.updaters.ItemUpdater

class GildedRose(var items: List<Item>) {

    fun updateQuality() {

        val itemUpdater = ItemUpdater()
        for (i in items.indices) {
            itemUpdater.update(items[i])
        }
    }

}

