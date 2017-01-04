# `Postal fee calculator microservice`

 - **FAST**

 - **FREE**

 - **PRECISE**

 - **EASY TO USE**

--------------------------------------------------------
>_**Overview**_

Easy to use postal free calculator for webshops.
Based on the addresses, this microservice calculates
the expected postal fee, so that you can inform your
customers.

--------------------------------------------------------
>_**Example**_

Create a URL:

    http://127.0.0.1:9999/api?target=Karancslapújtő&webshop=Baktalórántháza
    
Your only job is to extract the name of the city
from the customers address (in this case: 
Karancslapújtő). Also add the city of
your webshop's base (Baktalórántháza).

Send a get request to the microservice, and you
will get  JSON response, in the following formula:

    {"cost": "3.0 $", "status": "Completed"}

In case you forgot to add a parameter, the following
JSON will be sent back by the API:

    {"cost": "Could not calculate", "status": "Missing parameters"}

In case you added a city, that does not exist, the
API will send you a pretty straightforward answer:

    {"cost": "Could not calculate", "status": "Invalid parameters"}

In any case ther response will only contain strings.
