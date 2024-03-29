# KPO_HW2

Как пользоваться программой?
При запуске программы пользователь видит страницу регистрации, где требуется ввести логин, email и пароль. После успешной регистрации открывается страница с авторизацией, и данные пользователя добавляются в базу данных SQLite. При успешной авторизации пользователь попадает на страницу с меню, где заранее добавлены блюда, из которых можно выбирать.
Для регистрации в роли администратора необходимо добавить "_ad" в конце логина. После успешной авторизации администратору открывается страница с актуальным меню, где он может управлять блюдами.
При нажатии кнопки "Добавить блюдо" администратору открывается страница, где он может указать данные нового блюда. После успешного добавления он получает уведомление и возвращается на страницу с меню.
При нажатии кнопки "Статистика" пользователь видит страницу со статистикой, включая итоговую выручку, среднюю оценку блюд и другие параметры.
После авторизации у пользователя открывается страница с меню, где можно добавлять или удалять блюда из заказа. Затем пользователь может нажать "Завершить", чтобы перейти к странице с подробной информацией о заказе, включая итоговую сумму к оплате и время ожидания.
После этого пользователь может оценить блюда, оплатить или отменить заказ. На странице также присутствует кнопка "Обновить", чтобы обновить данные о заказе. При нажатии на список заказа пользователь может написать отзыв и поставить оценку блюду.
Также на странице присутствует текст, при нажатии на который пользователь возвращается на страницу с меню для добавления ещё блюд в свой заказ.
Использованные паттерны проектирования:
Изначально планировалось реализовать два паттерна проектирования: Singleton и Observer. Однако, в ходе разработки было решено использовать только Singleton, так как он позволил упростить код и обеспечить нужный функционал.
