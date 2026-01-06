# Clients Synchrones - Microservices Lab

Ce projet est une mise en œuvre pédagogique d'une architecture microservices démontrant la communication synchrone entre services à l'aide de Spring Cloud. Il met en évidence l'utilisation de différents clients HTTP (RestTemplate, Feign, WebClient) et de mécanismes de découverte de services (Eureka).

## 🏗 Architecture

Le système est composé de trois microservices principaux :

1.  **Discovery Service** (`discovery-service`): Serveur Eureka pour l'enregistrement et la découverte des services.
2.  **Car Service** (`car-service`): Microservice exposant une API de gestion de voitures. Il simule une latence pour tester les performances.
3.  **Client Service** (`client-service`): Microservice consommateur qui appelle le `car-service` via trois méthodes différentes.

## 🛠 Technologies Utilisées

*   **Java 17**
*   **Spring Boot 3.x**
*   **Spring Cloud** (Eureka, OpenFeign, LoadBalancer)
*   **Lombok**
*   **Maven**

## 🚀 Démarrage Rapide

### Ordre de démarrage
Il est important de démarrer les services dans cet ordre pour assurer un enregistrement correct :

1.  **Discovery Service**
2.  **Car Service**
3.  **Client Service**

### Commandes (Terminal)
À la racine de chaque projet, exécutez :
```bash
mvn spring-boot:run
```

Ou via votre IDE en lançant les classes principales :
*   `com.ghbou.swarch.discoveryservice.DiscoveryServiceApplication`
*   `com.ghbou.swarch.carservice.CarServiceApplication`
*   `com.ghbou.swarch.clientservice.ClientServiceApplication`

## 🔗 Endpoints & Test

Une fois tous les services démarrés, vous pouvez tester les endpoints suivants via Postman ou curl.

**Client ID de test : 1**

### 1. Via RestTemplate (Classique)
*   **URL** : `http://localhost:8088/api/clients/1/car/rest`
*   **Description** : Utilise `RestTemplate` avec `@LoadBalanced`.

### 2. Via OpenFeign (Déclaratif)
*   **URL** : `http://localhost:8088/api/clients/1/car/feign`
*   **Description** : Utilise une interface Java annotée `@FeignClient` (VehicleFeignClient). Plus lisible.

### 3. Via WebClient (Reactive/Moderne)
*   **URL** : `http://localhost:8088/api/clients/1/car/webclient`
*   **Description** : Utilise `WebClient`. Notez que pour ce lab, l'appel est bloquant (`.block()`) pour comparer les performances synchrones.

## 📊 Résultats Attendus (Performance)

Le `car-service` introduit une latence artificielle de 50ms.
*   **Feign** peut introduire une très légère latence supplémentaire due à l'abstraction.
*   **WebClient** est le plus performant sous forte charge en mode non-bloquant, mais ici (mode bloquant), il aura des performances similaires aux autres.

## 🛡 Résilience
En cas de panne du `car-service`, tous les appels échoueront immédiatement (500 Internal Server Error) car aucun mécanisme de "Circuit Breaker" n'est implémenté dans cette version de base, conformément au sujet du lab.
