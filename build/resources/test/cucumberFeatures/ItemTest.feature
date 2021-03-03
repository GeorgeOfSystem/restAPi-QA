Feature: Item

@Item
Scenario:As admin user
         I want to create, update and delete a project
         So that i am able to manipulate the project

  Given Access to Todo.ly
  When I send a POST request to url  https://todo.ly/api/items.json with json
  """
  {
    "Content": "Item de prueba"
  }
  """

  Then I hope the status code be 200
  And I hope the Content of the project be "Item de prueba"

