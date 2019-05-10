# Deboggler Back End
Spring Boot RPC Application that employs the Deboggler Engine to remotely solve your Boggle needs


### How to interact with the Deboggler Back End
The Deboggler Back End has only one endpoint: ``https://deboggler-rpc-app.herokuapp.com/words``.<br>
You can send ``POST`` requests (using an application like [Postman](https://www.getpostman.com/)) with JSON bodies in the following form:
```
{
  "scoringSystem": "original",
  "letterInputs": [
          {
            "letter": "h",
            "value": 3,
            "modifier": "none"
          },
          {
            "letter": "o",
            "value": 3,
            "modifier": "none"
          },
          {
            "letter": "p",
            "value": 3,
            "modifier": "none"
          },
          {
            "letter": "e",
            "value": 3,
            "modifier": "none"
          }]
  }
```
Currently the only acceptable values for ``scoringSystem`` are
* ``original`` corresponding to the scoring system used in the original Boggle game
* ``with friends`` corresponding to the scoring system used in Boggle With Friends (mobile game)<br>

``letterInputs`` takes an array of JSON letter objects with the following values:
* ``letter``: A single alphabetic character ('qu' being the exception)
* ``value``: An integer value representing how many points the letter is worth. Zero and negative integers are allowed.
* ``modifier``: This value represents a modifier associated with the letter (a la Scrabble). Currently the only acceptable values are:
``none`` (no multiplier), ``dl`` (double letter), ``dw`` (double word), ``tl`` (triple letter), and ``tw`` (triple word)><br>

The number of JSON letter objects in the array ``letterInputs`` must be a perfect square (4, 9, 16, etc.) because ``letterInputs``
represents a square grid of letters. The minimum length of the ``letterInputs`` array is 4 (a 2x2 grid of letters).
