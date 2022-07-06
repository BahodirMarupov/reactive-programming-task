﻿Prerequisites

1. Installed database from list of available: https://spring.io/projects/spring-data-r2dbc#overview
1. Java version 8+
1. Maven
1. Java IDE

Task 1 - ETL process (2 Points)

1. Create data model with following fields:

"id": int, // id of sport

"name": string // sport name

1. Create Reactive Repository
1. Create Setup class with following functionality: 3.1. Requests sports from https://sports.api.decathlon.com/sports 3.2. Parse Json Response using reactive pipelines and save objects using reactive repository

Task 2 - API for Sports (2 Points)

1. Implement the following API methods using Router Functions:
- POST /api/v1/sport/{sportname]} // create sport with name. make sure that you correctly cach exceptions if sport with provided name already exist
- GET /api/v1/sport?q=... //search sports by name
1. Implement methods in reactive repository with methods to support API above

Task 3 - Refactor ETL process using backpressure (1 Point)

1. Modify our ETL implementation to apply backpressure. Tell the upstream to only send 20 elements at a time by using request().
1. Log operations to see that request(20) is calles, followed by 20 onNext() calls, then request(20) again and so on.
