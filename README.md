# E-commerce-platform
Spring boot application for E commerce Platform

This application offers APIs to perform CRUD operations for items
Listing down the APIs provided.

## Item Resource
#### Get Item with ItemId (GET v1/item/{itemId})
With this end point we can fetch item details for a particular itemId

#### Add Item (POST v1/item/addItem)
With this end point we can add item with details like price, name and available stock

#### Update Item (PUT v1/item/updateItem)
With this end point we can update item details such as name, stock and price.

#### Delete Item (DELETE v1/item/delete)
With this end point we can delete item from the itinerary

#### Get All Items(GET v1/item/getAllItems)
With this end point we can list down all items present in the itinerary


## Order Resource

#### Get order with orderId (GET v1/order/{orderId})
With this end point we can fetch order details for a particular orderId

#### Get All Orders(GET v1/order/fetchAllOrders)
With this end point we can list down all orders present in the itinerary

#### Place single order(POST v1/order/postSingleOrder)
With this end point we can place single order for particular items present in the itinerary

#### Place Bulk order(POST v1/order/postBulkOrder)
With this end point we can place bulk order for various items present in the itinerary
