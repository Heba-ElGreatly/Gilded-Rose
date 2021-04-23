package com.gildedrose;

public class GildedRoseUpdated {
    Item[] items;

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

        if (checkSellInValue(item) || item.name.equalsIgnoreCase("Conjured Mana Cake")){
            item.quality = item.quality - 2;
        }
        if(item.name.equalsIgnoreCase("Backstage passes to a TAFKAL80ETC concert") && item.sellIn ==0){
            item.quality = 0;
        }
    }

    private void increaseQuality(Item item){

        if(item.sellIn >5 && item.sellIn <11
                && item.name.equalsIgnoreCase("Backstage passes to a TAFKAL80ETC concert")){
            item.quality = item.quality + 2;
        }
        else if (item.name.equalsIgnoreCase("Backstage passes to a TAFKAL80ETC concert")
                && item.sellIn >0 && item.sellIn < 6){
            item.quality = item.quality + 3 ;
        }
        else if (item.name.equalsIgnoreCase("Aged Brie")){
            item.quality = item.quality + 1 ;
        }

    }


    private boolean checkSellInValue(Item item){
        boolean negativeSellIn = false ;
        if(item.sellIn < 0 ){
            negativeSellIn = true;
        }
        return negativeSellIn;
    }

    private void decreaseSellIn(Item item){
        if(!item.name.equalsIgnoreCase("Sulfuras, Hand of Ragnaros")){
            item.sellIn = item.sellIn - 1 ;
        }
    }

    private Item validateQuality(Item item) {
        if (item.quality < 0){
            item.quality =  0;
        }
        if(item.quality > 50){
            item.quality = 50;
        }
        return item;
    }
}
