# Microservicios Clínica

Proyecto de arquitectura de microservicios para la gestión de clínica, desarrollado con Spring Boot y Spring Cloud.

## 🏗️ Arquitectura

Este proyecto utiliza una arquitectura de microservicios con los siguientes componentes:

- **Config Server**: Servidor de configuración centralizada
- **Eureka Server**: Servidor de registro y descubrimiento de servicios
- **API Gateway**: Puerta de enlace para enrutar solicitudes a los microservicios

## ⚙️ Orden de Ejecución

> **IMPORTANTE**: Los servicios deben iniciarse en el siguiente orden:

### 1️⃣ Config Server (Primero)
```bash
cd config-server
mvn spring-boot:run
```

Espera a que el Config Server esté completamente iniciado antes de continuar.

### 2️⃣ Eureka Server (Segundo)
```bash
cd eureka-server
mvn spring-boot:run
```

Espera a que Eureka esté completamente iniciado y disponible.

### 3️⃣ API Gateway (Tercero)
```bash
cd gateway
mvn spring-boot:run
```

### 4️⃣ Microservicios (Después)
Una vez que Config Server, Eureka y Gateway estén en ejecución, puedes iniciar los demás microservicios:

```bash
cd servicio-uno
mvn spring-boot:run
```

```bash
cd servicio-dos
mvn spring-boot:run
```

## 🛠️ Requisitos

- JDK 11 o superior
- Maven 3.6 o superior
- Git

## 📦 Tecnologías Utilizadas

- Spring Boot
- Spring Cloud
- Spring Cloud Config
- Eureka (Service Discovery)
- Spring Cloud Gateway
- Maven

## 🔍 Verificar Servicios

Puedes verificar que los servicios estén registrados en Eureka visitando:

```
http://localhost:8761
```

## 📝 Notas Importantes

- El **Config Server** debe estar en funcionamiento antes de iniciar cualquier otro servicio
- El **Eureka Server** debe estar disponible antes de iniciar el Gateway
- El **API Gateway** debe estar ejecutándose antes de realizar solicitudes a los microservicios
- Asegúrate de que los puertos no estén ocupados por otros procesos

## 🚀 Ejemplo de Solicitud

Una vez todo esté en funcionamiento, puedes hacer solicitudes a través del Gateway:

```bash
curl http://localhost:8080/api/endpoint
```

## 📄 Licencia

Este proyecto está bajo la licencia MIT.

## 👨‍💻 Autor

oliveriorojas
