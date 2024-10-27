package org.epam;

public enum Products {
    CLOTHES(100),
    FOODS(100);

    private int maxCount;

    Products(int maxCount) {
        this.maxCount = maxCount;
    }

    public int getMaxCount() {
        return this.maxCount;
    }
}
