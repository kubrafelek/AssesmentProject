# Url Shortener Service

## Requirements β¨οΈ

    Assesment requires url shortening service.
    - User must be able to register or login to system.
    - User can list all url list.

## Tools & Technologies β

     - Spring Boot
     - Spring Data JPA / Hibernate
     - Maven
     - Lombok
     - Mapstruct
     - Swagger UI & Postman
     - JDK 1.8+   

## Model π
    - User can generate multiple url. (One to Many)

## Installation π§

- Firstly, clone repository

```
git clone https://github.com/kubrafelek/AssesmentProject.git 
```

- Install maven for running project

```
mvn clean install

cd project -> Swagger Doc.

cd project-thymeleaf -> UI 
```

## Quick Start π₯

```
Navigate Swagger UI url:  http://localhost:8080/swagger-ui.html

Basic Frontend Pages : http://localhost:8080/ 
```

## Swagger UI Tests π

#### -  Api Documentation
![](ss/a.png)

#### - User post a url and if process is success then, new short url return.
![](ss/b.png)
![](ss/c.png)

#### - To login the api system authorization token using.
![](ss/d.png)
![](ss/e.png)
![](ss/f.png)
![](ss/g.png)
![](ss/h.png)
![](ss/k.png)

#### - All url list.
![](ss/m.png)

#### - Duplicate url cannot be added.
![](ss/l.png)
![](ss/r.png)

#### - Generated short url redirect original url link.
![](ss/n.png)

#### - Delete url.
![](ss/o.png)
![](ss/p.png)


### Authors π

* *KΓΌbra Felek* - *Initial work* - [kubrafelek](https://github.com/kubrafelek)

* Happy coding! π

### License π

MIT License - see the [LICENSE](LICENSE) file for details