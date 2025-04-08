# 🎒 Stadium Storage System

Простая Java-программа для хранения и выдачи вещей по коду, реализованная с использованием `HashMap`. Поддерживает тестирование и модульную архитектуру. Отлично подходит для учебных целей и демонстрации базовых принципов ООП, SOLID и JUnit.

---

## 📦 Возможности

- Сдать вещь по коду
- Получить вещь по коду
- Предотвращение перезаписи (с подтверждением)
- Простая CLI-оболочка
- Модульные юнит-тесты с JUnit 5

---

## 🚀 Как запустить

### 1. Клонируй репозиторий

```bash
git clone https://github.com/your-username/stadium-storage.git
cd stadium-storage
```

2. Запусти приложение
./gradlew run
Или вручную через IDE: запусти StorageApp.java
🧪 Как запустить тесты

./gradlew test
Открой HTML-отчёт по пути:
build/reports/tests/test/index.html
🧱 Структура проекта

stadium-storage/
├── build.gradle
├── settings.gradle
├── src/
│   ├── main/java/stadium/
│   │   ├── StorageApp.java
│   │   └── StorageService.java
│   └── test/java/stadium/
│       └── StorageServiceTest.java
🔧 Требования

Java 17+
Gradle 7+
JUnit 5 (входит через build.gradle)

