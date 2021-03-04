Feature: Item
  @Item
  Scenario: As admin user I want to create, read, update and delete a Item So that i am able to manipulate the Item
    Given Access to Item Todo.ly

    #Create an Item (POST)
    When I send a POST requests to url http://todo.ly/api/items.json with json
    """
    {
    "Content": "Item de prueba"
    }
    """
    Then I hope the status code be 200
    And I extract the Id to save on ID_Item
    And I hope the response body be
    """
    {
    "Id": ID_Item,
    "Content": "Item de prueba",
    "ItemType": 1,
    "Checked": false,
    "ProjectId": null,
    "ParentId": null,
    "Path": "",
    "Collapsed": false,
    "DateString": null,
    "DateStringPriority": 0,
    "DueDate": "",
    "Recurrence": null,
    "ItemOrder": IGNORE,
    "Priority": 4,
    "LastSyncedDateTime": "IGNORE",
    "Children": [

    ],
    "DueDateTime": IGNORE,
    "CreatedDate": "IGNORE",
    "LastCheckedDate": IGNORE,
    "LastUpdatedDate": "IGNORE",
    "Deleted": false,
    "Notes": "",
    "InHistory": false,
    "SyncClientCreationId": null,
    "DueTimeSpecified": true,
    "OwnerId": 676934
    }
    """

    #Read an Item (GET)
    When I send a GET request to url http://todo.ly/api/items.json with json
    """
    
    """
    Then I hope the status code be 200

    #Update an Item (PUT)
    When I send a PUT request to url http://todo.ly/api/items/ID_Item.json with json
    """
    {
    "Content": "Item de prueba Modificado"
    }
    """
    Then I hope the status code be 200
    And I hope the response body be
    """
{
    "Id": ID_Item,
    "Content": "Item de prueba Modificado",
    "ItemType": 1,
    "Checked": false,
    "ProjectId": null,
    "ParentId": null,
    "Path": "",
    "Collapsed": false,
    "DateString": null,
    "DateStringPriority": 0,
    "DueDate": "",
    "Recurrence": null,
    "ItemOrder": null,
    "Priority": 4,
    "LastSyncedDateTime": "IGNORE",
    "Children": [

    ],
    "DueDateTime": null,
    "CreatedDate": "IGNORE",
    "LastCheckedDate": null,
    "LastUpdatedDate": "IGNORE",
    "Deleted": false,
    "Notes": "",
    "InHistory": false,
    "SyncClientCreationId": null,
    "DueTimeSpecified": true,
    "OwnerId": 676934
    }
    """

    #Delete an Item (DELETE)
    When I send a DELETE request to url http://todo.ly/api/items/ID_Item.json with json
    """

    """
    Then I hope the status code be 200
    And I hope the response body be
    """
    {
    "Id": ID_Item,
    "Content": "Item de prueba Modificado",
    "ItemType": 1,
    "Checked": false,
    "ProjectId": null,
    "ParentId": null,
    "Path": "",
    "Collapsed": false,
    "DateString": null,
    "DateStringPriority": 0,
    "DueDate": "",
    "Recurrence": null,
    "ItemOrder": null,
    "Priority": 4,
    "LastSyncedDateTime": "IGNORE",
    "Children": [

    ],
    "DueDateTime": null,
    "CreatedDate": "IGNORE",
    "LastCheckedDate": null,
    "LastUpdatedDate": "IGNORE",
    "Deleted": true,
    "Notes": "",
    "InHistory": false,
    "SyncClientCreationId": null,
    "DueTimeSpecified": true,
    "OwnerId": 676934
    }
    """