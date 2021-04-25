package com.gildedrose;

public class GildedRoseUpdated {

    Item[] items;

    public final static String BACKSTAGE_ITEM = "Backstage passes to a TAFKAL80ETC concert";
    public final static String AGED_BRIE = "Aged Brie";
    public final static String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public final static String CONJURED_MANA_CAKE = "Conjured Mana Cake";


    public GildedRoseUpdated(Item[] items) {
        this.items = items;
    }

    public void updateQuality(){

        for(Item item: items) {
            decreaseQuality(item);
            increaseQuality(item);
            decreaseSellIn(item);
            validateQuality(item);
        }

    }

    private void decreaseQuality(Item item){


        if (hasRemainingSellInValue(item) || item.name.equalsIgnoreCase(CONJURED_MANA_CAKE)){
            item.quality = item.quality - 2;
        }
        if((item.name.equalsIgnoreCase(BACKSTAGE_ITEM) && item.sellIn ==0) || (item.name.equalsIgnoreCase(BACKSTAGE_ITEM) && hasRemainingSellInValue(item))){
            item.quality = 0;
        }
    }

    private void increaseQuality(Item item){

        if(item.sellIn >5 && item.sellIn <11
                && item.name.equalsIgnoreCase(BACKSTAGE_ITEM)){
            item.quality = item.quality + 2;
        }
        else if (item.name.equalsIgnoreCase(BACKSTAGE_ITEM)
                && item.sellIn >0 && item.sellIn < 6){
            item.quality = item.quality + 3 ;
        }
        else if (item.name.equalsIgnoreCase(AGED_BRIE) || (item.name.equalsIgnoreCase(BACKSTAGE_ITEM) && item.sellIn > 10)){
            item.quality = item.quality + 1 ;
        }

    }


    private boolean hasRemainingSellInValue(Item item){
        boolean negativeSellIn = false ;
        if(item.sellIn < 0 ){
            negativeSellIn = true;
        }
        if(item.name.equalsIgnoreCase(CONJURED_MANA_CAKE) && item.sellIn < 0){
            item.quality = item.quality - 2;
        }
        return negativeSellIn;
    }

    private void decreaseSellIn(Item item){
        if(!item.name.equalsIgnoreCase(SULFURAS_HAND_OF_RAGNAROS)){
            item.sellIn = item.sellIn - 1 ;
        }
    }

    private Item validateQuality(Item item) {
        if(!item.name.equalsIgnoreCase(SULFURAS_HAND_OF_RAGNAROS)) {
            if (item.quality < 0) {
                item.quality = 0;
            }
            if (item.quality > 50) {
                item.quality = 50;
            }
        }
        return item;
    }
}
