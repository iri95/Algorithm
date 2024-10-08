SELECT ITEM_ID, ITEM_NAME, RARITY
FROM ITEM_INFO join ITEM_TREE
                    USING(ITEM_ID)
WHERE ITEM_ID not in (SELECT DISTINCT PARENT_ITEM_ID as ITEM_ID
                      FROM ITEM_TREE
                      WHERE PARENT_ITEM_ID is not null)
ORDER BY ITEM_ID DESC
