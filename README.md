## Chat *(prototype)*
#### Описание
Приложение представляет из себя прототип текстового чата. Используемые сущности: пользователи, группы пользователей и сообщения. У группы имеется один пользователь-администратор, который может удалить группу и все относящиеся к ней сообщения.
#### Техническая информация
REST архитектура (JSON). Вся информация хранится в embedded h2 базе данных. Для реактивности передачи сообщений используется websocket. Есть возможность расширения масштабов реактивности приложения, также мигрируя на websocket в области CRUD групп пользователей.

Вопрос авторизации/аутентификации пользователей не решается в данном прототипе. Для наглядности необходимые параметры пользователя передаются в теле запроса.

В перспективе следует рассмотреть обработку исключений, валидацию и кеширование.

#### Стек технологий
* Spring Boot
* Spring MVC
* Embedded H2 Database
* Spring Data JPA
* Websocket
* Jackson