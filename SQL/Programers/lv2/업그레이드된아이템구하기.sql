SELECT I.ITEM_ID ITEM_ID, I.ITEM_NAME, I.RARITY
FROM ITEM_INFO I JOIN (SELECT T2.ITEM_ID, I2.RARITY
                       FROM ITEM_INFO I2 JOIN ITEM_TREE T2
                                              ON I2.ITEM_ID = T2.PARENT_ITEM_ID) T
                      ON I.ITEM_ID = T.ITEM_ID
WHERE T.RARITY = "RARE"
ORDER BY 1 DESC