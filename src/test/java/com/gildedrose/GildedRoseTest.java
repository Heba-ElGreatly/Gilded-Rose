package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void decreaseQualityByTwoForNormalItems(){
        Item[] items = new Item[]{new Item("Elixir of the Mongoose", -1, 7)};
//        GildedRose app = new GildedRose(items);
        GildedRoseUpdated app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(5, items[0].quality);
    }

    @Test
    void decreaseQualityByTwoIfItemIsAgedBrie(){
        Item[] items = new Item[]{new Item("Conjured Mana Cake", -1, 4)};
//        GildedRose app = new GildedRose(items);
        GildedRoseUpdated app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(2, items[0].quality);
    }

    @Test
    void IncreaseQualityIfItemIsAgedBrie(){
        Item[] items = new Item[]{new Item("Aged Brie", 5, 49)};
//        GildedRose app = new GildedRose(items);
        GildedRoseUpdated app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(50, items[0].quality);
    }

    @Test
    void increaseQualityByOneIfItemIsAgedBrie(){
        Item[] items = new Item[]{new Item("Aged Brie", 0, 7)};
//        GildedRose app = new GildedRose(items);
        GildedRoseUpdated app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(8, items[0].quality);
    }

    @Test
    void increaseQualityByTwoIfItemIsBackStageAndSellInValueLessThan10(){
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 6, 7)};
//        GildedRose app = new GildedRose(items);
        GildedRoseUpdated app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(9, items[0].quality);
    }

    @Test
    void increaseQualityByThreeIfItemIsBackStageAndSellInValueLessThanFive(){
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 1, 7)};
//        GildedRose app = new GildedRose(items);
        GildedRoseUpdated app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(10, items[0].quality);
    }


    @Test
    void itemQualityIsNeverBeMoreThanFifty(){
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 1, 48)};
//        GildedRose app = new GildedRose(items);
        GildedRoseUpdated app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(50, items[0].quality);
    }

    @Test
    void increaseQualityByThreeIfItemIsBackStage(){
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 7)};
//        GildedRose app = new GildedRose(items);
        GildedRoseUpdated app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(9, items[0].quality);
    }

    @Test
    void itemQualityNeverBeNegative(){
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", -1, 20)};
//        GildedRose app = new GildedRose(items);
        GildedRoseUpdated app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(0, items[0].quality);
    }

    @Test
    void increaseQualityByOneIfItemIsBackStageAndSellInValueIsGreaterThanTen(){
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20)};
//        GildedRose app = new GildedRose(items);
        GildedRoseUpdated app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(21, items[0].quality);
    }

    @Test
    void sulfurasQualityShouldNotBeChanged(){
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 1, 80)};
//        GildedRose app = new GildedRose(items);
        GildedRoseUpdated app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(80, items[0].quality);
    }

    @Test
    void sulfurasSellInShouldNotBeChanged(){
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 1, 80)};
//        GildedRose app = new GildedRose(items);
        GildedRoseUpdated app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(1, items[0].sellIn);
    }

    @Test
    void sulfurasQualityNeverBeDecreased(){
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 5, 80)};
//        GildedRose app = new GildedRose(items);
        GildedRoseUpdated app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(80, items[0].quality);
    }

}
