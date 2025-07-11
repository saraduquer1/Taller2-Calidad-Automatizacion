Feature: Gestión de información personal en My Info
  Como empleado del sistema
  Quiero acceder a mi información personal
  Para poder consultarla y actualizarla

  Background:
    Given el usuario se autentica en el sistema

  Scenario: Acceder exitosamente a la sección "My Info"
    When navega a la sección My Info
    Then puede ver la página de información personal