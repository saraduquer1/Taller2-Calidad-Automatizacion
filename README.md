# Automatización OrangeHRM - Sección My Info

## Descripción
Proyecto de automatización de pruebas para la sección "My Info" de OrangeHRM Demo usando el patrón Screenplay con Serenity BDD.

## Tecnologías
- **Java 21**
- **Serenity BDD 4.2.1**
- **Cucumber** para BDD
- **Gradle** como gestor de dependencias
- **Selenium WebDriver** para automatización web
- **Patrón Screenplay** para arquitectura de pruebas

## URL de Pruebas
- **Aplicación**: https://opensource-demo.orangehrmlive.com/
- **Usuario**: Admin
- **Contraseña**: admin123

## Comandos de Interés

### Ejecutar las pruebas:
```bash
./gradlew clean test
```

### Ver reporte de las pruebas (Windows):
```bash
start .\target\site\serenity\index.html
```

## Estructura del Proyecto
```
src/
├── main/java/co/com/udea/orangehrm/myinfo/
│   ├── interactions/       # Interacciones técnicas
│   ├── questions/          # Verificaciones y consultas
│   ├── tasks/             # Tareas de negocio
│   ├── userinterfaces/    # Page Objects
│   ├── utils/             # Utilidades y constantes
└── test/
    ├── java/              # Step definitions y runners
    └── resources/features/ # Archivos .feature en Gherkin
```

## Funcionalidades Automatizadas
- Actualización de información personal
- Validaciones de formularios
- Casos de error y excepciones

## Configuración IDE
- **JDK**: Java 21
- **Project language level**: 21
- **Gradle JVM**: Java 21