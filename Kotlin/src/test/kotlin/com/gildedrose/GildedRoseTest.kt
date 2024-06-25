package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class GildedRoseTest {

    // Helper function to create GildedRose instance and update quality
    private fun updateQualityFor(items: List<Item>) {
        val app = GildedRose(items)
        app.updateQuality()
    }

    @Test
    fun `Backstage passes decrement sellIn by 1`() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 15, 20))
        updateQualityFor(items)
        assertEquals(14, items[0].sellIn)
    }

    @Test
    fun `Backstage passes quality increases by 1 when sellIn is greater than 10`() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 15, 20))
        updateQualityFor(items)
        assertEquals(21, items[0].quality)
    }

    @Test
    fun `Backstage passes quality increases by 2 when sellIn is 10 or less`() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 10, 20))
        updateQualityFor(items)
        assertEquals(22, items[0].quality)
    }

    @Test
    fun `Backstage passes quality increases by 3 when sellIn is 5 or less`() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 5, 20))
        updateQualityFor(items)
        assertEquals(23, items[0].quality)
    }

    @Test
    fun `Backstage passes quality drops to 0 after the concert`() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 0, 20))
        updateQualityFor(items)
        assertEquals(0, items[0].quality)
    }

    @Test
    fun `Sulfuras does not change sellIn or quality`() {
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", 0, 80))
        updateQualityFor(items)
        assertEquals(0, items[0].sellIn)
        assertEquals(80, items[0].quality)
    }

    @Test
    fun `Normal items decrement sellIn by 1`() {
        val items = listOf(Item("Elixir of the Mongoose", 5, 7))
        updateQualityFor(items)
        assertEquals(4, items[0].sellIn)
    }

    @Test
    fun `Normal items decrement quality by 1`() {
        val items = listOf(Item("Elixir of the Mongoose", 5, 7))
        updateQualityFor(items)
        assertEquals(6, items[0].quality)
    }

    @Test
    fun `Normal items decrement quality by 2 after sellIn date`() {
        val items = listOf(Item("Dexterity Vest", 0, 10))
        updateQualityFor(items)
        assertEquals(8, items[0].quality)
    }

    @Test
    fun `Aged Brie increases in quality`() {
        val items = listOf(Item("Aged Brie", 2, 10))
        updateQualityFor(items)
        assertEquals(11, items[0].quality)
    }

    @Test
    fun `Aged Brie quality does not exceed 50`() {
        val items = listOf(Item("Aged Brie", 2, 50))
        updateQualityFor(items)
        assertEquals(50, items[0].quality)
    }

    @Test
    fun `Conjured items degrade in quality twice as fast`() {
        val items = listOf(Item("Conjured Mana Cake", 3, 6))
        updateQualityFor(items)
        assertEquals(4, items[0].quality)
    }

    @Test
    fun `Conjured items degrade in quality four times as fast after sellIn date`() {
        val items = listOf(Item("Conjured Mana Cake", -2, 6))
        updateQualityFor(items)
        assertEquals(2, items[0].quality)
    }

    @Test
    fun `Quality of an item is never negative`() {
        val items = listOf(Item("+5 Dexterity Vest", 10, 0))
        updateQualityFor(items)
        assertEquals(0, items[0].quality)
    }

    @Test
    fun `Quality of an item is never more than 50 except Sulfuras`() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 9, 49))
        updateQualityFor(items)
        assertEquals(50, items[0].quality)
    }

    @Test
    fun `Legendary items like Sulfuras have quality of 80`() {
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", 0, 80))
        updateQualityFor(items)
        assertEquals(80, items[0].quality)
    }
}


