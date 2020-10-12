# language: ru
@withdrawal

Функция: Добавление студента в базу данных

  Структура сценария:
    Дано создаём студента c именем <имя>, фамилией <фамилия> и отчеством <отчество>
    Дано создаём соединение с базой данных
    Дано создаём базу данных
    Когда проверяем наличие студента в базе данных
    То добавляем его, если отсутствует
    И закрываем соединение


    Примеры:
      | имя     | фамилия   | отчество       |
      | "Peter" | "Barking" | "Petrovichich" |
      | "Globe" | "Ponk"    | "Penkovich"    |
      | "Henry" | "Zippy"   | "Samplovich"   |