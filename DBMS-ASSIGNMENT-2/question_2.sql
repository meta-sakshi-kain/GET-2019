USE StoreFront;
#products which are Active and recently added products should be at top.
SELECT 
    PRODUCT.PRODUCT_ID,
    PRODUCT.NAME AS PRODUCT_TITLE,
    CATEGORY.NAME AS CATEGORY_TITLE,
    PRODUCT.PRICE
FROM
    PRODUCT,
    CATEGORY
WHERE
    PRODUCT.CATEGORY_ID = CATEGORY.CATEGORY_ID
ORDER BY PRODUCT.PRODUCT_ID DESC ;

# the list of products which don't have any images.
SELECT 
    NAME AS PRODUCT_TITLE
FROM
    PRODUCT
WHERE
    IMAGE IS NULL;

#Display all Id, Title and Parent Category Title for all the Categories listed, 
#sorted by Parent Category Title and then Category Title.
#If Category is top category then Parent Category Title column should display “Top Category” as value
SELECT 
    Category1.CATEGORY_ID AS ID,
    Category1.NAME AS CATEGORY_TITLE,
    IFNULL(Category2.NAME, 'Top Category') AS PARENT_CATEGORY
FROM
    CATEGORY Category1
        LEFT JOIN
    CATEGORY Category2 ON Category1.PARENT_CATEGORY = Category2.CATEGORY_ID
ORDER BY Category2.name,Category1.NAME;


#categories which are not parent of any other category
SELECT 
    Category1.CATEGORY_ID AS ID,
    Category1.NAME AS CATEGORY_TITLE,
    Category2.NAME AS PARENT_CATEGORY
FROM
    CATEGORY Category1
        LEFT JOIN
    CATEGORY Category2 ON Category1.PARENT_CATEGORY = Category2.CATEGORY_ID
WHERE
    Category1.CATEGORY_ID NOT IN (SELECT 
        PARENT_CATEGORY
    FROM
        CATEGORY
    WHERE
        PARENT_CATEGORY IS NOT NULL);
        
        
#Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)
SELECT 
    product.PRODUCT_ID AS ID,
    product.PRICE,
    product.NAME AS PRODUCT_TITLE,
    Category.name AS CATEGORY_NAME
FROM
    PRODUCT product
        LEFT JOIN
    CATEGORY Category ON Category.CATEGORY_ID = product.CATEGORY_ID
WHERE
    Category.NAME IN ('MOBILE') ;
    
    
#the list of Products whose Quantity on hand (Inventory) is under 50.
SELECT 
    p.NAME
FROM
    inventory i
        LEFT JOIN
    product p ON p.product_id = i.product_id
WHERE
    QUANTITY_in_stock <= 50;
