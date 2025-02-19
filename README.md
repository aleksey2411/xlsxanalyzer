# XlsxAnalyzer

## Запуск приложения

1. Склонируйте репозиторий:

    ```bash
    git clone https://github.com/aleksey2411/xlsxanalyzer.git
    ```

2. Перейдите в директорию проекта:

    ```bash
    cd xlsxanalyzer
    ```

3. Сборка и запуск через Maven:

    Для сборки и запуска приложения используйте команду:

    ```bash
    mvn spring-boot:run
    ```

    Или, если хотите запустить через JAR:

    - Сначала выполните сборку:

        ```bash
        mvn clean package
        ```

    - Затем запустите JAR файл:

        ```bash
        java -jar target/xlsxanalyzer-0.0.1-SNAPSHOT.jar
        ```

4. После успешного запуска приложение будет доступно по следующему адресу:

    - Swagger UI: `http://localhost:8080/swagger-ui/index.html`

